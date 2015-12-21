package com.shnlng.frog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ResourceSo {
	@Value("${forg.resource.clusters}")
	private String clusters;

	public List<String> popUrls(String resourceId) {

		if (StringUtils.isEmpty(clusters)) {
			return null;
		}

		String[] _cs = clusters.split(";");

		List<String> urls = new ArrayList<String>();

		if (_cs != null && _cs.length > 0) {
			for (String _c : _cs) {
				urls.add(_c + resourceId);
			}
		}
		return urls;
	}
}