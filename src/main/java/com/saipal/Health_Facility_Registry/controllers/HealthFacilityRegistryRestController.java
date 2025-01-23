package com.saipal.Health_Facility_Registry.controllers;



import java.io.IOException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saipal.Health_Facility_Registry.entity.ApiExchange;
import com.saipal.Health_Facility_Registry.entity.ApiLog;
import com.saipal.Health_Facility_Registry.entity.DeviceItem;
import com.saipal.Health_Facility_Registry.entity.HealthFacility;
import com.saipal.Health_Facility_Registry.entity.HfAyurvedService;
import com.saipal.Health_Facility_Registry.entity.HfFamilyPlanningService;
import com.saipal.Health_Facility_Registry.entity.HfLaboratoryService;
import com.saipal.Health_Facility_Registry.entity.HfMotherhoodService;
import com.saipal.Health_Facility_Registry.entity.HfOpdService;
import com.saipal.Health_Facility_Registry.entity.HfRadiologyService;
import com.saipal.Health_Facility_Registry.entity.HfServices;
import com.saipal.Health_Facility_Registry.entity.HfSpecializedService;
import com.saipal.Health_Facility_Registry.entity.HfSurgicalService;
import com.saipal.Health_Facility_Registry.entity.LoginStatusModel;
import com.saipal.Health_Facility_Registry.entity.Municipality;
import com.saipal.Health_Facility_Registry.entity.NewHfServices;
import com.saipal.Health_Facility_Registry.entity.OwnerItem;
import com.saipal.Health_Facility_Registry.entity.PaginationEntity;
import com.saipal.Health_Facility_Registry.entity.UserHf;
import com.saipal.Health_Facility_Registry.entity.WorkerItem;
import com.saipal.Health_Facility_Registry.repository.ApiExchangeRepo;
import com.saipal.Health_Facility_Registry.repository.HealthFacilityRepo;
import com.saipal.Health_Facility_Registry.repository.HfAyurvedRepo;
import com.saipal.Health_Facility_Registry.repository.HfBipannaRepo;
import com.saipal.Health_Facility_Registry.repository.HfFamilyPlanningRepo;
import com.saipal.Health_Facility_Registry.repository.HfLaboratoryRepo;
import com.saipal.Health_Facility_Registry.repository.HfMotherhoodRepo;
import com.saipal.Health_Facility_Registry.repository.HfOpdRepo;
import com.saipal.Health_Facility_Registry.repository.HfRadiologyRepo;
import com.saipal.Health_Facility_Registry.repository.HfServicesRepo;
import com.saipal.Health_Facility_Registry.repository.HfSpecializedRepo;
import com.saipal.Health_Facility_Registry.repository.HfSurgicalRepo;
import com.saipal.Health_Facility_Registry.repository.MunicipalityRepo;
import com.saipal.Health_Facility_Registry.repository.NewHfServicesRepo;
import com.saipal.Health_Facility_Registry.service.ApilogService;
import com.saipal.Health_Facility_Registry.service.HealthFacilityService;
import com.saipal.Health_Facility_Registry.util.JwtUtils;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/health-registry")
public class HealthFacilityRegistryRestController {

	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	ApilogService apilogservice;
	
	@Autowired
	ApiExchangeRepo apiexchangeRepo;
	
	
	@Autowired
	HealthFacilityService HealthFacilityService;
	@Autowired
	HealthFacilityRepo healthFacilityRepo;
	@Autowired
	HfServicesRepo hfServicesRepo;
	@Autowired
	HfOpdRepo hfOpdRepo;
	
	@Autowired
	NewHfServicesRepo nhfrepo;
	
	@Autowired
	HfSurgicalRepo hfSurgicRepo;
	@Autowired
	HfSpecializedRepo hfSpecialRepo;
	@Autowired
	HfLaboratoryRepo hfLabRepo;
	@Autowired
	HfRadiologyRepo hfRadioRepo;
	@Autowired
	HfBipannaRepo hfBipannaRepo;
	@Autowired
	HfAyurvedRepo hfAyurRepo;
	@Autowired
	HfFamilyPlanningRepo hfFamilyRepo;
	@Autowired
	HfMotherhoodRepo hfMotherRepo;
	@Qualifier("encoder")
	@Autowired
	PasswordEncoder passwordEncoder;
	CSVPrinter csvPrinter;
	@Autowired
	MunicipalityRepo muncRepo;
	@Autowired
	com.saipal.Health_Facility_Registry.util.DB db;
	

//	@RequestMapping("/list")
//	public List<HealthFacility> getAllFacilityType(@RequestParam(name = "search", defaultValue = "") String search) {
////		System.out.println("Search:" + search);
//		return HealthFacilityService.getFacilityType(search);
//	}
	
	@RequestMapping("/list")
	public List<HealthFacility> getAllFacilityType(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "cp", defaultValue = "") int cp,
			@RequestParam(name = "ps", defaultValue = "") int ps) {
//		System.out.println("Search:" + search);
//		String pn="1";
		if(1==0) {
			return new ArrayList<HealthFacility>();
		}else {
//		return HealthFacilityService.getFacilityType(search);
			return HealthFacilityService.getAllList(cp-1,ps,"id",search);
		}
	}
	
	@RequestMapping("/listbed")
	public List<HealthFacility> listbed(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "cp", defaultValue = "") int cp,
			@RequestParam(name = "ps", defaultValue = "") int ps) {

			return HealthFacilityService.getAllListbed(cp-1,ps,"id",search);
		
	}
	
	@RequestMapping("/list-online")
	public List<HealthFacility> getAllFacilityTypeOnline(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "cp", defaultValue = "") int cp,
			@RequestParam(name = "ps", defaultValue = "") int ps) {
//		System.out.println("Search:" + search);
//		String pn="1";
		if(1==0) {
			return new ArrayList<HealthFacility>();
		}else {
//		return HealthFacilityService.getFacilityType(search);
			return HealthFacilityService.getAllListOnline(cp-1,ps,"id",search);
		}
	}
//	
//	public List<HealthFacility> getPagination(@RequestBody PaginationEntity paginationEntity) {
////		System.out.println(paginationEntity.getToken());
//		if(paginationEntity.getPageno()==0) {
//			return new ArrayList<HealthFacility>();
//		}
//		else {
//			return HealthFacilityService.getAllPagination(paginationEntity.getPageno()-1, paginationEntity.getPagesize(), paginationEntity.getSortby(),paginationEntity.getToken());
//
//		}
//	}
	
	@RequestMapping("/dlist")
	public List<HealthFacility> getAllFacilityTypeDashboard(@RequestParam(name = "search", defaultValue = "") String search) {
//		System.out.println("Search:" + search);
		return HealthFacilityService.getFacilityTypeDashboard(search);
	}
	
	@RequestMapping("/getlist")
	public List<HealthFacility> getAllFacility(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues,
			@RequestParam(name = "uid", defaultValue = "") Integer uid,
			@RequestParam(name = "ps", defaultValue = "") Integer ps,
			@RequestParam(name = "cp", defaultValue = "") Integer cp) {

		return HealthFacilityService.getFacilityList(search,roles,rvalues,uid,cp-1,ps);
	}
	
	@RequestMapping("/getlistbed")
	public List<HealthFacility> getlistbed(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues,
			@RequestParam(name = "uid", defaultValue = "") Integer uid,
			@RequestParam(name = "ps", defaultValue = "") Integer ps,
			@RequestParam(name = "cp", defaultValue = "") Integer cp) {

		return HealthFacilityService.getFacilityListBed(search,roles,rvalues,uid,cp-1,ps);
	}
	
	@RequestMapping("/list-online-pending")
	public List<HealthFacility> getAllFacilityOnline(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues,
			@RequestParam(name = "uid", defaultValue = "") Integer uid,
			@RequestParam(name = "ps", defaultValue = "") Integer ps,
			@RequestParam(name = "cp", defaultValue = "") Integer cp) {
//		System.out.println("Search:" + search);
//		if("provincial".equals(roles)) {
//			roles="province";
//		}
//		if("palika".equals(roles)) {
//			roles="municipality";
//		}
		
		return HealthFacilityService.getFacilityListOnline(search,roles,rvalues,uid,cp-1,ps);
	}
	@RequestMapping("/dgetlist")
	public List<HealthFacility> getAllFacilityDashboard(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues,
			@RequestParam(name = "uid", defaultValue = "") Integer uid) {
//		System.out.println("Search:" + search);
//		if("provincial".equals(roles)) {
//			roles="province";
//		}
//		if("palika".equals(roles)) {
//			roles="municipality";
//		}
		
		return HealthFacilityService.getFacilityListDash(search,roles,rvalues,uid);
	}
