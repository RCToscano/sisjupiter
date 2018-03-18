package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum NacionalidadeEnum {
	
	BRASILEIRO(1, "Brasileiro"),
	ESTRANGEIRO(2, "Estrangeiro");

	private int id;
	private String descricao;
	
	
	private NacionalidadeEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<NacionalidadeEnum> listCodigos() {
		List<NacionalidadeEnum> list = new ArrayList<>();
		for (NacionalidadeEnum codigoEnum : values()) {
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