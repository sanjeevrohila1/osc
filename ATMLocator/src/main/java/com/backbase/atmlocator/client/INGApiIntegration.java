package com.backbase.atmlocator.client;

import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import com.backbase.atmlocator.model.ATM;


public interface INGApiIntegration {

	public List<ATM> getAllAtm() throws JsonParseException, JsonMappingException;

}
