package com.crime.entity.crimes;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.crime.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_department")
@DynamicInsert
@DynamicUpdate
public class Department extends BaseEntity {

	private static final long serialVersionUID = 3269686646246044312L;

	public String name;

	public String code;

	public String phone;

	public String email;

	@ManyToOne
	@JoinColumn(name = "address_id")
	public Address address;
}
