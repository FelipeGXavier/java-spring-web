package com.felipe.xavier.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.xavier.domain.Pedido;
import com.felipe.xavier.services.PedidoService;

@RestController
@RequestMapping (value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	PedidoService service;
	
	@RequestMapping (value = "/{id}", method = RequestMethod.GET )
	public Pedido buscaPedido(@PathVariable Integer id) {
		return service.findById(id);
	}

}
