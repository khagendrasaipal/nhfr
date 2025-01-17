package com.saipal.Health_Facility_Registry.entity;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OwnerItem {

	private String oname;
    private String oaddress;
    private String oemail;
    private String octzn;
    private String omobile;
    
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOaddress() {
		return oaddress;
	}
	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}
	public String getOemail() {
		return oemail;
	}
	public void setOemail(String oemail) {
		this.oemail = oemail;
	}
	public String getOctzn() {
		return octzn;
	}
	public void setOctzn(String octzn) {
		this.octzn = octzn;
	}
	public String getOmobile() {
		return omobile;
	}
	public void setOmobile(String omobile) {
		this.omobile = omobile;
	}
}
