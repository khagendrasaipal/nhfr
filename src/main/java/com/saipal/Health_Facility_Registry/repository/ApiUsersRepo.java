package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.ApiSignUpUsersEntity;

@Repository
public interface ApiUsersRepo extends JpaRepository<ApiSignUpUsersEntity, Integer>{

	List<ApiSignUpUsersEntity> findByUsername(@Param(value = "username") String username);

	@Query(value="SELECT * from apiusers where fullname LIKE  concat('%',?1,'%')",nativeQuery=true)
	List<ApiSignUpUsersEntity> getAllApiUsers(String search);

//	@Modifying(clearAutomatically = true) @Transactional
//	@Query(value="update apiusers set status=1 where id = ?1",nativeQuery=true)
//	int enable(int id);

//	@Modifying(clearAutomatically = true) @Transactional
//	@Query(value="update apiusers set status=1 where id = ?1",nativeQuery=true)
//	Object enables(int id);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update apiusers set status=1 where id = ?1",nativeQuery=true)
	void enableUser(int id);

	@Modifying(clearAutomatically = true) @Transactional
	@Query(value="update apiusers set status=0 where id = ?1",nativeQuery=true)
	void disableUser(int id);
}
