package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Ayurved;
import com.saipal.Health_Facility_Registry.repository.AyurvedRepo;

@Service
public class AyurvedService {

	@Autowired
	AyurvedRepo ayurvedRepo;
	
	public void addAyurved(Ayurved Ayurved) {
		ayurvedRepo.save(Ayurved);
	}
	
	public List<Ayurved> getAyurved(){
		return ayurvedRepo.findAll();
	}
	
	public void delete(int id) {
		ayurvedRepo.deleteById(id);
	}
	
	public Ayurved get(int id) {
		return ayurvedRepo.findById(id).get();
	}
}
