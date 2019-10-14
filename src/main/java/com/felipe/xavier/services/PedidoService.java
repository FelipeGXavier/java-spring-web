package com.felipe.xavier.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.xavier.domain.Pedido;
import com.felipe.xavier.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired PedidoRepository repo;
	
	public Pedido findById(Integer id) {
		Optional<Pedido> pedido = repo.findById(id);
		return pedido.orElse(null);
		
	}
	
}
