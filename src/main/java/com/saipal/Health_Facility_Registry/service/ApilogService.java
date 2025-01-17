package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.ApiLog;
import com.saipal.Health_Facility_Registry.repository.ApilogRepo;

@Service
public class ApilogService {

	@Autowired
	ApilogRepo ApilogRepo;
	
	public void addApiLog(ApiLog ApiLog) {
		ApilogRepo.save(ApiLog);
	}
	
	public List<ApiLog> getApiLog(){
		return ApilogRepo.findAll();
	}
	
	public void delete(int id) {
		ApilogRepo.deleteById(id);
	}
	
	public ApiLog get(int id) {
		return ApilogRepo.findById(id).get();
	}
}