//	@RequestMapping(value = "/facilitytypeCreate",method = RequestMethod.POST)
//	public String addFacilityType(HealthFacility HealthFacility){
//		HealthFacilityService.addFacilityType(HealthFacility);
//		return "saved successfull";
//	}
	
	@RequestMapping(value = "/userRole", method = RequestMethod.POST)
	public @ResponseBody String addUserRole(@RequestBody UserHf userhf,@RequestParam(name = "hfArray",defaultValue = "0") String hfArray) {
		int userid=userhf.getUserid();
		String[] sresult = hfArray.split(",");
		healthFacilityRepo.deleteHf(userid);
		if (!"0".equals(sresult[0])) {
		for (String s: sresult) {  
		
			healthFacilityRepo.addUserHf(userid,s);
			
		}	
		}
		return "Saved Successfully";
		
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Map<String, Object>>> addFacilityType(@RequestBody HealthFacility healthFacility,
			@RequestParam(name = "serviceArray",defaultValue = "500") String serviceArray,
			@RequestParam(name = "hfs",defaultValue = "500") String hfs,
			@RequestParam(name = "newserviceArray",defaultValue = "500") String newserviceArray,
			@RequestParam(name = "opdArray",defaultValue = "500") String opdArray,
			@RequestParam(name = "surgicArray",defaultValue = "500") String surgicArray,
			@RequestParam(name = "speclArray",defaultValue = "500") String speclArray,
			@RequestParam(name = "labArray",defaultValue = "500") String labArray,
			@RequestParam(name = "radioArray",defaultValue = "500") String radioArray,
			@RequestParam(name = "freeArray",defaultValue = "500") String freeArray,
			@RequestParam(name = "ayurArray",defaultValue = "500") String ayurArray,
			@RequestParam(name = "familyArray",defaultValue = "500") String familyArray,
			@RequestParam(name = "motherArray",defaultValue = "500") String motherArray
//			@RequestParam(name = "owneritems",defaultValue = "500") String owneritems,
//			@RequestParam(name = "deviceitems",defaultValue = "500") String deviceitems
			) {
		String munc=healthFacility.getMunicipality();
		int type=healthFacility.getType();
		int flvl=healthFacility.getLevel();
//		System.out.println(munc);
		String[] hf=healthFacilityRepo.findCodess(munc);
//		System.out.println(hf[0]);
		
		if (hf != null && hf.length > 0) {
			String[] ss = hf[0].split(",");
			int ucode=Integer.parseInt(ss[1])+1;
			String ucodes=String.format("%04d",ucode);
			String hfcod=ss[0]+ucodes+type;
			healthFacility.setCbscode(Integer.parseInt(ss[0]));
			healthFacility.setUcode(Integer.parseInt(ucodes));
			BigInteger numBig = new BigInteger(hfcod);
//			System.out.println(numBig);
			healthFacility.setHf_code(numBig);
		}else {
			int cbs=healthFacilityRepo.getCbsCodes(munc);
			String ucodes=String.format("%04d",1);
			String hfcod=cbs+ucodes+type;
			healthFacility.setCbscode(cbs);
			healthFacility.setUcode(Integer.parseInt(ucodes));
			BigInteger numBig = new BigInteger(hfcod);
//			System.out.println(numBig);
			healthFacility.setHf_code(numBig);
		}
		
		
//		String[] ss = hf[0].split(",");	
////		System.out.println(ss[1]);
//		int ucode=Integer.parseInt(ss[1])+1;
//		String ucodes=String.format("%04d",ucode);
//		String hfcod=ss[0]+ucodes+type;
//		healthFacility.setCbscode(Integer.parseInt(ss[0]));
//		healthFacility.setUcode(Integer.parseInt(ucodes));
//		BigInteger numBig = new BigInteger(hfcod);
//		System.out.println(numBig);
//		healthFacility.setHf_code(numBig);
		int lid=0;	
		HealthFacilityService.addFacilityType(healthFacility);
		lid = healthFacility.getId();
//		String[] sresult = serviceArray.split(",");
		String[] nsresult = newserviceArray.split(",");
//		String[] oresult = opdArray.split(",");
//		String[] surResult = surgicArray.split(",");
//		String[] spclResult = speclArray.split(",");
//		String[] labResult = labArray.split(",");
//		String[] radioResult = radioArray.split(",");
//		String[] freeResult = freeArray.split(",");
//		String[] ayurResult = ayurArray.split(",");
//		String[] familyResult = familyArray.split(",");
//		String[] motherResult = motherArray.split(",");
		apiexchangeRepo.addApiData(lid,"create");
		healthFacilityRepo.addHistoryLevel(lid,flvl);
//		if (!"500".equals(sresult[0])) {
//		for (String s: sresult) {  
//			healthFacilityRepo.addServices(lid,s);
//			healthFacilityRepo.addHistoryServices(lid,s);
//		}	
//		}
		if(healthFacility.getOnlinestatus()==1) {
			healthFacilityRepo.updateOnline(lid);
		}
		
		
		 if (healthFacility.getDeviceitems() != null) {
	            for (DeviceItem item : healthFacility.getDeviceitems()) {
	                // Print each property of the DeviceItem
	                System.out.println("Device Item Name: " + item.getDname());
	                healthFacilityRepo.addDevice(lid,item.getDname(),item.getDsource(),item.getRemarks());
	                
	                
	            }
	            }
		 
		 if (healthFacility.getOwneritems() != null) {
	            for (OwnerItem item : healthFacility.getOwneritems()) {
	                // Print each property of the DeviceItem
	                System.out.println("Owner Item Name: " + item.getOname());
	                healthFacilityRepo.addOwner(lid,item.getOname(),item.getOaddress(),item.getOctzn(),item.getOmobile(),item.getOemail());
	                
	                
	            }
	            }
		 
		 if (healthFacility.getWorkeritems() != null) {
	            for (WorkerItem item : healthFacility.getWorkeritems()) {
	            	 String iid = db.newIdInt();
	            	 String sql="insert into tbl_employee_import(id,orgidint,importid,workforceid,nameen,namenp,nid,email,dob,province,district,palika,gender,mobile,council,council_no,pis,ppis,apoint_date,att_date,ethnicity,emptype,authlevel,level,empstatus,worktype,education,qualification,created_by,code,groupid,subgroupid,postid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            	 db.execute(sql, Arrays.asList(iid,lid,lid,0,item.getNameen(),item.getNamenp(),item.getNid(),item.getHwemail(),item.getDob(),item.getProvinceid(),item.getDistrictid(),item.getPalikaid(),item.getGender(),item.getHwmobile(),item.getCouncil(),item.getCouncilno(),item.getPis(),item.getPpis(),item.getApoint_date(),item.getAtt_date(),item.getEthnicity(),item.getEmptype(),item.getDarbanditype(),item.getEmplevel(),item.getEmpstatus(),item.getWorktype(),item.getEducation(),item.getQualification(),0,0,item.getGroupid(),item.getSubgroupid(),item.getPostid()));

	                // Print each property of the DeviceItem
//	                System.out.println("worker Item Name: " + item);
//	                healthFacilityRepo.addDevice(lid,item.getDname(),item.getDsource(),item.getRemarks());
	                
	                
	            }
	            }
		 
		 
		if (!"500".equals(hfs)) {
		String[] hservice=hfs.split(",");
		
		for(String s: hservice) {
			
			healthFacilityRepo.inserthealthservice(lid,s);	
		}
		}
		
		if (!"500".equals(nsresult[0])) {
			for (String s: nsresult) {  
				healthFacilityRepo.addNewServices(lid,s);
				healthFacilityRepo.addNewHistoryServices(lid,s);
			}	
			}
		
//		
//		if (!"500".equals(oresult[0])) {
//			for (String s: oresult) {  
//				healthFacilityRepo.addOpdServices(lid,s);
//				healthFacilityRepo.addOpdHistoryServices(lid,s);
//			}	
//			}
//		
//		if (!"500".equals(surResult[0])) {
//			for (String s: surResult) {  
//				healthFacilityRepo.addSurgicalServices(lid,s);
//				healthFacilityRepo.addSurgicalHistoryServices(lid,s);
//			}	
//			}
//		if (!"500".equals(spclResult[0])) {
//			for (String s: spclResult) {  
//				healthFacilityRepo.addSpeicalServices(lid,s);
//				healthFacilityRepo.addspecialHistoryServices(lid,s);
//			}	
//			}
//		
//		if (!"500".equals(labResult[0])) {
//			for (String s: labResult) {  
//				healthFacilityRepo.addLabServices(lid,s);
//				healthFacilityRepo.addLabHistoryServices(lid,s);
//			}	
//			}
//		
//		if (!"500".equals(radioResult[0])) {
//			for (String s: radioResult) {  
//				healthFacilityRepo.addRadioServices(lid,s);
//				healthFacilityRepo.addRadioHistoryServices(lid,s);
//			}	
//			}
//		
//
//		if (!"500".equals(freeResult[0])) {
//			for (String s: freeResult) {  
//				healthFacilityRepo.addFreeServices(lid,s);
//				healthFacilityRepo.addFreeHistoryServices(lid,s);
//			}	
//			}
//		
//
//		if (!"500".equals(ayurResult[0])) {
//			for (String s: ayurResult) {  
//				healthFacilityRepo.addAyurServices(lid,s);
//				healthFacilityRepo.addAyurHistoryServices(lid,s);
//			}	
//			}
//		
//		if (!"500".equals(familyResult[0])) {
//			for (String s: familyResult) {  
//				healthFacilityRepo.addFamilyServices(lid,s);
//				healthFacilityRepo.addFamilyHistoryServices(lid,s);
//			}	
//			}
		
//		if (!"500".equals(motherResult[0])) {
//			for (String s: motherResult) {  
//				healthFacilityRepo.addMotherServices(lid,s);
//				healthFacilityRepo.addMotherHistoryServices(lid,s);
//			}	
//			}
		String hfcode=healthFacility.getHf_code().toString();
		String id=healthFacility.getId().toString();
		String confirmation=lid+hfcode;
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> mapadmlvl = new HashMap<>();
		mapadmlvl.put("status", "1");
		mapadmlvl.put("conf", confirmation);
	
		list.add(mapadmlvl);


return ResponseEntity.ok(list);
//		return "confirmation";
	}
	@Transactional
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<List<Map<String, Object>>> updateFacilityType(@RequestBody HealthFacility HealthFacility,
			@RequestParam(name = "id") int id,
			@RequestParam(name = "serviceArray",defaultValue = "500") String serviceArray,
			@RequestParam(name = "hfs",defaultValue = "500") String hfs,
			@RequestParam(name = "newserviceArray",defaultValue = "500") String newserviceArray,
			@RequestParam(name = "opdArray",defaultValue = "500") String opdArray,
			@RequestParam(name = "surgicArray",defaultValue = "500") String surgicArray,
			@RequestParam(name = "speclArray",defaultValue = "500") String speclArray,
			@RequestParam(name = "labArray",defaultValue = "500") String labArray,
			@RequestParam(name = "radioArray",defaultValue = "500") String radioArray,
			@RequestParam(name = "freeArray",defaultValue = "500") String freeArray,
			@RequestParam(name = "ayurArray",defaultValue = "500") String ayurArray,
			@RequestParam(name = "familyArray",defaultValue = "500") String familyArray,
			@RequestParam(name = "motherArray",defaultValue = "500") String motherArray,
			@RequestParam(name="history") Integer history)
	{
		
		HealthFacility.setId(id);
		int flvl=HealthFacility.getLevel();
		String munc=HealthFacility.getMunicipality();
		int type=HealthFacility.getType();
		
		String rt=HealthFacility.getRtype();
		int on=HealthFacility.getOnlinestatus();
		
		
		//System.out.println(plevel);
//		System.out.println(flvl);
		String phf[]=healthFacilityRepo.findPreviouscode(id);
		String sphf[]=phf[0].split(",");
		String cbscode;
		int ucode;
		if(sphf[2].equals(munc)) {
			 ucode=Integer.parseInt(sphf[1]);
			 cbscode=sphf[0];
		}else {
			String[] hf=healthFacilityRepo.findCodess(munc);
			if (hf != null && hf.length > 0) {
				String[] ss = hf[0].split(",");
				 ucode=Integer.parseInt(ss[1])+1;
				 cbscode=ss[0];
				
			}else {
				int cbs=healthFacilityRepo.getCbsCodes(munc);
				ucode=1;
				cbscode=String.valueOf(cbs);

			}
		}

		
		String ucodes=String.format("%04d",ucode);
		String hfcod=cbscode+ucodes+type;
		HealthFacility.setCbscode(Integer.parseInt(cbscode));
		HealthFacility.setUcode(Integer.parseInt(ucodes));
		BigInteger numBig = new BigInteger(hfcod);
//		System.out.println(numBig);
		HealthFacility.setHf_code(numBig);
		if(history==1) {
			healthFacilityRepo.addFacilityHistory(id);
		}
		HealthFacilityService.addFacilityType(HealthFacility);
		apiexchangeRepo.addApiData(id,"update");
//		int flvl=HealthFacility.getLevel();
//		int plevel=healthFacilityRepo.findlevels(id);
//		System.out.println(plevel);
//		System.out.println(flvl);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if(history==1) {
//			healthFacilityRepo.addFacilityHistory(id);
			int plevel=healthFacilityRepo.findlevels(id);
		if(plevel!=flvl) {
			healthFacilityRepo.updateFlevelhistory(id,plevel,timestamp);
			healthFacilityRepo.addHistoryLevel(id,flvl);
		}}
//		String[] sresult = serviceArray.split(",");
//		String[] psresult=hfServicesRepo.findAllServiceByHfid(id);
//		
		String[] nsresult = newserviceArray.split(",");
		String[] npsresult=hfServicesRepo.findAllNewServiceByHfid(id);
		String[] hservice=hfs.split(",");
		healthFacilityRepo.deletehealthService(id);
		for(String s: hservice) {
			
			healthFacilityRepo.inserthealthservice(id,s);	
		}
		
		if (HealthFacility.getDeviceitems() != null) {
			healthFacilityRepo.deletedevice(id);
            for (DeviceItem item : HealthFacility.getDeviceitems()) {
                // Print each property of the DeviceItem
//                System.out.println("Device Item Name: " + item.getDname());
                healthFacilityRepo.addDevice(id,item.getDname(),item.getDsource(),item.getRemarks());
                
                
            }
            }
	 
	 if (HealthFacility.getOwneritems() != null) {
		 healthFacilityRepo.deleteowner(id);
            for (OwnerItem item : HealthFacility.getOwneritems()) {
                // Print each property of the DeviceItem
//                System.out.println("Owner Item Name: " + item.getOname());
                healthFacilityRepo.addOwner(id,item.getOname(),item.getOaddress(),item.getOctzn(),item.getOmobile(),item.getOemail());
                
                
            }
            }
	 
	 if (HealthFacility.getWorkeritems() != null) {
		 healthFacilityRepo.deleteWorker(id);
         for (WorkerItem item : HealthFacility.getWorkeritems()) {
             // Print each property of the DeviceItem
        	 String iid = db.newIdInt();
        	 String sql="insert into tbl_employee_import(id,orgidint,importid,workforceid,nameen,namenp,nid,email,dob,province,district,palika,gender,mobile,council,council_no,pis,ppis,apoint_date,att_date,ethnicity,emptype,authlevel,level,empstatus,worktype,education,qualification,created_by,code,groupid,subgroupid,postid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        	 db.execute(sql, Arrays.asList(iid,id,id,0,item.getNameen(),item.getNamenp(),item.getNid(),item.getHwemail(),item.getDob(),item.getProvinceid(),item.getDistrictid(),item.getPalikaid(),item.getGender(),item.getHwmobile(),item.getCouncil(),item.getCouncilno(),item.getPis(),item.getPpis(),item.getApoint_date(),item.getAtt_date(),item.getEthnicity(),item.getEmptype(),item.getDarbanditype(),item.getEmplevel(),item.getEmpstatus(),item.getWorktype(),item.getEducation(),item.getQualification(),0,0,item.getGroupid(),item.getSubgroupid(),item.getPostid()));
//             System.out.println("worker Item Name: " + item);
//             healthFacilityRepo.addDevice(lid,item.getDname(),item.getDsource(),item.getRemarks());
             
             
         }
         }
		
		
//		String[] oresult = opdArray.split(",");
//		String[] poresult=hfOpdRepo.findAllServiceByHfid(id);
//		String[] surResult = surgicArray.split(",");
//		String[] psurResult=hfSurgicRepo.findAllServiceByHfId(id);
//		String[] spclResult = speclArray.split(",");
//		String[] pspclResult = hfSpecialRepo.findAllServiceByHfId(id);
//		String[] labResult = labArray.split(",");
//		String[] plabresult= hfLabRepo.findAllServiceByHfId(id);
//		String[] radioResult = radioArray.split(",");
//		String[] pradioResult=hfRadioRepo.findAllServiceByHfId(id);
//		String[] freeResult = freeArray.split(",");
//		String[] pfreeResult = hfBipannaRepo.findAllServiceByHfId(id);
//		String[] ayurResult = ayurArray.split(",");
//		String[] payurResult =hfAyurRepo.findAllServiceByHfId(id);
//		String[] familyResult = familyArray.split(",");
//		String[] pfamilyResult = hfFamilyRepo.findAllServiceByHfId(id);
//		String[] motherResult = motherArray.split(",");
//		String[] pmotherResult = hfMotherRepo.findAllServiceByHfId(id);
		
//		HashSet<String> sadded = new HashSet<String>(Arrays.asList(sresult));
//		sadded.removeAll(Arrays.asList(psresult));
//		HashSet<String> sremoved = new HashSet<String>(Arrays.asList(psresult));
//		sremoved.removeAll(Arrays.asList(sresult));
		
		HashSet<String> nsadded = new HashSet<String>(Arrays.asList(nsresult));
		nsadded.removeAll(Arrays.asList(npsresult));
		HashSet<String> nsremoved = new HashSet<String>(Arrays.asList(npsresult));
		nsremoved.removeAll(Arrays.asList(nsresult));
		
		
		
//		HashSet<String> oadded = new HashSet<String>(Arrays.asList(oresult));
//		oadded.removeAll(Arrays.asList(poresult));
//		HashSet<String> oremoved = new HashSet<String>(Arrays.asList(poresult));
//		oremoved.removeAll(Arrays.asList(oresult));
//		
//		HashSet<String> suradded = new HashSet<String>(Arrays.asList(surResult));
//		suradded.removeAll(Arrays.asList(psurResult));
//		HashSet<String> surremoved = new HashSet<String>(Arrays.asList(psurResult));
//		surremoved.removeAll(Arrays.asList(surResult));
//		
//		HashSet<String> spcladded = new HashSet<String>(Arrays.asList(spclResult));
//		spcladded.removeAll(Arrays.asList(pspclResult));
//		HashSet<String> spclremoved = new HashSet<String>(Arrays.asList(pspclResult));
//		spclremoved.removeAll(Arrays.asList(spclResult));
//		
//		HashSet<String> labadded = new HashSet<String>(Arrays.asList(labResult));
//		labadded.removeAll(Arrays.asList(plabresult));
//		HashSet<String> labremoved = new HashSet<String>(Arrays.asList(plabresult));
//		labremoved.removeAll(Arrays.asList(labResult));
//		
//		HashSet<String> radioadded = new HashSet<String>(Arrays.asList(radioResult));
//		radioadded.removeAll(Arrays.asList(pradioResult));
//		HashSet<String> radioremoved = new HashSet<String>(Arrays.asList(pradioResult));
//		radioremoved.removeAll(Arrays.asList(radioResult));
//		
//		HashSet<String> freeadded = new HashSet<String>(Arrays.asList(freeResult));
//		freeadded.removeAll(Arrays.asList(pfreeResult));
//		HashSet<String> freeremoved = new HashSet<String>(Arrays.asList(pfreeResult));
//		freeremoved.removeAll(Arrays.asList(freeResult));
//		
//		HashSet<String> ayuradded = new HashSet<String>(Arrays.asList(ayurResult));
//		ayuradded.removeAll(Arrays.asList(payurResult));
//		HashSet<String> ayurremoved = new HashSet<String>(Arrays.asList(payurResult));
//		ayurremoved.removeAll(Arrays.asList(ayurResult));
//		
//		HashSet<String> famadded = new HashSet<String>(Arrays.asList(familyResult));
//		famadded.removeAll(Arrays.asList(pfamilyResult));
//		HashSet<String> famremoved = new HashSet<String>(Arrays.asList(pfamilyResult));
//		famremoved.removeAll(Arrays.asList(familyResult));
//		
//		HashSet<String>motheradded = new HashSet<String>(Arrays.asList(motherResult));
//		motheradded.removeAll(Arrays.asList(pmotherResult));
//		HashSet<String> motherremoved = new HashSet<String>(Arrays.asList(pmotherResult));
//		motherremoved.removeAll(Arrays.asList(motherResult));
		
		
//		if (!"500".equals(sresult[0])) {
//		for(String s: sadded) {
//			healthFacilityRepo.addServices(id,s);
//			healthFacilityRepo.addHistoryServices(id,s);
//		}
//		}
//		for(String s: sremoved) {
//			healthFacilityRepo.deleteService(id,s);
//			healthFacilityRepo.updateHistoryServices(id,s,timestamp);	
//		}
		
		if (!"500".equals(nsresult[0])) {
			for(String s: nsadded) {
				healthFacilityRepo.addNewServices(id,s);
				healthFacilityRepo.addNewHistoryServices(id,s);
			}
			}
			for(String s: nsremoved) {
				healthFacilityRepo.deleteNewService(id,s);
				healthFacilityRepo.updateNewHistoryServices(id,s,timestamp);	
			}
			
			
			
		
//		if (!"500".equals(oresult[0])) {
//		for(String s: oadded) {
//			healthFacilityRepo.addOpdServices(id,s);
//			healthFacilityRepo.addOpdHistoryServices(id,s);
//		}
//		}
//		for(String s: oremoved) {
//			healthFacilityRepo.deleteOpdService(id,s);
//			healthFacilityRepo.updateOpdHistoryServices(id,s,timestamp);	
//		}
//			
//		if (!"500".equals(surResult[0])) {
//		for(String s: suradded) {
//			healthFacilityRepo.addSurgicalServices(id,s);
//			healthFacilityRepo.addSurgicalHistoryServices(id,s);
//		}
//		}
//		for(String s: surremoved) {
//			healthFacilityRepo.deleteSurgicalService(id,s);
//			healthFacilityRepo.updateSurgicalHistoryServices(id,s,timestamp);	
//		}
//				
//		if (!"500".equals(spclResult[0])) {
//		for(String s: spcladded) {
//			healthFacilityRepo.addSpeicalServices(id,s);
//			healthFacilityRepo.addspecialHistoryServices(id,s);
//		}
//		}
//		for(String s: spclremoved) {
//			healthFacilityRepo.deleteSpecialService(id,s);
//			healthFacilityRepo.updateSpecialHistoryServices(id,s,timestamp);	
//		}
//
//		if (!"500".equals(labResult[0])) {
//		for(String s: labadded) {
//			healthFacilityRepo.addLabServices(id,s);
//			healthFacilityRepo.addLabHistoryServices(id,s);
//		}
//		}
//		for(String s: labremoved) {
//			healthFacilityRepo.deleteLabService(id,s);
//			healthFacilityRepo.updateLabHistoryServices(id,s,timestamp);	
//		}
//		
//		if (!"500".equals(radioResult[0])) {
//		for(String s: radioadded) {
//			healthFacilityRepo.addRadioServices(id,s);
//			healthFacilityRepo.addRadioHistoryServices(id,s);
//		}
//		}
//		for(String s: radioremoved) {
//			healthFacilityRepo.deleteRadioService(id,s);
//			healthFacilityRepo.updateRadioHistoryServices(id,s,timestamp);	
//		}
//		
//		if (!"500".equals(freeResult[0])) {
//		for(String s: freeadded) {
//			healthFacilityRepo.addFreeServices(id,s);
//			healthFacilityRepo.addFreeHistoryServices(id,s);
//		}
//		
//		}
//		for(String s: freeremoved) {
//			healthFacilityRepo.deleteFreeService(id,s);
//			healthFacilityRepo.updateFreeHistoryServices(id,s,timestamp);	
//		}
//		
//		if (!"500".equals(ayurResult[0])) {
//		for(String s: ayuradded) {
//			healthFacilityRepo.addAyurServices(id,s);
//			healthFacilityRepo.addAyurHistoryServices(id,s);
//		}
//		}
//		for(String s: ayurremoved) {
//			healthFacilityRepo.deleteAyurService(id,s);
//			healthFacilityRepo.updateAyurHistoryServices(id,s,timestamp);	
//		}
//		
//		if (!"500".equals(familyResult[0])) {
//		for(String s: famadded) {
//			healthFacilityRepo.addFamilyServices(id,s);
//			healthFacilityRepo.addFamilyHistoryServices(id,s);
//		}
//		}
//		for(String s: famremoved) {
//			healthFacilityRepo.deleteFamilyService(id,s);
//			healthFacilityRepo.updateFamilyHistoryServices(id,s,timestamp);	
//		}
//		
//		if (!"500".equals(motherResult[0])) {
//		for(String s: motheradded) {
//			healthFacilityRepo.addMotherServices(id,s);
//			healthFacilityRepo.addMotherHistoryServices(id,s);
//		}
//		}
//		for(String s: motherremoved) {
//			healthFacilityRepo.deleteMotherService(id,s);
//			healthFacilityRepo.updateMotherHistoryServices(id,s,timestamp);	
//		}
			
			
			List<Map<String, Object>> list = new ArrayList<>();
			System.out.println("upto here"+on+ " rt"+rt);
			if(on!=0) {
				if(rt.equals("2") && on==1) {
					String sqs="update hfregistry set soft_delete=1,onlinestatus=1 where id="+id;
					db.execute(sqs);
					
					String hfcode=HealthFacility.getHf_code().toString();
					String lid=HealthFacility.getId().toString();
					String confirmation=lid+hfcode;
//					List<Map<String, Object>> list = new ArrayList<>();
					
					Map<String, Object> mapadmlvl = new HashMap<>();
					mapadmlvl.put("status", "1");
					mapadmlvl.put("conf", confirmation);
				
					list.add(mapadmlvl);


			return ResponseEntity.ok(list);
				}
			}
			
					Map<String, Object> mapadmlvl = new HashMap<>();
					mapadmlvl.put("status", "0");
					mapadmlvl.put("conf", "123");
				
					list.add(mapadmlvl);
		
			
			return ResponseEntity.ok(list);
	
//		return "saved successfull";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteFtype(@PathVariable(name = "id") int id) {
		HealthFacilityService.delete(id);
		return ResponseEntity.ok("Deleted Successfully");
	}
	
	@RequestMapping(value = "/deleteuserid/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteuser(@PathVariable(name = "id") int id) {
		try {
			String sql = "delete from users where id  = ?";
			 db.execute(sql, Arrays.asList(id));
			 return ResponseEntity.ok("Deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.ok("Deleted Successfully");
			// TODO: handle exception
		}
		
		
		
	}
	
	@RequestMapping("/approvehf/{id}")
	public ResponseEntity<String> approvehf(@PathVariable(name = "id") int id,HttpServletRequest request) {
		final String authorizationHeader = request.getHeader("Authorization");
		String jwt =null;
		String username= null;
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtils.extractUsername(jwt);
		}
		try {
			healthFacilityRepo.approve(username,id);
			return ResponseEntity.ok("Approved Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok("not approved");
			// TODO: handle exception
		}
		
		
	}
	
	@RequestMapping("/rejecthf")
	public ResponseEntity<String> rejecthf(@RequestParam(name = "id") int id,@RequestParam(name = "remarks") String remarks,HttpServletRequest request) {
		final String authorizationHeader = request.getHeader("Authorization");
		String jwt =null;
		String username= null;
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtils.extractUsername(jwt);
		}
		try {
			healthFacilityRepo.addRemarks(id,remarks);
			healthFacilityRepo.reject(username,id);
			return ResponseEntity.ok("Approved Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok("not approved");
			// TODO: handle exception
		}
		
		
	}
	
	
	@RequestMapping("/edit/{id}")
	public HealthFacility getFacilityType(@PathVariable(name = "id") int id) {
		return HealthFacilityService.get(id);

	}
	
	
	
	@RequestMapping("/editonline/{id}")
	public List editonline(@PathVariable(name = "id") String id) {
		return healthFacilityRepo.editonline(id);
	}

	@RequestMapping("/getCodes/{id}")
	public List<HealthFacility> gethfCodes(@PathVariable(name = "id") String id) {
		return healthFacilityRepo.findCodes(id);
	}
	
	@RequestMapping("/reportList")
	public List<HealthFacility> getHfLists(
			@RequestParam(name = "status") int status,
			@RequestParam(name = "type") int type,
			@RequestParam(name = "id") String id){
		if(status==1) {
			int ids = Integer.parseInt(id);
		if(type==0) {
			
			return healthFacilityRepo.getTotalList(ids);
		}else {
			return healthFacilityRepo.getTotalLists(ids,type);
		}
		}
		else if(status==2) {
			int ids = Integer.parseInt(id);
			if(type==0) {
				
				return healthFacilityRepo.getDistTotalList(ids);
			}else {
				return healthFacilityRepo.getDistTotalLists(ids,type);
			}
		}
		else {
			if(type==0) {
				
				return healthFacilityRepo.getPalikaTotalList(id);
			}else {
				return healthFacilityRepo.getPalikaTotalLists(id,type);
			}
		}
     
	}
	@RequestMapping("/gethfByPalika")
	public List<HealthFacility> getHfbyPalika(@RequestParam(name="palika") String palika){
		return healthFacilityRepo.getHfBypalika(palika);
	}
	
//	@RequestMapping("/userRole")
//	public saverole()
	
	@RequestMapping("/searchCovid")
	public List<HealthFacility> getFacility(@RequestParam(name = "service") int service,
			@RequestParam(name = "roles") String roles,
			@RequestParam(name = "rvalues") String rvalues){
		if ("palika".equals(roles)) {
			return healthFacilityRepo.getHfbyCovidServiceM(service,rvalues);
		}else if("district".equals(roles)) {
			return healthFacilityRepo.getHfbyCovidServiceD(service,rvalues);
		}else if("provincial".equals(roles)) {
			return healthFacilityRepo.getHfbyCovidServiceP(service,rvalues);
		}else {
			return healthFacilityRepo.getHfbyCovidService(service);
		}
		
	
	}
	
	@RequestMapping("/exp-list")
	public List<HealthFacility> getFacilityExpired(@RequestParam(name = "ndate") String ndate,
			@RequestParam(name = "roles") String roles,
		@RequestParam(name = "rvalues") String rvalues){
		if ("palika".equals(roles)) {
			return healthFacilityRepo.getHfbyexpDatem(ndate,rvalues);
		}else if("district".equals(roles)) {
			return healthFacilityRepo.getHfbyexpDated(ndate,rvalues);
		}else if("provincial".equals(roles)) {
			return healthFacilityRepo.getHfbyexpDatep(ndate,rvalues);
		}else {
			return healthFacilityRepo.getHfbyexpDate(ndate);
		}
		
	
	}
	
	@RequestMapping("/exp-list-month")
	public List<HealthFacility> getFacilityExpiredMonth(@RequestParam(name = "ndate") String ndate,
			@RequestParam(name = "endate") String endate,
			@RequestParam(name = "roles") String roles,
		@RequestParam(name = "rvalues") String rvalues){
//		System.out.println("upto here");
		if ("palika".equals(roles)) {
			return healthFacilityRepo.getHfbyexpDatem(ndate,endate,rvalues);
		}else if("district".equals(roles)) {
			return healthFacilityRepo.getHfbyexpDated(ndate,endate,rvalues);
		}else if("provincial".equals(roles)) {
			return healthFacilityRepo.getHfbyexpDatep(ndate,endate,rvalues);
		}else {
			return healthFacilityRepo.getHfbyexpDate(ndate,endate);
		}
		
	
	}
	
	
	
	
	
	@RequestMapping("api/FetchNewHfRecord")
	public List<HealthFacility> getLatest(
			@RequestParam(name = "token", defaultValue = "0") String token,
			@RequestParam(name = "date", defaultValue = "0") String date){
		String tuser=healthFacilityRepo.findApiuserRole(token);
		if("1".equals(tuser)) {
			return healthFacilityRepo.getFacilityLatest(date);
		}else {
			date="";
			return healthFacilityRepo.getFacilityLatest(date);
		}

		
	}
//	
//	@RequestMapping("api/FetchLatest")
//	public List<HealthFacility> getLatests(
//			@RequestParam(name = "token", defaultValue = "0") String token,
//			@RequestParam(name = "lastid", defaultValue ="0") int lastid){
//		String tuser=healthFacilityRepo.findApiuserRole(token);
////		System.out.println(tuser);
//		if("1".equals(tuser)) {
//			return healthFacilityRepo.getLatests(lastid);
//		}else {
//			return null;
//		}
//
//		
//	}
	
	@RequestMapping("api/FetchLatestHf")
	public List<ApiExchange> getLatestss(
			@RequestParam(name = "token", defaultValue = "0") String token,
			@RequestParam(name = "lastid", defaultValue ="0") int lastid){
		String tuser=healthFacilityRepo.findApiuserRole(token);
		if("1".equals(tuser)) {
			return apiexchangeRepo.getLatests(lastid);
		}else {
			return null;
		}

		
	}
	
	@RequestMapping("api/getLastUpdated")
	public List getLatestsss(
			@RequestParam(name = "token", defaultValue = "0") String token,
			@RequestParam(name = "date", defaultValue ="0") String date){
		String tuser=healthFacilityRepo.findApiuserRole(token);
		if("1".equals(tuser)) {
//			System.out.println(apiexchangeRepo.getLatestHfs(date));
			return apiexchangeRepo.getLatestHfs(date);
		}else {
			return null;
		}

		
	}
	
	@RequestMapping("/search")
	public List<HealthFacility> getAllFacility(
			@RequestParam(name = "province", defaultValue = "0") int province,
			@RequestParam(name = "district", defaultValue = "0") int district,
			@RequestParam(name = "palika", defaultValue = "0") String palika,
			@RequestParam(name = "authority", defaultValue = "0") int authority,
			@RequestParam(name = "type", defaultValue = "0") int type,
			@RequestParam(name = "service", defaultValue ="0") int service,
			@RequestParam(name = "tab", defaultValue = "0") String tab,
			@RequestParam(name = "col", defaultValue = "0") String col
			) {
//		if (!"0".equals(palika)) {
//			System.out.println(palika + "-"+ district);
//		}
		
	
		 if(province!=0 && district!=0 && (!"0".equals(palika)) && authority!=0 && type!=0 && service!=0) {
			return healthFacilityRepo.getFacility(district,palika,authority,type,service);
		}else if(province!=0 && district!=0 && (!"0".equals(palika)) && authority!=0 && type!=0 && service==0){
			return healthFacilityRepo.getFacility(district,palika,authority,type);
		}else if(province!=0 && district!=0 && (!"0".equals(palika)) && authority!=0 && type==0 && service==0) {
			return healthFacilityRepo.getFacility(district,palika,authority);
		}else if(province!=0 && district!=0 && (!"0".equals(palika)) && authority==0 && type==0 && service==0) {
			return healthFacilityRepo.getFacility(palika);
		}else if(province!=0 && district!=0 && ("0".equals(palika)) && authority==0 && type==0 && service==0) {
			// System.out.println("hello i am here");
			return healthFacilityRepo.getFacility(district);
		}else if(province!=0 && district==0 && ("0".equals(palika)) && authority==0 && type==0 && service==0) {
			return healthFacilityRepo.getFacilityByProvince(province);
		}else if((!"0".equals(palika)) && service!=0) {
//			return healthFacilityRepo.getFacilityByPalikaService(palika,service);
			return HealthFacilityService.getFacilityByPalikaService(palika,service,tab,col);
		}else if(district!=0 && service!=0) {
//			return healthFacilityRepo.getFacilityByDistService(district,service);
			return HealthFacilityService.getFacilityByDistrictService(district,service,tab,col);
		}else if(province!=0 && service !=0) {
			return HealthFacilityService.getFacilityByProvinceService(province,service,tab,col);
//			return healthFacilityRepo.getFacilityByProvService(province,service);
		}else if(province==0 && service !=0) {
			return HealthFacilityService.getFacilityByNationalService(service,tab,col);
//			return healthFacilityRepo.getFacilityByService(service);
		}else if((!"0".equals(palika)) && type!=0) {
			return healthFacilityRepo.getFacilityByPalikaType(palika,type);
		}else if(district!=0 && type!=0) {
			return healthFacilityRepo.getFacilityByDistType(district,type);
		}else if(province!=0 && type !=0) {
			return healthFacilityRepo.getFacilityByProvType(province,type);
		}else if(province==0 && type !=0 && authority!=0) {
			return healthFacilityRepo.getFacilityBytypeAuth(type,authority);
		}
		else if(province==0 && type !=0) {
			return healthFacilityRepo.getFacilityBytype(type);
		}else if((!"0".equals(palika)) && authority!=0) {
			return healthFacilityRepo.getFacilityByPalikaAuth(palika,authority);
		}else if(district!=0 && authority!=0) {
			return healthFacilityRepo.getFacilityByDistAuth(district,authority);
		}else if(province!=0 && authority !=0) {
			return healthFacilityRepo.getFacilityByProvAuth(province,authority);
		}else if(province==0 && authority !=0) {
			return healthFacilityRepo.getFacilityByAuth(authority);
		}
		else {
//			String sql="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  LEFT JOIN admin_local_level_structure mu ON p.municipality=mu.vcid WHERE p.soft_delete=0 limit 10";
//			List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
//			System.out.println("total list:"+admlvl);
//			if (!admlvl.isEmpty()) {
//			for (Tuple t : admlvl) {
//				System.out.println("Tuple: " + t);
//		        
//		        // Alternatively, try to access elements explicitly
//		        for (TupleElement<?> element : t.getElements()) {
//		            System.out.println("Column Alias: " + element.getAlias() + ", Value: " + t.get(element.getAlias()));
//		        }
////				System.out.println(t.get("hf_name"));
//			}
//		}
		return HealthFacilityService.getFacilityType("");
		}
	}
	
	@RequestMapping("/api/searchbyService")
	public List<HealthFacility> getAllFacilitys(@RequestParam(name = "service", defaultValue ="0") int service) {
		return healthFacilityRepo.getFacilityList(service);
	}
	
	@RequestMapping("/api/searchbyType")
	public List<HealthFacility> getAllFacilityList(@RequestParam(name = "type", defaultValue ="0") int type) {
		return healthFacilityRepo.getFacilityLists(type);
	}
	
	@RequestMapping("/hf_list/download")
	public void exportCSV(@RequestParam(name = "province", defaultValue = "0") int province,
			@RequestParam(name = "district", defaultValue = "0") int district,
			@RequestParam(name = "palika", defaultValue = "0") String palika,
			@RequestParam(name = "authority", defaultValue = "0") int authority,
			@RequestParam(name = "type", defaultValue = "0") int type,
			@RequestParam(name = "service", defaultValue ="0") int service,
			@RequestParam(name = "role", defaultValue ="0") int role,
			@RequestParam(name = "tab", defaultValue = "0") String tab,
			@RequestParam(name = "col", defaultValue = "0") String col,
			HttpServletResponse response) throws Exception {

		//set file name and content type
		String filename = "healthFacility.csv";
//		List<Users> users= usersService.getAllUsers(search);
		String sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 group by p.id ";
		
//		System.out.println("total list:"+admlvl);
		List<HealthFacility> hf = HealthFacilityService.getFacilityType("");


		 if(province!=0 && district!=0 && (!"0".equals(palika)) && authority!=0 && type!=0 && service!=0) {
			 sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 and p.district="+district+" AND p.municipality="+palika+" AND p.type="+authority+" AND p.level="+type+" AND p.id in(select hf_id from new_hf_services where service_id="+service+") group by p.id ";
//				hf= healthFacilityRepo.getFacility(district,palika,authority,type,service);
			}else if(province!=0 && district!=0 && (!"0".equals(palika)) && authority!=0 && type!=0 && service==0){
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 and p.district="+district+" AND p.municipality="+palika+" AND p.type="+authority+" AND p.level="+type+" group by p.id ";
//				hf= healthFacilityRepo.getFacility(district,palika,authority,type);
			}else if(province!=0 && district!=0 && (!"0".equals(palika)) && authority!=0 && type==0 && service==0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 and p.district="+district+" AND p.municipality="+palika+" AND p.type="+authority+" group by p.id ";
//				hf= healthFacilityRepo.getFacility(district,palika,authority);
			}else if(province!=0 && district!=0 && (!"0".equals(palika)) && authority==0 && type==0 && service==0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0  AND p.municipality="+palika+"  group by p.id ";
//				hf= healthFacilityRepo.getFacility(palika);
			}else if(province!=0 && district!=0 && ("0".equals(palika)) && authority==0 && type==0 && service==0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 and p.district="+district+"  group by p.id ";
//				hf= healthFacilityRepo.getFacility(district);
			}else if(province!=0 && district==0 && ("0".equals(palika)) && authority==0 && type==0 && service==0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 and p.province="+province+"  group by p.id ";
//				hf= healthFacilityRepo.getFacilityByProvince(province);
			}else if((!"0".equals(palika)) && service!=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 AND p.municipality="+palika+" AND p.id in(select hf_id from new_hf_services where service_id="+service+") group by p.id ";
//				return healthFacilityRepo.getFacilityByPalikaService(palika,service);
//				hf= HealthFacilityService.getFacilityByPalikaService(palika,service,tab,col);
			}else if(district!=0 && service!=0) {
//				return healthFacilityRepo.getFacilityByDistService(district,service);
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 AND p.district="+district+" AND p.id in(select hf_id from new_hf_services where service_id="+service+") group by p.id ";
//				hf= HealthFacilityService.getFacilityByDistrictService(district,service,tab,col);
			}else if(province!=0 && service !=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 AND p.province="+province+" AND p.id in(select hf_id from new_hf_services where service_id="+service+") group by p.id ";
				hf= HealthFacilityService.getFacilityByProvinceService(province,service,tab,col);
//				return healthFacilityRepo.getFacilityByProvService(province,service);
			}else if(province==0 && service !=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0  AND p.id in(select hf_id from new_hf_services where service_id="+service+") group by p.id ";
				hf= HealthFacilityService.getFacilityByNationalService(service,tab,col);
//				return healthFacilityRepo.getFacilityByService(service);
			}else if((!"0".equals(palika)) && type!=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 AND p.municipality="+palika+" and p.level="+type+" group by p.id ";
//				hf= healthFacilityRepo.getFacilityByPalikaType(palika,type);
			}else if(district!=0 && type!=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 AND p.district="+district+" and p.level="+type+" group by p.id ";
//				hf= healthFacilityRepo.getFacilityByDistType(district,type);
			}else if(province!=0 && type !=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 AND p.province="+province+" and p.level="+type+" group by p.id ";
//				hf= healthFacilityRepo.getFacilityByProvType(province,type);
			}else if(province==0 && type !=0 && authority!=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0  and p.type="+authority+" and p.level="+type+" group by p.id ";
//				hf= healthFacilityRepo.getFacilityBytypeAuth(type,authority);
			}
			else if(province==0 && type !=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0  and  p.level="+type+" group by p.id ";
//				hf= healthFacilityRepo.getFacilityBytype(type);
			}else if((!"0".equals(palika)) && authority!=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0  and p.type="+authority+" and p.municipality="+palika+" group by p.id ";
//				hf= healthFacilityRepo.getFacilityByPalikaAuth(palika,authority);
			}else if(district!=0 && authority!=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0  and p.type="+authority+" and p.district="+district+" group by p.id ";
//				hf= healthFacilityRepo.getFacilityByDistAuth(district,authority);
			}else if(province!=0 && authority !=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0  and p.type="+authority+" and p.province="+province+" group by p.id ";
//				hf= healthFacilityRepo.getFacilityByProvAuth(province,authority);
			}else if(province==0 && authority !=0) {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0  and p.type="+authority+"  group by p.id ";
//				hf= healthFacilityRepo.getFacilityByAuth(authority);
			}
			else {
				sql="SELECT p.*,n.type_name as hftype,o.name as ownerships,l.name as newlevels,fl.name as oldlevels,mu.nameen as palikas,pro.nameen as provinces,dis.nameen as districts,GROUP_CONCAT(ns.name ORDER BY ns.orders SEPARATOR ', ') AS servicess FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id   JOIN admin_local_level_structure mu ON p.municipality=mu.vcid join admin_province pro on pro.pid=p.province join admin_district dis on dis.districtid=p.district LEFT JOIN     new_hf_services nhs ON p.id = nhs.hf_id LEFT JOIN   new_services ns ON nhs.service_id = ns.id WHERE p.soft_delete=0 group by p.id ";
//				hf= HealthFacilityService.getFacilityType("");
//				String sql="SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id LEFT JOIN facility_level fl ON p.oldlevel=fl.id  LEFT JOIN admin_local_level_structure mu ON p.municipality=mu.vcid WHERE p.soft_delete=0 limit 10";
//				List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
//				System.out.println("total list:"+admlvl);
				List<Map<String, Object>> list = new ArrayList<>();
//				if (!admlvl.isEmpty()) {
//					for (Tuple t : admlvl) {
//						System.out.println(t.get);
//					}
//				}
			}
		 
		 List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		

		try {
			response.setContentType("text/csv");
			response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=\"" + filename + "\"");
			if(role==1) {
			csvPrinter = new CSVPrinter(response.getWriter(),
					CSVFormat.DEFAULT.withHeader("HF Code", "HF Name", "Province","District","Palika","Ward","Authority-Level","Authority","Ownership","Facility Level","Facility Type","Operational_Status",
							"Internet_facility","Sanctioned_facility_bed","Functional_facility_bed","Sanctioned_ICU_bed","Functional_ICU_bed","Sanctioned_Ventilator_bed","Functional_Ventilator_bed",
							"Latitude","Longitude","estd_date/Reg_date","Last_renew_date","Date_of_validation","Contact_person","Contactperson_mobile","email","Website","Telephone","Services"));
			}else {
				csvPrinter = new CSVPrinter(response.getWriter(),
						CSVFormat.DEFAULT.withHeader("HF Code", "HF Name", "Province","District","Palika","Ward","Authority-Level","Authority","Ownership","Facility Level"));
			}
			
			if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				if(role==1) {
				csvPrinter.printRecord(Arrays.asList(t.get("hf_code"),t.get("hf_name"),t.get("provinces"),t.get("districts"),t.get("palikas"),t.get("ward"),t.get("authlevel"),t.get("hftype"),t.get("ownerships"),t.get("newlevels"),t.get("oldlevels"),t.get("opstatus"),
						t.get("internet"),t.get("sectioned"),t.get("functional"),t.get("icu_sectioned"),t.get("icu_functional"),t.get("ventilator_sectioned"),t.get("ventilator_functional"),t.get("latitude"),t.get("longitude"),t.get("estd_date"),t.get("ren_date"),t.get("validity"),t.get("contact_person"),t.get("contact_person_mobile"),t.get("email"),t.get("website"),t.get("telephone"),t.get("servicess")));
				}else {
					csvPrinter.printRecord(Arrays.asList(t.get("hf_code"),t.get("hf_name"),t.get("provinces"),t.get("districts"),t.get("palikas"),t.get("ward"),t.get("authlevel"),t.get("hftype"),t.get("ownerships"),t.get("newlevels")));
				}
			}
		}
				String own="-";
				String ftype="-";
				if(1==0) {
//			for (HealthFacility hfs : hf) {
//				System.out.println("hfssss: "+hfs);
//				own="-";
//				ftype="-";
//				if(hfs.getOwnership() !=null) {
//					
//					own= hfs.getOwnerships().getName();
//				}
//				if(hfs.getLevel()!=null) {
//					ftype=hfs.getHealthFacilityLevel().getName();	
//				}
//				 List<HfServices> hfserv=hfServicesRepo.findAllByHfidSearch(hfs.getId());  NewHfServicesRepo
//				 List<HfOpdService> opdserv=hfOpdRepo.findAllByHfid(hfs.getId());
//				 List<HfRadiologyService> radioserv=hfRadioRepo.findAllByHfid(hfs.getId());
//				 List<HfLaboratoryService> labserv=hfLabRepo.findAllByHfid(hfs.getId());
//				 List<HfFamilyPlanningService> famserv=hfFamilyRepo.findAllByHfid(hfs.getId());
//				 List<HfMotherhoodService> motherserv=hfMotherRepo.findAllByHfid(hfs.getId());
//				 List<HfSurgicalService> surgserv=hfSurgicRepo.findAllByHfid(hfs.getId());
//				 List<HfSpecializedService> specserv=hfSpecialRepo.findAllByHfid(hfs.getId());
//				 List<HfAyurvedService> ayurserv=hfAyurRepo.findAllByHfid(hfs.getId());
				
//				 List<NewHfServices> hfserv=nhfrepo.findAllByHfid(hfs.getId());
//				 String Serv = String.join(", ", nhfrepo.findAllByHfid(hfs.getId()).stream()
//		                    .map(s -> s.getServices().getName()).collect(Collectors.toList()));
//				 String Serv="";
//				 String opd="";
//				 String radio="";
//				 String lab="";
//				 String family="";
//				 String motherhood="";
//				 String surgical="";
//				 String special="";
//				 String ayurved="";
//				if(hfserv.size()!=0) {
//					for(NewHfServices hff :hfserv) {
//						Serv += hff.getServices().getName() +", ";
//					}
//					
//				}
//				
//				if(ayurserv.size()!=0) {
//					for(HfAyurvedService hffa :ayurserv) {
//						ayurved += hffa.getAyurved().getName() +", ";
//					}
//					
//				}
//				
//				if(specserv.size()!=0) {
//					for(HfSpecializedService hffs :specserv) {
//						special += hffs.getSpecialized().getName() +", ";
//					}
//					
//				}
//				
//				if(motherserv.size()!=0) {
//					for(HfMotherhoodService hfm :motherserv) {
//						motherhood += hfm.getMotherhood().getName() +", ";
//					}
//					
//				}
//				
//				if(surgserv.size()!=0) {
//					for(HfSurgicalService hfss :surgserv) {
//						surgical += hfss.getSurgical().getName() +", ";
//					}
//					
//				}
//				 
//				 if(opdserv.size()!=0) {
//						for(HfOpdService hfo :opdserv) {
//							opd += hfo.getOpd().getName() +", ";
//						}
//						
//					}
//				 
//				 if(radioserv.size()!=0) {
//						for(HfRadiologyService hfr :radioserv) {
//							radio += hfr.getRadiology().getName() +", ";
//						}
//						
//					}
//				 
//				 if(labserv.size()!=0) {
//						for(HfLaboratoryService hfl :labserv) {
//							lab += hfl.getLaboratory().getName() +", ";
//						}
//						
//					}
//				 if(famserv.size()!=0) {
//						for(HfFamilyPlanningService hfff :famserv) {
//							family += hfff.getFamilyplanning().getName() +", ";
//						}
//						
//					}
//				System.out.println(hfs.getOwnerships());  
//				if(role==1) {
//					csvPrinter.printRecord(Arrays.asList(hfs.getHf_code(),hfs.getHf_name(),hfs.getProvinces().getNameen(),hfs.getDistricts().getNameen(),hfs.getMunicipalitys().getNameen(),
//							hfs.getWard(),hfs.getAuthlevel(),hfs.getHealthFacilityType().getType_name(),own ,ftype,hfs.getOldHealthFacilityLevel().getName(),hfs.getOpstatus(),hfs.getInternet(),hfs.getSectioned(),hfs.getFunctional(),
//							hfs.getIcu_sectioned(),hfs.getIcu_functional(),hfs.getVentilator_sectioned(),hfs.getVentilator_functional(),hfs.getLatitude(),hfs.getLongitude(),hfs.getEstd_date(),
//							hfs.getRen_date(),hfs.getValidity(),hfs.getContact_person(),hfs.getContact_person_mobile(),hfs.getEmail(),hfs.getWebsite(),hfs.getTelephone(),Serv,opd,radio,lab,family,motherhood,surgical,special,ayurved));
//				}else {
//					// System.out.println("hello:"+hfs.getOpstatus());
//					if(hfs.getOpstatus()==null|| hfs.getOpstatus().equals("Functional") || hfs.getOpstatus().equals("") || hfs.getOpstatus().equals("null")) {
//					csvPrinter.printRecord(Arrays.asList(hfs.getHf_code(),hfs.getHf_name(),hfs.getProvinces().getNameen(),hfs.getDistricts().getNameen(),hfs.getMunicipalitys().getNameen(),hfs.getWard(),hfs.getAuthlevel(),hfs.getHealthFacilityType().getType_name(),own ,ftype));
//					}
//					}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(csvPrinter != null)
				csvPrinter.close();
		}

	}


	
	@RequestMapping("/getcbscode/{id}")
	public int getcbscode(@PathVariable(name = "id") String id) {
		return healthFacilityRepo.getCbsCodes(id);
	}
	@RequestMapping("/changePassword")
	public int chnagePassword(@RequestParam(name = "old", defaultValue = "") String old,
			@RequestParam(name = "newp", defaultValue = "") String newp,@RequestParam(name = "username", defaultValue = "") String username) {
		String newpass=passwordEncoder.encode(newp);
//		String oldpass=passwordEncoder.encode(old);
//		System.out.println(newpass);
		
		
		return HealthFacilityService.upDatePassword(username,old,newpass);
	}
	
	@RequestMapping(value = "/api/get-hf",method = RequestMethod.POST)
	public List<HealthFacility> getPagination(@RequestBody PaginationEntity paginationEntity) {
//		System.out.println(paginationEntity.getToken());
		if(paginationEntity.getPageno()==0) {
			return new ArrayList<HealthFacility>();
		}
		else {
			return HealthFacilityService.getAllPagination(paginationEntity.getPageno()-1, paginationEntity.getPagesize(), paginationEntity.getSortby(),paginationEntity.getToken());

		}
	}
	
	@RequestMapping(value = "/api/get-hfs")
	public List<HealthFacility> getPaginations(@RequestBody PaginationEntity paginationEntity) {
		System.out.println(paginationEntity.getToken());
		if(paginationEntity.getPageno()==0) {
			return new ArrayList<HealthFacility>();
		}
		else {
			return HealthFacilityService.getAllPagination(paginationEntity.getPageno()-1, paginationEntity.getPagesize(), paginationEntity.getSortby(),paginationEntity.getToken());

		}
	}
	

	@RequestMapping(value = "/api/get-hf-byHfCode",method = RequestMethod.POST)
	public List<HealthFacility> getHfBycode(@RequestBody PaginationEntity paginationEntity) {
//		System.out.println(paginationEntity.getToken());
			return HealthFacilityService.getHfbycode(paginationEntity.getCode(),paginationEntity.getToken());
			
	}
	
	@RequestMapping(value = "/api/get-hf-byProvince",method = RequestMethod.POST)
	public List<HealthFacility> getHfByProvince(@RequestBody PaginationEntity paginationEntity) {
//		System.out.println(paginationEntity.getToken());
		
			return HealthFacilityService.getHfbyProvince(paginationEntity.getPageno()-1, paginationEntity.getPagesize(), paginationEntity.getSortby(),paginationEntity.getToken(),paginationEntity.getProvince());

	}
	
	@RequestMapping(value = "/api/get-hf-byDistrict",method = RequestMethod.POST)
	public List<HealthFacility> getHfByDistrict(@RequestBody PaginationEntity paginationEntity) {
//		System.out.println(paginationEntity.getToken());
			return HealthFacilityService.getHfbyDistrict(paginationEntity.getPageno()-1, paginationEntity.getPagesize(), paginationEntity.getSortby(),paginationEntity.getToken(),paginationEntity.getDistrict());

	}
	
	@RequestMapping(value = "/api/get-hf-byMunicipality",method = RequestMethod.POST)
	public List<HealthFacility> getHfByMunicipality(@RequestBody PaginationEntity paginationEntity) {
//		System.out.println(paginationEntity.getToken());
			return HealthFacilityService.getHfbyMunicipality(paginationEntity.getPageno()-1, paginationEntity.getPagesize(), paginationEntity.getSortby(),paginationEntity.getToken(),paginationEntity.getMunicipality());

	}
	
	@RequestMapping(value="/api/get-hf-search",method=RequestMethod.POST)
	public List<HealthFacility> getHfSearch(@RequestBody PaginationEntity paginationEntity){
		return HealthFacilityService.getHfSearch(paginationEntity.getPageno()-1,paginationEntity.getPagesize(),paginationEntity.getToken(),paginationEntity.getSortby(),paginationEntity.getSearchKeyword());
	}
	@RequestMapping("/noWardFacility")
	public ArrayList<String> getWardFacility(){
		ArrayList<String> fw = new ArrayList<>();
	
		List<Municipality> munc=muncRepo.findAll();
		for (Municipality muncs : munc) {
//			System.out.println(muncs.getNumberofward());
//			System.out.println(muncs.getVcid());
			for (int i = 1; i <= muncs.getNumberofward(); i++) {
			   int c=healthFacilityRepo.getHFCount(muncs.getVcid(),i);
			  if(c==0) {
				
				  fw.add(muncs.getDistrict()+"_"+muncs.getNameen()+"_"+i);
			 
			  }
			}
		}
		
		return fw;
	}
	@RequestMapping("/national-count")
	public String[][] getNcount(@RequestParam(name = "catid",defaultValue = "500") String catid) {
//		System.out.println("i am here");
//		
//		System.out.println("catid:"+catid);
		String[][] arr=null;
		if("1".equals(catid)) {
			String[] pc=healthFacilityRepo.getPcount();
			String[] gc=healthFacilityRepo.getGcount();
			String[] ngc=healthFacilityRepo.getNgcCount();
			 arr = new String [][] {pc,gc,ngc};
		}
		
		if("2".equals(catid)) {
			String[] pc=healthFacilityRepo.getPcount();
			String[] gc=healthFacilityRepo.getFcount();
			String[] ngc=healthFacilityRepo.getPcCount();
			String[] ngcc=healthFacilityRepo.getLcCount();
			 arr = new String [][] {pc,gc,ngc,ngcc};
		}
		
		
		return arr;
	}
	
	@RequestMapping("/district-count")
	public String[][] getDcount(@RequestParam(name = "catid",defaultValue = "500") String catid,@RequestParam(name = "pid",defaultValue = "500") int pid){
//		System.out.println("here");
		String[][] arr=null;
		if("1".equals(catid)) {
			String[] pc=healthFacilityRepo.getDcount(pid);
			String[] gc=healthFacilityRepo.getDGcount(pid);
			String[] ngc=healthFacilityRepo.getDNgcCount(pid);
			 arr = new String [][] {pc,gc,ngc};
		}
		
		if("2".equals(catid)) {
			String[] pc=healthFacilityRepo.getDcount(pid);
			String[] gc=healthFacilityRepo.getDfcount(pid);
			String[] ngc=healthFacilityRepo.getDpcCount(pid);
			String[] ngcc=healthFacilityRepo.getDlccCount(pid);
			 arr = new String [][] {pc,gc,ngc,ngcc};
		}
		
//		String[] pc=healthFacilityRepo.getDcount(pid);
//		String[] gc=healthFacilityRepo.getDGcount(pid);
//		String[] ngc=healthFacilityRepo.getDNgcCount(pid);
//		String[][] arr = new String [][] {pc,gc,ngc};
		
		return arr;
	}
	
	@RequestMapping("/palika-count")
	public String[][] getPcount(@RequestParam(name = "catid",defaultValue = "500") String catid,@RequestParam(name = "did",defaultValue = "500") int did){
		
		String[][] arr=null;
		if("1".equals(catid)) {
			String[] pc=healthFacilityRepo.getMcount(did);
			String[] gc=healthFacilityRepo.getMGcount(did);
			String[] ngc=healthFacilityRepo.getMNgcCount(did);
			 arr = new String [][] {pc,gc,ngc};
		}
		
		if("2".equals(catid)) {
			String[] pc=healthFacilityRepo.getMcount(did);
			String[] gc=healthFacilityRepo.getMfcount(did);
			String[] ngc=healthFacilityRepo.getMpcCount(did);
			String[] ngcc=healthFacilityRepo.getMlcCount(did);
			 arr = new String [][] {pc,gc,ngc,ngcc};
		}
		
		
		return arr;
	}
	
	@RequestMapping("/national-count-level")
	public ResponseEntity<List<Map<String, Object>>> natcount(@RequestParam(name = "catid",defaultValue = "500") String catid) {
		String sql = "SELECT l.name AS level_name, p.province, COUNT(h.id) AS hf_count FROM (SELECT DISTINCT province FROM hfregistry) p CROSS JOIN facility_level l LEFT JOIN hfregistry h ON l.id = h.level AND h.province = p.province WHERE l.status=1 GROUP BY l.name, p.province ORDER BY l.code, p.province";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("province", t.get("province"));
				mapadmlvl.put("hf_count", t.get("hf_count"));
				
				
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getcountflevel1")
	public ResponseEntity<List<Map<String, Object>>> getcountflevel() {
		String sql = "SELECT admin_province.nameen as province, facility_level.nameen as level, COUNT(*) AS count FROM hfregistry join admin_province on admin_province.pid=hfregistry.province join facility_level on facility_level.id=hfregistry.level GROUP BY province, level";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("province", t.get("province"));
				mapadmlvl.put("level", t.get("level"));
				mapadmlvl.put("hf_count", t.get("count"));
				
				
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}

	@RequestMapping("/getcountbed")
	public ResponseEntity<List<Map<String, Object>>> getcountbed() {
		String sql = "SELECT admin_province.nameen as province,  COUNT(*) AS count FROM hfregistry join admin_province on admin_province.pid=hfregistry.province  GROUP BY province";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("province", t.get("province"));
				mapadmlvl.put("level", t.get("level"));
				mapadmlvl.put("hf_count", t.get("count"));
				
				
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getcountflevelsss")
	 public ResponseEntity<List<Map<String, Object>>> getCountFLevelsss() {
        // Fetch all distinct levels
        String levelsSql = "SELECT DISTINCT name as nameen FROM facility_level where status=1";
        Query levelsQuery = entityManager.createNativeQuery(levelsSql);
        List<String> levels = levelsQuery.getResultList();

        // Fetch province-level counts
        String sql = "SELECT admin_province.nameen as province, facility_level.nameen as level, COUNT(*) AS count " +
                     "FROM hfregistry " +
                     "JOIN admin_province ON admin_province.pid = hfregistry.province " +
                     "JOIN facility_level ON facility_level.id = hfregistry.level " +
                     "  GROUP BY province, level order by admin_province.pid";
        System.out.println("flevel"+sql);
        Query query = entityManager.createNativeQuery(sql, Tuple.class);
        List<Tuple> result = query.getResultList();

        // Process results
        Map<String, Map<String, Long>> countsMap = new HashMap<>();
        for (Tuple t : result) {
            String province = t.get("province", String.class);
            String level = t.get("level", String.class);
            BigInteger countBigInt = t.get("count", BigInteger.class);
            Long count = countBigInt.longValue();

            countsMap.computeIfAbsent(province, k -> new HashMap<>()).put(level, count);
        }

        // Ensure all levels are present for each province
        List<Map<String, Object>> responseList = new ArrayList<>();
        for (Map.Entry<String, Map<String, Long>> entry : countsMap.entrySet()) {
            Map<String, Object> map = new HashMap<>();
            map.put("province", entry.getKey());
            for (String level : levels) {
                map.put(level, entry.getValue().getOrDefault(level, 0L));
            }
            responseList.add(map);
        }

        return ResponseEntity.ok(responseList);
    }
	
	
	@RequestMapping("/getcountflevel")
	 public ResponseEntity<List<Map<String, Object>>> getCountFLevel() {
       String levelsSql = "SELECT DISTINCT name as nameen,id FROM facility_level where status=1";
       List<Tuple> council = db.getResultList(levelsSql, Arrays.asList());
       String councilColumns = council.stream()
               .map(c -> "SUM(CASE WHEN e.level = '" + c.get("id") + "' THEN 1 ELSE 0 END) AS `" + c.get("nameen") + "`")
               .collect(Collectors.joining(", "));
       
      String sql = "SELECT p.nameen AS Organization, " + councilColumns +
               " FROM admin_province p " +
               " LEFT JOIN hfregistry e ON e.province = p.pid and e.soft_delete=0" +
               " GROUP BY p.nameen " +
               " ORDER BY p.pid";

       List<Tuple> result = entityManager.createNativeQuery(sql, Tuple.class).getResultList();

       System.out.println(result);
       List<Map<String, Object>> resultList = result.stream()
       	    .map(tuple -> {
       	        Map<String, Object> row = new LinkedHashMap<>();
       	     
       	        row.put("province", tuple.get("Organization"));
       	        tuple.getElements().stream()
       	            .filter(element -> !element.getAlias().equals("Organization"))
       	            .forEach(element -> row.put(element.getAlias(), tuple.get(element.getAlias())));

       	        return row;
       	    })
       	    .collect(Collectors.toList());


       return ResponseEntity.ok(resultList);
   }
	
	
	@RequestMapping("/getcountflevelDist")
	 public ResponseEntity<List<Map<String, Object>>> getcountflevelDist(@RequestParam(name = "pid",defaultValue = "500") String pid) {
   
		 String levelsSql = "SELECT DISTINCT name as nameen,id FROM facility_level where status=1";
	       List<Tuple> council = db.getResultList(levelsSql, Arrays.asList());
	       String councilColumns = council.stream()
	               .map(c -> "SUM(CASE WHEN e.level = '" + c.get("id") + "' THEN 1 ELSE 0 END) AS `" + c.get("nameen") + "`")
	               .collect(Collectors.joining(", "));
	       
	      String sql = "SELECT p.nameen AS Organization, " + councilColumns +
	               " FROM admin_district p " +
	               " LEFT JOIN hfregistry e ON e.district = p.districtid and e.soft_delete=0 " +
	               " where p.provinceid="+pid+
	               " GROUP BY p.nameen " +
	               " ORDER BY p.districtid";

	       List<Tuple> result = entityManager.createNativeQuery(sql, Tuple.class).getResultList();

	       System.out.println(result);
	       List<Map<String, Object>> resultList = result.stream()
	       	    .map(tuple -> {
	       	        Map<String, Object> row = new LinkedHashMap<>();
	       	     
	       	        row.put("province", tuple.get("Organization"));
	       	        tuple.getElements().stream()
	       	            .filter(element -> !element.getAlias().equals("Organization"))
	       	            .forEach(element -> row.put(element.getAlias(), tuple.get(element.getAlias())));

	       	        return row;
	       	    })
	       	    .collect(Collectors.toList());


	       return ResponseEntity.ok(resultList);
//		
//		 String levelsSql = "SELECT DISTINCT nameen FROM facility_level WHERE status = 1";
//	        Query levelsQuery = entityManager.createNativeQuery(levelsSql);
//	        List<String> levels = levelsQuery.getResultList();
//
//	        // Fetch all provinces
//	        String provincesSql = "SELECT nameen FROM admin_district where provinceid="+pid;
//	        Query provincesQuery = entityManager.createNativeQuery(provincesSql);
//	        List<String> provinces = provincesQuery.getResultList();
//
//	        // Fetch province-level counts
//	        String countsSql = "SELECT admin_district.nameen as province, facility_level.nameen as level, COUNT(*) AS count " +
//                  "FROM hfregistry " +
//                  "JOIN admin_district ON admin_district.districtid = hfregistry.district  and admin_district.provinceid="  + pid+
//                  " JOIN facility_level ON facility_level.id = hfregistry.level " +
//                  "  GROUP BY province, level order by admin_district.districtid";
//	        Query countsQuery = entityManager.createNativeQuery(countsSql, Tuple.class);
//	        List<Tuple> countsResult = countsQuery.getResultList();
//
//	        // Process results
//	        Map<String, Map<String, Long>> countsMap = new HashMap<>();
//	        for (Tuple t : countsResult) {
//	            String province = t.get("province", String.class);
//	            String level = t.get("level", String.class);
//	            BigInteger countBigInt = t.get("count", BigInteger.class);
//	            Long count = countBigInt.longValue();
//
//	            countsMap.computeIfAbsent(province, k -> new HashMap<>()).put(level, count);
//	        }
//
//	        // Ensure all levels are present for each province
//	        List<Map<String, Object>> responseList = new ArrayList<>();
//	        for (String province : provinces) {
//	            Map<String, Object> map = new HashMap<>();
//	            map.put("province", province);
//	            for (String level : levels) {
//	                map.put(level, countsMap.getOrDefault(province, Collections.emptyMap()).getOrDefault(level, 0L));
//	            }
//	            responseList.add(map);
//	        }
//
//	        return ResponseEntity.ok(responseList);
	    }
   
	
	@RequestMapping("/getcountflevelPalika")
	 public ResponseEntity<List<Map<String, Object>>> getcountflevelPalika(@RequestParam(name = "pid",defaultValue = "500") String pid) {
		 String levelsSql = "SELECT DISTINCT name as nameen,id FROM facility_level where status=1";
	       List<Tuple> council = db.getResultList(levelsSql, Arrays.asList());
	       String councilColumns = council.stream()
	               .map(c -> "SUM(CASE WHEN e.level = '" + c.get("id") + "' THEN 1 ELSE 0 END) AS `" + c.get("nameen") + "`")
	               .collect(Collectors.joining(", "));
	       
	      String sql = "SELECT p.nameen AS Organization, " + councilColumns +
	               " FROM admin_local_level_structure p " +
	               " LEFT JOIN hfregistry e ON e.municipality = p.vcid and e.soft_delete=0 " +
	               " where p.districtid="+pid+
	               " GROUP BY p.nameen " +
	               " ORDER BY p.vcid";

	       List<Tuple> result = entityManager.createNativeQuery(sql, Tuple.class).getResultList();

	       System.out.println(result);
	       List<Map<String, Object>> resultList = result.stream()
	       	    .map(tuple -> {
	       	        Map<String, Object> row = new LinkedHashMap<>();
	       	     
	       	        row.put("province", tuple.get("Organization"));
	       	        tuple.getElements().stream()
	       	            .filter(element -> !element.getAlias().equals("Organization"))
	       	            .forEach(element -> row.put(element.getAlias(), tuple.get(element.getAlias())));

	       	        return row;
	       	    })
	       	    .collect(Collectors.toList());


	       return ResponseEntity.ok(resultList);
		
//		 String levelsSql = "SELECT DISTINCT nameen FROM facility_level WHERE status = 1";
//	        Query levelsQuery = entityManager.createNativeQuery(levelsSql);
//	        List<String> levels = levelsQuery.getResultList();
//
//	        // Fetch all provinces
//	        String provincesSql = "SELECT nameen FROM admin_local_level_structure where districtid="+pid;
//	        Query provincesQuery = entityManager.createNativeQuery(provincesSql);
//	        List<String> provinces = provincesQuery.getResultList();
//
//	        // Fetch province-level counts
//	        String countsSql = "SELECT admin_local_level_structure.nameen as province, facility_level.nameen as level, COUNT(*) AS count " +
//                 "FROM hfregistry " +
//                 "JOIN admin_local_level_structure ON admin_local_level_structure.vcid = hfregistry.municipality  and admin_local_level_structure.districtid="  + pid+
//                 " JOIN facility_level ON facility_level.id = hfregistry.level " +
//                 "  GROUP BY province, level ";
//	        Query countsQuery = entityManager.createNativeQuery(countsSql, Tuple.class);
//	        List<Tuple> countsResult = countsQuery.getResultList();
//
//	        // Process results
//	        Map<String, Map<String, Long>> countsMap = new HashMap<>();
//	        for (Tuple t : countsResult) {
//	            String province = t.get("province", String.class);
//	            String level = t.get("level", String.class);
//	            BigInteger countBigInt = t.get("count", BigInteger.class);
//	            Long count = countBigInt.longValue();
//
//	            countsMap.computeIfAbsent(province, k -> new HashMap<>()).put(level, count);
//	        }
//
//	        // Ensure all levels are present for each province
//	        List<Map<String, Object>> responseList = new ArrayList<>();
//	        for (String province : provinces) {
//	            Map<String, Object> map = new HashMap<>();
//	            map.put("province", province);
//	            for (String level : levels) {
//	                map.put(level, countsMap.getOrDefault(province, Collections.emptyMap()).getOrDefault(level, 0L));
//	            }
//	            responseList.add(map);
//	        }
//
//	        return ResponseEntity.ok(responseList);
	    }
  
	
	@RequestMapping("/shareholders/{id}")
	public ResponseEntity<List<Map<String, Object>>> shareholders(@PathVariable(name = "id") String id) {
		String sql = "select * from hf_ownerinfo where hf_id=?";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(id));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("fullname", t.get("fullname"));
				mapadmlvl.put("address", t.get("address"));
				
				mapadmlvl.put("mobile", t.get("mobile"));
				mapadmlvl.put("email", t.get("email"));
				mapadmlvl.put("citizenship", t.get("citizenship"));
				
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getCouncil")
	public ResponseEntity<List<Map<String, Object>>> getCouncil() {
		String sql = "select * from tbl_council ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("nameen", t.get("nameen"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getGroup")
	public ResponseEntity<List<Map<String, Object>>> getGroup() {
		String sql = "select * from tbl_samuha ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("namenp"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getethnicity")
	public ResponseEntity<List<Map<String, Object>>> getethnicity() {
		String sql = "select * from tbl_ethnicity ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("nameen", t.get("nameen"));
				mapadmlvl.put("namenp", t.get("name"));
				mapadmlvl.put("code", t.get("code"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getemptype")
	public ResponseEntity<List<Map<String, Object>>> getemptype() {
		String sql = "select * from tbl_emptype ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("namenp"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getEmplevel")
	public ResponseEntity<List<Map<String, Object>>> getEmplevel() {
		String sql = "select * from tbl_level ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("nameen"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getEmpstatus")
	public ResponseEntity<List<Map<String, Object>>> getEmpstatus() {
		String sql = "select * from tbl_emp_status ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("namenp"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getEducations")
	public ResponseEntity<List<Map<String, Object>>> getEducations() {
		String sql = "select * from tbl_edulevel ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("nameen"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getQualification")
	public ResponseEntity<List<Map<String, Object>>> getQualification(@RequestParam(name = "council",defaultValue = "500") String council,@RequestParam(name = "edu",defaultValue = "500") String edu) {
		String sql = "select * from tbl_qualification where council=? and level=? ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(council,edu));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("nameen"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getSubgroup")
	public ResponseEntity<List<Map<String, Object>>> getSubgroup(@RequestParam(name = "gid",defaultValue = "500") String gid) {
		String sql = "select * from tbl_upasamuha where samuha=?  ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(gid));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("namenp"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getPost")
	public ResponseEntity<List<Map<String, Object>>> getPost(@RequestParam(name = "gid",defaultValue = "500") String gid) {
		String sql = "select * from tbl_post where samuha=?  ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(gid));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("namenp"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	
	@RequestMapping("/getFlevel")
	public ResponseEntity<List<Map<String, Object>>> getFlevel(@RequestParam(name = "tid",defaultValue = "500") String tid) {
		String sql = "select * from facility_level where status=? and types like ? order by code";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(1,"%" + tid + "%"));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("name"));
				mapadmlvl.put("nameen", t.get("nameen"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/allflvel")
	public ResponseEntity<List<Map<String, Object>>> allflvel() {
		String sql = "select * from facility_level where status=? order by code";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(1));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("name"));
				mapadmlvl.put("nameen", t.get("nameen"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/gethfbycode")
	public ResponseEntity<List<Map<String, Object>>> gethfbycode(@RequestParam(name = "hfcode", defaultValue = "500") String hfcode) {
		String sql = "select id,hf_name from hfregistry where CAST(hf_code AS CHAR)=?";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(hfcode));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("name", t.get("hf_name"));
			
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/shareholdersedit/{id}")
	public ResponseEntity<List<Map<String, Object>>> shareholdersedit(@PathVariable(name = "id") String id) {
		String sql = "select * from hf_ownerinfo where hf_id=?";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(id));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("oname", t.get("fullname"));
				mapadmlvl.put("oaddress", t.get("address"));
				
				mapadmlvl.put("omobile", t.get("mobile"));
				mapadmlvl.put("oemail", t.get("email"));
				mapadmlvl.put("octzn", t.get("citizenship"));
				
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/workersedit/{id}")
	public ResponseEntity<List<Map<String, Object>>> workersedit(@PathVariable(name = "id") String id) {
		String sql = "select * from tbl_employee_import where importid=?";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(id));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("nameen", t.get("nameen"));
				mapadmlvl.put("namenp", t.get("namenp"));
				mapadmlvl.put("nid", t.get("nid"));
				mapadmlvl.put("gender", t.get("gender"));
				mapadmlvl.put("dob", t.get("dob"));
				mapadmlvl.put("ethnicity", t.get("ethnicity"));
				mapadmlvl.put("provinceid", t.get("province"));
				mapadmlvl.put("districtid", t.get("district"));
				mapadmlvl.put("palikaid", t.get("palika"));
				mapadmlvl.put("hwmobile", t.get("mobile"));
				mapadmlvl.put("hwemail", t.get("email"));
				mapadmlvl.put("council", t.get("council"));
				mapadmlvl.put("councilno", t.get("council_no"));
				
				mapadmlvl.put("pis", t.get("pis"));
				mapadmlvl.put("ppis", t.get("ppis"));
				
				mapadmlvl.put("emptype", t.get("emptype"));
				mapadmlvl.put("darbanditype", t.get("authlevel"));
				
				mapadmlvl.put("emplevel", t.get("level"));
				mapadmlvl.put("apoint_date", t.get("apoint_date"));
				
				mapadmlvl.put("att_date", t.get("att_date"));
				mapadmlvl.put("empstatus", t.get("empstatus"));
				
				mapadmlvl.put("worktype", t.get("worktype"));
				mapadmlvl.put("education", t.get("education"));
				
				mapadmlvl.put("qualification", t.get("qualification"));
				
				mapadmlvl.put("groupid", t.get("groupid"));
				mapadmlvl.put("subgroupid", t.get("subgroupid"));
				mapadmlvl.put("postid", t.get("postid"));
				
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/deviceInfo/{id}")
	public ResponseEntity<List<Map<String, Object>>> deviceInfo(@PathVariable(name = "id") String id) {
		String sql = "select * from hf_deviceinfo where hf_id=?";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(id));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("dname", t.get("dname"));
				mapadmlvl.put("dsource", t.get("dsource"));
				
				mapadmlvl.put("remarks", t.get("remarks"));
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/getHf/{id}")
	public ResponseEntity<List<Map<String, Object>>> getHflist(@PathVariable(name = "id") String id) {
		String sql = "select id,hf_name,hf_code from hfregistry where municipality=?";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(id));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("hf_name", t.get("hf_name"));
				
				mapadmlvl.put("hf_code", t.get("hf_code"));
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	public static String decrypt(String encryptedData, String secretKey) throws Exception {
		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

	    // Extract the IV and ciphertext
	    byte[] iv = Arrays.copyOfRange(encryptedBytes, 0, 16);
	    byte[] cipherBytes = Arrays.copyOfRange(encryptedBytes, 16, encryptedBytes.length);

	    // Prepare the key
	    SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

	    // Decrypt using AES/CBC/PKCS5Padding
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    IvParameterSpec ivSpec = new IvParameterSpec(iv);
	    cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

	    byte[] decryptedBytes = cipher.doFinal(cipherBytes);
	    return new String(decryptedBytes, "UTF-8");
    }
	
	@RequestMapping("/getotps")
	public ResponseEntity<Map<String, Object>> getotp(@RequestParam(name = "email", defaultValue = "") String email) throws Exception {
		 String secretKey = "7c276b3e853dfc6e7333cfac13a26bf8";

         // Decrypt the data
        
//		String subject="Your otp to apply online in NHFR is: ";
//		String body="123456";
//		System.out.println("email"+email);
//		SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email);
//        message.setSubject(subject);
//        message.setText(body);
//        message.setFrom("nhfrapplyonline@gmail.com"); // Optional: Set the sender email
//        disableSSLVerification();
//        System.out.println(message);
//        mailSender.send(message);
		 
		 
		 
		 	String from = "nhfrapplyonline@gmail.com";
	        String password = "ksiq eguz jytm amou"; // Use app password if 2FA is enabled
	        String to = email;

	        // SMTP server configuration
	        String host = "smtp.gmail.com";
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

	        // Get the Session object
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(from, password);
	            }
	        });

	        try {
	        	
	        	Random random = new Random();
	            int otp = 100000 + random.nextInt(900000);
	            // Create a default MimeMessage object
	            MimeMessage message = new MimeMessage(session);

	            // Set the From, To, Subject, and Body of the email
	            message.setFrom(new InternetAddress(from));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setSubject("OTP of NHFR");
	            message.setText("Your OTP to apply online is: "+otp);
	            String sql="insert into otplog(email,otp,expiry) values(?,?,DATE_ADD(NOW(), INTERVAL 5 MINUTE))";
			    db.execute(sql,Arrays.asList(email,otp));

	            // Send the message
	            Transport.send(message);
	            System.out.println("Email sent successfully.");
	            Map<String, Object> mapadmlvl = new HashMap<>();
	    		mapadmlvl.put("status", "1");
	    		return ResponseEntity.ok(mapadmlvl);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            Map<String, Object> mapadmlvl = new HashMap<>();
	    		mapadmlvl.put("status", "0");
	    		return ResponseEntity.ok(mapadmlvl);
	        }
        
		
	}
	
	@RequestMapping("/getotp")
	public ResponseEntity<Map<String, Object>> getotps(@RequestParam(name = "email", defaultValue = "") String email) throws Exception {
		 Map<String, Object> mapadmlvl = new HashMap<>(); 	
		try {
//		 		String secretKey = "7c276b3e853dfc6e7333cfac13a26bf8";
		 		String secretKey = "7c276b3e853dfc6e";
			    email = email.replaceAll("\\s+", "");
			    String decodedEmail = URLDecoder.decode(email, "UTF-8");
			    //for java version 
//			    String decodedEmail = URLDecoder.decode(email, StandardCharsets.UTF_8);
			    decodedEmail = decodedEmail.replace(" ", "+"); // Replace spaces with plus sign if needed
			    if (decodedEmail.length() % 4 != 0) {
			        decodedEmail += "=".repeat(4 - decodedEmail.length() % 4); // Ensure proper Base64 padding
			    }
			    String decryptedData = decrypt(decodedEmail, secretKey);
//			    System.out.println(decryptedData);
			    JSONObject json = new JSONObject(decryptedData);
			    String decryptedEmail = json.getString("email");
			    int otp = json.getInt("otp");
			    String sql="insert into otplog(email,otp,expiry) values(?,?,DATE_ADD(NOW(), INTERVAL 5 MINUTE))";
			    db.execute(sql,Arrays.asList(decryptedEmail,otp));
			   
			    mapadmlvl.put("status", "1");
			    return ResponseEntity.ok(mapadmlvl);
			} catch (Exception e) {
				e.printStackTrace();
				 mapadmlvl.put("status", "0");
				    return ResponseEntity.ok(mapadmlvl);
				// TODO: handle exception
			}
			
	}
	
	@RequestMapping("/checkotp")
	public ResponseEntity<Map<String, Object>> checkotp(@RequestParam(name = "email", defaultValue = "") String email,@RequestParam(name = "otp", defaultValue = "") String otp) throws Exception {
		 Map<String, Object> mapadmlvl = new HashMap<>(); 	
		
		 		
			String sql = "select  otp from otplog where email=? and expiry>= NOW() and otp=?  order by created_at desc limit 1";
			Tuple tt = db.getSingleResult(sql, Arrays.asList( email, otp));
			if (tt != null) {
				 mapadmlvl.put("status", "1");
				   return ResponseEntity.ok(mapadmlvl);
			}else {
				 mapadmlvl.put("status", "0");
				    return ResponseEntity.ok(mapadmlvl);
			}

			   
			   
			
			
	}
	
	private static void disableSSLVerification() throws Exception {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

	
	@RequestMapping("/gettrack")
	public ResponseEntity<List<Map<String, Object>>> gettrack(@RequestParam(name = "tid", defaultValue = "") String tid) {
		String sql = "select id,hf_name,hf_code,onlinestatus,soft_delete from hfregistry where CONCAT(id, hf_code)=?";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(tid));
		System.out.println(admlvl);
		List<Map<String, Object>> list = new ArrayList<>();
		if(admlvl.isEmpty()) {
			Map<String, Object> mapadmlvl = new HashMap<>();
			mapadmlvl.put("status", "0");
//			mapadmlvl.put("revs", null);
			list.add(mapadmlvl);
			return ResponseEntity.ok(list);
		}
		String hid=admlvl.get(0).get("id")+"";
		List<Map<String, Object>> revs = db.getResultListMap(
				"select count(id) as cid,remarks from hf_remarks where hf_id=?",
				Arrays.asList(hid));
		System.out.println(revs);
	
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("status", "1");
				mapadmlvl.put("hf_name", t.get("hf_name"));
				
				mapadmlvl.put("hf_code", t.get("hf_code"));
				mapadmlvl.put("onlinestatus", t.get("onlinestatus"));
				mapadmlvl.put("soft_delete", t.get("soft_delete"));
				
				
				list.add(mapadmlvl);
			}
		}else {
			Map<String, Object> mapadmlvl = new HashMap<>();
			mapadmlvl.put("status", "0");
//			mapadmlvl.put("revs", null);
			list.add(mapadmlvl);
		}
		
		Map<String, Object> rem = new HashMap<>();
		if (revs.size() == 0) {
//			System.out.println(revs.size());
			rem.put("revs", "");
		} else {
			rem.put("revs", revs);
		}
		
		list.add(rem);
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/servicestypeonline/{id}")
	public ResponseEntity<List<Map<String, Object>>> servicesTypeonline(@PathVariable(name = "id") String id) {
//		HttpSession session = request.getSession(false);
//		System.out.println("sessionID: "+session.getAttribute("userId"));
		String sql = "select st.name from hf_healthservice hh join health_service st on st.id=hh.service_id where hh.hf_id=?";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(id));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("name", t.get("name"));
				
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	
	@RequestMapping("/servicesonline/{id}")
	public ResponseEntity<List<Map<String, Object>>> servicesonline(@PathVariable(name = "id") String id) {
		String sql = "select s.id,s.code,s.name,s.parent from new_hf_services ns join new_services s on s.id=ns.service_id where ns.hf_id=? order by s.orders";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(id));
		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("code", t.get("code"));
				mapadmlvl.put("name", t.get("name"));
				mapadmlvl.put("id", t.get("id"));
				mapadmlvl.put("parent", t.get("parent"));
				list.add(mapadmlvl);
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/wardwise-count")
	public ResponseEntity<List<Map<String, Object>>> getwardWisecount(@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues) {
		String sql = "select numberofward from admin_local_level_structure where vcid=?";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(rvalues));
		int nward=(int) admlvl.get(0).get("numberofward");
		List<Map<String, Object>> list = new ArrayList<>();
		for(int i=1;i<=nward;i++) {	
			Map<String, Object> mapadmlvl = new HashMap<>();
			mapadmlvl.put("ward", i);
			mapadmlvl.put("total", getTotal(i,rvalues));
			mapadmlvl.put("gov", getGov(i,rvalues));
			mapadmlvl.put("ngov",getnGov(i,rvalues));
			mapadmlvl.put("normal",getNormalbed(i,rvalues));
			mapadmlvl.put("icu", getIcubed(i,rvalues));
			mapadmlvl.put("vent", getVentbed(i,rvalues));
			list.add(mapadmlvl);
		}
		
		return ResponseEntity.ok(list);
	}
	
	
	
	private Object getNormalbed(int i, String rvalues) {
		String sql = "select COALESCE(SUM(functional),0) as total from hfregistry where municipality=? and ward=? and soft_delete=0";
		Map<String, Object> data = db.getSingleResultMap(sql, Arrays.asList(rvalues,i));
		return data.get("total");
	}
	private Object getIcubed(int i, String rvalues) {
		String sql = "select COALESCE(SUM(icu_functional),0) as total from hfregistry where municipality=? and ward=? and soft_delete=0";
		Map<String, Object> data = db.getSingleResultMap(sql, Arrays.asList(rvalues,i));
		return data.get("total");
	}
	private Object getVentbed(int i, String rvalues) {
		String sql = "select COALESCE(SUM(ventilator_functional),0) as total from hfregistry where municipality=? and ward=? and soft_delete=0";
		Map<String, Object> data = db.getSingleResultMap(sql, Arrays.asList(rvalues,i));
		return data.get("total");
	}
	private Object getGov(int i, String rvalues) {
		String sql = "select count(id) as total from hfregistry where municipality=? and ward=? and type=? and soft_delete=0";
		Map<String, Object> data = db.getSingleResultMap(sql, Arrays.asList(rvalues,i,1));
		return data.get("total");
	}
	private Object getnGov(int i, String rvalues) {
		String sql = "select count(id) as total from hfregistry where municipality=? and ward=? and type=? and soft_delete=0";
		Map<String, Object> data = db.getSingleResultMap(sql, Arrays.asList(rvalues,i,2));
		return data.get("total");
	}
	private Object getTotal(int i, String rvalues) {
		String sql = "select count(id) as total from hfregistry where municipality=? and ward=? and soft_delete=0";
		Map<String, Object> data = db.getSingleResultMap(sql, Arrays.asList(rvalues,i));
		return data.get("total");
	}
	@RequestMapping("/authlevel-count")
	public String[][] getauthlvlcount(@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues) {
		String[] fc;
		String[] pc;
		String[] lc;
		String[] icu;
		String[] vent;
		if("palika".equals(roles)) {
			 fc=healthFacilityRepo.getFederalcountM(rvalues);
			 pc=healthFacilityRepo.getProvincialcountM(rvalues);
			 lc=healthFacilityRepo.getLocalCountM(rvalues);
			 icu=healthFacilityRepo.getIcuCountM(rvalues);
			 vent=healthFacilityRepo.getVentCountM(rvalues);
		}else if("district".equals(roles)) {
			 fc=healthFacilityRepo.getFederalcountD(rvalues);
			 pc=healthFacilityRepo.getProvincialcountD(rvalues);
			 lc=healthFacilityRepo.getLocalCountD(rvalues);
			 icu=healthFacilityRepo.getIcuCountD(rvalues);
			 vent=healthFacilityRepo.getVentCountD(rvalues);
		}else if("provincial".equals(roles)) {
			 fc=healthFacilityRepo.getFederalcountP(rvalues);
			 pc=healthFacilityRepo.getProvincialcountP(rvalues);
			 lc=healthFacilityRepo.getLocalCountP(rvalues);
			 icu=healthFacilityRepo.getIcuCountP(rvalues);
			 vent=healthFacilityRepo.getVentCountP(rvalues);
		}else {
			 fc=healthFacilityRepo.getFederalcount();
			 pc=healthFacilityRepo.getProvincialcount();
			 lc=healthFacilityRepo.getLocalCount();
			 icu=healthFacilityRepo.getIcuCount();
			 vent=healthFacilityRepo.getVentCount();
		}
		
		String[][] arr = new String [][] {fc,pc,lc,icu,vent};
		
		return arr;
	}
	
	@RequestMapping("/auth-count")
	public String[][] getauthcount(@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues) {
//		System.out.println(roles +" "+ rvalues);
		String[] tc;
		String[] gc;
		String[] ngc;
		if("palika".equals(roles)) {
			 tc=healthFacilityRepo.getTotalM(rvalues);
			 gc=healthFacilityRepo.getGovcountM(rvalues);
			 ngc=healthFacilityRepo.getNgovCountM(rvalues);
			
		}
		else if("district".equals(roles)) {
			 tc=healthFacilityRepo.getTotalD(rvalues);
			 gc=healthFacilityRepo.getGovcountD(rvalues);
			 ngc=healthFacilityRepo.getNgovCountD(rvalues);
			
		}
		else if("provincial".equals(roles)) {
			 tc=healthFacilityRepo.getTotalP(rvalues);
			 gc=healthFacilityRepo.getGovcountP(rvalues);
			 ngc=healthFacilityRepo.getNgovCountP(rvalues);
			
		}
		else {
			 tc=healthFacilityRepo.getTotal();
			 gc=healthFacilityRepo.getGovcount();
			 ngc=healthFacilityRepo.getNgovCount();
			
		}
		
		String[][] arr = new String [][] {tc,gc,ngc};
		
		return arr;
	}
	
	
	@RequestMapping("/auth-count-bed")
	public String[][] getauthcountbed(@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues) {
//		System.out.println(roles +" "+ rvalues);
		String[] tc;
		String[] gc;
		String[] ngc;
		if("palika".equals(roles)) {
			 tc=healthFacilityRepo.getTotalMBed(rvalues);
			 gc=healthFacilityRepo.getGovcountM(rvalues);
			 ngc=healthFacilityRepo.getNgovCountM(rvalues);
			
		}
		else if("district".equals(roles)) {
			 tc=healthFacilityRepo.getTotalDBed(rvalues);
			 gc=healthFacilityRepo.getGovcountD(rvalues);
			 ngc=healthFacilityRepo.getNgovCountD(rvalues);
			
		}
		else if("provincial".equals(roles)) {
			 tc=healthFacilityRepo.getTotalPBed(rvalues);
			 gc=healthFacilityRepo.getGovcountP(rvalues);
			 ngc=healthFacilityRepo.getNgovCountP(rvalues);
			
		}
		else {
			 tc=healthFacilityRepo.getTotalBed();
			 gc=healthFacilityRepo.getGovcount();
			 ngc=healthFacilityRepo.getNgovCount();
			
		}
		
		String[][] arr = new String [][] {tc,gc,ngc};
		
		return arr;
	}
	
	@RequestMapping("/auth-count-online")
	public String[][] getauthcountOnline(@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues) {
//		System.out.println(roles +" "+ rvalues);
		String[] tc;
		String[] gc;
		String[] ngc;
		if("palika".equals(roles)) {
			 tc=healthFacilityRepo.getTotalOnlineM(rvalues);
			 gc=healthFacilityRepo.getGovcountM(rvalues);
			 ngc=healthFacilityRepo.getNgovCountM(rvalues);
			
		}
		else if("district".equals(roles)) {
			 tc=healthFacilityRepo.getTotalOnlineD(rvalues);
			 gc=healthFacilityRepo.getGovcountD(rvalues);
			 ngc=healthFacilityRepo.getNgovCountD(rvalues);
			
		}
		else if("provincial".equals(roles)) {
			 tc=healthFacilityRepo.getTotalOnlineP(rvalues);
			 gc=healthFacilityRepo.getGovcountP(rvalues);
			 ngc=healthFacilityRepo.getNgovCountP(rvalues);
			
		}
		else {
			 tc=healthFacilityRepo.getTotalOnline();
			 gc=healthFacilityRepo.getGovcount();
			 ngc=healthFacilityRepo.getNgovCount();
			
		}
		
		String[][] arr = new String [][] {tc,gc,ngc};
		
		return arr;
	}
	
	@RequestMapping("/exp-count")
	public String[][] getexpcount(@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "ndate", defaultValue = "") String ndate,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues) {
		String[] tc;
		
		if("palika".equals(roles)) {
			 tc=healthFacilityRepo.getTotalMexp(rvalues,ndate);
			
		}
		else if("district".equals(roles)) {
			 tc=healthFacilityRepo.getTotalDexp(rvalues,ndate);
			
		}
		else if("provincial".equals(roles)) {
			 tc=healthFacilityRepo.getTotalPexp(rvalues,ndate);
			
		}
		else {
			 tc=healthFacilityRepo.getTotalExp(ndate);
			
		}
		
		String[][] arr = new String [][] {tc};
		
		
		
		return arr;
	}
	
	@RequestMapping("/exp-count-month")
	public String[][] getexpcountMonth(@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "ndate", defaultValue = "") String ndate,
			@RequestParam(name = "endate", defaultValue = "") String endate,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues) {
		String[] tc;

		if("palika".equals(roles)) {
			 tc=healthFacilityRepo.getTotalMexp(rvalues,ndate,endate);
			
		}
		else if("district".equals(roles)) {
			 tc=healthFacilityRepo.getTotalDexp(rvalues,ndate,endate);
			
		}
		else if("provincial".equals(roles)) {
			 tc=healthFacilityRepo.getTotalPexp(rvalues,ndate,endate);
			
		}
		else {
			 tc=healthFacilityRepo.getTotalExp(ndate,endate);
			
		}
		
		String[][] arr = new String [][] {tc};
		
		
		
		return arr;
	}
	
	@RequestMapping("/covid-count")
	public String[][] getCovidcount(@RequestParam(name = "roles", defaultValue = "") String roles,
			@RequestParam(name = "rvalues", defaultValue = "") String rvalues) {
		String[] c;
		String[] c1;
		String[] c2;
		String[] c3;
		if("palika".equals(roles)) {
			 c=healthFacilityRepo.getCovidCountM(56,rvalues);
			 c1=healthFacilityRepo.getCovidCountM(57,rvalues);
			 c2=healthFacilityRepo.getCovidCountM(58,rvalues);
			 c3=healthFacilityRepo.getCovidCountM(59,rvalues);
		}else if("district".equals(roles)) {
			 c=healthFacilityRepo.getCovidCountD(56,rvalues);
			 c1=healthFacilityRepo.getCovidCountD(57,rvalues);
			 c2=healthFacilityRepo.getCovidCountD(58,rvalues);
			 c3=healthFacilityRepo.getCovidCountD(59,rvalues);
		}else if("provincial".equals(roles)) {
			 c=healthFacilityRepo.getCovidCountP(56,rvalues);
			 c1=healthFacilityRepo.getCovidCountP(57,rvalues);
			 c2=healthFacilityRepo.getCovidCountP(58,rvalues);
			 c3=healthFacilityRepo.getCovidCountP(59,rvalues);
		}else {
			 c=healthFacilityRepo.getCovidCount(56);
			 c1=healthFacilityRepo.getCovidCount(57);
			 c2=healthFacilityRepo.getCovidCount(58);
			 c3=healthFacilityRepo.getCovidCount(59);
		}
		
		String[][] arr = new String [][] {c,c1,c2,c3};
		
		return arr;
	}
	
	
	
	@RequestMapping(value = "/api/hf-create", method = RequestMethod.POST)
	public @ResponseBody String addFacility(@RequestBody HealthFacility healthFacility) {
		String munc=healthFacility.getMunicipality();
		String[] services=healthFacility.getServices();
		String[] opdService=healthFacility.getOpdServices();
		String[] surgicService=healthFacility.getSurgicalServices();
		String[] radioService=healthFacility.getRadiologyServices();
		String[] labService=healthFacility.getLaboratoryServices();
		String[] specialService=healthFacility.getSpecializedServices();
		String[] ayurvedService=healthFacility.getAyurvedServices();
		String[] motherhoodService=healthFacility.getSafeMotherhoodServices();
		String[] fplanningService=healthFacility.getFamilyPlanningServices();
		String[] bipannaService=healthFacility.getBipannaServices();
        String token=healthFacility.getToken();
//        System.out.println(token);
		int type=healthFacility.getType();
		int flvl=healthFacility.getLevel();
//		System.out.println(munc);
		String[] hf=healthFacilityRepo.findCodess(munc);
//		System.out.println(Arrays.toString(hf));
		if (hf != null && hf.length > 0) {
			String[] ss = hf[0].split(",");
			int ucode=Integer.parseInt(ss[1])+1;
			String ucodes=String.format("%04d",ucode);
			String hfcod=ss[0]+ucodes+type;
			healthFacility.setCbscode(Integer.parseInt(ss[0]));
			healthFacility.setUcode(Integer.parseInt(ucodes));
			BigInteger numBig = new BigInteger(hfcod);
//			System.out.println(numBig);
			healthFacility.setHf_code(numBig);
		}else {
			int cbs=healthFacilityRepo.getCbsCodes(munc);
			String ucodes=String.format("%04d",1);
			String hfcod=cbs+ucodes+type;
			healthFacility.setCbscode(cbs);
			healthFacility.setUcode(Integer.parseInt(ucodes));
			BigInteger numBig = new BigInteger(hfcod);
//			System.out.println(numBig);
			healthFacility.setHf_code(numBig);
		}
		
		
		
		int lid=0;	
		
//		String tuser=healthFacilityRepo.findApiuser(token);
		String tuser=healthFacilityRepo.findApiuserRole(token);
//		System.out.println(tuser);
		
		if("1".equals(tuser)) {
		HealthFacilityService.addFacilityType(healthFacility);
		lid = healthFacility.getId();
		healthFacilityRepo.addHistoryLevel(lid,flvl);
//		System.out.println(lid);
		for (String s: services) {  
			healthFacilityRepo.addServices(lid,s);
			healthFacilityRepo.addHistoryServices(lid,s);
		}	
		for (String s: opdService) {  
			healthFacilityRepo.addOpdServices(lid,s);
			healthFacilityRepo.addOpdHistoryServices(lid,s);
		}	
		
		for(String s: surgicService) {
			healthFacilityRepo.addSurgicalServices(lid, s);
			healthFacilityRepo.addSurgicalHistoryServices(lid, s);
		}
		
		for(String s: radioService) {
			healthFacilityRepo.addRadioServices(lid, s);
			healthFacilityRepo.addRadioHistoryServices(lid, s);
		}
		
		for(String s: labService) {
			healthFacilityRepo.addLabServices(lid, s);
			healthFacilityRepo.addLabHistoryServices(lid, s);
		}
		for(String s: specialService) {
			healthFacilityRepo.addSpeicalServices(lid, s);
			healthFacilityRepo.addspecialHistoryServices(lid, s);
		}
		for(String s: ayurvedService) {
			healthFacilityRepo.addAyurServices(lid, s);
			healthFacilityRepo.addAyurHistoryServices(lid, s);
		}
		for(String s: motherhoodService) {
			healthFacilityRepo.addMotherServices(lid, s);
			healthFacilityRepo.addMotherHistoryServices(lid, s);
		}
		for(String s: fplanningService) {
			healthFacilityRepo.addFamilyServices(lid, s);
			healthFacilityRepo.addFamilyHistoryServices(lid,s);
		}
		for(String s: bipannaService) {
			healthFacilityRepo.addFreeServices(lid, s);
			healthFacilityRepo.addFreeHistoryServices(lid, s);
		}
		Integer aid=healthFacilityRepo.findApiUserid(token);
		
			ApiLog a =new ApiLog();
			a.setUserid(aid);
			a.setAction("create");
			a.setUrl("api/hf-create");
			a.setCaseid(lid);
			apilogservice.addApiLog(a);
		return "Saved Successfull!";
		}else {
			return "Invalid API Token or Users is disabled.";
		}
	}
	

	@RequestMapping(value = "/api/hf-update", method = RequestMethod.POST)
	public @ResponseBody String updateFacility(@RequestBody HealthFacility healthFacility) {
		int id=healthFacility.getId();
		String munc=healthFacility.getMunicipality();
		String[] services=healthFacility.getServices();
		String[] opdService=healthFacility.getOpdServices();
		String[] surgicService=healthFacility.getSurgicalServices();
		String[] radioService=healthFacility.getRadiologyServices();
		String[] labService=healthFacility.getLaboratoryServices();
		String[] specialService=healthFacility.getSpecializedServices();
		String[] ayurvedService=healthFacility.getAyurvedServices();
		String[] motherhoodService=healthFacility.getSafeMotherhoodServices();
		String[] fplanningService=healthFacility.getFamilyPlanningServices();
		String[] bipannaService=healthFacility.getBipannaServices();
        String token=healthFacility.getToken();
//        System.out.println(token);
		int type=healthFacility.getType();
		int flvl=healthFacility.getLevel();
//		System.out.println(munc);
		String[] psresult=hfServicesRepo.findAllServiceByHfid(id);
		
		String[] poresult=hfOpdRepo.findAllServiceByHfid(id);
		
		String[] psurResult=hfSurgicRepo.findAllServiceByHfId(id);
		
		String[] pspclResult = hfSpecialRepo.findAllServiceByHfId(id);
		
		String[] plabresult= hfLabRepo.findAllServiceByHfId(id);
		
		String[] pradioResult=hfRadioRepo.findAllServiceByHfId(id);
		
		String[] pfreeResult = hfBipannaRepo.findAllServiceByHfId(id);
		
		String[] payurResult =hfAyurRepo.findAllServiceByHfId(id);
		
		String[] pfamilyResult = hfFamilyRepo.findAllServiceByHfId(id);
		
		String[] pmotherResult = hfMotherRepo.findAllServiceByHfId(id);
		
		HashSet<String> sadded = new HashSet<String>(Arrays.asList(services));
		sadded.removeAll(Arrays.asList(psresult));
		HashSet<String> sremoved = new HashSet<String>(Arrays.asList(psresult));
		sremoved.removeAll(Arrays.asList(services));
		
		HashSet<String> oadded = new HashSet<String>(Arrays.asList(opdService));
		oadded.removeAll(Arrays.asList(poresult));
		HashSet<String> oremoved = new HashSet<String>(Arrays.asList(poresult));
		oremoved.removeAll(Arrays.asList(opdService));
		
		HashSet<String> suradded = new HashSet<String>(Arrays.asList(surgicService));
		suradded.removeAll(Arrays.asList(psurResult));
		HashSet<String> surremoved = new HashSet<String>(Arrays.asList(psurResult));
		surremoved.removeAll(Arrays.asList(surgicService));
		
		HashSet<String> spcladded = new HashSet<String>(Arrays.asList(specialService));
		spcladded.removeAll(Arrays.asList(pspclResult));
		HashSet<String> spclremoved = new HashSet<String>(Arrays.asList(pspclResult));
		spclremoved.removeAll(Arrays.asList(specialService));
		
		HashSet<String> labadded = new HashSet<String>(Arrays.asList(labService));
		labadded.removeAll(Arrays.asList(plabresult));
		HashSet<String> labremoved = new HashSet<String>(Arrays.asList(plabresult));
		labremoved.removeAll(Arrays.asList(labService));
		
		HashSet<String> radioadded = new HashSet<String>(Arrays.asList(radioService));
		radioadded.removeAll(Arrays.asList(pradioResult));
		HashSet<String> radioremoved = new HashSet<String>(Arrays.asList(pradioResult));
		radioremoved.removeAll(Arrays.asList(radioService));
		
		HashSet<String> freeadded = new HashSet<String>(Arrays.asList(bipannaService));
		freeadded.removeAll(Arrays.asList(pfreeResult));
		HashSet<String> freeremoved = new HashSet<String>(Arrays.asList(pfreeResult));
		freeremoved.removeAll(Arrays.asList(bipannaService));
		
		HashSet<String> ayuradded = new HashSet<String>(Arrays.asList(ayurvedService));
		ayuradded.removeAll(Arrays.asList(payurResult));
		HashSet<String> ayurremoved = new HashSet<String>(Arrays.asList(payurResult));
		ayurremoved.removeAll(Arrays.asList(ayurvedService));
		
		HashSet<String> famadded = new HashSet<String>(Arrays.asList(fplanningService));
		famadded.removeAll(Arrays.asList(pfamilyResult));
		HashSet<String> famremoved = new HashSet<String>(Arrays.asList(pfamilyResult));
		famremoved.removeAll(Arrays.asList(fplanningService));
		
		HashSet<String>motheradded = new HashSet<String>(Arrays.asList(motherhoodService));
		motheradded.removeAll(Arrays.asList(pmotherResult));
		HashSet<String> motherremoved = new HashSet<String>(Arrays.asList(pmotherResult));
		motherremoved.removeAll(Arrays.asList(motherhoodService));
		
		String phf[]=healthFacilityRepo.findPreviouscode(id);
		String sphf[]=phf[0].split(",");
		String cbscode;
		int ucode;
		if(sphf[2].equals(munc)) {
			 ucode=Integer.parseInt(sphf[1]);
			 cbscode=sphf[0];
		}else {
			String[] hf=healthFacilityRepo.findCodess(munc);
			if (hf != null && hf.length > 0) {
				String[] ss = hf[0].split(",");
				 ucode=Integer.parseInt(ss[1])+1;
				 cbscode=ss[0];
				
			}else {
				int cbs=healthFacilityRepo.getCbsCodes(munc);
				ucode=1;
				cbscode=String.valueOf(cbs);

			}
		}
		
//		System.out.println(hf[0]);
		
		String ucodes=String.format("%04d",ucode);
		String hfcod=cbscode+ucodes+type;
		healthFacility.setCbscode(Integer.parseInt(cbscode));
		healthFacility.setUcode(Integer.parseInt(ucodes));
		BigInteger numBig = new BigInteger(hfcod);
//		System.out.println(numBig);
		healthFacility.setHf_code(numBig);
		int lid=0;	
		
//		String tuser=healthFacilityRepo.findApiuser(token);
		String tuser=healthFacilityRepo.findApiuserRole(token);
//		System.out.println(tuser);
//		System.out.println(psresult);
//		System.out.println(services);
		
		if("1".equals(tuser)) {
			healthFacility.setId(id);
		HealthFacilityService.addFacilityType(healthFacility);
//		lid = healthFacility.getId();
		int plevel=healthFacilityRepo.findlevels(id);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if(plevel!=flvl) {
			healthFacilityRepo.updateFlevelhistory(id,plevel,timestamp);
			healthFacilityRepo.addHistoryLevel(id,flvl);
		}
//		System.out.println(lid);

		
			for(String s: sadded) {
				healthFacilityRepo.addServices(id,s);
				healthFacilityRepo.addHistoryServices(id,s);
			}
			
			for(String s: sremoved) {
				healthFacilityRepo.deleteService(id,s);
				healthFacilityRepo.updateHistoryServices(id,s,timestamp);	
			}
			
		
			for(String s: oadded) {
				healthFacilityRepo.addOpdServices(id,s);
				healthFacilityRepo.addOpdHistoryServices(id,s);
			}
			
			for(String s: oremoved) {
				healthFacilityRepo.deleteOpdService(id,s);
				healthFacilityRepo.updateOpdHistoryServices(id,s,timestamp);	
			}
				
			
			for(String s: suradded) {
				healthFacilityRepo.addSurgicalServices(id,s);
				healthFacilityRepo.addSurgicalHistoryServices(id,s);
			}
			
			for(String s: surremoved) {
				healthFacilityRepo.deleteSurgicalService(id,s);
				healthFacilityRepo.updateSurgicalHistoryServices(id,s,timestamp);	
			}
					
			
			for(String s: spcladded) {
				healthFacilityRepo.addSpeicalServices(id,s);
				healthFacilityRepo.addspecialHistoryServices(id,s);
			}
			for(String s: spclremoved) {
				healthFacilityRepo.deleteSpecialService(id,s);
				healthFacilityRepo.updateSpecialHistoryServices(id,s,timestamp);	
			}

		
			for(String s: labadded) {
				healthFacilityRepo.addLabServices(id,s);
				healthFacilityRepo.addLabHistoryServices(id,s);
			}
		
			for(String s: labremoved) {
				healthFacilityRepo.deleteLabService(id,s);
				healthFacilityRepo.updateLabHistoryServices(id,s,timestamp);	
			}
			
			
			for(String s: radioadded) {
				healthFacilityRepo.addRadioServices(id,s);
				healthFacilityRepo.addRadioHistoryServices(id,s);
			}
		
			for(String s: radioremoved) {
				healthFacilityRepo.deleteRadioService(id,s);
				healthFacilityRepo.updateRadioHistoryServices(id,s,timestamp);	
			}
			
			
			for(String s: freeadded) {
				healthFacilityRepo.addFreeServices(id,s);
				healthFacilityRepo.addFreeHistoryServices(id,s);
			}
			
			
			for(String s: freeremoved) {
				healthFacilityRepo.deleteFreeService(id,s);
				healthFacilityRepo.updateFreeHistoryServices(id,s,timestamp);	
			}
			
			
			for(String s: ayuradded) {
				healthFacilityRepo.addAyurServices(id,s);
				healthFacilityRepo.addAyurHistoryServices(id,s);
			}
		
			for(String s: ayurremoved) {
				healthFacilityRepo.deleteAyurService(id,s);
				healthFacilityRepo.updateAyurHistoryServices(id,s,timestamp);	
			}
			
			
			for(String s: famadded) {
				healthFacilityRepo.addFamilyServices(id,s);
				healthFacilityRepo.addFamilyHistoryServices(id,s);
			}
		
			for(String s: famremoved) {
				healthFacilityRepo.deleteFamilyService(id,s);
				healthFacilityRepo.updateFamilyHistoryServices(id,s,timestamp);	
			}
			
		
			for(String s: motheradded) {
				healthFacilityRepo.addMotherServices(id,s);
				healthFacilityRepo.addMotherHistoryServices(id,s);
			}
			
			for(String s: motherremoved) {
				healthFacilityRepo.deleteMotherService(id,s);
				healthFacilityRepo.updateMotherHistoryServices(id,s,timestamp);	
			}
			
			Integer aid=healthFacilityRepo.findApiUserid(token);
			
			ApiLog a =new ApiLog();
			a.setUserid(aid);
			a.setAction("update");
			a.setUrl("api/hf-update");
			a.setCaseid(id);
			apilogservice.addApiLog(a);

		return "Saved Successfull!";
		}else {
			return "Invalid API Token or Users is disabled.";
		}
	}
	
//	@RequestMapping("/user-list/list")
//	public List<Users> getAllUsers(@RequestParam(name="search",required=false) String search){
//		return healthFacilityRepo.getUsersList(search);
//	}
	
	
}
