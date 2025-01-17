package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saipal.Health_Facility_Registry.entity.Users;
import com.saipal.Health_Facility_Registry.repository.UsersRepo;



@Service

public class UsersService  {

	@Autowired
	UsersRepo usersRepo;
	
	public List<Users> getUsers(){
		List<Users>users =usersRepo.findAll();
		
		return users;
	}
	
	public List<Users> getUsers(String username){
		List<Users>users =usersRepo.findByUsername(username);
		
		return users;
	}
	public void addUser(Users users) {
		usersRepo.save(users);
	}

//<<<<<<< HEAD
//	public List<Users> getUsersList(String search) {
//		// TODO Auto-generated method stub
//		return usersRepo.getUserList(search);
//	}
//	
//=======

	public List<Users> getAllUsers(String search) {
		return usersRepo.findAllUsers(search);
	}
	
	public List<Users> getAllUserProv(String search,String rid) {
		return usersRepo.findAllUsersprov(rid,search);
	}
	
	public List getAllMuncs(String search) {
		return usersRepo.findAllMuncs(search);
	}
//>>>>>>> e5ea2716e106c7dacf8ba9f70d58fe8d44edd792

	public Users getUser(int id) {
			return usersRepo.finduser(id);
	}

	public List getMuncis(String id) {
		// TODO Auto-generated method stub
		return usersRepo.findMuncs(id);
	}

	

	public void addMuncipality(int id, String nameen, String namenp, String ward) {
		usersRepo.updatemunc(id,nameen,namenp,ward) ;
		
	}
}
