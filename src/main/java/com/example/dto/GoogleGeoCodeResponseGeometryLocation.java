package com.example.dto;

public class GoogleGeoCodeResponseGeometryLocation {
	public String lat;
    public String lng;
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "GoogleGeoCodeResponseGeometryLocation [lat=" + lat + ", lng=" + lng + "]";
	}
    
    
}
