package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HealthFacilityLevel;

@Repository
public interface HealthFacilityLevelRepo extends JpaRepository<HealthFacilityLevel, Integer> {

	@Query("FROM HealthFacilityLevel WHERE status=1 and( parent = ?1 OR parent not in(1,2))")
	List<HealthFacilityLevel> findByType(int id);

//	@Query("FROM HealthFacilityLevel WHERE name LIKE %?1% OR code LIKE %?1%")
	@Query(value="select *,nameen as nameen from facility_level where name LIKE concat('%',?1,'%') OR code LIKE concat('%',?1,'%')",nativeQuery=true)
	List<HealthFacilityLevel> findAllList(String search);
	
//	@Query("FROM HealthFacilityLevel WHERE status=1 and( name LIKE %?1% OR code LIKE %?1%)")
	@Query(value="select *,nameen as nameen from facility_level where status=1 and ( name LIKE concat('%',?1,'%') OR code LIKE concat('%',?1,'%'))",nativeQuery=true)
	List<HealthFacilityLevel> findAllLists(String search);

}
