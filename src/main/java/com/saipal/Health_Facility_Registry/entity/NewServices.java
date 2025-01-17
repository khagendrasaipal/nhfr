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
@Table(name="new_services")

public class NewServices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "parent")
	private int parent;
	
	@Column(name = "code")
	@NotBlank(message = "Code is mandatory")
	private String code;
	@Column(name = "name")
	@NotBlank(message = "Name is mandatory")
	private String name;
	@Column(name = "status")
	private int status;
	
	@Column(name = "orders")
	private int orders;
	
	@Column(name = "namenp")
	private String namenp;
	
	@OneToMany(targetEntity = NewHfServices.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<NewHfServices> nhfServices;
	
	
	
	public NewServices(int id, @NotBlank(message = "Code is mandatory") String code,
			@NotBlank(message = "Name is mandatory") String name, int status,int parent,int orders,String namenp) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.status = status;
		this.parent=parent;
		this.orders=orders;
		this.namenp=namenp;
		}
	
	

	public String getNamenp() {
		return namenp;
	}



	public void setNamenp(String namenp) {
		this.namenp = namenp;
	}



	public NewServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}
	
	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
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
		return "NewServices [id=" + id + ", parent=" + parent + ", code=" + code + ", name=" + name + ", status="
				+ status + ", orders=" + orders + ", namenp=" + namenp + "]";
	}
	
	
}
