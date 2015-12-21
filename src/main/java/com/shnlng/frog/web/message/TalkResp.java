package com.shnlng.frog.web.message;

import java.io.Serializable;
import java.util.List;

public class TalkResp implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mid;
	private String mname;
	private int mmaxitems;
	private List<TalkRespItem> items;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMmaxitems() {
		return mmaxitems;
	}

	public void setMmaxitems(int mmaxitems) {
		this.mmaxitems = mmaxitems;
	}

	public List<TalkRespItem> getItems() {
		return items;
	}

	public void setItems(List<TalkRespItem> items) {
		this.items = items;
	}

}
