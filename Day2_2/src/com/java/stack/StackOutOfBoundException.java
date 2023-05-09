package com.java.stack;

@SuppressWarnings("serial")
public class StackOutOfBoundException extends Exception{
	public StackOutOfBoundException(String errMsg) {
		super(errMsg);
	}
}
