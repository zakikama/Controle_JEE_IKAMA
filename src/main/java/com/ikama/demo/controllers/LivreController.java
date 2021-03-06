package com.ikama.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikama.demo.entities.Livre;
import com.ikama.demo.services.LivreService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/emsiapi/livres")
public class LivreController {
	
	@Autowired
	LivreService livreService;
	
	@GetMapping
	public List<Livre> getLivres() {
		
		List<Livre> livres=livreService.getAllLivres();
		return livres;
	}
	@GetMapping(path = "/get/{id}")
	public Livre getLivre(@PathVariable Integer id) {
		Livre livre=livreService.getLivre(id);
		return livre;
	}
	@PutMapping(path = "/update")
	public Livre updateLivre(@RequestBody Livre livre){
		
		Livre livre_ = livreService.editLivre(livre);
		return livre_;
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Object>  deleteLivre(@PathVariable Integer id) {
		livreService.deleteLivre(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
