package com.shnlng.frog.web.message;

import java.io.Serializable;
import java.util.List;

public class TalkReq implements Serializable {

	private static final long serialVersionUID = 1L;

	private String did;
	private List<TalkReqCount> counts;

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public List<TalkReqCount> getCounts() {
		return counts;
	}

	public void setCounts(List<TalkReqCount> counts) {
		this.counts = counts;
	}

}
