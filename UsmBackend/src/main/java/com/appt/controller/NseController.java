package com.appt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appt.dto.NseResponseDto;
import com.appt.model.Nse;
import com.appt.service.NseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/stocks")
public class NseController {

	@Autowired
	private NseService nseService;
	
	@PostMapping("/insert")
	public void setDataInDB() throws IOException {
		nseService.saveNseData();
	}
	
	@GetMapping("/all")
	public List<Nse> getAllStocks(){
		return nseService.allStocks();
	}
	
	@GetMapping("/{isinNo}")
	public ResponseEntity<List<Nse>> getStockByCode(@PathVariable("isinNo") String isinNo) {
		List<Nse> list = new ArrayList<>();
		list.add(nseService.findByIsinNo(isinNo)); 
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/symbol/")
	public ResponseEntity<List<Nse>> getStocksBySymbol(@RequestParam String symbol){
		return ResponseEntity.ok(nseService.getBySymbol(symbol));
	}
	
	@GetMapping("/sector/")
	public ResponseEntity<List<Nse>> getStocksBySector(@RequestParam String sector) {
		return ResponseEntity.ok(nseService.findBySector(sector));
	}
	
	@GetMapping("/industry/")
	public ResponseEntity<List<NseResponseDto>> getStocksByIndustry(@RequestParam String industry) {
		return ResponseEntity.ok(nseService.fetchByIndustry(industry));	
	}
	
	@GetMapping("/security/")
	public ResponseEntity<List<NseResponseDto>> getStockBySecurityName(@RequestParam String securityName) {
		return ResponseEntity.ok(nseService.fetchStocksBySecurityName(securityName));
	}
	
}
