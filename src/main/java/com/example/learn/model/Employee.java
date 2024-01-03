package com.example.learn.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Name is mandatory")
	private String name;
	@NotNull(message = "phNo is mandatory")
	private String phNo;
	@NotNull(message = "emailId is mandatory")
	private String emailId;
	@NotNull(message = "currency is mandatory")
	private String currency;
	@NotNull(message = "salary is mandatory")
	private long salary;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "adrs_id",nullable = false)
	private Address adrs;
	public Address getAdrs() {
		return adrs;
	}
	public void setAdrs(Address adrs) {
		this.adrs = adrs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public Employee()
	{
		
	}
	
	public Employee(@NotNull(message = "Name is mandatory") String name,
			@NotNull(message = "phNo is mandatory") String phNo,
			@NotNull(message = "emailId is mandatory") String emailId,
			@NotNull(message = "currency is mandatory") String currency,
			@NotNull(message = "salary is mandatory") long salary, Address adrs) {
	
		this.name = name;
		this.phNo = phNo;
		this.emailId = emailId;
		this.currency = currency;
		this.salary = salary;
		this.adrs = adrs;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phNo=" + phNo + ", emailId=" + emailId + ", currency="
				+ currency + ", salary=" + salary + ", adrs=" + adrs + "]";
	}
}
