package com.ikama.demo.services;

import java.util.Date;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikama.demo.entities.Livre;
import com.ikama.demo.repositories.LivreRepo;

@Service
public class LivreService {
	
	@Autowired
	LivreRepo livreRepo;
	
	public List<Livre> getAllLivres() {
		
		List<Livre> livres = (List<Livre>) livreRepo.findByOrderByTitreDesc();
				
		return livres ;	
		
	}
	
	public Livre getLivre(Integer id) {
		
		Livre livre= livreRepo.findById(id).orElse(null);
				
		if (livre == null)
			throw new RuntimeException("Livre not found");
		
		return livre;	
		
	}
	
	public void deleteLivre(Integer id) {
		
		Livre livre= livreRepo.findById(id).orElse(null);
		
		if (livre == null)
			throw new RuntimeException("Livre not found");
		
		livreRepo.delete(livre);			
		
	}
	
	public Livre editLivre(Integer id,String titre,String auteur,int nombrePages,Boolean disponible,Date dateSortie,Date dateDerniereConsultation) {
		
		Livre livre= livreRepo.findById(id).orElse(null);
		
		if (livre == null)
			throw new RuntimeException("Livre not found");
		
		livre.setAuteur(auteur);

		livre.setDisponible(disponible);

		livre.setTitre(titre);

		livre.setDateSortie(dateSortie);

		livre.setDateDerniereConsultation(dateDerniereConsultation);
		
		livre.setNombrePages(nombrePages);
		
		Livre livreUpdated = livreRepo.save(livre); 
		
		return livreUpdated;	
	}
}
