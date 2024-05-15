package com.spring.exception;

import java.sql.Date;



public class ErrorDetails  {
	private Date timestamp;
	private String Mesage;
	private String details;
	public ErrorDetails(Date timestamp, String mesage,String details) {
		super();
		this.timestamp = timestamp;
		Mesage = mesage;
		this.details=details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMesage() {
		return Mesage;
	}
	public void setMesage(String mesage) {
		Mesage = mesage;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDetails() {
		return details;
	}
	

}
