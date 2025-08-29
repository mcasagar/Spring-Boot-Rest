package com.sb.exception;

public class TravellerNotFoundException extends RuntimeException {
	public TravellerNotFoundException() {
		super();
	}
	
	public TravellerNotFoundException(String msg) {
		super(msg);
	}
}
