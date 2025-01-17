package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Bipanna;
import com.saipal.Health_Facility_Registry.repository.BipannaRepo;

@Service
public class BipannaService {

	@Autowired
	BipannaRepo BipannaRepo;
	
	public void addBipanna(Bipanna Bipanna) {
		BipannaRepo.save(Bipanna);
	}
	
	public List<Bipanna> getBipanna(String search){
		return BipannaRepo.findAllList(search);
	}
	
	public void delete(int id) {
		BipannaRepo.deleteById(id);
	}
	
	public Bipanna get(int id) {
		return BipannaRepo.findById(id).get();
	}
}
