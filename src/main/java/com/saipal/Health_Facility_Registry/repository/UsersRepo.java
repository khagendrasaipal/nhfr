package com.saipal.Health_Facility_Registry.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
	
	List<Users> findByUsername(@Param(value = "username") String username);

//<<<<<<< HEAD
//	@Query(value="select * FROM users WHERE  username LIKE %?1% OR firstname LIKE %?1%",countQuery = "SELECT count(*) FROM users WHERE username LIKE %?1% OR firstname LIKE %?1%",nativeQuery=true)
//	List<Users> getUserList(String search);
//
//=======
@Query(value="SELECT u.* FROM users u LEFT JOIN admin_province p ON u.province = p.pid LEFT JOIN admin_district d ON u.district=d.districtid LEFT JOIN admin_local_level_structure m ON u.municipality=m.vcid WHERE u.username LIKE %?1% OR u.firstname LIKE %?1%",nativeQuery=true)
    List<Users> findAllUsers(String search);

@Query(value="SELECT u.* FROM users u LEFT JOIN admin_province p ON u.province = p.pid LEFT JOIN admin_district d ON u.district=d.districtid LEFT JOIN admin_local_level_structure m ON u.municipality=m.vcid WHERE u.province= ?1 and ( u.username LIKE %?2% OR u.firstname LIKE %?2%)",nativeQuery=true)
List<Users> findAllUsersprov(String rid,String search);

//@Query(value="SELECT u.* FROM users u LEFT JOIN admin_province p ON u.province = p.pid LEFT JOIN admin_district d ON u.district=d.districtid LEFT JOIN admin_local_level_structure m ON u.municipality=m.vcid WHERE u.username LIKE %?1% OR u.firstname LIKE %?1%",nativeQuery=true)
//List findAllMuncs(String search);
//>>>>>>> e5ea2716e106c7dacf8ba9f70d58fe8d44edd792
    //@Query("FROM Users WHERE username LIKE %?1% OR firstname LIKE %?1%")


    @Query("FROM Users WHERE id=?1")
	Users finduser(int id);

    @Query(value="select cbscode as vc,nameen,namenp,numberofward from admin_local_level_structure WHERE nameen LIKE %?1%",nativeQuery=true)
	List findAllMuncs(String search);

    @Query(value="select cbscode as vc,nameen,namenp,numberofward from admin_local_level_structure WHERE cbscode = ?1",nativeQuery=true)
	List findMuncs(String id);

    @Modifying(clearAutomatically = true) @Transactional
    @Query(value="update admin_local_level_structure set nameen=?2,namenp=?3,numberofward=?4 WHERE cbscode = ?1",nativeQuery=true)
	void updatemunc(int id, String nameen, String namenp, String ward);
}
