package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import com.example.dto.Call;
import com.example.dto.GoogleGeoCodeResponse;
import com.example.dto.GoogleGeoCodeResponseAddressComponent;

import feign.FeignException;


@EnableBinding(Processor.class) 
public class ZipProcessor {

	private static final Logger log = LoggerFactory.getLogger(ZipProcessor.class);
	
	private static final String zipWord = "postal_code";

	@Value("${google.appKey}")
	private String appKey;
	
    @Value("${service.name}")
    private String serviceName;
	
	@Autowired
	private ReverseGeoLookupResource reverseGeoLookupResource;
	
	@StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Call transformToUpperCase(Call call) { // enrich Call object with Zip Code
		// TODO: Add Hystrix Support
		
		try {
			GoogleGeoCodeResponse response = reverseGeoLookupResource.getAddressDetails(String.valueOf(call.getLatitude()) + "," + String.valueOf(call.getLongitude()), appKey);
	
			String zip = "";
			for (GoogleGeoCodeResponseAddressComponent addressComponent : response.getResults()[0].getAddressComponents()) {
				if (addressComponent.getTypes()[0].equals(zipWord)) {
					zip = addressComponent.getShortName();
				}
			}
			
			if (zip == "") {
				log.error("Service: {}. Incident: {}. Can not lookup Zip!", serviceName, call.getIncidentNumber());
			} else {
				call.setZip(zip);
			}
        } catch (FeignException e) {
        	log.error("Service: {}. Incident: {}. Can not fetch data from: {}", serviceName, call.getIncidentNumber(), e.getMessage());
		}

        return call;
    }
}
