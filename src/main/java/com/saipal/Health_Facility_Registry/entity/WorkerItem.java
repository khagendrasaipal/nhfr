package com.saipal.Health_Facility_Registry.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkerItem {
	
	private String nameen;
	private String namenp;
	private String nid;
	private String gender;
	private String dob;
	private String ethnicity;
	private String provinceid;
	private String districtid;
	private String palikaid;
	private String hwemail;
	private String hwmobile;
	private String council;
	private String councilno;
	private String pis;
	private String ppis;
	private String emptype;
	private String darbanditype;
	private String emplevel;
	private String apoint_date;
	private String att_date;
	private String empstatus;
	private String worktype;
	private String education;
	private String qualification;
	private String groupid;
	private String subgroupid;
	private String postid;
	public String getNameen() {
		return nameen;
	}
	public void setNameen(String nameen) {
		this.nameen = nameen;
	}
	public String getNamenp() {
		return namenp;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getSubgroupid() {
		return subgroupid;
	}
	public void setSubgroupid(String subgroupid) {
		this.subgroupid = subgroupid;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public void setNamenp(String namenp) {
		this.namenp = namenp;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getDistrictid() {
		return districtid;
	}
	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}
	public String getPalikaid() {
		return palikaid;
	}
	public void setPalikaid(String palikaid) {
		this.palikaid = palikaid;
	}
	public String getHwemail() {
		return hwemail;
	}
	public void setHwemail(String hwemail) {
		this.hwemail = hwemail;
	}
	public String getHwmobile() {
		return hwmobile;
	}
	public void setHwmobile(String hwmobile) {
		this.hwmobile = hwmobile;
	}
	public String getCouncil() {
		return council;
	}
	public void setCouncil(String council) {
		this.council = council;
	}
	public String getCouncilno() {
		return councilno;
	}
	public void setCouncilno(String councilno) {
		this.councilno = councilno;
	}
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public String getPpis() {
		return ppis;
	}
	public void setPpis(String ppis) {
		this.ppis = ppis;
	}
	public String getEmptype() {
		return emptype;
	}
	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}
	public String getDarbanditype() {
		return darbanditype;
	}
	public void setDarbanditype(String darbanditype) {
		this.darbanditype = darbanditype;
	}
	public String getEmplevel() {
		return emplevel;
	}
	public void setEmplevel(String emplevel) {
		this.emplevel = emplevel;
	}
	public String getApoint_date() {
		return apoint_date;
	}
	public void setApoint_date(String apoint_date) {
		this.apoint_date = apoint_date;
	}
	public String getAtt_date() {
		return att_date;
	}
	public void setAtt_date(String att_date) {
		this.att_date = att_date;
	}
	public String getEmpstatus() {
		return empstatus;
	}
	public void setEmpstatus(String empstatus) {
		this.empstatus = empstatus;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	

}
