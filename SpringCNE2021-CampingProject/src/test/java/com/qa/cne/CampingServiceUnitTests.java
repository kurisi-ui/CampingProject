package com.qa.cne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.cne.persistance.domain.Camping;
import com.qa.cne.persistance.repository.CampingRepository;
import com.qa.cne.service.CampingService;

@SpringBootTest
public class CampingServiceUnitTests {
	  @Autowired
	    private CampingService service;

	    @MockBean
	    private CampingRepository repo;
	    
	    
	    public Camping create(Camping camp) {
	        return this.repo.save(camp);
	    }

	    @Test
	    void testCreate() {
	    	
	    	final Camping TEST_CAMPING = new Camping(null, "Ghost Camp", false, 22);
	    	final Camping TEST_SAVED_CAMPING = new Camping(1L, "Ghost Camp", false, 22);
	    	
	        Mockito.when(this.repo.save(new Camping(null, "Ghost Camp", false, 22))).thenReturn(new Camping(1L, "Ghost Camp", false, 22));
	        Assertions.assertEquals(this.service.create(TEST_CAMPING),TEST_SAVED_CAMPING);
	        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_CAMPING);
	    }
	    
	    @Test
	    void testReadById() {
	    	
	    		final Camping TEST_READ_CAMPING = new Camping(1L, "Ghost Camp", false, 22);
	    		
	    		
	    		when(repo.findById(1L)).thenReturn(Optional.of(TEST_READ_CAMPING));
	    		Assertions.assertEquals(this.service.readByID(1L),(TEST_READ_CAMPING));
	    		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	    		
	    		
	    }
	    
	    @Test
	    void testReadAll() {
	    	
	     	final Camping TEST_READ_CAMPING1 = new Camping(1L, "Ghost Camp", false, 22);
	    	final Camping TEST_READ_CAMPING2 = new Camping(2L, "Cool Camp", true, 12);
	    	final Camping TEST_READ_CAMPING3 = new Camping(3L, "Bikini Camp", false, 44);
	    	final List<Camping> CAMPS = List.of(TEST_READ_CAMPING1, TEST_READ_CAMPING2, TEST_READ_CAMPING3);
	    	 
	    	when(this.repo.findAll()).thenReturn(CAMPS);
	         assertThat(this.service.readAll().isEmpty()).isFalse();
	         verify(this.repo, atLeastOnce()).findAll();
    	
	    	}
	    
	    @Test
	    void testUpdate() {
	    

}
}