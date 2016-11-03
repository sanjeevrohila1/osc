package com.backbase.atmlocator.service;

import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import com.backbase.atmlocator.model.ATM;


public interface ATMLocatorService {
	
	public List<ATM> locate(String cityName) throws JsonParseException, JsonMappingException;

}
