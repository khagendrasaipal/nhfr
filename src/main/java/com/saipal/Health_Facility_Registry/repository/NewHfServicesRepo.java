package com.saipal.Health_Facility_Registry.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfServices;
import com.saipal.Health_Facility_Registry.entity.NewHfServices;

@Repository
public interface NewHfServicesRepo extends JpaRepository<NewHfServices, Integer>{
	
	@Query(value="SELECT s.*,m.name FROM new_hf_services s JOIN new_services m ON s.service_id=m.id WHERE s.hf_id=?1 order by m.orders",nativeQuery=true)
//	@Query("FROM HfServices WHERE hf_id = ?1")
	List<NewHfServices> findAllByHfid(int id);
	
	@Query(value="SELECT s.*,m.name FROM hf_services s JOIN services m ON s.service_id=m.id WHERE s.hf_id=?1 and s.service_id not in(20,27,12,9,42,43,44,52)",nativeQuery=true)
//	@Query("FROM HfServices WHERE hf_id = ?1")
	List<NewHfServices> findAllByHfidSearch(int id);

	@Query(value="select service_id from hf_services where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfid(int id);
	
	@Query(value="select service_id from new_hf_services where hf_id=?1",nativeQuery=true)
	String[] findAllNewServiceByHfid(int id);

	@Query(value="select service_id from new_hf_services where hf_id=?1",nativeQuery=true)
	List<NewHfServices> findAllNewServiceByHfids(int id);
	
	@Query(value="select service_id from hf_healthservice where hf_id=?1",nativeQuery=true)
	List<Map<String, Object>> findAllhfserviceHfid(int id);

}
