package com.shnlng.frog.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shnlng.frog.domain.entity.CountEo;

public interface CountRepo extends PagingAndSortingRepository<CountEo, String>{
}
