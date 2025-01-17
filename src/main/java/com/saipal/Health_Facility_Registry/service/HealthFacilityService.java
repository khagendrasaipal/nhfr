package com.saipal.Health_Facility_Registry.service;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Tuple;

//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.ApiLog;
import com.saipal.Health_Facility_Registry.entity.HealthFacility;
import com.saipal.Health_Facility_Registry.repository.ApilogRepo;
import com.saipal.Health_Facility_Registry.repository.HealthFacilityRepo;


@Service
public class HealthFacilityService {

	@Autowired
	HealthFacilityRepo healthFacilityRepo;
	@Autowired
	ApilogService apilogservice;
//	@Autowired
//	EntityManager em;
	@Qualifier("encoder")
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	com.saipal.Health_Facility_Registry.util.DB db;
	
	

	public void addFacilityType(HealthFacility HealthFacility) {
		healthFacilityRepo.save(HealthFacility);

	}
	
	public List<HealthFacility> getFacilityType(String search) {
		return healthFacilityRepo.findAllList(search);

	}
	
	public List<HealthFacility> getFacilityTypeExcel(String search) {
		System.out.println("here");
		System.out.println(healthFacilityRepo.getFacilityTypeExcel(search));
		return healthFacilityRepo.getFacilityTypeExcel(search);

	}
	
	
	
	public List<HealthFacility> getFacilityTypeDashboard(String search) {
		return healthFacilityRepo.findAllListDash(search);

	}
	
	
	
	

//	public void delete(int id) {
//		healthFacilityRepo.deleteById(id);
//	}
	public void delete(int id) {
		healthFacilityRepo.softDelete(id);
	}

	public HealthFacility get(int id) {
		return healthFacilityRepo.findById(id).get();
	}
	
	


//	public List<HealthFacility> getFacilityLists(String search, String roles, String rvalues) {
//		List<HealthFacility> hfList = new ArrayList<>();
//		HealthFacility hf;
//		String sql = "SELECT p.* FROM hfregistry p LEFT JOIN health_facility_type n ON p.type = n.id LEFT JOIN ownership o ON p.ownership=o.id  LEFT JOIN facility_level l ON p.level=l.id  WHERE p.hf_name LIKE %?% AND p."
//				+ roles + "=? ";
//		Query query = em.createNamedQuery(sql, Tuple.class);
//		query.setParameter(1, search);
//		query.setParameter(2, rvalues);
//		List<Tuple> tList = query.getResultList();
//		for (Tuple t : tList) {
//			hf = new HealthFacility();
//			hf.setAuthlevel(t.get("authlevel") + "");
//			hf.setHf_name(t.get("hf_name") + "");
//            hf.setMunicipality(t.get("municipality") + "");
//			hfList.add(hf);
//
//		}
//		return hfList;
//		// return healthFacilityRepo.findAllHFList(search, roles, rvalues);
//	}

//	public List<HealthFacility> getFacilityList(String search, String roles, String rvalues,Integer uid) {
//		if("provincial".equals(roles)) {
//			return healthFacilityRepo.findAllHFListByProvince(search, rvalues);
//		}
//		if("palika".equals(roles)) {
//			return healthFacilityRepo.findAllHFListByPalika(search, rvalues,uid);
//		}
//		if("district".equals(roles)) {
//			return healthFacilityRepo.findAllHFListByDistrict(search, rvalues);
//		}
//		return healthFacilityRepo.findAllList(search);
//	}

	public int upDatePassword(String username, String old, String newpass) {
		String pp=healthFacilityRepo.findOne(username);
		
		System.out.println(pp);
		if(passwordEncoder.matches(old, pp)){
			return healthFacilityRepo.updatePasswords(username,newpass);
		}else {
			return 0;
		}
		
	}

