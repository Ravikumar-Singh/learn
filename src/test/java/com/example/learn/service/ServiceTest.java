package com.example.learn.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.learn.model.Address;
import com.example.learn.model.Employee;
import com.example.learn.model.Response;
import com.example.learn.repository.EmployeeRepo;

@SpringBootTest
public class ServiceTest {

	@InjectMocks
	Service service;
	
	@Mock
	EmployeeRepo emprepo;
	
	@Test
	public void testSaveNewEmp()
	{
		 Address adr=new Address("INR", "KA", "RCR", "123456");
		 Employee e= new Employee("name", "1234567890", "ravi@mail.com", "INR", 1210, adr);
		 when(emprepo.save(e)).thenReturn(e);
		 Employee emp= service.saveEmployee(e);
		 assertNotNull(emp);
	}
	@Test
	public void testSaveEmp()
	{
		 Address adr=new Address("INR", "KA", "RCR", "123456");
		 Employee e= new Employee("name", "1234567890", "ravi@mail.com", "INR", 1210, adr);
		 when(emprepo.findByName(anyString())).thenReturn(e);
		 when(emprepo.save(e)).thenReturn(e);
		 Employee emp= service.saveEmployee(e);
		 assertNotNull(emp);
	}
	
	@Test
	public void getEmp()
	{
		 Address adr=new Address("INR", "KA", "RCR", "123456");
		 Employee e= new Employee("name", "1234567890", "ravi@mail.com", "INR", 1210, adr);
		
		 when(emprepo.findByEmailId("email")).thenReturn(e);
		 when(emprepo.findByPhNo("phNo")).thenReturn(e);
		service.getEmp(null, "email", null, null);
		
		service.getEmp(null, null, "phNo", null);
		 when(emprepo.findByName(anyString())).thenReturn(e);
		 Employee emp=service.getEmp("name", null, null, null);
		 assertNotNull(emp);
		
	}
	
	@Test
	public void deleteEmp()
	{
		 Address adr=new Address("INR", "KA", "RCR", "123456");
		 Employee e= new Employee("name", "1234567890", "ravi@mail.com", "INR", 1210, adr);
		 when(emprepo.findByEmailId("email")).thenReturn(e);
		Response res= service.deleteEmp("ravi@mail.com");
		 assertNotNull(res);
	}
}
