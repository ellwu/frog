package com.shnlng.frog.web.message;

import java.io.Serializable;

public class TalkReqCount implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String rid;
	private int c;
	private int t;
	private String ct;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

}
