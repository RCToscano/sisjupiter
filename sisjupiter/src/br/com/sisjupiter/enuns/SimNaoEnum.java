package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum SimNaoEnum {
	
	SIM(1, "Sim"),
	NAO(2, "N&atilde;o");

	private int id;
	private String descricao;
	
	
	private SimNaoEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<SimNaoEnum> listCodigos() {
		List<SimNaoEnum> list = new ArrayList<>();
		for (SimNaoEnum codigoEnum : values()) {
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