package com.crime.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.crime.constant.UploadedMediaFileConstants;
import com.crime.dao.crimes.IMediaFilesUploadRepository;
import com.crime.dto.SuccessResponse;
import com.crime.dto.UploadedMediaResponse;
import com.crime.entity.crimes.UploadMedia;
import com.crime.enums.EntityName;
import com.crime.enums.MediaFileType;
import com.crime.exceptions.ApplicationException;
import com.crime.util.MediaUploadUtils;
import com.crime.util.RandomUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MediaFilesUploadService implements IMediaFilesUploadService {

	private final IMediaFilesUploadRepository mediaFilesUploadRepository;

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> addMediaFiles(MultipartFile[] files, EntityName entity, long entityId)
			throws ApplicationException {
		String dirPath = MediaUploadUtils.constructDirectoryPath(entity.getDislayValue(), entityId);
		Arrays.asList(files).stream().forEach(file -> {

			try {
				addMediaFile(file, dirPath, entity, entityId, false);
			} catch (IOException e) {
			}

		});
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().message("File(s) uploaded successfully").status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}

	private void addMediaFile(MultipartFile file, String dirPath, EntityName entity, long entityId, boolean isThumbnail)
			throws IOException {
		String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
		String fileName = String.format("%s.%s", RandomUtils.getRandomString(), fileExtension);
		String location = new StringBuilder(dirPath).append(File.separator).append(fileName).toString();
		Path path = Paths.get(location);
		Files.write(path, file.getBytes());
		mediaFilesUploadRepository.save(UploadMedia.builder()
				.originalFileName(Paths.get(file.getOriginalFilename()).getFileName().toString())
				.savedFileName(fileName).entity(entity).filePath(location).isThumbnail(isThumbnail)
				.mediaFileType(MediaUploadUtils.findMediaFileType(fileExtension)).fileExtension(fileExtension).build());
	}

	@Override
	@Transactional
	public ResponseEntity<Map<String, List<UploadedMediaResponse>>> getMediaFileLinks(EntityName entityName,
			long entityId) {
		if (mediaFilesUploadRepository.countByEntityAndEntityId(entityName, entityId) == 0)
			throw new ApplicationException("There are no media files", HttpStatus.NO_CONTENT);
		List<UploadMedia> list = mediaFilesUploadRepository.findAllByEntityAndEntityId(entityName, entityId);
		Map<String, List<UploadedMediaResponse>> map = new HashMap<>();
		List<UploadedMediaResponse> imageLinks = new ArrayList<>();
		List<UploadedMediaResponse> videoLinks = new ArrayList<>();
		List<UploadedMediaResponse> otherFileLinks = new ArrayList<>();
		list.stream().forEach(item -> {
			String link = "/media/" + item.getId();
			if (MediaFileType.IMAGE.equals(item.getMediaFileType()))
				imageLinks.add(UploadedMediaResponse.builder().imageLink(link).uploadedRecordId(item.getId())
						.entity(entityName).entityId(entityId).build());
			else if (MediaFileType.VIDEO.equals(item.getMediaFileType()))
				videoLinks.add(UploadedMediaResponse.builder().imageLink(link).uploadedRecordId(item.getId())
						.entity(entityName).entityId(entityId).build());
			else
				otherFileLinks.add(UploadedMediaResponse.builder().imageLink(link).uploadedRecordId(item.getId())
						.entity(entityName).entityId(entityId).build());
		});
		map.put(MediaFileType.IMAGE.getDislayValue(), imageLinks);
		map.put(MediaFileType.VIDEO.getDislayValue(), videoLinks);
		map.put(MediaFileType.OTHERS.getDislayValue(), otherFileLinks);
		return new ResponseEntity<Map<String, List<UploadedMediaResponse>>>(map, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<byte[]> getMediaThumbnail(long entityId) {
		UploadMedia uploadMedia = mediaFilesUploadRepository.findByEntityIdAndMediaFileTypeAndIsThumbnail(entityId,
				MediaFileType.IMAGE, true);

		if (null == uploadMedia) {
			throw new ApplicationException("There are no thumbnails. Please add or select from existing images.",
					HttpStatus.NO_CONTENT);
		}

		byte[] thumbnail = null;

		try {
			thumbnail = getFile(uploadMedia.getFilePath());
		} catch (IOException e) {
		}

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add(UploadedMediaFileConstants.CONTENT_DISPOSITION, "attachment;");
		return new ResponseEntity<byte[]>(thumbnail, map, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<byte[]> getMediaById(long id) {
		Optional<UploadMedia> optionalUploadMedia = mediaFilesUploadRepository.findById(id);
		if (!optionalUploadMedia.isPresent())
			throw new ApplicationException("No record found with the provided ID", HttpStatus.NOT_FOUND);
		byte[] media = null;

		try {
			media = getFile(optionalUploadMedia.get().getFilePath());
		} catch (IOException e) {
			throw new ApplicationException(e.getMessage(), e);
		}

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add(UploadedMediaFileConstants.CONTENT_DISPOSITION, "attachment;");
		return new ResponseEntity<byte[]>(media, map, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> updateMediaThumbnail(long id) {
		Optional<UploadMedia> optionalUploadMedia = mediaFilesUploadRepository.findById(id);
		if (!optionalUploadMedia.isPresent())
			throw new ApplicationException("No record found with the provided ID", HttpStatus.NOT_FOUND);
		UploadMedia uploadMedia = optionalUploadMedia.get();
		uploadMedia.setThumbnail(true);
//		deselectThumbnailSelection(uploadMedia.getEntityId(), id);
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().message("Thumbnail updated successfully").status(HttpStatus.OK).build(),
				HttpStatus.OK);
	}

	private void deselectThumbnailSelection(long entityId, long uploadMediaId) {
		mediaFilesUploadRepository.findAllByEntityIdAndMediaFileType(entityId, MediaFileType.IMAGE).stream()
				.forEach(item -> {
					if (0 == uploadMediaId || item.getId() != uploadMediaId)
						item.setThumbnail(false);
				});
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> addMediaThumbnail(MultipartFile file, EntityName entity, long entityId) {

		try {
			deselectThumbnailSelection(entityId, 0);
			String dirPath = MediaUploadUtils.constructDirectoryPath(entity.getDislayValue(), entityId);
			addMediaFile(file, dirPath, entity, entityId, true);
		} catch (IOException e) {
			throw new ApplicationException(e.getMessage(), e);
		}

		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().message("Thumbnail uploaded successfully").status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}

	private byte[] getFile(String path) throws IOException {
		File file = new File(path);
		byte[] b = null;

		if (file.exists()) {
			b = FileUtils.readFileToByteArray(file);
		}

		return b;
	}

}
