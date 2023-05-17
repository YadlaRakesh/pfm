package com.appt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appt.model.FundManager;

@Repository
public interface FundManagerRepository extends JpaRepository<FundManager, Long>{

}
