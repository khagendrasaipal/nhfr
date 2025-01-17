package com.saipal.Health_Facility_Registry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="apiusers")
public class ApiSignUpUsersEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "fullname")
	@NotBlank(message = "fullname is mandatory")
	private String fullname;
	@Column(name = "email")
	@NotBlank(message = "email is mandatory")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "designation")
	@NotBlank(message = "designation is mandatory")
	private String designation;
	@Column(name = "phone")
	@NotBlank(message = "phone is mandatory")
	private String phone;
	@Column(name = "username")
	@NotBlank(message = "username is mandatory")
	private String username;
	@Column(name = "password")
	@NotBlank(message = "password is mandatory")
	private String password;
	@Column(name = "token")
	@NotBlank(message = "token is mandatory")
	private String token;
	
	@Column(name="status")
	private int status;
	
	public ApiSignUpUsersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public ApiSignUpUsersEntity(int id, @NotBlank(message = "fullname is mandatory") String fullname,
			@NotBlank(message = "email is mandatory") String email, String address,
			@NotBlank(message = "designation is mandatory") String designation,
			@NotBlank(message = "phone is mandatory") String phone,
			@NotBlank(message = "username is mandatory") String username,
			@NotBlank(message = "password is mandatory") String password,
			@NotBlank(message = "token is mandatory") String token, int status) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.designation = designation;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.token = token;
		this.status = status;
	}




	public int getId() {
		return id;
	}
	public String getFullname() {
		return fullname;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public String getDesignation() {
		return designation;
	}
	public String getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getToken() {
		return token;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}




	@Override
	public String toString() {
		return "ApiSignUpUsersEntity [id=" + id + ", fullname=" + fullname + ", email=" + email + ", address=" + address
				+ ", designation=" + designation + ", phone=" + phone + ", username=" + username + ", password="
				+ password + ", token=" + token + ", status=" + status + "]";
	}
	
	
	
}
