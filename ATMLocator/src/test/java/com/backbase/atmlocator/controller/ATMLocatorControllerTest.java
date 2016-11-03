package com.backbase.atmlocator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.backbase.atmlocator.client.INGApiIntegration;
import com.backbase.atmlocator.model.ATM;
import com.backbase.atmlocator.model.Address;

public class ATMLocatorControllerTest {
	
	ATMLocatorController controller;

	@Before
	public void setUp() throws Exception {
		
		INGApiIntegration mockIngApiIntegration = new INGApiIntegration() {
			@Override
			public List<ATM> getAllAtm() throws JsonParseException, JsonMappingException {
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
		controller = new ATMLocatorController();
		controller.setIngApiIntegration(mockIngApiIntegration);
	}

	@Test
	public void shouldReturnViewWhichRenderListOfAllATMWhenThereIsData() throws JsonParseException, JsonMappingException, IOException {
		Assert.assertEquals("View which displays List of all ATM is rendered" , "listAllAtm", controller.getdata().getViewName());
	}
	
	@Test
	public void shouldReturnViewWhichRenderListOfAllATMEvenInCaseOfException() throws JsonParseException, JsonMappingException, IOException {
		INGApiIntegration mockIngApiIntegration = new INGApiIntegration() {
			@Override
			public List<ATM> getAllAtm() throws JsonParseException, JsonMappingException {
				throw new JsonParseException("bad json", null);
			}
		};
		controller.setIngApiIntegration(mockIngApiIntegration);
		Assert.assertEquals("View which displays List of all ATM is rendered" , "listAllAtm", controller.getdata().getViewName());
	}
	

}
