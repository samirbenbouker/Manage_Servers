package com.samirbenbouker.server.model;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class Response {
	
	protected LocalDate timeStap;
	protected int statusCodee;
	protected HttpStatus status;
	protected String reason;
	protected String message;
	protected String developerMessage;
	protected Map<?,?> data;
	
	public Response() {}
	
	public Response(LocalDate timeStap, int statusCodee, HttpStatus status, String reason, String message,
			String developerMessage, Map<?, ?> data) {
		super();
		this.timeStap = timeStap;
		this.statusCodee = statusCodee;
		this.status = status;
		this.reason = reason;
		this.message = message;
		this.developerMessage = developerMessage;
		this.data = data;
	}
	
	public LocalDate getTimeStap() {
		return timeStap;
	}
	
	public void setTimeStap(LocalDate timeStap) {
		this.timeStap = timeStap;
	}
	
	public int getStatusCodee() {
		return statusCodee;
	}
	
	public void setStatusCodee(int statusCodee) {
		this.statusCodee = statusCodee;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDeveloperMessage() {
		return developerMessage;
	}
	
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	
	public Map<?, ?> getData() {
		return data;
	}
	
	public void setData(Map<?, ?> data) {
		this.data = data;
	}
	
	

}
