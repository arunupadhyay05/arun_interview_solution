package com.demo.ccengine.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.ccengine.util.CreditCardType;

@Component("VisaCardValidator")
public class VisaCardValidator implements ILuhnCardValidator {

	private static final Logger LOGGER = LoggerFactory.getLogger(VisaCardValidator.class);


	@Override
	public boolean validate(String cardNumber) {
		boolean flag = cardNumber.startsWith(CreditCardType.VISA.getCardInitialNumber());
		if(flag){
			flag = validateCardNumberAgainstLuhnAlgo(cardNumber);
		}else{
			LOGGER.info(cardNumber+" is not a valid Visa credit card");
		}
		return flag;
	}
}
