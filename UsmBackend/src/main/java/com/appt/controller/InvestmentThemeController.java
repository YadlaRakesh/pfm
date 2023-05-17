package com.appt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.appt.model.InvestmentTheme;

import com.appt.repository.InvestmentThemeRepository;

@RestController
@CrossOrigin("http://localhost:8000")
@RequestMapping("/api")
public class InvestmentThemeController {
	@Autowired
	private InvestmentThemeRepository themeRepository;
	


	@PostMapping("/add/theme")
	public InvestmentTheme addTheme(@RequestBody InvestmentTheme investmentTheme) {
	return themeRepository.save(investmentTheme);	
	}
	
	@GetMapping("/get/{themeName}")
	public InvestmentTheme getthemeName(@PathVariable("themeName") String themeName){
		InvestmentTheme theme =themeRepository.findBythemeNameContaining(themeName);
		return theme;
	}
	
}
