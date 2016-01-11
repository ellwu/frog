package com.shnlng.frog.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.shnlng.frog.domain.entity.TargetEo;

public interface TargetRepo extends PagingAndSortingRepository<TargetEo, String> {

	@Query("select t from TargetEo t where t.merchantId = :merchantId and t.status = 1 and t.deleteFlag = 0 and t.disableFlag = 0 and t.beginTime <= :date and t.endTime >= :date")
	List<TargetEo> findByMerchantId(@Param("merchantId") String merchantId, @Param("date") Date date);
}
