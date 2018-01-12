package com.boot.operations.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.boot.operations.SpringBootMainApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(
	webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT,
			classes=SpringBootMainApplication.class
)

@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
public class SpringBootMainApplicationIntegrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void retrieveAllEmployee() throws Exception{
	
		RequestBuilder reqBuilder=MockMvcRequestBuilders.get("/emp/retrieveAll").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult=mockMvc.perform(reqBuilder).andReturn();
		
		System.out.println("value="+mvcResult.getResponse().toString()); 
			
	}

}
