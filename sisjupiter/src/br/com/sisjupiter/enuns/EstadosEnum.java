package br.com.sisjupiter.enuns;

import java.util.ArrayList;
import java.util.List;

public enum EstadosEnum {
	
	ACRE("AC", "Acre"),
	ALAGOAS("AL", "Alagoas"),
	AMAPA("AP", "Amapa"),
	AMAZONAS("AM", "Amazonas"),
	BAHIA("BA", "Bahia"),
	CEARA("CE", "Ceara"),
	DISTRITO_FEDERAL("DF", "Distrito Federal"),
	ESPIRITO_SANTO("ES", "Espirito Santo"),
	GOIAS("GO", "Goias"),
	MARANHAO("MA", "Maranhao"),
	MATO_GROSSO("MT", "Mato Grosso"),
	MATO_GROSSO_SUL("MS", "Mato Grosso Sul"),
	MINAS_GERAIS("MG", "Minas Gerais"),
	PARA("PA", "Para"),
	PARAIBA("PB", "Paraiba"),
	PARANA("PR", "Parana"),
	PERNAMBUCO("PE", "Pernambuco"),
	PIAUI("PI", "Piaui"),
	RIO_JANEIRO("RJ", "Rio de Janeiro"),
	RIO_GRANDE_NORTE("RN", "Rio Grande do Norte"),
	RIO_GRANDE_SUL("RS", "Rio Grande do Sul"),
	RONDONIA("RO", "Rondonia"),
	RORAIMA("RR", "Roraima"),
	SANTA_CATARINA("SC", "Santa Catarina"),
	SAO_PAULO("SP", "Sao Paulo"),
	SERGIPE("SE", "Sergipe"),
	TOCANTINS("TO", "Tocantins");

	private String id;
	private String descricao;
	
	
	private EstadosEnum(String id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	
	public static List<EstadosEnum> listCodigos() {
		List<EstadosEnum> list = new ArrayList<>();
		for (EstadosEnum codigoEnum : values()) {
			list.add(codigoEnum);
		}
		return list;
	}



	public String getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}