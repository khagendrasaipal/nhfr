package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.HealthFacilityLevel;
import com.saipal.Health_Facility_Registry.repository.HealthFacilityLevelRepo;

@Service
public class HealthFacilityLevelService {
	@Autowired
	HealthFacilityLevelRepo healthFacilityLevelRepo;
	
	public void addFacilityLevel(HealthFacilityLevel healthFacilityLevel) {
		healthFacilityLevelRepo.save(healthFacilityLevel);
		
	}
	
	public List<HealthFacilityLevel> getFacilityLevel(String search) {
		return healthFacilityLevelRepo.findAllList(search);
		 
	}
	
	public List<HealthFacilityLevel> getFacilityLevels(String search) {
		return healthFacilityLevelRepo.findAllLists(search);
		 
	}
	
	public void delete(int id) {
		healthFacilityLevelRepo.deleteById(id);
	}
	
	public HealthFacilityLevel get(int id) {
		return healthFacilityLevelRepo.findById(id).get();
	}

	public List<HealthFacilityLevel> findAllByType(int id) {
		return healthFacilityLevelRepo.findByType(id);
	}
}
