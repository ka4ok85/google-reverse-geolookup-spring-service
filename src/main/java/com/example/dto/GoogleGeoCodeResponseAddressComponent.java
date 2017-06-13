package com.example.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleGeoCodeResponseAddressComponent {
	
	@JsonProperty(value = "long_name")
	private String longName;
	
	@JsonProperty(value = "short_name")
	private String shortName;
	
	private String[] types ;

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "GoogleGeoCodeResponseAddressComponent [longName=" + longName + ", shortName=" + shortName + ", types="
				+ Arrays.toString(types) + "]";
	}
	
	
}
