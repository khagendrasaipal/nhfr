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

import com.saipal.Health_Facility_Registry.entity.Surgical;
import com.saipal.Health_Facility_Registry.service.SurgicalService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/surgical")
public class SurgicalRestController {

	@Autowired
	SurgicalService SurgicalService;
	
	@RequestMapping("/list")
	public List<Surgical> getAllSurgical(@RequestParam(name="search",required=false) String search){
		return SurgicalService.getSurgical(search);
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addSurgical (@RequestBody Surgical Surgical){
		SurgicalService.addSurgical(Surgical);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateSurgical (@RequestBody Surgical Surgical,@PathVariable(name="id") int id){
		Surgical.setId(id);
		SurgicalService.addSurgical(Surgical);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteSurgical (@PathVariable(name="id") int id){
//		SurgicalService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Surgical getSurgical(@PathVariable(name="id") int id) {
		return SurgicalService.get(id);
	}
}
