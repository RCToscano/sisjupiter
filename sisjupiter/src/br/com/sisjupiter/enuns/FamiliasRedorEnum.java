package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum FamiliasRedorEnum {
	
	BASTANTE_PROXIMIDADE(1, "Tem bastante proximidade entre si"),
	VIZINHANCA_NAO_UNIDA(2, "Algumas se conhecem entre si, mas n&atilde;o considero que seja uma vizinhan&ccedil;a unida"),
	POUCO_SE_CONHECEM(3, "Pouco se conhecem"),
	NAO_SE_CONHECEM(4, "N&atilde;o se conhecem");

	private int id;
	private String descricao;
	
	
	private FamiliasRedorEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<FamiliasRedorEnum> listCodigos() {
		List<FamiliasRedorEnum> list = new ArrayList<>();
		for (FamiliasRedorEnum codigoEnum : values()) {
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