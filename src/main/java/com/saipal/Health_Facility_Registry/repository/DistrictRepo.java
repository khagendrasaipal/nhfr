package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.District;

@Repository
public interface DistrictRepo extends JpaRepository<District, Integer> {

	@Query("FROM District WHERE provinceid = ?1 order by districtid")
	List<District> findAllByProvince(int id);

}
