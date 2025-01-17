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

import com.saipal.Health_Facility_Registry.entity.Motherhood;
import com.saipal.Health_Facility_Registry.service.MotherhoodService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/motherhood")
public class MotherhoodRestController {

	@Autowired
	MotherhoodService motherhoodService;
	
	@RequestMapping("/list")
	public List<Motherhood> getAllMotherhood() {
		return motherhoodService.getMotherhood();
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addMotherhood (@RequestBody Motherhood Motherhood){
		motherhoodService.addMotherhood(Motherhood);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateMotherhood (@RequestBody Motherhood Motherhood,@PathVariable(name="id") int id){
		Motherhood.setId(id);
		motherhoodService.addMotherhood(Motherhood);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteMotherhood (@PathVariable(name="id") int id){
//		motherhoodService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Motherhood getMotherhood(@PathVariable(name="id") int id) {
		return motherhoodService.get(id);
	}
}
