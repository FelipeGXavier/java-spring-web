package com.felipe.xavier.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.xavier.domain.Cliente;
import com.felipe.xavier.services.ClienteService;

@RestController
@RequestMapping (value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService serv;
	
	
	@RequestMapping (value = "/{id}", method = RequestMethod.GET)
	public Cliente buscaCliente(@PathVariable Integer id) {
		Cliente obj = serv.buscaPorId(id);
		return obj;
		
	}
	
	
}
