package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.modelo.Diagnostico;

public class DiagnosticoDAO {
	
	Connection connection = null;

    public DiagnosticoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Diagnostico> listarPorPeriodo(String dtInicio, String dtFim) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Diagnostico> list = new ArrayList<>();
        SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.m");
    	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            
            stmt = connection.prepareStatement(
            "SELECT    TB_DIAGNOSTICO.* " +
            "FROM      TB_DIAGNOSTICO " +
            "WHERE     TB_DIAGNOSTICO.DTINSERT >= ? " +
            "AND       TB_DIAGNOSTICO.DTINSERT <= ? " +
            "ORDER BY  TB_DIAGNOSTICO.DTINSERT DESC "
            );
            
            stmt.setString(1, dtInicio);
            stmt.setString(2, dtFim);

            rs = stmt.executeQuery();

            while(rs.next()) {
            	Diagnostico diagnostico = new Diagnostico();
            	diagnostico.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
            	diagnostico.setDtInsert(formatoData.format(formatoBanco.parse(rs.getString("DTINSERT"))));
            	diagnostico.setIdSitImovel(rs.getInt("ID_SITIMOVEL"));
            	diagnostico.setNome(rs.getString("NOME"));
            	diagnostico.setCpf(rs.getString("CPF"));
            	diagnostico.setEndereco(rs.getString("ENDERECO"));
            	diagnostico.setNumAtual(rs.getInt("NUMATUAL"));
            	diagnostico.setAbastAguaIrreg(rs.getInt("ABASTAGUAIRREG"));
            	diagnostico.setIdDestEsgoto(rs.getInt("ID_DESTESGOTO"));
                list.add(diagnostico);
            }
            return list;
        }
        finally {
            if(stmt != null)
                stmt.close();
            if(rs != null)
                rs.close();
        }
    }
    
    public Diagnostico buscarPorId(Long idDiagnostico) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            stmt = connection.prepareStatement(
            "SELECT    TB_DIAGNOSTICO.* " +
            "FROM      TB_DIAGNOSTICO " +
            "WHERE     TB_DIAGNOSTICO.ID_DIAGNOSTICO = ? "
            );
            stmt.setLong(1, idDiagnostico);

            rs = stmt.executeQuery();

            Diagnostico diagnostico = null;
            if(rs.next()) {
            	diagnostico = new Diagnostico();
            	diagnostico.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
            	diagnostico.setData(formatoData.format(formatoBanco.parse(rs.getString("DATA"))));
            	diagnostico.setDtInsert(rs.getString("DTINSERT"));
            	diagnostico.setIdComunidade(rs.getLong("ID_COMUNIDADE"));
            	diagnostico.setIdEquipe(rs.getLong("ID_EQUIPE"));
            	diagnostico.setIdUser(rs.getLong("ID_USER"));
            	diagnostico.setCoordY(rs.getString("COORDY"));
            	diagnostico.setCoordX(rs.getString("COORDX"));
            	diagnostico.setCodServ(rs.getInt("CODSERV"));
            	diagnostico.setIdSitImovel(rs.getInt("ID_SITIMOVEL"));
            	diagnostico.setIdTpConstr(rs.getInt("ID_TPCONSTR"));
            	diagnostico.setIdTpInstal(rs.getInt("ID_TPINSTAL"));
            	diagnostico.setCategoria1(rs.getInt("CATEGORIA1"));
            	diagnostico.setCategoria2(rs.getInt("CATEGORIA2"));
            	diagnostico.setCategoria3(rs.getInt("CATEGORIA3"));
            	diagnostico.setCategoria4(rs.getInt("CATEGORIA4"));
            	diagnostico.setIdTpUso(rs.getInt("ID_TPUSO"));
            	diagnostico.setQtdeCasas(rs.getInt("QTDECASAS"));
            	diagnostico.setTempoOcup(rs.getInt("TEMPOOCUP"));
            	diagnostico.setAtividade(rs.getString("ATIVIDADE"));
            	diagnostico.setEnergEletr(rs.getInt("ENERGELETR"));
            	diagnostico.setEnergEletrIrreg(rs.getInt("ENERGELETRIRREG"));
            	diagnostico.setInstalacao(rs.getString("INSTALACAO"));
            	diagnostico.setMedidor(rs.getString("MEDIDOR"));
            	diagnostico.setPavimeExiste(rs.getInt("PAVIMEXISTE"));
            	diagnostico.setColLixoExiste(rs.getInt("COLLIXOEXISTE"));
            	diagnostico.setIdAbastAgua(rs.getInt("ID_ABASTAGUA"));
            	diagnostico.setAbastAguaIrreg(rs.getInt("ABASTAGUAIRREG"));
            	diagnostico.setHidrometro(rs.getString("HIDROMETRO"));
            	diagnostico.setIdDestEsgoto(rs.getInt("ID_DESTESGOTO"));
            	diagnostico.setNome(rs.getString("NOME"));
            	diagnostico.setCpf(rs.getString("CPF"));
            	diagnostico.setRg(rs.getString("RG"));
            	diagnostico.setNacionalidade(rs.getInt("NACIONALIDADE"));
            	diagnostico.setUfNasc(rs.getString("UFNASC"));
            	diagnostico.setMunNasc(rs.getString("MUNNASC"));
            	diagnostico.setDtNasc(formatoData.format(formatoBanco.parse(rs.getString("DTNASC"))));
            	diagnostico.setSexo(rs.getString("SEXO"));
            	diagnostico.setTelRes(rs.getInt("TELRES"));
            	diagnostico.setTelCel(rs.getInt("TELCEL"));
            	diagnostico.setIdEstadoCivil(rs.getInt("ID_ESTADOCIVIL"));
            	diagnostico.setEmail(rs.getString("EMAIL"));
            	diagnostico.setEndereco(rs.getString("ENDERECO"));
            	diagnostico.setNumAtual(rs.getInt("NUMATUAL"));
            	diagnostico.setNumAntigo(rs.getInt("NUMANTIGO"));
            	diagnostico.setCompl(rs.getString("COMPL"));
            	diagnostico.setBairro(rs.getString("BAIRRO"));
            	diagnostico.setMun(rs.getString("MUN"));
            	diagnostico.setUf(rs.getString("UF"));
            	diagnostico.setCep(rs.getString("CEP"));
            	diagnostico.setQtdeAdulto(rs.getInt("QTDEADULTO"));
            	diagnostico.setQtdeCrianca(rs.getInt("QTDECRIANCA"));
            	diagnostico.setPossuiConta(rs.getInt("POSSUICONTA"));
            	diagnostico.setBanco(rs.getString("BANCO"));
            	diagnostico.setPossuiCDeb(rs.getInt("POSSUICDEB"));
            	diagnostico.setRendaTotal(rs.getBigDecimal("RENDATOTAL"));
            	diagnostico.setRendaPerceUtil(rs.getInt("RENDAPERCEUTIL"));
            	diagnostico.setMeioTransp1(rs.getInt("MEIOTRANSP1"));
            	diagnostico.setMeioTransp2(rs.getInt("MEIOTRANSP2"));
            	diagnostico.setMeioTransp3(rs.getInt("MEIOTRANSP3"));
            	diagnostico.setMeioTransp4(rs.getInt("MEIOTRANSP4"));
            	diagnostico.setMeioTransp5(rs.getInt("MEIOTRANSP5"));
            	diagnostico.setInternetAcess(rs.getInt("INTERNETACESS"));
            	diagnostico.setInternetWifi(rs.getInt("INTERNETWIFI"));
            	diagnostico.setInternet3g(rs.getInt("INTERNET3G"));
            	diagnostico.setQtdeCarro(rs.getInt("QTDECARRO"));
            	diagnostico.setQtdeMoto(rs.getInt("QTDEMOTO"));
            	diagnostico.setQtdeBicicleta(rs.getInt("QTDEBICICLETA"));
            	diagnostico.setBenefBCPNum(rs.getString("BENEFBCPNUM"));
            	diagnostico.setBenefNISNum(rs.getString("BENEFNISNUM"));
            	diagnostico.setPossuiTarSocial(rs.getInt("POSSUITARSOCIAL"));
            	diagnostico.setPossuiBolsaFamil(rs.getInt("POSSUIBOLSAFAMIL"));
            	diagnostico.setBenefEntrev(rs.getInt("BENEFENTREV"));
            	diagnostico.setBenefNome(rs.getString("BENEFNOME"));
            	diagnostico.setBenefCpf(rs.getString("BENEFCPF"));
            	diagnostico.setBenefRg(rs.getString("BENEFRG"));
            	diagnostico.setBenefSexo(rs.getString("BENEFSEXO"));
            	diagnostico.setBenefDtNasc(formatoData.format(formatoBanco.parse(rs.getString("BENEFDTNASC"))));
            	diagnostico.setBenefObs(rs.getString("BENEFOBS"));
            	diagnostico.setMaior59Qtde(rs.getInt("MAIOR59QTDE"));
            	diagnostico.setMenor19Qtde(rs.getInt("MENOR19QTDE"));
            	diagnostico.setMenor1Qtde(rs.getInt("MENOR1QTDE"));
            	diagnostico.setDefVisualQtde(rs.getInt("DEFVISUALQTDE"));
            	diagnostico.setDefAuditQtde(rs.getInt("DEFAUDITQTDE"));
            	diagnostico.setDefFisQtde(rs.getInt("DEFFISQTDE"));
            	diagnostico.setDefIntelecQtde(rs.getInt("DEFINTELECQTDE"));
            	diagnostico.setDefOutrosQtde(rs.getInt("DEFOUTROSQTDE"));
            	diagnostico.setTratCancer(rs.getInt("TRATCANCER"));
            	diagnostico.setTratTuber(rs.getInt("TRATTUBER"));
            	diagnostico.setTratHansen(rs.getInt("TRATHANSEN"));
            	diagnostico.setTratMental(rs.getInt("TRATMENTAL"));
            	diagnostico.setTratEscler(rs.getInt("TRATESCLER"));
            	diagnostico.setTratParal(rs.getInt("TRATPARAL"));
            	diagnostico.setTratHepat(rs.getInt("TRATHEPAT"));
            	diagnostico.setTratCardiac(rs.getInt("TRATCARDIAC"));
            	diagnostico.setTratParkins(rs.getInt("TRATPARKINS"));
            	diagnostico.setTratRenal(rs.getInt("TRATRENAL"));
            	diagnostico.setTratOutro(rs.getInt("TRATOUTRO"));
            	diagnostico.setTratOutroDesc(rs.getString("TRATOUTRODESC"));
            	diagnostico.setAmebiase(rs.getInt("AMEBIASE"));
            	diagnostico.setAmebiaseMemb(rs.getString("AMBIASEMEMB"));
            	diagnostico.setGastroent(rs.getInt("GASTROENT"));
            	diagnostico.setGastroentMemb(rs.getString("GASTROENTMEMB"));
            	diagnostico.setGiardiase(rs.getInt("GIARDIASE"));
            	diagnostico.setGiardiaseMemb(rs.getString("GIARDIASEMEMB"));
            	diagnostico.setFebreTifo(rs.getInt("FEBRETIFO"));
            	diagnostico.setFebreTifoMemb(rs.getString("FEBRETIFOMEMB"));
            	diagnostico.setHepatite(rs.getInt("HEPATITE"));
            	diagnostico.setHepatiteMemb(rs.getString("HEPATITEMEMB"));
            	diagnostico.setColera(rs.getInt("COLERA"));
            	diagnostico.setColeraMemb(rs.getString("COLERAMEMB"));
            	diagnostico.setEsquitosso(rs.getInt("ESQUITOSSO"));
            	diagnostico.setEsquitossoMemb(rs.getString("ESQUITOSSOMEMB"));
            	diagnostico.setAscaridiase(rs.getInt("ASCARIDIASE"));
            	diagnostico.setAscaridiaseMemb(rs.getString("ASCARIDIASEMEMB"));
            	diagnostico.setTeniase(rs.getInt("TENIASE"));
            	diagnostico.setTeniaseMemb(rs.getString("TENIASEMEMB"));
            	diagnostico.setLeptospirose(rs.getInt("LEPTOSPIROSE"));
            	diagnostico.setLeptospiroseMemb(rs.getString("LEPTOSPIROSEMEMB"));
            	diagnostico.setMalaria(rs.getInt("MALARIA"));
            	diagnostico.setMalariaMemb(rs.getString("MALARIAMEMB"));
            	diagnostico.setDengue(rs.getInt("DENGUE"));
            	diagnostico.setDengueMemb(rs.getString("DENGUEMEMB"));
            	diagnostico.setFebreAmar(rs.getInt("FEBREAMAR"));
            	diagnostico.setFebreAmarMemb(rs.getString("FEBREAMARMEMB"));
            	diagnostico.setChikung(rs.getInt("CHIKUNG"));
            	diagnostico.setChikungMemb(rs.getString("CHIKUNGMEMB"));
            	diagnostico.setZicaVirus(rs.getInt("ZICAVIRUS"));
            	diagnostico.setZicaVirusMemb(rs.getString("ZICAVIRUSMEMB"));
            	diagnostico.setCianobacter(rs.getInt("CIANOBACTER"));
            	diagnostico.setCianobacterMemb(rs.getString("CIANOBACTERMEMB"));
            	diagnostico.setValDoacao(rs.getBigDecimal("VALDOACAO"));
            	diagnostico.setValAposent(rs.getBigDecimal("VALAPOSENT"));
            	diagnostico.setValPensaoAlimen(rs.getBigDecimal("VALPENSAOALIMEN"));
            	diagnostico.setValSegDesempr(rs.getBigDecimal("VALSEGDESEMPR"));
            	diagnostico.setValEmprInformal(rs.getBigDecimal("VALEMPRINFORMAL"));
            	diagnostico.setValEmprFormal(rs.getBigDecimal("VALEMPRFORMAL"));
            	diagnostico.setValBolsaFamil(rs.getBigDecimal("VALBOLSAFAMIL"));
            	diagnostico.setValOutro(rs.getBigDecimal("VALOUTRO"));
            	diagnostico.setValOutroDescr(rs.getString("VALOUTRDESCR"));
            	diagnostico.setIdGrauEscol(rs.getInt("ID_GRAUESCOL"));
            	diagnostico.setGrauEscolCompl(rs.getInt("GRAUESCOLCOMPL"));
            	diagnostico.setSabeEscrever(rs.getInt("SABEESCREVER"));
            	diagnostico.setSabeLer(rs.getInt("SABELER"));
            	diagnostico.setEnsinoFunMembro(rs.getInt("ENSINOFUNMEMBRO"));
            	diagnostico.setEnsinoMedMembro(rs.getInt("ENSINOMEDMEMBRO"));
            	diagnostico.setEnsinoSupMembro(rs.getInt("ENSINOSUPMEMBRO"));
            	diagnostico.setEnsinoPosMembro(rs.getInt("ENSINOPOSMEMBRO"));
            	diagnostico.setEnsinoCurMembro(rs.getInt("ENSINOCURMEMBRO"));
            	diagnostico.setAnalfabMembro(rs.getInt("ANALFABMEMBRO"));
            	diagnostico.setProfissRespFamil(rs.getString("PROFISSRESPFAMIL"));
            	diagnostico.setEnergNegoc(rs.getInt("ENERGNEGOC"));
            	diagnostico.setEnergNegocParcVal(rs.getBigDecimal("ENERGNEGOCPARCVAL"));
            	diagnostico.setEnergNegocParcQtde(rs.getInt("ENERGNEGOCPARCQTDE"));
            	diagnostico.setEnergNegocDia(rs.getInt("ENERGNEGOCDIA"));
            	diagnostico.setAguaNegoc(rs.getInt("AGUANEGOC"));
            	diagnostico.setAguaNegocParcVal(rs.getBigDecimal("AGUANEGOCPARCVAL"));
            	diagnostico.setAguaNegocParcQtde(rs.getInt("AGUANEGOCPARCQTDE"));
            	diagnostico.setAguaNegocDia(rs.getInt("AGUANEGOCDIA"));
            	diagnostico.setObraSaneamConhe(rs.getString("OBRASANEAMCONHE"));
            	diagnostico.setBenefObraSanSaude(rs.getInt("BENEFOBRASANSAUDE"));
            	diagnostico.setBenefObraSanEco(rs.getInt("BENEFOBRASANECO"));
            	diagnostico.setBenefObraSanImob(rs.getInt("BENEFOBRASANIMOB"));
            	diagnostico.setBenefObraSanTuri(rs.getInt("BENEFOBRASANTURI"));
            	diagnostico.setObsGerais(rs.getString("OBSGERAIS"));
            }
            return diagnostico;
        }
        finally {
            if(stmt != null)
                stmt.close();
            if(rs != null)
                rs.close();
        }
    }
    
    

}
