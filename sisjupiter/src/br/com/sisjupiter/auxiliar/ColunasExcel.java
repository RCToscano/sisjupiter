package br.com.sisjupiter.auxiliar;

import java.util.ArrayList;
import java.util.List;

public class ColunasExcel {
	
//	@SuppressWarnings("serial")
//	private List<String> colunasDiagnostico = new ArrayList<String>(){{
//		add("ID_DIAGNOSTICO"); add("ID_COMUNIDADE"); add("COMUNIDADE"); add("DATA_DIAGNOS");
//		add("DATA_INSERT"); add("ID_EQUIPE"); add("EXECUTOR"); add("ID_USER"); add("SITUACAO_IMOVEL"); add("TIPO_CONTRUCAO"); add("TIPO_INSTALACAO");
//		add("RESIDENCIA"); add("COMERCIO"); add("INDUSTRIA"); add("PUBLICA"); add("USO_IMOVEL"); add("QTDE_CASAS"); add("TEMPO_OCUPACAO"); add("ATIVIDADE");
//		add("ENERGIA_ELETRICA"); add("ENERGIA_ELETRICA_IRREG"); add("INSTALACAO"); add("MEDIDOR"); add("PAVIMENTACAO"); add("COLETA_LIXO");
//		add("ABASTEC_AGUA"); add("ABASTEC_AGUA_IRREG"); add("HIDROMETRO"); add("DESTINO_ESGOTO"); add("CLIENTE"); add("CPF"); add("RG");
//		add("NACIONALIDADE"); add("UF_NASC"); add("MUN_NASC"); add("DTNASC"); add("SEXO"); add("TELRES"); add("TELCEL"); add("ESTADO_CIVIL"); add("EMAIL");
//		add("ENDERECO"); add("NUMATUAL"); add("NUMANTIGO"); add("COMPL"); add("BAIRRO"); add("MUN"); add("UF"); add("CEP"); add("QTDE_ADULTO"); add("QTDE_CRIANCA");
//		add("TEM_CONTA"); add("BANCO"); add("TEM_CARTAO_DEBITO"); add("RENDATOTAL"); add("COMPRO_FINANC"); add("TRANSP_CARRO_PROPRIO");
//		add("TRANSP_ONIBUS"); add("TRANSP_TREM"); add("TRANSP_METRO"); add("TRANSP_TAXI"); add("ACESSO_INTERNET"); add("WIFI"); add("3G");
//		add("QTDE_CARRO"); add("QTDE_MOTO"); add("QTDE_BICICLETA"); add("BENEF_BCPNUM"); add("BENEF_NISNUM"); add("TARIFA_SOCIAL");
//		add("BOLSA_FAMILIA"); add("BENEF_NOME"); add("BENEF_CPF"); add("BENEF_RG"); add("BENEF_SEXO"); add("BENEF_DTNASC"); add("BENEF_OBS");
//		add("60_ANOS_OU_MAIOR"); add("18_ANOS_OU_MENOR"); add("MENOR_1_ANO"); add("QTDE_DEF_VISUAL"); add("QTDE_DEF_AUDITIVO");
//		add("QTDE_DEF_FISICO"); add("QTDE_DEF_INTELECT"); add("QTDE_DEF_OUTROS"); add("TRATA_CANCER"); add("TRATA_TUBERCULOSE");
//		add("TRATA_HANSEN"); add("TRATA_ALIE_MENTAL"); add("TRATA_ESCLEROSE"); add("TRATA_PARALISIA"); add("TRATA_HEPATITE");
//		add("TRATA_CARDIACO"); add("TRATA_PARKINSON"); add("TRATA_RENAL"); add("TRATA_OUTRO"); add("TRAT_OUTRO_DESC"); add("MEMBRO_AMEBIASE");
//		add("MEMBRO_AMEBIASE_PARENT"); add("MEMBRO_GASTRO"); add("MEMBRO_GASTRO_PARENT"); add("MEMBRO_GIARDIASE");
//		add("MEMBRO_GIARDIASE_PARENT"); add("MEMBRO_FEBRE_TIFOIDE"); add("MEMBRO_FEBRE_TIFOIDE_PARENT"); add("MEMBRO_HEPATITE");
//		add("MEMBRO_HEPATITE_PARENT"); add("MEMBRO_COLERA"); add("MEMBRO_COLERA_PARENT"); add("MEMBRO_ESQUITOSSO");
//		add("MEMBRO_ESQUITOSSO_PARENT"); add("MEMBRO_ASCARIDIASE"); add("MEMBRO_ASCARIDIASE_PARENT"); add("MEMBRO_TENIASE");
//		add("MEMBRO_TENIASE_PARENT"); add("MEMBRO_LEPTOSPIROSE"); add("MEMBRO_LEPTOSPIROSE_PARENT"); add("MEMBRO_MALARIA");
//		add("MEMBRO_MALARIA_PARENT"); add("MEMBRO_DENGUE"); add("MEMBRO_DENGUE_PARENT"); add("MEMBRO_FEBREAMAR");
//		add("MEMBRO_FEBREAMAR_PARENT"); add("MEMBRO_CHIKUNG"); add("MEMBRO_CHIKUNG_PARENT"); add("MEMBRO_ZICAVIRUS");
//		add("MEMBRO_ZICAVIRUS_PARENT"); add("MEMBRO_CIANOBACTER"); add("MEMBRO_CIANOBACTER_PARENT"); add("VAL_DOACAO"); add("VAL_APOSENT");
//		add("VAL_PENSAO_ALIMEN"); add("VAL_SEG_DESEMPR"); add("VAL_EMPR_INFORMAL"); add("VAL_EMPR_FORMAL"); add("VAL_BOLSA_FAMIL");
//		add("VAL_OUTRO"); add("VAL_OUTR_DESCR"); add("GRAU_ESCOLAR"); add("GRAU_ESCOLAR_COMPL"); add("SABE_ESCREVER"); add("SABE_LER");
//		add("PROFISSAO_RESP_FAMILIA"); add("NEGOCIACAO_DEB_ENERGIA"); add("VALOR_PARCELA_ENERG"); add("QTDE_PARCELA_ENERG");
//		add("VENC_PARCELA_ENERG"); add("NEGOCIACAO_DEB_AGUA"); add("VALOR_PARCELA_AGUA"); add("QTDE_PARCELA_AGUA"); add("VENC_PARCELA_AGUA");
//		add("CONHEC_OBRA_SANEAM"); add("BENEF_SANEA_PREV_DOENCA"); add("BENEF_SANEA_FORTAL_ECONO"); add("BENEF_SANEA_VALORI_IMOB");
//		add("BENEF_SANEA_VALOR_TURISM"); add("OBS_GERAIS"); add("MORADORES"); add("RESP_CASA_NOME1"); add("RESP_CASA_TEL1");
//		add("RESP_CASA_NOME2"); add("RESP_CASA_TEL2"); add("VIZINHO_NOME1"); add("VIZINHO_TEL1"); add("VIZINHO_NOME2"); add("VIZINHO_TEL2");
//		add("CONTATO_ALTERN_NOME1"); add("CONTATO_ALTERN_TEL1"); add("CONTATO_ALTERN_NOME2"); add("CONTATO_ALTERN_TEL2");
//		add("CONTATO_PROF_NOME1"); add("CONTATO_PROF_TE1"); add("CONTATO_PROF_NOME2"); add("CONTATO_PROF_TE2"); add("EQUIP_PUBLICO");
//		add("RELACAOVIZ"); add("REL_RECOR_VIZINHO"); add("REL_RECOR_VIZINHO_FREQ"); add("CONSIDERACOES_FAMILIAS_AO_REDOR");
//		add("HOSPITAL_NOME"); add("REF_NOME"); add("COORDX"); add("COORDY"); add("COORDXDIAG"); add("COORDYDIAG");
//	}};
	
