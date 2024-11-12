package com.crime.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.crime.dto.SuccessResponse;
import com.crime.dto.UploadedMediaResponse;
import com.crime.enums.EntityName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface IMediaFilesUploadService {

	ResponseEntity<SuccessResponse> addMediaFiles(@Valid @NotNull @NotEmpty MultipartFile[] files, EntityName entity,
			long entityId);

	ResponseEntity<Map<String, List<UploadedMediaResponse>>> getMediaFileLinks(EntityName entityName, long userId);

	ResponseEntity<byte[]> getMediaThumbnail(long entityId);

	ResponseEntity<byte[]> getMediaById(long id);

	ResponseEntity<SuccessResponse> updateMediaThumbnail(long id);

	ResponseEntity<SuccessResponse> addMediaThumbnail(@Valid @NotNull @NotEmpty MultipartFile file, EntityName valueOf,
			long entityId);

}
