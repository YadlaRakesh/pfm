package com.appt.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.appt.dto.MessageDto;
import com.appt.model.Admin;
import com.appt.model.Nse;
import com.appt.repository.NseRepository;
import com.appt.service.AdminService;

@RestController
@CrossOrigin("http://localhost:8000")
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private NseRepository nseRepository;

	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {

		return adminService.addAdmin(admin);
	}
	
	@GetMapping("/details")
	public Admin getAdminDetails(Principal principal) {
		String username = principal.getName();
		return adminService.getAdminDetails(username);
	}
	
	@PostMapping("/addstock")
	public void addNewStock(@RequestBody Nse nse){
		adminService.addStock(nse);
	}

	@PutMapping("/update/{isinNo}")
	public ResponseEntity<MessageDto> updateStockByIsinNo(@RequestBody Nse nse, @PathVariable("isinNo") String isinNo) {
		
		if(nseRepository.findById(isinNo)==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageDto("Security Not Found!"));
		}
		
		adminService.updateStockByIsin(nse, isinNo);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("Updated Succesfully!"));
	}
	
	@DeleteMapping("/delete/{isinNo}")
	public void deleteStock(@PathVariable("isinNo") String isinNo) {
		adminService.deleteStock(isinNo);
	}
	
}
