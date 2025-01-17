package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.ServiceType;
import com.saipal.Health_Facility_Registry.repository.ProvinceRepo;
import com.saipal.Health_Facility_Registry.repository.ServiceTypeRepo;

@Service
public class ServiceTypeService {

	@Autowired
	ServiceTypeRepo serviceTypeRepo;
	@Autowired
	ProvinceRepo provinceRepo;
	
	public void addServiceType(ServiceType serviceType) {
		serviceTypeRepo.save(serviceType);
	}
	
	public List<ServiceType> getServiceType(){
		return serviceTypeRepo.findAll();
	}
	
	public void delete(int id) {
		serviceTypeRepo.deleteById(id);
	}
	
	public ServiceType get(int id) {
		return serviceTypeRepo.findById(id).get();
	}



	
	
}
