package com.felipe.xavier;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipe.xavier.domain.Categoria;
import com.felipe.xavier.repositories.CategoriaRepository;

@SpringBootApplication
public class SpringmcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringmcApplication.class, args);
	}

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Teste 1 ");
		Categoria c2 = new Categoria(null, "Teste 2 ");
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		
	}

}
