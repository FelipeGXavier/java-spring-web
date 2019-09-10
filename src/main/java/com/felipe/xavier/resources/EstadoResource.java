package com.felipe.xavier.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.xavier.domain.Estado;
import com.felipe.xavier.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id)  {
		Estado obj = service.buscaEstado(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/listar",method=RequestMethod.GET)
	public List<Estado> exibe()  {
		List<Estado> obj = service.exibeEstados();
		return obj;
	}
	
}
