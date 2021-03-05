package com.qa.cne;

import java.util.List;


import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.cne.persistance.domain.Camping;
import com.qa.cne.persistance.repository.CampingRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CampingRepositoryTest {
	@Autowired
	private CampingRepository repo;
	
	final Camping TEST_CAMPING1 = new Camping(1L, "Ghost Camp", false, 22);
	final Camping TEST_CAMPING2 = new Camping(2L, "Cool Camp", true, 12);
	final Camping TEST_CAMPING3 = new Camping(3L, "Bikini Camp", false, 44);
	final List<Camping> CAMPS = List.of(TEST_CAMPING1, TEST_CAMPING2, TEST_CAMPING3);
	
	@BeforeAll
	void init() {
		this.repo.saveAll(CAMPS);
	}
	
}