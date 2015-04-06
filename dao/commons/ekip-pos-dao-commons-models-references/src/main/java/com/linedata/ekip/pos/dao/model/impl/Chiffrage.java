package com.linedata.ekip.pos.dao.model.impl;

import javax.persistence.Entity;
import javax.persistence.Id;





@Entity
public class Chiffrage {
	

	@Id
	private int id;
	private String libelle;
	
	public Chiffrage(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	public Chiffrage() {
		super();
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
