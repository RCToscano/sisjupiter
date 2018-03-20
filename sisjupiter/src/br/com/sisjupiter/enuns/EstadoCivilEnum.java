package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum EstadoCivilEnum {
	
	CASADO(1, "Casado"),
	VIUVO(2, "Vi&uacute;vo"),
	SOLTEIRO(3, "Solteiro"),
	DIVORCIADO(4, "Divorciado");

	private int id;
	private String descricao;
	
	
	private EstadoCivilEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<EstadoCivilEnum> listCodigos() {
		List<EstadoCivilEnum> list = new ArrayList<>();
		for (EstadoCivilEnum codigoEnum : values()) {
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