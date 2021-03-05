package com.qa.cne.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cne.persistance.domain.Camping;
import com.qa.cne.persistance.repository.CampingRepository;
import com.qa.cne.service.exceptions.CampNotFoundException;

@Service
public class CampingService {
	private CampingRepository repo;
	
	@Autowired
	public CampingService(CampingRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	//Methods are Below
	
	//CREATE Method
	
	public Camping create(Camping camping) {
		Camping created = this.repo.save(camping);
		return created;
	}
	
	
	// READ by ID
	
	public Camping readByID(Long id) {
		Camping readFromDb = this.repo.findById(id).orElseThrow(CampNotFoundException::new);
		return readFromDb;
	}
	
	
	// READ by ALL
	
	public List<Camping> readAll() {
		List<Camping> readFromDb = this.repo.findAll();
		return readFromDb;
	}
	
	// UPDATE by ID
	
	public Camping updateById(Long id,Camping newcamping) {
		//Defines old object to get by id
		Camping oldCamping = this.repo.findById(id).get();
		//Adding changes to the object by id
		oldCamping.setCampName(newcamping.getCampName());
		oldCamping.setOpenWinter(newcamping.getOpenWinter());
		oldCamping.setPrice(newcamping.getPrice());
		
		//Returns saved object to Database
		return this.repo.save(oldCamping);
		
		
	}
	
	// DELETE by ID
	
	public boolean deleteById(Long id) {
		
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	
	// FIND by CAMPNAME
	
	public Camping findByCampName(String campName) throws CampNotFoundException {
		return this.repo.findByCampName(campName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
