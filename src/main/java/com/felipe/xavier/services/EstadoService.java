package com.felipe.xavier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.xavier.domain.Estado;
import com.felipe.xavier.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository e;
	
	public Estado buscaEstado(int id) {
		Optional<Estado> obj = e.findById(id);
		return obj.orElse(null);
	}
	
	public List<Estado> exibeEstados() {
		List<Estado> lista = e.findAll();
		return lista;
	}
}
