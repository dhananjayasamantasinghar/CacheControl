package com.cache.CacheTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cache.CacheTest.service.CacheService;

@RestController
@RequestMapping("/rest")
public class CacheController {
	
	@Autowired
	private CacheService service;
	
	@GetMapping("/getName")
	public String getName(@RequestParam String name){
		service.getName(name);
		System.out.println("Dhananjaya");
		return "Dhananjaya";
	}

}
