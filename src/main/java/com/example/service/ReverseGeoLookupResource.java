package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.config.FeignConfiguration;
import com.example.dto.GoogleGeoCodeResponse;


//@FeignClient(name = "reverse-geo-lookup-service", url = "http://nominatim.openstreetmap.org/reverse?format=json&addressdetails=1", configuration = FeignConfiguration.class)
//@FeignClient(name = "reverse-geo-lookup-service", url = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCpiTxxB3VVo1lCfhiI7MoJLBwwMwCWtTM", configuration = FeignConfiguration.class)

         // https://maps.googleapis.com/maps/api/geocode/json?latlng=47.592506,-122.311966&key=AIzaSyCpiTxxB3VVo1lCfhiI7MoJLBwwMwCWtTM
@FeignClient(name = "reverse-geo-lookup-service", url = "https://maps.googleapis.com/maps/api/geocode/json", configuration = FeignConfiguration.class)
public interface ReverseGeoLookupResource {
	//@RequestMapping(method = RequestMethod.GET)
	//public GoogleGeoCodeResponse getAddressDetails(@RequestParam("lat") float lat, @RequestParam("lon") float lon);
	
	@RequestMapping(method = RequestMethod.GET)
	public GoogleGeoCodeResponse getAddressDetails(@RequestParam("latlng") String latlng, @RequestParam("key") String appKey);
}

