package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum SituacaoImovelEnum {
	
	VAGO(1, "Vago"),
	DEMOLIDO(2, "Demolido"),
	MORADOR_AUSENTE(3, "Morador Ausente"),
	EM_CONSTRUCAO(4, "Em Constru&ccedil;&atilde;o");

	private int id;
	private String descricao;
	
	
	private SituacaoImovelEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<SituacaoImovelEnum> listCodigos() {
		List<SituacaoImovelEnum> list = new ArrayList<>();
		for (SituacaoImovelEnum codigoEnum : values()) {
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