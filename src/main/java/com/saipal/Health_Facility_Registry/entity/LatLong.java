package com.saipal.Health_Facility_Registry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="latlong")
public class LatLong {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "lat")
	@NotBlank(message = "lat is mandatory")
	private String lat;
	@Column(name = "longs")
	@NotBlank(message = "longs is mandatory")
	private String longs;
	@Column(name = "hfname")
	private String hfname;
	@Column(name = "district")
	private String district;
	
	public LatLong(int id, @NotBlank(message = "lat is mandatory") String lat,
			@NotBlank(message = "longs is mandatory") String longs, String hfname, String district) {
		super();
		this.id = id;
		this.lat = lat;
		this.longs = longs;
		this.hfname = hfname;
		this.district = district;
	}
	public LatLong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLongs() {
		return longs;
	}
	public void setLongs(String longs) {
		this.longs = longs;
	}
	public String getHfname() {
		return hfname;
	}
	public void setHfname(String hfname) {
		this.hfname = hfname;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Override
	public String toString() {
		return "LatLong [id=" + id + ", lat=" + lat + ", longs=" + longs + ", hfname=" + hfname + ", district="
				+ district + "]";
	}
	
	
}
