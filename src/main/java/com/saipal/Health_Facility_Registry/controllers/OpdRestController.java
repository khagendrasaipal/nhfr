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

import com.saipal.Health_Facility_Registry.entity.Opd;
import com.saipal.Health_Facility_Registry.service.OpdService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/opd")
public class OpdRestController {

	@Autowired
	OpdService OpdService;
	
	@RequestMapping("/list")
	public List<Opd> getAllOpd(@RequestParam(name="search",required=false) String search){
		return OpdService.getOpd(search);
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addOpd (@RequestBody Opd Opd){
		OpdService.addOpd(Opd);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateOpd (@RequestBody Opd Opd,@PathVariable(name="id") int id){
		Opd.setId(id);
		OpdService.addOpd(Opd);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteOpd (@PathVariable(name="id") int id){
//		OpdService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Opd getOpd(@PathVariable(name="id") int id) {
		return OpdService.get(id);
	}
}
