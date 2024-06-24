package com.example.RestApi.wrapperClass;

import org.springframework.stereotype.Component;

@Component
public class WrapperUser {

	String msg;
	Object data;
	public WrapperUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WrapperUser(String msg, Object data) {
		super();
		this.msg = msg;
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
