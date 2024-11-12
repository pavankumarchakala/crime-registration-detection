package com.crime.entity.crimes;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.crime.entity.BaseEntity;

import jakarta.persistence.Column;
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
@Table(name = "tb_station_user")
@DynamicInsert
@DynamicUpdate
public class StationUser extends BaseEntity {

	private static final long serialVersionUID = 4469460740975033853L;

	@Column(name = "user_name", unique = true)
	public String userName;

	@Column(name = "password")
	public String password;

	@Column(name = "badge_id")
	public String badgeId;

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "phone")
	public String phone;

	@Column(name = "email")
	public String email;

	@ManyToOne
	@JoinColumn(name = "address_id")
	public Address address;

	@ManyToOne
	@JoinColumn(name = "department_id")
	public Department department;

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station station;

}
