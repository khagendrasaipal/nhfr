package com.saipal.Health_Facility_Registry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saipal.Health_Facility_Registry.entity.HealthFacilityLevel;
import com.saipal.Health_Facility_Registry.service.HealthFacilityLevelService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/facility-level")
public class FacilityLevelRestController {
	@Autowired
	HealthFacilityLevelService healthFacilityLevelService;
	
	@RequestMapping("/list")
	public List<HealthFacilityLevel> getAllFacilityLevel(@RequestParam(name="search", required = false) String search,@RequestParam(name="entry", required = false) String entry){
		 if ("1".equals(entry)) {
			 return healthFacilityLevelService.getFacilityLevels(search);
		 }else {
			 return healthFacilityLevelService.getFacilityLevel(search);
		 }
		
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addFacilityLevel (@RequestBody HealthFacilityLevel healthFacilityLevel){
		healthFacilityLevelService.addFacilityLevel(healthFacilityLevel);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateFacilityLevel (@RequestBody HealthFacilityLevel healthFacilityLevel, @PathVariable(name="id") int id){
		healthFacilityLevel.setId(id);
		healthFacilityLevelService.addFacilityLevel(healthFacilityLevel);
		return "saved successfull";
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public String deleteLtype(@PathVariable(name="id") int id) {
//		healthFacilityLevelService.delete(id);
		return "Deleted Successfully";
	}
	
	@RequestMapping("/edit/{id}")
	public  HealthFacilityLevel getFacilityLevel(@PathVariable(name="id") int id) {
		return healthFacilityLevelService.get(id);
		
	}
	
	@RequestMapping("/getLevels/{id}")
	public List<HealthFacilityLevel> getLevelList(@PathVariable(name="id") int id) {
		return healthFacilityLevelService.findAllByType(id);
	}
	
	
}