	@SuppressWarnings("serial")
	private List<String> colunasDiagnostico = new ArrayList<String>(){{
		add("ID_DIAGNOSTICO"); add("ID_COMUNIDADE"); add("COMUNIDADE"); add("DATA_DIAGNOS");
		add("DATA_INSERT"); add("ID_EQUIPE"); add("EXECUTOR"); add("ID_USER"); 
		add("CLIENTE"); add("CPF"); add("RG");
		add("ENDERECO"); add("NUMATUAL"); add("NUMANTIGO"); add("COMPL"); add("BAIRRO"); add("MUN"); add("UF"); add("CEP"); 
		add("MORADORES"); add("RESP_CASA_NOME1"); add("RESP_CASA_TEL1");
		add("RESP_CASA_NOME2"); add("RESP_CASA_TEL2"); add("VIZINHO_NOME1"); add("VIZINHO_TEL1"); add("VIZINHO_NOME2"); add("VIZINHO_TEL2");
		add("CONTATO_ALTERN_NOME1"); add("CONTATO_ALTERN_TEL1"); add("CONTATO_ALTERN_NOME2"); add("CONTATO_ALTERN_TEL2");
		add("CONTATO_PROF_NOME1"); add("CONTATO_PROF_TE1"); add("CONTATO_PROF_NOME2"); add("CONTATO_PROF_TE2"); add("EQUIP_PUBLICO");
		add("RELACAOVIZ"); add("REL_RECOR_VIZINHO"); add("REL_RECOR_VIZINHO_FREQ"); add("CONSIDERACOES_FAMILIAS_AO_REDOR");
		add("HOSPITAL_NOME"); add("REF_NOME"); add("COORDX"); add("COORDY"); add("COORDXDIAG"); add("COORDYDIAG");
	}};

	@SuppressWarnings("serial")
	private List<String> colunasRelatorioComunidade = new ArrayList<String>(){{
	    add("Nº");
	    add("COMUNIDADE");
	    add("QUANTIDADE");
	}};
	
	@SuppressWarnings("serial")
	private List<String> colunasRelatorioEquipe = new ArrayList<String>(){{
		add("Nº");
		add("EQUIPE");
		add("QUANTIDADE");
	}};
	
	
	
	public List<String> getColunasDiagnostico() {
		return colunasDiagnostico;
	}

	public List<String> getColunasRelatorioComunidade() {
		return colunasRelatorioComunidade;
	}

	public List<String> getColunasRelatorioEquipe() {
		return colunasRelatorioEquipe;
	}

	
}
