package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum CategoriaImovelEnum {
	
	RESIDENCIA(1, "Resid&ecirc;ncia"),
	COMERCIO(2, "Com&eacute;rcio"),
	INDUSTRIA(3, "Morador Ausente"),
	PUBLICA(4, "Publica");

	private int id;
	private String descricao;
	
	
	private CategoriaImovelEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<CategoriaImovelEnum> listCodigos() {
		List<CategoriaImovelEnum> list = new ArrayList<>();
		for (CategoriaImovelEnum codigoEnum : values()) {
			list.add(codigoEnum);
		}
		return list;
	}



	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}