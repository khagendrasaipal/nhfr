package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.ApiLog;
import com.saipal.Health_Facility_Registry.entity.HealthFacility;

@Repository
public interface ApilogRepo extends JpaRepository<ApiLog, Integer> {

	@Query(value="SELECT * from apilog where action LIKE %?1%",nativeQuery=true)
	List<ApiLog> getAllApiLogs(String search);
//	
//	@Query(value="select * FROM apilog WHERE action = ?1",countQuery = "SELECT count(*) FROM apilog",nativeQuery=true)
//	Page<ApiLog> getAllApiLogss(String search, Pageable pageable);

}
