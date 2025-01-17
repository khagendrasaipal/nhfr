package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Laboratory;

@Repository
public interface LaboratoryRepo extends JpaRepository<Laboratory, Integer>{

	@Query("from Laboratory where name LIKE %?1% OR code LIKE %?1%")
	List<Laboratory> findAllList(String search);

}
