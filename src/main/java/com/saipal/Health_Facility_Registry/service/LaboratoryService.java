package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Laboratory;
import com.saipal.Health_Facility_Registry.repository.LaboratoryRepo;

@Service
public class LaboratoryService {

	@Autowired
	LaboratoryRepo LaboratoryRepo;
	
	public void addLaboratory(Laboratory Laboratory) {
		LaboratoryRepo.save(Laboratory);
	}
	
	public List<Laboratory> getLaboratory(String search){
		return LaboratoryRepo.findAllList(search);
	}
	
	public void delete(int id) {
		LaboratoryRepo.deleteById(id);
	}
	
	public Laboratory get(int id) {
		return LaboratoryRepo.findById(id).get();
	}
}
