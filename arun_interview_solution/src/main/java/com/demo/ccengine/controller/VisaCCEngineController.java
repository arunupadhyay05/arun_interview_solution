package com.demo.ccengine.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ccengine.service.CreditCard;
import com.demo.ccengine.service.ICCEngineService;

@RestController
public class VisaCCEngineController {

	@Autowired
	@Qualifier("VisaCCEngineServiceImpl")
	private ICCEngineService ccEngineService;

	@GetMapping(path = "/CCEngine/Visa/{noOfCards}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<CreditCard> getVisaCreditCards(@PathVariable Integer noOfCards) {
		return ccEngineService.generateCreditCards(noOfCards);
	}

}
