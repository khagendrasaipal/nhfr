package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfSpecializedService;

@Repository
public interface HfSpecializedRepo extends JpaRepository<HfSpecializedService, Integer>{

	@Query(value="select * from hf_specialized where hf_id=?1",nativeQuery=true)
	List<HfSpecializedService> findAllByHfid(int id);

	@Query(value="select specialized_id from hf_specialized where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfId(int id);

}
