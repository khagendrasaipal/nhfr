package com.saipal.Health_Facility_Registry.entity;

public class Login {
String email,password;

public Login(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}

public Login() {
	super();
	// TODO Auto-generated constructor stub
}

public String getemail() {
	return email;
}

public void setemail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}
