package com.saipal.Health_Facility_Registry.repository;


import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.ApiExchange;
import com.saipal.Health_Facility_Registry.entity.HealthFacility;
import com.saipal.Health_Facility_Registry.entity.Users;

@Repository
public interface HealthFacilityRepo extends PagingAndSortingRepository<HealthFacility, Integer> {
	

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  LEFT JOIN admin_local_level_structure mu ON p.municipality=mu.vcid WHERE p.soft_delete=0 and ( p.hf_name LIKE %?1% OR p.hf_code LIKE %?1% OR mu.nameen LIKE %?1%) ",nativeQuery=true)
	List<HealthFacility> findAllList(String search);
	
	@Query(value="SELECT p.*,services.name FROM hfregistry p LEFT JOIN hf_services on hf_services.hf_id=p.id  LEFT JOIN services on services.id=hf_services.service_id LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id LEFT JOIN admin_local_level_structure mu ON p.municipality=mu.vcid WHERE p.soft_delete=0 and ( p.hf_name LIKE %?1% OR p.hf_code LIKE %?1% OR mu.nameen LIKE %?1%) ",nativeQuery=true)
	List<HealthFacility> getFacilityTypeExcel(String search);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE p.soft_delete=0 and ( p.hf_name LIKE %?1% OR p.hf_code LIKE %?1%) and (p.opstatus  in('Functional','') or p.opstatus is null) ",nativeQuery=true)
	List<HealthFacility> findAllListDash(String search);

	@Query("FROM HealthFacility WHERE municipality = ?1 AND ucode=(select max(ucode) from HealthFacility where municipality=?1)")
	List<HealthFacility> findCodes(String id);
	
