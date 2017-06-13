package com.example.dto;

import java.util.Arrays;

public class GoogleGeoCodeResponse {
    private GoogleGeoCodeResponseResult[] results;
    private int response;
	public GoogleGeoCodeResponseResult[] getResults() {
		return results;
	}
	public void setResults(GoogleGeoCodeResponseResult[] results) {
		this.results = results;
	}
	public int getResponse() {
		return response;
	}
	public void setResponse(int response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "GoogleGeoCodeResponse [results=" + Arrays.toString(results) + ", response=" + response + "]";
	}
    
    
}
