package com.appt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appt.model.Stock;

@Repository
public interface StocksRepository extends JpaRepository<Stock, String>{

	Stock findByIsinNo(String isinNo);
}
