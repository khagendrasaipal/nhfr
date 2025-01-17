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

import com.saipal.Health_Facility_Registry.service.OwnershipService;
import com.saipal.Health_Facility_Registry.entity.Ownership;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ownership")
public class OwnershipRestController {

	@Autowired
	OwnershipService ownershipService;
	
	@RequestMapping("/list")
	public List<Ownership> getAllOwnership(@RequestParam(name="search",required=false) String search){
		return ownershipService.getOwnership(search);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public @ResponseBody String addOwnership(@RequestBody Ownership ownership) {
		ownershipService.addOwnership(ownership);
		return "Saved Sucessfully";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public @ResponseBody String updateOwnership(@RequestBody Ownership ownership,@PathVariable(name="id") int id) {
		ownership.setId(id);
		ownershipService.addOwnership(ownership);
		return "Saved Sucessfully";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String deleteOwnership(@PathVariable(name="id") int id) {
//		ownershipService.delete(id);
		return "Deleted Successfully";
	}
	
	@RequestMapping("/edit/{id}")
	public Ownership getOwnership(@PathVariable(name="id") int id) {
		return ownershipService.get(id);
	}
	
	@RequestMapping("/getOwnership/{id}")
	public List<Ownership> getMuncList(@PathVariable(name="id") int id) {
		return ownershipService.findAllByType(id);
	}
}
