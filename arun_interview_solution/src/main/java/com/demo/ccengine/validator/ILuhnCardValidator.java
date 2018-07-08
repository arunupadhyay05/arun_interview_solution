package com.demo.ccengine.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("ILuhnCardValidator")
public interface ILuhnCardValidator extends CardValidator {
	
	public boolean validate(String cardNumber);
	
	public default boolean validateCardNumberAgainstLuhnAlgo(final String cardNumber) {

		int[] ints = new int[cardNumber.length()];
		for (int i = 0; i < cardNumber.length(); i++) {
			ints[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
		}
		for (int i = ints.length - 2; i >= 0; i = i - 2) {
			int j = ints[i];
			j = j * 2;
			if (j > 9) {
				j = j % 10 + 1;
			}
			ints[i] = j;
		}
		int sum = 0;
		for (int i = 0; i < ints.length; i++) {
			sum += ints[i];
		}
		if (sum % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
