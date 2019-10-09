package com.felipe.xavier.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pesso Jurídica");

	private int codigo;
	private String desc;

	private TipoCliente(int codigo, String desc) {
		this.codigo = codigo;
		this.desc = desc;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDesc() {
		return desc;
	}
	
	public static TipoCliente buscaEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		// values() retorna um vetor com os valores contidos na classe Enumerador
		
		for (TipoCliente x : TipoCliente.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Inválido: " + codigo);
	}

}
