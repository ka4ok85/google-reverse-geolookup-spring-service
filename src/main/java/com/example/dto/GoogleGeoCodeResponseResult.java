package com.example.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleGeoCodeResponseResult {
    
	@JsonProperty(value = "formatted_address")
	private String formattedAddress;
    
	private GoogleGeoCodeResponseGeometry geometry ;
    
	private String[] types;

	@JsonProperty(value = "address_components")
	private GoogleGeoCodeResponseAddressComponent[] addressComponents;

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public GoogleGeoCodeResponseGeometry getGeometry() {
		return geometry;
	}

	public void setGeometry(GoogleGeoCodeResponseGeometry geometry) {
		this.geometry = geometry;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public GoogleGeoCodeResponseAddressComponent[] getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(GoogleGeoCodeResponseAddressComponent[] addressComponents) {
		this.addressComponents = addressComponents;
	}

	@Override
	public String toString() {
		return "GoogleGeoCodeResponseResult [formattedAddress=" + formattedAddress + ", geometry=" + geometry
				+ ", types=" + Arrays.toString(types) + ", addressComponents=" + Arrays.toString(addressComponents)
				+ "]";
	}
	
	
}
