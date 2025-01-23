package com.saipal.Health_Facility_Registry.apiControl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.saipal.Health_Facility_Registry.entity.ApiLog;
import com.saipal.Health_Facility_Registry.entity.HealthFacility;
import com.saipal.Health_Facility_Registry.repository.HealthFacilityRepo;
import com.saipal.Health_Facility_Registry.service.ApilogService;
import com.saipal.Health_Facility_Registry.util.DB;
import com.saipal.Health_Facility_Registry.util.Messenger;

@Service
public class ApiService {

	@Autowired
	private HealthFacilityRepo healthFacilityRepo;

	@Autowired
	DB db;

	public List<Map<String, Object>> getAllPagination(Integer pageNo, Integer pagesize, String sortby, String token) {

		List<Map<String, Object>> messages = new ArrayList<Map<String, Object>>();
		Map<String, Object> message = new HashMap<String, Object>();

		if (pagesize >= 100) {
			pagesize = 100;
		}
		if ("".equals(sortby)) {
			sortby = "id";
		}

		String tuser = healthFacilityRepo.findApiuser(token);
		Integer aid = healthFacilityRepo.findApiUserid(token);
		System.out.println("find user : " + tuser);
		if ("1".equals(tuser)) {
			ApiLog a = new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch"); 
			a.setUrl("api/v1/getHf");
//			apilogservice.addApiLog(a);

			Pageable pageable = PageRequest.of(pageNo, pagesize, Sort.by(sortby));
			// System.out.println(healthFacilityRepo.getAllInPagination(pageable));
			Page<Object[]> pagedResult = healthFacilityRepo.findallFacilities(pageable);

			if (pagedResult.hasContent()) {
				List<Object[]> content = pagedResult.getContent();
				List<Map<String, Object>> formattedList = new ArrayList<>();

				String[] fieldNames = { "name", "href", "uuid", "active", "created_at", "updated_at", "latitude",
						"longitude", "iid", "agency", "hfCode", "type", "hftype_id", "hftype_code", "hftype_name",
						"authlevel", "ftype", "opstatus", "internet", "ren_date", "sectioned", "functional",
						"icu_sectioned", "icu_functional", "ventilator_sectioned", "ventilator_functional",
						"province_id", "province_name", "district_id", "district_name", "municipality_id",
						"municipality_name", "ward", "estd_date", "validity", "email", "telephone", "oxygen",
						"ambulance", "concentrator", "cylinder", "ehs", "geriatrics", "insurance", "ocmc", "pharmacy",
						"plant_capacity", "ssu", "contact_person", "contact_person_mobile", "ambulance_category",
						"ambulance_contact", "hdu_functional", "hdu_sectioned", "nicu_functional", "nicu_sectioned",
						"org_source", "building_cost", "device_cost", "est_income", "loan_org", "other_source",
						"property_source", "workforce_cost", "approvedate", "approveby", "ftype_id", "ftype_code",
						"ftype_name", "ftype_status", "ownership", "ownership_id", "ownership_name", "ownership_code",
						"ownership_status", "level", "facility_level_id", "facility_level_code", "facility_level_name",
						"facility_level_status", "facility_level_parent", "facility_level_types", "oldlevel",
						"building_maps", "hf_details", "iee_certs", "mem_citizenships", "org_articles", "org_perms",
						"reg_orgs", "service_fees", "tax_clears", "vat_pans", "hcode", "rtype" };

				// Map each record to a key-value pair structure
				for (Object[] record : content) {
					Map<String, Object> map = new LinkedHashMap<>();

					for (int i = 0; i < fieldNames.length; i++) {

						if ("name".equals(fieldNames[i]) || "href".equals(fieldNames[i]) || "uuid".equals(fieldNames[i])
								|| "active".equals(fieldNames[i]) || "created_at".equals(fieldNames[i])
								|| "updated_at".equals(fieldNames[i])) {
							map.put(fieldNames[i], record[i]);
						} else if ("latitude".equals(fieldNames[i]) || "longitude".equals(fieldNames[i])) {
							// Handle coordinates
							map.computeIfAbsent("coordinates", k -> new LinkedHashMap<String, String>());
							Map<String, String> coordinates = (Map<String, String>) map.get("coordinates");
							coordinates.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						} else if ("agency".equals(fieldNames[i]) || "iid".equals(fieldNames[i])) {
							// Handle identifiers
							map.computeIfAbsent("identifiers", k -> new LinkedHashMap<String, String>());
							Map<String, String> identifiers = (Map<String, String>) map.get("identifiers");
							identifiers.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						} else {
							map.computeIfAbsent("properties", k -> new LinkedHashMap<String, String>());
							Map<String, Object> properties = (Map<String, Object>) map.get("properties");

							if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])) {
								properties.put(fieldNames[i], record[i]);
							}

							else if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])
									|| "hftype_id".equals(fieldNames[i]) || "hftype_code".equals(fieldNames[i])
									|| "hftype_name".equals(fieldNames[i])) {
//			                       // Handle identifiers
								map.computeIfAbsent("Health_facility_Type", k -> new LinkedHashMap<String, String>());
								Map<String, String> hft = (Map<String, String>) map.get("Health_facility_Type");
								hft.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("Health_facility_Type", hft);
							} else if ("facility_level_id".equals(fieldNames[i])
									|| "facility_level_code".equals(fieldNames[i])
									|| "facility_level_name".equals(fieldNames[i])
									|| "facility_level_status".equals(fieldNames[i])
									|| "facility_level_parent".equals(fieldNames[i])
									|| "facility_level_types".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("health_facility_level", k -> new LinkedHashMap<String, String>());
								Map<String, String> hfl = (Map<String, String>) map.get("health_facility_level");
								hfl.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("health_facility_level", hfl);
							} else if ("ownership_id".equals(fieldNames[i]) || "ownership_name".equals(fieldNames[i])
									|| "ownership_code".equals(fieldNames[i])
									|| "ownership_status".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("ownerships", k -> new LinkedHashMap<String, String>());
								Map<String, String> ownerships = (Map<String, String>) map.get("ownerships");
								ownerships.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("ownerships", ownerships);
							} else if ("ftype_id".equals(fieldNames[i]) || "ftype_code".equals(fieldNames[i])
									|| "ftype_name".equals(fieldNames[i]) || "ftype_status".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("service_type", k -> new LinkedHashMap<String, String>());
								Map<String, String> service_type = (Map<String, String>) map.get("service_type");
								service_type.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("service_type", service_type);
							}

