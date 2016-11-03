package com.backbase.atmlocator.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.backbase.atmlocator.model.ATM;
import com.backbase.atmlocator.model.Address;
import com.backbase.atmlocator.service.ATMLocatorService;

public class ATMLocatorAPIControllerTest {
	
	ATMLocatorAPIController controller;

	@Before
	public void setUp() throws Exception {
		ATMLocatorService	mockAtmLocatorService = new ATMLocatorService() {
			@Override
			public List<ATM> locate(String cityName) throws JsonParseException, JsonMappingException {
				Address address1 = new Address();
				address1.setCity("Amsterdam");
				Address address2 = new Address();
				address2.setCity("KAMPEN");
				ATM atm1 = new ATM(address1, 1.0, "AC" );
				ATM atm2 = new ATM(address1, 2.0, "XYZ" );
				ATM atm3 = new ATM(address2, 1.0, "ABC" );
				ATM atm4 = new ATM(address2, 1.0, "AB" );
				List<ATM> atms = new ArrayList<>();
				atms.add(atm1);atms.add(atm2);atms.add(atm3);atms.add(atm4);
				return atms;
			}
		};
		controller = new ATMLocatorAPIController();
		controller.setAtmLocatorService(mockAtmLocatorService);
	}

	@Test
	public void shouldReturnOKStatus() throws JsonParseException, JsonMappingException, IOException {
		ResponseEntity<List<ATM>> response = controller.listAllAtms("Amsterdam");
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void shouldReturnNoStatus() throws JsonParseException, JsonMappingException, IOException {
		ATMLocatorService mockAtmLocatorService = new ATMLocatorService() {
			@Override
			public List<ATM> locate(String cityName) throws JsonParseException, JsonMappingException {
				return null;
			}
		};
		controller.setAtmLocatorService(mockAtmLocatorService);
		ResponseEntity<List<ATM>> response = controller.listAllAtms("Amsterdam");
		Assert.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
		
	}
	
	@Test
	public void shouldReturnServiceNotAvailable() throws JsonParseException, JsonMappingException, IOException {
		ATMLocatorService mockAtmLocatorService = new ATMLocatorService() {
			@Override
			public List<ATM> locate(String cityName) throws JsonParseException {
				throw new JsonParseException("AmsterDam", null);
			}
		};
		controller.setAtmLocatorService(mockAtmLocatorService);
		ResponseEntity<List<ATM>> response = controller.listAllAtms("Amsterdam");
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SERVICE_UNAVAILABLE);
		
	}

}
