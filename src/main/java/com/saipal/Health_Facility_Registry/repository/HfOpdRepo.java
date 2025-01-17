package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.HfOpdService;


@Repository
public interface HfOpdRepo extends JpaRepository<HfOpdService, Integer> {
//	@Query(value="SELECT s.*,m.name FROM hf_services s JOIN services m ON s.service_id=m.id WHERE s.hf_id=?1",nativeQuery=true)
	@Query(value="select s.*,m.name from hf_opd s JOIN opd m ON s.opd_id=m.id where s.hf_id=?1",nativeQuery=true)
	List<HfOpdService> findAllByHfid(int id);

	@Query(value="select opd_id from hf_opd where hf_id=?1",nativeQuery=true)
	String[] findAllServiceByHfid(int id);

}
