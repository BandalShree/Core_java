package com.cdac.showroom;

@SuppressWarnings("serial")
public class InvalidObject extends RuntimeException{
	public InvalidObject(String exc){
		super(exc);
	}
}
