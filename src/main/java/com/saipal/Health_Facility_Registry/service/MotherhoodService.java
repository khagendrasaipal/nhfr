package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Motherhood;
import com.saipal.Health_Facility_Registry.repository.MotherhoodRepo;

@Service
public class MotherhoodService {

	@Autowired
	MotherhoodRepo motherhoodRepo;
	
	public void addMotherhood(Motherhood Motherhood) {
		motherhoodRepo.save(Motherhood);
	}
	
	public List<Motherhood> getMotherhood(){
		return motherhoodRepo.findAll();
	}
	
	public void delete(int id) {
		motherhoodRepo.deleteById(id);
	}
	
	public Motherhood get(int id) {
		return motherhoodRepo.findById(id).get();
	}
}
