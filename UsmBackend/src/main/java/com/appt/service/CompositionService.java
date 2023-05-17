package com.appt.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.appt.repository.CompositionRepository;

@Service
public class CompositionService {
	@Autowired
	private CompositionRepository repo;

	public String updateNoOfSecurity(String securityName, long id) {
		String str="unable to update security";
		int res=repo.updateNoOfSecurity(securityName,id);
		if(res>0) {
			str="No Of Securities updated";
		}
		return str;
	}

	public String deleteBysecurityName(String securityName) {
       String str = "Unable to delete security";
		
		int res = repo.deleteBysecurityName(securityName);
		if(res > 0) {
			str = "Security is deleted";
		}
		return str;
	}
}
