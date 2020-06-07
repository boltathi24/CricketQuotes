package com.cq.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.apache.commons.configuration.ConfigurationException;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cq.model.RequestModel;

@RestController
public class ServiceController {

	@RequestMapping(value = "/getQuotesByPlayer", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody RequestModel params)
			throws ConfigurationException, ParseException, IOException {

		String playerName=params.getPlayerName();
		return new ResponseEntity<>(playerName, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/cricket")
	public ResponseEntity<Object> printSomething() throws JSONException {

		HashMap<String, String> hello = new HashMap<String, String>();
		hello.put("Key", "Value");
		return new ResponseEntity<>(hello, HttpStatus.OK);
	}

}