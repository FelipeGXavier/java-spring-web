package com.felipe.xavier.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.xavier.domain.Cliente;
import com.felipe.xavier.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscaPorId(int id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
