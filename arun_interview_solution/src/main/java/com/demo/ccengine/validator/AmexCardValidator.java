package com.demo.ccengine.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.ccengine.util.CreditCardType;
import com.demo.ccengine.validator.ILuhnCardValidator;;

@Component("AmexCardValidator")
public class AmexCardValidator implements ILuhnCardValidator{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AmexCardValidator.class);

	@Override
	public boolean validate(String cardNumber) {
		boolean flag = cardNumber.startsWith(CreditCardType.AMEX.getCardInitialNumber());
		if(flag){
			flag = validateCardNumberAgainstLuhnAlgo(cardNumber);
		}else{
			LOGGER.info(cardNumber+" is not a valid AMEX credit card");
		}
		return flag;
	}
}
