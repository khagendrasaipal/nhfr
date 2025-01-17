package com.saipal.Health_Facility_Registry.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Municipality;

@Repository
public interface MunicipalityRepo extends JpaRepository<Municipality, String>{
	
	@Query("FROM Municipality WHERE districtid = ?1 order by vcid")
	List<Municipality> findAllByDistrict(int id);

	 @Query(value = "select * from admin_local_level_structure where vcid=?1", nativeQuery = true)
	Optional<Municipality> findByMid(String id);

	 @Query(value = "select * from admin_local_level_structure where vcid=?1", nativeQuery = true)
	List<Municipality> findOne(String id);

}
