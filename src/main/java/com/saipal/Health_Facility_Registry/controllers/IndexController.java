package com.saipal.Health_Facility_Registry.controllers;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.saipal.Health_Facility_Registry.service.HealthFacilityService;
@Controller
public class IndexController {
	
	@Autowired
	HealthFacilityService objService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/anusuchi/{id}")
	public String anusuchi(Model model,@PathVariable(name = "id") int id,HttpServletRequest request) throws UnsupportedEncodingException {
		ResponseEntity<List<Map<String, Object>>> revd = objService.getHFDetails(id);
		System.out.println(revd.getBody());
		ResponseEntity<List<Map<String, Object>>> serv = objService.getServices(id);
		model.addAttribute("services", serv.getBody());
		model.addAttribute("hfname", revd.getBody().get(0).get("hfname"));
		model.addAttribute("hfcode", objService.toggleNum(revd.getBody().get(0).get("hfcode")+""));
		model.addAttribute("appdate", objService.toggleNum(revd.getBody().get(0).get("nepapprovedate")+""));
		model.addAttribute("palika", revd.getBody().get(0).get("palika"));
		model.addAttribute("ward", objService.toggleNum(revd.getBody().get(0).get("ward")+""));
		model.addAttribute("bed", objService.toggleNum(revd.getBody().get(0).get("sectioned")+""));
		model.addAttribute("validity", objService.toggleNum(revd.getBody().get(0).get("validity")+""));
		model.addAttribute("nepcdate", objService.toggleNum(revd.getBody().get(0).get("nepcdate")+""));
		
		String scheme = request.getScheme();             // http or https
	    String serverName = request.getServerName();     // localhost or domain name
	    int serverPort = request.getServerPort();        // 8080 or 80 or 443
	    String contextPath = request.getContextPath();   // application context path

	    String baseUrl = scheme + "://" + serverName + ":" + serverPort + contextPath;
	    String qrText = baseUrl + "/getservicesQr/" + id; // Construct the full URL for the QR code
	   
//	    String qrCodeUrl = "/generateQR?qrtext=" +  URLEncoder.encode(qrText, StandardCharsets.UTF_8);
	    String qrCodeUrl = "/generateQR?qrtext=" + URLEncoder.encode(qrText, "UTF-8");
	    System.out.println(qrCodeUrl);
	    model.addAttribute("qrCodeUrl", qrCodeUrl);
		return "anusuchi";
	}
	
	@GetMapping("/getservicesQr/{id}")
	public String getservicesQr(Model model,@PathVariable(name = "id") int id) {
		ResponseEntity<List<Map<String, Object>>> revd = objService.getHFDetails(id);
		ResponseEntity<List<Map<String, Object>>> serv = objService.getServices(id);
		model.addAttribute("hfname", revd.getBody().get(0).get("hfname"));
		model.addAttribute("hfcode", revd.getBody().get(0).get("hfcode"));
		model.addAttribute("services", serv.getBody());
	   
	    return "simple";
	}
	
	@GetMapping("/simple")
	public String simple(Model model) {
	    model.addAttribute("name", "World");
	    return "simple";
	}
	
	@GetMapping("/server-info")
    public Map<String, String> getServerInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("tomcatVersion", org.apache.catalina.util.ServerInfo.getServerInfo());
        info.put("javaVersion", System.getProperty("java.version"));
        return info;
    }
	
	@GetMapping("/article")
	public ModelAndView displayArticle(Map<String, Object> model) {

	    model.put("orgname", "BIR hospital");

	    return new ModelAndView("anusuchi", model);
	}
	
	 @GetMapping(value = "/generateQR", produces = MediaType.IMAGE_PNG_VALUE)
	    public ResponseEntity<byte[]> generateQRCode(@RequestParam(name = "qrtext", defaultValue = "")  String text) {
	    	System.out.println(text);
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        int width = 200;
	        int height = 200;

	        try {
	            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
	            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
	            byte[] pngData = pngOutputStream.toByteArray();

	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.IMAGE_PNG);

	            return ResponseEntity.ok().headers(headers).body(pngData);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body(null);
	        }
	    }
	
	
}
