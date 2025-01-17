package com.saipal.Health_Facility_Registry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Users;


@Service
public class MyuserDetailsService implements UserDetailsService{

	@Autowired
	UsersService userService;
	

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println(username);
		List<Users>users =userService.getUsers(username);
//	System.out.println(users.get(0));
		for(Users u:users) {
			System.out.println(username);
		return new User(u.getUsername(),u.getPassword(),new ArrayList<>());
		}

		return null;
	}

}
