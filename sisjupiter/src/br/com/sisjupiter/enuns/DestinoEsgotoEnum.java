package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum DestinoEsgotoEnum {
	
	REDE(1, "Rede de Esgoto"),
	FOSSA(2, "Fossa"),
	GALERIA(3, "Galeria de &Aacute;guas Pluviais"),
	CORREGO(4, "C&oacute;rrego"),
	OUTRO(5, "Outro");

	private int id;
	private String descricao;
	
	
	private DestinoEsgotoEnum(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<DestinoEsgotoEnum> listCodigos() {
		List<DestinoEsgotoEnum> list = new ArrayList<>();
		for (DestinoEsgotoEnum codigoEnum : values()) {
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