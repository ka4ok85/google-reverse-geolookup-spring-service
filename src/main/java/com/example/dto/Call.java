package com.example.dto;

public class Call {

    private Long id;
    
    private String address;
    
    private String type;
    
    private float latitude;
    
    private float longitude;
    
    private String datetime; // let's keep it String since we just pass this field to the Sink

    private String incidentNumber;
    
    private String zip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getIncidentNumber() {
		return incidentNumber;
	}

	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Call [id=" + id + ", address=" + address + ", type=" + type + ", latitude=" + latitude + ", longitude="
				+ longitude + ", datetime=" + datetime + ", incidentNumber=" + incidentNumber + ", zip=" + zip + "]";
	}

}
