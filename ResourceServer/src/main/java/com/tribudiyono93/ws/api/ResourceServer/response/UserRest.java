package com.tribudiyono93.ws.api.ResourceServer.response;

public class UserRest {
	private String userFirstname;
	private String userLastname;
	private String userId;
	
	
	public UserRest(String userFirstname, String userLastname, String userId) {
		super();
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.userId = userId;
	}
	
	public String getUserFirstname() {
		return userFirstname;
	}
	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}
	public String getUserLastname() {
		return userLastname;
	}
	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
