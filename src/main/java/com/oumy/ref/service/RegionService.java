package com.oumy.ref.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oumy.ref.model.Pays;
import com.oumy.ref.model.Region;
import com.oumy.ref.repository.PaysRepository;
import com.oumy.ref.repository.RegionRepository;

@RestController
@RequestMapping("/api")
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private PaysRepository paysRepository;
	
	@PostMapping("/region")
	public Region addRegion(@RequestBody Region region) {
		Pays pays = new Pays();
		pays.setPays_fr(region.getPays().getPays_fr());
		paysRepository.save(pays);
		Region r = new Region(region);
		r.setPays(pays);
		return regionRepository.save(r);
	}
	
	@GetMapping("/region")
	public Iterable<Region> getRegions(){
		return regionRepository.findAll();
	}
}
