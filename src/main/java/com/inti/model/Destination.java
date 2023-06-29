package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Destination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDestination;
	private int longitude;
	private int latitude;
	
	
	
	

}
