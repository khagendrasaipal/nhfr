package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Radiology;
import com.saipal.Health_Facility_Registry.repository.RadiologyRepo;

@Service
public class RadiologyService {

	@Autowired
	RadiologyRepo RadiologyRepo;
	
	public void addRadiology(Radiology Radiology) {
		RadiologyRepo.save(Radiology);
	}
	
	public List<Radiology> getRadiology(String search){
		return RadiologyRepo.findAllList(search);
	}
	
	public void delete(int id) {
		RadiologyRepo.deleteById(id);
	}
	
	public Radiology get(int id) {
		return RadiologyRepo.findById(id).get();
	}
}
