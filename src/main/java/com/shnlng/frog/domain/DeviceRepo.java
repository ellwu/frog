package com.shnlng.frog.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.shnlng.frog.domain.entity.DeviceEo;

public interface DeviceRepo extends PagingAndSortingRepository<DeviceEo, String>{
	
	@Query("select d from DeviceEo d where d.sn = :sn and d.deleteFlag = 0 and d.disableFlag = 0 and d.status = 1 and d.bindStatus = 1")
	DeviceEo findBySn(@Param("sn") String sn);
}
