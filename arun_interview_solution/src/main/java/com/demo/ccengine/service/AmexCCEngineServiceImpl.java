package com.demo.ccengine.service;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.ccengine.util.CreditCardNumberGenerator;
import com.demo.ccengine.util.CreditCardType;
import com.demo.ccengine.validator.CardValidator;
import com.demo.ccengine.validator.CreditCardValidatorEngine;

@Service("AmexCCEngineServiceImpl")
public class AmexCCEngineServiceImpl implements ICCEngineService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AmexCCEngineServiceImpl.class);

	@Autowired
	private CreditCardNumberGenerator cardNumberGenerator;

	@Autowired
	@Qualifier("AmexCardValidator")
	private CardValidator creditCardValidator;
	
	@Autowired
	private CreditCardValidatorEngine validatorEngine;
	
	
	@Override
	public Set<CreditCard> generateCreditCards(Integer noOfCards) {
		Set<CreditCard> creditCardSet = cardNumberGenerator.generateCardNumber(
				CreditCardType.AMEX, noOfCards);
		
		Future<Set<CreditCard>> validatorEngineFuture = validatorEngine.addCardsForValidation(creditCardSet, creditCardValidator);
		Set<CreditCard> validatedCreditCardSet = null;
		try {
			validatedCreditCardSet = validatorEngineFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error("Exception: "+e.getMessage(),e);
		}		
		LOGGER.info("Total No of cards:"+validatedCreditCardSet.size()+", Amex Cards List: "+validatedCreditCardSet);
		return validatedCreditCardSet;
	}

}
