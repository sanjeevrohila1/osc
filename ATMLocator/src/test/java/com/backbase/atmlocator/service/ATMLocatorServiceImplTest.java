package com.backbase.atmlocator.service;

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


public class ATMLocatorServiceImplTest {
	
	ATMLocatorService service;

	@Before
	public void init(){
		INGApiIntegration mockINGApiIntegration = new INGApiIntegration() {
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
		service = new ATMLocatorServiceImpl(mockINGApiIntegration);
		
	}
	
	@Test
	public void shouldNotFindAnyATMForAnInvalidCity() throws JsonParseException, JsonMappingException, IOException{
		Assert.assertEquals(" There is no ATM in XYZ",0, service.locate("XYZ").size());
	}
	
	@Test
	public void shouldReturn2ATMInAmsterdam() throws JsonParseException, JsonMappingException, IOException{
		Assert.assertEquals("",2, service.locate("Amsterdam").size());
		
	}
	
	@Test
	public void shouldReturn2ATMInAmsterdamForLowerCaseCityName() throws JsonParseException, JsonMappingException, IOException{
		Assert.assertEquals("",2, service.locate("amsterdam").size());
		
	}
	
	@Test
	public void shouldReturn2ATMInAmsterdamForUpperCaseCityName() throws JsonParseException, JsonMappingException, IOException{
		Assert.assertEquals("",2, service.locate("AMSTERDAM").size());
		
	}
	
	@Test
	public void shouldReturn2ATMInAmsterdamForMixedCaseCityName() throws JsonParseException, JsonMappingException, IOException{
		Assert.assertEquals("",2, service.locate("amSTerDam").size());
		
	}
	
	@Test(expected = JsonParseException.class)
	public void shouldThrowJsonParseException() throws JsonParseException, JsonMappingException, IOException{
		INGApiIntegration mockINGApiIntegration = new INGApiIntegration() {
			@Override
			public List<ATM> getAllAtm() throws JsonParseException, JsonMappingException {
				throw new JsonParseException("invalid Json", null);
			}
		};
		service = new ATMLocatorServiceImpl(mockINGApiIntegration);
		service.locate("AMSTERDAM");
	}
	
	@Test(expected = JsonMappingException.class)
	public void shouldThrowJsonMappingException() throws JsonParseException, JsonMappingException, IOException{
		INGApiIntegration mockINGApiIntegration = new INGApiIntegration() {
			@Override
			public List<ATM> getAllAtm() throws JsonParseException, JsonMappingException {
				throw new JsonMappingException("invalid json");
			}
		};
		service = new ATMLocatorServiceImpl(mockINGApiIntegration);
		service.locate("AMSTERDAM");
	}
	
	
}
