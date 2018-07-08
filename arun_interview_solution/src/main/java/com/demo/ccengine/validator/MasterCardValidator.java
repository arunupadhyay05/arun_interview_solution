package com.demo.ccengine.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.ccengine.util.CreditCardType;

@Component("MasterCardValidator")
public class MasterCardValidator implements ILuhnCardValidator {

	private static final Logger LOGGER = LoggerFactory.getLogger(MasterCardValidator.class);

	@Override
	public boolean validate(String cardNumber) {
		boolean flag = cardNumber.startsWith(CreditCardType.MASTER.getCardInitialNumber());
		if(flag){
			flag = validateCardNumberAgainstLuhnAlgo(cardNumber);
		}else{
			LOGGER.info(cardNumber+" is not a valid Master credit card");
		}
		return flag;
	}
}