	@Query(value="SELECT p.*,st.name as ftypes FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id join service_type st on st.id=p.ftype LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id=?1",nativeQuery=true)
	List<HealthFacility> editonline(String id);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into new_hf_services(hf_id,service_id) VALUES (:lid,:s)", nativeQuery = true)
	void addNewServices(int lid, String s);
	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_remarks(hf_id,remarks) VALUES (:lid,:s)", nativeQuery = true)
	void addRemarks(int lid, String s);
	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_healthservice(hf_id,service_id) VALUES (:lid,:s)", nativeQuery = true)
	void inserthealthservice(int lid, String s);
	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_deviceinfo(hf_id,dname,dsource,remarks) VALUES (:lid,:dname,:dsource,:remarks)", nativeQuery = true)
	void addDevice(int lid, String dname,String dsource,String remarks);
	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_ownerinfo(hf_id,fullname,address,citizenship,mobile,email) VALUES (:lid,:oname,:oaddress,:ctzn,:mbl,:email)", nativeQuery = true)
	void addOwner(int lid, String oname,String oaddress,String ctzn,String mbl,String email);
	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_services(hf_id,service_id) VALUES (:lid,:s)", nativeQuery = true)
	void addServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_services(hf_id,service_id,removed_date) VALUES (?1,?2,NULL)", nativeQuery = true)
	void addHistoryServices(int lid, String s);
	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into new_history_services(hf_id,service_id,removed_date) VALUES (?1,?2,NULL)", nativeQuery = true)
	void addNewHistoryServices(int lid, String s);
	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_opd(hf_id,opd_id) VALUES (:lid,:s)", nativeQuery = true)
	void addOpdServices(int lid, String s);

	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_opd(hf_id,opd_id,removed_date) VALUES (:lid,:s,NULL)", nativeQuery = true)
	void addOpdHistoryServices(int lid, String s);

	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_surgical(hf_id,surgical_id) VALUES (:lid,:s)", nativeQuery = true)
	void addSurgicalServices(int lid, String s);

	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_surgical(hf_id,surgical_id,removed_date) VALUES (:lid,:s,NULL)", nativeQuery = true)
	void addSurgicalHistoryServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_specialized(hf_id,specialized_id) VALUES (:lid,:s)", nativeQuery = true)
	void addSpeicalServices(int lid, String s);

	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_specialized(hf_id,specialized_id,removed_date) VALUES (:lid,:s,NULL)", nativeQuery = true)
	void addspecialHistoryServices(int lid, String s);

	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_laboratory(hf_id,laboratory_id) VALUES (:lid,:s)", nativeQuery = true)
	void addLabServices(int lid, String s);

	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_laboratory(hf_id,laboratory_id,removed_date) VALUES (:lid,:s,NULL)", nativeQuery = true)
	void addLabHistoryServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_radiology(hf_id,radiology_id) VALUES (:lid,:s)", nativeQuery = true)
	void addRadioServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_radiology(hf_id,radiology_id,removed_date) VALUES (:lid,:s,NULL)", nativeQuery = true)
	void addRadioHistoryServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_bipanna(hf_id,bipanna_id) VALUES (:lid,:s)", nativeQuery = true)
	void addFreeServices(int lid, String s);

	
	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_bipanna(hf_id,bipanna_id,removed_date) VALUES (:lid,:s,NULL)", nativeQuery = true)
	void addFreeHistoryServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_ayurved(hf_id,ayur_id) VALUES (:lid,:s)", nativeQuery = true)
	void addAyurServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_ayurved(hf_id,ayur_id,removed_date) VALUES (:lid,:s,NULL)", nativeQuery = true)
	void addAyurHistoryServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_familyplanning(hf_id,family_id) VALUES (:lid,:s)", nativeQuery = true)
	void addFamilyServices(int lid, String s);
	

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_familyplanning(hf_id,family_id,removed_date) VALUES (:lid,:s,NULL)", nativeQuery = true)
	void addFamilyHistoryServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into hf_motherhood(hf_id,mother_id) VALUES (:lid,:s)", nativeQuery = true)
	void addMotherServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_motherhood(hf_id,mother_id,removed_date) VALUES (:lid,:s,NULL)", nativeQuery = true)
	void addMotherHistoryServices(int lid, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_services where hf_id=?1 AND service_id=?2",nativeQuery=true)
	void deleteService(int id, String s);
	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from new_hf_services where hf_id=?1 AND service_id=?2",nativeQuery=true)
	void deleteNewService(int id, String s);
	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_healthservice where hf_id=?1 ",nativeQuery=true)
	void deletehealthService(int id);
	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_deviceinfo where hf_id=?1 ",nativeQuery=true)
	void deletedevice(int id);
	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_ownerinfo where hf_id=?1 ",nativeQuery=true)
	void deleteowner(int id);
	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from tbl_employee_import where importid=?1 ",nativeQuery=true)
	void deleteWorker(int id);
	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update hfregistry set soft_delete=0 , onlinestatus=2 , approveby=?1 , approvedate=CURRENT_TIMESTAMP  where id=?2",nativeQuery=true)
	void approve(String username,int id);
	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update hfregistry set  onlinestatus=3 , approveby=?1 , approvedate=CURRENT_TIMESTAMP  where id=?2",nativeQuery=true)
	void reject(String username,int id);

	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_services set removed_date=Default(removed_date) where hf_id=?1 AND service_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateHistoryServices(int id, String s, Timestamp timestamp);
	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update new_history_services set removed_date=Default(removed_date) where hf_id=?1 AND service_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateNewHistoryServices(int id, String s, Timestamp timestamp);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_opd where hf_id=?1 AND opd_id=?2",nativeQuery=true)
	void deleteOpdService(int id, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_opd set removed_date=Default(removed_date) where hf_id=?1 AND opd_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateOpdHistoryServices(int id, String s, Timestamp timestamp);
	
	
	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update hfregistry set soft_delete=1 where id=?1",nativeQuery=true)
	void updateOnline(int id);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_surgical where hf_id=?1 AND surgical_id=?2",nativeQuery=true)
	void deleteSurgicalService(int id, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_surgical set removed_date=Default(removed_date) where hf_id=?1 AND surgical_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateSurgicalHistoryServices(int id, String s, Timestamp timestamp);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_specialized where hf_id=?1 AND specialized_id=?2",nativeQuery=true)
	void deleteSpecialService(int id, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_specialized set removed_date=Default(removed_date) where hf_id=?1 AND specialized_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateSpecialHistoryServices(int id, String s, Timestamp timestamp);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_laboratory where hf_id=?1 AND laboratory_id=?2",nativeQuery=true)
	void deleteLabService(int id, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_laboratory set removed_date=Default(removed_date) where hf_id=?1 AND laboratory_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateLabHistoryServices(int id, String s, Timestamp timestamp);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_radiology where hf_id=?1 AND radiology_id=?2",nativeQuery=true)
	void deleteRadioService(int id, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_radiology set removed_date=Default(removed_date) where hf_id=?1 AND radiology_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateRadioHistoryServices(int id, String s, Timestamp timestamp);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_bipanna where hf_id=?1 AND bipanna_id=?2",nativeQuery=true)
	void deleteFreeService(int id, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_bipanna set removed_date=Default(removed_date) where hf_id=?1 AND bipanna_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateFreeHistoryServices(int id, String s, Timestamp timestamp);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_ayurved where hf_id=?1 AND ayur_id=?2",nativeQuery=true)
	void deleteAyurService(int id, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_ayurved set removed_date=Default(removed_date) where hf_id=?1 AND ayur_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateAyurHistoryServices(int id, String s, Timestamp timestamp);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_familyplanning where hf_id=?1 AND family_id=?2",nativeQuery=true)
	void deleteFamilyService(int id, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_familyplanning set removed_date=Default(removed_date) where hf_id=?1 AND family_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateFamilyHistoryServices(int id, String s, Timestamp timestamp);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from hf_motherhood where hf_id=?1 AND mother_id=?2",nativeQuery=true)
	void deleteMotherService(int id, String s);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_motherhood set removed_date=Default(removed_date) where hf_id=?1 AND mother_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateMotherHistoryServices(int id, String s, Timestamp timestamp);

	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE p.soft_delete=0 and p.district=?1",nativeQuery=true)
	List<HealthFacility> findListByDist(int district);

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE p.soft_delete=0 and p.district=?1 AND p.municipality=?2 AND p.type=?3 AND p.level=?4 AND p.id in(select hf_id from hf_services where service_id=?5)",nativeQuery=true)
	List<HealthFacility> getFacility(int district, String palika, int authority, int type, int service);

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE p.soft_delete=0 and p.district=?1 AND p.municipality=?2 AND p.type=?3 AND p.level=?4",nativeQuery=true)
	List<HealthFacility> getFacility(int district, String palika, int authority, int type);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE p.soft_delete=0 and p.district=?1 AND p.municipality=?2 AND p.type=?3",nativeQuery=true)
	List<HealthFacility> getFacility(int district, String palika, int authority);

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE p.soft_delete=0 and p.municipality=?1",nativeQuery=true)
	List<HealthFacility> getFacility(String palika);

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.district=?1",nativeQuery=true)
	List<HealthFacility> getFacility(int district);

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE p.soft_delete=0 and p.province=?1",nativeQuery=true)
	List<HealthFacility> getFacilityByProvince(int province);

//	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.hf_name LIKE %?1% p.?2=?3 ",nativeQuery=true)
//	List<HealthFacility> findAllHFList(String search,String roles, String rvalues);

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and (p.hf_name LIKE %?1% or p.hf_code LIKE %?1% ) AND p.province=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.province=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",nativeQuery=true)
	Page<HealthFacility> findAllHFListByProvince(String search, String rvalues,Integer uid, Pageable pageable);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.level in(37,40,41,43,44,45,46,48,49,50,65,66) and (p.hf_name LIKE %?1% or p.hf_code LIKE %?1% ) AND p.province=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.province=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",nativeQuery=true)
	Page<HealthFacility> findAllHFListByProvinceBed(String search, String rvalues,Integer uid, Pageable pageable);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=1 and p.onlinestatus=1 and p.submitto=2 and (p.hf_name LIKE %?1% or p.hf_code LIKE %?1% ) AND p.province=?2 ",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=1 and p.onlinestatus=1 and p.submitto=2 and p.hf_name LIKE %?1% AND p.province=?2",nativeQuery=true)
	Page<HealthFacility> findAllHFListByProvinceOnline(String search, String rvalues,Integer uid, Pageable pageable);
	
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.province=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",nativeQuery=true)
	List<HealthFacility> findAllHFListByProvince(String search, String rvalues,Integer uid);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.province=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3) and (p.opstatus not in('Non-Functional','Closed') or p.opstatus is null)",nativeQuery=true)
	List<HealthFacility> findAllHFListByProvinceDash(String search, String rvalues,Integer uid);

	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.municipality=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3) ",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.municipality=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3) ",nativeQuery=true)
	Page<HealthFacility> findAllHFListByPalika(String search, String rvalues,Integer uid,Pageable pageable);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.level in(37,40,41,43,44,45,46,48,49,50,65,66) and p.hf_name LIKE %?1% AND p.municipality=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3) ",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.municipality=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3) ",nativeQuery=true)
	Page<HealthFacility> findAllHFListByPalikaBed(String search, String rvalues,Integer uid,Pageable pageable);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.id=?2  ",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.id=?2  ",nativeQuery=true)
	Page<HealthFacility> findAllHFListByHF(String search, String rvalues,Integer uid,Pageable pageable);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=1 and p.onlinestatus=1 and p.submitto=4 and p.hf_name LIKE %?1% AND p.municipality=?2  ",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=1 and p.onlinestatus=1 and p.submitto=4 and p.hf_name LIKE %?1% AND p.municipality=?2  ",nativeQuery=true)
	Page<HealthFacility> findAllHFListByPalikaOnline(String search, String rvalues,Integer uid,Pageable pageable);
	
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.municipality=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3) ",nativeQuery=true)
	List<HealthFacility> findAllHFListByPalika(String search, String rvalues,Integer uid);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.municipality=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3) and (p.opstatus not in('Non-Functional','Closed') or p.opstatus is null) ",nativeQuery=true)
	List<HealthFacility> findAllHFListByPalikaDash(String search, String rvalues,Integer uid);

	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.district=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",countQuery="SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.district=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",nativeQuery=true)
	Page<HealthFacility> findAllHFListByDistrict(String search, String rvalues,Integer uid,Pageable pageable);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.level in (37,40,41,43,44,45,46,48,49,50,65,66) and p.hf_name LIKE %?1% AND p.district=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",countQuery="SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.district=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",nativeQuery=true)
	Page<HealthFacility> findAllHFListByDistrictBed(String search, String rvalues,Integer uid,Pageable pageable);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=1 and p.onlinestatus=1 and p.submitto=3 and p.hf_name LIKE %?1% AND p.district=?2 ",countQuery="SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=1 and p.onlinestatus=1 and p.submitto=3 and p.hf_name LIKE %?1% AND p.district=?2 ",nativeQuery=true)
	Page<HealthFacility> findAllHFListByDistrictOnline(String search, String rvalues,Integer uid,Pageable pageable);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.district=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3)",nativeQuery=true)
	List<HealthFacility> findAllHFListByDistrict(String search, String rvalues,Integer uid);
	
	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.hf_name LIKE %?1% AND p.district=?2 and p.id NOT IN(select hfid from user_hf_access where userid=?3) and (p.opstatus not in('Non-Functional','Closed') or p.opstatus is null) ",nativeQuery=true)
	List<HealthFacility> findAllHFListByDistrictDash(String search, String rvalues,Integer uid);

	@Query(value="select password from users where username=?1",nativeQuery=true)
	String findOne(String username);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update users set password=?2 where username=?1",nativeQuery=true)
	int updatePasswords(String username, String newpass);

	@Query(value="select count(id) from apiusers where token=?1",nativeQuery=true)
	String findApiuser(String token);

	@Query(value="select cbscode,ucode FROM hfregistry WHERE municipality = ?1 AND ucode=(select max(ucode) from hfregistry where municipality=?1)",nativeQuery=true)
	String[] findCodess(String munc);

	@Query("FROM HealthFacility WHERE hf_code = ?1")
	List<HealthFacility> findHfbycode(BigInteger code);

	@Query(value="select * FROM hfregistry WHERE province = ?1",countQuery = "SELECT count(*) FROM hfregistry WHERE province = ?1",nativeQuery=true)
	Page<HealthFacility> findByProvince(int province, Pageable pageable);

	@Query(value="select * FROM hfregistry WHERE district = ?1",countQuery = "SELECT count(*) FROM hfregistry WHERE district = ?1",nativeQuery=true)
	Page<HealthFacility> findByDistrict(int district, Pageable pageable);

	@Query(value="select * FROM hfregistry WHERE municipality = ?1",countQuery = "SELECT count(*) FROM hfregistry WHERE municipality = ?1",nativeQuery=true)
	Page<HealthFacility> findByPalika(String municipality, Pageable pageable);

	@Query(value="select * FROM hfregistry WHERE  hf_name LIKE %?1% OR hf_code LIKE %?1%",countQuery = "SELECT count(*) FROM hfregistry WHERE hf_name LIKE %?1% OR hf_code LIKE %?1%",nativeQuery=true)
	Page<HealthFacility> findBySearch(String searchKeyword, Pageable pageable);

	@Query(value="select count(id) as pcount from hfregistry  where soft_delete=0 group by province order by province",nativeQuery=true)
	String[] getPcount();
	
	@Query(value="select count(id) as pcount from hfregistry where type=1 and soft_delete=0 group by province order by province ",nativeQuery=true)
	String[] getGcount();
	
	@Query(value="select count(id) as pcount from hfregistry where authlevel='Federal' and soft_delete=0 group by province order by province ",nativeQuery=true)
	String[] getFcount();
	
	@Query(value="select count(id) as pcount from hfregistry join admin_province on admin_province.pid=hfregistry.province where authlevel='Provincial' and soft_delete=0 group by province order by province ",nativeQuery=true)
	String[] getPcCount();
	
	@Query(value="select count(id) as pcount from hfregistry where authlevel='Local' and soft_delete=0 group by province order by province ",nativeQuery=true)
	String[] getLcCount();
	
	@Query(value="select count(id) as pcount from hfregistry  where type=2 and soft_delete=0 group  by province order by province",nativeQuery=true)
	String[] getNgcCount();

	@Query(value="select count(id) as pcount from hfregistry  where province=?1 and soft_delete=0 group by district order by district",nativeQuery=true)
	String[] getDcount(int id);

	@Query(value="select count(id) as pcount from hfregistry  where province=?1 and type=1 and soft_delete=0 group by district order by district",nativeQuery=true)
	String[] getDGcount(int id);
	
	@Query(value="SELECT COUNT(hfregistry.id) AS pcount FROM admin_district LEFT JOIN hfregistry ON hfregistry.district = admin_district.districtid AND hfregistry.authlevel = 'Federal' AND hfregistry.soft_delete = 0 WHERE admin_district.provinceid = ?1 GROUP BY admin_district.districtid ORDER BY admin_district.districtid;",nativeQuery=true)
	String[] getDfcount(int id);
	
	@Query(value="SELECT COUNT(hfregistry.id) AS pcount FROM admin_district LEFT JOIN hfregistry ON hfregistry.district = admin_district.districtid AND hfregistry.authlevel = 'Provincial' AND hfregistry.soft_delete = 0 WHERE admin_district.provinceid = ?1 GROUP BY admin_district.districtid ORDER BY admin_district.districtid",nativeQuery=true)
	String[] getDpcCount(int id);
	
	@Query(value="SELECT COUNT(hfregistry.id) AS pcount FROM admin_district LEFT JOIN hfregistry ON hfregistry.district = admin_district.districtid AND hfregistry.authlevel = 'Local' AND hfregistry.soft_delete = 0 WHERE admin_district.provinceid = ?1 GROUP BY admin_district.districtid ORDER BY admin_district.districtid",nativeQuery=true)
	String[] getDlccCount(int id);

	@Query(value="select count(id) as pcount from hfregistry  where province=?1 and type=2 and soft_delete=0 group by district order by district",nativeQuery=true)
	String[] getDNgcCount(int id);

	@Query(value="select count(id) as pcount from hfregistry  where district=?1 and soft_delete=0 group by municipality order by municipality",nativeQuery=true)
	String[] getMcount(int id);

	@Query(value="select count(id) as pcount from hfregistry  where district=?1 and type=1 and soft_delete=0 group by municipality order by municipality",nativeQuery=true)
	String[] getMGcount(int id);
	
	@Query(value="SELECT COUNT(hfregistry.id) AS pcount FROM admin_local_level_structure LEFT JOIN hfregistry ON hfregistry.municipality = admin_local_level_structure.vcid AND hfregistry.authlevel = 'Federal' AND hfregistry.soft_delete = 0 WHERE admin_local_level_structure.districtid = ?1 GROUP BY admin_local_level_structure.vcid ORDER BY admin_local_level_structure.vcid",nativeQuery=true)
	String[] getMfcount(int id);
	
	@Query(value="SELECT COUNT(hfregistry.id) AS pcount FROM admin_local_level_structure LEFT JOIN hfregistry ON hfregistry.municipality = admin_local_level_structure.vcid AND hfregistry.authlevel = 'Provincial' AND hfregistry.soft_delete = 0 WHERE admin_local_level_structure.districtid = ?1 GROUP BY admin_local_level_structure.vcid ORDER BY admin_local_level_structure.vcid",nativeQuery=true)
	String[] getMpcCount(int id);
	
	@Query(value="SELECT COUNT(hfregistry.id) AS pcount FROM admin_local_level_structure LEFT JOIN hfregistry ON hfregistry.municipality = admin_local_level_structure.vcid AND hfregistry.authlevel = 'Local' AND hfregistry.soft_delete = 0 WHERE admin_local_level_structure.districtid = ?1 GROUP BY admin_local_level_structure.vcid ORDER BY admin_local_level_structure.vcid",nativeQuery=true)
	String[] getMlcCount(int id);

	@Query(value="select count(id) as pcount from hfregistry  where district=?1 and type=2  and soft_delete=0 group by municipality order by municipality",nativeQuery=true)
	String[] getMNgcCount(int id);

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into history_facilitytype(hf_id,ftype_id,removed_date) VALUES (:lid,:flvl,NULL)", nativeQuery = true)
	void addHistoryLevel(int lid, int flvl);
	
	@Query(value="select level from hfregistry where id=?1",nativeQuery=true)
	int findlevels(int id);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update history_facilitytype set removed_date=Default(removed_date) where hf_id=?1 AND ftype_id=?2 AND removed_date is NULL",nativeQuery=true)
	void updateFlevelhistory(int id, int plevel, Timestamp timestamp);

	@Query(value="select cbscode,ucode FROM hfregistry WHERE municipality = ?1 AND id!=?2 AND ucode=(select max(ucode) from hfregistry where municipality=?1)",nativeQuery=true)
	String[] findUpdateCodess(String munc, int id);

	@Query(value="select cbscode,ucode,municipality FROM hfregistry WHERE  id=?1",nativeQuery=true)
	String[] findPreviouscode(int id);

	@Query(value="select cbscode FROM admin_local_level_structure WHERE  vcid=?1 ",nativeQuery=true)
	int getCbsCodes(String munc);

	@Query(value="select * FROM hfregistry WHERE province = ?1  and soft_delete=0",nativeQuery = true)
	List<HealthFacility> getTotalList(int province);

	@Query(value="select * FROM hfregistry WHERE province = ?1 AND type=?2  and soft_delete=0",nativeQuery = true)
	List<HealthFacility> getTotalLists(int province, int type);
	
	@Query(value="select * FROM hfregistry WHERE district = ?1  and soft_delete=0",nativeQuery = true)
	List<HealthFacility> getDistTotalList(int dist);

	@Query(value="select * FROM hfregistry WHERE district = ?1 AND type=?2  and soft_delete=0",nativeQuery = true)
	List<HealthFacility> getDistTotalLists(int dist, int type);
	
	@Query(value="select * FROM hfregistry WHERE municipality = ?1  and soft_delete=0",nativeQuery = true)
	List<HealthFacility> getPalikaTotalList(String dipalikast);

	@Query(value="select * FROM hfregistry WHERE municipality = ?1 AND type=?2 and soft_delete=0",nativeQuery = true)
	List<HealthFacility> getPalikaTotalLists(String palika, int type);

	@Query(value="select * From hfregistry Where municipality=?1 and  soft_delete=0",nativeQuery=true)
	List<HealthFacility> getHfBypalika(String palika);

