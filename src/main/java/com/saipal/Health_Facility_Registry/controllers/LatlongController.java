package com.saipal.Health_Facility_Registry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.saipal.Health_Facility_Registry.entity.LatLong;
import com.saipal.Health_Facility_Registry.service.LatlongService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/latlong")
public class LatlongController {

	@Autowired
	LatlongService latlongService;
	
	@RequestMapping("/list")
	public List<LatLong> getAllLatlong(@RequestParam(name="search",required=false) String search){
		return latlongService.getLatLong(search);
	}
}
