package com.felipe.xavier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.xavier.domain.Cidade;
import com.felipe.xavier.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> listaCidade(){
		List<Cidade> cidades = repo.findAll();
		return cidades;
	}
}
