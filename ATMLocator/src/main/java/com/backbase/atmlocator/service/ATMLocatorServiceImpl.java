package com.backbase.atmlocator.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backbase.atmlocator.client.INGApiIntegration;
import com.backbase.atmlocator.model.ATM;

@Service
public class ATMLocatorServiceImpl implements ATMLocatorService {

	private static final Logger logger = Logger.getLogger(ATMLocatorServiceImpl.class);
	@Autowired
	private INGApiIntegration ingApiIntegration;
	
	public ATMLocatorServiceImpl(INGApiIntegration ingApiIntegration) {
		this.ingApiIntegration = ingApiIntegration;
	}

	@Override
	public List<ATM> locate(String cityName) throws JsonParseException, JsonMappingException {
		List<ATM> atms = ingApiIntegration.getAllAtm();
		if(logger.isDebugEnabled()){
			logger.debug("fetched "+ atms.size() + " ATM data from ING API");
		}
		return filter(atms, cityName);
	}

	private List<ATM> filter(List<ATM> allAtms, String cityName) {
		Iterator<ATM> iterator = allAtms.iterator();
		while (iterator.hasNext()) {
			ATM atm = iterator.next();
			if (!atm.belongsTo(cityName))
				iterator.remove();
		}
		if(logger.isDebugEnabled()){
			logger.debug(allAtms.size() + " ATM found in the city : " + cityName);
		}
		return allAtms;
	}

}
