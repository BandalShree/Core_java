package com.app.banking;

@SuppressWarnings("serial")
public class InvalidObject extends RuntimeException{
	public InvalidObject(String exc){
		super(exc);
	}
}
