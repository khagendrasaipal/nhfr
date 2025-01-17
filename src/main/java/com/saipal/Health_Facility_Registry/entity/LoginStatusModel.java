package com.saipal.Health_Facility_Registry.entity;

public class LoginStatusModel {

	Integer id;
	String username;
	String role;
	Integer province;
	Integer district;
	String municipality;
	String orgid;
	private  String token;
	public LoginStatusModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public LoginStatusModel(Integer id, String username, String role, Integer province, Integer district,
			String municipality, String token,String orgid) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
		this.province = province;
		this.district = district;
		this.municipality = municipality;
		this.token = token;
		this.orgid=orgid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public Integer getProvince() {
		return province;
	}

	public Integer getDistrict() {
		return district;
	}

	public String getMunicipality() {
		return municipality;
	}
	
	public String getOrgid() {
		return orgid;
	}

	public String getToken() {
		return token;
	}

	
	


	
	
}
