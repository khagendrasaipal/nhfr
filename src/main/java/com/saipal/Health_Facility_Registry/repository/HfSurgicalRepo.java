package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfSurgicalService;

@Repository
public interface HfSurgicalRepo extends JpaRepository<HfSurgicalService, Integer> {

	@Query(value="select * from hf_surgical where hf_id=?1",nativeQuery=true)
	List<HfSurgicalService> findAllByHfid(int id);

	@Query(value="select surgical_id from hf_surgical where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfId(int id);

}
