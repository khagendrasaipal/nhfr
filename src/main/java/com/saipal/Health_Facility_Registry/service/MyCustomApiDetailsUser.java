package com.saipal.Health_Facility_Registry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.ApiSignUpUsersEntity;


@Service
public class MyCustomApiDetailsUser{

	@Autowired
	ApiUserService apiUserService;
	
	@Qualifier("encoder")
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserDetails loadUserByUsername(String username,String password) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
	
		List<ApiSignUpUsersEntity>users =apiUserService.getApiUser(username);
		List<User> userslist = new ArrayList<>();
		for(ApiSignUpUsersEntity u:users) {
			
			if(passwordEncoder.matches(password, u.getPassword()))
		return new User(u.getUsername(),u.getPassword(),new ArrayList<>());
		}
		return null;
	}

}
