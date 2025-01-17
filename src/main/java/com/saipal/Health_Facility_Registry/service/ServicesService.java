package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saipal.Health_Facility_Registry.entity.Services;
import com.saipal.Health_Facility_Registry.repository.ServicesRepo;

@Service
public class ServicesService {
	@Autowired
	ServicesRepo servicesRepo;
	
	public void addServices(Services services) {
		servicesRepo.save(services);
	}
	
	public List<Services> getServices(String search){
		return servicesRepo.findAllList(search);
	}
	
	public void delete(int id) {
		servicesRepo.deleteById(id);
	}
	
	public Services get(int id) {
		return servicesRepo.findById(id).get();
	}

}
