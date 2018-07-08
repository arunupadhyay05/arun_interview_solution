package com.demo.ccengine.util;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.ccengine.main.Application;
import com.demo.ccengine.service.CreditCard;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = Application.class)
public class CreditCardNumberGeneratorTest {

	@Autowired
	private CreditCardNumberGenerator cardNumberGenerator;

	@Test
	public void testValidCardNumberForVisa() {
		String creditCardNo = cardNumberGenerator.generateCardNumber(CreditCardType.VISA);
		System.out.println("CreditCardNo: "+creditCardNo);
		assertTrue(creditCardNo.startsWith("4"));
	}
	
	@Test
	public void testForCardEquality() {
		Set<CreditCard> visaCreditCards = cardNumberGenerator.generateCardNumber(CreditCardType.VISA, 1);
		CreditCard visaCreditCard = null;
		for (CreditCard creditCard : visaCreditCards) {
			visaCreditCard = creditCard;
		}		
		Set<CreditCard> amexCreditCards = cardNumberGenerator.generateCardNumber(CreditCardType.AMEX, 1);
		CreditCard amexCreditCard = null;
		for (CreditCard creditCard : amexCreditCards) {
			amexCreditCard = creditCard;
		}
		assertFalse(visaCreditCard.equals(amexCreditCard));
	}
	
	@Test
	public void testInvalidCardNumberForVisa() {
		String creditCardNo = cardNumberGenerator.generateCardNumber(CreditCardType.VISA);
		System.out.println("CreditCardNo: "+creditCardNo);
		assertFalse(creditCardNo.startsWith("5"));
	}
	

}
