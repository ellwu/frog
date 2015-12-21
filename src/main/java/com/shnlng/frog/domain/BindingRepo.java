package com.shnlng.frog.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface BindingRepo extends PagingAndSortingRepository<Binding, String>{
	
	@Query("select b from Binding b where b.deviceId = :deviceId and b.deleteFlag = 0 and b.disableFlag = 0 and b.status = 1")
	Binding findByDeviceId(@Param("deviceId") String deviceId);
}
