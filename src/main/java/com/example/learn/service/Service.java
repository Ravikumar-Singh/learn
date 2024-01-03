package com.example.learn.service;


import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.learn.model.Employee;
import com.example.learn.model.Response;
import com.example.learn.repository.EmployeeRepo;

@Component
public class Service {

	private static final Logger logger =  LogManager.getLogger(Service.class);

	
	@Autowired
	EmployeeRepo emprepo;
	
	public Employee saveEmployee(Employee emp)
	{
		logger.info("employee information is saving--"+emp.toString());
		Employee e =emprepo.findByEmailId(emp.getEmailId());
		if(e !=null)
		{
			e.setCurrency(emp.getCurrency());
			e.setName(emp.getName());
			e.setPhNo(emp.getPhNo());
			e.setSalary(emp.getSalary());
			return emprepo.save(e);
		}
		else
		{
		return emprepo.save(emp);
		}
	}
	
	public Employee getEmp(String name,String emailId,String phNo,Long Id)
	{
		if(name!=null && !name.isEmpty())
		{
			logger.info("fetching data by name");
		return emprepo.findByName(name);
		}
		
		if(emailId!=null && !emailId.isEmpty())
		{
			logger.info("fetching data by  emailId");
		return emprepo.findByEmailId(emailId);
		}
		
		if(phNo!=null && !phNo.isEmpty())
		{
			logger.info("fetching data by phNo");
			return emprepo.findByPhNo(phNo);
		}
		
		if(Id!=0)
		{
			logger.info("fetching data by  id");
			return emprepo.findById(Id).get();
		}
		logger.info("returning null due to invalid input");
		return null;
	}
	
	public Response deleteEmp(String emailId)
	{
		Employee emp = emprepo.findByEmailId(emailId);
		Response response;
		if (emp == null) {
			response = new Response("invalid Employee", "OK");
		} else {
			emprepo.delete(emp);
			logger.info("employee deleted");
			response = new Response("Employee deleted", "OK");
		}
		return response;
	}
	
	
}
