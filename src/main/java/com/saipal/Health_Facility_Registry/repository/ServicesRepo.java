package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Services;

@Repository
public interface ServicesRepo extends JpaRepository<Services, Integer>{

	@Query("FROM Services WHERE name LIKE %?1% OR code LIKE %?1% order by orders")
	List<Services> findAllList(String search);

	
	

}
