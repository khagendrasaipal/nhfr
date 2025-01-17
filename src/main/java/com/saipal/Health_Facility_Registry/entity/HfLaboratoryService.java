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
@Table(name="hf_laboratory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HfLaboratoryService {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "hf_id")
	private int hf_id;
//	@Column(name="laboratory_id")
	private int laboratory_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "laboratory_id",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Laboratory laboratory;
	
	
//	public HfLaboratoryService(int id, int hf_id, int laboratory_id) {
//		super();
//		this.id = id;
//		this.hf_id = hf_id;
//		this.laboratory_id = laboratory_id;
//	}
//	
//	
//	public HfLaboratoryService() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
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
//	public int getLaboratory_id() {
//		return laboratory_id;
//	}
//	public void setLaboratory_id(int laboratory_id) {
//		this.laboratory_id = laboratory_id;
//	}
//	@Override
//	public String toString() {
//		return "HfLaboratoryService [id=" + id + ", hf_id=" + hf_id + ", laboratory_id=" + laboratory_id + "]";
//	}
//	
//	
	
}
