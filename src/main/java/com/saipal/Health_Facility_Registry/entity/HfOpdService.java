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
@Table(name="hf_opd")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HfOpdService {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "hf_id")
	private int hf_id;
//	@Column(name="opd_id")
	private int opd_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opd_id",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Opd opd;
	
//	
//	public HfOpdService(int id, int hf_id, int opd_id) {
//		super();
//		this.id = id;
//		this.hf_id = hf_id;
//		this.opd_id = opd_id;
//	}
//	
//	public HfOpdService() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public int getHf_id() {
//		return hf_id;
//	}
//	public void setHf_id(int hf_id) {
//		this.hf_id = hf_id;
//	}
//	public int getOpd_id() {
//		return opd_id;
//	}
//	public void setOpd_id(int opd_id) {
//		this.opd_id = opd_id;
//	}
//	@Override
//	public String toString() {
//		return "HfOpdService [id=" + id + ", hf_id=" + hf_id + ", opd_id=" + opd_id + "]";
//	}
//	
	
}
