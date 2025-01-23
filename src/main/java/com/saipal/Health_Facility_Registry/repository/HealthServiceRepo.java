package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HealthServices;
import com.saipal.Health_Facility_Registry.entity.ServiceSystem;

@Repository
public interface HealthServiceRepo extends JpaRepository<HealthServices, Integer> {

	@Query("FROM HealthServices WHERE name LIKE %?1% OR code LIKE %?1%")
	List<HealthServices> findAllList(String search);
	
//	@Query("FROM HealthServices WHERE status=1 and (name LIKE %?1% OR code LIKE %?1%)")
	@Query(value="select id,name,code,status,id as value,name as text from health_service where status=1 and  name LIKE concat('%',?1,'%') ",nativeQuery=true)
	List<HealthServices> findAllLists(String search);

}
