package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfMotherhoodService;

@Repository
public interface HfMotherhoodRepo extends JpaRepository<HfMotherhoodService, Integer> {

	@Query(value="select * from hf_motherhood where hf_id=?1",nativeQuery=true)
	List<HfMotherhoodService> findAllByHfid(int id);

	@Query(value="select mother_id from hf_motherhood where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfId(int id);

}
