package com.java.stack;

public class GrowableStack extends FixedStack{
	private short num;
	
	public GrowableStack() {
		this.num = 2;
	}
	@Override
	public void push(Customer c) {
		// TODO Auto-generated method stub
		if(topOfStack+1>STACK_SIZE) {
			Customer []cust = new Customer[STACK_SIZE*num];
			for(int i=0;i<=this.num;i++)
				cust[i] = custs[i];
			custs = cust;
			this.num*=2;
		}
		custs[topOfStack] = c;
		topOfStack++;
	}
}
