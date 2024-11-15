package com.crime.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 5952868229579386586L;

	@Id
	@GenericGenerator(name = "id_generator", strategy = "com.crime.config.CustomIdGenerator")
	@GeneratedValue(generator = "id_generator", strategy = GenerationType.IDENTITY)
	private long id;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false, columnDefinition = "TIMESTAMP")
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date", insertable = false, columnDefinition = "TIMESTAMP")
	private LocalDateTime updatedDate;

}
