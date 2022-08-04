package com.oumy.ref.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oumy.ref.model.Pays;
import com.oumy.ref.model.Region;
import com.oumy.ref.repository.PaysRepository;

@RestController
@RequestMapping("/api")
public class PaysService {
	
	@Autowired
	private PaysRepository paysRepository;
	
	@GetMapping("/pays")
	public Iterable<Pays> getPays(){
		return paysRepository.findAll();
	}
	
	@GetMapping("/pays/{id}")
	public Optional<Pays> getPaysById(@PathVariable("id") long id){
		return paysRepository.findById(id);
	}
	
	@PostMapping("/pays")
	public Pays addPays(@RequestBody Pays pays) {
		return paysRepository.save(pays);
	}
	
	@PutMapping("/pays/{id}")
	public Pays updatePays(@PathVariable("id") long id, @RequestBody Pays pays) {
		Optional<Pays> optPays = paysRepository.findById(id);
		Pays p = optPays.get();
		p.setPays_fr(pays.getPays_fr());
		return paysRepository.save(p);
	}
	
	/*@PutMapping("/pays/{id}")
	public Pays updatePays(@PathVariable("id")long id, @RequestBody Pays pays) {
		Optional<Pays> optPays = paysRepository.findById(id);
		
			Pays p = optPays.get();
			p.setPays_fr(pays.getPays_fr());
			
			return paysRepository.save(p);
		
	}*/
	
	@DeleteMapping("/pays/{id}")
	public void deletePaysById(@PathVariable("id")long id) {
		paysRepository.deleteById(id);
	}
	
	
}
