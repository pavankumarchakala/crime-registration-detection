package com.crime.dto;

import java.io.Serializable;

import com.crime.enums.EntityName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class UploadedMediaResponse implements Serializable {

	private static final long serialVersionUID = -253974814188171753L;

	private long uploadedRecordId;

	private String imageLink;

	private long entityId;

	private EntityName entity;

}
