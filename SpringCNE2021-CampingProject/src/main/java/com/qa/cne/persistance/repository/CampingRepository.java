package com.qa.cne.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.cne.persistance.domain.Camping;

public interface CampingRepository extends JpaRepository<Camping,Long> {
	 Camping findByCampName(String campName);
}
