package com.saipal.Health_Facility_Registry.entity;

public class ApiLoginResponse {
	int id;
	String token;
	String username;
	String fullname;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public ApiLoginResponse(int id, String token,String fullname,String username) {
		super();
		this.id = id;
		this.token = token;
		this.username=username;
		this.fullname=fullname;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "ApiLoginResponse [id=" + id + ", token=" + token + "]";
	}
	
	

}
