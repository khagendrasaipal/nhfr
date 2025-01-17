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

import com.saipal.Health_Facility_Registry.entity.ServiceSystem;
import com.saipal.Health_Facility_Registry.service.ServiceSystemService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/servicesystem")
public class serviceSystemRestController {

	@Autowired
	ServiceSystemService objService;
	
	@RequestMapping("/list")
	public List<ServiceSystem> getAllOpd(@RequestParam(name="search",required=false) String search){
		return objService.getOpd(search);
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addOpd (@RequestBody ServiceSystem Opd){
		objService.addOpd(Opd);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateOpd (@RequestBody ServiceSystem Opd,@PathVariable(name="id") int id){
		Opd.setId(id);
		objService.addOpd(Opd);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteOpd (@PathVariable(name="id") int id){
//		objService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ServiceSystem getOpd(@PathVariable(name="id") int id) {
		return objService.get(id);
	}
}
