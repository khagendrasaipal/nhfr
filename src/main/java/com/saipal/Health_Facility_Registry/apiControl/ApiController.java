package com.saipal.Health_Facility_Registry.apiControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saipal.Health_Facility_Registry.entity.ApiLoginResponse;
import com.saipal.Health_Facility_Registry.entity.ApiSignUpUsersEntity;
import com.saipal.Health_Facility_Registry.entity.HealthFacility;
import com.saipal.Health_Facility_Registry.entity.Login;
import com.saipal.Health_Facility_Registry.entity.PaginationEntity;
import com.saipal.Health_Facility_Registry.service.ApiUserService;
import com.saipal.Health_Facility_Registry.service.MyCustomApiDetailsUser;
import com.saipal.Health_Facility_Registry.service.UsersService;
import com.saipal.Health_Facility_Registry.util.JwtUtils;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

	@Autowired
	ApiService apiService;

	@Autowired
	ApiUserService apiUserService;
	@Qualifier("encoder")
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UsersService usersService;
	ApiLoginResponse apiLoginResponse;
	JSONObject result = new JSONObject();
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtils jwtTokenutils;

	@Autowired
	MyCustomApiDetailsUser myapiDetailsService;
	@Autowired
	ObjectMapper objectMapper;

	@RequestMapping(value = "apiLogin", method = RequestMethod.POST)
	public @ResponseBody String apiLogin(@RequestBody Login login) {
		try {
			final UserDetails userDetails = myapiDetailsService.loadUserByUsername(login.getemail(),
					login.getPassword());
			List<ApiSignUpUsersEntity> users = apiUserService.getApiUser(userDetails.getUsername());
			for (ApiSignUpUsersEntity u : users) {
				apiLoginResponse = new ApiLoginResponse(u.getId(), u.getToken(), u.getFullname(), u.getUsername());
			}
			result.put("Status", "1");
			result.put("user", new JSONObject(apiLoginResponse));
		} catch (Exception e) {
			result.put("Status", "0");
			result.put("user", new JSONObject());
			return result.toString();
		}

		return result.toString();
	}

	@RequestMapping(value = "/getHf", method = RequestMethod.POST)
	public List<Map<String, Object>> getPagination(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);
		System.out.println("token: " + token);
		if (paginationEntity.getPageno() == 0) {
			return new ArrayList<>();
		} else {
			return apiService.getAllPagination(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(),
					paginationEntity.getSortby(), token);
		}
	}

	@RequestMapping(value = "/getHfSearch", method = RequestMethod.POST)
	public List<Map<String, Object>> getHfSearch(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfSearch(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(), token,
				paginationEntity.getSortby(), paginationEntity.getSearchKeyword());
	}

	@RequestMapping(value = "/getHfByHfCode", method = RequestMethod.POST)
	public  List<Map<String, Object>> getHfByCode(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfbycode(paginationEntity.getCode(), token);
	}

	@RequestMapping(value = "/getHfByProvince", method = RequestMethod.POST)
	public List<Map<String, Object>> getHfByProvince(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfbyProvince(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(),
				paginationEntity.getSortby(), token, paginationEntity.getProvince());
	}

	@RequestMapping(value = "/getHfByDistrict", method = RequestMethod.POST)
	public List<Map<String, Object>> getHfByDistrict(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfbyDistrict(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(),
				paginationEntity.getSortby(), token, paginationEntity.getDistrict());
	}

	@RequestMapping(value = "/getHfByMunicipality", method = RequestMethod.POST)
	public List<Map<String, Object>> getHfByMunicipality(@RequestBody PaginationEntity paginationEntity,
			@RequestHeader("Authorization") String authorizationHeader) {

		String token = extractBearerToken(authorizationHeader);

		return apiService.getHfbyMunicipality(paginationEntity.getPageno() - 1, paginationEntity.getPagesize(),
				paginationEntity.getSortby(), token, paginationEntity.getMunicipality());
	}

	private String extractBearerToken(String authorizationHeader) {
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			return authorizationHeader.substring(7);
		} else {
			throw new IllegalArgumentException("Invalid Authorization header format.");
		}
	}
}
