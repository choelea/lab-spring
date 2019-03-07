package com.joe.labspringweb.controller;

import java.util.Collections;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("testMappingController")
@RequestMapping("/mapping")
public class MappingTest {
	/**
	 * 索引页面
	 */
	@GetMapping("/cas-registry-number_{subfix}.html")
	public String index(@PathVariable String subfix, ModelMap model) {
		
		return "not-exist";
	}

	@GetMapping("/cas-{casNo}.html")
	public String casNoProducts(@PathVariable String casNo, Integer pageNumber, ModelMap model) {
		return "not-exist";
	}	 

	@GetMapping(path = "/cas-{casNo}.html", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> casNoProductsJson(String casNo, Integer pageNumber) {		
		return ResponseEntity.ok("OK");
	}	
	
	
		
	// this one doesn't work
	@GetMapping(path = "/search.html", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> testNotWork(String casNo, Integer pageNumber) {
		System.out.println("Never comes here");
		return ResponseEntity.ok(Collections.singletonMap("success", true));
	}	
	
	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> testJson(String casNo, Integer pageNumber) {
		return ResponseEntity.ok(Collections.singletonMap("success", true));
	}	
}
