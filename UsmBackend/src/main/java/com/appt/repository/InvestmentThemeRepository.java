package com.appt.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.appt.model.InvestmentTheme;

public interface InvestmentThemeRepository extends JpaRepository<InvestmentTheme,String>{

	public InvestmentTheme findBythemeNameContaining(String themeName);

	
}
