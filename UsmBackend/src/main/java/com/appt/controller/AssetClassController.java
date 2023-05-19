package com.appt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appt.model.AssetClass;
import com.appt.repository.AssetClassRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AssetClassController {
	
	@Autowired
	private AssetClassRepository assetRepo;
	
	@PostMapping("/add/asset")
	public AssetClass addAsset(@RequestBody AssetClass asset) {
		return assetRepo.save(asset);
		
	}

}