//	@Query(value="select * From users",nativeQuery=true)
	@Query(value="select * FROM Users WHERE  username LIKE %?1% OR firstname LIKE %?1%",countQuery = "SELECT count(*) FROM Users WHERE username LIKE %?1% OR firstname LIKE %?1%",nativeQuery=true)
	List<Users> getUsersList(String search);

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_services where service_id=?1) and  p.soft_delete=0",nativeQuery=true)
	List<HealthFacility> getFacilityList(int service);

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.level=?1 and  p.soft_delete=0",nativeQuery=true)
	List<HealthFacility> getFacilityLists(int type);

	@Query(value="select id from apiusers where token=?1",nativeQuery=true)
	Integer findApiUserid(String token);

	@Query(value="select count(id) from apiusers where token=?1 and status=1",nativeQuery=true)
	String findApiuserRole(String token);

	@Query(value="select count(id) as fcount from hfregistry where authlevel='Federal' and  soft_delete=0",nativeQuery=true)
	String[] getFederalcount();

	@Query(value="select count(id) as fcount from hfregistry where authlevel='Provincial' and  soft_delete=0",nativeQuery=true)
	String[] getProvincialcount();

	@Query(value="select count(id) as fcount from hfregistry where authlevel='Local' and  soft_delete=0 ",nativeQuery=true)
	String[] getLocalCount();

	 @Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into user_hf_access(userid,hfid) VALUES (:userid,:s)", nativeQuery = true)
	void addUserHf(int userid, String s);

	 @Modifying(clearAutomatically = true) @Transactional
	@Query(value="delete from user_hf_access where userid=?1",nativeQuery=true)
	void deleteHf(int userid);

	 @Query(value="select count(id) as icount from hfregistry where icu_functional is not null and icu_functional !=0 and  soft_delete=0",nativeQuery=true)
	String[] getIcuCount();

	 @Query(value="select count(id) as vcount from hfregistry where ventilator_functional is not null and ventilator_functional !=0  and  soft_delete=0",nativeQuery=true)
	  String[] getVentCount();

	 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0 and (opstatus  in('Functional','') or opstatus is null)",nativeQuery=true)
	String[] getTotal();
	 
	 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0 and  level in(37,40,41,43,44,45,46,48,49,50,65,66)",nativeQuery=true)
		String[] getTotalBed();
	 
	 @Query(value="select count(id) as tcount from hfregistry where soft_delete=1 and onlinestatus=1",nativeQuery=true)
		String[] getTotalOnline();
	 
	 @Query(value="select count(id) as tcount from hfregistry where soft_delete=1 and onlinestatus=1 and province=?1 and submitto=2",nativeQuery=true)
		String[] getTotalOnlineP(String rvalues);
	 
	 @Query(value="select count(id) as tcount from hfregistry where soft_delete=1 and onlinestatus=1 and district=?1 and submitto=3",nativeQuery=true)
		String[] getTotalOnlineD(String rvalues);
	 
	 @Query(value="select count(id) as tcount from hfregistry where soft_delete=1 and onlinestatus=1 and municipality=?1 and submitto=4",nativeQuery=true)
		String[] getTotalOnlineM(String rvalues);

	 @Query(value="select count(id) as tcount from hfregistry where type=1 and  soft_delete=0 and (opstatus  in('Functional','') or opstatus is null)",nativeQuery=true)
	String[] getGovcount();

	 @Query(value="select count(id) as tcount from hfregistry where type=2 and  soft_delete=0 and (opstatus  in('Functional','') or opstatus is null)",nativeQuery=true)
	String[] getNgovCount();

	 @Query(value="SELECT count(id) FROM hfregistry   WHERE  id in(select hf_id from hf_services where service_id=?1) and  soft_delete=0",nativeQuery=true)
	String[] getCovidCount(int i);

	@Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_services where service_id=?1 ) and  soft_delete=0",nativeQuery=true)
	List<HealthFacility> getHfbyCovidService(int service);
	
	 @Query(value="select count(id) as tcount from hfregistry where municipality=?1 and  soft_delete=0",nativeQuery=true)
	String[] getTotalM(String rvalues);
	 
	 @Query(value="select count(id) as tcount from hfregistry where municipality=?1 and  soft_delete=0 and level in(37,40,41,43,44,45,46,48,49,50,65,66)",nativeQuery=true)
		String[] getTotalMBed(String rvalues);

	 @Query(value="select count(id) as tcount from hfregistry where type=1 and  municipality=?1 and  soft_delete=0",nativeQuery=true)
	String[] getGovcountM(String rvalues);

	 @Query(value="select count(id) as tcount from hfregistry where type=2 and  municipality=?1 and  soft_delete=0",nativeQuery=true)
	 String[] getNgovCountM(String rvalues);

	 @Query(value="select count(id) as tcount from hfregistry where district=?1 and  soft_delete=0",nativeQuery=true)
	String[] getTotalD(String rvalues);
	 
	 @Query(value="select count(id) as tcount from hfregistry where district=?1 and  soft_delete=0 and level in(37,40,41,43,44,45,46,48,49,50,65,66)",nativeQuery=true)
		String[] getTotalDBed(String rvalues);

	 @Query(value="select count(id) as tcount from hfregistry where type=1 and  district=?1 and  soft_delete=0",nativeQuery=true)
	String[] getGovcountD(String rvalues);

	 @Query(value="select count(id) as tcount from hfregistry where type=2 and  district=?1 and  soft_delete=0",nativeQuery=true)
	String[] getNgovCountD(String rvalues);

	 @Query(value="select count(id) as tcount from hfregistry where province=?1 and  soft_delete=0",nativeQuery=true)
	String[] getTotalP(String rvalues);
	 
	 @Query(value="select count(id) as tcount from hfregistry where province=?1 and  soft_delete=0 and level in(37,40,41,43,44,45,46,48,49,50,65,66)",nativeQuery=true)
		String[] getTotalPBed(String rvalues);

	 @Query(value="select count(id) as tcount from hfregistry where type=1 and  province=?1 and  soft_delete=0",nativeQuery=true)
	String[] getGovcountP(String rvalues);

	 @Query(value="select count(id) as tcount from hfregistry where type=2 and  province=?1 and  soft_delete=0",nativeQuery=true)
	String[] getNgovCountP(String rvalues);
	 
	 @Query(value="select count(id) as fcount from hfregistry where authlevel='Federal' and municipality=?1 and  soft_delete=0",nativeQuery=true)
	String[] getFederalcountM(String rvalues);
	 
	 @Query(value="select count(id) as fcount from hfregistry where authlevel='Provincial' and municipality=?1 and  soft_delete=0 ",nativeQuery=true)
		String[] getProvincialcountM(String rvalues);

	@Query(value="select count(id) as fcount from hfregistry where authlevel='Local' and municipality=?1 and  soft_delete=0",nativeQuery=true)
		String[] getLocalCountM(String rvalues);
		
	 @Query(value="select count(id) as icount from hfregistry where icu_functional is not null and municipality=?1 and  soft_delete=0 ",nativeQuery=true)
		String[] getIcuCountM(String rvalues);

	 @Query(value="select count(id) as vcount from hfregistry where ventilator_functional is not null and municipality=?1 and  soft_delete=0 ",nativeQuery=true)
		 String[] getVentCountM(String rvalues);
	 
	 
	 @Query(value="select count(id) as fcount from hfregistry where authlevel='Federal' and district=?1 and  soft_delete=0",nativeQuery=true)
		String[] getFederalcountD(String rvalues);
		 
		 @Query(value="select count(id) as fcount from hfregistry where authlevel='Provincial' and district=?1 and  soft_delete=0 ",nativeQuery=true)
			String[] getProvincialcountD(String rvalues);

		@Query(value="select count(id) as fcount from hfregistry where authlevel='Local' and district=?1 and  soft_delete=0",nativeQuery=true)
			String[] getLocalCountD(String rvalues);
			
		 @Query(value="select count(id) as icount from hfregistry where icu_functional is not null and district=?1 and  soft_delete=0",nativeQuery=true)
			String[] getIcuCountD(String rvalues);

		 @Query(value="select count(id) as vcount from hfregistry where ventilator_functional is not null and district=?1 and  soft_delete=0 ",nativeQuery=true)
			 String[] getVentCountD(String rvalues);
		 
		 
		 @Query(value="select count(id) as fcount from hfregistry where authlevel='Federal' and province=?1 and  soft_delete=0 ",nativeQuery=true)
			String[] getFederalcountP(String rvalues);
			 
			 @Query(value="select count(id) as fcount from hfregistry where authlevel='Provincial' and province=?1 and  soft_delete=0",nativeQuery=true)
				String[] getProvincialcountP(String rvalues);

			@Query(value="select count(id) as fcount from hfregistry where authlevel='Local' and province=?1 and  soft_delete=0",nativeQuery=true)
				String[] getLocalCountP(String rvalues);
				
			 @Query(value="select count(id) as icount from hfregistry where icu_functional is not null and province=?1 and  soft_delete=0 ",nativeQuery=true)
				String[] getIcuCountP(String rvalues);

			 @Query(value="select count(id) as vcount from hfregistry where ventilator_functional is not null and province=?1 and  soft_delete=0",nativeQuery=true)
				 String[] getVentCountP(String rvalues);

			 @Query(value="SELECT count(id) FROM hfregistry   WHERE  id in(select hf_id from hf_services where service_id=?1 and municipality=?2 and  soft_delete=0)",nativeQuery=true)
			String[] getCovidCountM(int i, String rvalues);

			 @Query(value="SELECT count(id) FROM hfregistry   WHERE  id in(select hf_id from hf_services where service_id=?1 and district=?2) and  soft_delete=0",nativeQuery=true)
			String[] getCovidCountD(int i, String rvalues);

			 @Query(value="SELECT count(id) FROM hfregistry   WHERE  id in(select hf_id from hf_services where service_id=?1 and province=?2) and  soft_delete=0",nativeQuery=true)
			String[] getCovidCountP(int i, String rvalues);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_services where service_id=?1) and p.municipality=?2 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getHfbyCovidServiceM(int service, String rvalues);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_services where service_id=?1) and p.district=?2 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getHfbyCovidServiceD(int service, String rvalues);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_services where service_id=?1) and p.province=?2 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getHfbyCovidServiceP(int service, String rvalues);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.id in(select hf_id from hf_services where service_id=?2) and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByPalikaService(String palika, int service);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.id in(select hf_id from hf_services where service_id=?2) and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByDistService(int district, int service);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.id in(select hf_id from hf_services where service_id=?2) and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByProvService(int province, int service);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_services where service_id=?1) and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByService(int service);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.level=?2 and  p.soft_delete=0",nativeQuery=true)
			 List<HealthFacility> getFacilityByPalikaType(String palika, int type);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.level=?2 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByDistType(int district, int type);
			 
			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.level=?2 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByProvType(int province, int type);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.level=?1 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityBytype(int type);
			 
			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.type=?2 and  p.soft_delete=0",nativeQuery=true)
			 List<HealthFacility> getFacilityByPalikaAuth(String palika, int type);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.type=?2 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByDistAuth(int district, int type);
			 
			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.type=?2 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByProvAuth(int province, int type);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.type=?1 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByAuth(int type);

			 @Query(value="select count(id) as pcount from hfregistry where municipality=?1 and ward=?2 and  soft_delete=0",nativeQuery=true)
			int getHFCount(String vcid, int i);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.created_date>=?1 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityLatest(String date);

			 @Modifying(clearAutomatically = true) @Transactional
			 @Query(value="insert into hfregistry_history select * from hfregistry where id=?1",nativeQuery=true) 
			void addFacilityHistory(int id);

