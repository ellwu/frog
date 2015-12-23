package com.shnlng.frog.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shnlng.frog.service.TalkSo;
import com.shnlng.frog.web.message.TalkReq;
import com.shnlng.frog.web.message.TalkResp;

@Controller
public class TalkCo {
	private static final Logger logger = Logger.getLogger(TalkCo.class);

	@Autowired
	private TalkSo talkSo;

	@ResponseBody
	public TalkResp talk2(@RequestBody TalkReq talkReq) {
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

	@RequestMapping(value = "/talk")
	@ResponseBody
	public TalkResp talk(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("enter talk");

		BufferedReader br = null;
		StringBuilder jsonReq = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(req.getInputStream()));
			while ((line = br.readLine()) != null) {
				jsonReq.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		logger.debug("talk request: " + jsonReq.toString());

		ObjectMapper mapper = new ObjectMapper();

		TalkReq talkReq = null;

		try {

			talkReq = mapper.readValue(jsonReq.toString(), TalkReq.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		if (talkReq == null) {
			return null;
		}

		TalkResp respTalk = null;

		boolean talkReqNeedProcess = talkReq != null;

		if (talkReqNeedProcess) {

			boolean hasCounts = talkReq.getCounts() != null && talkReq.getCounts().size() > 0;

			if (hasCounts) {
				talkSo.saveCounts(talkReq);
			}

			respTalk = talkSo.replyTalk(talkReq);
		}

		logger.debug("leave talk");
		return respTalk;
	}

}
