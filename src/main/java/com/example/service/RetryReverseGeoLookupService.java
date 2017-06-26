package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import feign.FeignException;

import com.example.dto.GoogleGeoCodeResponse;
import com.example.exceptions.ReverseGeoLookupResourceException;

@Component
class RetryReverseGeoLookupService {
	
	private static final Logger log = LoggerFactory.getLogger(RetryReverseGeoLookupService.class);
	
    @Value("${service.name}")
    private String serviceName;
	
	@Autowired
	private ReverseGeoLookupResource reverseGeoLookupResource;
	
	@Retryable(value = {FeignException.class}, maxAttempts = 3)
	public GoogleGeoCodeResponse requestAddressDetails(String latlng, String appKey, String incidentNumber) {
		GoogleGeoCodeResponse response = reverseGeoLookupResource.getAddressDetails(latlng, appKey);

		return response;
	}

    @Recover
    public GoogleGeoCodeResponse requestAddressDetailsRetryFallback(FeignException e) throws ReverseGeoLookupResourceException {
		log.warn("Service: {}. Can not fetch data from Google after 3 retries", serviceName);

		throw new ReverseGeoLookupResourceException();
    }
    
}