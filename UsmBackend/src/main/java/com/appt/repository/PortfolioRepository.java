package com.appt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appt.model.PortfolioHeader;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioHeader, String>{
	
	public PortfolioHeader findByPortfolioNameContaining(String portfolioName);


	@Modifying
	@Query("delete from PortfolioHeader where portfolioName=:portfolioName")
	public int deletePortfolioByName(@Param("portfolioName") String portfolioName);
}
