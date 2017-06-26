package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.dto.GoogleGeoCodeResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HystrixReverseGeoLookupService {

	private static final Logger log = LoggerFactory.getLogger(HystrixReverseGeoLookupService.class);
	
	@Autowired
	private RetryReverseGeoLookupService retryReverseGeoLookupService;

    @Value("${service.name}")
    private String serviceName;

	@HystrixCommand(fallbackMethod="getZipFallback")
	public GoogleGeoCodeResponse getZip(String latlng, String appKey, String incidentNumber) {
		GoogleGeoCodeResponse response = retryReverseGeoLookupService.requestAddressDetails(latlng, appKey, incidentNumber);

		return response;
	}

    
    public GoogleGeoCodeResponse getZipFallback(String latlng, String appKey, String incidentNumber) {
		log.warn("Service: {}. Circuit Breaker Fallback Method returned null", serviceName);

        return null;
    }
	
	
}



