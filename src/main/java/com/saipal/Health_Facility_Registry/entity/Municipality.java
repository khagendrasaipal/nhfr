package com.saipal.Health_Facility_Registry.entity;

import javax.persistence.*;


@Entity
@Table(name="admin_local_level_structure")
public class Municipality {

	@Id
	@Column(name="vcid")
	private String vcid;
	
	@Column(name = "nameen")
	private String nameen;
	@Column(name="districtid")
	private int districtid;
	@Column(name = "provinceid")
	private int provinceid;
	@Column(name = "numberofward")
	private int numberofward;
	@Column(name = "district")
	private String district;





	
	
	public Municipality(String vcid, String nameen, int districtid, int provinceid, int numberofward, String district) {
		super();
		this.vcid = vcid;
		this.nameen = nameen;
		this.districtid = districtid;
		this.provinceid = provinceid;
		this.numberofward = numberofward;
		this.district = district;
	}

	public Municipality() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getVcid() {
		return vcid;
	}
	public void setVcid(String vcid) {
		this.vcid = vcid;
	}
	public String getNameen() {
		return nameen;
	}
	public void setNameen(String nameen) {
		this.nameen = nameen;
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
	public int getNumberofward() {
		return numberofward;
	}
	public void setNumberofward(int numberofward) {
		this.numberofward = numberofward;
	}
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "Municipality [vcid=" + vcid + ", nameen=" + nameen + ", districtid=" + districtid + ", provinceid="
				+ provinceid + ", numberofward=" + numberofward + ", district=" + district + "]";
	}

	
	
	
}
