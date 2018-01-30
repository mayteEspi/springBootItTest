package com.meh.ittest.controller;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.meh.ittest.SpringBootIntegrationTestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootIntegrationTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WelcomeControllerIT {


	@LocalServerPort
	private int port;

	  
	@Test
	public void welcome_thenStatus200() throws Exception {
		final TestRestTemplate restTemplate = new TestRestTemplate();
		final HttpEntity<String> requestEntity = new HttpEntity<String>(new HttpHeaders());
		ResponseEntity<String> response = restTemplate.exchange(
				getUrlWithPort("/welcome"),HttpMethod.GET,requestEntity, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		JSONAssert.assertEquals("{'userName':Mayte}", response.getBody(), true);
	}
	
	
	private String getUrlWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
	
}
