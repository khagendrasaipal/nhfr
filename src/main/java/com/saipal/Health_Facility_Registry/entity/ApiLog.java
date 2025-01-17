package com.saipal.Health_Facility_Registry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="apilog")
public class ApiLog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="userid")
	private int userid;
	@Column(name="action")
	private String action;
	@Column(name="url")
	private String url;
	@Column(name="caseid")
	private int caseid;
	
//	@Column(name="created_at")
//	private Timestamp created_at;
	
	
	
	public ApiLog(int id, int userid, String action, String url, int caseid) {
		super();
		this.id = id;
		this.userid = userid;
		this.action = action;
		this.url = url;
		this.caseid = caseid;
	}
	
	
	public ApiLog() {
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCaseid() {
		return caseid;
	}
	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}
	@Override
	public String toString() {
		return "ApiLog [id=" + id + ", userid=" + userid + ", action=" + action + ", url=" + url + ", caseid=" + caseid
				+ "]";
	}
	
	
	
}
