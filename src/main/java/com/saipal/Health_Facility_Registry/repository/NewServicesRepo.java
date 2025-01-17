package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.NewServices;
import com.saipal.Health_Facility_Registry.entity.Services;

@Repository
public interface NewServicesRepo extends JpaRepository<NewServices, Integer>{

	@Query("FROM NewServices WHERE name LIKE %?1% OR code LIKE %?1% order by orders")
	List<NewServices> findAllList(String search);

	@Query("FROM NewServices WHERE status=1 order by orders")
	List<NewServices> findAllListservice();

	
	

}
