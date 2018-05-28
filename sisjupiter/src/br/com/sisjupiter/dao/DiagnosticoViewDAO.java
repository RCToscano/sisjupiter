package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.andsisjupiter.modelo.DiagnosticoView;

public class DiagnosticoViewDAO {
	
	Connection connection = null;

    public DiagnosticoViewDAO(Connection connection) {
        this.connection = connection;
    }
    
    public DiagnosticoView buscarViewPorId(String idDiagnostico) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
            "SELECT    VW_DIAGNOSTICO.* " +
            "FROM      VW_DIAGNOSTICO " +
            "WHERE     VW_DIAGNOSTICO.ID_DIAGNOSTICO = ? "
            );

            stmt.setObject(1, idDiagnostico);
            rs = stmt.executeQuery();

            DiagnosticoView diagnosticoView = null;
            if(rs.next()) {
            	diagnosticoView = new DiagnosticoView();
            	
            	diagnosticoView.setId_diagnostico(rs.getString("ID_DIAGNOSTICO"));
            	diagnosticoView.setId_comunidade(rs.getString("ID_COMUNIDADE"));
            	diagnosticoView.setComunidade(rs.getString("COMUNIDADE"));
            	diagnosticoView.setData_diagnos(rs.getString("DATA_DIAGNOS"));
            	diagnosticoView.setData_insert(rs.getString("DATA_INSERT"));
            	diagnosticoView.setId_equipe(rs.getString("ID_EQUIPE"));
            	diagnosticoView.setExecutor(rs.getString("EXECUTOR"));
            	diagnosticoView.setId_user(rs.getString("ID_USER"));
            	diagnosticoView.setSituacao_imovel(rs.getString("SITUACAO_IMOVEL"));
            	diagnosticoView.setTipo_contrucao(rs.getString("TIPO_CONTRUCAO"));
            	diagnosticoView.setTipo_instalacao(rs.getString("TIPO_INSTALACAO"));
            	diagnosticoView.setResidencia(rs.getString("RESIDENCIA"));
            	diagnosticoView.setComercio(rs.getString("COMERCIO"));
            	diagnosticoView.setIndustria(rs.getString("INDUSTRIA"));
            	diagnosticoView.setPublica(rs.getString("PUBLICA"));
            	diagnosticoView.setUso_imovel(rs.getString("USO_IMOVEL"));
            	diagnosticoView.setQtde_casas(rs.getString("QTDE_CASAS"));
            	diagnosticoView.setTempo_ocupacao(rs.getString("TEMPO_OCUPACAO"));
            	diagnosticoView.setAtividade(rs.getString("ATIVIDADE"));
            	diagnosticoView.setEnergia_eletrica(rs.getString("ENERGIA_ELETRICA"));
            	diagnosticoView.setEnergia_eletrica_irreg(rs.getString("ENERGIA_ELETRICA_IRREG"));
            	diagnosticoView.setInstalacao(rs.getString("INSTALACAO"));
            	diagnosticoView.setMedidor(rs.getString("MEDIDOR"));
            	diagnosticoView.setPavimentacao(rs.getString("PAVIMENTACAO"));
            	diagnosticoView.setColeta_lixo(rs.getString("COLETA_LIXO"));
            	diagnosticoView.setAbastec_agua(rs.getString("ABASTEC_AGUA"));
            	diagnosticoView.setAbastec_agua_irreg(rs.getString("ABASTEC_AGUA_IRREG"));
            	diagnosticoView.setHidrometro(rs.getString("HIDROMETRO"));
            	diagnosticoView.setDestino_esgoto(rs.getString("DESTINO_ESGOTO"));
            	diagnosticoView.setCliente(rs.getString("CLIENTE"));
            	diagnosticoView.setCpf(rs.getString("CPF"));
            	diagnosticoView.setRg(rs.getString("RG"));
            	diagnosticoView.setNacionalidade(rs.getString("NACIONALIDADE"));
            	diagnosticoView.setUf_nasc(rs.getString("UF_NASC"));
            	diagnosticoView.setMun_nasc(rs.getString("MUN_NASC"));
            	diagnosticoView.setDtnasc(rs.getString("DTNASC"));
            	diagnosticoView.setSexo(rs.getString("SEXO"));
            	diagnosticoView.setTelres(rs.getString("TELRES"));
            	diagnosticoView.setTelcel(rs.getString("TELCEL"));
            	diagnosticoView.setEstado_civil(rs.getString("ESTADO_CIVIL"));
            	diagnosticoView.setEmail(rs.getString("EMAIL"));
            	diagnosticoView.setEndereco(rs.getString("ENDERECO"));
            	diagnosticoView.setNumatual(rs.getString("NUMATUAL"));
            	diagnosticoView.setNumantigo(rs.getString("NUMANTIGO"));
            	diagnosticoView.setCompl(rs.getString("COMPL"));
            	diagnosticoView.setBairro(rs.getString("BAIRRO"));
            	diagnosticoView.setMun(rs.getString("MUN"));
            	diagnosticoView.setUf(rs.getString("UF"));
            	diagnosticoView.setCep(rs.getString("CEP"));
            	diagnosticoView.setQtde_adulto(rs.getString("QTDE_ADULTO"));
            	diagnosticoView.setQtde_crianca(rs.getString("QTDE_CRIANCA"));
            	diagnosticoView.setTem_conta(rs.getString("TEM_CONTA"));
            	diagnosticoView.setBanco(rs.getString("BANCO"));
            	diagnosticoView.setTem_cartao_debito(rs.getString("TEM_CARTAO_DEBITO"));
            	diagnosticoView.setRendatotal(rs.getString("RENDATOTAL"));
            	diagnosticoView.setCompro_financ(rs.getString("COMPRO_FINANC"));
            	diagnosticoView.setTransp_carro_proprio(rs.getString("TRANSP_CARRO_PROPRIO"));
            	diagnosticoView.setTransp_onibus(rs.getString("TRANSP_ONIBUS"));
            	diagnosticoView.setTransp_trem(rs.getString("TRANSP_TREM"));
            	diagnosticoView.setTransp_metro(rs.getString("TRANSP_METRO"));
            	diagnosticoView.setTransp_taxi(rs.getString("TRANSP_TAXI"));
            	diagnosticoView.setAcesso_internet(rs.getString("ACESSO_INTERNET"));
            	diagnosticoView.setWifi(rs.getString("WIFI"));
            	diagnosticoView.setInternet3g(rs.getString("3G"));
            	diagnosticoView.setQtde_carro(rs.getString("QTDE_CARRO"));
            	diagnosticoView.setQtde_moto(rs.getString("QTDE_MOTO"));
            	diagnosticoView.setQtde_bicicleta(rs.getString("QTDE_BICICLETA"));
            	diagnosticoView.setBenef_bcpnum(rs.getString("BENEF_BCPNUM"));
            	diagnosticoView.setBenef_nisnum(rs.getString("BENEF_NISNUM"));
            	diagnosticoView.setTarifa_social(rs.getString("TARIFA_SOCIAL"));
            	diagnosticoView.setBolsa_familia(rs.getString("BOLSA_FAMILIA"));
            	diagnosticoView.setBenef_nome(rs.getString("BENEF_NOME"));
            	diagnosticoView.setBenef_cpf(rs.getString("BENEF_CPF"));
            	diagnosticoView.setBenef_rg(rs.getString("BENEF_RG"));
            	diagnosticoView.setBenef_sexo(rs.getString("BENEF_SEXO"));
            	diagnosticoView.setBenef_dtnasc(rs.getString("BENEF_DTNASC"));
            	diagnosticoView.setBenef_obs(rs.getString("BENEF_OBS"));
            	diagnosticoView.setAnos60_ou_maior(rs.getString("60_ANOS_OU_MAIOR"));
            	diagnosticoView.setAnos18_ou_menor(rs.getString("18_ANOS_OU_MENOR"));
            	diagnosticoView.setMenor_1_ano(rs.getString("MENOR_1_ANO"));
            	diagnosticoView.setQtde_def_visual(rs.getString("QTDE_DEF_VISUAL"));
            	diagnosticoView.setQtde_def_auditivo(rs.getString("QTDE_DEF_AUDITIVO"));
            	diagnosticoView.setQtde_def_fisico(rs.getString("QTDE_DEF_FISICO"));
            	diagnosticoView.setQtde_def_intelect(rs.getString("QTDE_DEF_INTELECT"));
            	diagnosticoView.setQtde_def_outros(rs.getString("QTDE_DEF_OUTROS"));
            	diagnosticoView.setTrata_cancer(rs.getString("TRATA_CANCER"));
            	diagnosticoView.setTrata_tuberculose(rs.getString("TRATA_TUBERCULOSE"));
            	diagnosticoView.setTrata_hansen(rs.getString("TRATA_HANSEN"));
            	diagnosticoView.setTrata_alie_mental(rs.getString("TRATA_ALIE_MENTAL"));
            	diagnosticoView.setTrata_esclerose(rs.getString("TRATA_ESCLEROSE"));
            	diagnosticoView.setTrata_paralisia(rs.getString("TRATA_PARALISIA"));
            	diagnosticoView.setTrata_hepatite(rs.getString("TRATA_HEPATITE"));
            	diagnosticoView.setTrata_cardiaco(rs.getString("TRATA_CARDIACO"));
            	diagnosticoView.setTrata_parkinson(rs.getString("TRATA_PARKINSON"));
            	diagnosticoView.setTrata_renal(rs.getString("TRATA_RENAL"));
            	diagnosticoView.setTrata_outro(rs.getString("TRATA_OUTRO"));
            	diagnosticoView.setTrat_outro_desc(rs.getString("TRAT_OUTRO_DESC"));
            	diagnosticoView.setMembro_amebiase(rs.getString("MEMBRO_AMEBIASE"));
            	diagnosticoView.setMembro_amebiase_parent(rs.getString("MEMBRO_AMEBIASE_PARENT"));
            	diagnosticoView.setMembro_gastro(rs.getString("MEMBRO_GASTRO"));
            	diagnosticoView.setMembro_gastro_parent(rs.getString("MEMBRO_GASTRO_PARENT"));
            	diagnosticoView.setMembro_giardiase(rs.getString("MEMBRO_GIARDIASE"));
            	diagnosticoView.setMembro_giardiase_parent(rs.getString("MEMBRO_GIARDIASE_PARENT"));
            	diagnosticoView.setMembro_febre_tifoide(rs.getString("MEMBRO_FEBRE_TIFOIDE"));
            	diagnosticoView.setMembro_febre_tifoide_parent(rs.getString("MEMBRO_FEBRE_TIFOIDE_PARENT"));
            	diagnosticoView.setMembro_hepatite(rs.getString("MEMBRO_HEPATITE"));
            	diagnosticoView.setMembro_hepatite_parent(rs.getString("MEMBRO_HEPATITE_PARENT"));
            	diagnosticoView.setMembro_colera(rs.getString("MEMBRO_COLERA"));
            	diagnosticoView.setMembro_colera_parent(rs.getString("MEMBRO_COLERA_PARENT"));
            	diagnosticoView.setMembro_esquitosso(rs.getString("MEMBRO_ESQUITOSSO"));
            	diagnosticoView.setMembro_esquitosso_parent(rs.getString("MEMBRO_ESQUITOSSO_PARENT"));
            	diagnosticoView.setMembro_ascaridiase(rs.getString("MEMBRO_ASCARIDIASE"));
            	diagnosticoView.setMembro_ascaridiase_parent(rs.getString("MEMBRO_ASCARIDIASE_PARENT"));
            	diagnosticoView.setMembro_teniase(rs.getString("MEMBRO_TENIASE"));
            	diagnosticoView.setMembro_teniase_parent(rs.getString("MEMBRO_TENIASE_PARENT"));
            	diagnosticoView.setMembro_leptospirose(rs.getString("MEMBRO_LEPTOSPIROSE"));
            	diagnosticoView.setMembro_leptospirose_parent(rs.getString("MEMBRO_LEPTOSPIROSE_PARENT"));
            	diagnosticoView.setMembro_malaria(rs.getString("MEMBRO_MALARIA"));
            	diagnosticoView.setMembro_malaria_parent(rs.getString("MEMBRO_MALARIA_PARENT"));
            	diagnosticoView.setMembro_dengue(rs.getString("MEMBRO_DENGUE"));
            	diagnosticoView.setMembro_dengue_parent(rs.getString("MEMBRO_DENGUE_PARENT"));
            	diagnosticoView.setMembro_febreamar(rs.getString("MEMBRO_FEBREAMAR"));
            	diagnosticoView.setMembro_febreamar_parent(rs.getString("MEMBRO_FEBREAMAR_PARENT"));
            	diagnosticoView.setMembro_chikung(rs.getString("MEMBRO_CHIKUNG"));
            	diagnosticoView.setMembro_chikung_parent(rs.getString("MEMBRO_CHIKUNG_PARENT"));
            	diagnosticoView.setMembro_zicavirus(rs.getString("MEMBRO_ZICAVIRUS"));
            	diagnosticoView.setMembro_zicavirus_parent(rs.getString("MEMBRO_ZICAVIRUS_PARENT"));
            	diagnosticoView.setMembro_cianobacter(rs.getString("MEMBRO_CIANOBACTER"));
            	diagnosticoView.setMembro_cianobacter_parent(rs.getString("MEMBRO_CIANOBACTER_PARENT"));
            	diagnosticoView.setVal_doacao(rs.getString("VAL_DOACAO"));
            	diagnosticoView.setVal_aposent(rs.getString("VAL_APOSENT"));
            	diagnosticoView.setVal_pensao_alimen(rs.getString("VAL_PENSAO_ALIMEN"));
            	diagnosticoView.setVal_seg_desempr(rs.getString("VAL_SEG_DESEMPR"));
            	diagnosticoView.setVal_empr_informal(rs.getString("VAL_EMPR_INFORMAL"));
            	diagnosticoView.setVal_empr_formal(rs.getString("VAL_EMPR_FORMAL"));
            	diagnosticoView.setVal_bolsa_famil(rs.getString("VAL_BOLSA_FAMIL"));
            	diagnosticoView.setVal_outro(rs.getString("VAL_OUTRO"));
            	diagnosticoView.setVal_outr_descr(rs.getString("VAL_OUTR_DESCR"));
            	diagnosticoView.setGrau_escolar(rs.getString("GRAU_ESCOLAR"));
            	diagnosticoView.setGrau_escolar_compl(rs.getString("GRAU_ESCOLAR_COMPL"));
            	diagnosticoView.setSabe_escrever(rs.getString("SABE_ESCREVER"));
            	diagnosticoView.setSabe_ler(rs.getString("SABE_LER"));
            	diagnosticoView.setProfissao_resp_familia(rs.getString("PROFISSAO_RESP_FAMILIA"));
            	diagnosticoView.setNegociacao_deb_energia(rs.getString("NEGOCIACAO_DEB_ENERGIA"));
            	diagnosticoView.setValor_parcela_energ(rs.getString("VALOR_PARCELA_ENERG"));
            	diagnosticoView.setQtde_parcela_energ(rs.getString("QTDE_PARCELA_ENERG"));
            	diagnosticoView.setVenc_parcela_energ(rs.getString("VENC_PARCELA_ENERG"));
            	diagnosticoView.setNegociacao_deb_agua(rs.getString("NEGOCIACAO_DEB_AGUA"));
            	diagnosticoView.setValor_parcela_agua(rs.getString("VALOR_PARCELA_AGUA"));
            	diagnosticoView.setQtde_parcela_agua(rs.getString("QTDE_PARCELA_AGUA"));
            	diagnosticoView.setVenc_parcela_agua(rs.getString("VENC_PARCELA_AGUA"));
            	diagnosticoView.setConhec_obra_saneam(rs.getString("CONHEC_OBRA_SANEAM"));
            	diagnosticoView.setBenef_sanea_prev_doenca(rs.getString("BENEF_SANEA_PREV_DOENCA"));
            	diagnosticoView.setBenef_sanea_fortal_econo(rs.getString("BENEF_SANEA_FORTAL_ECONO"));
            	diagnosticoView.setBenef_sanea_valori_imob(rs.getString("BENEF_SANEA_VALORI_IMOB"));
            	diagnosticoView.setBenef_sanea_valor_turism(rs.getString("BENEF_SANEA_VALOR_TURISM"));
            	diagnosticoView.setObs_gerais(rs.getString("OBS_GERAIS"));
            	diagnosticoView.setMoradores(rs.getString("MORADORES"));
            	diagnosticoView.setResp_casa_nome1(rs.getString("RESP_CASA_NOME1"));
            	diagnosticoView.setResp_casa_tel1(rs.getString("RESP_CASA_TEL1"));
            	diagnosticoView.setResp_casa_nome2(rs.getString("RESP_CASA_NOME2"));
            	diagnosticoView.setResp_casa_tel2(rs.getString("RESP_CASA_TEL2"));
            	diagnosticoView.setVizinho_nome1(rs.getString("VIZINHO_NOME1"));
            	diagnosticoView.setVizinho_tel1(rs.getString("VIZINHO_TEL1"));
            	diagnosticoView.setVizinho_nome2(rs.getString("VIZINHO_NOME2"));
            	diagnosticoView.setVizinho_tel2(rs.getString("VIZINHO_TEL2"));
            	diagnosticoView.setContato_altern_nome1(rs.getString("CONTATO_ALTERN_NOME1"));
            	diagnosticoView.setContato_altern_tel1(rs.getString("CONTATO_ALTERN_TEL1"));
            	diagnosticoView.setContato_altern_nome2(rs.getString("CONTATO_ALTERN_NOME2"));
            	diagnosticoView.setContato_altern_tel2(rs.getString("CONTATO_ALTERN_TEL2"));
            	diagnosticoView.setContato_prof_nome1(rs.getString("CONTATO_PROF_NOME1"));
            	diagnosticoView.setContato_prof_te1(rs.getString("CONTATO_PROF_TE1"));
            	diagnosticoView.setContato_prof_nome2(rs.getString("CONTATO_PROF_NOME2"));
            	diagnosticoView.setContato_prof_te2(rs.getString("CONTATO_PROF_TE2"));
            	diagnosticoView.setEquip_publico(rs.getString("EQUIP_PUBLICO"));
            	diagnosticoView.setRelacaoviz(rs.getString("RELACAOVIZ"));
            	diagnosticoView.setRel_recor_vizinho(rs.getString("REL_RECOR_VIZINHO"));
            	diagnosticoView.setRel_recor_vizinho_freq(rs.getString("REL_RECOR_VIZINHO_FREQ"));
            	diagnosticoView.setConsideracoes_familias_ao_redor(rs.getString("CONSIDERACOES_FAMILIAS_AO_REDOR"));
            	diagnosticoView.setHospital_nome(rs.getString("HOSPITAL_NOME"));
            	diagnosticoView.setRef_nome(rs.getString("REF_NOME"));
            	diagnosticoView.setCoordx(rs.getString("COORDX"));
            	diagnosticoView.setCoordy(rs.getString("COORDY"));
            	diagnosticoView.setCoordxdiag(rs.getString("COORDXDIAG"));
            	diagnosticoView.setCoordydiag(rs.getString("COORDYDIAG"));
            }
            return diagnosticoView;
        }
        finally {
            if(stmt != null)
                stmt.close();
            if(rs != null)
                rs.close();
        }
    }
    
    public List<List<String>> buscarPorId(String idDiagnostico) throws Exception {
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	try {
    		stmt = connection.prepareStatement(
    				"SELECT    VW_DIAGNOSTICO.* " +
    						"FROM      VW_DIAGNOSTICO " +
    						"WHERE     VW_DIAGNOSTICO.ID_DIAGNOSTICO = ? "
    				);
    		
    		stmt.setObject(1, idDiagnostico);
    		rs = stmt.executeQuery();
    		
    		List<List<String>> listaTotal = new ArrayList<>();
    		if(rs.next()) {
    			List<String> diagnosticoView = new ArrayList<String>();
    			diagnosticoView.add(rs.getString("ID_DIAGNOSTICO"));
    			diagnosticoView.add(rs.getString("ID_COMUNIDADE"));
    			diagnosticoView.add(rs.getString("COMUNIDADE"));
    			diagnosticoView.add(rs.getString("DATA_DIAGNOS"));
    			diagnosticoView.add(rs.getString("DATA_INSERT"));
    			diagnosticoView.add(rs.getString("ID_EQUIPE"));
    			diagnosticoView.add(rs.getString("EXECUTOR"));
    			diagnosticoView.add(rs.getString("ID_USER"));
    			diagnosticoView.add(rs.getString("SITUACAO_IMOVEL"));
    			diagnosticoView.add(rs.getString("TIPO_CONTRUCAO"));
    			diagnosticoView.add(rs.getString("TIPO_INSTALACAO"));
    			diagnosticoView.add(rs.getString("RESIDENCIA"));
    			diagnosticoView.add(rs.getString("COMERCIO"));
    			diagnosticoView.add(rs.getString("INDUSTRIA"));
    			diagnosticoView.add(rs.getString("PUBLICA"));
    			diagnosticoView.add(rs.getString("USO_IMOVEL"));
    			diagnosticoView.add(rs.getString("QTDE_CASAS"));
    			diagnosticoView.add(rs.getString("TEMPO_OCUPACAO"));
    			diagnosticoView.add(rs.getString("ATIVIDADE"));
    			diagnosticoView.add(rs.getString("ENERGIA_ELETRICA"));
    			diagnosticoView.add(rs.getString("ENERGIA_ELETRICA_IRREG"));
    			diagnosticoView.add(rs.getString("INSTALACAO"));
    			diagnosticoView.add(rs.getString("MEDIDOR"));
    			diagnosticoView.add(rs.getString("PAVIMENTACAO"));
    			diagnosticoView.add(rs.getString("COLETA_LIXO"));
    			diagnosticoView.add(rs.getString("ABASTEC_AGUA"));
    			diagnosticoView.add(rs.getString("ABASTEC_AGUA_IRREG"));
    			diagnosticoView.add(rs.getString("HIDROMETRO"));
    			diagnosticoView.add(rs.getString("DESTINO_ESGOTO"));
    			diagnosticoView.add(rs.getString("CLIENTE"));
    			diagnosticoView.add(rs.getString("CPF"));
    			diagnosticoView.add(rs.getString("RG"));
    			diagnosticoView.add(rs.getString("NACIONALIDADE"));
    			diagnosticoView.add(rs.getString("UF_NASC"));
    			diagnosticoView.add(rs.getString("MUN_NASC"));
    			diagnosticoView.add(rs.getString("DTNASC"));
    			diagnosticoView.add(rs.getString("SEXO"));
    			diagnosticoView.add(rs.getString("TELRES"));
    			diagnosticoView.add(rs.getString("TELCEL"));
    			diagnosticoView.add(rs.getString("ESTADO_CIVIL"));
    			diagnosticoView.add(rs.getString("EMAIL"));
    			diagnosticoView.add(rs.getString("ENDERECO"));
    			diagnosticoView.add(rs.getString("NUMATUAL"));
    			diagnosticoView.add(rs.getString("NUMANTIGO"));
    			diagnosticoView.add(rs.getString("COMPL"));
    			diagnosticoView.add(rs.getString("BAIRRO"));
    			diagnosticoView.add(rs.getString("MUN"));
    			diagnosticoView.add(rs.getString("UF"));
    			diagnosticoView.add(rs.getString("CEP"));
    			diagnosticoView.add(rs.getString("QTDE_ADULTO"));
    			diagnosticoView.add(rs.getString("QTDE_CRIANCA"));
    			diagnosticoView.add(rs.getString("TEM_CONTA"));
    			diagnosticoView.add(rs.getString("BANCO"));
    			diagnosticoView.add(rs.getString("TEM_CARTAO_DEBITO"));
    			diagnosticoView.add(rs.getString("RENDATOTAL"));
    			diagnosticoView.add(rs.getString("COMPRO_FINANC"));
    			diagnosticoView.add(rs.getString("TRANSP_CARRO_PROPRIO"));
    			diagnosticoView.add(rs.getString("TRANSP_ONIBUS"));
    			diagnosticoView.add(rs.getString("TRANSP_TREM"));
    			diagnosticoView.add(rs.getString("TRANSP_METRO"));
    			diagnosticoView.add(rs.getString("TRANSP_TAXI"));
    			diagnosticoView.add(rs.getString("ACESSO_INTERNET"));
    			diagnosticoView.add(rs.getString("WIFI"));
    			diagnosticoView.add(rs.getString("3G"));
    			diagnosticoView.add(rs.getString("QTDE_CARRO"));
    			diagnosticoView.add(rs.getString("QTDE_MOTO"));
    			diagnosticoView.add(rs.getString("QTDE_BICICLETA"));
    			diagnosticoView.add(rs.getString("BENEF_BCPNUM"));
    			diagnosticoView.add(rs.getString("BENEF_NISNUM"));
    			diagnosticoView.add(rs.getString("TARIFA_SOCIAL"));
    			diagnosticoView.add(rs.getString("BOLSA_FAMILIA"));
    			diagnosticoView.add(rs.getString("BENEF_NOME"));
    			diagnosticoView.add(rs.getString("BENEF_CPF"));
    			diagnosticoView.add(rs.getString("BENEF_RG"));
    			diagnosticoView.add(rs.getString("BENEF_SEXO"));
    			diagnosticoView.add(rs.getString("BENEF_DTNASC"));
    			diagnosticoView.add(rs.getString("BENEF_OBS"));
    			diagnosticoView.add(rs.getString("60_ANOS_OU_MAIOR"));
    			diagnosticoView.add(rs.getString("18_ANOS_OU_MENOR"));
    			diagnosticoView.add(rs.getString("MENOR_1_ANO"));
    			diagnosticoView.add(rs.getString("QTDE_DEF_VISUAL"));
    			diagnosticoView.add(rs.getString("QTDE_DEF_AUDITIVO"));
    			diagnosticoView.add(rs.getString("QTDE_DEF_FISICO"));
    			diagnosticoView.add(rs.getString("QTDE_DEF_INTELECT"));
    			diagnosticoView.add(rs.getString("QTDE_DEF_OUTROS"));
    			diagnosticoView.add(rs.getString("TRATA_CANCER"));
    			diagnosticoView.add(rs.getString("TRATA_TUBERCULOSE"));
    			diagnosticoView.add(rs.getString("TRATA_HANSEN"));
    			diagnosticoView.add(rs.getString("TRATA_ALIE_MENTAL"));
    			diagnosticoView.add(rs.getString("TRATA_ESCLEROSE"));
    			diagnosticoView.add(rs.getString("TRATA_PARALISIA"));
    			diagnosticoView.add(rs.getString("TRATA_HEPATITE"));
    			diagnosticoView.add(rs.getString("TRATA_CARDIACO"));
    			diagnosticoView.add(rs.getString("TRATA_PARKINSON"));
    			diagnosticoView.add(rs.getString("TRATA_RENAL"));
    			diagnosticoView.add(rs.getString("TRATA_OUTRO"));
    			diagnosticoView.add(rs.getString("TRAT_OUTRO_DESC"));
    			diagnosticoView.add(rs.getString("MEMBRO_AMEBIASE"));
    			diagnosticoView.add(rs.getString("MEMBRO_AMEBIASE_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_GASTRO"));
    			diagnosticoView.add(rs.getString("MEMBRO_GASTRO_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_GIARDIASE"));
    			diagnosticoView.add(rs.getString("MEMBRO_GIARDIASE_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_FEBRE_TIFOIDE"));
    			diagnosticoView.add(rs.getString("MEMBRO_FEBRE_TIFOIDE_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_HEPATITE"));
    			diagnosticoView.add(rs.getString("MEMBRO_HEPATITE_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_COLERA"));
    			diagnosticoView.add(rs.getString("MEMBRO_COLERA_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_ESQUITOSSO"));
    			diagnosticoView.add(rs.getString("MEMBRO_ESQUITOSSO_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_ASCARIDIASE"));
    			diagnosticoView.add(rs.getString("MEMBRO_ASCARIDIASE_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_TENIASE"));
    			diagnosticoView.add(rs.getString("MEMBRO_TENIASE_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_LEPTOSPIROSE"));
    			diagnosticoView.add(rs.getString("MEMBRO_LEPTOSPIROSE_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_MALARIA"));
    			diagnosticoView.add(rs.getString("MEMBRO_MALARIA_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_DENGUE"));
    			diagnosticoView.add(rs.getString("MEMBRO_DENGUE_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_FEBREAMAR"));
    			diagnosticoView.add(rs.getString("MEMBRO_FEBREAMAR_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_CHIKUNG"));
    			diagnosticoView.add(rs.getString("MEMBRO_CHIKUNG_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_ZICAVIRUS"));
    			diagnosticoView.add(rs.getString("MEMBRO_ZICAVIRUS_PARENT"));
    			diagnosticoView.add(rs.getString("MEMBRO_CIANOBACTER"));
    			diagnosticoView.add(rs.getString("MEMBRO_CIANOBACTER_PARENT"));
    			diagnosticoView.add(rs.getString("VAL_DOACAO"));
    			diagnosticoView.add(rs.getString("VAL_APOSENT"));
    			diagnosticoView.add(rs.getString("VAL_PENSAO_ALIMEN"));
    			diagnosticoView.add(rs.getString("VAL_SEG_DESEMPR"));
    			diagnosticoView.add(rs.getString("VAL_EMPR_INFORMAL"));
    			diagnosticoView.add(rs.getString("VAL_EMPR_FORMAL"));
    			diagnosticoView.add(rs.getString("VAL_BOLSA_FAMIL"));
    			diagnosticoView.add(rs.getString("VAL_OUTRO"));
    			diagnosticoView.add(rs.getString("VAL_OUTR_DESCR"));
    			diagnosticoView.add(rs.getString("GRAU_ESCOLAR"));
    			diagnosticoView.add(rs.getString("GRAU_ESCOLAR_COMPL"));
    			diagnosticoView.add(rs.getString("SABE_ESCREVER"));
    			diagnosticoView.add(rs.getString("SABE_LER"));
    			diagnosticoView.add(rs.getString("PROFISSAO_RESP_FAMILIA"));
    			diagnosticoView.add(rs.getString("NEGOCIACAO_DEB_ENERGIA"));
    			diagnosticoView.add(rs.getString("VALOR_PARCELA_ENERG"));
    			diagnosticoView.add(rs.getString("QTDE_PARCELA_ENERG"));
    			diagnosticoView.add(rs.getString("VENC_PARCELA_ENERG"));
    			diagnosticoView.add(rs.getString("NEGOCIACAO_DEB_AGUA"));
    			diagnosticoView.add(rs.getString("VALOR_PARCELA_AGUA"));
    			diagnosticoView.add(rs.getString("QTDE_PARCELA_AGUA"));
    			diagnosticoView.add(rs.getString("VENC_PARCELA_AGUA"));
    			diagnosticoView.add(rs.getString("CONHEC_OBRA_SANEAM"));
    			diagnosticoView.add(rs.getString("BENEF_SANEA_PREV_DOENCA"));
    			diagnosticoView.add(rs.getString("BENEF_SANEA_FORTAL_ECONO"));
    			diagnosticoView.add(rs.getString("BENEF_SANEA_VALORI_IMOB"));
    			diagnosticoView.add(rs.getString("BENEF_SANEA_VALOR_TURISM"));
    			diagnosticoView.add(rs.getString("OBS_GERAIS"));
    			diagnosticoView.add(rs.getString("MORADORES"));
    			diagnosticoView.add(rs.getString("RESP_CASA_NOME1"));
    			diagnosticoView.add(rs.getString("RESP_CASA_TEL1"));
    			diagnosticoView.add(rs.getString("RESP_CASA_NOME2"));
    			diagnosticoView.add(rs.getString("RESP_CASA_TEL2"));
    			diagnosticoView.add(rs.getString("VIZINHO_NOME1"));
    			diagnosticoView.add(rs.getString("VIZINHO_TEL1"));
    			diagnosticoView.add(rs.getString("VIZINHO_NOME2"));
    			diagnosticoView.add(rs.getString("VIZINHO_TEL2"));
    			diagnosticoView.add(rs.getString("CONTATO_ALTERN_NOME1"));
    			diagnosticoView.add(rs.getString("CONTATO_ALTERN_TEL1"));
    			diagnosticoView.add(rs.getString("CONTATO_ALTERN_NOME2"));
    			diagnosticoView.add(rs.getString("CONTATO_ALTERN_TEL2"));
    			diagnosticoView.add(rs.getString("CONTATO_PROF_NOME1"));
    			diagnosticoView.add(rs.getString("CONTATO_PROF_TE1"));
    			diagnosticoView.add(rs.getString("CONTATO_PROF_NOME2"));
    			diagnosticoView.add(rs.getString("CONTATO_PROF_TE2"));
    			diagnosticoView.add(rs.getString("EQUIP_PUBLICO"));
    			diagnosticoView.add(rs.getString("RELACAOVIZ"));
    			diagnosticoView.add(rs.getString("REL_RECOR_VIZINHO"));
    			diagnosticoView.add(rs.getString("REL_RECOR_VIZINHO_FREQ"));
    			diagnosticoView.add(rs.getString("CONSIDERACOES_FAMILIAS_AO_REDOR"));
    			diagnosticoView.add(rs.getString("HOSPITAL_NOME"));
    			diagnosticoView.add(rs.getString("REF_NOME"));
    			diagnosticoView.add(rs.getString("COORDX"));
    			diagnosticoView.add(rs.getString("COORDY"));
    			diagnosticoView.add(rs.getString("COORDXDIAG"));
    			diagnosticoView.add(rs.getString("COORDYDIAG"));
    			listaTotal.add(diagnosticoView);
    		}
    		return listaTotal;
    	}
    	finally {
    		if(stmt != null)
    			stmt.close();
    		if(rs != null)
    			rs.close();
    	}
    }
     

}