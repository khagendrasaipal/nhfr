package com.saipal.Health_Facility_Registry.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	@NotBlank(message = "username is mandatory")
	private String username;
	@Column(name = "password")
	@NotBlank(message = "password is mandatory")
	private String password;
	@Column(name = "surname")
	private String surname;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "email")
	private String email;
	@Column(name = "orgid")
	private String orgid;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "role")
	private String role;
	@Column(name = "province")
	private Integer province;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "province",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Province provinces;

	@Column(name = "district")
	private Integer district;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private District districts;

	public Province getProvinces() {
		return provinces;
	}

	public void setProvinces(Province provinces) {
		this.provinces = provinces;
	}

	public District getDistricts() {
		return districts;
	}

	public void setDistricts(District districts) {
		this.districts = districts;
	}

	public Municipality getMunicipalitys() {
		return municipalitys;
	}

	public void setMunicipalitys(Municipality municipalitys) {
		this.municipalitys = municipalitys;
	}

	@Column(name = "municipality")
	private String municipality;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "municipality",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Municipality municipalitys;


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, @NotBlank(message = "username is mandatory") String username,
			@NotBlank(message = "password is mandatory") String password, String surname, String firstname,
			String email, String mobile, String role, int province, int district, String municipality,String orgid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.surname = surname;
		this.firstname = firstname;
		this.email = email;
		this.mobile = mobile;
		this.role = role;
		this.province = province;
		this.district = district;
		this.municipality = municipality;
		this.orgid=orgid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getDistrict() {
		return district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", surname=" + surname
				+ ", firstname=" + firstname + ", email=" + email + ", mobile=" + mobile + ", role=" + role
				+ ", province=" + province + ", district=" + district + ", orgid=" + orgid + ", municipality=" + municipality + "]";
	}
	
	

//	@Override
//	public String toString() {
//		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", surname=" + surname
//				+ ", firstname=" + firstname + ", email=" + email + ", mobile=" + mobile + ", role=" + role
//				+ ", province=" + province + ", district=" + district + ", municipality=" + municipality + "]";
//	}

}
