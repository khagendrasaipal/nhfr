package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.NewServices;
import com.saipal.Health_Facility_Registry.entity.Services;
import com.saipal.Health_Facility_Registry.repository.NewServicesRepo;
import com.saipal.Health_Facility_Registry.repository.ServicesRepo;

@Service
public class NewServicesService {
	@Autowired
	NewServicesRepo servicesRepo;
	
	public void addServices(NewServices services) {
		servicesRepo.save(services);
	}
	
	public List<NewServices> getServices(String search){
		return servicesRepo.findAllList(search);
	}
	
	public List<NewServices> getServicesAll(String search){
		return servicesRepo.findAllListservice();
	}
	
	public void delete(int id) {
		servicesRepo.deleteById(id);
	}
	
	public NewServices get(int id) {
		return servicesRepo.findById(id).get();
	}

}
