package com.shnlng.frog.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shnlng.frog.service.ResourceSo;

@Controller
public class EchoCo {
	
	@Autowired
	private ResourceSo rSo;

	@RequestMapping(value = "/echo")
	public String echo(HttpServletRequest req, HttpServletResponse resp) {
		
		String rid = req.getParameter("rid");
		String mid = req.getParameter("mid");
		
		String redirectUrl = rSo.getRedirectUrl(rid);
		
		if(StringUtils.isEmpty(redirectUrl)){
			return "echoError";
		}
		
		rSo.saveQrCount(rid, mid, redirectUrl);
		
		try {
			resp.sendRedirect(redirectUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "echo";
	}

}
