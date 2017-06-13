package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleGeoCodeResponseGeometry {

	private GoogleGeoCodeResponseGeometryBounds bounds;
   
    @JsonProperty(value = "location_type")
    private String locationType ;

    private GoogleGeoCodeResponseGeometryLocation location;

    private GoogleGeoCodeResponseGeometryBounds viewport;

	public GoogleGeoCodeResponseGeometryBounds getBounds() {
		return bounds;
	}
	
	public void setBounds(GoogleGeoCodeResponseGeometryBounds bounds) {
		this.bounds = bounds;
	}
	
	public String getLocationType() {
		return locationType;
	}
	
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	
	public GoogleGeoCodeResponseGeometryLocation getLocation() {
		return location;
	}
	
	public void setLocation(GoogleGeoCodeResponseGeometryLocation location) {
		this.location = location;
	}
	
	public GoogleGeoCodeResponseGeometryBounds getViewport() {
		return viewport;
	}
	
	public void setViewport(GoogleGeoCodeResponseGeometryBounds viewport) {
		this.viewport = viewport;
	}

	@Override
	public String toString() {
		return "GoogleGeoCodeResponseGeometry [bounds=" + bounds + ", locationType=" + locationType + ", location="
				+ location + ", viewport=" + viewport + "]";
	}
   
    
}
