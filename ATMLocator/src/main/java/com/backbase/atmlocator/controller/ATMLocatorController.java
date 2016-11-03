package com.backbase.atmlocator.controller;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.backbase.atmlocator.client.INGApiIntegration;

@Controller
@RequestMapping("/")
public class ATMLocatorController {
	
	private static final Logger logger = Logger.getLogger(ATMLocatorController.class);
	
	@Autowired
	INGApiIntegration ingApiIntegration;
	
	 @RequestMapping(method = RequestMethod.GET)
	    public String atmLocator() {
	        return "atmlocator";
	    }
	 
	 @RequestMapping(value = "/list-all-atm", method = RequestMethod.GET)
		public ModelAndView getdata() {
		 	logger.info("listing all the ATMs");
			ModelAndView model = new ModelAndView("listAllAtm");
			try {
				model.addObject("atms", ingApiIntegration.getAllAtm());
			} catch (JsonParseException | JsonMappingException e) {
				logger.fatal("Seems something wrong with the Client API" + e);
			}
			return model;
		}

	public void setIngApiIntegration(INGApiIntegration ingApiIntegration) {
		this.ingApiIntegration = ingApiIntegration;
	}
	 
	 
	 
	}


