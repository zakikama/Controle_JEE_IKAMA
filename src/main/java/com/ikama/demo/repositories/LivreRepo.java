package com.ikama.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikama.demo.entities.Livre;

public interface LivreRepo extends JpaRepository<Livre, Integer>{

	Livre findByTitre(String name);
	List<Livre> findByOrderByTitreDesc();
}
