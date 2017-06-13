package com.example.dto;

public class GoogleGeoCodeResponseGeometryBounds {
	private GoogleGeoCodeResponseGeometryLocation northeast ;
	private GoogleGeoCodeResponseGeometryLocation southwest ;

	public GoogleGeoCodeResponseGeometryLocation getNortheast() {
		return northeast;
	}
	public void setNortheast(GoogleGeoCodeResponseGeometryLocation northeast) {
		this.northeast = northeast;
	}
	public GoogleGeoCodeResponseGeometryLocation getSouthwest() {
		return southwest;
	}
	public void setSouthwest(GoogleGeoCodeResponseGeometryLocation southwest) {
		this.southwest = southwest;
	}
	@Override
	public String toString() {
		return "GoogleGeoCodeResponseGeometryBounds [northeast=" + northeast + ", southwest=" + southwest + "]";
	}
	
	
}
