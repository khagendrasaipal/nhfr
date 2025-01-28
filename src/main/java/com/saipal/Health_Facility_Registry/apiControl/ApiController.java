package com.saipal.Health_Facility_Registry.apiControl;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saipal.Health_Facility_Registry.entity.ApiLog;
import com.saipal.Health_Facility_Registry.entity.ApiLoginResponse;
import com.saipal.Health_Facility_Registry.entity.ApiSignUpUsersEntity;
import com.saipal.Health_Facility_Registry.entity.DeviceItem;
import com.saipal.Health_Facility_Registry.entity.HealthFacility;
import com.saipal.Health_Facility_Registry.entity.Login;
import com.saipal.Health_Facility_Registry.entity.OwnerItem;
import com.saipal.Health_Facility_Registry.entity.PaginationEntity;
import com.saipal.Health_Facility_Registry.entity.WorkerItem;
import com.saipal.Health_Facility_Registry.repository.ApiExchangeRepo;
import com.saipal.Health_Facility_Registry.repository.HealthFacilityRepo;
import com.saipal.Health_Facility_Registry.repository.HfServicesRepo;
import com.saipal.Health_Facility_Registry.service.ApiUserService;
import com.saipal.Health_Facility_Registry.service.HealthFacilityService;
import com.saipal.Health_Facility_Registry.service.MyCustomApiDetailsUser;
import com.saipal.Health_Facility_Registry.service.UsersService;
import com.saipal.Health_Facility_Registry.util.DB;
import com.saipal.Health_Facility_Registry.util.JwtUtils;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

	@Autowired
	ApiService apiService;

	@Autowired
	DB db;

	@Autowired
	ApiUserService apiUserService;

	@Qualifier("encoder")
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UsersService usersService;
	ApiLoginResponse apiLoginResponse;
	JSONObject result = new JSONObject();

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	HealthFacilityService healthFacilityService;

	@Autowired
	HealthFacilityRepo healthFacilityRepo;

	@Autowired
	JwtUtils jwtTokenutils;

	@Autowired
	MyCustomApiDetailsUser myapiDetailsService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	HfServicesRepo hfServicesRepo;

	@RequestMapping(value = "apiLogin", method = RequestMethod.POST)
	public @ResponseBody String apiLogin(@RequestBody Login login) {
		try {
			final UserDetails userDetails = myapiDetailsService.loadUserByUsername(login.getemail(),
					login.getPassword());
			List<ApiSignUpUsersEntity> users = apiUserService.getApiUser(userDetails.getUsername());
			for (ApiSignUpUsersEntity u : users) {
				apiLoginResponse = new ApiLoginResponse(u.getId(), u.getToken(), u.getFullname(), u.getUsername());
			}
			result.put("Status", "1");
			result.put("user", new JSONObject(apiLoginResponse));
		} catch (Exception e) {
			result.put("Status", "0");
			result.put("user", new JSONObject());
			return result.toString();
		}

		return result.toString();
	}

	@RequestMapping(value = "/getHf", method = RequestMethod.POST)
	public List<Map<String, Object>> getPagination(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);
		System.out.println("token: " + token);
		if (paginationEntity.getPageno() == 0) {
			return new ArrayList<>();
		} else {
			return apiService.getAllPagination(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(),
					paginationEntity.getSortby(), token);
		}
	}

	@RequestMapping(value = "/getHfSearch", method = RequestMethod.POST)
	public List<Map<String, Object>> getHfSearch(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfSearch(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(), token,
				paginationEntity.getSortby(), paginationEntity.getSearchKeyword());
	}

	@RequestMapping(value = "/getHfByHfCode", method = RequestMethod.POST)
	public List<Map<String, Object>> getHfByCode(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfbycode(paginationEntity.getCode(), token);
	}

	@RequestMapping(value = "/getHfByProvince", method = RequestMethod.POST)
	public List<Map<String, Object>> getHfByProvince(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfbyProvince(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(),
				paginationEntity.getSortby(), token, paginationEntity.getProvince());
	}

	@RequestMapping(value = "/getHfByDistrict", method = RequestMethod.POST)
	public List<Map<String, Object>> getHfByDistrict(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfbyDistrict(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(),
				paginationEntity.getSortby(), token, paginationEntity.getDistrict());
	}

	@RequestMapping(value = "/getHfByMunicipality", method = RequestMethod.POST)
	public List<Map<String, Object>> getHfByMunicipality(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfbyMunicipality(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(),
				paginationEntity.getSortby(), token, paginationEntity.getMunicipality());
	}

	@RequestMapping(value = "/createHf", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> addFacilityType(@RequestBody HealthFacility healthFacility,
			@RequestParam(name = "serviceArray", defaultValue = "500") String serviceArray,
			@RequestParam(name = "hfs", defaultValue = "500") String hfs,
			@RequestParam(name = "newserviceArray", defaultValue = "500") String newserviceArray,
			@RequestParam(name = "opdArray", defaultValue = "500") String opdArray,
			@RequestParam(name = "surgicArray", defaultValue = "500") String surgicArray,
			@RequestParam(name = "speclArray", defaultValue = "500") String speclArray,
			@RequestParam(name = "labArray", defaultValue = "500") String labArray,
			@RequestParam(name = "radioArray", defaultValue = "500") String radioArray,
			@RequestParam(name = "freeArray", defaultValue = "500") String freeArray,
			@RequestParam(name = "ayurArray", defaultValue = "500") String ayurArray,
			@RequestParam(name = "familyArray", defaultValue = "500") String familyArray,
			@RequestParam(name = "motherArray", defaultValue = "500") String motherArray,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		String munc = healthFacility.getMunicipality();
		int type = healthFacility.getType();
		int flvl = healthFacility.getLevel();
		String[] hf = healthFacilityRepo.findCodess(munc);

		if (hf != null && hf.length > 0) {
			String[] ss = hf[0].split(",");
			int ucode = Integer.parseInt(ss[1]) + 1;
			String ucodes = String.format("%04d", ucode);
			String hfcod = ss[0] + ucodes + type;
			healthFacility.setCbscode(Integer.parseInt(ss[0]));
			healthFacility.setUcode(Integer.parseInt(ucodes));
			BigInteger numBig = new BigInteger(hfcod);
			healthFacility.setHf_code(numBig);
		} else {
			int cbs = healthFacilityRepo.getCbsCodes(munc);
			String ucodes = String.format("%04d", 1);
			String hfcod = cbs + ucodes + type;
			healthFacility.setCbscode(cbs);
			healthFacility.setUcode(Integer.parseInt(ucodes));
			BigInteger numBig = new BigInteger(hfcod);
			healthFacility.setHf_code(numBig);
		}

		int lid = 0;
		apiService.addFacilityType(healthFacility, token);
		lid = healthFacility.getId();
		String[] nsresult = newserviceArray.split(",");

//		apiexchangeRepo.addApiData(lid,"create");
		healthFacilityRepo.addHistoryLevel(lid, flvl);
		if (healthFacility.getOnlinestatus() == 1) {
			healthFacilityRepo.updateOnline(lid);
		}

		if (healthFacility.getDeviceitems() != null) {
			for (DeviceItem item : healthFacility.getDeviceitems()) {
				// Print each property of the DeviceItem
				System.out.println("Device Item Name: " + item.getDname());
				healthFacilityRepo.addDevice(lid, item.getDname(), item.getDsource(), item.getRemarks());
			}
		}

		if (healthFacility.getOwneritems() != null) {
			for (OwnerItem item : healthFacility.getOwneritems()) {
				// Print each property of the DeviceItem
				System.out.println("Owner Item Name: " + item.getOname());
				healthFacilityRepo.addOwner(lid, item.getOname(), item.getOaddress(), item.getOctzn(),
						item.getOmobile(), item.getOemail());
			}
		}

		if (healthFacility.getWorkeritems() != null) {
			for (WorkerItem item : healthFacility.getWorkeritems()) {
				String iid = db.newIdInt();
				String sql = "insert into tbl_employee_import(id,orgidint,importid,workforceid,nameen,namenp,nid,email,dob,province,district,palika,gender,mobile,council,council_no,pis,ppis,apoint_date,att_date,ethnicity,emptype,authlevel,level,empstatus,worktype,education,qualification,created_by,code,groupid,subgroupid,postid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				db.execute(sql, Arrays.asList(iid, lid, lid, 0, item.getNameen(), item.getNamenp(), item.getNid(),
						item.getHwemail(), item.getDob(), item.getProvinceid(), item.getDistrictid(),
						item.getPalikaid(), item.getGender(), item.getHwmobile(), item.getCouncil(),
						item.getCouncilno(), item.getPis(), item.getPpis(), item.getApoint_date(), item.getAtt_date(),
						item.getEthnicity(), item.getEmptype(), item.getDarbanditype(), item.getEmplevel(),
						item.getEmpstatus(), item.getWorktype(), item.getEducation(), item.getQualification(), 0, 0,
						item.getGroupid(), item.getSubgroupid(), item.getPostid()));
			}
		}

		if (!"500".equals(hfs)) {
			String[] hservice = hfs.split(",");

			for (String s : hservice) {

				healthFacilityRepo.inserthealthservice(lid, s);
			}
		}

		if (!"500".equals(nsresult[0])) {
			for (String s : nsresult) {
				healthFacilityRepo.addNewServices(lid, s);
				healthFacilityRepo.addNewHistoryServices(lid, s);
			}
		}
		List<Map<String, Object>> list = new ArrayList<>();

		Map<String, Object> mapadmlvl = new HashMap<>();
		mapadmlvl.put("response", "Created Successfully");
		mapadmlvl.put("status", "200 OK");

		list.add(mapadmlvl);

		return list;
	}

	private String extractBearerToken(String authorizationHeader) {
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			return authorizationHeader.substring(7);
		} else {
			throw new IllegalArgumentException("Invalid Authorization header format.");
		}
	}

	@RequestMapping("/edit/{id}")
	public HealthFacility getFacilityType(@PathVariable(name = "id") int id) {
		return apiService.get(id);
	}

