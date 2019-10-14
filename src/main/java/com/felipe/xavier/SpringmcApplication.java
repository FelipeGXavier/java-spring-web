package com.felipe.xavier;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipe.xavier.domain.Categoria;
import com.felipe.xavier.domain.Cidade;
import com.felipe.xavier.domain.Cliente;
import com.felipe.xavier.domain.Endereco;
import com.felipe.xavier.domain.Estado;
import com.felipe.xavier.domain.ItemPedido;
import com.felipe.xavier.domain.Pagamento;
import com.felipe.xavier.domain.PagamentoComCartao;
import com.felipe.xavier.domain.Pedido;
import com.felipe.xavier.domain.Produto;
import com.felipe.xavier.domain.enums.EstadoPagamento;
import com.felipe.xavier.domain.enums.TipoCliente;
import com.felipe.xavier.repositories.CategoriaRepository;
import com.felipe.xavier.repositories.CidadeRepository;
import com.felipe.xavier.repositories.ClienteRepository;
import com.felipe.xavier.repositories.EnderecoRepository;
import com.felipe.xavier.repositories.EstadoRepository;
import com.felipe.xavier.repositories.ItemPedidoRepository;
import com.felipe.xavier.repositories.PagamentoRepository;
import com.felipe.xavier.repositories.PedidoRepository;
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

	@Autowired
	PagamentoRepository pagamentoRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;

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

		// Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo,
		// Set<String> telefones
		Cliente cl = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cl.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		clienteRepository.saveAll(Arrays.asList(cl));

		Endereco endereco1 = new Endereco(null, "ABC", "256", "Casa", "Centro", "89160075", cl, cidade1);
		enderecoRepository.save(endereco1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cl, endereco1);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, 6, ped1);
		ped1.setPagamento(pagto1);

		cl.getPedidos().addAll(Arrays.asList(ped1));

		pedidoRepository.saveAll(Arrays.asList(ped1));
		pagamentoRepository.saveAll(Arrays.asList(pagto1));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
	
		ped1.getItens().addAll(Arrays.asList(ip1));
		p1.getItens().addAll(Arrays.asList(ip1));
		itemPedidoRepository.saveAll(Arrays.asList(ip1));

	}

}
