package com.cq.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import org.apache.commons.configuration.ConfigurationException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cq.data.Utility;
import com.cq.model.ProcessRequest;
import com.cq.model.RequestModel;

@RestController
public class ServiceController {

	@RequestMapping(value = "/getQuotesByPlayer", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody RequestModel params)
			throws ConfigurationException, ParseException, IOException, ClassNotFoundException, SQLException {

		String playerName=params.getPlayerName();
		ProcessRequest pr=new ProcessRequest();
		JSONObject playerData=pr.getImageDataAndPlayerDataForPlayer(playerName);
		JSONObject quoteData=pr.getQuoteDataForPlayer(playerName);
		
		return new ResponseEntity<>(new Utility().mergeJsons(playerData, quoteData).toString(), HttpStatus.CREATED);
	}

//	@RequestMapping(value = "/cricket")
//	public ResponseEntity<Object> printSomething() throws JSONException {
//
//		HashMap<String, String> hello = new HashMap<String, String>();
//		hello.put("Key", "Value");
//		return new ResponseEntity<>(hello, HttpStatus.OK);
//	}

}