package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum TipoInstalacaoEnum {
	
	REGULAR(1, "Regular"),
	CLANDESTINA(2, "Clandestina"),
	MISTA(3, "Mista");

	private int id;
	private String descricao;
	
	
	private TipoInstalacaoEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<TipoInstalacaoEnum> listCodigos() {
		List<TipoInstalacaoEnum> list = new ArrayList<>();
		for (TipoInstalacaoEnum codigoEnum : values()) {
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