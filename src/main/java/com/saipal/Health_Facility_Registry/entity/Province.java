package com.saipal.Health_Facility_Registry.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="admin_province")
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid")
	private int pid;
	@Column(name = "nameen")
	@NotBlank(message = "Name is mandatory")
	private String nameen;



	public Province(int pid, @NotBlank(message = "Name is mandatory") String nameen) {
		super();
		this.pid = pid;
		this.nameen = nameen;
	}
	
	
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getNameen() {
		return nameen;
	}
	public void setNameen(String nameen) {
		this.nameen = nameen;
	}
	@Override
	public String toString() {
		return "Province [pid=" + pid + ", nameen=" + nameen + "]";
	}
	
	
	
}
