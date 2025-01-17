package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HealthFacilityType;

@Repository
public interface HealthFacilityTypeRepo extends JpaRepository<HealthFacilityType, Integer>{

	@Query("from HealthFacilityType where type_name LIKE %?1% OR code LIKE %?1%")
	List<HealthFacilityType> findAllList(String search);

}
