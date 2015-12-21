package com.shnlng.frog.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface TargetRepo extends PagingAndSortingRepository<Target, String> {

	@Query("select t from Target t where t.merchantId = :merchantId and t.status = 1 and t.beginTime <= :date and t.endTime >= :date")
	List<Target> findByMerchantId(@Param("merchantId") String merchantId, @Param("date") Date date);
}
