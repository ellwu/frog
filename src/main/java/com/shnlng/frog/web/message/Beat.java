package com.shnlng.frog.web.message;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Beat implements Serializable {

	private static final long serialVersionUID = 1L;

	private static SimpleDateFormat DATE_FORMATE = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	private String time;

	public Beat() {
		this.setTime(DATE_FORMATE.format(new Date()));
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
