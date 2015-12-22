package com.shnlng.frog.web.message;

import java.io.Serializable;

public class Version implements Serializable {

	private static final long serialVersionUID = 1L;

	private String v;
	private String url;

	public Version(){}

	public Version(String v, String url){
		this.v = v;
		this.url = url;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
