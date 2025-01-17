package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Familyplanning;
import com.saipal.Health_Facility_Registry.repository.FamilyplanningRepo;

@Service
public class FamilyplanningService {

	@Autowired
	FamilyplanningRepo familyplanningRepo;
	
	public void addFamilyplanning(Familyplanning Familyplanning) {
		familyplanningRepo.save(Familyplanning);
	}
	
	public List<Familyplanning> getFamilyplanning(){
		return familyplanningRepo.findAll();
	}
	
	public void delete(int id) {
		familyplanningRepo.deleteById(id);
	}
	
	public Familyplanning get(int id) {
		return familyplanningRepo.findById(id).get();
	}
}
