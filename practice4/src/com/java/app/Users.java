package com.java.app;

public class Users {
	private String loginId,password;

	public Users(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.loginId.equals(((Users)obj).loginId) && this.password.equals(((Users)obj).password))?true:false;
	}

	public String getLoginId() {
		return loginId;
	}
	
}
