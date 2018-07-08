package com.demo.ccengine.validator;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.Callable;

import com.demo.ccengine.service.CreditCard;

public class CreditCardValidatorWorkerTask implements Callable<Set<CreditCard>>{

	private final Set<CreditCard> cards;
	private final CardValidator cardValidator;
	
	public CreditCardValidatorWorkerTask(Set<CreditCard> cards, CardValidator cardValidator) {
		this.cards = cards;
		this.cardValidator = cardValidator;
	}

	@Override
	public Set<CreditCard> call() throws Exception {
		for (CreditCard creditCard : cards) {
			if (cardValidator.validate(creditCard.getCardNumber())) {
				creditCard.setExpiryDate(LocalDate.now()
						.toString());				
			}
		}
		return cards;
	}

}
