package com.shnlng.frog.web.message;

import java.io.Serializable;
import java.util.List;

public class TalkRespItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rid;
	private List<String> urls;
	private String echo;
	private String aid;
	private int s;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}

}
