package com.meh.ittest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meh.ittest.model.UserModel;

@RestController
public class WelcomeController {

	private static Log log = LogFactory.getLog(WelcomeController.class);
	
	@GetMapping("/welcome")
	public ResponseEntity<UserModel> welcome() {
		ResponseEntity<UserModel> response = null;
		try{
			response = new ResponseEntity<>(new UserModel("Mayte"), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e);
		}
		return response;
	}
}