	public List<HealthFacility> getAllPagination(Integer pageNo,Integer pagesize,String sortby, String token) {
		if(pagesize>=100) {
			pagesize=100;
		}
		if("".equals(sortby)) {
			sortby="id";
		}
		String tuser=healthFacilityRepo.findApiuser(token);
		Integer aid=healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if("1".equals(tuser)) {
			ApiLog a =new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/get-hf");
			apilogservice.addApiLog(a);
			
		Pageable pageable =  PageRequest.of(pageNo, pagesize, Sort.by(sortby));
		//System.out.println(healthFacilityRepo.getAllInPagination(pageable));
		Page<HealthFacility> pagedResult = healthFacilityRepo.findAll(pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<HealthFacility>();
		}
		}else {
			return new ArrayList<HealthFacility>();
		}
		
		
	}
	
	
	public List<HealthFacility> getAllPaginations(Integer pageNo,Integer pagesize,String sortby, String token) {
		if(pagesize>=100) {
			pagesize=100;
		}
		if("".equals(sortby)) {
			sortby="id";
		}
//		String tuser=healthFacilityRepo.findApiuser(token);
//		Integer aid=healthFacilityRepo.findApiUserid(token);
//		System.out.println(tuser);
		if("1".equals("1")) {
//			ApiLog a =new ApiLog();
//			a.setUserid(aid);
//			a.setAction("fetch");
//			a.setUrl("api/get-hf");
//			apilogservice.addApiLog(a);
//			
		Pageable pageable =  PageRequest.of(pageNo, pagesize, Sort.by(sortby));
		//System.out.println(healthFacilityRepo.getAllInPagination(pageable));
		Page<HealthFacility> pagedResult = healthFacilityRepo.findAll(pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<HealthFacility>();
		}
		}else {
			return new ArrayList<HealthFacility>();
		}
		
		
	}
	public List<HealthFacility> getHfbycode(BigInteger code, String token) {
		String tuser=healthFacilityRepo.findApiuser(token);
		Integer aid=healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if("1".equals(tuser)) {
			ApiLog a =new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/get-hf-byHfCode");
			apilogservice.addApiLog(a);
			return healthFacilityRepo.findHfbycode(code);
		}else {
           return null;
			
		}
		
	}

	public List<HealthFacility> getHfbyProvince(int pageNo, int pagesize, String sortby, String token, int province) {
		if(pagesize>=100) {
			pagesize=100;
		}
		if("".equals(sortby)) {
			sortby="id";
		}
		String tuser=healthFacilityRepo.findApiuser(token);
		Integer aid=healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if("1".equals(tuser)) {
			ApiLog a =new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/get-hf-byProvince");
			apilogservice.addApiLog(a);
		Pageable pageable =  PageRequest.of(pageNo, pagesize, Sort.by(sortby));
		//System.out.println(healthFacilityRepo.getAllInPagination(pageable));
		Page<HealthFacility> pagedResult = healthFacilityRepo.findByProvince(province,pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<HealthFacility>();
		}
		}else {
			return new ArrayList<HealthFacility>();
		}
	}

	public List<HealthFacility> getHfbyDistrict(int pageNo, int pagesize, String sortby, String token, int district) {
		if(pagesize>=100) {
			pagesize=100;
		}
		if("".equals(sortby)) {
			sortby="id";
		}
		String tuser=healthFacilityRepo.findApiuser(token);
		Integer aid=healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if("1".equals(tuser)) {
			ApiLog a =new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/get-hf-byDistrict");
			apilogservice.addApiLog(a);
		Pageable pageable =  PageRequest.of(pageNo, pagesize, Sort.by(sortby));
		//System.out.println(healthFacilityRepo.getAllInPagination(pageable));
		Page<HealthFacility> pagedResult = healthFacilityRepo.findByDistrict(district,pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<HealthFacility>();
		}
		}else {
			return new ArrayList<HealthFacility>();
		}
	}

	public List<HealthFacility> getHfbyMunicipality(int pageNo, int pagesize, String sortby, String token, String municipality) {
		if(pagesize>=100) {
			pagesize=100;
		}
		if("".equals(sortby)) {
			sortby="id";
		}
		String tuser=healthFacilityRepo.findApiuser(token);
		Integer aid=healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if("1".equals(tuser)) {
			ApiLog a =new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/get-hf-byMunicipality");
			apilogservice.addApiLog(a);
		Pageable pageable =  PageRequest.of(pageNo, pagesize, Sort.by(sortby));
		//System.out.println(healthFacilityRepo.getAllInPagination(pageable));
		Page<HealthFacility> pagedResult = healthFacilityRepo.findByPalika(municipality,pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			
			return new ArrayList<HealthFacility>();
		}
		}else {
			return new ArrayList<HealthFacility>();
		}
	}

	public List<HealthFacility> getHfSearch(int pageNo, int pagesize, String token, String sortby, String searchKeyword) {
		if(pagesize>=100) {
			pagesize=100;
		}
		if("".equals(sortby)) {
			sortby="id";
		}
		String tuser=healthFacilityRepo.findApiuser(token);
		Integer aid=healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if("1".equals(tuser)) {
			ApiLog a =new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/get-hf-search");
			apilogservice.addApiLog(a);
		Pageable pageable =  PageRequest.of(pageNo, pagesize, Sort.by(sortby));
		Page<HealthFacility> pagedResult = healthFacilityRepo.findBySearch(searchKeyword,pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			
			return new ArrayList<HealthFacility>();
		}
		}else {
			return new ArrayList<HealthFacility>();
		}
	}
	
