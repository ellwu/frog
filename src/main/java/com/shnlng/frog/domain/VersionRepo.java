package com.shnlng.frog.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shnlng.frog.domain.entity.VersionEo;

public interface VersionRepo extends PagingAndSortingRepository<VersionEo, String>{
	@Query("select v from VersionEo v where v.deleteFlag = 0 and v.disableFlag = 0 and v.applyFlag = 1")
	VersionEo findApplyVersion();
}
