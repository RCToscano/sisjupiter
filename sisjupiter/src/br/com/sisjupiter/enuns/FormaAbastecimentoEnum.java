package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum FormaAbastecimentoEnum {
	
	REGULAR(1, "Liga&ccedil;&atilde;o Regular"),
	VIZINHO(2, "Vizinho"),
	POCO(3, "Po&ccedil;o"),
	TANQUE(4, "Carro Tanque"),
	OUTRA(5, "Outra"),
	NAO_IDENTIFICADO(6, "N&atilde;o Identificado");

	private int id;
	private String descricao;
	
	
	private FormaAbastecimentoEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<FormaAbastecimentoEnum> listCodigos() {
		List<FormaAbastecimentoEnum> list = new ArrayList<>();
		for (FormaAbastecimentoEnum codigoEnum : values()) {
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