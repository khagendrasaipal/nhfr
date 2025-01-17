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

import com.saipal.Health_Facility_Registry.entity.Specialized;
import com.saipal.Health_Facility_Registry.service.SpecializedService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/specialized")
public class SpecializedRestController {

	@Autowired
	SpecializedService SpecializedService;
	
	@RequestMapping("/list")
	public List<Specialized> getAllSpecialized(@RequestParam(name="search",required=false) String search){
		return SpecializedService.getSpecialized(search);
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addSpecialized (@RequestBody Specialized Specialized){
		SpecializedService.addSpecialized(Specialized);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateSpecialized (@RequestBody Specialized Specialized,@PathVariable(name="id") int id){
		Specialized.setId(id);
		SpecializedService.addSpecialized(Specialized);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteSpecialized (@PathVariable(name="id") int id){
//		SpecializedService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Specialized getSpecialized(@PathVariable(name="id") int id) {
		return SpecializedService.get(id);
	}
}
