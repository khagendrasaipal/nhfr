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

import com.saipal.Health_Facility_Registry.entity.Bipanna;
import com.saipal.Health_Facility_Registry.service.BipannaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/bipanna")
public class BipannaRestController {

	@Autowired
	BipannaService BipannaService;
	
	@RequestMapping("/list")
	public List<Bipanna> getAllBipanna(@RequestParam(name="search",required=false) String search) {
		return BipannaService.getBipanna(search);
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addBipanna (@RequestBody Bipanna Bipanna){
		BipannaService.addBipanna(Bipanna);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateBipanna (@RequestBody Bipanna Bipanna,@PathVariable(name="id") int id){
		Bipanna.setId(id);
		BipannaService.addBipanna(Bipanna);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteBipanna (@PathVariable(name="id") int id){
//		BipannaService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Bipanna getBipanna(@PathVariable(name="id") int id) {
		return BipannaService.get(id);
	}
	
}
