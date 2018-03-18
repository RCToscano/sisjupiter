package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum SituacaoEnsinoEnum {
	
	COMPLETO(1, "Completo"),
	INCOMPLETO(2, "Incompleto");

	private int id;
	private String descricao;
	
	
	private SituacaoEnsinoEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<SituacaoEnsinoEnum> listCodigos() {
		List<SituacaoEnsinoEnum> list = new ArrayList<>();
		for (SituacaoEnsinoEnum codigoEnum : values()) {
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