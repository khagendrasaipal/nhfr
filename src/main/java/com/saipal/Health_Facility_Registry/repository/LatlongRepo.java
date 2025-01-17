package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.LatLong;
@Repository
public interface LatlongRepo extends JpaRepository<LatLong, Integer> {

	@Query("from LatLong where hfname LIKE %?1% and id<=2050 and id>=2027")
	List<LatLong> findAllList(String search);

}
