package com.shnlng.frog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shnlng.frog.web.message.Beat;

@Controller
public class BeatCo {

	@RequestMapping(value = "/beat")
	@ResponseBody
	public Beat beat(String did) {
		return new Beat();
	}

}
