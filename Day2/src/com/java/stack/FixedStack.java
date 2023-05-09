package com.java.stack;

public class FixedStack implements Stack{
	private static Customer []custs=new Customer[STACK_SIZE];
	static int topOfStack;

	@Override
	public void push(Customer c) {
		// TODO Auto-generated method stub
		if(topOfStack+1>STACK_SIZE) System.out.println("stack is full");
		else {
			custs[topOfStack] = c;
			topOfStack++;
		}
	}

	@Override
	public Customer pop() {
		if(topOfStack<=0) System.out.println("stack is empty");
		else {
			topOfStack--;
			return custs[topOfStack];
		}
		return null;
		// TODO Auto-generated method stub
	}

}
