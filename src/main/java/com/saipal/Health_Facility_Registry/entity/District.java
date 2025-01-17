package com.saipal.Health_Facility_Registry.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="admin_district")
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="districtid")
	private int districtid;
	@Column(name = "provinceid")
	private int provinceid;
	@Column(name = "nameen")
	@NotBlank(message = "Name is mandatory")
	private String nameen;


	public District(int districtid, int provinceid, @NotBlank(message = "Name is mandatory") String nameen) {
		super();
		this.districtid = districtid;
		this.provinceid = provinceid;
		this.nameen = nameen;
	}
	
	
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getDistrictid() {
		return districtid;
	}
	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	public String getNameen() {
		return nameen;
	}
	public void setNameen(String nameen) {
		this.nameen = nameen;
	}
	@Override
	public String toString() {
		return "District [districtid=" + districtid + ", provinceid=" + provinceid + ", nameen=" + nameen + "]";
	}
	
	
}
