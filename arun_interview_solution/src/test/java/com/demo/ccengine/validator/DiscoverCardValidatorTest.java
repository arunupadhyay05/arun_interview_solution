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
public class DiscoverCardValidatorTest {
	
	@Autowired
	@Qualifier("DiscoverCardValidator")
	private CardValidator cardValidator;

	@Test
	public void testValidCreditCardsForDiscover() {		
		assertEquals(true, cardValidator.validate("6165714195913151"));
	}

	@Test
	public void testInvalidCreditCardsForDiscover() {
		assertNotEquals(true, cardValidator.validate("4903874600355166"));
	}

}
