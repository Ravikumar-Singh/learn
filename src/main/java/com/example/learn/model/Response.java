package com.example.learn.model;

public class Response {

	private String response;
	private String status;
	public Response()
	{
		
	}
	public Response(String response, String status) {
		this.response = response;
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