							else if ("province_id".equals(fieldNames[i]) || "province_name".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("province", k -> new LinkedHashMap<String, String>());
								Map<String, String> province = (Map<String, String>) map.get("province");
								province.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("province", province);
							} else if ("district_id".equals(fieldNames[i]) || "district_name".equals(fieldNames[i])) {
								// Handle district
								map.computeIfAbsent("district", k -> new LinkedHashMap<String, String>());
								Map<String, String> district = (Map<String, String>) map.get("district");
								district.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("district", district);

							} else if ("municipality_id".equals(fieldNames[i])
									|| "municipality_name".equals(fieldNames[i])) {
								// Handle municipality
								map.computeIfAbsent("municipality", k -> new LinkedHashMap<String, String>());
								Map<String, String> municipality = (Map<String, String>) map.get("municipality");
								municipality.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("municipality", municipality);

							} else {
								properties.put(fieldNames[i], record[i]);
//			                	   map.put(fieldNames[i], record[i]);
							}
						}
					}
					map.remove("Health_facility_Type");
					map.remove("health_facility_level");
					map.remove("ownerships");
					map.remove("service_type");
					map.remove("district");
					map.remove("province");
					map.remove("municipality");
					formattedList.add(map);

				}
				message.put("status", 200);
				message.put("message", "OK ");
				messages.add(message);
				return formattedList;
			} else {
				message.put("status", 404);
				message.put("message", "Not Found ");
				messages.add(message);
			}
		} else {
			message.put("status", 401);
			message.put("message", "Unauthorized");
			messages.add(message);
		}
		return messages;
	}

	public List<Map<String, Object>> getHfbycode(BigInteger code, String token) {

		List<Map<String, Object>> messages = new ArrayList<Map<String, Object>>();
		Map<String, Object> message = new HashMap<String, Object>();

		String tuser = healthFacilityRepo.findApiuser(token);
		Integer aid = healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if ("1".equals(tuser)) {
			ApiLog a = new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/v1/getHfByHfCode");
//			apilogservice.addApiLog(a);
			Pageable pageable = PageRequest.of(0, 1, Sort.by("id"));
			Page<Object[]> pagedResult = healthFacilityRepo.findHfByCodes(code, pageable);
			if (pagedResult.hasContent()) {
				List<Object[]> content = pagedResult.getContent();
				List<Map<String, Object>> formattedList = new ArrayList<>();

				String[] fieldNames = { "name", "href", "uuid", "active", "created_at", "updated_at", "latitude",
						"longitude", "iid", "agency", "hfCode", "type", "hftype_id", "hftype_code", "hftype_name",
						"authlevel", "ftype", "opstatus", "internet", "ren_date", "sectioned", "functional",
						"icu_sectioned", "icu_functional", "ventilator_sectioned", "ventilator_functional",
						"province_id", "province_name", "district_id", "district_name", "municipality_id",
						"municipality_name", "ward", "estd_date", "validity", "email", "telephone", "oxygen",
						"ambulance", "concentrator", "cylinder", "ehs", "geriatrics", "insurance", "ocmc", "pharmacy",
						"plant_capacity", "ssu", "contact_person", "contact_person_mobile", "ambulance_category",
						"ambulance_contact", "hdu_functional", "hdu_sectioned", "nicu_functional", "nicu_sectioned",
						"org_source", "building_cost", "device_cost", "est_income", "loan_org", "other_source",
						"property_source", "workforce_cost", "approvedate", "approveby", "ftype_id", "ftype_code",
						"ftype_name", "ftype_status", "ownership", "ownership_id", "ownership_name", "ownership_code",
						"ownership_status", "level", "facility_level_id", "facility_level_code", "facility_level_name",
						"facility_level_status", "facility_level_parent", "facility_level_types", "oldlevel",
						"building_maps", "hf_details", "iee_certs", "mem_citizenships", "org_articles", "org_perms",
						"reg_orgs", "service_fees", "tax_clears", "vat_pans", "hcode", "rtype"

				};

				// Map each record to a key-value pair structure
				for (Object[] record : content) {
					Map<String, Object> map = new LinkedHashMap<>();

					for (int i = 0; i < fieldNames.length; i++) {

						if ("name".equals(fieldNames[i]) || "href".equals(fieldNames[i]) || "uuid".equals(fieldNames[i])
								|| "active".equals(fieldNames[i]) || "created_at".equals(fieldNames[i])
								|| "updated_at".equals(fieldNames[i])) {
							map.put(fieldNames[i], record[i]);
						} else if ("latitude".equals(fieldNames[i]) || "longitude".equals(fieldNames[i])) {
							// Handle coordinates
							map.computeIfAbsent("coordinates", k -> new LinkedHashMap<String, String>());
							Map<String, String> coordinates = (Map<String, String>) map.get("coordinates");
							coordinates.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						} else if ("agency".equals(fieldNames[i]) || "iid".equals(fieldNames[i])) {
							// Handle identifiers
							map.computeIfAbsent("identifiers", k -> new LinkedHashMap<String, String>());
							Map<String, String> identifiers = (Map<String, String>) map.get("identifiers");
							identifiers.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						}

						else {
							map.computeIfAbsent("properties", k -> new LinkedHashMap<String, String>());
							Map<String, Object> properties = (Map<String, Object>) map.get("properties");

							if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])) {
								properties.put(fieldNames[i], record[i]);
							}

							else if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])
									|| "hftype_id".equals(fieldNames[i]) || "hftype_code".equals(fieldNames[i])
									|| "hftype_name".equals(fieldNames[i])) {
//			                       // Handle identifiers
								map.computeIfAbsent("Health_facility_Type", k -> new LinkedHashMap<String, String>());
								Map<String, String> hft = (Map<String, String>) map.get("Health_facility_Type");
								hft.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("Health_facility_Type", hft);
							} else if ("facility_level_id".equals(fieldNames[i])
									|| "facility_level_code".equals(fieldNames[i])
									|| "facility_level_name".equals(fieldNames[i])
									|| "facility_level_status".equals(fieldNames[i])
									|| "facility_level_parent".equals(fieldNames[i])
									|| "facility_level_types".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("health_facility_level", k -> new LinkedHashMap<String, String>());
								Map<String, String> hfl = (Map<String, String>) map.get("health_facility_level");
								hfl.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("health_facility_level", hfl);
							} else if ("ownership_id".equals(fieldNames[i]) || "ownership_name".equals(fieldNames[i])
									|| "ownership_code".equals(fieldNames[i])
									|| "ownership_status".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("ownerships", k -> new LinkedHashMap<String, String>());
								Map<String, String> ownerships = (Map<String, String>) map.get("ownerships");
								ownerships.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("ownerships", ownerships);
							} else if ("ftype_id".equals(fieldNames[i]) || "ftype_code".equals(fieldNames[i])
									|| "ftype_name".equals(fieldNames[i]) || "ftype_status".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("service_type", k -> new LinkedHashMap<String, String>());
								Map<String, String> service_type = (Map<String, String>) map.get("service_type");
								service_type.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("service_type", service_type);
							}

							else if ("province_id".equals(fieldNames[i]) || "province_name".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("province", k -> new LinkedHashMap<String, String>());
								Map<String, String> province = (Map<String, String>) map.get("province");
								province.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("province", province);
							} else if ("district_id".equals(fieldNames[i]) || "district_name".equals(fieldNames[i])) {
								// Handle district
								map.computeIfAbsent("district", k -> new LinkedHashMap<String, String>());
								Map<String, String> district = (Map<String, String>) map.get("district");
								district.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("district", district);

							} else if ("municipality_id".equals(fieldNames[i])
									|| "municipality_name".equals(fieldNames[i])) {
								// Handle municipality
								map.computeIfAbsent("municipality", k -> new LinkedHashMap<String, String>());
								Map<String, String> municipality = (Map<String, String>) map.get("municipality");
								municipality.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("municipality", municipality);

							} else {
								properties.put(fieldNames[i], record[i]);
//			                	   map.put(fieldNames[i], record[i]);
							}

						}
					}

					map.remove("Health_facility_Type");
					map.remove("health_facility_level");
					map.remove("ownerships");
					map.remove("service_type");
					map.remove("district");
					map.remove("province");
					map.remove("municipality");
					formattedList.add(map);

				}