//			 @Query(value="SELECT a.* FROM api_exchange a LEFT JOIN hfregistry h ON a.hfid=h.id where a.id>?1",nativeQuery=true)
//			 List<ApiExchange> getLatestss(int lastid);
//
//			 @Query(value="SELECT a.* FROM api_exchange a LEFT JOIN hfregistry h ON a.hfid=h.id where a.id>?1",nativeQuery=true)
//			 List<ApiExchange> getLatestsss(int lastid);

			 @Query(value="SELECT p.*,ap.id as aid FROM hfregistry p   JOIN api_exchange ap ON p.id=ap.hfid LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hfid from api_exchange where id>?1)",nativeQuery=true)
			 List<HealthFacility> getLatests(int lastid);

			 @Modifying(clearAutomatically = true) @Transactional
		     @Query(value="update hfregistry set soft_delete=1 where id=?1",nativeQuery=true)
			void softDelete(int id);

			 @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.level=?1 and p.type=?2 and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityBytypeAuth(int type, int authority);
			 
			 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?1 and validity!=''",nativeQuery=true)
			String[] getTotalExp(String ndate);

			 @Query(value="select * from hfregistry where soft_delete=0 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?1 and validity!=''",nativeQuery=true)
			List<HealthFacility> getHfbyexpDate(String ndate);

			 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0  and municipality=?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?2 and validity!=''",nativeQuery=true)
			String[] getTotalMexp(String rvalues, String ndate);

			 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0  and district=?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?2 and validity!=''",nativeQuery=true)
			String[] getTotalDexp(String rvalues, String ndate);

			 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0  and province=?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?2 and validity!=''",nativeQuery=true)
			String[] getTotalPexp(String rvalues, String ndate);

			 @Query(value="select * from hfregistry where soft_delete=0 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?1 and municipality=?2 and validity!=''",nativeQuery=true)
			List<HealthFacility> getHfbyexpDatem(String ndate, String rvalues);

			 @Query(value="select * from hfregistry where soft_delete=0 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?1 and district=?2 and validity!=''",nativeQuery=true)
			List<HealthFacility> getHfbyexpDated(String ndate, String rvalues);

			 @Query(value="select * from hfregistry where soft_delete=0 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?1 and province=?2 and validity!=''",nativeQuery=true)
			List<HealthFacility> getHfbyexpDatep(String ndate, String rvalues);

			 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0  and municipality=?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))>?2 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?3 and validity!=''",nativeQuery=true)
			 String[] getTotalMexp(String rvalues, String ndate, String endate);

			 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0  and district=?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))>?2 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?3 and validity!=''",nativeQuery=true)
			String[] getTotalDexp(String rvalues, String ndate, String endate);

			 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0  and province=?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))>?2 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?3 and validity!=''",nativeQuery=true)
			String[] getTotalPexp(String rvalues, String ndate, String endate);

			 @Query(value="select count(id) as tcount from hfregistry where soft_delete=0  and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))>?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?2 and validity!=''",nativeQuery=true)
			String[] getTotalExp(String ndate, String endate);

			 @Query(value="select * from hfregistry where soft_delete=0 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))>?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?2 and municipality=?3 and validity!=''",nativeQuery=true)
			List<HealthFacility> getHfbyexpDatem(String ndate, String endate, String rvalues);

			 @Query(value="select * from hfregistry where soft_delete=0 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))>?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?2 and district=?3 and validity!=''",nativeQuery=true)
			List<HealthFacility> getHfbyexpDated(String ndate, String endate, String rvalues);

			 @Query(value="select * from hfregistry where soft_delete=0 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))>?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?2 and province=?3 and validity!=''",nativeQuery=true)
			List<HealthFacility> getHfbyexpDatep(String ndate, String endate, String rvalues);

			 @Query(value="select * from hfregistry where soft_delete=0 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))>?1 and CONCAT(SUBSTRING_INDEX(validity,'/',-1),'/',SUBSTRING_INDEX(SUBSTRING_INDEX(validity,'/',2),'/',-1),'/',SUBSTRING_INDEX(validity,'/',1))<?2  and validity!=''",nativeQuery=true)
			List<HealthFacility> getHfbyexpDate(String ndate, String endate);

			
		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.id in(select hf_id from hf_opd where opd_id=?2) and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByPalikaServiceOpd(String palika, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.id in(select hf_id from hf_motherhood where mother_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByPalikaServiceMother(String palika, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.id in(select hf_id from hf_familyplanning where family_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByPalikaServicefp(String palika, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.id in(select hf_id from hf_laboratory where laboratory_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByPalikaServicelab(String palika, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.id in(select hf_id from hf_radiology where radiology_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByPalikaServiceradio(String palika, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and (p.hf_name LIKE %?1% or p.hf_code LIKE %?1%) ",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and  (p.hf_name LIKE %?1% or p.hf_code LIKE %?1%) ",nativeQuery=true)
		Page<HealthFacility> findAllHFList(String search, Pageable pageable);
		   
		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0 and p.level in(37,40,41,43,44,45,46,48,49,50,65,66) and (p.hf_name LIKE %?1% or p.hf_code LIKE %?1%) ",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=0  and p.level in(37,40,41,43,44,45,46,48,49,50,65,66) and  (p.hf_name LIKE %?1% or p.hf_code LIKE %?1%) ",nativeQuery=true)
			Page<HealthFacility> findAllHFListBed(String search, Pageable pageable);
		   
		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=1 and p.onlinestatus=1 and p.hf_name LIKE %?1% ",countQuery = "SELECT count(*) FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  WHERE p.soft_delete=1 and p.onlinestatus=1 and p.hf_name LIKE %?1% ",nativeQuery=true)
			Page<HealthFacility> findAllHFListOnline(String search, Pageable pageable);
		   
		 

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.id in(select hf_id from hf_surgical where surgical_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByPalikaServicesurgic(String palika, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.id in(select hf_id from hf_specialized where specialized_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByPalikaServiceSpecial(String palika, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.municipality=?1 AND  p.id in(select hf_id from hf_ayurved where ayur_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByPalikaServiceAyurved(String palika, int service, String tab, String col);
		   
		   
		   
		   
		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.id in(select hf_id from hf_opd where opd_id=?2) and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByDistrictServiceOpd(int district, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.id in(select hf_id from hf_motherhood where mother_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByDistrictServiceMother(int district, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.id in(select hf_id from hf_familyplanning where family_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByDistrictServicefp(int district, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.id in(select hf_id from hf_laboratory where laboratory_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByDistrictServicelab(int district, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.id in(select hf_id from hf_radiology where radiology_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByDistrictServiceradio(int district, int service, String tab, String col);

		  

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.id in(select hf_id from hf_surgical where surgical_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByDistrictServicesurgic(int district, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.id in(select hf_id from hf_specialized where specialized_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByDistrictServiceSpecial(int district, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.district=?1 AND  p.id in(select hf_id from hf_ayurved where ayur_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByDistrictServiceAyurved(int district, int service, String tab, String col);

		
	
	
		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.id in(select hf_id from hf_opd where opd_id=?2) and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByProvinceServiceOpd(int province, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.id in(select hf_id from hf_motherhood where mother_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByProvinceServiceMother(int province, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.id in(select hf_id from hf_familyplanning where family_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByProvinceServicefp(int province, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.id in(select hf_id from hf_laboratory where laboratory_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByProvinceServicelab(int province, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.id in(select hf_id from hf_radiology where radiology_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByProvinceServiceradio(int province, int service, String tab, String col);

		  

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.id in(select hf_id from hf_surgical where surgical_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByProvinceServicesurgic(int province, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.id in(select hf_id from hf_specialized where specialized_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByProvinceServiceSpecial(int province, int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.province=?1 AND  p.id in(select hf_id from hf_ayurved where ayur_id=?2) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByProvinceServiceAyurved(int province, int service, String tab, String col);
		   
		   
			
		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_opd where opd_id=?1) and  p.soft_delete=0",nativeQuery=true)
			List<HealthFacility> getFacilityByNationalServiceOpd(int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_motherhood where mother_id=?1) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByNationalServiceMother(int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE   p.id in(select hf_id from hf_familyplanning where family_id=?1) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByNationalServicefp(int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE   p.id in(select hf_id from hf_laboratory where laboratory_id=?1) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByNationalServicelab( int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE   p.id in(select hf_id from hf_radiology where radiology_id=?1) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByNationalServiceradio(int service, String tab, String col);
		 
		   @Query(value="select id,hf_name FROM hfregistry WHERE province = ?1",countQuery = "SELECT count(*) FROM hfregistry WHERE province = ?1",nativeQuery=true)
			Page<Object[]> findAllbyprovince(int province, Pageable pageable);
		  

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_surgical where surgical_id=?1) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByNationalServicesurgic(int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE   p.id in(select hf_id from hf_specialized where specialized_id=?1) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByNationalServiceSpecial(int service, String tab, String col);

		   @Query(value="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id WHERE  p.id in(select hf_id from hf_ayurved where ayur_id=?1) and  p.soft_delete=0",nativeQuery=true)
		List<HealthFacility> getFacilityByNationalServiceAyurved(int service, String tab, String col);


//		@Query(value="Select hf_name as name , website as href,  id  as uuid,  hf_code  as hfCode,  latitude ,  longitude ,  type ,  authlevel ,  level ,  oldlevel ,  ownership ,"
//				+ "  ftype ,  opstatus ,  internet ,  ren_date ,  sectioned ,  functional ,  icu_sectioned ,  icu_functional ,  ventilator_sectioned ,  ventilator_functional ,  province,p.nameen as provincename , "
//				+ " district ,  municipality ,  ward ,  estd_date ,  validity ,  email ,  telephone ,  source ,  hmis_code ,  created_at ,  ucode ,  cbscode ,  newcode ,  district_code , "
//				+ " datecount ,  services ,  soft_delete ,  created_date ,  c_hf_name ,  health_services ,  oxygen ,  ambulance ,  concentrator ,  cylinder ,  ehs ,  geriatrics ,  insurance , "
//				+ " ocmc ,  pharmacy ,  plant_capacity ,  ssu ,  contact_person ,  contact_person_mobile ,  ambulance_category ,  ambulance_contact ,  hdu_functional ,  hdu_sectioned , "
//				+ " nicu_functional ,  nicu_sectioned ,  org_source ,  building_cost ,  device_cost ,  est_income ,  loan_org ,  other_source ,  property_source ,  workforce_cost ,"
//				+ "  deviceitems ,  owneritems ,  onlinestatus ,  approvedate ,  approveby ,  building_maps ,  hf_details ,  iee_certs ,  mem_citizenships ,  org_articles ,  org_perms , "
//				+ " reg_orgs ,  service_fees ,  tax_clears ,  vat_pans ,  submitto ,  hcode ,  rtype  from  hfregistry join admin_province p on p.pid=hfregistry.province",countQuery = "SELECT count(*) FROM hfregistry" , nativeQuery = true)
//		
		   @Query(value = 
				   "SELECT hf.hf_name AS name, hf.website AS href, hf.id AS uuid,CASE WHEN hf.opstatus = 'Functional' THEN 'true'ELSE 'false'END AS active,"
				   + " DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS created_at,DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS updated_at, hf.latitude, hf.longitude, hf.hmis_code AS iid, hf.source AS agency, hf.hf_code AS hfCode,hf.type, "
				    + "health_facility_type.id AS hftype_id, health_facility_type.code AS hftype_code, health_facility_type.type_name AS hftype_name, "
				    + "  hf.authlevel,"
		            + "hf.ftype AS ftype, hf.opstatus, "
		            + "hf.internet, hf.ren_date, hf.sectioned, hf.functional, hf.icu_sectioned, hf.icu_functional, hf.ventilator_sectioned, hf.ventilator_functional, "
		            + "admin_province.pid AS province_id, admin_province.nameen AS province_name, "
		            + "admin_district.districtid AS district_id, admin_district.nameen AS district_name, admin_local_level_structure.vcid AS municipality_id, admin_local_level_structure.nameen AS municipality_name, "
		            + "hf.ward, hf.estd_date, hf.validity, hf.email, hf.telephone, "
		            + " hf.oxygen, hf.ambulance, "
		            + "hf.concentrator, hf.cylinder, hf.ehs, hf.geriatrics, hf.insurance, hf.ocmc, hf.pharmacy, hf.plant_capacity, hf.ssu, hf.contact_person, hf.contact_person_mobile, "
		            + "hf.ambulance_category, hf.ambulance_contact, hf.hdu_functional, hf.hdu_sectioned, hf.nicu_functional, hf.nicu_sectioned, hf.org_source, hf.building_cost, hf.device_cost, "
		            + "hf.est_income, hf.loan_org, hf.other_source, hf.property_source, hf.workforce_cost,DATE_FORMAT(hf.approvedate, '%Y-%m-%d') AS approved_date , hf.approveby, "
		            + "service_type.id AS ftype_id, service_type.code AS ftype_code, service_type.name AS ftype_name, service_type.status AS ftype_status, "
		            + " hf.ownership, ownership.id AS ownership_id, ownership.name AS ownership_name, ownership.code AS ownership_code, ownership.status AS ownership_status, "
		            + "hf.level,facility_level.id AS facility_level_id, facility_level.code AS facility_level_code, facility_level.nameen AS facility_level_name, facility_level.status AS facility_level_status, "
		            + "facility_level.parent AS facility_level_parent, facility_level.types AS facility_level_types, hf.oldlevel,hf.hcode, hf.rtype,  "
		            + "hf.building_maps, hf.hf_details, hf.iee_certs, hf.mem_citizenships, hf.org_articles, hf.org_perms, hf.reg_orgs, hf.service_fees, hf.tax_clears, hf.vat_pans "
		            + "FROM hfregistry hf "
		            + "JOIN admin_province ON admin_province.pid = hf.province "
		            + "LEFT JOIN service_type ON service_type.id = hf.ftype "
		            + "LEFT JOIN ownership ON ownership.id = hf.ownership "
		            + "LEFT JOIN facility_level ON facility_level.id = hf.level "
		            + "JOIN admin_district ON admin_district.districtid = hf.district "
		            + "JOIN admin_local_level_structure ON admin_local_level_structure.vcid = hf.municipality "
		            + "LEFT JOIN health_facility_type ON health_facility_type.id = hf.type "
		            + "WHERE hf.soft_delete = 0"
		   			,
		   				countQuery = "SELECT count(*) FROM hfregistry where soft_delete=0", nativeQuery = true)
		Page<Object[]> findallFacilities(Pageable pageable);
		
		 @Query(value = 
				   "SELECT hf.hf_name AS name, hf.website AS href, hf.id AS uuid,CASE WHEN hf.opstatus = 'Functional' THEN 'true'ELSE 'false'END AS active,"
				   + " DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS created_at,DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS updated_at, hf.latitude, hf.longitude, hf.hmis_code AS iid, hf.source AS agency, hf.hf_code AS hfCode,hf.type, "
				    + "health_facility_type.id AS hftype_id, health_facility_type.code AS hftype_code, health_facility_type.type_name AS hftype_name, "
				    + "  hf.authlevel,"
		            + "hf.ftype AS ftype, hf.opstatus, "
		            + "hf.internet, hf.ren_date, hf.sectioned, hf.functional, hf.icu_sectioned, hf.icu_functional, hf.ventilator_sectioned, hf.ventilator_functional, "
		            + "admin_province.pid AS province_id, admin_province.nameen AS province_name, "
		            + "admin_district.districtid AS district_id, admin_district.nameen AS district_name, admin_local_level_structure.vcid AS municipality_id, admin_local_level_structure.nameen AS municipality_name, "
		            + "hf.ward, hf.estd_date, hf.validity, hf.email, hf.telephone, "
		            + " hf.oxygen, hf.ambulance, "
		            + "hf.concentrator, hf.cylinder, hf.ehs, hf.geriatrics, hf.insurance, hf.ocmc, hf.pharmacy, hf.plant_capacity, hf.ssu, hf.contact_person, hf.contact_person_mobile, "
		            + "hf.ambulance_category, hf.ambulance_contact, hf.hdu_functional, hf.hdu_sectioned, hf.nicu_functional, hf.nicu_sectioned, hf.org_source, hf.building_cost, hf.device_cost, "
		            + "hf.est_income, hf.loan_org, hf.other_source, hf.property_source, hf.workforce_cost,DATE_FORMAT(hf.approvedate, '%Y-%m-%d') AS approved_date , hf.approveby, "
		            + "service_type.id AS ftype_id, service_type.code AS ftype_code, service_type.name AS ftype_name, service_type.status AS ftype_status, "
		            + " hf.ownership, ownership.id AS ownership_id, ownership.name AS ownership_name, ownership.code AS ownership_code, ownership.status AS ownership_status, "
		            + "hf.level,facility_level.id AS facility_level_id, facility_level.code AS facility_level_code, facility_level.nameen AS facility_level_name, facility_level.status AS facility_level_status, "
		            + "facility_level.parent AS facility_level_parent, facility_level.types AS facility_level_types, hf.oldlevel,hf.hcode, hf.rtype,  "
		            + "hf.building_maps, hf.hf_details, hf.iee_certs, hf.mem_citizenships, hf.org_articles, hf.org_perms, hf.reg_orgs, hf.service_fees, hf.tax_clears, hf.vat_pans "
		            + "FROM hfregistry hf "
		            + "JOIN admin_province ON admin_province.pid = hf.province "
		            + "LEFT JOIN service_type ON service_type.id = hf.ftype "
		            + "LEFT JOIN ownership ON ownership.id = hf.ownership "
		            + "LEFT JOIN facility_level ON facility_level.id = hf.level "
		            + "JOIN admin_district ON admin_district.districtid = hf.district "
		            + "JOIN admin_local_level_structure ON admin_local_level_structure.vcid = hf.municipality "
		            + "LEFT JOIN health_facility_type ON health_facility_type.id = hf.type "
		            + "WHERE hf.soft_delete = 0 and hf.hf_code= ?1"
		   			,
		   				countQuery = "SELECT count(*) FROM hfregistry where soft_delete=0 and hf_code= ?1", nativeQuery = true)
		Page<Object[]> findHfByCodes(BigInteger code,Pageable pageable);

		 @Query(value = 
				   "SELECT hf.hf_name AS name, hf.website AS href, hf.id AS uuid,CASE WHEN hf.opstatus = 'Functional' THEN 'true'ELSE 'false'END AS active,"
				   + " DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS created_at,DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS updated_at, hf.latitude, hf.longitude, hf.hmis_code AS iid, hf.source AS agency, hf.hf_code AS hfCode,hf.type, "
				    + "health_facility_type.id AS hftype_id, health_facility_type.code AS hftype_code, health_facility_type.type_name AS hftype_name, "
				    + "  hf.authlevel,"
		            + "hf.ftype AS ftype, hf.opstatus, "
		            + "hf.internet, hf.ren_date, hf.sectioned, hf.functional, hf.icu_sectioned, hf.icu_functional, hf.ventilator_sectioned, hf.ventilator_functional, "
		            + "admin_province.pid AS province_id, admin_province.nameen AS province_name, "
		            + "admin_district.districtid AS district_id, admin_district.nameen AS district_name, admin_local_level_structure.vcid AS municipality_id, admin_local_level_structure.nameen AS municipality_name, "
		            + "hf.ward, hf.estd_date, hf.validity, hf.email, hf.telephone, "
		            + " hf.oxygen, hf.ambulance, "
		            + "hf.concentrator, hf.cylinder, hf.ehs, hf.geriatrics, hf.insurance, hf.ocmc, hf.pharmacy, hf.plant_capacity, hf.ssu, hf.contact_person, hf.contact_person_mobile, "
		            + "hf.ambulance_category, hf.ambulance_contact, hf.hdu_functional, hf.hdu_sectioned, hf.nicu_functional, hf.nicu_sectioned, hf.org_source, hf.building_cost, hf.device_cost, "
		            + "hf.est_income, hf.loan_org, hf.other_source, hf.property_source, hf.workforce_cost,DATE_FORMAT(hf.approvedate, '%Y-%m-%d') AS approved_date , hf.approveby, "
		            + "service_type.id AS ftype_id, service_type.code AS ftype_code, service_type.name AS ftype_name, service_type.status AS ftype_status, "
		            + " hf.ownership, ownership.id AS ownership_id, ownership.name AS ownership_name, ownership.code AS ownership_code, ownership.status AS ownership_status, "
		            + "hf.level,facility_level.id AS facility_level_id, facility_level.code AS facility_level_code, facility_level.nameen AS facility_level_name, facility_level.status AS facility_level_status, "
		            + "facility_level.parent AS facility_level_parent, facility_level.types AS facility_level_types, hf.oldlevel,hf.hcode, hf.rtype,  "
		            + "hf.building_maps, hf.hf_details, hf.iee_certs, hf.mem_citizenships, hf.org_articles, hf.org_perms, hf.reg_orgs, hf.service_fees, hf.tax_clears, hf.vat_pans "
		            + "FROM hfregistry hf "
		            + "JOIN admin_province ON admin_province.pid = hf.province "
		            + "LEFT JOIN service_type ON service_type.id = hf.ftype "
		            + "LEFT JOIN ownership ON ownership.id = hf.ownership "
		            + "LEFT JOIN facility_level ON facility_level.id = hf.level "
		            + "JOIN admin_district ON admin_district.districtid = hf.district "
		            + "JOIN admin_local_level_structure ON admin_local_level_structure.vcid = hf.municipality "
		            + "LEFT JOIN health_facility_type ON health_facility_type.id = hf.type "
		            + "WHERE hf.soft_delete = 0 and hf.province= ?1"
		   			,
		   				countQuery = "SELECT count(*) FROM hfregistry where soft_delete=0 and province=?1", nativeQuery = true)
		 Page<Object[]>  findHfByProvince(int province, Pageable pageable);
		
		
		 @Query(value = 
				   "SELECT hf.hf_name AS name, hf.website AS href, hf.id AS uuid,CASE WHEN hf.opstatus = 'Functional' THEN 'true'ELSE 'false'END AS active,"
				   + " DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS created_at,DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS updated_at, hf.latitude, hf.longitude, hf.hmis_code AS iid, hf.source AS agency, hf.hf_code AS hfCode,hf.type, "
				    + "health_facility_type.id AS hftype_id, health_facility_type.code AS hftype_code, health_facility_type.type_name AS hftype_name, "
				    + "  hf.authlevel,"
		            + "hf.ftype AS ftype, hf.opstatus, "
		            + "hf.internet, hf.ren_date, hf.sectioned, hf.functional, hf.icu_sectioned, hf.icu_functional, hf.ventilator_sectioned, hf.ventilator_functional, "
		            + "admin_province.pid AS province_id, admin_province.nameen AS province_name, "
		            + "admin_district.districtid AS district_id, admin_district.nameen AS district_name, admin_local_level_structure.vcid AS municipality_id, admin_local_level_structure.nameen AS municipality_name, "
		            + "hf.ward, hf.estd_date, hf.validity, hf.email, hf.telephone, "
		            + " hf.oxygen, hf.ambulance, "
		            + "hf.concentrator, hf.cylinder, hf.ehs, hf.geriatrics, hf.insurance, hf.ocmc, hf.pharmacy, hf.plant_capacity, hf.ssu, hf.contact_person, hf.contact_person_mobile, "
		            + "hf.ambulance_category, hf.ambulance_contact, hf.hdu_functional, hf.hdu_sectioned, hf.nicu_functional, hf.nicu_sectioned, hf.org_source, hf.building_cost, hf.device_cost, "
		            + "hf.est_income, hf.loan_org, hf.other_source, hf.property_source, hf.workforce_cost,DATE_FORMAT(hf.approvedate, '%Y-%m-%d') AS approved_date , hf.approveby, "
		            + "service_type.id AS ftype_id, service_type.code AS ftype_code, service_type.name AS ftype_name, service_type.status AS ftype_status, "
		            + " hf.ownership, ownership.id AS ownership_id, ownership.name AS ownership_name, ownership.code AS ownership_code, ownership.status AS ownership_status, "
		            + "hf.level,facility_level.id AS facility_level_id, facility_level.code AS facility_level_code, facility_level.nameen AS facility_level_name, facility_level.status AS facility_level_status, "
		            + "facility_level.parent AS facility_level_parent, facility_level.types AS facility_level_types, hf.oldlevel,hf.hcode, hf.rtype,  "
		            + "hf.building_maps, hf.hf_details, hf.iee_certs, hf.mem_citizenships, hf.org_articles, hf.org_perms, hf.reg_orgs, hf.service_fees, hf.tax_clears, hf.vat_pans "
		            + "FROM hfregistry hf "
		            + "JOIN admin_province ON admin_province.pid = hf.province "
		            + "LEFT JOIN service_type ON service_type.id = hf.ftype "
		            + "LEFT JOIN ownership ON ownership.id = hf.ownership "
		            + "LEFT JOIN facility_level ON facility_level.id = hf.level "
		            + "JOIN admin_district ON admin_district.districtid = hf.district "
		            + "JOIN admin_local_level_structure ON admin_local_level_structure.vcid = hf.municipality "
		            + "LEFT JOIN health_facility_type ON health_facility_type.id = hf.type "
		            + "WHERE hf.soft_delete = 0 and hf.district= ?1"
		   			,
		   				countQuery = "SELECT count(*) FROM hfregistry where soft_delete=0 and district=?1", nativeQuery = true)
		 Page<Object[]> findHfByDistrict(int district, Pageable pageable);
		
		 @Query(value = 
				   "SELECT hf.hf_name AS name, hf.website AS href, hf.id AS uuid,CASE WHEN hf.opstatus = 'Functional' THEN 'true'ELSE 'false'END AS active,"
				   + " DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS created_at,DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS updated_at, hf.latitude, hf.longitude, hf.hmis_code AS iid, hf.source AS agency, hf.hf_code AS hfCode,hf.type, "
				    + "health_facility_type.id AS hftype_id, health_facility_type.code AS hftype_code, health_facility_type.type_name AS hftype_name, "
				    + "  hf.authlevel,"
		            + "hf.ftype AS ftype, hf.opstatus, "
		            + "hf.internet, hf.ren_date, hf.sectioned, hf.functional, hf.icu_sectioned, hf.icu_functional, hf.ventilator_sectioned, hf.ventilator_functional, "
		            + "admin_province.pid AS province_id, admin_province.nameen AS province_name, "
		            + "admin_district.districtid AS district_id, admin_district.nameen AS district_name, admin_local_level_structure.vcid AS municipality_id, admin_local_level_structure.nameen AS municipality_name, "
		            + "hf.ward, hf.estd_date, hf.validity, hf.email, hf.telephone, "
		            + " hf.oxygen, hf.ambulance, "
		            + "hf.concentrator, hf.cylinder, hf.ehs, hf.geriatrics, hf.insurance, hf.ocmc, hf.pharmacy, hf.plant_capacity, hf.ssu, hf.contact_person, hf.contact_person_mobile, "
		            + "hf.ambulance_category, hf.ambulance_contact, hf.hdu_functional, hf.hdu_sectioned, hf.nicu_functional, hf.nicu_sectioned, hf.org_source, hf.building_cost, hf.device_cost, "
		            + "hf.est_income, hf.loan_org, hf.other_source, hf.property_source, hf.workforce_cost,DATE_FORMAT(hf.approvedate, '%Y-%m-%d') AS approved_date , hf.approveby, "
		            + "service_type.id AS ftype_id, service_type.code AS ftype_code, service_type.name AS ftype_name, service_type.status AS ftype_status, "
		            + " hf.ownership, ownership.id AS ownership_id, ownership.name AS ownership_name, ownership.code AS ownership_code, ownership.status AS ownership_status, "
		            + "hf.level,facility_level.id AS facility_level_id, facility_level.code AS facility_level_code, facility_level.nameen AS facility_level_name, facility_level.status AS facility_level_status, "
		            + "facility_level.parent AS facility_level_parent, facility_level.types AS facility_level_types, hf.oldlevel,hf.hcode, hf.rtype,  "
		            + "hf.building_maps, hf.hf_details, hf.iee_certs, hf.mem_citizenships, hf.org_articles, hf.org_perms, hf.reg_orgs, hf.service_fees, hf.tax_clears, hf.vat_pans "
		            + "FROM hfregistry hf "
		            + "JOIN admin_province ON admin_province.pid = hf.province "
		            + "LEFT JOIN service_type ON service_type.id = hf.ftype "
		            + "LEFT JOIN ownership ON ownership.id = hf.ownership "
		            + "LEFT JOIN facility_level ON facility_level.id = hf.level "
		            + "JOIN admin_district ON admin_district.districtid = hf.district "
		            + "JOIN admin_local_level_structure ON admin_local_level_structure.vcid = hf.municipality "
		            + "LEFT JOIN health_facility_type ON health_facility_type.id = hf.type "
		            + "WHERE hf.soft_delete = 0 and hf.municipality= ?1"
		   			,
		   				countQuery = "SELECT count(*) FROM hfregistry where soft_delete=0 and municipality=?1", nativeQuery = true)
		Page<Object[]> findHfByPalika(String municipality, Pageable pageable);
		
		 @Query(value = 
				   "SELECT hf.hf_name AS name, hf.website AS href, hf.id AS uuid,CASE WHEN hf.opstatus = 'Functional' THEN 'true'ELSE 'false'END AS active,"
				   + " DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS created_at,DATE_FORMAT(hf.created_at, '%Y-%m-%d') AS updated_at, hf.latitude, hf.longitude, hf.hmis_code AS iid, hf.source AS agency, hf.hf_code AS hfCode,hf.type, "
				    + "health_facility_type.id AS hftype_id, health_facility_type.code AS hftype_code, health_facility_type.type_name AS hftype_name, "
				    + "  hf.authlevel,"
		            + "hf.ftype AS ftype, hf.opstatus, "
		            + "hf.internet, hf.ren_date, hf.sectioned, hf.functional, hf.icu_sectioned, hf.icu_functional, hf.ventilator_sectioned, hf.ventilator_functional, "
		            + "admin_province.pid AS province_id, admin_province.nameen AS province_name, "
		            + "admin_district.districtid AS district_id, admin_district.nameen AS district_name, admin_local_level_structure.vcid AS municipality_id, admin_local_level_structure.nameen AS municipality_name, "
		            + "hf.ward, hf.estd_date, hf.validity, hf.email, hf.telephone, "
		            + " hf.oxygen, hf.ambulance, "
		            + "hf.concentrator, hf.cylinder, hf.ehs, hf.geriatrics, hf.insurance, hf.ocmc, hf.pharmacy, hf.plant_capacity, hf.ssu, hf.contact_person, hf.contact_person_mobile, "
		            + "hf.ambulance_category, hf.ambulance_contact, hf.hdu_functional, hf.hdu_sectioned, hf.nicu_functional, hf.nicu_sectioned, hf.org_source, hf.building_cost, hf.device_cost, "
		            + "hf.est_income, hf.loan_org, hf.other_source, hf.property_source, hf.workforce_cost,DATE_FORMAT(hf.approvedate, '%Y-%m-%d') AS approved_date , hf.approveby, "
		            + "service_type.id AS ftype_id, service_type.code AS ftype_code, service_type.name AS ftype_name, service_type.status AS ftype_status, "
		            + " hf.ownership, ownership.id AS ownership_id, ownership.name AS ownership_name, ownership.code AS ownership_code, ownership.status AS ownership_status, "
		            + "hf.level,facility_level.id AS facility_level_id, facility_level.code AS facility_level_code, facility_level.nameen AS facility_level_name, facility_level.status AS facility_level_status, "
		            + "facility_level.parent AS facility_level_parent, facility_level.types AS facility_level_types, hf.oldlevel,hf.hcode, hf.rtype,  "
		            + "hf.building_maps, hf.hf_details, hf.iee_certs, hf.mem_citizenships, hf.org_articles, hf.org_perms, hf.reg_orgs, hf.service_fees, hf.tax_clears, hf.vat_pans "
		            + "FROM hfregistry hf "
		            + "JOIN admin_province ON admin_province.pid = hf.province "
		            + "LEFT JOIN service_type ON service_type.id = hf.ftype "
		            + "LEFT JOIN ownership ON ownership.id = hf.ownership "
		            + "LEFT JOIN facility_level ON facility_level.id = hf.level "
		            + "JOIN admin_district ON admin_district.districtid = hf.district "
		            + "JOIN admin_local_level_structure ON admin_local_level_structure.vcid = hf.municipality "
		            + "LEFT JOIN health_facility_type ON health_facility_type.id = hf.type "
		            + "WHERE hf.soft_delete = 0 and  hf.hf_name LIKE %?1% OR hf_code LIKE %?1%"
		   			,
		   				countQuery = "SELECT count(*) FROM hfregistry where soft_delete=0 and hf_name LIKE %?1% OR hf_code LIKE %?1%", nativeQuery = true)
		Page<Object[]> findHfBySearch(String searchKeyword, Pageable pageable);
	
//		   @Query(value="Select `hf_name` as name , `website` as href, `id` as uuid, `hf_code` as hfCode, `latitude`, `longitude`, `type`, `authlevel`, `level`, `oldlevel`, `ownership`, `ftype`, `opstatus`, `internet`, `ren_date`, `sectioned`, `functional`, `icu_sectioned`, `icu_functional`, `ventilator_sectioned`, `ventilator_functional`, `province`, `district`, `municipality`, `ward`, `estd_date`, `validity`, `email`, `telephone`, `source`, `hmis_code`, `created_at`, `ucode`, `cbscode`, `newcode`, `district_code`, `datecount`, `services`, `soft_delete`, `created_date`, `c_hf_name`, `health_services`, `oxygen`, `ambulance`, `concentrator`, `cylinder`, `ehs`, `geriatrics`, `insurance`, `ocmc`, `pharmacy`, `plant_capacity`, `ssu`, `contact_person`, `contact_person_mobile`, `ambulance_category`, `ambulance_contact`, `hdu_functional`, `hdu_sectioned`, `nicu_functional`, `nicu_sectioned`, `org_source`, `building_cost`, `device_cost`, `est_income`, `loan_org`, `other_source`, `property_source`, `workforce_cost`, `deviceitems`, `owneritems`, `onlinestatus`, `approvedate`, `approveby`, `building_maps`, `hf_details`, `iee_certs`, `mem_citizenships`, `org_articles`, `org_perms`, `reg_orgs`, `service_fees`, `tax_clears`, `vat_pans`, `submitto`, `hcode`, `rtype` from `hfregistry` WHERE hf_code=?")
//		   List<HealthFacility> getHfByHfCode();
//		   
//	@Query(value="update users set password=?3 where username=?1 OR password=?2",nativeQuery=true)
//	String upDatePw(String username, String oldpass, String newpass);

	
	
	
	
//	@Query("FROM HealthFacility WHERE hf_name LIKE %?1% OR hf_code LIKE %?1%")
//	List<HealthFacility> findAllList(String search);
//	@Query(value = "SELECT * FROM tbllanguagefile WHERE english like %?1% and nepali like %?2%",
//		    countQuery = "SELECT count(*) FROM tbllanguagefile WHERE english like %?1% and nepali like %?2%",
//		    nativeQuery = true)
	
	
	//	  Page<HealthFacility> findAllInPagination(Pageable pageable);
	
}
