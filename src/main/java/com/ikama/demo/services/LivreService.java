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
	
	public Livre editLivre(Livre livre) {
		
		Livre existLivre= livreRepo.findById(livre.getId()).orElse(null);
		
		if (livre == null)
			throw new RuntimeException("Livre not found");
		
			existLivre.setAuteur(livre.getAuteur());

			existLivre.setDisponible(livre.getDisponible());

			existLivre.setTitre(livre.getTitre());

			existLivre.setDateSortie(livre.getDateSortie());

			existLivre.setDateDerniereConsultation(livre.getDateDerniereConsultation());
		
			existLivre.setNombrePages(livre.getNombrePages());
		
		Livre livreUpdated = livreRepo.save(existLivre); 
		
		return livreUpdated;	
	}
}
