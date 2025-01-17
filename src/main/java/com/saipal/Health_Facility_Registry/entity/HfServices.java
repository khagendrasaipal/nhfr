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
@Table(name="hf_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HfServices {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "hf_id")
	private int hf_id;
//	@Column(name="service_id")
	private int service_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Services services;
	

	
	
	
}
