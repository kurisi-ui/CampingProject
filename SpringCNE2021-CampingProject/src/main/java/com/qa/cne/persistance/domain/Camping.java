package com.qa.cne.persistance.domain;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Camping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Auto Incrementing table ID
	
	@Column
	private String campName;
	
	@Column
	private Boolean openWinter;
	
	@Column
	private double price;



	

	
	}


