package com.saipal.Health_Facility_Registry.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="free_treatment")
public class Bipanna {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "code")
	@NotBlank(message = "Code is mandatory")
	private String code;
	@Column(name = "name")
	@NotBlank(message = "Name is mandatory")
	private String name;
	@Column(name = "status")
	private int status;
	
	@OneToMany(targetEntity = HfBipannaService.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<HfBipannaService> hfBipannaService;
	
	
	
	public Bipanna(int id, @NotBlank(message = "Code is mandatory") String code,
			@NotBlank(message = "Name is mandatory") String name, int status) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.status = status;
	}
	
	
	public Bipanna() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bipanna [id=" + id + ", code=" + code + ", name=" + name + ", status=" + status + "]";
	}
	
	
	

}
