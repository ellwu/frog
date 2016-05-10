package com.shnlng.frog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shnlng.frog.domain.QrCountRepo;
import com.shnlng.frog.domain.ResourceRepo;
import com.shnlng.frog.domain.entity.QrCountEo;
import com.shnlng.frog.domain.entity.ResourceEo;
import com.shnlng.frog.util.IdGen;

@Service
public class ResourceSo {
	@Value("${frog.resource.clusters}")
	private String clusters;
	
	@Value("${frog.resource.echo}")
	private String echoUrl;
	
	@Autowired
	private ResourceRepo rRepo;
	
	@Autowired
	private QrCountRepo qrCntRepo;
	
	public void saveQrCount(String resourceId, String redirectUrl){
		
		QrCountEo qc = new QrCountEo();
		qc.setId(IdGen.id32());
		qc.setResourceId(resourceId);
		qc.setQrUrl(redirectUrl);
		
		qrCntRepo.save(qc);
	}
	
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