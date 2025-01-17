package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfFamilyPlanningService;

@Repository
public interface HfFamilyPlanningRepo extends JpaRepository<HfFamilyPlanningService, Integer> {

	@Query(value="select * from hf_familyplanning where hf_id=?1",nativeQuery=true)
	List<HfFamilyPlanningService> findAllByHfid(int id);

	@Query(value="select family_id from hf_familyplanning where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfId(int id);

}
