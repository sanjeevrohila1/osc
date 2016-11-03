package com.backbase.atmlocator.api;

import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.backbase.atmlocator.model.ATM;
import com.backbase.atmlocator.service.ATMLocatorService;

@RestController
public class ATMLocatorAPIController {

	private static final Logger logger = Logger.getLogger(ATMLocatorAPIController.class);
	@Autowired
	private ATMLocatorService atmLocatorService;
	
	
	@ResponseBody
	@RequestMapping(value = "/api/city/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<ATM>> listAllAtms(@PathVariable("name") String cityName)  {
		logger.info("Searching ATM in city " + cityName);
		List<ATM> atms = null;
		try {
			atms = atmLocatorService.locate(cityName);
		} catch (JsonParseException | JsonMappingException e) {
			logger.fatal("Looks like the Json Format changed on the client end! " + e);
			return new ResponseEntity<List<ATM>>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		if (atms == null || atms.isEmpty())
			return new ResponseEntity<List<ATM>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<ATM>>(atms, HttpStatus.OK);
	}


	public void setAtmLocatorService(ATMLocatorService atmLocatorService) {
		this.atmLocatorService = atmLocatorService;
	}
	
	
}
