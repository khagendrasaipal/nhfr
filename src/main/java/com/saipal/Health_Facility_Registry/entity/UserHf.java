package com.saipal.Health_Facility_Registry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_hf_access")
public class UserHf {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="userid")
	private int userid;
	@Column(name="hfid")
	private int hfid;
	
	
	public UserHf(int id, int userid, int hfid) {
		super();
		this.id = id;
		this.userid = userid;
		this.hfid = hfid;
	}
	
	
	public UserHf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getHfid() {
		return hfid;
	}
	public void setHfid(int hfid) {
		this.hfid = hfid;
	}
	@Override
	public String toString() {
		return "UserHf [id=" + id + ", userid=" + userid + ", hfid=" + hfid + "]";
	}
	
	
	
	
}
