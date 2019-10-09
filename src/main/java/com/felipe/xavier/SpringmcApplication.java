package com.felipe.xavier;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipe.xavier.domain.Categoria;
import com.felipe.xavier.domain.Cidade;
import com.felipe.xavier.domain.Cliente;
import com.felipe.xavier.domain.Estado;
import com.felipe.xavier.domain.Produto;
import com.felipe.xavier.domain.enums.TipoCliente;
import com.felipe.xavier.repositories.CategoriaRepository;
import com.felipe.xavier.repositories.CidadeRepository;
import com.felipe.xavier.repositories.ClienteRepository;
import com.felipe.xavier.repositories.EstadoRepository;
import com.felipe.xavier.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringmcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringmcApplication.class, args);
	}

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria c1 = new Categoria(null, "Teste 1 ");
		Categoria c2 = new Categoria(null, "Teste 2 ");

		Produto p1 = new Produto(null, "Produto 1", 2200);
		Produto p2 = new Produto(null, "Produto 2", 800);

		p1.getCategorias().addAll(Arrays.asList(c1, c2));
		p2.getCategorias().addAll(Arrays.asList(c1));

		c1.getProdutos().addAll(Arrays.asList(p1, p2));
		c2.getProdutos().addAll(Arrays.asList(p1));

		Estado e1 = new Estado(null, "SC");
		Cidade cidade1 = new Cidade(null, "Rio do Sul", e1);
		e1.getCidades().addAll(Arrays.asList(cidade1));

		estadoRepository.saveAll(Arrays.asList(e1));
		cidadeRepository.saveAll(Arrays.asList(cidade1));

		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2));

		
		// Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo, Set<String> telefones
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		clienteRepository.saveAll(Arrays.asList(cli1));
		

	}

}
