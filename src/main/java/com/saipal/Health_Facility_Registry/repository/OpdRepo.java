package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Opd;

@Repository
public interface OpdRepo extends JpaRepository<Opd, Integer> {

	@Query("FROM Opd WHERE name LIKE %?1% OR code LIKE %?1%")
	List<Opd> findAllList(String search);

}
