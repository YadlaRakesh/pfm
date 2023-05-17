package com.appt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appt.model.Admin;
import com.appt.model.Nse;
import com.appt.model.User;
import com.appt.repository.AdminRepository;
import com.appt.repository.NseRepository;
import com.appt.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private NseRepository nseRepository;
	
	public Admin addAdmin(Admin admin) {

		User user = admin.getUser();

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user = userRepository.save(user);

		admin.setUser(user);
		admin = adminRepository.save(admin);
		admin.getUser().setPassword("-------");
		return admin;
	}
	
	public Admin getAdminDetails(String username) {
		return adminRepository.getAdminByUsername(username);
	}
	
	public void addStock(Nse nse) {
		nseRepository.save(nse);
	}
	
	public void updateStockByIsin(Nse nse,String isinNo) {
		Optional<Nse> s = nseRepository.findByIsinNo(isinNo);
	    Nse stock = s.get();
		stock.setSecurityName(nse.getSecurityName());
		stock.setSector(nse.getSector());
		stock.setIndustry(nse.getIndustry());
		stock.setExchange(nse.getExchange());
		stock.setCurrency(nse.getCurrency());
		stock.setCountry(nse.getCountry());
		stock.setLast(nse.getLast());
		stock.setClose(nse.getClose());

		nseRepository.save(stock);
	}
	
	public void deleteStock(String isinNo) {
		nseRepository.deleteById(isinNo);
	}
}