//	@Transactional
//	@RequestMapping(value = "/updateHf/{id}", method = RequestMethod.PUT)
//	public @ResponseBody ResponseEntity<List<Map<String, Object>>> updateFacilityType(@RequestBody HealthFacility healthFacility,
//			@PathVariable(name = "id") int id,
//			@RequestParam(name = "serviceArray", defaultValue = "500") String serviceArray,
//			@RequestParam(name = "hfs", defaultValue = "500") String hfs,
//			@RequestParam(name = "newserviceArray", defaultValue = "500") String newserviceArray,
//			@RequestParam(name = "opdArray", defaultValue = "500") String opdArray,
//			@RequestParam(name = "surgicArray", defaultValue = "500") String surgicArray,
//			@RequestParam(name = "speclArray", defaultValue = "500") String speclArray,
//			@RequestParam(name = "labArray", defaultValue = "500") String labArray,
//			@RequestParam(name = "radioArray", defaultValue = "500") String radioArray,
//			@RequestParam(name = "freeArray", defaultValue = "500") String freeArray,
//			@RequestParam(name = "ayurArray", defaultValue = "500") String ayurArray,
//			@RequestParam(name = "familyArray", defaultValue = "500") String familyArray,
//			@RequestParam(name = "motherArray", defaultValue = "500") String motherArray,
//			@RequestParam(name = "history",defaultValue ="1") String history,
//			@RequestHeader("Authorization") String authorizationHeader) {
//		
//
//		String token = extractBearerToken(authorizationHeader);
//
//		healthFacility.setId(id);
//		System.out.println("This is the id: " + id);
//		int flvl = healthFacility.getLevel();
//		String munc = healthFacility.getMunicipality();
//		int type = healthFacility.getType();
//
//		String rt = healthFacility.getRtype();
//		int on = healthFacility.getOnlinestatus();
//
//		String phf[] = healthFacilityRepo.findPreviouscode(id);
//		String sphf[] = phf[0].split(",");
//		String cbscode;
//		int ucode;
//		if (sphf[2].equals(munc)) {
//			ucode = Integer.parseInt(sphf[1]);
//			cbscode = sphf[0];
//		} else {
//			String[] hf = healthFacilityRepo.findCodess(munc);
//			if (hf != null && hf.length > 0) {
//				String[] ss = hf[0].split(",");
//				ucode = Integer.parseInt(ss[1]) + 1;
//				cbscode = ss[0];
//
//			} else {
//				int cbs = healthFacilityRepo.getCbsCodes(munc);
//				ucode = 1;
//				cbscode = String.valueOf(cbs);
//
//			}
//		}
//		String ucodes = String.format("%04d", ucode);
//		String hfcod = cbscode + ucodes + type;
//		healthFacility.setCbscode(Integer.parseInt(cbscode));
//		healthFacility.setUcode(Integer.parseInt(ucodes));
//		BigInteger numBig = new BigInteger(hfcod);
//		healthFacility.setHf_code(numBig);
//		if (history.equals("1")) {
//			healthFacilityRepo.addFacilityHistory(id);
//		}
//		apiService.addFacilityType(healthFacility, token);
////		apiexchangeRepo.addApiData(id, "update");
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		if (history.equals("1")) {
//			int plevel = healthFacilityRepo.findlevels(id);
//			if (plevel != flvl) {
//				healthFacilityRepo.updateFlevelhistory(id, plevel, timestamp);
//				healthFacilityRepo.addHistoryLevel(id, flvl);
//			}
//		}
//		String[] nsresult = newserviceArray.split(",");
//		String[] npsresult = hfServicesRepo.findAllNewServiceByHfid(id);
//		String[] hservice = hfs.split(",");
//		healthFacilityRepo.deletehealthService(id);
//		for (String s : hservice) {
//
//			healthFacilityRepo.inserthealthservice(id, s);
//		}
//
//		if (healthFacility.getDeviceitems() != null) {
//			healthFacilityRepo.deletedevice(id);
//			for (DeviceItem item : healthFacility.getDeviceitems()) {
//				healthFacilityRepo.addDevice(id, item.getDname(), item.getDsource(), item.getRemarks());
//
//			}
//		}
//
//		if (healthFacility.getOwneritems() != null) {
//			healthFacilityRepo.deleteowner(id);
//			for (OwnerItem item : healthFacility.getOwneritems()) {
//				healthFacilityRepo.addOwner(id, item.getOname(), item.getOaddress(), item.getOctzn(), item.getOmobile(),
//						item.getOemail());
//
//			}
//		}
//
//		if (healthFacility.getWorkeritems() != null) {
//			healthFacilityRepo.deleteWorker(id);
//			for (WorkerItem item : healthFacility.getWorkeritems()) {
//				// Print each property of the DeviceItem
//				String iid = db.newIdInt();
//				String sql = "insert into tbl_employee_import(id,orgidint,importid,workforceid,nameen,namenp,nid,email,dob,province,district,palika,gender,mobile,council,council_no,pis,ppis,apoint_date,att_date,ethnicity,emptype,authlevel,level,empstatus,worktype,education,qualification,created_by,code,groupid,subgroupid,postid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//				db.execute(sql, Arrays.asList(iid, id, id, 0, item.getNameen(), item.getNamenp(), item.getNid(),
//						item.getHwemail(), item.getDob(), item.getProvinceid(), item.getDistrictid(),
//						item.getPalikaid(), item.getGender(), item.getHwmobile(), item.getCouncil(),
//						item.getCouncilno(), item.getPis(), item.getPpis(), item.getApoint_date(), item.getAtt_date(),
//						item.getEthnicity(), item.getEmptype(), item.getDarbanditype(), item.getEmplevel(),
//						item.getEmpstatus(), item.getWorktype(), item.getEducation(), item.getQualification(), 0, 0,
//						item.getGroupid(), item.getSubgroupid(), item.getPostid()));
//			}
//		}
//
//		HashSet<String> nsadded = new HashSet<String>(Arrays.asList(nsresult));
//		nsadded.removeAll(Arrays.asList(npsresult));
//		HashSet<String> nsremoved = new HashSet<String>(Arrays.asList(npsresult));
//		nsremoved.removeAll(Arrays.asList(nsresult));
//
//		if (!"500".equals(nsresult[0])) {
//			for (String s : nsadded) {
//				healthFacilityRepo.addNewServices(id, s);
//				healthFacilityRepo.addNewHistoryServices(id, s);
//			}
//		}
//		for (String s : nsremoved) {
//			healthFacilityRepo.deleteNewService(id, s);
//			healthFacilityRepo.updateNewHistoryServices(id, s, timestamp);
//		}
//
//		List<Map<String, Object>> list = new ArrayList<>();
//		System.out.println("upto here" + on + " rt" + rt);
//		if (on != 0) {
//			if (rt.equals("2") && on == 1) {
//				String sqs = "update hfregistry set soft_delete=1,onlinestatus=1 where id=" + id;
//				db.execute(sqs);
//
//				String hfcode = healthFacility.getHf_code().toString();
//				String lid = healthFacility.getId().toString();
//				String confirmation = lid + hfcode;
////					List<Map<String, Object>> list = new ArrayList<>();
//
//				Map<String, Object> mapadmlvl = new HashMap<>();
//				mapadmlvl.put("Status", " 200 OK");
//				mapadmlvl.put("response", "");
//
//				list.add(mapadmlvl);
//
//				return ResponseEntity.ok(list);
//			}
//		}
//
//		Map<String, Object> mapadmlvl = new HashMap<>();
//		mapadmlvl.put("Status", " 200 OK");
//		mapadmlvl.put("Location", "200");
//
//		 list.add(mapadmlvl);
//
//		 return ResponseEntity.ok(list);
//	}

	@Transactional
	@RequestMapping(value = "/updateHf/{id}", method = RequestMethod.PUT)
	public @ResponseBody Map<String, Object> updateFacilityType(@RequestBody HealthFacility healthFacility,
			@PathVariable(name = "id") int id,
			@RequestParam(name = "serviceArray", defaultValue = "500") String serviceArray,
			@RequestParam(name = "hfs", defaultValue = "500") String hfs,
			@RequestParam(name = "newserviceArray", defaultValue = "500") String newserviceArray,
			@RequestParam(name = "opdArray", defaultValue = "500") String opdArray,
			@RequestParam(name = "surgicArray", defaultValue = "500") String surgicArray,
			@RequestParam(name = "speclArray", defaultValue = "500") String speclArray,
			@RequestParam(name = "labArray", defaultValue = "500") String labArray,
			@RequestParam(name = "radioArray", defaultValue = "500") String radioArray,
			@RequestParam(name = "freeArray", defaultValue = "500") String freeArray,
			@RequestParam(name = "ayurArray", defaultValue = "500") String ayurArray,
			@RequestParam(name = "familyArray", defaultValue = "500") String familyArray,
			@RequestParam(name = "motherArray", defaultValue = "500") String motherArray,
			@RequestParam(name = "history", defaultValue = "1") String history,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> mapadmlvl = new HashMap<>();
		// Validate that the body contains at least the 'name' attribute
		if (healthFacility.getHf_name() == null || healthFacility.getHf_name().trim().isEmpty()) {
			mapadmlvl.put("Status", "400 Bad Request");
			mapadmlvl.put("message", "Health Facility Name error");
			return mapadmlvl;
		}

		// Check if the facility exists
		if (!healthFacilityRepo.existsById(id)) {
			mapadmlvl.put("code", "404 Not Found");
			mapadmlvl.put("message", "Resource not found");
			return mapadmlvl;
		}

//	    // Load the existing facility to validate immutable fields
//	    if(!healthFacilityRepo.findById(id).equals(id)) {
//	    	  mapadmlvl.put("code", "404 Not Found");
//		        mapadmlvl.put("message", "Resource not found");
//		        return mapadmlvl;
//	    }

		// Ensure immutable properties are not altered
		if (healthFacility.getId() != null && healthFacility.getId() != id) {
			mapadmlvl.put("Status", "400 Bad Request");
			mapadmlvl.put("message", "Id error");
			return mapadmlvl;
		}

		healthFacility.setId(id);

		System.out.println("This is the id: " + id);
		int flvl = healthFacility.getLevel();
		String munc = healthFacility.getMunicipality();
		int type = healthFacility.getType();

		String rt = healthFacility.getRtype();
		int on = healthFacility.getOnlinestatus();

		String phf[] = healthFacilityRepo.findPreviouscode(id);
		String sphf[] = phf[0].split(",");
		String cbscode;
		int ucode;
		if (sphf[2].equals(munc)) {
			ucode = Integer.parseInt(sphf[1]);
			cbscode = sphf[0];
		} else {
			String[] hf = healthFacilityRepo.findCodess(munc);
			if (hf != null && hf.length > 0) {
				String[] ss = hf[0].split(",");
				ucode = Integer.parseInt(ss[1]) + 1;
				cbscode = ss[0];

			} else {
				int cbs = healthFacilityRepo.getCbsCodes(munc);
				ucode = 1;
				cbscode = String.valueOf(cbs);

			}
		}
		String ucodes = String.format("%04d", ucode);
		String hfcod = cbscode + ucodes + type;
		healthFacility.setCbscode(Integer.parseInt(cbscode));
		healthFacility.setUcode(Integer.parseInt(ucodes));
		BigInteger numBig = new BigInteger(hfcod);
		healthFacility.setHf_code(numBig);
		if (history.equals("1")) {
			healthFacilityRepo.addFacilityHistory(id);
		}
		apiService.addFacilityType(healthFacility, token);

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (history.equals("1")) {
			int plevel = healthFacilityRepo.findlevels(id);
			if (plevel != flvl) {
				healthFacilityRepo.updateFlevelhistory(id, plevel, timestamp);
				healthFacilityRepo.addHistoryLevel(id, flvl);
			}
		}
		String[] nsresult = newserviceArray.split(",");
		String[] npsresult = hfServicesRepo.findAllNewServiceByHfid(id);
		String[] hservice = hfs.split(",");
		healthFacilityRepo.deletehealthService(id);
		for (String s : hservice) {
			healthFacilityRepo.inserthealthservice(id, s);
		}

		if (healthFacility.getDeviceitems() != null) {
			healthFacilityRepo.deletedevice(id);
			for (DeviceItem item : healthFacility.getDeviceitems()) {
				healthFacilityRepo.addDevice(id, item.getDname(), item.getDsource(), item.getRemarks());
			}
		}

		if (healthFacility.getOwneritems() != null) {
			healthFacilityRepo.deleteowner(id);
			for (OwnerItem item : healthFacility.getOwneritems()) {
				healthFacilityRepo.addOwner(id, item.getOname(), item.getOaddress(), item.getOctzn(), item.getOmobile(),
						item.getOemail());
			}
		}

		if (healthFacility.getWorkeritems() != null) {
			healthFacilityRepo.deleteWorker(id);
			for (WorkerItem item : healthFacility.getWorkeritems()) {
				String iid = db.newIdInt();
				String sql = "insert into tbl_employee_import(id,orgidint,importid,workforceid,nameen,namenp,nid,email,dob,"
						+ "province,district,palika,gender,mobile,council,council_no,pis,ppis,apoint_date,att_date,ethnicity,"
						+ "emptype,authlevel,level,empstatus,worktype,education,qualification,created_by,code,groupid,subgroupid,postid) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				db.execute(sql, Arrays.asList(iid, id, id, 0, item.getNameen(), item.getNamenp(), item.getNid(),
						item.getHwemail(), item.getDob(), item.getProvinceid(), item.getDistrictid(),
						item.getPalikaid(), item.getGender(), item.getHwmobile(), item.getCouncil(),
						item.getCouncilno(), item.getPis(), item.getPpis(), item.getApoint_date(), item.getAtt_date(),
						item.getEthnicity(), item.getEmptype(), item.getDarbanditype(), item.getEmplevel(),
						item.getEmpstatus(), item.getWorktype(), item.getEducation(), item.getQualification(), 0, 0,
						item.getGroupid(), item.getSubgroupid(), item.getPostid()));
			}
		}

		HashSet<String> nsadded = new HashSet<String>(Arrays.asList(nsresult));
		nsadded.removeAll(Arrays.asList(npsresult));
		HashSet<String> nsremoved = new HashSet<String>(Arrays.asList(npsresult));
		nsremoved.removeAll(Arrays.asList(nsresult));

		if (!"500".equals(nsresult[0])) {
			for (String s : nsadded) {
				healthFacilityRepo.addNewServices(id, s);
				healthFacilityRepo.addNewHistoryServices(id, s);
			}
		}
		for (String s : nsremoved) {
			healthFacilityRepo.deleteNewService(id, s);
			healthFacilityRepo.updateNewHistoryServices(id, s, timestamp);
		}

		System.out.println("upto here" + on + " rt" + rt);
		if (on != 0) {
			if (rt.equals("2") && on == 1) {
				String sqs = "update hfregistry set soft_delete=1,onlinestatus=1 where id=" + id;
				db.execute(sqs);

				String hfcode = healthFacility.getHf_code().toString();
				String lid = healthFacility.getId().toString();
//				String confirmation = lid + hfcode;

//	            Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("Status", " 200 OK");
				mapadmlvl.put("response", "");
				list.add(mapadmlvl);
				return mapadmlvl;
			}
		}
		mapadmlvl.put("Status", " 200 OK");
		mapadmlvl.put("Location", String.format("http://182.93.95.238:8084/api/v1/updateHf/%s.json", id));

		list.add(mapadmlvl);

		return mapadmlvl;
	}

	@RequestMapping(value = "/deleteHf/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteFtype(@PathVariable(name = "id") int id) {
		Map<String, Object> mapadmlvl = new HashMap<>();

		if (!healthFacilityRepo.existsById(id)) {
			mapadmlvl.put("code", 404);
			mapadmlvl.put("message", "Resource not found");
			return mapadmlvl;
		}
		apiService.delete(id);
		mapadmlvl.put("code", "200 OK");
		mapadmlvl.put("id", String.valueOf(id));
		mapadmlvl.put("message", "Resource deleted");
		return mapadmlvl;
	}
}