//
//				return formattedList;
//			} else {
//				return  List.of(Map.of("status:","404" ,"error", "Not Found "));
//			}
//		} else {
//			return  List.of(Map.of("status:","401" ,"error", "Unauthorized "));
//
//		}
				message.put("status", 200);
				message.put("message", "OK ");
				messages.add(message);
				return formattedList;
			} else {
				message.put("status", 404);
				message.put("message", "Not Found ");
				messages.add(message);
			}
		} else {
			message.put("status", 401);
			message.put("message", "Unauthorized");
			messages.add(message);
		}
		return messages;

	}

	public List<Map<String, Object>> getHfbyProvince(int pageNo, int pagesize, String sortby, String token,
			int province) {

		List<Map<String, Object>> messages = new ArrayList<Map<String, Object>>();
		Map<String, Object> message = new HashMap<String, Object>();

		if (pagesize >= 100) {
			pagesize = 100;
		}
		if ("".equals(sortby)) {
			sortby = "id";
		}
		String tuser = healthFacilityRepo.findApiuser(token);
		Integer aid = healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if ("1".equals(tuser)) {
			ApiLog a = new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/v1/getHfByProvince");
//			apilogservice.addApiLog(a);
			Pageable pageable = PageRequest.of(pageNo, pagesize, Sort.by(sortby));
			// System.out.println(healthFacilityRepo.getAllInPagination(pageable));
			Page<Object[]> pagedResult = healthFacilityRepo.findHfByProvince(province, pageable);

			if (pagedResult.hasContent()) {
				List<Object[]> content = pagedResult.getContent();
				List<Map<String, Object>> formattedList = new ArrayList<>();

				String[] fieldNames = { "name", "href", "uuid", "active", "created_at", "updated_at", "latitude",
						"longitude", "iid", "agency", "hfCode", "type", "hftype_id", "hftype_code", "hftype_name",
						"authlevel", "ftype", "opstatus", "internet", "ren_date", "sectioned", "functional",
						"icu_sectioned", "icu_functional", "ventilator_sectioned", "ventilator_functional",
						"province_id", "province_name", "district_id", "district_name", "municipality_id",
						"municipality_name", "ward", "estd_date", "validity", "email", "telephone", "oxygen",
						"ambulance", "concentrator", "cylinder", "ehs", "geriatrics", "insurance", "ocmc", "pharmacy",
						"plant_capacity", "ssu", "contact_person", "contact_person_mobile", "ambulance_category",
						"ambulance_contact", "hdu_functional", "hdu_sectioned", "nicu_functional", "nicu_sectioned",
						"org_source", "building_cost", "device_cost", "est_income", "loan_org", "other_source",
						"property_source", "workforce_cost", "approvedate", "approveby", "ftype_id", "ftype_code",
						"ftype_name", "ftype_status", "ownership", "ownership_id", "ownership_name", "ownership_code",
						"ownership_status", "level", "facility_level_id", "facility_level_code", "facility_level_name",
						"facility_level_status", "facility_level_parent", "facility_level_types", "oldlevel",
						"building_maps", "hf_details", "iee_certs", "mem_citizenships", "org_articles", "org_perms",
						"reg_orgs", "service_fees", "tax_clears", "vat_pans", "hcode", "rtype"

				};

				// Map each record to a key-value pair structure
				for (Object[] record : content) {
					Map<String, Object> map = new LinkedHashMap<>();

					for (int i = 0; i < fieldNames.length; i++) {

						if ("name".equals(fieldNames[i]) || "href".equals(fieldNames[i]) || "uuid".equals(fieldNames[i])
								|| "active".equals(fieldNames[i]) || "created_at".equals(fieldNames[i])
								|| "updated_at".equals(fieldNames[i])) {
							map.put(fieldNames[i], record[i]);
						} else if ("latitude".equals(fieldNames[i]) || "longitude".equals(fieldNames[i])) {
							// Handle coordinates
							map.computeIfAbsent("coordinates", k -> new LinkedHashMap<String, String>());
							Map<String, String> coordinates = (Map<String, String>) map.get("coordinates");
							coordinates.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						} else if ("agency".equals(fieldNames[i]) || "iid".equals(fieldNames[i])) {
							// Handle identifiers
							map.computeIfAbsent("identifiers", k -> new LinkedHashMap<String, String>());
							Map<String, String> identifiers = (Map<String, String>) map.get("identifiers");
							identifiers.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						}

						else {
							map.computeIfAbsent("properties", k -> new LinkedHashMap<String, String>());
							Map<String, Object> properties = (Map<String, Object>) map.get("properties");

							if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])) {
								properties.put(fieldNames[i], record[i]);
							}

							else if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])
									|| "hftype_id".equals(fieldNames[i]) || "hftype_code".equals(fieldNames[i])
									|| "hftype_name".equals(fieldNames[i])) {
//			                       // Handle identifiers
								map.computeIfAbsent("Health_facility_Type", k -> new LinkedHashMap<String, String>());
								Map<String, String> hft = (Map<String, String>) map.get("Health_facility_Type");
								hft.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("Health_facility_Type", hft);
							} else if ("facility_level_id".equals(fieldNames[i])
									|| "facility_level_code".equals(fieldNames[i])
									|| "facility_level_name".equals(fieldNames[i])
									|| "facility_level_status".equals(fieldNames[i])
									|| "facility_level_parent".equals(fieldNames[i])
									|| "facility_level_types".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("health_facility_level", k -> new LinkedHashMap<String, String>());
								Map<String, String> hfl = (Map<String, String>) map.get("health_facility_level");
								hfl.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("health_facility_level", hfl);
							} else if ("ownership_id".equals(fieldNames[i]) || "ownership_name".equals(fieldNames[i])
									|| "ownership_code".equals(fieldNames[i])
									|| "ownership_status".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("ownerships", k -> new LinkedHashMap<String, String>());
								Map<String, String> ownerships = (Map<String, String>) map.get("ownerships");
								ownerships.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("ownerships", ownerships);
							} else if ("ftype_id".equals(fieldNames[i]) || "ftype_code".equals(fieldNames[i])
									|| "ftype_name".equals(fieldNames[i]) || "ftype_status".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("service_type", k -> new LinkedHashMap<String, String>());
								Map<String, String> service_type = (Map<String, String>) map.get("service_type");
								service_type.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("service_type", service_type);
							}

							else if ("province_id".equals(fieldNames[i]) || "province_name".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("province", k -> new LinkedHashMap<String, String>());
								Map<String, String> provinces = (Map<String, String>) map.get("province");
								provinces.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("province", provinces);
							} else if ("district_id".equals(fieldNames[i]) || "district_name".equals(fieldNames[i])) {
								// Handle district
								map.computeIfAbsent("district", k -> new LinkedHashMap<String, String>());
								Map<String, String> district = (Map<String, String>) map.get("district");
								district.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("district", district);

							} else if ("municipality_id".equals(fieldNames[i])
									|| "municipality_name".equals(fieldNames[i])) {
								// Handle municipality
								map.computeIfAbsent("municipality", k -> new LinkedHashMap<String, String>());
								Map<String, String> municipality = (Map<String, String>) map.get("municipality");
								municipality.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("municipality", municipality);

							} else {
								properties.put(fieldNames[i], record[i]);
//			                	   map.put(fieldNames[i], record[i]);
							}

						}
					}

					map.remove("Health_facility_Type");
					map.remove("health_facility_level");
					map.remove("ownerships");
					map.remove("service_type");
					map.remove("district");
					map.remove("province");
					map.remove("municipality");
					formattedList.add(map);

				}
				message.put("status", 200);
				message.put("message", "OK ");
				messages.add(message);
				return formattedList;
			} else {
				message.put("status", 404);
				message.put("message", "Not Found ");
				messages.add(message);
			}
		} else {
			message.put("status", 401);
			message.put("message", "Unauthorized");
			messages.add(message);
		}
		return messages;
	}

	public List<Map<String, Object>> getHfbyDistrict(int pageNo, int pagesize, String sortby, String token,
			int district) {

		List<Map<String, Object>> messages = new ArrayList<Map<String, Object>>();
		Map<String, Object> message = new HashMap<String, Object>();

		if (pagesize >= 100) {
			pagesize = 100;
		}
		if ("".equals(sortby)) {
			sortby = "id";
		}
		String tuser = healthFacilityRepo.findApiuser(token);
		Integer aid = healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if ("1".equals(tuser)) {
			ApiLog a = new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/v1/getHfByDistrict");
//			apilogservice.addApiLog(a);
			Pageable pageable = PageRequest.of(pageNo, pagesize, Sort.by(sortby));
			// System.out.println(healthFacilityRepo.getAllInPagination(pageable));
			Page<Object[]> pagedResult = healthFacilityRepo.findHfByDistrict(district, pageable);
			if (pagedResult.hasContent()) {
				List<Object[]> content = pagedResult.getContent();
				List<Map<String, Object>> formattedList = new ArrayList<>();

				String[] fieldNames = { "name", "href", "uuid", "active", "created_at", "updated_at", "latitude",
						"longitude", "iid", "agency", "hfCode", "type", "hftype_id", "hftype_code", "hftype_name",
						"authlevel", "ftype", "opstatus", "internet", "ren_date", "sectioned", "functional",
						"icu_sectioned", "icu_functional", "ventilator_sectioned", "ventilator_functional",
						"province_id", "province_name", "district_id", "district_name", "municipality_id",
						"municipality_name", "ward", "estd_date", "validity", "email", "telephone", "oxygen",
						"ambulance", "concentrator", "cylinder", "ehs", "geriatrics", "insurance", "ocmc", "pharmacy",
						"plant_capacity", "ssu", "contact_person", "contact_person_mobile", "ambulance_category",
						"ambulance_contact", "hdu_functional", "hdu_sectioned", "nicu_functional", "nicu_sectioned",
						"org_source", "building_cost", "device_cost", "est_income", "loan_org", "other_source",
						"property_source", "workforce_cost", "approvedate", "approveby", "ftype_id", "ftype_code",
						"ftype_name", "ftype_status", "ownership", "ownership_id", "ownership_name", "ownership_code",
						"ownership_status", "level", "facility_level_id", "facility_level_code", "facility_level_name",
						"facility_level_status", "facility_level_parent", "facility_level_types", "oldlevel",
						"building_maps", "hf_details", "iee_certs", "mem_citizenships", "org_articles", "org_perms",
						"reg_orgs", "service_fees", "tax_clears", "vat_pans", "hcode", "rtype"

				};

				// Map each record to a key-value pair structure
				for (Object[] record : content) {
					Map<String, Object> map = new LinkedHashMap<>();

					for (int i = 0; i < fieldNames.length; i++) {

						if ("name".equals(fieldNames[i]) || "href".equals(fieldNames[i]) || "uuid".equals(fieldNames[i])
								|| "active".equals(fieldNames[i]) || "created_at".equals(fieldNames[i])
								|| "updated_at".equals(fieldNames[i])) {
							map.put(fieldNames[i], record[i]);
						} else if ("latitude".equals(fieldNames[i]) || "longitude".equals(fieldNames[i])) {
							// Handle coordinates
							map.computeIfAbsent("coordinates", k -> new LinkedHashMap<String, String>());
							Map<String, String> coordinates = (Map<String, String>) map.get("coordinates");
							coordinates.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						} else if ("agency".equals(fieldNames[i]) || "iid".equals(fieldNames[i])) {
							// Handle identifiers
							map.computeIfAbsent("identifiers", k -> new LinkedHashMap<String, String>());
							Map<String, String> identifiers = (Map<String, String>) map.get("identifiers");
							identifiers.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						}

						else {
							map.computeIfAbsent("properties", k -> new LinkedHashMap<String, String>());
							Map<String, Object> properties = (Map<String, Object>) map.get("properties");

							if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])) {
								properties.put(fieldNames[i], record[i]);
							}

							else if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])
									|| "hftype_id".equals(fieldNames[i]) || "hftype_code".equals(fieldNames[i])
									|| "hftype_name".equals(fieldNames[i])) {
//			                       // Handle identifiers
								map.computeIfAbsent("Health_facility_Type", k -> new LinkedHashMap<String, String>());
								Map<String, String> hft = (Map<String, String>) map.get("Health_facility_Type");
								hft.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("Health_facility_Type", hft);
							} else if ("facility_level_id".equals(fieldNames[i])
									|| "facility_level_code".equals(fieldNames[i])
									|| "facility_level_name".equals(fieldNames[i])
									|| "facility_level_status".equals(fieldNames[i])
									|| "facility_level_parent".equals(fieldNames[i])
									|| "facility_level_types".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("health_facility_level", k -> new LinkedHashMap<String, String>());
								Map<String, String> hfl = (Map<String, String>) map.get("health_facility_level");
								hfl.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("health_facility_level", hfl);
							} else if ("ownership_id".equals(fieldNames[i]) || "ownership_name".equals(fieldNames[i])
									|| "ownership_code".equals(fieldNames[i])
									|| "ownership_status".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("ownerships", k -> new LinkedHashMap<String, String>());
								Map<String, String> ownerships = (Map<String, String>) map.get("ownerships");
								ownerships.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("ownerships", ownerships);
							} else if ("ftype_id".equals(fieldNames[i]) || "ftype_code".equals(fieldNames[i])
									|| "ftype_name".equals(fieldNames[i]) || "ftype_status".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("service_type", k -> new LinkedHashMap<String, String>());
								Map<String, String> service_type = (Map<String, String>) map.get("service_type");
								service_type.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("service_type", service_type);
							}

							else if ("province_id".equals(fieldNames[i]) || "province_name".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("province", k -> new LinkedHashMap<String, String>());
								Map<String, String> provinces = (Map<String, String>) map.get("province");
								provinces.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("province", provinces);
							} else if ("district_id".equals(fieldNames[i]) || "district_name".equals(fieldNames[i])) {
								// Handle district
								map.computeIfAbsent("district", k -> new LinkedHashMap<String, String>());
								Map<String, String> districts = (Map<String, String>) map.get("district");
								districts.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("district", districts);

							} else if ("municipality_id".equals(fieldNames[i])
									|| "municipality_name".equals(fieldNames[i])) {
								// Handle municipality
								map.computeIfAbsent("municipality", k -> new LinkedHashMap<String, String>());
								Map<String, String> municipality = (Map<String, String>) map.get("municipality");
								municipality.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("municipality", municipality);

							} else {
								properties.put(fieldNames[i], record[i]);
//			                	   map.put(fieldNames[i], record[i]);
							}

						}
					}

					map.remove("Health_facility_Type");
					map.remove("health_facility_level");
					map.remove("ownerships");
					map.remove("service_type");
					map.remove("district");
					map.remove("province");
					map.remove("municipality");
					formattedList.add(map);

				}
				message.put("status", 200);
				message.put("message", "OK ");
				messages.add(message);
				return formattedList;
			} else {
				message.put("status", 404);
				message.put("message", "Not Found ");
				messages.add(message);
			}
		} else {
			message.put("status", 401);
			message.put("message", "Unauthorized");
			messages.add(message);
		}
		return messages;
	}

	public List<Map<String, Object>> getHfbyMunicipality(int pageNo, int pagesize, String sortby, String token,
			String municipality) {

		List<Map<String, Object>> messages = new ArrayList<Map<String, Object>>();
		Map<String, Object> message = new HashMap<String, Object>();

		if (pagesize >= 100) {
			pagesize = 100;
		}
		if ("".equals(sortby)) {
			sortby = "id";
		}
		String tuser = healthFacilityRepo.findApiuser(token);
		Integer aid = healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if ("1".equals(tuser)) {
			ApiLog a = new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/v1/getHfByMunicipality");
//			apilogservice.addApiLog(a);
			Pageable pageable = PageRequest.of(pageNo, pagesize, Sort.by(sortby));
			// System.out.println(healthFacilityRepo.getAllInPagination(pageable));
			Page<Object[]> pagedResult = healthFacilityRepo.findHfByPalika(municipality, pageable);
			if (pagedResult.hasContent()) {
				List<Object[]> content = pagedResult.getContent();
				List<Map<String, Object>> formattedList = new ArrayList<>();

				String[] fieldNames = { "name", "href", "uuid", "active", "created_at", "updated_at", "latitude",
						"longitude", "iid", "agency", "hfCode", "type", "hftype_id", "hftype_code", "hftype_name",
						"authlevel", "ftype", "opstatus", "internet", "ren_date", "sectioned", "functional",
						"icu_sectioned", "icu_functional", "ventilator_sectioned", "ventilator_functional",
						"province_id", "province_name", "district_id", "district_name", "municipality_id",
						"municipality_name", "ward", "estd_date", "validity", "email", "telephone", "oxygen",
						"ambulance", "concentrator", "cylinder", "ehs", "geriatrics", "insurance", "ocmc", "pharmacy",
						"plant_capacity", "ssu", "contact_person", "contact_person_mobile", "ambulance_category",
						"ambulance_contact", "hdu_functional", "hdu_sectioned", "nicu_functional", "nicu_sectioned",
						"org_source", "building_cost", "device_cost", "est_income", "loan_org", "other_source",
						"property_source", "workforce_cost", "approvedate", "approveby", "ftype_id", "ftype_code",
						"ftype_name", "ftype_status", "ownership", "ownership_id", "ownership_name", "ownership_code",
						"ownership_status", "level", "facility_level_id", "facility_level_code", "facility_level_name",
						"facility_level_status", "facility_level_parent", "facility_level_types", "oldlevel",
						"building_maps", "hf_details", "iee_certs", "mem_citizenships", "org_articles", "org_perms",
						"reg_orgs", "service_fees", "tax_clears", "vat_pans", "hcode", "rtype"

				};

				// Map each record to a key-value pair structure
				for (Object[] record : content) {
					Map<String, Object> map = new LinkedHashMap<>();

					for (int i = 0; i < fieldNames.length; i++) {

						if ("name".equals(fieldNames[i]) || "href".equals(fieldNames[i]) || "uuid".equals(fieldNames[i])
								|| "active".equals(fieldNames[i]) || "created_at".equals(fieldNames[i])
								|| "updated_at".equals(fieldNames[i])) {
							map.put(fieldNames[i], record[i]);
						} else if ("latitude".equals(fieldNames[i]) || "longitude".equals(fieldNames[i])) {
							// Handle coordinates
							map.computeIfAbsent("coordinates", k -> new LinkedHashMap<String, String>());
							Map<String, String> coordinates = (Map<String, String>) map.get("coordinates");
							coordinates.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						} else if ("agency".equals(fieldNames[i]) || "iid".equals(fieldNames[i])) {
							// Handle identifiers
							map.computeIfAbsent("identifiers", k -> new LinkedHashMap<String, String>());
							Map<String, String> identifiers = (Map<String, String>) map.get("identifiers");
							identifiers.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						}

						else {
							map.computeIfAbsent("properties", k -> new LinkedHashMap<String, String>());
							Map<String, Object> properties = (Map<String, Object>) map.get("properties");

							if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])) {
								properties.put(fieldNames[i], record[i]);
							}

							else if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])
									|| "hftype_id".equals(fieldNames[i]) || "hftype_code".equals(fieldNames[i])
									|| "hftype_name".equals(fieldNames[i])) {
//			                       // Handle identifiers
								map.computeIfAbsent("Health_facility_Type", k -> new LinkedHashMap<String, String>());
								Map<String, String> hft = (Map<String, String>) map.get("Health_facility_Type");
								hft.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("Health_facility_Type", hft);
							} else if ("facility_level_id".equals(fieldNames[i])
									|| "facility_level_code".equals(fieldNames[i])
									|| "facility_level_name".equals(fieldNames[i])
									|| "facility_level_status".equals(fieldNames[i])
									|| "facility_level_parent".equals(fieldNames[i])
									|| "facility_level_types".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("health_facility_level", k -> new LinkedHashMap<String, String>());
								Map<String, String> hfl = (Map<String, String>) map.get("health_facility_level");
								hfl.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("health_facility_level", hfl);
							} else if ("ownership_id".equals(fieldNames[i]) || "ownership_name".equals(fieldNames[i])
									|| "ownership_code".equals(fieldNames[i])
									|| "ownership_status".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("ownerships", k -> new LinkedHashMap<String, String>());
								Map<String, String> ownerships = (Map<String, String>) map.get("ownerships");
								ownerships.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("ownerships", ownerships);
							} else if ("ftype_id".equals(fieldNames[i]) || "ftype_code".equals(fieldNames[i])
									|| "ftype_name".equals(fieldNames[i]) || "ftype_status".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("service_type", k -> new LinkedHashMap<String, String>());
								Map<String, String> service_type = (Map<String, String>) map.get("service_type");
								service_type.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("service_type", service_type);
							}

							else if ("province_id".equals(fieldNames[i]) || "province_name".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("province", k -> new LinkedHashMap<String, String>());
								Map<String, String> provinces = (Map<String, String>) map.get("province");
								provinces.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("province", provinces);
							} else if ("district_id".equals(fieldNames[i]) || "district_name".equals(fieldNames[i])) {
								// Handle district
								map.computeIfAbsent("district", k -> new LinkedHashMap<String, String>());
								Map<String, String> districts = (Map<String, String>) map.get("district");
								districts.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("district", districts);

							} else if ("municipality_id".equals(fieldNames[i])
									|| "municipality_name".equals(fieldNames[i])) {
								// Handle municipality
								map.computeIfAbsent("municipality", k -> new LinkedHashMap<String, String>());
								Map<String, String> municipalitys = (Map<String, String>) map.get("municipality");
								municipalitys.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("municipality", municipalitys);

							} else {
								properties.put(fieldNames[i], record[i]);
//			                	   map.put(fieldNames[i], record[i]);
							}

						}
					}

					map.remove("Health_facility_Type");
					map.remove("health_facility_level");
					map.remove("ownerships");
					map.remove("service_type");
					map.remove("district");
					map.remove("province");
					map.remove("municipality");
					formattedList.add(map);

				}
				message.put("status", 200);
				message.put("message", "OK ");
				messages.add(message);
				return formattedList;
			} else {
				message.put("status", 404);
				message.put("message", "Not Found ");
				messages.add(message);
			}
		} else {
			message.put("status", 401);
			message.put("message", "Unauthorized");
			messages.add(message);
		}
		return messages;
	}

	public List<Map<String, Object>> getHfSearch(int pageNo, int pagesize, String token, String sortby,
			String searchKeyword) {

		List<Map<String, Object>> messages = new ArrayList<Map<String, Object>>();
		Map<String, Object> message = new HashMap<String, Object>();

		if (pagesize >= 100) {
			pagesize = 100;
		}
		if ("".equals(sortby)) {
			sortby = "id";
		}
		String tuser = healthFacilityRepo.findApiuser(token);
		Integer aid = healthFacilityRepo.findApiUserid(token);
		System.out.println(tuser);
		if ("1".equals(tuser)) {
			ApiLog a = new ApiLog();
			a.setUserid(aid);
			a.setAction("fetch");
			a.setUrl("api/get-hf-search");
//			apilogservice.addApiLog(a);
			Pageable pageable = PageRequest.of(pageNo, pagesize, Sort.by(sortby));
			Page<Object[]> pagedResult = healthFacilityRepo.findHfBySearch(searchKeyword, pageable);
			if (pagedResult.hasContent()) {
				List<Object[]> content = pagedResult.getContent();
				List<Map<String, Object>> formattedList = new ArrayList<>();

				String[] fieldNames = { "name", "href", "uuid", "active", "created_at", "updated_at", "latitude",
						"longitude", "iid", "agency", "hfCode", "type", "hftype_id", "hftype_code", "hftype_name",
						"authlevel", "ftype", "opstatus", "internet", "ren_date", "sectioned", "functional",
						"icu_sectioned", "icu_functional", "ventilator_sectioned", "ventilator_functional",
						"province_id", "province_name", "district_id", "district_name", "municipality_id",
						"municipality_name", "ward", "estd_date", "validity", "email", "telephone", "oxygen",
						"ambulance", "concentrator", "cylinder", "ehs", "geriatrics", "insurance", "ocmc", "pharmacy",
						"plant_capacity", "ssu", "contact_person", "contact_person_mobile", "ambulance_category",
						"ambulance_contact", "hdu_functional", "hdu_sectioned", "nicu_functional", "nicu_sectioned",
						"org_source", "building_cost", "device_cost", "est_income", "loan_org", "other_source",
						"property_source", "workforce_cost", "approvedate", "approveby", "ftype_id", "ftype_code",
						"ftype_name", "ftype_status", "ownership", "ownership_id", "ownership_name", "ownership_code",
						"ownership_status", "level", "facility_level_id", "facility_level_code", "facility_level_name",
						"facility_level_status", "facility_level_parent", "facility_level_types", "oldlevel",
						"building_maps", "hf_details", "iee_certs", "mem_citizenships", "org_articles", "org_perms",
						"reg_orgs", "service_fees", "tax_clears", "vat_pans", "hcode", "rtype" };
				// Map each record to a key-value pair structure
				for (Object[] record : content) {
					Map<String, Object> map = new LinkedHashMap<>();

					for (int i = 0; i < fieldNames.length; i++) {

						if ("name".equals(fieldNames[i]) || "href".equals(fieldNames[i]) || "uuid".equals(fieldNames[i])
								|| "active".equals(fieldNames[i]) || "created_at".equals(fieldNames[i])
								|| "updated_at".equals(fieldNames[i])) {
							map.put(fieldNames[i], record[i]);
						} else if ("latitude".equals(fieldNames[i]) || "longitude".equals(fieldNames[i])) {
							// Handle coordinates
							map.computeIfAbsent("coordinates", k -> new LinkedHashMap<String, String>());
							Map<String, String> coordinates = (Map<String, String>) map.get("coordinates");
							coordinates.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						} else if ("agency".equals(fieldNames[i]) || "iid".equals(fieldNames[i])) {
							// Handle identifiers
							map.computeIfAbsent("identifiers", k -> new LinkedHashMap<String, String>());
							Map<String, String> identifiers = (Map<String, String>) map.get("identifiers");
							identifiers.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
						} else {
							map.computeIfAbsent("properties", k -> new LinkedHashMap<String, String>());
							Map<String, Object> properties = (Map<String, Object>) map.get("properties");

							if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])) {
								properties.put(fieldNames[i], record[i]);
							}

							else if ("hfCode".equals(fieldNames[i]) || "type".equals(fieldNames[i])
									|| "hftype_id".equals(fieldNames[i]) || "hftype_code".equals(fieldNames[i])
									|| "hftype_name".equals(fieldNames[i])) {
//			                       // Handle identifiers
								map.computeIfAbsent("Health_facility_Type", k -> new LinkedHashMap<String, String>());
								Map<String, String> hft = (Map<String, String>) map.get("Health_facility_Type");
								hft.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("Health_facility_Type", hft);
							} else if ("facility_level_id".equals(fieldNames[i])
									|| "facility_level_code".equals(fieldNames[i])
									|| "facility_level_name".equals(fieldNames[i])
									|| "facility_level_status".equals(fieldNames[i])
									|| "facility_level_parent".equals(fieldNames[i])
									|| "facility_level_types".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("health_facility_level", k -> new LinkedHashMap<String, String>());
								Map<String, String> hfl = (Map<String, String>) map.get("health_facility_level");
								hfl.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("health_facility_level", hfl);
							} else if ("ownership_id".equals(fieldNames[i]) || "ownership_name".equals(fieldNames[i])
									|| "ownership_code".equals(fieldNames[i])
									|| "ownership_status".equals(fieldNames[i])) {
								// Handle identifiers
								map.computeIfAbsent("ownerships", k -> new LinkedHashMap<String, String>());
								Map<String, String> ownerships = (Map<String, String>) map.get("ownerships");
								ownerships.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("ownerships", ownerships);
							} else if ("ftype_id".equals(fieldNames[i]) || "ftype_code".equals(fieldNames[i])
									|| "ftype_name".equals(fieldNames[i]) || "ftype_status".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("service_type", k -> new LinkedHashMap<String, String>());
								Map<String, String> service_type = (Map<String, String>) map.get("service_type");
								service_type.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("service_type", service_type);
							} else if ("province_id".equals(fieldNames[i]) || "province_name".equals(fieldNames[i])) {
								// Handle province
								map.computeIfAbsent("province", k -> new LinkedHashMap<String, String>());
								Map<String, String> provinces = (Map<String, String>) map.get("province");
								provinces.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("province", provinces);
							} else if ("district_id".equals(fieldNames[i]) || "district_name".equals(fieldNames[i])) {
								// Handle district
								map.computeIfAbsent("district", k -> new LinkedHashMap<String, String>());
								Map<String, String> districts = (Map<String, String>) map.get("district");
								districts.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("district", districts);

							} else if ("municipality_id".equals(fieldNames[i])
									|| "municipality_name".equals(fieldNames[i])) {
								// Handle municipality
								map.computeIfAbsent("municipality", k -> new LinkedHashMap<String, String>());
								Map<String, String> municipalitys = (Map<String, String>) map.get("municipality");
								municipalitys.put(fieldNames[i], record[i] != null ? record[i].toString() : null);
								properties.put("municipality", municipalitys);
							} else {
								properties.put(fieldNames[i], record[i]);
//			                	   map.put(fieldNames[i], record[i]);
							}
						}
					}
					map.remove("Health_facility_Type");
					map.remove("health_facility_level");
					map.remove("ownerships");
					map.remove("service_type");
					map.remove("district");
					map.remove("province");
					map.remove("municipality");
					formattedList.add(map);
				}
				message.put("status", 200);
				message.put("message", "OK ");
				messages.add(message);
				return formattedList;
			} else {
				message.put("status", 404);
				message.put("message", "Not Found ");
				messages.add(message);
			}
		} else {
			message.put("status", 401);
			message.put("message", "Unauthorized");
			messages.add(message);
		}
		return messages;
	}
}
