package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Opd;
import com.saipal.Health_Facility_Registry.entity.ServiceSystem;
import com.saipal.Health_Facility_Registry.repository.OpdRepo;
import com.saipal.Health_Facility_Registry.repository.ServiceSystemRepo;

@Service
public class ServiceSystemService {
	@Autowired
	ServiceSystemRepo ssRepo;
	
	public void addOpd(ServiceSystem ss) {
		ssRepo.save(ss);
	}
	
	public List<ServiceSystem> getOpd(String search){
		return ssRepo.findAllList(search);
	}
	
	public void delete(int id) {
		ssRepo.deleteById(id);
	}
	
	public ServiceSystem get(int id) {
		return ssRepo.findById(id).get();
	}
}
