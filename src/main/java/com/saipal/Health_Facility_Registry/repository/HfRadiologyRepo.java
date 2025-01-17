package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfRadiologyService;

@Repository
public interface HfRadiologyRepo extends JpaRepository<HfRadiologyService, Integer> {

	@Query(value="select * from hf_radiology where hf_id=?1",nativeQuery=true)
	List<HfRadiologyService> findAllByHfid(int id);

	@Query(value="select radiology_id from hf_radiology where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfId(int id);

}
