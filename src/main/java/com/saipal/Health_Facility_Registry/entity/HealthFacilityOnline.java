package com.saipal.Health_Facility_Registry.entity;

import java.math.BigInteger;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "hfregistry")

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HealthFacilityOnline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "hf_code")
	private BigInteger hf_code;
	@Column(name = "hf_name")
	@NotBlank(message = "Name is mandatory")
	private String hf_name;
//	@Column(name = "type")
	private Integer type;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private HealthFacilityType healthFacilityType;
	
	@JsonInclude()
	@Transient
	private String[] services;
	@JsonInclude()
	@Transient
	private String[] opdServices;
	@JsonInclude()
	@Transient
	private String[] surgicalServices;
	@JsonInclude()
	@Transient
	private String[] radiologyServices;
	@JsonInclude()
	@Transient
	private String[] laboratoryServices;
	@JsonInclude()
	@Transient
	private String[] specializedServices;
	@JsonInclude()
	@Transient
	private String[] ayurvedServices;
	@JsonInclude()
	@Transient
	private String[] familyPlanningServices;
	@JsonInclude()
	@Transient
	private String[] safeMotherhoodServices;
	@JsonInclude()
	@Transient
	private String[] bipannaServices;
	@JsonInclude()
	@Transient
	private String token;
	
	
	@Column(name = "authlevel")
	private String authlevel;
	
	@Column(name = "c_hf_name")
	private String c_hf_name;
	
	@Column(name = "health_services")
	private String health_services;
	
	@Column(name = "oxygen")
	private String oxygen;
	
	@Column(name = "plant_capacity")
	private String plant_capacity;
	
	@Column(name = "cylinder")
	private String cylinder;
	
	@Column(name = "concentrator")
	private String concentrator;
	
	@Column(name = "ambulance")
	private String ambulance;
	
	@Column(name = "ambulance_category")
	private String ambulance_category;
	
	@Column(name = "ambulance_contact")
	private String ambulance_contact;
	
	@Column(name = "ocmc")
	private String ocmc;
	
	@Column(name = "ssu")
	private String ssu;
	
	@Column(name = "geriatrics")
	private String geriatrics;
	
	@Column(name = "ehs")
	private String ehs;
	
	@Column(name = "pharmacy")
	private String pharmacy;
	
	@Column(name = "insurance")
	private String insurance;
	
	@Column(name = "contact_person")
	private String contact_person;
	
	@Column(name = "contact_person_mobile")
	private String contact_person_mobile;
	
//	@Column(name = "level")
	private Integer level;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "level", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private HealthFacilityLevel healthFacilityLevel;
	
//	@Column(name = "ownership")
	private Integer ownership;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ownership",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Ownership ownerships;
	
	@Column(name = "sectioned")
	private Integer sectioned;
	@Column(name = "functional")
	private Integer functional;
	
	@Column(name = "icu_sectioned")
	private Integer icu_sectioned;
	@Column(name = "icu_functional")
	private Integer icu_functional;
	
	@Column(name = "ventilator_sectioned")
	private Integer ventilator_sectioned;
	@Column(name = "ventilator_functional")
	private Integer ventilator_functional;
	
	@Column(name = "hdu_sectioned")
	private Integer hdu_sectioned;
	@Column(name = "hdu_functional")
	private Integer hdu_functional;
	
	@Column(name = "nicu_sectioned")
	private Integer nicu_sectioned;
	@Column(name = "nicu_functional")
	private Integer nicu_functional;
	
	
	
	
	@Column(name = "internet")
	private String internet;
	
	@Column(name = "hmis_code")
	private String hmis_code;
	
//	@Column(name = "province")
	private Integer province;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "province",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Province provinces;
	
