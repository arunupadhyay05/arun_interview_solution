package com.demo.ccengine.validator;

import org.springframework.stereotype.Component;

@Component("CardValidator")
public interface CardValidator {

	public boolean validate(String cardNumber);
	
	
}
