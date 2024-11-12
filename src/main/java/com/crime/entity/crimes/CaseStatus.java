package com.crime.entity.crimes;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.crime.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
@Table(name = "tb_case_status")
@DynamicInsert
@DynamicUpdate
public class CaseStatus extends BaseEntity {

	private static final long serialVersionUID = -5248215587648105277L;

	@Column(name = "name")
	private String name;

	@Column(name = "display_name")
	private String displayName;

}
