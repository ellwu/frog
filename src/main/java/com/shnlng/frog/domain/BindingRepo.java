package com.shnlng.frog.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.shnlng.frog.domain.entity.BindingEo;

public interface BindingRepo extends PagingAndSortingRepository<BindingEo, String>{
	
	@Query("select b from BindingEo b where b.deviceId = :deviceId and b.deleteFlag = 0 and b.disableFlag = 0 and b.status = 1")
	BindingEo findByDeviceId(@Param("deviceId") String deviceId);
}
