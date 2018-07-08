package com.demo.ccengine.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.ccengine.main.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = Application.class)
public class VisaCardValidatorTest {
	
	@Autowired
	@Qualifier("VisaCardValidator")
	private CardValidator cardValidator;

	@Test
	public void testValidCreditCardsForVisa() {		
		assertEquals(true, cardValidator.validate("4903874600355166"));
	}

	@Test
	public void testInvalidCreditCardsForVisa() {
		assertNotEquals(true, cardValidator.validate("3736147381902430"));
	}

}
