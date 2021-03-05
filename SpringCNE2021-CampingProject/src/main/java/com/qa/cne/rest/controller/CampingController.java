package com.qa.cne.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cne.persistance.domain.Camping;
import com.qa.cne.service.CampingService;

@RestController
@RequestMapping("/camping")
public class CampingController {
	private CampingService service;
	
	@Autowired
	public CampingController(CampingService service) {
		super(); this.service = service;
	}
	
	
	// CREATE
	
	@PostMapping("/create")
	public ResponseEntity<Camping> create(@RequestBody Camping c) {
		Camping createdObject = this.service.create(c);
		return new ResponseEntity<>(createdObject, HttpStatus.CREATED); // Returns HTTP 201
	}

	
	
	// READ by ID
	
	@GetMapping("/read/{id}")
	public ResponseEntity<Camping> readById(@PathVariable Long id) {
		Camping returnedObject = this.service.readByID(id);
		return ResponseEntity.ok(returnedObject);
	}
	
	
	// READ by ALL
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Camping>> readAll() {
		return ResponseEntity.ok(this.service.readAll()); 
	}
	
	
	// UPDATE by ID
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Camping> updateById(@PathVariable Long id, @RequestBody Camping camping) {
		Camping updatedObject = this.service.updateById(id, camping);
		return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED); // Returns HTTP 202
	}
	
	
	// DELETE by ID
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Camping> deleteById(@PathVariable Long id) {
		if (this.service.deleteById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Returns HTTP 204
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Returns HTTP 503
		}
		
	}
	
	
	// FIND by CAMP NAME
	
	@GetMapping("read/findbycampname/{campName}")
	public ResponseEntity<Camping> findByCampName(@PathVariable String campName) {
		Camping found = this.service.findByCampName(campName);
		return ResponseEntity.ok(found);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
