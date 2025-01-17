package com.saipal.Health_Facility_Registry.entity;

import java.math.BigInteger;

public class PaginationEntity {

	int pageno,pagesize;
	String sortby;
	String token;
	BigInteger code;
	int province;
	int district;
	String municipality;
	String searchKeyword;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the pageno
	 */
	
	
	
	public int getPageno() {
		return pageno;
	}
	public PaginationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaginationEntity(int pageno, int pagesize, String sortby,String token,BigInteger code,int province,int district,String municipality,String searchKeyword) {
		super();
		this.pageno = pageno;
		this.pagesize = pagesize;
		this.sortby = sortby;
		this.token=token;
		this.code=code;
		this.province=province;
		this.district=district;
		this.municipality=municipality;
		this.searchKeyword=searchKeyword;
	}
	
	/**
	 * @return the pagesize
	 */
	public int getPagesize() {
		return pagesize;
	}
	/**
	 * @return the sortby
	 */
	public String getSortby() {
		return sortby;
	}
	/**
	 * @param pageno the pageno to set
	 */
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	/**
	 * @param pagesize the pagesize to set
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public BigInteger getCode() {
		return code;
	}
	public void setCode(BigInteger code) {
		this.code = code;
	}
	
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	
	
	public int getDistrict() {
		return district;
	}
	public void setDistrict(int district) {
		this.district = district;
	}
	
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	/**
	 * @param sortby the sortby to set
	 */
	public void setSortby(String sortby) {
		this.sortby = sortby;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	
}
