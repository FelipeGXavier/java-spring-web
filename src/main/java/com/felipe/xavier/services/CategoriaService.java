package com.felipe.xavier.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.xavier.domain.Categoria;
import com.felipe.xavier.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	/** 
	 * Instância de forma automatica
	 */
	@Autowired
	private CategoriaRepository repo;
	
	/**
	 * Utiliza-se o Optional para manipular o objeto através do ID
	 * 
	 */
	public Categoria buscaPorId(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		// Retorna o objeto ou simplesmente null
		return obj.orElse(null);
	}
}
