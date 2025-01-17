package com.saipal.Health_Facility_Registry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="api_exchange")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class ApiExchange {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
//	@Column(name = "hfid")
	private int hfid;
	@Column(name = "action")
	private String action;
	
//	@Column(name="opd_id")
//	private int opd_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hfid",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private HealthFacility hf;
	
	
	

	public ApiExchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiExchange(int id, int hfid, String action, HealthFacility hf) {
		super();
		this.id = id;
		this.hfid = hfid;
		this.action = action;
		this.hf = hf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHfid() {
		return hfid;
	}

	public void setHfid(int hfid) {
		this.hfid = hfid;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public HealthFacility getHf() {
		return hf;
	}

	public void setHf(HealthFacility hf) {
		this.hf = hf;
	}

	@Override
	public String toString() {
		return "ApiExchange [id=" + id + ", hfid=" + hfid + ", action=" + action + ", hf=" + hf + "]";
	}
	
	
}
