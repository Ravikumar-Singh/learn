package com.example.learn.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "country is mandatory")
	private String country;
	@NotNull(message = "state is mandatory")
	private String state;
	@NotNull(message = "dist is mandatory")
	private String dist;
	@NotNull(message = "pincode is mandatory")
	private String pincode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Address(@NotNull(message = "country is mandatory") String country,
			@NotNull(message = "state is mandatory") String state, @NotNull(message = "dist is mandatory") String dist,
			@NotNull(message = "pincode is mandatory") String pincode) {
		
		this.country = country;
		this.state = state;
		this.dist = dist;
		this.pincode = pincode;
	}
	
	public Address()
	{
		
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", state=" + state + ", dist=" + dist + ", pincode="
				+ pincode + "]";
	}
}
