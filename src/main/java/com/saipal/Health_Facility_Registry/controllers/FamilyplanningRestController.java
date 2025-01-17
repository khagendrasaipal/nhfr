package com.saipal.Health_Facility_Registry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saipal.Health_Facility_Registry.entity.Familyplanning;
import com.saipal.Health_Facility_Registry.service.FamilyplanningService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/familyplanning")
public class FamilyplanningRestController {

	@Autowired
	FamilyplanningService familyplanningService;
	
	@RequestMapping("/list")
	public List<Familyplanning> getAllFamilyplanning() {
		return familyplanningService.getFamilyplanning();
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addFamilyplanning (@RequestBody Familyplanning Familyplanning){
		familyplanningService.addFamilyplanning(Familyplanning);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateFamilyplanning (@RequestBody Familyplanning Familyplanning,@PathVariable(name="id") int id){
		Familyplanning.setId(id);
		familyplanningService.addFamilyplanning(Familyplanning);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteFamilyplanning (@PathVariable(name="id") int id){
//		familyplanningService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Familyplanning getFamilyplanning(@PathVariable(name="id") int id) {
		return familyplanningService.get(id);
	}
}
