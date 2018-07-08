package com.demo.ccengine.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.ccengine.main.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
public class CCEngineControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void masterCCEngineControllerTest() throws Exception {
		this.mockMvc.perform(get("/CCEngine/Master/5"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(5)))
				.andExpect(jsonPath("$[0].cardType", is("Master")))
				.andExpect(jsonPath("$[0].cardNumber", startsWith("5")))
				.andReturn();		
	}
	
	@Test
	public void visaCCEngineControllerTest() throws Exception {
		this.mockMvc.perform(get("/CCEngine/Visa/3"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].cardType", is("Visa")))
				.andExpect(jsonPath("$[0].cardNumber", startsWith("4")))
				.andReturn();		
	}
	
	@Test
	public void amexCCEngineControllerTest() throws Exception {
		this.mockMvc.perform(get("/CCEngine/Amex/5"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(5)))
				.andExpect(jsonPath("$[0].cardType", is("Amex")))
				.andExpect(jsonPath("$[0].cardNumber", startsWith("37")))
				.andReturn();		
	}
	
	@Test
	public void discoverCCEngineControllerTest() throws Exception {
		this.mockMvc.perform(get("/CCEngine/Discover/5"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(5)))
				.andExpect(jsonPath("$[0].cardType", is("Discover")))
				.andExpect(jsonPath("$[0].cardNumber", startsWith("6")))
				.andReturn();		
	}
	
	

}
