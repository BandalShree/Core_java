package com.java.stack;

public class GrowableStack implements Stack{
	private static Customer []custs=new Customer[STACK_SIZE];
	static int topOfStack;
	static short num=2;

	@Override
	public void push(Customer c) {
		// TODO Auto-generated method stub
		if(topOfStack+1>STACK_SIZE) {
			Customer []cust = new Customer[STACK_SIZE*num];
			for(int i=0;i<=num;i++)
				cust[i] = custs[i];
			custs = cust;
			num*=2;
		}
		custs[topOfStack] = c;
		topOfStack++;
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
