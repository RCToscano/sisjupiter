package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum TipoConstrucaoEnum {
	
	MADEIRA(1, "Madeira"),
	ALVENARIA(2, "Alvenaria"),
	MISTA(3, "Mista");

	private int id;
	private String descricao;
	
	
	private TipoConstrucaoEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<TipoConstrucaoEnum> listCodigos() {
		List<TipoConstrucaoEnum> list = new ArrayList<>();
		for (TipoConstrucaoEnum codigoEnum : values()) {
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