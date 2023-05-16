package com.java.app;

public class Order {
	private Integer orderId, petId,quantity;
	private Status status;
	private static Integer id=1;
	
	public enum Status{
		PLACED, IN_PROCESS, COMPLETED
	}
	
	public Order(Integer petId, Integer quantity) {
		super();
		this.orderId = id++;
		this.petId = petId;
		this.quantity = quantity;
		this.status = Status.PLACED;
	}
	
	public Order(Integer petId, Integer quantity,Status status) {
		super();
		this.orderId = id++;
		this.petId = petId;
		this.quantity = quantity;
		this.status = status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Pet pet = new Pet(((Order)obj).orderId);
		return this.orderId.equals(((Order)obj).orderId) && pet.getStocks()>=this.quantity;
	}
	
	
}
