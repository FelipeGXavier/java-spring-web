package com.felipe.xavier.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private int codigo;
	private String desc;

	private EstadoPagamento(int codigo, String desc) {
		this.codigo = codigo;
		this.desc = desc;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDesc() {
		return desc;
	}

	public static EstadoPagamento buscaEnum(Integer codigo) {

		if (codigo == null) {
			return null;
		}
		// values() retorna um vetor com os valores contidos na classe Enumerador
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id Inválido: " + codigo);
	}
}
