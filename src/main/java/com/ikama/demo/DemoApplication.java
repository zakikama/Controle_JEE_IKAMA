package com.ikama.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ikama.demo.entities.Livre;
import com.ikama.demo.repositories.LivreRepo;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	LivreRepo livreRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//get current date

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDateTime now = LocalDateTime.now();  
		
	    Date date1=new SimpleDateFormat("yyyy/MM/dd").parse("1999/10/02");  

	    Date date2=new SimpleDateFormat("yyyy/MM/dd").parse(dtf.format(now));  

		livreRepo.save(new Livre(null,"My Evil Mother: A Short Story","Amazon Original Stories","Margaret Atwood",93,"B09T971KPQ",true,date1,date2));
		
		livreRepo.save(new Livre(null,"The Obsession","Amazon Original Stories","Nora Roberts",148,"B0152FFZYI",true,date1,date2));
		
	}


}
