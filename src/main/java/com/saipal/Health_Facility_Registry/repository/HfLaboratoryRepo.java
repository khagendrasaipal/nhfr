package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfLaboratoryService;

@Repository
public interface HfLaboratoryRepo extends JpaRepository<HfLaboratoryService, Integer>{

	@Query(value="select * from hf_laboratory where hf_id=?1",nativeQuery=true)
	List<HfLaboratoryService> findAllByHfid(int id);

	@Query(value="select laboratory_id from hf_laboratory where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfId(int id);

}
