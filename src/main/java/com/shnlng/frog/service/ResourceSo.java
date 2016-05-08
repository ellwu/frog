package com.shnlng.frog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shnlng.frog.domain.ResourceRepo;
import com.shnlng.frog.domain.entity.ResourceEo;

@Service
public class ResourceSo {
	@Value("${frog.resource.clusters}")
	private String clusters;
	
	@Value("${frog.resource.echo}")
	private String echoUrl;
	
	@Autowired
	private ResourceRepo rRepo;
	
	public String getRedirectUrl(String resourceId){
		ResourceEo r = rRepo.findOne(resourceId);
		
		if(r != null){
			return r.getRedirectUrl();
		}
		
		return null;
	}
	
	public String echoUrl(String resourceId){
		return this.echoUrl + resourceId;
	}

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