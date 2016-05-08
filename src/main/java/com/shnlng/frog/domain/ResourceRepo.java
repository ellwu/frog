package com.shnlng.frog.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shnlng.frog.domain.entity.ResourceEo;


public interface ResourceRepo extends PagingAndSortingRepository<ResourceEo, String> {
	
}
