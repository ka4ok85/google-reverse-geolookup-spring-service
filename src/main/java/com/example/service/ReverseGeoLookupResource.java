package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.config.FeignConfiguration;
import com.example.dto.GoogleGeoCodeResponse;

@FeignClient(name = "reverse-geo-lookup-service", url = "https://maps.googleapis.com/maps/api/geocode/json", configuration = FeignConfiguration.class)
public interface ReverseGeoLookupResource {
	@RequestMapping(method = RequestMethod.GET)
	public GoogleGeoCodeResponse getAddressDetails(@RequestParam("latlng") String latlng, @RequestParam("key") String appKey);
}

