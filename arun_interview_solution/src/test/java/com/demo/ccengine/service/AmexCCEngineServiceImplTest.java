package com.demo.ccengine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Set;

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
public class AmexCCEngineServiceImplTest {
	
	@Autowired
	@Qualifier("AmexCCEngineServiceImpl")
	private ICCEngineService ccEngineService;

	@Test
	public void testValidCreditCardsForVisa() {
		Set<CreditCard> creditCardSet = ccEngineService.generateCreditCards(2);
		assertEquals(2, creditCardSet.size());
	}

	@Test
	public void testInvalidCreditCardsForVisa() {
		Set<CreditCard> creditCardSet = ccEngineService.generateCreditCards(10);
		assertNotEquals(12, creditCardSet.size());
	}

}
