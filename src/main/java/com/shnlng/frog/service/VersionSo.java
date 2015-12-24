package com.shnlng.frog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shnlng.frog.domain.VersionRepo;
import com.shnlng.frog.domain.entity.VersionEo;
import com.shnlng.frog.web.message.Version;

@Service
public class VersionSo {

	@Autowired
	private VersionRepo vRepo;

	public Version currentVersion() {
		VersionEo versionApply = vRepo.findApplyVersion();

		if (versionApply == null) {
			return null;
		}

		Version v = new Version(versionApply.getCode() + "", versionApply.getName(), versionApply.getUrl());

		return v;
	}
}
