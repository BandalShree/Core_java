package com.app.banking;

@SuppressWarnings("serial")
public class CustomException extends Exception{
	public CustomException(String exc) {
		super(exc);
	}
}
