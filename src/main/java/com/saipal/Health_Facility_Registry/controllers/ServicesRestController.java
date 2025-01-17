package com.saipal.Health_Facility_Registry.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saipal.Health_Facility_Registry.entity.HfAyurvedService;
import com.saipal.Health_Facility_Registry.entity.HfBipannaService;
import com.saipal.Health_Facility_Registry.entity.HfFamilyPlanningService;
import com.saipal.Health_Facility_Registry.entity.HfLaboratoryService;
import com.saipal.Health_Facility_Registry.entity.HfMotherhoodService;
import com.saipal.Health_Facility_Registry.entity.HfOpdService;
import com.saipal.Health_Facility_Registry.entity.HfRadiologyService;
import com.saipal.Health_Facility_Registry.entity.HfServices;
import com.saipal.Health_Facility_Registry.entity.HfSpecializedService;
import com.saipal.Health_Facility_Registry.entity.HfSurgicalService;
import com.saipal.Health_Facility_Registry.entity.NewHfServices;
import com.saipal.Health_Facility_Registry.entity.Services;
import com.saipal.Health_Facility_Registry.repository.HfAyurvedRepo;
import com.saipal.Health_Facility_Registry.repository.HfBipannaRepo;
import com.saipal.Health_Facility_Registry.repository.HfFamilyPlanningRepo;
import com.saipal.Health_Facility_Registry.repository.HfLaboratoryRepo;
import com.saipal.Health_Facility_Registry.repository.HfMotherhoodRepo;
import com.saipal.Health_Facility_Registry.repository.HfOpdRepo;
import com.saipal.Health_Facility_Registry.repository.HfRadiologyRepo;
import com.saipal.Health_Facility_Registry.repository.HfServicesRepo;
import com.saipal.Health_Facility_Registry.repository.HfSpecializedRepo;
import com.saipal.Health_Facility_Registry.repository.HfSurgicalRepo;
import com.saipal.Health_Facility_Registry.repository.NewHfServicesRepo;
import com.saipal.Health_Facility_Registry.repository.NewServicesRepo;
import com.saipal.Health_Facility_Registry.service.ServicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/services")
public class ServicesRestController {

	private static final Logger LOG = LoggerFactory.getLogger(ServicesRestController.class);
	@Autowired
	ServicesService servicesService;
	@Autowired
	HfServicesRepo hfServicesRepo;
	
	@Autowired
	NewHfServicesRepo newServicesRepo;
	
	@Autowired
	HfOpdRepo hfOpdRepo;
	@Autowired
	HfLaboratoryRepo hfLabRepo;
	@Autowired
	HfRadiologyRepo hfRadioRepo;
	@Autowired
	HfSpecializedRepo hfSpecializedRepo;
	@Autowired
	HfSurgicalRepo hfSurgicalRepo;
	@Autowired
	HfAyurvedRepo hfAyurvedRepo;
	@Autowired
	HfFamilyPlanningRepo hfFamilyRepo;
	@Autowired
	HfMotherhoodRepo hfMotherhoodRepo;
	@Autowired
	HfBipannaRepo hfBipannaRepo;
	
	@RequestMapping("/list")
	public List<Services> getAllServices(@RequestParam(name="search",required=false) String search){
		return servicesService.getServices(search);
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public  @ResponseBody  String addServices (@RequestBody Services services){
		servicesService.addServices(services);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public  @ResponseBody  String updateServices (@RequestBody Services services,@PathVariable(name="id") int id){
		services.setId(id);
		servicesService.addServices(services);
		return "saved successfull";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public  @ResponseBody  String deleteServices (@PathVariable(name="id") int id){
//		servicesService.delete(id);	
		return "Deleted successfully";
	}
	
	
	@RequestMapping("/edit/{id}")
	public Services getServices(@PathVariable(name="id") int id) {
		return servicesService.get(id);
	}
	
	@RequestMapping("/getService/{id}")
	public List<HfServices> getServiceList(@PathVariable(name="id") int id) {
//		hfServicesRepo.findAllByHfid(id).forEach(l->{
//			LOG.info(l.toString());
//		});
//		System.out.println("here i am");
		
//		System.out.println(hfServicesRepo.findAllByHfid(id));
		return hfServicesRepo.findAllByHfid(id);
	}
	
	@RequestMapping("/getNewService/{id}")
	public List<NewHfServices> getNewService(@PathVariable(name="id") int id) {
		return newServicesRepo.findAllByHfid(id);
	}
	
	@RequestMapping("/gethfService/{id}")
	public List<Map<String, Object>> gethfService(@PathVariable(name="id") int id) {
		System.out.println("here i am ");
		return newServicesRepo.findAllhfserviceHfid(id);
	}
	
//	@RequestMapping("/getNewService/{id}")
//	public List<NewHfServices> getNewService(@PathVariable(name="id") int id) {
//		System.out.println("here"+id);
////		newServicesRepo.findAllNewServiceByHfids(id).forEach(l->{
////			LOG.info(l.toString());
////		});
////		System.out.println("here i am");
//		return newServicesRepo.findAllByHfid(id);
//	}
	
	@RequestMapping("/getServiceSearch/{id}")
	public List<HfServices> getServiceListSearch(@PathVariable(name="id") int id) {
		hfServicesRepo.findAllByHfid(id).forEach(l->{
//			LOG.info(l.get(""));
		});
//		LOG.info("helllo yahah xu ");
//		System.out.println(hfServicesRepo.findAllByHfidSearch(id).get(0));
		return hfServicesRepo.findAllByHfidSearch(id);
	}
	
	@RequestMapping("/getOpdService/{id}")
	public List<HfOpdService> getOpdServiceList(@PathVariable(name="id") int id) {
		return hfOpdRepo.findAllByHfid(id);
	}
	
	@RequestMapping("/getLabService/{id}")
	public List<HfLaboratoryService> getLabServiceList(@PathVariable(name="id") int id) {
		return hfLabRepo.findAllByHfid(id);
	}
	@RequestMapping("/getRadioService/{id}")
	public List<HfRadiologyService> getRadioServiceList(@PathVariable(name="id") int id) {
		return hfRadioRepo.findAllByHfid(id);
	}
	@RequestMapping("/getSpecializedService/{id}")
	public List<HfSpecializedService> getSpclServiceList(@PathVariable(name="id") int id) {
		return hfSpecializedRepo.findAllByHfid(id);
	}
	
	@RequestMapping("/getSurgicalService/{id}")
	public List<HfSurgicalService> getSurgicalServiceList(@PathVariable(name="id") int id) {
		return hfSurgicalRepo.findAllByHfid(id);
	}
	
	@RequestMapping("/getAyurvedService/{id}")
	public List<HfAyurvedService> getAyurvedServiceList(@PathVariable(name="id") int id) {
		return hfAyurvedRepo.findAllByHfid(id);
	}
	@RequestMapping("/getMotherService/{id}")
	public List<HfMotherhoodService> getMotherhoodServiceList(@PathVariable(name="id") int id) {
		return hfMotherhoodRepo.findAllByHfid(id);
	}
	
	@RequestMapping("/getFamilyService/{id}")
	public List<HfFamilyPlanningService> getFamilyServiceList(@PathVariable(name="id") int id) {
		return hfFamilyRepo.findAllByHfid(id);
	}
	
	@RequestMapping("/getBipannaService/{id}")
	public List<HfBipannaService> getBipannaServiceList(@PathVariable(name="id") int id) {
		return hfBipannaRepo.findAllByHfid(id);
	}
}
