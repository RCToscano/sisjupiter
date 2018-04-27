package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum RelacaoVizinhoEnum {
	
	DIARIAMENTE(1, "Diariamente"),
	SEMANALMENTE(2, "Semanalmente"),
	MENSALMENTE(3, "Mensalmente"),
	QUASE_NUNCA_VE(4, "Quase nunca vejo os meus vizinhos"),
	NUNCA_VE(5, "Nunca vejo os meus vizinhos");

	private int id;
	private String descricao;
	
	
	private RelacaoVizinhoEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<RelacaoVizinhoEnum> listCodigos() {
		List<RelacaoVizinhoEnum> list = new ArrayList<>();
		for (RelacaoVizinhoEnum codigoEnum : values()) {
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