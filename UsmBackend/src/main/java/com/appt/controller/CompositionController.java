package com.appt.controller;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appt.model.PortfolioComposition;
import com.appt.model.PortfolioHeader;
import com.appt.repository.CompositionRepository;
import com.appt.service.CompositionService;

@RestController
@CrossOrigin("http://localhost:8000")
@RequestMapping("/api/composition/")
public class CompositionController {
	
	@Autowired
	private CompositionRepository compositionRepository;
	
	@Autowired
	private CompositionService service; 
	
	
	@PostMapping("/new")
	public PortfolioComposition createPortfolio(@RequestBody PortfolioComposition portfolioComposition) {
		return compositionRepository.save(portfolioComposition);
	}
	
	@GetMapping("/get") 
	public List<PortfolioComposition> getcompo(){
		List<PortfolioComposition> compo = compositionRepository.findAll();
		return compo;
	}
	
//	@GetMapping("/get/{portfolioName}")
//	public List<PortfolioComposition> getPortfolioByName(@PathVariable("portfolioName") String portfolioName) {
//		List<PortfolioComposition> p = compositionRepository.findByPortfolioName(portfolioName);
//		return p;
//		
//	}
	@PutMapping("/securityname/{securityName}/{id}")
	public ResponseEntity<String> updateNoOfSecurity(@PathVariable("securityName") String securityName, @PathVariable("id") long id){
		String str=service.updateNoOfSecurity(securityName,id);
		return ResponseEntity.ok().body(str);
	}
	

	@DeleteMapping("/delete/{securityName}")
	@Transactional
	public ResponseEntity<String> removeBysecurityName(@PathVariable("securityName") String securityName) {
		String str = service.deleteBysecurityName(securityName);
		return ResponseEntity.ok().body(str);
	}

}
	
