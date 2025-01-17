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

import com.saipal.Health_Facility_Registry.entity.Radiology;
import com.saipal.Health_Facility_Registry.service.RadiologyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/radiology")
public class RadiologyRestController {

	@Autowired
	RadiologyService RadiologyService;
	
	@RequestMapping("/list")
	public List<Radiology> getAllRadiology(@RequestParam(name="search",required=false) String search){
		return RadiologyService.getRadiology(search);
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addRadiology (@RequestBody Radiology Radiology){
		RadiologyService.addRadiology(Radiology);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateRadiology (@RequestBody Radiology Radiology,@PathVariable(name="id") int id){
		Radiology.setId(id);
		RadiologyService.addRadiology(Radiology);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteRadiology (@PathVariable(name="id") int id){
//		RadiologyService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Radiology getRadiology(@PathVariable(name="id") int id) {
		return RadiologyService.get(id);
	}
}
