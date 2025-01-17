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

import com.saipal.Health_Facility_Registry.entity.Laboratory;

import com.saipal.Health_Facility_Registry.service.LaboratoryService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/laboratory")
public class LaboratoryRestController {

	@Autowired
	LaboratoryService LaboratoryService;
	
	@RequestMapping("/list")
	public List<Laboratory> getAllLaboratory(@RequestParam(name="search",required=false) String search){
		return LaboratoryService.getLaboratory(search);
	}
	
	
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addLaboratory (@RequestBody Laboratory Laboratory){
		LaboratoryService.addLaboratory(Laboratory);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateLaboratory (@RequestBody Laboratory Laboratory,@PathVariable(name="id") int id){
		Laboratory.setId(id);
		LaboratoryService.addLaboratory(Laboratory);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteLaboratory (@PathVariable(name="id") int id){
//		LaboratoryService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Laboratory getLaboratory(@PathVariable(name="id") int id) {
		return LaboratoryService.get(id);
	}
}
