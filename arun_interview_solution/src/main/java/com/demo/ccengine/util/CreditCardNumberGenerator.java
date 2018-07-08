package com.demo.ccengine.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.ccengine.service.CreditCard;

@Component
public class CreditCardNumberGenerator {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CreditCardNumberGenerator.class);

	private Random random = new Random(System.currentTimeMillis());

	private static final int CARD_NUMBER_LENGTH = 16;

	/**
	 * This method is used to generates a random valid credit card number of any
	 * bank based on initial digit passed in method
	 * 
	 * @param cardType
	 *            Card initial digits at the start of the credit card number,
	 *            used to identify the bank that is issuing the credit card
	 * @param noOfCards
	 *            Total length of the credit card number.
	 * @return return Set<CreditCard>
	 */
	public Set<CreditCard> generateCardNumber(CreditCardType cardType,
			int noOfCards) {
		Set<CreditCard> cardNumberSet = new HashSet<>();
		while (cardNumberSet.size() < noOfCards) {
			String cardNo = generateCardNumber(cardType);
			boolean flag = cardNumberSet.add(new CreditCard(cardNo, cardType
					.getCardType()));
			if (!flag)
				LOGGER.info("Duplicate Credit Card Number generated:" + cardNo);
		}
		return cardNumberSet;
	}

	/**
	 * This method is used to generates a random valid credit card number of any
	 * bank based on initial digit passed in method
	 * 
	 * @param cardType
	 *            CardType of the credit card number
	 * @return Credit Card Number
	 */
	public String generateCardNumber(CreditCardType cardType) {
		int randomNumberLength = CARD_NUMBER_LENGTH
				- (cardType.getCardInitialNumber().length() + 1);
		StringBuilder cardNumberBuilder = new StringBuilder(
				cardType.getCardInitialNumber());
		for (int i = 0; i < randomNumberLength; i++) {
			int digit = this.random.nextInt(10);
			cardNumberBuilder.append(digit);
		}

		int checkDigit = this.getCheckDigit(cardNumberBuilder.toString());
		cardNumberBuilder.append(checkDigit);
		LOGGER.info("Credit Card Number :" + cardNumberBuilder.toString()
				+ " generated");
		return cardNumberBuilder.toString();
	}

	/**
	 * Generates the check digit required to make the given credit card number
	 * valid (i.e. pass the Luhn check)
	 *
	 * @param cardNumber
	 *            The credit card number for which to generate the check digit.
	 * @return The check digit required to make the given credit card number
	 *         valid.
	 */
	private int getCheckDigit(String cardNumber) {
		int sum = 0;
		for (int i = 0; i < cardNumber.length(); i++) {
			int digit = Integer.parseInt(cardNumber.substring(i, (i + 1)));

			if ((i % 2) == 0) {
				digit = digit * 2;
				if (digit > 9) {
					digit = (digit / 10) + (digit % 10);
				}
			}
			sum += digit;
		}
		int mod = sum % 10;
		return ((mod == 0) ? 0 : 10 - mod);
	}

}
