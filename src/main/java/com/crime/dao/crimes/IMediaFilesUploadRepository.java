package com.crime.dao.crimes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crime.entity.crimes.UploadMedia;
import com.crime.enums.EntityName;
import com.crime.enums.MediaFileType;

@Repository
public interface IMediaFilesUploadRepository extends JpaRepository<UploadMedia, Long> {

	List<UploadMedia> findAllByEntityId(long entityId);

	List<UploadMedia> findAllByEntityAndEntityId(EntityName entityName, long entityId);

	UploadMedia findByEntityIdAndMediaFileTypeAndIsThumbnail(long entityId, MediaFileType mediaFileType,
			boolean isThumbnail);

	List<UploadMedia> findAllByEntityIdAndMediaFileType(long entityId, MediaFileType mediaFileType);

	long countByEntityIdAndMediaFileType(long entityId, MediaFileType mediaFileType);

	long countByEntityId(long entityId);

	long countByEntityAndEntityId(EntityName entityName, long entityId);

}
