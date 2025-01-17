package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Surgical;
import com.saipal.Health_Facility_Registry.repository.SurgicalRepo;

@Service
public class SurgicalService {

	@Autowired
	SurgicalRepo SurgicalRepo;
	
	public void addSurgical(Surgical Surgical) {
		SurgicalRepo.save(Surgical);
	}
	
	public List<Surgical> getSurgical(String search){
		return SurgicalRepo.findAllList(search);
	}
	
	public void delete(int id) {
		SurgicalRepo.deleteById(id);
	}
	
	public Surgical get(int id) {
		return SurgicalRepo.findById(id).get();
	}
}
