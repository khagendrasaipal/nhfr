package com.saipal.Health_Facility_Registry.controllers;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ErrorrHandlerController implements ErrorController {

	@GetMapping("/error")
	public String customError() {
		return "index";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}