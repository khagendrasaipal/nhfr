package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Motherhood;
import com.saipal.Health_Facility_Registry.entity.Specialized;

@Repository
public interface MotherhoodRepo extends JpaRepository<Motherhood, Integer> {

	@Query("from Motherhood where name LIKE %?1% OR code LIKE %?1%")
	List<Motherhood> findAllList(String search);
}
