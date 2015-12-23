package com.shnlng.frog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shnlng.frog.web.message.Version;

@Service
public class VersionSo {
	@Value("${frog.app.current.version}")
	private String currentVersion;
	
	@Value("${frog.app.current.version.name}")
	private String currentVersionName;
	
	@Value("${frog.app.repository.url}")
	private String repoUrl;
	
	public Version currentVersion(){
		return new Version(currentVersion, currentVersionName, repoUrl + currentVersion);
	}
}
