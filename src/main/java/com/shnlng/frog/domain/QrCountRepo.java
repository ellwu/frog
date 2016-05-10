package com.shnlng.frog.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shnlng.frog.domain.entity.QrCountEo;

public interface QrCountRepo extends PagingAndSortingRepository<QrCountEo, String>{
}
