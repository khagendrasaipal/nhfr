package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Ownership;

@Repository
public interface OwnershipRepo extends JpaRepository<Ownership, Integer> {

	@Query("FROM Ownership WHERE parent_id = ?1 and status=1")
	List<Ownership> findByType(int id);

	@Query("FROM Ownership WHERE status=1 and (name LIKE %?1% OR code LIKE %?1%)")
	List<Ownership> findAllList(String search);

}
