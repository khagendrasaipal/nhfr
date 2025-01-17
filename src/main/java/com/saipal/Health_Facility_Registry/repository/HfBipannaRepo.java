package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfBipannaService;

@Repository
public interface HfBipannaRepo extends JpaRepository<HfBipannaService, Integer> {

	@Query(value="select * from hf_bipanna where hf_id=?1",nativeQuery=true)
	List<HfBipannaService> findAllByHfid(int id);

	@Query(value="select bipanna_id from hf_bipanna where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfId(int id);

}
