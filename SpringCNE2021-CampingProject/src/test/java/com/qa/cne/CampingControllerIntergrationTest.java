package com.qa.cne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.cne.persistance.domain.Camping;




@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:camping-schema.sql", "classpath:camping-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")

public class CampingControllerIntergrationTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	private final Camping TEST_CAMPING = new Camping(null, "Ghost Camp", false, 22);
	
	private final Camping TEST_SAVED_CAMPING = new Camping(1L, "Ghost Camp", false, 22);
	
	
	  @Test  // TEST Create
	    public void testCreate() throws JsonProcessingException, Exception {
	        String resultString = this.mockMVC
	                .perform(post("/camping/create").contentType(MediaType.APPLICATION_JSON)
	                        .content(this.mapper.writeValueAsString(TEST_CAMPING)))
	                .andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();

	        Camping result = this.mapper.readValue(resultString, Camping.class);
	        assertThat(result).isEqualTo(TEST_CAMPING);
	    }
	  
	  
	   @Test   // TEST Read by ID
	    public void testReadOne() throws Exception {
	        this.mockMVC.perform(get("/camping/read/1")).andExpect(status().isOk())
	                .andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_CAMPING)));

	    }
	   
	    @Test // TEST READ ALL
	    public void testReadAll() throws Exception {
	        final List<Camping> CAMPS = new ArrayList<>();
	        CAMPS.add(TEST_SAVED_CAMPING);

	        final String resultString = this.mockMVC
	                .perform(request(HttpMethod.GET, "/camping/readAll").accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

	        List<Camping> results = Arrays.asList(mapper.readValue(resultString, Camping[].class));
	        assertThat(results).contains(this.TEST_SAVED_CAMPING).hasSize(3);
	    }
	    
	    @Test // TEST Update
	    public void testUpdate() throws Exception {
	        final Camping newCamping = new Camping(null, "Ghost Camp", false, 22);
	        String resultString = this.mockMVC
	                .perform(put("/camping/update/3").contentType(MediaType.APPLICATION_JSON)
	                        .content(this.mapper.writeValueAsString(newCamping)))
	                .andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

	        Camping result = this.mapper.readValue(resultString, Camping.class);
	        assertThat(result).isEqualTo(newCamping);
	    }
	    
	    @Test // TEST Delete
	    public void testDelete() throws Exception {
	        this.mockMVC.perform(delete("/camping/delete/2")).andExpect(status().isNoContent());
	    }
	    
	    @Test // TEST READ by CAMPNAME
	    public void testReadCamp() throws Exception {
	    	 this.mockMVC.perform(get("/camping/read/findbycampname/Ghost Camp")).andExpect(status().isOk())
             .andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_CAMPING)));
	    }
	    
	}


