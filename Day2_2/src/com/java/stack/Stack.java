package com.java.stack;
public interface Stack {
	int STACK_SIZE = 3;// public static final

	void push(Customer c) throws StackOutOfBoundException; // public abstract

	Customer pop() throws EmptyStackException;
}
