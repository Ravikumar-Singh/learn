package com.example.learn.controler;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.learn.model.Address;
import com.example.learn.model.Employee;
import com.example.learn.service.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

	 @Autowired
	  private MockMvc mockMvc;
	 
	 @Autowired
	  private ObjectMapper objectMapper;
	 
	 @MockBean
	Service service;
	 
	 @Test
	 public void testsaveEmployee() throws JsonProcessingException, Exception
	 {
		 Address adr=new Address("INR", "KA", "RCR", "123456");
		 Employee e= new Employee("name", "1234567890", "ravi@mail.com", "INR", 1210, adr);
		 mockMvc.perform(post("/save").contentType("application/json").content(objectMapper.writeValueAsString(e))).andExpect(status().isOk());
	 }
	 
	 @Test
	 public void testGetEmp() throws Exception
	 {
		 mockMvc.perform(get("/save/getEmp?name=Ravikumar")).andExpect(status().isOk()); 
	 }
	 
	 @Test
	 
	 public void testdelteEmp() throws Exception
	 {
		 mockMvc.perform(delete("/save/deleteEmp/{emailId}","ravsnd@yopmail.com")).andExpect(status().isOk()); 
	 }
	 
	 
}
