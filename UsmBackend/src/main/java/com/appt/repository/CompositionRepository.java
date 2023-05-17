package com.appt.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appt.model.PortfolioComposition;


@Repository 
public interface CompositionRepository extends JpaRepository<PortfolioComposition, Long>{

	@Transactional
	@Modifying
	@Query("update PortfolioComposition set securityName=:securityName where portfolio_composition_id=:id")
	public int updateNoOfSecurity(@Param("securityName") String securityName, @Param("id") long id);

	
	@Modifying
	@Query("delete from PortfolioComposition where securityName=:securityName")
	public int deleteBysecurityName(@Param("securityName") String securityName);
}


