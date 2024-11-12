package com.crime.entity.users;

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
@Table(name = "tb_address")
@DynamicInsert
@DynamicUpdate
public class Address extends BaseEntity {

	private static final long serialVersionUID = -6011752823995449130L;

	@Column(name = "door_number")
	private String doorNumber;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "landmark")
	private String landmark;

}