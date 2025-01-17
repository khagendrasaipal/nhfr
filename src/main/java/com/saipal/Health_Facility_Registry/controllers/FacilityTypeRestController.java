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

import com.saipal.Health_Facility_Registry.entity.HealthFacilityType;
import com.saipal.Health_Facility_Registry.service.HealthFacilityTypeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/facility-type")
public class FacilityTypeRestController {

	@Autowired
	HealthFacilityTypeService healthFacilityTypeService;
	
	
	@RequestMapping("/list")
	public List<HealthFacilityType> getAllFacilityType(@RequestParam(name="search",required=false) String search){
		return healthFacilityTypeService.getFacilityType(search);
	}
//	@RequestMapping(value = "/facilitytypeCreate",method = RequestMethod.POST)
//	public String addFacilityType(HealthFacilityType healthFacilityType){
//		healthFacilityTypeService.addFacilityType(healthFacilityType);
//		return "saved successfull";
//	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addFacilityType (@RequestBody HealthFacilityType healthFacilityType){
		healthFacilityTypeService.addFacilityType(healthFacilityType);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateFacilityType (@RequestBody HealthFacilityType healthFacilityType, @PathVariable(name="id") int id){
		healthFacilityType.setId(id);
		healthFacilityTypeService.addFacilityType(healthFacilityType);
		return "saved successfull";
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public String deleteFtype(@PathVariable(name="id") int id) {
//		healthFacilityTypeService.delete(id);
		return "Deleted Successfully";
	}
	
	@RequestMapping("/edit/{id}")
	public  HealthFacilityType getFacilityType(@PathVariable(name="id") int id) {
		return healthFacilityTypeService.get(id);
		
	}
	
}
