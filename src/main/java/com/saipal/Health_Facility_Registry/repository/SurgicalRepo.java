package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Surgical;

@Repository
public interface SurgicalRepo extends JpaRepository<Surgical, Integer> {

	@Query("from Surgical where name LIKE %?1% OR code LIKE %?1%")
	List<Surgical> findAllList(String search);

}
