package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Specialized;
import com.saipal.Health_Facility_Registry.repository.SpecializedRepo;

@Service
public class SpecializedService {

	@Autowired
	SpecializedRepo SpecializedRepo;
	
	public void addSpecialized(Specialized Specialized) {
		SpecializedRepo.save(Specialized);
	}
	
	public List<Specialized> getSpecialized(String search){
		return SpecializedRepo.findAllList(search);
	}
	
	public void delete(int id) {
		SpecializedRepo.deleteById(id);
	}
	
	public Specialized get(int id) {
		return SpecializedRepo.findById(id).get();
	}
}
