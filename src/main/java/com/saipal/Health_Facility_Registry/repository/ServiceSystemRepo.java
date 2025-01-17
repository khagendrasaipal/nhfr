package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.ServiceSystem;

@Repository
public interface ServiceSystemRepo extends JpaRepository<ServiceSystem, Integer> {

	@Query("FROM ServiceSystem WHERE name LIKE %?1% OR code LIKE %?1%")
	List<ServiceSystem> findAllList(String search);

}
