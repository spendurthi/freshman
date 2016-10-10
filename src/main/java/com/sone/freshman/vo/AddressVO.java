package com.sone.freshman.vo;


public class AddressVO {
	private int id;
	private String street;
	private String suiteApt;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phoneHome;
	private String phoneOffice;
	private String phoneMobile;
	private String type;
	private String extension;
	private String fax;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuiteApt() {
		return suiteApt;
	}
	public void setSuiteApt(String suiteApt) {
		this.suiteApt = suiteApt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneHome() {
		return phoneHome;
	}
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	public String getPhoneOffice() {
		return phoneOffice;
	}
	public void setPhoneOffice(String phoneOffice) {
		this.phoneOffice = phoneOffice;
	}
	public String getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public AddressVO(int id){
		this.id = id;
	}
	public AddressVO(){}
}
