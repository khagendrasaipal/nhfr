package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Opd;
import com.saipal.Health_Facility_Registry.repository.OpdRepo;

@Service
public class OpdService {
	@Autowired
	OpdRepo OpdRepo;
	
	public void addOpd(Opd Opd) {
		OpdRepo.save(Opd);
	}
	
	public List<Opd> getOpd(String search){
		return OpdRepo.findAllList(search);
	}
	
	public void delete(int id) {
		OpdRepo.deleteById(id);
	}
	
	public Opd get(int id) {
		return OpdRepo.findById(id).get();
	}
}
