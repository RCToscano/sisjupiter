package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum TipoUsoImovelEnum {
	
	PROPRIO(1, "Pr&oacute;prio"),
	ALUGADO(2, "Alugado");

	private int id;
	private String descricao;
	
	
	private TipoUsoImovelEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<TipoUsoImovelEnum> listCodigos() {
		List<TipoUsoImovelEnum> list = new ArrayList<>();
		for (TipoUsoImovelEnum codigoEnum : values()) {
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