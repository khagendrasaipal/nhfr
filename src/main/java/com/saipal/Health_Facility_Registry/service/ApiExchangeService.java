package com.saipal.Health_Facility_Registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.saipal.Health_Facility_Registry.entity.ApiExchange;
import com.saipal.Health_Facility_Registry.entity.Familyplanning;
import com.saipal.Health_Facility_Registry.repository.ApiExchangeRepo;
import com.saipal.Health_Facility_Registry.repository.FamilyplanningRepo;

public class ApiExchangeService {

	@Autowired
	ApiExchangeRepo apiExchangerepo;
	
	public void addApiExchang(ApiExchange apiExchange) {
		apiExchangerepo.save(apiExchange);
	}
	
	public List<ApiExchange> getFamilyplanning(){
		return apiExchangerepo.findAll();
	}
	
	public void delete(int id) {
		apiExchangerepo.deleteById(id);
	}
	
	public ApiExchange get(int id) {
		return apiExchangerepo.findById(id).get();
	}
}
