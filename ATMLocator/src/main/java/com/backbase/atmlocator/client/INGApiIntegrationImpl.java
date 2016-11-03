package com.backbase.atmlocator.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backbase.atmlocator.exception.CouldNotConnectToINGAPIException;
import com.backbase.atmlocator.model.ATM;

@Service
public class INGApiIntegrationImpl implements INGApiIntegration {

	private RestTemplate restTemplate = new RestTemplate();
	// this can be externalized later to environment specific if there are multiple environments - spring profiles
	// can be used.
	private static final String endPoint = "https://www.ing.nl/api/locator/atms/";

	private static final Logger logger = Logger.getLogger(INGApiIntegrationImpl.class);

	@Override
	public List<ATM> getAllAtm() throws JsonParseException, JsonMappingException {
		logger.info("Fetching all the ATM details from ING API");
		try {
			String json = restTemplate.getForObject(endPoint, String.class);
			json = sanitize(json);
			return new ObjectMapper().readValue(json, new TypeReference<ArrayList<ATM>>() {
			});
		} catch (IOException exception) {
			logger.error("Error connecting to ING API" + exception);
			throw new CouldNotConnectToINGAPIException(exception);
		}
	}

	private String sanitize(String json) {
		return json.substring(json.indexOf("[{"));
	}

}
