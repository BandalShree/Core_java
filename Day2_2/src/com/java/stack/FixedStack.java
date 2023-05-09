package com.java.stack;

public class FixedStack implements Stack{
	protected Customer []custs;
	protected int topOfStack;

	public FixedStack() {
		this.custs = new Customer[STACK_SIZE];
		this.topOfStack = 0;
	}

	@Override
	public void push(Customer c) throws StackOutOfBoundException{
		// TODO Auto-generated method stub
		if(topOfStack+1>STACK_SIZE) throw new StackOutOfBoundException("stack is full");
		else {
			custs[topOfStack] = c;
			topOfStack++;
		}
	}

	@Override
	public Customer pop() throws EmptyStackException{
		try {
			if(topOfStack<=0) throw new EmptyStackException("stack is empty");
			else {
				topOfStack--;
				return custs[topOfStack];
			}
		}
		finally {
			custs[topOfStack]=null;
//			for(Customer c : custs)
//				System.out.println(c);
		}
		// TODO Auto-generated method stub
	}

}
