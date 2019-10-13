package com.felipe.xavier.domain;

import javax.persistence.Entity;

import com.felipe.xavier.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {

	private int numeroParcelas;

	private static final long serialVersionUID = 1L;

	
	public PagamentoComCartao() {
		
	}
	
	public PagamentoComCartao(Integer id, EstadoPagamento estado, int numeroParcelas, Pedido pedido) {
		super(id, estado, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public int getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

}
