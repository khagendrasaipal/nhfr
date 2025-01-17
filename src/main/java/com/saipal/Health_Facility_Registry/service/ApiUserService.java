package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.ApiSignUpUsersEntity;
import com.saipal.Health_Facility_Registry.repository.ApiUsersRepo;

@Service
public class ApiUserService {

	@Autowired
	ApiUsersRepo apiUsersRepo;
	
	public void addApiUser(ApiSignUpUsersEntity apiSignUpUsersEntity) {
		apiUsersRepo.save(apiSignUpUsersEntity);
		
	}
	
	public List<ApiSignUpUsersEntity> getApiUser(String username) {
		List<ApiSignUpUsersEntity>users =apiUsersRepo.findByUsername(username);
		return users;
		
	}
}
