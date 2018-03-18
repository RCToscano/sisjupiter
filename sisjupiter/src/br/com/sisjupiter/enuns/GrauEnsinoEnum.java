package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum GrauEnsinoEnum {
	
	ENSINO_FUNDAMENTAL(1, "Ensino Fundamental"),
	ENSINO_MEDIO(2, "Ensino M&eacute;dio"),
	CURSO_TECNICO(3, "Especializa&ccedil;&atilde;o (Cursos T&eacute;cnicos)"),
	ENSINO_SUPEIOR(4, "Ensino Superior"),
	POS_GRADUACAO(5, "P&oacute;s Gradua&ccedil;&atilde;o"),
	N_ALFABETIZADO(6, "NN&atilde;o Alfabetizado");

	private int id;
	private String descricao;
	
	
	private GrauEnsinoEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<GrauEnsinoEnum> listCodigos() {
		List<GrauEnsinoEnum> list = new ArrayList<>();
		for (GrauEnsinoEnum codigoEnum : values()) {
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