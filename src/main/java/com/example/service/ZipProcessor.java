package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.example.dto.Call;
import com.example.dto.GoogleGeoCodeResponse;
import com.example.dto.GoogleGeoCodeResponseAddressComponent;
import com.example.dto.GoogleGeoCodeResponseResult;

@EnableBinding(Processor.class)
@Component
public class ZipProcessor {

	private static final Logger log = LoggerFactory.getLogger(ZipProcessor.class);

	private static final String zipWord = "postal_code";

	@Value("${google.appKey}")
	private String appKey;

	@Value("${service.name}")
	private String serviceName;

	@Autowired
	private HystrixReverseGeoLookupService hystrixReverseGeoLookupService;

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Call addZipToTheCall(Call call) { // enrich Call object with Zip Code
		if (call.getLatitude() == 0.0f && call.getLongitude() == 0.0f) {
			log.warn("Service: {}. Incident: {}. Blank coordinates.", serviceName, call.getIncidentNumber());
			return call;
		}

		GoogleGeoCodeResponse response = hystrixReverseGeoLookupService.getZip(String.valueOf(call.getLatitude()) + "," + String.valueOf(call.getLongitude()), appKey, call.getIncidentNumber());
		String zip = "";
		if (response != null && response.getResults().length > 0) {
			resultsTopLevelLoop: for (GoogleGeoCodeResponseResult resultItem : response.getResults()) {
				for (GoogleGeoCodeResponseAddressComponent addressComponent : resultItem.getAddressComponents()) {
					if (addressComponent.getTypes()[0].equals(zipWord)) {
						zip = addressComponent.getShortName();
						if (zip.isEmpty() == false) {
							break resultsTopLevelLoop;
						}
					}
				}
			}
		}

		if (zip.isEmpty()) {
			log.error("Service: {}. Incident: {}. Can not lookup Zip!", serviceName, call.getIncidentNumber());
			log.error(response.toString());
			return null;
		} else {
			call.setZip(zip);
			return call;
		}
	}
}
