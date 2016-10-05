package com.fgtway.vo;

public class Location implements java.io.Serializable{
	private static final long serialVersionUID = 8115801503385916381L;
	private String browserDetails;
	private String locationDetails;
	
	public void setBrowserDetails(String browserDetails) {
		this.browserDetails = browserDetails;
	}
	public String getBrowserDetails() {
		return browserDetails;
	}
	public void setLocationDetails(String locationDetails) {
		this.locationDetails = locationDetails;
	}
	public String getLocationDetails() {
		return locationDetails;
	}
	public Location() {
	}
	public Location(String browserDetails) {
		this.browserDetails = browserDetails;
	}
	public Location(String browserDetails, String locationDetails) {
		this.browserDetails = browserDetails;
		this.locationDetails = locationDetails;
	}
	@Override
	public String toString() {
		return "Location [browserDetails=" + browserDetails
				+ ", locationDetails=" + locationDetails + "]";
	}	
}
