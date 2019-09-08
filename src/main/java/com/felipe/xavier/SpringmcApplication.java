package com.felipe.xavier;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipe.xavier.domain.Categoria;
import com.felipe.xavier.domain.Produto;
import com.felipe.xavier.repositories.CategoriaRepository;
import com.felipe.xavier.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringmcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringmcApplication.class, args);
	}

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Teste 1 ");
		Categoria c2 = new Categoria(null, "Teste 2 ");
		
		Produto p1 = new Produto(null, "Produto 1", 2200);
		Produto p2 = new Produto(null, "Produto 2", 800);
		
		p1.getCategorias().addAll(Arrays.asList(c1,c2));
		p2.getCategorias().addAll(Arrays.asList(c1));
		
		c1.getProdutos().addAll(Arrays.asList(p1, p2));
		c2.getProdutos().addAll(Arrays.asList(p1));
		
		categoriaRepository.saveAll(Arrays.asList(c1,c2));
		produtoRepository.saveAll(Arrays.asList(p1,p2));
		
	}

}
