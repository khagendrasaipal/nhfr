package com.saipal.Health_Facility_Registry.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.saipal.Health_Facility_Registry.entity.ApiLog;
import com.saipal.Health_Facility_Registry.entity.ApiSignUpUsersEntity;
import com.saipal.Health_Facility_Registry.entity.HealthFacility;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saipal.Health_Facility_Registry.entity.Laboratory;
import com.saipal.Health_Facility_Registry.entity.Login;
import com.saipal.Health_Facility_Registry.entity.LoginStatusModel;
import com.saipal.Health_Facility_Registry.entity.PaginationEntity;
import com.saipal.Health_Facility_Registry.entity.Users;
import com.saipal.Health_Facility_Registry.repository.ApiUsersRepo;
import com.saipal.Health_Facility_Registry.repository.ApilogRepo;
import com.saipal.Health_Facility_Registry.service.HealthFacilityService;
import com.saipal.Health_Facility_Registry.service.MyuserDetailsService;
import com.saipal.Health_Facility_Registry.service.UsersService;
import com.saipal.Health_Facility_Registry.util.JwtUtils;


import javassist.bytecode.stackmap.BasicBlock.Catch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UsersRestController {
	@Autowired
	UsersService usersService;
	LoginStatusModel loginStatusModel;
	JSONObject result= new JSONObject();
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtTokenutils; 
	@Autowired
	ApiUsersRepo apiusersRepo;
	
	@Autowired
	ApilogRepo apilogRepo;
	@Autowired
	MyuserDetailsService userDetailsServices;
	@Autowired
	ObjectMapper objectMapper;
	@Qualifier("encoder")
	@Autowired
	PasswordEncoder passwordEncoder;
	CSVPrinter csvPrinter;

	@RequestMapping("health_registry/municipality/list")
	@ResponseBody public List getAllMunc(@RequestParam(name = "search", defaultValue = "") String search) {
//		System.out.println("Search:" + usersService.getUsers().get(0).getUsername());
		return usersService.getAllMuncs(search);
	}
	

	@RequestMapping("health_registry/user_list/list")
	@ResponseBody public List<Users> getAllUser(@RequestParam(name = "search", defaultValue = "") String search,@RequestParam(name = "role", defaultValue = "") String role,@RequestParam(name = "rid", defaultValue = "") String rid) {
//		System.out.println("Search:" + usersService.getUsers().get(0).getUsername());
		if(role.equals("superuser")) {
			return usersService.getAllUsers(search);
		}else if(role.equals("provincial")) {
			return usersService.getAllUserProv(search,rid);
			
		}else {
			return null;
		}
		
	}
	
	@RequestMapping("health_registry/api_list/list")
	@ResponseBody public List<ApiSignUpUsersEntity> getAllUsers(@RequestParam(name = "search", defaultValue = "") String search) {
//		System.out.println("Search:" + usersService.getUsers().get(0).getUsername());
		return apiusersRepo.getAllApiUsers(search);
	}
	@RequestMapping("health_registry/api_log/list")
	@ResponseBody public List<ApiLog> getAllLogs(@RequestParam(name = "search", defaultValue = "") String search) {
		System.out.println("Search:" + usersService.getUsers().get(0).getUsername());
		return apilogRepo.getAllApiLogs(search);
	}
	

	@RequestMapping(value = "health_registry/api_list/enable/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String enableApiUser (@PathVariable(name="id") int id){
		apiusersRepo.enableUser(id);
		return "saved successfull";
	}
	
	@RequestMapping(value = "health_registry/api_list/disable/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String disableApiUser (@PathVariable(name="id") int id){
		apiusersRepo.disableUser(id);
		return "saved successfull";
	}
	
	
	@RequestMapping("health_registry/user_list/edit/{id}")
	public Users getUsers(@PathVariable(name = "id") int id) {
//		System.out.println(usersService.getUser(id));
		return usersService.getUser(id);

	}
	
	@RequestMapping("health_registry/municipality/edit/{id}")
	public List getMuns(@PathVariable(name = "id") String id) {
		System.out.println(id);
		System.out.println(usersService.getMuncis(id));
		return usersService.getMuncis(id);

	}
	
	@RequestMapping(value = "health_registry/municipality/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateLaboratory (HttpServletRequest request,@PathVariable(name="id") int id,
			@RequestParam(name = "nameen", defaultValue = "") String nameen,@RequestParam(name = "namenp", defaultValue = "") String namenp,
			@RequestParam(name = "ward", defaultValue = "") String ward){
		
		usersService.addMuncipality(id,nameen,namenp,ward);
		return "saved successfull";
	}
	
	
	@RequestMapping(value = "/login/user",method = RequestMethod.POST)
	@ResponseBody
		public String createAuthenticationToken(@RequestBody Login login,HttpServletRequest request) throws Exception {
	
		try {
			
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getemail(), login.getPassword()));
			
		final UserDetails userDetails = userDetailsServices.loadUserByUsername(login.getemail());
//		System.out.println("here "+userDetails.toString());
		List<Users>users= usersService.getUsers(userDetails.getUsername());
		String jwtToken = jwtTokenutils.generateToken(userDetails);
		for(Users u: users) {
			 loginStatusModel = new LoginStatusModel(u.getId(),u.getUsername(),u.getRole(),u.getProvince(),u.getDistrict(),u.getMunicipality(),jwtToken,u.getOrgid());
			    HttpSession session = request.getSession(true); // create new session if not exists
		        session.setAttribute("userId", u.getId());
		        System.out.println("Session of users: "+session.getAttribute("userId"));
		}
		
		
		result.put("Status","1");
		result.put("user", new JSONObject(loginStatusModel));
	}
	catch (Exception e) {
		
		result.put("Status","0");
		result.put("user", new JSONObject());
		return result.toString();
	
	
	}
	
	
	
	
	 return result.toString();
	}
	
	
	
	@RequestMapping(value = "/userSignup",method = RequestMethod.POST)
	public @ResponseBody String addUserSignup(@RequestBody Users users) {
		Users u =new Users();
		u.setDistrict(users.getDistrict());
		u.setEmail(users.getEmail());
		u.setFirstname(users.getFirstname());
		u.setMobile(users.getMobile());
		u.setMunicipality(users.getMunicipality());
		u.setProvince(users.getProvince());
		u.setRole(users.getRole());
		u.setSurname(users.getSurname());
		u.setUsername(users.getUsername());	
		u.setOrgid(users.getOrgid());
		u.setPassword(passwordEncoder.encode(users.getPassword()));
		usersService.addUser(u);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/userUpdate/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateUser (@RequestBody Users users,@PathVariable(name="id") int id){
		Users u =new Users();
		u.setId(id);
		u.setDistrict(users.getDistrict());
		u.setEmail(users.getEmail());
		u.setFirstname(users.getFirstname());
		u.setMobile(users.getMobile());
		u.setMunicipality(users.getMunicipality());
		u.setProvince(users.getProvince());
		u.setRole(users.getRole());
		u.setSurname(users.getSurname());
		u.setUsername(users.getUsername());	
		u.setOrgid(users.getOrgid());
		u.setPassword(passwordEncoder.encode(users.getPassword()));
		usersService.addUser(u);
		return "saved successfull";
	}



	@RequestMapping("/health_registry/user_list/download")
	public void exportCSV(@RequestParam(name = "search", defaultValue = "") String search, HttpServletResponse response) throws Exception {

		//set file name and content type
		String filename = "user.csv";
		List<Users> users= usersService.getAllUsers(search);

		try {
			response.setContentType("text/csv");
			response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=\"" + filename + "\"");
			csvPrinter = new CSVPrinter(response.getWriter(),
					CSVFormat.EXCEL.withHeader("Id", "Username", "Province","District","Municipality","Role"));

			for (Users user : users) {
				if (user.getProvince()==null){
					csvPrinter.printRecord(Arrays.asList(user.getId(),user.getUsername(),"","","",user.getRole()));
				}
				else if(user.getDistrict()==null){
					csvPrinter.printRecord(Arrays.asList(user.getId(),user.getUsername(),user.getProvinces().getNameen(),"","",user.getRole()));

				}
				else if(user.getMunicipality().equals(null)){
					csvPrinter.printRecord(Arrays.asList(user.getId(),user.getUsername(),user.getProvinces().getNameen(),user.getDistricts().getNameen(),"",user.getRole()));
				}
				else {
					csvPrinter.printRecord(Arrays.asList(user.getId(),user.getUsername(), user.getProvinces().getNameen(),user.getDistricts().getNameen(),user.getMunicipalitys().getNameen(),user.getRole()));

				}
//				System.out.println("district:"+user.getDistricts());

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(csvPrinter != null)
				csvPrinter.close();
		}

	}




}
