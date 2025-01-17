package com.saipal.Health_Facility_Registry.controllers;


import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saipal.Health_Facility_Registry.entity.ApiLoginResponse;
import com.saipal.Health_Facility_Registry.entity.ApiSignUpUsersEntity;
import com.saipal.Health_Facility_Registry.entity.Login;
import com.saipal.Health_Facility_Registry.entity.LoginStatusModel;
import com.saipal.Health_Facility_Registry.entity.Users;

import com.saipal.Health_Facility_Registry.service.ApiUserService;
import com.saipal.Health_Facility_Registry.service.MyCustomApiDetailsUser;
import com.saipal.Health_Facility_Registry.service.MyuserDetailsService;
import com.saipal.Health_Facility_Registry.service.UsersService;
import com.saipal.Health_Facility_Registry.util.JwtUtils;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ApiSignUpRestController {

	@Autowired
	ApiUserService apiUserService;
	@Qualifier("encoder")
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Autowired
	UsersService usersService;
	ApiLoginResponse apiLoginResponse;
	JSONObject result= new JSONObject();
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtTokenutils; 
	
	@Autowired
	MyCustomApiDetailsUser myapiDetailsService;
	@Autowired
	ObjectMapper objectMapper;
	
	
	@RequestMapping(value = "apiUsers",method = RequestMethod.POST)
	public @ResponseBody  String addApiUser(@RequestBody ApiSignUpUsersEntity apiSignUpUsersEntity) {
		try{ 
		ApiSignUpUsersEntity apisign = new ApiSignUpUsersEntity();
			apisign.setAddress(apiSignUpUsersEntity.getAddress());
			apisign.setDesignation(apiSignUpUsersEntity.getDesignation());
			apisign.setFullname(apiSignUpUsersEntity.getFullname());
			apisign.setPhone(apiSignUpUsersEntity.getPhone());
			apisign.setEmail(apiSignUpUsersEntity.getEmail());
			apisign.setUsername(apiSignUpUsersEntity.getUsername());
			apisign.setPassword(passwordEncoder.encode(apiSignUpUsersEntity.getPassword()));
			LocalDateTime date= LocalDateTime.now();
			apisign.setToken(passwordEncoder.encode(date.toString()));
			apiUserService.addApiUser(apisign);
			return "saved successfull";
		}
		catch (Exception e) {
			return "error: "+e.getMessage();
		}
		
		
	}
	
	@RequestMapping(value = "apiLogin",method = RequestMethod.POST)
	public @ResponseBody String apiLogin(@RequestBody Login login) {
		try {
		final UserDetails userDetails =  myapiDetailsService.loadUserByUsername(login.getemail(),login.getPassword());
//		System.out.println(userDetails.getUsername());
		List<ApiSignUpUsersEntity>users= apiUserService.getApiUser(userDetails.getUsername());
		
		
		for(ApiSignUpUsersEntity u: users) {
//			System.out.println(u.getFullname());
			apiLoginResponse = new ApiLoginResponse(u.getId(),u.getToken(),u.getFullname(),u.getUsername());
		}
		
		result.put("Status","1");
		result.put("user", new JSONObject(apiLoginResponse));
	}
	catch (Exception e) {
//		System.out.println(e.getMessage()+e.getStackTrace());
		result.put("Status","0");
		result.put("user", new JSONObject());
		return result.toString();
	
	
	}
	
	
	
	
	 return result.toString();
	
	}
	
}
