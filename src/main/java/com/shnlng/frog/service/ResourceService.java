package com.shnlng.frog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ResourceService {

	public List<String> popUrls(String resourceId) {
		List<String> urls = new ArrayList<String>();
		urls.add("http://localhost:8080/res?rid=" + resourceId);
		return urls;
	}
}