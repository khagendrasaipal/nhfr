package com.saipal.Health_Facility_Registry.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "health_facility_type")
public class HealthFacilityType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "code")
	@NotBlank(message = "Code is mandatory")
	private String code;
	@Column(name = "type_name")
	private String type_name;
	@Column(name = "status")
	private int status;
	
	@OneToMany(targetEntity = HealthFacility.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<HealthFacility> healthFacility;

	public HealthFacilityType(int id, String code, String type_name, int status) {
		super();
		this.id = id;
		this.code = code;
		this.type_name = type_name;
		this.status = status;
//		this.created_at = created_at;
//		this.expired_date = expired_date;
	}
	public HealthFacilityType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
//	public Date getCreated_at() {
//		return created_at;
//	}
//	public void setCreated_at(Date created_at) {
//		this.created_at = created_at;
//	}
//	public Date getExpired_date() {
//		return expired_date;
//	}
//	public void setExpired_date(Date expired_date) {
//		this.expired_date = expired_date;
//	}
	@Override
	public String toString() {
		return "HealthFacilityType [id=" + id + ", code=" + code + ", type_name=" + type_name + ", status=" + status
				+ "]";
	}


	
	
}
