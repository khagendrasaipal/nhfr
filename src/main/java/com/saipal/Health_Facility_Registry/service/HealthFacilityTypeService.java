package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.HealthFacilityType;
import com.saipal.Health_Facility_Registry.repository.HealthFacilityTypeRepo;

@Service
public class HealthFacilityTypeService {

	@Autowired
	HealthFacilityTypeRepo healthFacilityTypeRepo;
	
	public void addFacilityType(HealthFacilityType healthFacilityType) {
		healthFacilityTypeRepo.save(healthFacilityType);
		
	}
	
	public List<HealthFacilityType> getFacilityType() {
		return healthFacilityTypeRepo.findAll();
		 
	}
	
	public List<HealthFacilityType> getFacilityType(String search) {
		return healthFacilityTypeRepo.findAllList(search);
		 
	}
	
	public void delete(int id) {
		healthFacilityTypeRepo.deleteById(id);
	}
	
	public HealthFacilityType get(int id) {
		return healthFacilityTypeRepo.findById(id).get();
	}
	
}
