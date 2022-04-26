package com.ikama.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Livre implements Serializable{
	
	private static final long serialVersionUID = -3451729344189518704L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false, length = 50)
	private String titre;
	
	@Column(nullable = false, length = 50,updatable=false)
	private String maisonEdition;	
	
	@Column(nullable = false)
	private String auteur;	
	
	@Column(nullable = false)
	private int nombrePages;
	
	@Column(nullable = false,unique=true,updatable=false)
	private String ISBN;
	
	@Column(nullable = false)
	private Boolean disponible;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateSortie;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDerniereConsultation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getMaisonEdition() {
		return maisonEdition;
	}

	public void setMaisonEdition(String maisonEdition) {
		this.maisonEdition = maisonEdition;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getNombrePages() {
		return nombrePages;
	}

	public void setNombrePages(int nombrePages) {
		this.nombrePages = nombrePages;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Date getDateDerniereConsultation() {
		return dateDerniereConsultation;
	}

	public void setDateDerniereConsultation(Date dateDerniereConsultation) {
		this.dateDerniereConsultation = dateDerniereConsultation;
	}

	public Livre(Integer id, String titre, String maisonEdition, String auteur, int nombrePages, String iSBN,
			Boolean disponible, Date dateSortie, Date dateDerniereConsultation) {
		super();
		this.id = id;
		this.titre = titre;
		this.maisonEdition = maisonEdition;
		this.auteur = auteur;
		this.nombrePages = nombrePages;
		ISBN = iSBN;
		this.disponible = disponible;
		this.dateSortie = dateSortie;
		this.dateDerniereConsultation = dateDerniereConsultation;
	}

	public Livre() {
		super();
	}
	
	
}
