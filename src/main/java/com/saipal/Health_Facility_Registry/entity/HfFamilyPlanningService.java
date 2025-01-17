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
@Table(name="hf_familyplanning")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HfFamilyPlanningService {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "hf_id")
	private int hf_id;
//	@Column(name="family_id")
	private int family_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "family_id",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Familyplanning familyplanning;
	
//	
//	public HfFamilyPlanningService(int id, int hf_id, int family_id) {
//		super();
//		this.id = id;
//		this.hf_id = hf_id;
//		this.family_id = family_id;
//	}
//	
//	public HfFamilyPlanningService() {
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
//	public int getFamily_id() {
//		return family_id;
//	}
//	public void setFamily_id(int family_id) {
//		this.family_id = family_id;
//	}
//	@Override
//	public String toString() {
//		return "HfFamilyPlanningService [id=" + id + ", hf_id=" + hf_id + ", family_id=" + family_id + "]";
//	}
//	
	
}
