package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.HealthServices;
import com.saipal.Health_Facility_Registry.entity.Opd;
import com.saipal.Health_Facility_Registry.entity.ServiceSystem;
import com.saipal.Health_Facility_Registry.repository.HealthServiceRepo;
import com.saipal.Health_Facility_Registry.repository.OpdRepo;
import com.saipal.Health_Facility_Registry.repository.ServiceSystemRepo;

@Service
public class HealthServiceService {
	@Autowired
	HealthServiceRepo ssRepo;
	
	public void addOpd(HealthServices ss) {
		ssRepo.save(ss);
	}
	
	public List<HealthServices> getOpd(String search){
		return ssRepo.findAllList(search);
	}
	
	public List<HealthServices> getOpds(String search){
		return ssRepo.findAllLists(search);
	}
	
	public void delete(int id) {
		ssRepo.deleteById(id);
	}
	
	public HealthServices get(int id) {
		return ssRepo.findById(id).get();
	}
}
