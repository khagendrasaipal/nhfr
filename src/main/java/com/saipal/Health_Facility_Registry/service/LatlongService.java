package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.LatLong;
import com.saipal.Health_Facility_Registry.repository.LatlongRepo;

@Service
public class LatlongService {

	@Autowired
	LatlongRepo latlongRepo;
	public void addLatlong(LatLong LatLong) {
		latlongRepo.save(LatLong);
	}
	
	public List<LatLong> getLatLong(String search){
		return latlongRepo.findAllList(search);
	}
	
	public void delete(int id) {
		latlongRepo.deleteById(id);
	}
	
	public LatLong get(int id) {
		return latlongRepo.findById(id).get();
	}
}
