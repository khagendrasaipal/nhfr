package com.saipal.Health_Facility_Registry.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saipal.Health_Facility_Registry.entity.District;
import com.saipal.Health_Facility_Registry.entity.Municipality;
import com.saipal.Health_Facility_Registry.entity.Province;
import com.saipal.Health_Facility_Registry.entity.ServiceType;
import com.saipal.Health_Facility_Registry.repository.DistrictRepo;
import com.saipal.Health_Facility_Registry.repository.MunicipalityRepo;
import com.saipal.Health_Facility_Registry.repository.ProvinceRepo;
import com.saipal.Health_Facility_Registry.service.ServiceTypeService;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/service-type")
public class ServiceTypeRestController {

	@Autowired
	ServiceTypeService serviceTypeService;
	@Autowired
	DistrictRepo districtRepo;
	@Autowired
	ProvinceRepo provinceRepo;
	@Autowired
	MunicipalityRepo municipalityRepo;
	
	
	
	@RequestMapping("/list")
	public List<ServiceType> getAllServiceType(){
		return serviceTypeService.getServiceType();
	}
	
	@RequestMapping("/getProvince")
	public List<Province> getProvinceList() {
		return provinceRepo.findAll();
	}
	@RequestMapping("/getDistrict")
	public List<District> getDistrictList() {
		return districtRepo.findAll();
	}
	
	@RequestMapping("/getMunicipality")
	public List<Municipality> getMunicipalityList() {
		return municipalityRepo.findAll();
	}
	
	@RequestMapping("/getDistrict/{id}")
	public List<District> getDistList(@PathVariable(name="id") int id) {
		return districtRepo.findAllByProvince(id);
	}
	
	@RequestMapping("/getMunicipality/{id}")
	public List<Municipality> getMuncList(@PathVariable(name="id") int id) {
		return municipalityRepo.findAllByDistrict(id);
	}
	

	@RequestMapping("/getWard/{id}")
	public List<Municipality> getWard(@PathVariable(name="id") String id) {
		return municipalityRepo.findOne(id);
	}
}
