package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfAyurvedService;

@Repository
public interface HfAyurvedRepo extends JpaRepository<HfAyurvedService, Integer>{

	@Query(value="select * from hf_ayurved where hf_id=?1",nativeQuery=true)
	List<HfAyurvedService> findAllByHfid(int id);

	@Query(value="select ayur_id from hf_ayurved where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfId(int id);

}
