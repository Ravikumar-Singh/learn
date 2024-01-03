package com.example.learn.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn.model.Employee;
import com.example.learn.model.Response;
import com.example.learn.service.Service;

@RestController
@RequestMapping("/save")
public class Controller {

	@Autowired
	Service service;
	
	@PostMapping(name = "/saveEmployee")
	public Employee saveEmployee(@Valid @RequestBody Employee emp)
	{
		return service.saveEmployee(emp);
	}
	
	@GetMapping("/getEmp")
	public Object getEmp(@RequestParam(name= "name",required = false) String name,@RequestParam(name= "emailId",required = false) String emailId
			,@RequestParam(name= "phNo",required = false) String phNo,@RequestParam(name= "id",required = false) Long id
			) throws Exception
	{
		Employee e= service.getEmp(name, emailId, phNo, id);
		if(e==null)
		{
			return new Response("employee not found","ok");
		}
		return e;
	}
	
	@DeleteMapping("/deleteEmp/{emailId}")
	public Response deleteEmp(@PathVariable("emailId") String emailId)
	{
		return service.deleteEmp(emailId);
	}
	
	
}
