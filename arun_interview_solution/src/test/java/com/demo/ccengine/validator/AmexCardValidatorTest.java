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
public class AmexCardValidatorTest {
	
	@Autowired
	@Qualifier("AmexCardValidator")
	private CardValidator cardValidator;

	@Test
	public void testValidCreditCardsForAmex() {		
		assertEquals(true, cardValidator.validate("3736147381902430"));
	}

	@Test
	public void testInvalidCreditCardsForAmex() {
		assertNotEquals(true, cardValidator.validate("4903874600355166"));
	}

}
