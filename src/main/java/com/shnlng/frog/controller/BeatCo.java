package com.shnlng.frog.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeatCo {
	@RequestMapping(value = "/beat", method = RequestMethod.GET)
	@ResponseBody
	public String beat() {
		return new Date().toString();
	}

}