	public List<HealthFacility> getFacilityList(String search, String roles, String rvalues, Integer uid,Integer pageNo,Integer pagesize) {
		Pageable pageable =  PageRequest.of(pageNo, pagesize, Sort.by("id"));
		if("provincial".equals(roles)) {
			
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByProvince(search, rvalues,uid,pageable);
//			return healthFacilityRepo.findAllHFListByProvince(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
		}
		if("palika".equals(roles)) {
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByPalika(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
//			return healthFacilityRepo.findAllHFListByPalika(search, rvalues,uid);
		}
		
		if("HF".equals(roles)) {
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByHF(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
//			return healthFacilityRepo.findAllHFListByPalika(search, rvalues,uid);
		}
		if("district".equals(roles)) {
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByDistrict(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
//			return healthFacilityRepo.findAllHFListByDistrict(search, rvalues,uid);
		}
		return new ArrayList<HealthFacility>();
//		return healthFacilityRepo.findAllList(search);
	}
	
	public List<HealthFacility> getFacilityListBed(String search, String roles, String rvalues, Integer uid,Integer pageNo,Integer pagesize) {
		Pageable pageable =  PageRequest.of(pageNo, pagesize, Sort.by("id"));
		if("provincial".equals(roles)) {
			
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByProvinceBed(search, rvalues,uid,pageable);
//			return healthFacilityRepo.findAllHFListByProvince(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
		}
		if("palika".equals(roles)) {
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByPalikaBed(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
//			return healthFacilityRepo.findAllHFListByPalika(search, rvalues,uid);
		}
		
		if("HF".equals(roles)) {
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByHF(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
//			return healthFacilityRepo.findAllHFListByPalika(search, rvalues,uid);
		}
		if("district".equals(roles)) {
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByDistrictBed(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
//			return healthFacilityRepo.findAllHFListByDistrict(search, rvalues,uid);
		}
		return new ArrayList<HealthFacility>();
//		return healthFacilityRepo.findAllList(search);
	}
	
	public List<HealthFacility> getFacilityListOnline(String search, String roles, String rvalues, Integer uid,Integer pageNo,Integer pagesize) {
		Pageable pageable =  PageRequest.of(pageNo, pagesize, Sort.by("id"));
		if("provincial".equals(roles)) {
			
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByProvinceOnline(search, rvalues,uid,pageable);
//			return healthFacilityRepo.findAllHFListByProvince(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
		}
		if("palika".equals(roles)) {
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByPalikaOnline(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
//			return healthFacilityRepo.findAllHFListByPalika(search, rvalues,uid);
		}
		if("district".equals(roles)) {
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListByDistrictOnline(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
//			return healthFacilityRepo.findAllHFListByDistrict(search, rvalues,uid);
		}
		return new ArrayList<HealthFacility>();
//		return healthFacilityRepo.findAllList(search);
	}

	public List<HealthFacility> getFacilityList(String search, String roles, String rvalues, Integer uid) {
		if("provincial".equals(roles)) {
			return healthFacilityRepo.findAllHFListByProvince(search, rvalues,uid);
		}
		if("palika".equals(roles)) {
			return healthFacilityRepo.findAllHFListByPalika(search, rvalues,uid);
		}
		if("district".equals(roles)) {
			return healthFacilityRepo.findAllHFListByDistrict(search, rvalues,uid);
		}
		return healthFacilityRepo.findAllList(search);
	}
	
	public List<HealthFacility> getFacilityListDash(String search, String roles, String rvalues, Integer uid) {
		if("provincial".equals(roles)) {
			return healthFacilityRepo.findAllHFListByProvinceDash(search, rvalues,uid);
		}
		if("palika".equals(roles)) {
			return healthFacilityRepo.findAllHFListByPalikaDash(search, rvalues,uid);
		}
		if("district".equals(roles)) {
			return healthFacilityRepo.findAllHFListByDistrictDash(search, rvalues,uid);
		}
		return healthFacilityRepo.findAllListDash(search);
	}
	
	public List<HealthFacility> getFacilityByPalikaService(String palika, int service, String tab, String col) {
		if(tab.equals("hf_opd")) {
			return healthFacilityRepo.getFacilityByPalikaServiceOpd( palika,  service,  tab,  col);
		}
		
		else if(tab.equals("hf_motherhood")) {
			return healthFacilityRepo.getFacilityByPalikaServiceMother( palika,  service,  tab,  col);
		}else if(tab.equals("hf_familyplanning")) {
			return healthFacilityRepo.getFacilityByPalikaServicefp( palika,  service,  tab,  col);
		}
		else if(tab.equals("hf_laboratory")) {
			return healthFacilityRepo.getFacilityByPalikaServicelab( palika,  service,  tab,  col);
		}
		else if(tab.equals("hf_radiology")) {
			return healthFacilityRepo.getFacilityByPalikaServiceradio( palika,  service,  tab,  col);
		}
		else if(tab.equals("hf_surgical")) {
			return healthFacilityRepo.getFacilityByPalikaServicesurgic( palika,  service,  tab,  col);
		}
		else if(tab.equals("hf_specialized")) {
			return healthFacilityRepo.getFacilityByPalikaServiceSpecial( palika,  service,  tab,  col);
		}
		else if(tab.equals("hf_ayurved")) {
			return healthFacilityRepo.getFacilityByPalikaServiceAyurved( palika,  service,  tab,  col);
		}
		
		
		
		else {
			return healthFacilityRepo.getFacilityByPalikaService(palika,service);
		}
	}

	public List<HealthFacility> getAllList(int i, int ps, String string, String search) {
		Pageable pageable =  PageRequest.of(i, ps, Sort.by("id"));
	
			
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFList(search,pageable);
//			return healthFacilityRepo.findAllHFListByProvince(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
	
	}
	
	public List<HealthFacility> getAllListbed(int i, int ps, String string, String search) {
		Pageable pageable =  PageRequest.of(i, ps, Sort.by("id"));
	
			
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListBed(search,pageable);
//			return healthFacilityRepo.findAllHFListByProvince(search, rvalues,uid,pageable);
//			long total = pagedResult.getTotalElements();
//			System.out.println(total +"total here");
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
	
	}
	
	public List<HealthFacility> getAllListOnline(int i, int ps, String string, String search) {
		Pageable pageable =  PageRequest.of(i, ps, Sort.by("id"));
	
			
			Page<HealthFacility> pagedResult = healthFacilityRepo.findAllHFListOnline(search,pageable);
//			return healthFacilityRepo.findAllHFListByProvince(search, rvalues,uid,pageable);
			if (pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
				
				return new ArrayList<HealthFacility>();
			}
	
	}

	public List<HealthFacility> getFacilityByDistrictService(int district, int service, String tab, String col) {
		if(tab.equals("hf_opd")) {
			return healthFacilityRepo.getFacilityByDistrictServiceOpd( district,  service,  tab,  col);
		}
		
		else if(tab.equals("hf_motherhood")) {
			return healthFacilityRepo.getFacilityByDistrictServiceMother( district,  service,  tab,  col);
		}else if(tab.equals("hf_familyplanning")) {
			return healthFacilityRepo.getFacilityByDistrictServicefp( district,  service,  tab,  col);
		}
		else if(tab.equals("hf_laboratory")) {
			return healthFacilityRepo.getFacilityByDistrictServicelab( district,  service,  tab,  col);
		}
		else if(tab.equals("hf_radiology")) {
			return healthFacilityRepo.getFacilityByDistrictServiceradio( district,  service,  tab,  col);
		}
		else if(tab.equals("hf_surgical")) {
			return healthFacilityRepo.getFacilityByDistrictServicesurgic( district,  service,  tab,  col);
		}
		else if(tab.equals("hf_specialized")) {
			return healthFacilityRepo.getFacilityByDistrictServiceSpecial( district,  service,  tab,  col);
		}
		else if(tab.equals("hf_ayurved")) {
			return healthFacilityRepo.getFacilityByDistrictServiceAyurved( district,  service,  tab,  col);
		}
		
		
		
		else {
			return healthFacilityRepo.getFacilityByDistService(district,service);
		}
	}

	public List<HealthFacility> getFacilityByProvinceService(int province, int service, String tab, String col) {
		if(tab.equals("hf_opd")) {
			return healthFacilityRepo.getFacilityByProvinceServiceOpd( province,  service,  tab,  col);
		}
		
		else if(tab.equals("hf_motherhood")) {
			return healthFacilityRepo.getFacilityByProvinceServiceMother( province,  service,  tab,  col);
		}else if(tab.equals("hf_familyplanning")) {
			return healthFacilityRepo.getFacilityByProvinceServicefp( province,  service,  tab,  col);
		}
		else if(tab.equals("hf_laboratory")) {
			return healthFacilityRepo.getFacilityByProvinceServicelab( province,  service,  tab,  col);
		}
		else if(tab.equals("hf_radiology")) {
			return healthFacilityRepo.getFacilityByProvinceServiceradio( province,  service,  tab,  col);
		}
		else if(tab.equals("hf_surgical")) {
			return healthFacilityRepo.getFacilityByProvinceServicesurgic( province,  service,  tab,  col);
		}
		else if(tab.equals("hf_specialized")) {
			return healthFacilityRepo.getFacilityByProvinceServiceSpecial( province,  service,  tab,  col);
		}
		else if(tab.equals("hf_ayurved")) {
			return healthFacilityRepo.getFacilityByProvinceServiceAyurved( province,  service,  tab,  col);
		}
		
		
		
		else {
			return healthFacilityRepo.getFacilityByProvService(province,service);
		}
	}

	public List<HealthFacility> getFacilityByNationalService(int service, String tab, String col) {
		
		if(tab.equals("hf_opd")) {
			return healthFacilityRepo.getFacilityByNationalServiceOpd( service,  tab,  col);
		}
		
		else if(tab.equals("hf_motherhood")) {
			return healthFacilityRepo.getFacilityByNationalServiceMother(  service,  tab,  col);
		}else if(tab.equals("hf_familyplanning")) {
			return healthFacilityRepo.getFacilityByNationalServicefp( service,  tab,  col);
		}
		else if(tab.equals("hf_laboratory")) {
			return healthFacilityRepo.getFacilityByNationalServicelab(  service,  tab,  col);
		}
		else if(tab.equals("hf_radiology")) {
			return healthFacilityRepo.getFacilityByNationalServiceradio(service,  tab,  col);
		}
		else if(tab.equals("hf_surgical")) {
			return healthFacilityRepo.getFacilityByNationalServicesurgic(service,  tab,  col);
		}
		else if(tab.equals("hf_specialized")) {
			return healthFacilityRepo.getFacilityByNationalServiceSpecial(service,  tab,  col);
		}
		else if(tab.equals("hf_ayurved")) {
			return healthFacilityRepo.getFacilityByNationalServiceAyurved(service,  tab,  col);
		}
		
		
		
		else {
			return healthFacilityRepo.getFacilityByService(service);
		}
		
	}

	public ResponseEntity<List<Map<String, Object>>> getHFDetails(int id) {
		String sql="select hf.hf_name,hf.hf_code,hf.validity,hf.approvedate,nepdate(cast(hf.approvedate as date)) as nepapprovedate,nepdate(cast(hf.created_at as date)) as nepcdate,hf.sectioned,m.namenp as palika,hf.ward from hfregistry hf join admin_local_level_structure m on m.vcid=hf.municipality where hf.id=? ";
		List<Tuple> admlvl = db.getResultList(sql, Arrays.asList(id));

		List<Map<String, Object>> list = new ArrayList<>();
		if (!admlvl.isEmpty()) {
			for (Tuple t : admlvl) {
				Map<String, Object> mapadmlvl = new HashMap<>();
				mapadmlvl.put("approvedate", t.get("approvedate"));
				mapadmlvl.put("palika", t.get("palika"));
				mapadmlvl.put("nepapprovedate", t.get("nepapprovedate"));
				mapadmlvl.put("sectioned", t.get("sectioned"));
				mapadmlvl.put("ward", t.get("ward"));
				mapadmlvl.put("hfname", t.get("hf_name"));
				mapadmlvl.put("hfcode", t.get("hf_code"));
				mapadmlvl.put("validity", t.get("validity"));
				mapadmlvl.put("nepcdate", t.get("nepcdate"));
				list.add(mapadmlvl);
			}
			
	}
		return ResponseEntity.ok(list);
	 

	

}

	public String toggleNum(String engNum) {
		
		 String[] nepNum = {"०", "१", "२", "३", "४", "५", "६", "७", "८", "९"};
	        
	        StringBuilder tnum = new StringBuilder();
	        
	        // Split the input string into characters
	        char[] engNums = engNum.toCharArray();
	        
	        // Convert each character
	        for (char c : engNums) {
	            int index = Character.getNumericValue(c);
	            if (index >= 0 && index <= 9) {
	                tnum.append(nepNum[index]);
	            } else {
	                tnum.append(c);
	            }
	        }
	        
	        return tnum.toString();
		// TODO Auto-generated method stub
//		return null;
	}

	public ResponseEntity<List<Map<String, Object>>> getServices(int id) {
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

	
	
	
}
