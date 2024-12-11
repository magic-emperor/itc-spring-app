package com.itc.app.Dto;

public class itcAuthResponse {
	private String Jwt;

	public itcAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public itcAuthResponse(String jwt) {
		super();
		Jwt = jwt;
	}

	public String getJwt() {
		return Jwt;
	}

	public void setJwt(String jwt) {
		Jwt = jwt;
	}
	
	
}
