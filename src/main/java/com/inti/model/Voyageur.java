package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Voyageur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVoyageur;
	private String nom;
	private String prenom;
	private int age;
	@OneToMany(mappedBy = "voyageur")
	private List<Reservation> reservations;
	
	public Voyageur(String nom, String prenom, int age, List<Reservation> reservations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.reservations = reservations;
	}
	
	
}
