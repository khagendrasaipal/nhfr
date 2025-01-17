package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.Ownership;
import com.saipal.Health_Facility_Registry.repository.OwnershipRepo;

@Service
public class OwnershipService {
	@Autowired
	OwnershipRepo ownershipRepo;
	
	public void addOwnership(Ownership ownership) {
		ownershipRepo.save(ownership);
	}
	
	public List<Ownership> getOwnership(String search){
		return ownershipRepo.findAllList(search);
	}
	
	public void delete(int id) {
		ownershipRepo.deleteById(id);
	}
	
	public Ownership get(int id) {
		return ownershipRepo.findById(id).get();
	}

	public List<Ownership> findAllByType(int id) {
		return ownershipRepo.findByType(id);
	}
}
