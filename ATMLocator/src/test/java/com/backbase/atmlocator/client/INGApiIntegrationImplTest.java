package com.backbase.atmlocator.client;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class INGApiIntegrationImplTest {

	INGApiIntegrationImpl integration;

	@Before
	public void init() {
		integration = new INGApiIntegrationImpl();
	}

	@Test
	public void shouldNotNull() throws JsonParseException, JsonMappingException {
		Assert.assertNotNull("Yeah! The API works!", integration.getAllAtm());
	}

}
