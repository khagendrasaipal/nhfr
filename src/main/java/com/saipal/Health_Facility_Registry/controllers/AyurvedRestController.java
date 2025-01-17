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

import com.saipal.Health_Facility_Registry.entity.Ayurved;
import com.saipal.Health_Facility_Registry.service.AyurvedService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ayurved")
public class AyurvedRestController {

	@Autowired
	AyurvedService ayurvedService;
	
	@RequestMapping("/list")
	public List<Ayurved> getAllAyurved() {
		return ayurvedService.getAyurved();
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addAyurved (@RequestBody Ayurved Ayurved){
		ayurvedService.addAyurved(Ayurved);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateAyurved (@RequestBody Ayurved Ayurved,@PathVariable(name="id") int id){
		Ayurved.setId(id);
		ayurvedService.addAyurved(Ayurved);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteAyurved (@PathVariable(name="id") int id){
		ayurvedService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Ayurved getAyurved(@PathVariable(name="id") int id) {
		return ayurvedService.get(id);
	}
	
}
