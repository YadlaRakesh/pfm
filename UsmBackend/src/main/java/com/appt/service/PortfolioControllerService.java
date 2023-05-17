package com.appt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appt.repository.PortfolioRepository;

@Service
public class PortfolioControllerService {

	@Autowired
	private PortfolioRepository repository;
	
	public String deletePortfolioByName(String portfolioName) {
		String str = "Unable to delete portfolio";
		
		int res = repository.deletePortfolioByName(portfolioName);
		if(res > 0) {
			str = "Portfolio with Name: " + portfolioName + " deleted.";
		}
		
		return str;
	}
	
}