//	@Column(name = "district")
	private Integer district;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private District districts;  
	
	@Column(name = "municipality")
	private String municipality;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "municipality",insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Municipality municipalitys;
	
	@Column(name = "ward")
	private Integer ward;
	@Column(name = "opstatus")
	private String opstatus;
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "longitude")
	private String longitude;
	@Column(name = "estd_date")
	private String estd_date;
	@Column(name = "email")
	private String email;
	@Column(name = "website")
	private String website;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "ren_date")
	private String ren_date;
	@Column(name = "ftype")
	private Integer ftype;
	@Column(name = "validity")
	private String validity;
	@Column(name = "ucode")
	private Integer ucode;
	@Column(name = "cbscode")
	private Integer cbscode;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the hf_code
	 */
	public BigInteger getHf_code() {
		return hf_code;
	}
	/**
	 * @return the hf_name
	 */
	public String getHf_name() {
		return hf_name;
	}
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @return the healthFacilityType
	 */
	public HealthFacilityType getHealthFacilityType() {
		return healthFacilityType;
	}
	/**
	 * @return the authlevel
	 */
	public String getAuthlevel() {
		return authlevel;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @return the healthFacilityLevel
	 */
	public HealthFacilityLevel getHealthFacilityLevel() {
		return healthFacilityLevel;
	}
	/**
	 * @return the ownership
	 */
	public Integer getOwnership() {
		return ownership;
	}
	/**
	 * @return the ownerships
	 */
	public Ownership getOwnerships() {
		return ownerships;
	}
	/**
	 * @return the sectioned
	 */
	public Integer getSectioned() {
		return sectioned;
	}
	/**
	 * @return the functional
	 */
	public Integer getFunctional() {
		return functional;
	}
	/**
	 * @return the internet
	 */
	public String getInternet() {
		return internet;
	}
	/**
	 * @return the province
	 */
	public Integer getProvince() {
		return province;
	}
	/**
	 * @return the provinces
	 */
	public Province getProvinces() {
		return provinces;
	}
	/**
	 * @return the district
	 */
	public Integer getDistrict() {
		return district;
	}
	/**
	 * @return the districts
	 */
	public District getDistricts() {
		return districts;
	}
	/**
	 * @return the municipality
	 */
	public String getMunicipality() {
		return municipality;
	}
	/**
	 * @return the municipalitys
	 */
	public Municipality getMunicipalitys() {
		return municipalitys;
	}
	/**
	 * @return the ward
	 */
	public Integer getWard() {
		return ward;
	}
	/**
	 * @return the opstatus
	 */
	public String getOpstatus() {
		return opstatus;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @return the estd_date
	 */
	public String getEstd_date() {
		return estd_date;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @return the ren_date
	 */
	public String getRen_date() {
		return ren_date;
	}
	/**
	 * @return the ftype
	 */
	public Integer getFtype() {
		return ftype;
	}
	/**
	 * @return the validity
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * @return the ucode
	 */
	public Integer getUcode() {
		return ucode;
	}
	/**
	 * @return the cbscode
	 */
	public Integer getCbscode() {
		return cbscode;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param hf_code the hf_code to set
	 */
	public void setHf_code(BigInteger hf_code) {
		this.hf_code = hf_code;
	}
	/**
	 * @param hf_name the hf_name to set
	 */
	public void setHf_name(String hf_name) {
		this.hf_name = hf_name;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @param healthFacilityType the healthFacilityType to set
	 */
	public void setHealthFacilityType(HealthFacilityType healthFacilityType) {
		this.healthFacilityType = healthFacilityType;
	}
	/**
	 * @param authlevel the authlevel to set
	 */
	public void setAuthlevel(String authlevel) {
		this.authlevel = authlevel;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @param healthFacilityLevel the healthFacilityLevel to set
	 */
	public void setHealthFacilityLevel(HealthFacilityLevel healthFacilityLevel) {
		this.healthFacilityLevel = healthFacilityLevel;
	}
	/**
	 * @param ownership the ownership to set
	 */
	public void setOwnership(Integer ownership) {
		this.ownership = ownership;
	}
	/**
	 * @param ownerships the ownerships to set
	 */
	public void setOwnerships(Ownership ownerships) {
		this.ownerships = ownerships;
	}
	/**
	 * @param sectioned the sectioned to set
	 */
	public void setSectioned(Integer sectioned) {
		this.sectioned = sectioned;
	}
	/**
	 * @param functional the functional to set
	 */
	public void setFunctional(Integer functional) {
		this.functional = functional;
	}
	/**
	 * @param internet the internet to set
	 */
	public void setInternet(String internet) {
		this.internet = internet;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(Integer province) {
		this.province = province;
	}
	/**
	 * @param provinces the provinces to set
	 */
	public void setProvinces(Province provinces) {
		this.provinces = provinces;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(Integer district) {
		this.district = district;
	}
	/**
	 * @param districts the districts to set
	 */
	public void setDistricts(District districts) {
		this.districts = districts;
	}
	/**
	 * @param municipality the municipality to set
	 */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	/**
	 * @param municipalitys the municipalitys to set
	 */
	public void setMunicipalitys(Municipality municipalitys) {
		this.municipalitys = municipalitys;
	}
	/**
	 * @param ward the ward to set
	 */
	public void setWard(Integer ward) {
		this.ward = ward;
	}
	/**
	 * @param opstatus the opstatus to set
	 */
	public void setOpstatus(String opstatus) {
		this.opstatus = opstatus;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @param estd_date the estd_date to set
	 */
	public void setEstd_date(String estd_date) {
		this.estd_date = estd_date;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @param ren_date the ren_date to set
	 */
	public void setRen_date(String ren_date) {
		this.ren_date = ren_date;
	}
	/**
	 * @param ftype the ftype to set
	 */
	public void setFtype(Integer ftype) {
		this.ftype = ftype;
	}
	/**
	 * @param validity the validity to set
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}
	/**
	 * @param ucode the ucode to set
	 */
	public void setUcode(Integer ucode) {
		this.ucode = ucode;
	}
	/**
	 * @param cbscode the cbscode to set
	 */
	public void setCbscode(Integer cbscode) {
		this.cbscode = cbscode;
	}
	public String[] getServices() {
		return services;
	}
	public void setServices(String[] services) {
		this.services = services;
	}
	public String[] getOpdServices() {
		return opdServices;
	}
	public void setOpdServices(String[] opdServices) {
		this.opdServices = opdServices;
	}
	public String[] getSurgicalServices() {
		return surgicalServices;
	}
	public void setSurgicalServices(String[] surgicalServices) {
		this.surgicalServices = surgicalServices;
	}
	public String[] getRadiologyServices() {
		return radiologyServices;
	}
	public void setRadiologyServices(String[] radiologyServices) {
		this.radiologyServices = radiologyServices;
	}
	public String[] getLaboratoryServices() {
		return laboratoryServices;
	}
	public void setLaboratoryServices(String[] laboratoryServices) {
		this.laboratoryServices = laboratoryServices;
	}
	public String[] getSpecializedServices() {
		return specializedServices;
	}
	public void setSpecializedServices(String[] specializedServices) {
		this.specializedServices = specializedServices;
	}
	public String[] getAyurvedServices() {
		return ayurvedServices;
	}
	public void setAyurvedServices(String[] ayurvedServices) {
		this.ayurvedServices = ayurvedServices;
	}
	public String[] getFamilyPlanningServices() {
		return familyPlanningServices;
	}
	public void setFamilyPlanningServices(String[] familyPlanningServices) {
		this.familyPlanningServices = familyPlanningServices;
	}
	public String[] getSafeMotherhoodServices() {
		return safeMotherhoodServices;
	}
	public void setSafeMotherhoodServices(String[] safeMotherhoodServices) {
		this.safeMotherhoodServices = safeMotherhoodServices;
	}
	public String[] getBipannaServices() {
		return bipannaServices;
	}
	public void setBipannaServices(String[] bipannaServices) {
		this.bipannaServices = bipannaServices;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getIcu_sectioned() {
		return icu_sectioned;
	}
	public void setIcu_sectioned(Integer icu_sectioned) {
		this.icu_sectioned = icu_sectioned;
	}
	public Integer getIcu_functional() {
		return icu_functional;
	}
	public void setIcu_functional(Integer icu_functional) {
		this.icu_functional = icu_functional;
	}
	public Integer getVentilator_sectioned() {
		return ventilator_sectioned;
	}
	public void setVentilator_sectioned(Integer ventilator_sectioned) {
		this.ventilator_sectioned = ventilator_sectioned;
	}
	public Integer getVentilator_functional() {
		return ventilator_functional;
	}
	public void setVentilator_functional(Integer ventilator_functional) {
		this.ventilator_functional = ventilator_functional;
	}
	public String getHmis_code() {
		return hmis_code;
	}
	public void setHmis_code(String hmis_code) {
		this.hmis_code = hmis_code;
	}
	public String getC_hf_name() {
		return c_hf_name;
	}
	public void setC_hf_name(String c_hf_name) {
		this.c_hf_name = c_hf_name;
	}
	public String getHealth_services() {
		return health_services;
	}
	public void setHealth_services(String health_services) {
		this.health_services = health_services;
	}
	public String getOxygen() {
		return oxygen;
	}
	public void setOxygen(String oxygen) {
		this.oxygen = oxygen;
	}
	public String getPlant_capacity() {
		return plant_capacity;
	}
	public void setPlant_capacity(String plant_capacity) {
		this.plant_capacity = plant_capacity;
	}
	public String getCylinder() {
		return cylinder;
	}
	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}
	public String getConcentrator() {
		return concentrator;
	}
	public void setConcentrator(String concentrator) {
		this.concentrator = concentrator;
	}
	public String getAmbulance() {
		return ambulance;
	}
	public void setAmbulance(String ambulance) {
		this.ambulance = ambulance;
	}
	public String getOcmc() {
		return ocmc;
	}
	public void setOcmc(String ocmc) {
		this.ocmc = ocmc;
	}
	public String getSsu() {
		return ssu;
	}
	public void setSsu(String ssu) {
		this.ssu = ssu;
	}
	public String getGeriatrics() {
		return geriatrics;
	}
	public void setGeriatrics(String geriatrics) {
		this.geriatrics = geriatrics;
	}
	public String getEhs() {
		return ehs;
	}
	public void setEhs(String ehs) {
		this.ehs = ehs;
	}
	public String getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getContact_person() {
		return contact_person;
	}
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}
	public String getContact_person_mobile() {
		return contact_person_mobile;
	}
	public void setContact_person_mobile(String contact_person_mobile) {
		this.contact_person_mobile = contact_person_mobile;
	}
	public String getAmbulance_category() {
		return ambulance_category;
	}
	public void setAmbulance_category(String ambulance_category) {
		this.ambulance_category = ambulance_category;
	}
	public String getAmbulance_contact() {
		return ambulance_contact;
	}
	public void setAmbulance_contact(String ambulance_contact) {
		this.ambulance_contact = ambulance_contact;
	}
	public Integer getHdu_sectioned() {
		return hdu_sectioned;
	}
	public void setHdu_sectioned(Integer hdu_sectioned) {
		this.hdu_sectioned = hdu_sectioned;
	}
	public Integer getHdu_functional() {
		return hdu_functional;
	}
	public void setHdu_functional(Integer hdu_functional) {
		this.hdu_functional = hdu_functional;
	}
	public Integer getNicu_sectioned() {
		return nicu_sectioned;
	}
	public void setNicu_sectioned(Integer nicu_sectioned) {
		this.nicu_sectioned = nicu_sectioned;
	}
	public Integer getNicu_functional() {
		return nicu_functional;
	}
	public void setNicu_functional(Integer nicu_functional) {
		this.nicu_functional = nicu_functional;
	}
	
	
	
	

}
