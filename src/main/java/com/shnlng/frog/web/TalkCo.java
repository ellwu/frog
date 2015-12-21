package com.shnlng.frog.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shnlng.frog.service.TalkService;
import com.shnlng.frog.web.message.TalkReq;
import com.shnlng.frog.web.message.TalkResp;

@Controller
public class TalkCo {
	private static final Logger logger = Logger.getLogger(TalkCo.class);
	
	@Autowired
	private TalkService talkSo;

	@RequestMapping(value = "/talk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public TalkResp talk(@RequestBody TalkReq talkReq) {
		logger.debug("enter talk");
		
		TalkResp resp = null;

		boolean talkReqNeedProcess = talkReq != null;

		if (talkReqNeedProcess) {

			boolean hasCounts = talkReq.getCounts() != null && talkReq.getCounts().size() > 0;

			if (hasCounts) {
				talkSo.saveCounts(talkReq);
			}
			
			resp = talkSo.replyTalk(talkReq);
		}

		logger.debug("leave talk");
		return resp;
	}

	
}
