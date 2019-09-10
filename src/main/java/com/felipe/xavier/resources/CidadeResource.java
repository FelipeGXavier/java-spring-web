package com.felipe.xavier.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.xavier.domain.Cidade;
import com.felipe.xavier.services.CidadeService;

@RestController
@RequestMapping (value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;
	
	
	@RequestMapping (value = "/listar", method = RequestMethod.GET)
	public List<Cidade> listaCidades(){
		List<Cidade> lista = service.listaCidade();
		return lista;
	}
	
}
