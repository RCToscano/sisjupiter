package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.auxiliar.Auxiliar;
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
            "WHERE     TB_DIAGNOSTICO.DATA >= ? " +
            "AND       TB_DIAGNOSTICO.DATA <= ? " +
            "ORDER BY  TB_DIAGNOSTICO.DATA DESC, " +
            "          TB_DIAGNOSTICO.ID_DIAGNOSTICO DESC "
            );
            
            stmt.setString(1, dtInicio);
            stmt.setString(2, dtFim);

            rs = stmt.executeQuery();

            while(rs.next()) {
            	Diagnostico diagnostico = new Diagnostico();
            	diagnostico.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
            	diagnostico.setDtInsert(formatoData.format(formatoBanco.parse(rs.getString("DTINSERT"))));
            	diagnostico.setData(formatoData.format(formatoBanco.parse(rs.getString("DATA"))));
            	diagnostico.setIdSitImovel(rs.getInt("ID_SITIMOVEL"));
            	diagnostico.setNome(rs.getString("NOME"));
            	diagnostico.setCpf(rs.getString("CPF"));
            	diagnostico.setEndereco(rs.getString("ENDERECO"));
            	diagnostico.setNumAtual(Auxiliar.converteInteger(rs.getString("NUMATUAL")));
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
        SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.m");
        SimpleDateFormat formatoBanco2 = new SimpleDateFormat("yyyy-MM-dd");
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
            	diagnostico.setCodServ(Auxiliar.converteLong(rs.getString("CODSERV")));
            	diagnostico.setIdSitImovel(Auxiliar.converteInteger(rs.getString("ID_SITIMOVEL")));
            	diagnostico.setIdTpConstr(Auxiliar.converteInteger(rs.getString("ID_TPCONSTR")));
            	diagnostico.setIdTpInstal(Auxiliar.converteInteger(rs.getString("ID_TPINSTAL")));
            	diagnostico.setCategoria1(Auxiliar.converteInteger(rs.getString("CATEGORIA1")));
            	diagnostico.setCategoria2(Auxiliar.converteInteger(rs.getString("CATEGORIA2")));
            	diagnostico.setCategoria3(Auxiliar.converteInteger(rs.getString("CATEGORIA3")));
            	diagnostico.setCategoria4(Auxiliar.converteInteger(rs.getString("CATEGORIA4")));
            	diagnostico.setIdTpUso(Auxiliar.converteInteger(rs.getString("ID_TPUSO")));
            	diagnostico.setQtdeCasas(Auxiliar.converteInteger(rs.getString("QTDECASAS")));
            	diagnostico.setTempoOcup(Auxiliar.converteLong(rs.getString("TEMPOOCUP")));
            	diagnostico.setAtividade(rs.getString("ATIVIDADE"));
            	diagnostico.setEnergEletr(Auxiliar.converteInteger(rs.getString("ENERGELETR")));
            	diagnostico.setEnergEletrIrreg(Auxiliar.converteInteger(rs.getString("ENERGELETRIRREG")));
            	diagnostico.setInstalacao(rs.getString("INSTALACAO"));
            	diagnostico.setMedidor(rs.getString("MEDIDOR"));
            	diagnostico.setPavimeExiste(Auxiliar.converteInteger(rs.getString("PAVIMEXISTE")));
            	diagnostico.setColLixoExiste(Auxiliar.converteInteger(rs.getString("COLLIXOEXISTE")));
            	diagnostico.setIdAbastAgua(Auxiliar.converteInteger(rs.getString("ID_ABASTAGUA")));
            	diagnostico.setAbastAguaIrreg(Auxiliar.converteInteger(rs.getString("ABASTAGUAIRREG")));
            	diagnostico.setHidrometro(rs.getString("HIDROMETRO"));
            	diagnostico.setIdDestEsgoto(Auxiliar.converteInteger(rs.getString("ID_DESTESGOTO")));
            	diagnostico.setNome(rs.getString("NOME"));
            	diagnostico.setCpf(rs.getString("CPF"));
            	diagnostico.setRg(rs.getString("RG"));
            	diagnostico.setNacionalidade(Auxiliar.converteInteger(rs.getString("NACIONALIDADE")));
            	diagnostico.setUfNasc(rs.getString("UFNASC"));
            	diagnostico.setMunNasc(rs.getString("MUNNASC"));
            	if(rs.getString("DTNASC") != null && ! rs.getString("DTNASC").isEmpty())
            		diagnostico.setDtNasc(formatoData.format(formatoBanco2.parse(rs.getString("DTNASC"))));
            	diagnostico.setSexo(rs.getString("SEXO"));
            	diagnostico.setTelRes(Auxiliar.converteLong(rs.getString("TELRES")));
            	diagnostico.setTelCel(Auxiliar.converteLong(rs.getString("TELCEL")));
            	diagnostico.setIdEstadoCivil(Auxiliar.converteInteger(rs.getString("ID_ESTADOCIVIL")));
            	diagnostico.setEmail(rs.getString("EMAIL"));
            	diagnostico.setEndereco(rs.getString("ENDERECO"));
            	diagnostico.setNumAtual(Auxiliar.converteInteger(rs.getString("NUMATUAL")));
            	diagnostico.setNumAntigo(Auxiliar.converteInteger(rs.getString("NUMANTIGO")));
            	diagnostico.setCompl(rs.getString("COMPL"));
            	diagnostico.setBairro(rs.getString("BAIRRO"));
            	diagnostico.setMun(rs.getString("MUN"));
            	diagnostico.setUf(rs.getString("UF"));
            	diagnostico.setCep(rs.getString("CEP"));
            	diagnostico.setQtdeAdulto(Auxiliar.converteInteger(rs.getString("QTDEADULTO")));
            	diagnostico.setQtdeCrianca(Auxiliar.converteInteger(rs.getString("QTDECRIANCA")));
            	diagnostico.setPossuiConta(Auxiliar.converteInteger(rs.getString("POSSUICONTA")));
            	diagnostico.setBanco(rs.getString("BANCO"));
            	diagnostico.setPossuiCDeb(Auxiliar.converteInteger(rs.getString("POSSUICDEB")));
            	diagnostico.setRendaTotal(rs.getBigDecimal("RENDATOTAL"));
            	diagnostico.setRendaPerceUtil(Auxiliar.converteInteger(rs.getString("RENDAPERCEUTIL")));
            	diagnostico.setMeioTransp1(Auxiliar.converteInteger(rs.getString("MEIOTRANSP1")));
            	diagnostico.setMeioTransp2(Auxiliar.converteInteger(rs.getString("MEIOTRANSP2")));
            	diagnostico.setMeioTransp3(Auxiliar.converteInteger(rs.getString("MEIOTRANSP3")));
            	diagnostico.setMeioTransp4(Auxiliar.converteInteger(rs.getString("MEIOTRANSP4")));
            	diagnostico.setMeioTransp5(Auxiliar.converteInteger(rs.getString("MEIOTRANSP5")));
            	diagnostico.setInternetAcess(Auxiliar.converteInteger(rs.getString("INTERNETACESS")));
            	diagnostico.setInternetWifi(Auxiliar.converteInteger(rs.getString("INTERNETWIFI")));
            	diagnostico.setInternet3g(Auxiliar.converteInteger(rs.getString("INTERNET3G")));
            	diagnostico.setQtdeCarro(Auxiliar.converteInteger(rs.getString("QTDECARRO")));
            	diagnostico.setQtdeMoto(Auxiliar.converteInteger(rs.getString("QTDEMOTO")));
            	diagnostico.setQtdeBicicleta(Auxiliar.converteInteger(rs.getString("QTDEBICICLETA")));
            	diagnostico.setBenefBCPNum(rs.getString("BENEFBCPNUM"));
            	diagnostico.setBenefNISNum(rs.getString("BENEFNISNUM"));
            	diagnostico.setPossuiTarSocial(Auxiliar.converteInteger(rs.getString("POSSUITARSOCIAL")));
            	diagnostico.setPossuiBolsaFamil(Auxiliar.converteInteger(rs.getString("POSSUIBOLSAFAMIL")));
            	diagnostico.setBenefEntrev(Auxiliar.converteInteger(rs.getString("BENEFENTREV")));
            	diagnostico.setBenefNome(rs.getString("BENEFNOME"));
            	diagnostico.setBenefCpf(rs.getString("BENEFCPF"));
            	diagnostico.setBenefRg(rs.getString("BENEFRG"));
            	diagnostico.setBenefSexo(rs.getString("BENEFSEXO"));
            	if(rs.getString("BENEFDTNASC") != null && ! rs.getString("BENEFDTNASC").isEmpty())
            		diagnostico.setBenefDtNasc(formatoData.format(formatoBanco2.parse(rs.getString("BENEFDTNASC"))));
            	diagnostico.setBenefObs(rs.getString("BENEFOBS"));
            	diagnostico.setMaior59Qtde(Auxiliar.converteInteger(rs.getString("MAIOR59QTDE")));
            	diagnostico.setMenor19Qtde(Auxiliar.converteInteger(rs.getString("MENOR19QTDE")));
            	diagnostico.setMenor1Qtde(Auxiliar.converteInteger(rs.getString("MENOR1QTDE")));
            	diagnostico.setDefVisualQtde(Auxiliar.converteInteger(rs.getString("DEFVISUALQTDE")));
            	diagnostico.setDefAuditQtde(Auxiliar.converteInteger(rs.getString("DEFAUDITQTDE")));
            	diagnostico.setDefFisQtde(Auxiliar.converteInteger(rs.getString("DEFFISQTDE")));
            	diagnostico.setDefIntelecQtde(Auxiliar.converteInteger(rs.getString("DEFINTELECQTDE")));
            	diagnostico.setDefOutrosQtde(Auxiliar.converteInteger(rs.getString("DEFOUTROSQTDE")));
            	diagnostico.setTratCancer(Auxiliar.converteInteger(rs.getString("TRATCANCER")));
            	diagnostico.setTratTuber(Auxiliar.converteInteger(rs.getString("TRATTUBER")));
            	diagnostico.setTratHansen(Auxiliar.converteInteger(rs.getString("TRATHANSEN")));
            	diagnostico.setTratMental(Auxiliar.converteInteger(rs.getString("TRATMENTAL")));
            	diagnostico.setTratEscler(Auxiliar.converteInteger(rs.getString("TRATESCLER")));
            	diagnostico.setTratParal(Auxiliar.converteInteger(rs.getString("TRATPARAL")));
            	diagnostico.setTratHepat(Auxiliar.converteInteger(rs.getString("TRATHEPAT")));
            	diagnostico.setTratCardiac(Auxiliar.converteInteger(rs.getString("TRATCARDIAC")));
            	diagnostico.setTratParkins(Auxiliar.converteInteger(rs.getString("TRATPARKINS")));
            	diagnostico.setTratRenal(Auxiliar.converteInteger(rs.getString("TRATRENAL")));
            	diagnostico.setTratOutro(Auxiliar.converteInteger(rs.getString("TRATOUTRO")));
            	diagnostico.setTratOutroDesc(rs.getString("TRATOUTRODESC"));
            	diagnostico.setAmebiase(Auxiliar.converteInteger(rs.getString("AMEBIASE")));
            	diagnostico.setAmebiaseMemb(rs.getString("AMBIASEMEMB"));
            	diagnostico.setGastroent(Auxiliar.converteInteger(rs.getString("GASTROENT")));
            	diagnostico.setGastroentMemb(rs.getString("GASTROENTMEMB"));
            	diagnostico.setGiardiase(Auxiliar.converteInteger(rs.getString("GIARDIASE")));
            	diagnostico.setGiardiaseMemb(rs.getString("GIARDIASEMEMB"));
            	diagnostico.setFebreTifo(Auxiliar.converteInteger(rs.getString("FEBRETIFO")));
            	diagnostico.setFebreTifoMemb(rs.getString("FEBRETIFOMEMB"));
            	diagnostico.setHepatite(Auxiliar.converteInteger(rs.getString("HEPATITE")));
            	diagnostico.setHepatiteMemb(rs.getString("HEPATITEMEMB"));
            	diagnostico.setColera(Auxiliar.converteInteger(rs.getString("COLERA")));
            	diagnostico.setColeraMemb(rs.getString("COLERAMEMB"));
            	diagnostico.setEsquitosso(Auxiliar.converteInteger(rs.getString("ESQUITOSSO")));
            	diagnostico.setEsquitossoMemb(rs.getString("ESQUITOSSOMEMB"));
            	diagnostico.setAscaridiase(Auxiliar.converteInteger(rs.getString("ASCARIDIASE")));
            	diagnostico.setAscaridiaseMemb(rs.getString("ASCARIDIASEMEMB"));
            	diagnostico.setTeniase(Auxiliar.converteInteger(rs.getString("TENIASE")));
            	diagnostico.setTeniaseMemb(rs.getString("TENIASEMEMB"));
            	diagnostico.setLeptospirose(Auxiliar.converteInteger(rs.getString("LEPTOSPIROSE")));
            	diagnostico.setLeptospiroseMemb(rs.getString("LEPTOSPIROSEMEMB"));
            	diagnostico.setMalaria(Auxiliar.converteInteger(rs.getString("MALARIA")));
            	diagnostico.setMalariaMemb(rs.getString("MALARIAMEMB"));
            	diagnostico.setDengue(Auxiliar.converteInteger(rs.getString("DENGUE")));
            	diagnostico.setDengueMemb(rs.getString("DENGUEMEMB"));
            	diagnostico.setFebreAmar(Auxiliar.converteInteger(rs.getString("FEBREAMAR")));
            	diagnostico.setFebreAmarMemb(rs.getString("FEBREAMARMEMB"));
            	diagnostico.setChikung(Auxiliar.converteInteger(rs.getString("CHIKUNG")));
            	diagnostico.setChikungMemb(rs.getString("CHIKUNGMEMB"));
            	diagnostico.setZicaVirus(Auxiliar.converteInteger(rs.getString("ZICAVIRUS")));
            	diagnostico.setZicaVirusMemb(rs.getString("ZICAVIRUSMEMB"));
            	diagnostico.setCianobacter(Auxiliar.converteInteger(rs.getString("CIANOBACTER")));
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
            	diagnostico.setIdGrauEscol(Auxiliar.converteInteger(rs.getString("ID_GRAUESCOL")));
            	diagnostico.setGrauEscolCompl(Auxiliar.converteInteger(rs.getString("GRAUESCOLCOMPL")));
            	diagnostico.setSabeEscrever(Auxiliar.converteInteger(rs.getString("SABEESCREVER")));
            	diagnostico.setSabeLer(Auxiliar.converteInteger(rs.getString("SABELER")));
            	diagnostico.setEnsinoFunMembro(Auxiliar.converteInteger(rs.getString("ENSINOFUNMEMBRO")));
            	diagnostico.setEnsinoMedMembro(Auxiliar.converteInteger(rs.getString("ENSINOMEDMEMBRO")));
            	diagnostico.setEnsinoSupMembro(Auxiliar.converteInteger(rs.getString("ENSINOSUPMEMBRO")));
            	diagnostico.setEnsinoPosMembro(Auxiliar.converteInteger(rs.getString("ENSINOPOSMEMBRO")));
            	diagnostico.setEnsinoCurMembro(Auxiliar.converteInteger(rs.getString("ENSINOCURMEMBRO")));
            	diagnostico.setAnalfabMembro(Auxiliar.converteInteger(rs.getString("ANALFABMEMBRO")));
            	diagnostico.setProfissRespFamil(rs.getString("PROFISSRESPFAMIL"));
            	diagnostico.setEnergNegoc(Auxiliar.converteInteger(rs.getString("ENERGNEGOC")));
            	diagnostico.setEnergNegocParcVal(rs.getBigDecimal("ENERGNEGOCPARCVAL"));
            	diagnostico.setEnergNegocParcQtde(Auxiliar.converteInteger(rs.getString("ENERGNEGOCPARCQTDE")));
            	diagnostico.setEnergNegocDia(Auxiliar.converteInteger(rs.getString("ENERGNEGOCDIA")));
            	diagnostico.setAguaNegoc(Auxiliar.converteInteger(rs.getString("AGUANEGOC")));
            	diagnostico.setAguaNegocParcVal(rs.getBigDecimal("AGUANEGOCPARCVAL"));
            	diagnostico.setAguaNegocParcQtde(Auxiliar.converteInteger(rs.getString("AGUANEGOCPARCQTDE")));
            	diagnostico.setAguaNegocDia(Auxiliar.converteInteger(rs.getString("AGUANEGOCDIA")));
            	diagnostico.setObraSaneamConhe(rs.getString("OBRASANEAMCONHE"));
            	diagnostico.setBenefObraSanSaude(Auxiliar.converteInteger(rs.getString("BENEFOBRASANSAUDE")));
            	diagnostico.setBenefObraSanEco(Auxiliar.converteInteger(rs.getString("BENEFOBRASANECO")));
            	diagnostico.setBenefObraSanImob(Auxiliar.converteInteger(rs.getString("BENEFOBRASANIMOB")));
            	diagnostico.setBenefObraSanTuri(Auxiliar.converteInteger(rs.getString("BENEFOBRASANTURI")));
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
    
    public void inserir(Diagnostico diagnostico) throws Exception {
    	PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
            				" INSERT INTO TB_DIAGNOSTICO ( " +
		            		" DATA," + 
		            		" DTINSERT," + 
		            		" ID_COMUNIDADE," + 
		            		" ID_EQUIPE," + 
		            		" ID_USER," + 
		            		" CODSERV," + 
		            		" ID_SITIMOVEL," + 
		            		" ID_TPCONSTR," + 
		            		" ID_TPINSTAL," + 
		            		" CATEGORIA1," + 
		            		" CATEGORIA2," + 
		            		" CATEGORIA3," + 
		            		" CATEGORIA4," + 
		            		" ID_TPUSO," + 
		            		" QTDECASAS," + 
		            		" TEMPOOCUP," + 
		            		" ATIVIDADE," + 
		            		" ENERGELETR," + 
		            		" ENERGELETRIRREG," + 
		            		" INSTALACAO," + 
		            		" MEDIDOR," + 
		            		" PAVIMEXISTE," + 
		            		" COLLIXOEXISTE," + 
		            		" ID_ABASTAGUA," + 
		            		" ABASTAGUAIRREG," + 
		            		" HIDROMETRO," + 
		            		" ID_DESTESGOTO," + 
		            		" NOME," + 
		            		" CPF," + 
		            		" RG," + 
		            		" NACIONALIDADE," + 
		            		" UFNASC," + 
		            		" MUNNASC," + 
		            		" DTNASC," + 
		            		" SEXO," + 
		            		" TELRES," + 
		            		" TELCEL," + 
		            		" ID_ESTADOCIVIL," + 
		            		" EMAIL," + 
		            		" ENDERECO," + 
		            		" NUMATUAL," + 
		            		" NUMANTIGO," + 
		            		" COMPL," + 
		            		" BAIRRO," + 
		            		" MUN," + 
		            		" UF," + 
		            		" CEP," + 
		            		" QTDEADULTO," + 
		            		" QTDECRIANCA," + 
		            		" POSSUICONTA," + 
		            		" BANCO," + 
		            		" POSSUICDEB," + 
		            		" RENDATOTAL," + 
		            		" RENDAPERCEUTIL," + 
		            		" MEIOTRANSP1," + 
		            		" MEIOTRANSP2," + 
		            		" MEIOTRANSP3," + 
		            		" MEIOTRANSP4," + 
		            		" MEIOTRANSP5," + 
		            		" INTERNETACESS," + 
		            		" INTERNETWIFI," + 
		            		" INTERNET3G," + 
		            		" QTDECARRO," + 
		            		" QTDEMOTO," + 
		            		" QTDEBICICLETA," + 
		            		" BENEFBCPNUM," + 
		            		" BENEFNISNUM," + 
		            		" POSSUITARSOCIAL," + 
		            		" POSSUIBOLSAFAMIL," + 
		            		" BENEFENTREV," + 
		            		" BENEFNOME," + 
		            		" BENEFCPF," + 
		            		" BENEFRG," + 
		            		" BENEFSEXO," + 
		            		" BENEFDTNASC," + 
		            		" BENEFOBS," + 
		            		" MAIOR59QTDE," + 
		            		" MENOR19QTDE," + 
		            		" MENOR1QTDE," + 
		            		" DEFVISUALQTDE," + 
		            		" DEFAUDITQTDE," + 
		            		" DEFFISQTDE," + 
		            		" DEFINTELECQTDE," + 
		            		" DEFOUTROSQTDE," + 
		            		" TRATCANCER," + 
		            		" TRATTUBER," + 
		            		" TRATHANSEN," + 
		            		" TRATMENTAL," + 
		            		" TRATESCLER," + 
		            		" TRATPARAL," + 
		            		" TRATHEPAT," + 
		            		" TRATCARDIAC," + 
		            		" TRATPARKINS," + 
		            		" TRATRENAL," + 
		            		" TRATOUTRO," + 
		            		" TRATOUTRODESC," + 
		            		" AMEBIASE," + 
		            		" AMBIASEMEMB," + 
		            		" GASTROENT," + 
		            		" GASTROENTMEMB," + 
		            		" GIARDIASE," + 
		            		" GIARDIASEMEMB," + 
		            		" FEBRETIFO," + 
		            		" FEBRETIFOMEMB," + 
		            		" HEPATITE," + 
		            		" HEPATITEMEMB," + 
		            		" COLERA," + 
		            		" COLERAMEMB," + 
		            		" ESQUITOSSO," + 
		            		" ESQUITOSSOMEMB," + 
		            		" ASCARIDIASE," + 
		            		" ASCARIDIASEMEMB," + 
		            		" TENIASE," + 
		            		" TENIASEMEMB," + 
		            		" LEPTOSPIROSE," + 
		            		" LEPTOSPIROSEMEMB," + 
		            		" MALARIA," + 
		            		" MALARIAMEMB," + 
		            		" DENGUE," + 
		            		" DENGUEMEMB," + 
		            		" FEBREAMAR," + 
		            		" FEBREAMARMEMB," + 
		            		" CHIKUNG," + 
		            		" CHIKUNGMEMB," + 
		            		" ZICAVIRUS," + 
		            		" ZICAVIRUSMEMB," + 
		            		" CIANOBACTER," + 
		            		" CIANOBACTERMEMB," + 
		            		" VALDOACAO," + 
		            		" VALAPOSENT," + 
		            		" VALPENSAOALIMEN," + 
		            		" VALSEGDESEMPR," + 
		            		" VALEMPRINFORMAL," + 
		            		" VALEMPRFORMAL," + 
		            		" VALBOLSAFAMIL," + 
		            		" VALOUTRO," + 
		            		" VALOUTRDESCR," + 
		            		" ID_GRAUESCOL," + 
		            		" GRAUESCOLCOMPL," + 
		            		" SABEESCREVER," + 
		            		" SABELER," + 
		            		" ENSINOFUNMEMBRO," + 
		            		" ENSINOMEDMEMBRO," + 
		            		" ENSINOSUPMEMBRO," + 
		            		" ENSINOPOSMEMBRO," + 
		            		" ENSINOCURMEMBRO," + 
		            		" ANALFABMEMBRO," + 
		            		" PROFISSRESPFAMIL," + 
		            		" ENERGNEGOC," + 
		            		" ENERGNEGOCPARCVAL," + 
		            		" ENERGNEGOCPARCQTDE," + 
		            		" ENERGNEGOCDIA," + 
		            		" AGUANEGOC," + 
		            		" AGUANEGOCPARCVAL," + 
		            		" AGUANEGOCPARCQTDE," + 
		            		" AGUANEGOCDIA," + 
		            		" OBRASANEAMCONHE," + 
		            		" BENEFOBRASANSAUDE," + 
		            		" BENEFOBRASANECO," + 
		            		" BENEFOBRASANIMOB," + 
		            		" BENEFOBRASANTURI," + 
		            		" OBSGERAIS " +
		            		")" +
            				" VALUES ( "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            				+ "?, ? )" 
            				);
		            		
				            stmt.setObject(1, diagnostico.getData());
				            stmt.setObject(2, diagnostico.getDtInsert());
				            stmt.setObject(3, diagnostico.getIdComunidade());
				            stmt.setObject(4, diagnostico.getIdEquipe());
				            stmt.setObject(5, diagnostico.getIdUser());
				            stmt.setObject(6, diagnostico.getCodServ());
				            stmt.setObject(7, diagnostico.getIdSitImovel());
				            stmt.setObject(8, diagnostico.getIdTpConstr());
				            stmt.setObject(9, diagnostico.getIdTpInstal());
				            stmt.setObject(10, diagnostico.getCategoria1());
				            stmt.setObject(11, diagnostico.getCategoria2());
				            stmt.setObject(12, diagnostico.getCategoria3());
				            stmt.setObject(13, diagnostico.getCategoria4());
				            stmt.setObject(14, diagnostico.getIdTpUso());
				            stmt.setObject(15, diagnostico.getQtdeCasas());
				            stmt.setObject(16, diagnostico.getTempoOcup());
				            stmt.setObject(17, diagnostico.getAtividade());
				            stmt.setObject(18, diagnostico.getEnergEletr());
				            stmt.setObject(19, diagnostico.getEnergEletrIrreg());
				            stmt.setObject(20, diagnostico.getInstalacao());
				            stmt.setObject(21, diagnostico.getMedidor());
				            stmt.setObject(22, diagnostico.getPavimeExiste());
				            stmt.setObject(23, diagnostico.getColLixoExiste());
				            stmt.setObject(24, diagnostico.getIdAbastAgua());
				            stmt.setObject(25, diagnostico.getAbastAguaIrreg());
				            stmt.setObject(26, diagnostico.getHidrometro());
				            stmt.setObject(27, diagnostico.getIdDestEsgoto());
				            stmt.setObject(28, diagnostico.getNome());
				            stmt.setObject(29, diagnostico.getCpf());
				            stmt.setObject(30, diagnostico.getRg());
				            stmt.setObject(31, diagnostico.getNacionalidade());
				            stmt.setObject(32, diagnostico.getUfNasc());
				            stmt.setObject(33, diagnostico.getMunNasc());
				            stmt.setObject(34, diagnostico.getDtNasc());
				            stmt.setObject(35, diagnostico.getSexo());
				            stmt.setObject(36, diagnostico.getTelRes());
				            stmt.setObject(37, diagnostico.getTelCel());
				            stmt.setObject(38, diagnostico.getIdEstadoCivil());
				            stmt.setObject(39, diagnostico.getEmail());
				            stmt.setObject(40, diagnostico.getEndereco());
				            stmt.setObject(41, diagnostico.getNumAtual());
				            stmt.setObject(42, diagnostico.getNumAntigo());
				            stmt.setObject(43, diagnostico.getCompl());
				            stmt.setObject(44, diagnostico.getBairro());
				            stmt.setObject(45, diagnostico.getMun());
				            stmt.setObject(46, diagnostico.getUf());
				            stmt.setObject(47, diagnostico.getCep());
				            stmt.setObject(48, diagnostico.getQtdeAdulto());
				            stmt.setObject(49, diagnostico.getQtdeCrianca());
				            stmt.setObject(50, diagnostico.getPossuiConta());
				            stmt.setObject(51, diagnostico.getBanco());
				            stmt.setObject(52, diagnostico.getPossuiCDeb());
				            stmt.setObject(53, diagnostico.getRendaTotal());
				            stmt.setObject(54, diagnostico.getRendaPerceUtil());
				            stmt.setObject(55, diagnostico.getMeioTransp1());
				            stmt.setObject(56, diagnostico.getMeioTransp2());
				            stmt.setObject(57, diagnostico.getMeioTransp3());
				            stmt.setObject(58, diagnostico.getMeioTransp4());
				            stmt.setObject(59, diagnostico.getMeioTransp5());
				            stmt.setObject(60, diagnostico.getInternetAcess());
				            stmt.setObject(61, diagnostico.getInternetWifi());
				            stmt.setObject(62, diagnostico.getInternet3g());
				            stmt.setObject(63, diagnostico.getQtdeCarro());
				            stmt.setObject(64, diagnostico.getQtdeMoto());
				            stmt.setObject(65, diagnostico.getQtdeBicicleta());
				            stmt.setObject(66, diagnostico.getBenefBCPNum());
				            stmt.setObject(67, diagnostico.getBenefNISNum());
				            stmt.setObject(68, diagnostico.getPossuiTarSocial());
				            stmt.setObject(69, diagnostico.getPossuiBolsaFamil());
				            stmt.setObject(70, diagnostico.getBenefEntrev());
				            stmt.setObject(71, diagnostico.getBenefNome());
				            stmt.setObject(72, diagnostico.getBenefCpf());
				            stmt.setObject(73, diagnostico.getBenefRg());
				            stmt.setObject(74, diagnostico.getBenefSexo());
				            stmt.setObject(75, diagnostico.getBenefDtNasc());
				            stmt.setObject(76, diagnostico.getBenefObs());
				            stmt.setObject(77, diagnostico.getMaior59Qtde());
				            stmt.setObject(78, diagnostico.getMenor19Qtde());
				            stmt.setObject(79, diagnostico.getMenor1Qtde());
				            stmt.setObject(80, diagnostico.getDefVisualQtde());
				            stmt.setObject(81, diagnostico.getDefAuditQtde());
				            stmt.setObject(82, diagnostico.getDefFisQtde());
				            stmt.setObject(83, diagnostico.getDefIntelecQtde());
				            stmt.setObject(84, diagnostico.getDefOutrosQtde());
				            stmt.setObject(85, diagnostico.getTratCancer());
				            stmt.setObject(86, diagnostico.getTratTuber());
				            stmt.setObject(87, diagnostico.getTratHansen());
				            stmt.setObject(88, diagnostico.getTratMental());
				            stmt.setObject(89, diagnostico.getTratEscler());
				            stmt.setObject(90, diagnostico.getTratParal());
				            stmt.setObject(91, diagnostico.getTratHepat());
				            stmt.setObject(92, diagnostico.getTratCardiac());
				            stmt.setObject(93, diagnostico.getTratParkins());
				            stmt.setObject(94, diagnostico.getTratRenal());
				            stmt.setObject(95, diagnostico.getTratOutro());
				            stmt.setObject(96, diagnostico.getTratOutroDesc());
				            stmt.setObject(97, diagnostico.getAmebiase());
				            stmt.setObject(98, diagnostico.getAmebiaseMemb());
				            stmt.setObject(99, diagnostico.getGastroent());
				            stmt.setObject(100, diagnostico.getGastroentMemb());
				            stmt.setObject(101, diagnostico.getGiardiase());
				            stmt.setObject(102, diagnostico.getGiardiaseMemb());
				            stmt.setObject(103, diagnostico.getFebreTifo());
				            stmt.setObject(104, diagnostico.getFebreTifoMemb());
				            stmt.setObject(105, diagnostico.getHepatite());
				            stmt.setObject(106, diagnostico.getHepatiteMemb());
				            stmt.setObject(107, diagnostico.getColera());
				            stmt.setObject(108, diagnostico.getColeraMemb());
				            stmt.setObject(109, diagnostico.getEsquitosso());
				            stmt.setObject(110, diagnostico.getEsquitossoMemb());
				            stmt.setObject(111, diagnostico.getAscaridiase());
				            stmt.setObject(112, diagnostico.getAscaridiaseMemb());
				            stmt.setObject(113, diagnostico.getTeniase());
				            stmt.setObject(114, diagnostico.getTeniaseMemb());
				            stmt.setObject(115, diagnostico.getLeptospirose());
				            stmt.setObject(116, diagnostico.getLeptospiroseMemb());
				            stmt.setObject(117, diagnostico.getMalaria());
				            stmt.setObject(118, diagnostico.getMalariaMemb());
				            stmt.setObject(119, diagnostico.getDengue());
				            stmt.setObject(120, diagnostico.getDengueMemb());
				            stmt.setObject(121, diagnostico.getFebreAmar());
				            stmt.setObject(122, diagnostico.getFebreAmarMemb());
				            stmt.setObject(123, diagnostico.getChikung());
				            stmt.setObject(124, diagnostico.getChikungMemb());
				            stmt.setObject(125, diagnostico.getZicaVirus());
				            stmt.setObject(126, diagnostico.getZicaVirusMemb());
				            stmt.setObject(127, diagnostico.getCianobacter());
				            stmt.setObject(128, diagnostico.getCianobacterMemb());
				            stmt.setObject(129, diagnostico.getValDoacao());
				            stmt.setObject(130, diagnostico.getValAposent());
				            stmt.setObject(131, diagnostico.getValPensaoAlimen());
				            stmt.setObject(132, diagnostico.getValSegDesempr());
				            stmt.setObject(133, diagnostico.getValEmprInformal());
				            stmt.setObject(134, diagnostico.getValEmprFormal());
				            stmt.setObject(135, diagnostico.getValBolsaFamil());
				            stmt.setObject(136, diagnostico.getValOutro());
				            stmt.setObject(137, diagnostico.getValOutroDescr());
				            stmt.setObject(138, diagnostico.getIdGrauEscol());
				            stmt.setObject(139, diagnostico.getGrauEscolCompl());
				            stmt.setObject(140, diagnostico.getSabeEscrever());
				            stmt.setObject(141, diagnostico.getSabeLer());
				            stmt.setObject(142, diagnostico.getEnsinoFunMembro());
				            stmt.setObject(143, diagnostico.getEnsinoMedMembro());
				            stmt.setObject(144, diagnostico.getEnsinoSupMembro());
				            stmt.setObject(145, diagnostico.getEnsinoPosMembro());
				            stmt.setObject(146, diagnostico.getEnsinoCurMembro());
				            stmt.setObject(147, diagnostico.getAnalfabMembro());
				            stmt.setObject(148, diagnostico.getProfissRespFamil());
				            stmt.setObject(149, diagnostico.getEnergNegoc());
				            stmt.setObject(150, diagnostico.getEnergNegocParcVal());
				            stmt.setObject(151, diagnostico.getEnergNegocParcQtde());
				            stmt.setObject(152, diagnostico.getEnergNegocDia());
				            stmt.setObject(153, diagnostico.getAguaNegoc());
				            stmt.setObject(154, diagnostico.getAguaNegocParcVal());
				            stmt.setObject(155, diagnostico.getAguaNegocParcQtde());
				            stmt.setObject(156, diagnostico.getAguaNegocDia());
				            stmt.setObject(157, diagnostico.getObraSaneamConhe());
				            stmt.setObject(158, diagnostico.getBenefObraSanSaude());
				            stmt.setObject(159, diagnostico.getBenefObraSanEco());
				            stmt.setObject(160, diagnostico.getBenefObraSanImob());
				            stmt.setObject(161, diagnostico.getBenefObraSanTuri());
				            stmt.setObject(162, diagnostico.getObsGerais());
				            stmt.executeUpdate();
	    }
	    finally {
	        if(stmt != null)
	            stmt.close();
	        if(rs != null)
	            rs.close();
	    }
    }
    
    public void alterar(Diagnostico diagnostico) throws Exception {
    	PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
            				" UPDATE TB_DIAGNOSTICO SET " +
    						"DATA = ?," + 
    	            		"DTINSERT = ?," + 
    	            		"ID_COMUNIDADE = ?," + 
    	            		"ID_EQUIPE = ?," + 
    	            		"ID_USER = ?," + 
    	            		"CODSERV = ?," + 
    	            		"ID_SITIMOVEL = ?," + 
    	            		"ID_TPCONSTR = ?," + 
    	            		"ID_TPINSTAL = ?," + 
    	            		"CATEGORIA1 = ?," + 
    	            		"CATEGORIA2 = ?," + 
    	            		"CATEGORIA3 = ?," + 
    	            		"CATEGORIA4 = ?," + 
    	            		"ID_TPUSO = ?," + 
    	            		"QTDECASAS = ?," + 
    	            		"TEMPOOCUP = ?," + 
    	            		"ATIVIDADE = ?," + 
    	            		"ENERGELETR = ?," + 
    	            		"ENERGELETRIRREG = ?," + 
    	            		"INSTALACAO = ?," + 
    	            		"MEDIDOR = ?," + 
    	            		"PAVIMEXISTE = ?," + 
    	            		"COLLIXOEXISTE = ?," + 
    	            		"ID_ABASTAGUA = ?," + 
    	            		"ABASTAGUAIRREG = ?," + 
    	            		"HIDROMETRO = ?," + 
    	            		"ID_DESTESGOTO = ?," + 
    	            		"NOME = ?," + 
    	            		"CPF = ?," + 
    	            		"RG = ?," + 
    	            		"NACIONALIDADE = ?," + 
    	            		"UFNASC = ?," + 
    	            		"MUNNASC = ?," + 
    	            		"DTNASC = ?," + 
    	            		"SEXO = ?," + 
    	            		"TELRES = ?," + 
    	            		"TELCEL = ?," + 
    	            		"ID_ESTADOCIVIL = ?," + 
    	            		"EMAIL = ?," + 
    	            		"ENDERECO = ?," + 
    	            		"NUMATUAL = ?," + 
    	            		"NUMANTIGO = ?," + 
    	            		"COMPL = ?," + 
    	            		"BAIRRO = ?," + 
    	            		"MUN = ?," + 
    	            		"UF = ?," + 
    	            		"CEP = ?," + 
    	            		"QTDEADULTO = ?," + 
    	            		"QTDECRIANCA = ?," + 
    	            		"POSSUICONTA = ?," + 
    	            		"BANCO = ?," + 
    	            		"POSSUICDEB = ?," + 
    	            		"RENDATOTAL = ?," + 
    	            		"RENDAPERCEUTIL = ?," + 
    	            		"MEIOTRANSP1 = ?," + 
    	            		"MEIOTRANSP2 = ?," + 
    	            		"MEIOTRANSP3 = ?," + 
    	            		"MEIOTRANSP4 = ?," + 
    	            		"MEIOTRANSP5 = ?," + 
    	            		"INTERNETACESS = ?," + 
    	            		"INTERNETWIFI = ?," + 
    	            		"INTERNET3G = ?," + 					
    	            		"QTDECARRO = ?," + 
    	            		"QTDEMOTO = ?," + 
    	            		"QTDEBICICLETA = ?," + 
    	            		"BENEFBCPNUM = ?," + 
    	            		"BENEFNISNUM = ?," + 
    	            		"POSSUITARSOCIAL = ?," + 
    	            		"POSSUIBOLSAFAMIL = ?," + 
    	            		"BENEFENTREV = ?," + 
    	            		"BENEFNOME = ?," + 
    	            		"BENEFCPF = ?," + 
    	            		"BENEFRG = ?," + 
    	            		"BENEFSEXO = ?," + 
    	            		"BENEFDTNASC = ?," + 
    	            		"BENEFOBS = ?," + 
    	            		"MAIOR59QTDE = ?," + 
    	            		"MENOR19QTDE = ?," + 
    	            		"MENOR1QTDE = ?," + 
    	            		"DEFVISUALQTDE = ?," + 
    	            		"DEFAUDITQTDE = ?," + 
    	            		"DEFFISQTDE = ?," + 
    	            		"DEFINTELECQTDE = ?," + 
    	            		"DEFOUTROSQTDE = ?," + 
    	            		"TRATCANCER = ?," + 
    	            		"TRATTUBER = ?," + 
    	            		"TRATHANSEN = ?," + 
    	            		"TRATMENTAL = ?," + 
    	            		"TRATESCLER = ?," + 
    	            		"TRATPARAL = ?," + 
    	            		"TRATHEPAT = ?," + 
    	            		"TRATCARDIAC = ?," + 
    	            		"TRATPARKINS = ?," + 
    	            		"TRATRENAL = ?," + 
    	            		"TRATOUTRO = ?," + 
    	            		"TRATOUTRODESC = ?," + 
    	            		"AMEBIASE = ?," + 
    	            		"AMBIASEMEMB = ?," + 
    	            		"GASTROENT = ?," + 
    	            		"GASTROENTMEMB = ?," + 
    	            		"GIARDIASE = ?," + 
    	            		"GIARDIASEMEMB = ?," + 
    	            		"FEBRETIFO = ?," + 
    	            		"FEBRETIFOMEMB = ?," + 
    	            		"HEPATITE = ?," + 
    	            		"HEPATITEMEMB = ?," + 
    	            		"COLERA = ?," + 
    	            		"COLERAMEMB = ?," + 
    	            		"ESQUITOSSO = ?," + 
    	            		"ESQUITOSSOMEMB = ?," + 
    	            		"ASCARIDIASE = ?," + 
    	            		"ASCARIDIASEMEMB = ?," + 
    	            		"TENIASE = ?," + 
    	            		"TENIASEMEMB = ?," + 
    	            		"LEPTOSPIROSE = ?," + 
    	            		"LEPTOSPIROSEMEMB = ?," + 
    	            		"MALARIA = ?," + 
    	            		"MALARIAMEMB = ?," + 
    	            		"DENGUE = ?," + 
    	            		"DENGUEMEMB = ?," + 
    	            		"FEBREAMAR = ?," + 
    	            		"FEBREAMARMEMB = ?," + 
    	            		"CHIKUNG = ?," + 
    	            		"CHIKUNGMEMB = ?," + 
    	            		"ZICAVIRUS = ?," + 
    	            		"ZICAVIRUSMEMB = ?," + 
    	            		"CIANOBACTER = ?," + 
    	            		"CIANOBACTERMEMB = ?," + 
    	            		"VALDOACAO = ?," + 
    	            		"VALAPOSENT = ?," + 
    	            		"VALPENSAOALIMEN = ?," + 
    	            		"VALSEGDESEMPR = ?," + 
    	            		"VALEMPRINFORMAL = ?," + 
    	            		"VALEMPRFORMAL = ?," + 
    	            		"VALBOLSAFAMIL = ?," + 
    	            		"VALOUTRO = ?," + 
    	            		"VALOUTRDESCR = ?," + 
    	            		"ID_GRAUESCOL = ?," + 
    	            		"GRAUESCOLCOMPL = ?," + 
    	            		"SABEESCREVER = ?," + 
    	            		"SABELER = ?," + 
    	            		"ENSINOFUNMEMBRO = ?," + 
    	            		"ENSINOMEDMEMBRO = ?," + 
    	            		"ENSINOSUPMEMBRO = ?," + 
    	            		"ENSINOPOSMEMBRO = ?," + 
    	            		"ENSINOCURMEMBRO = ?," + 
    	            		"ANALFABMEMBRO = ?," + 
    	            		"PROFISSRESPFAMIL = ?," + 
    	            		"ENERGNEGOC = ?," + 
    	            		"ENERGNEGOCPARCVAL = ?," + 
    	            		"ENERGNEGOCPARCQTDE = ?," + 
    	            		"ENERGNEGOCDIA = ?," + 
    	            		"AGUANEGOC = ?," + 
    	            		"AGUANEGOCPARCVAL = ?," + 
    	            		"AGUANEGOCPARCQTDE = ?," + 
    	            		"AGUANEGOCDIA = ?," + 
    	            		"OBRASANEAMCONHE = ?," + 
    	            		"BENEFOBRASANSAUDE = ?," + 
    	            		"BENEFOBRASANECO = ?," + 
    	            		"BENEFOBRASANIMOB = ?," + 
    	            		"BENEFOBRASANTURI = ?," + 
    	            		"OBSGERAIS = ? " +
    	            		"WHERE ID_DIAGNOSTICO = ? "
    	            		);
		            		
				            stmt.setObject(1, diagnostico.getData());
				            stmt.setObject(2, diagnostico.getDtInsert());
				            stmt.setObject(3, diagnostico.getIdComunidade());
				            stmt.setObject(4, diagnostico.getIdEquipe());
				            stmt.setObject(5, diagnostico.getIdUser());
				            stmt.setObject(6, diagnostico.getCodServ());
				            stmt.setObject(7, diagnostico.getIdSitImovel());
				            stmt.setObject(8, diagnostico.getIdTpConstr());
				            stmt.setObject(9, diagnostico.getIdTpInstal());
				            stmt.setObject(10, diagnostico.getCategoria1());
				            stmt.setObject(11, diagnostico.getCategoria2());
				            stmt.setObject(12, diagnostico.getCategoria3());
				            stmt.setObject(13, diagnostico.getCategoria4());
				            stmt.setObject(14, diagnostico.getIdTpUso());
				            stmt.setObject(15, diagnostico.getQtdeCasas());
				            stmt.setObject(16, diagnostico.getTempoOcup());
				            stmt.setObject(17, diagnostico.getAtividade());
				            stmt.setObject(18, diagnostico.getEnergEletr());
				            stmt.setObject(19, diagnostico.getEnergEletrIrreg());
				            stmt.setObject(20, diagnostico.getInstalacao());
				            stmt.setObject(21, diagnostico.getMedidor());
				            stmt.setObject(22, diagnostico.getPavimeExiste());
				            stmt.setObject(23, diagnostico.getColLixoExiste());
				            stmt.setObject(24, diagnostico.getIdAbastAgua());
				            stmt.setObject(25, diagnostico.getAbastAguaIrreg());
				            stmt.setObject(26, diagnostico.getHidrometro());
				            stmt.setObject(27, diagnostico.getIdDestEsgoto());
				            stmt.setObject(28, diagnostico.getNome());
				            stmt.setObject(29, diagnostico.getCpf());
				            stmt.setObject(30, diagnostico.getRg());
				            stmt.setObject(31, diagnostico.getNacionalidade());
				            stmt.setObject(32, diagnostico.getUfNasc());
				            stmt.setObject(33, diagnostico.getMunNasc());
				            stmt.setObject(34, diagnostico.getDtNasc());
				            stmt.setObject(35, diagnostico.getSexo());
				            stmt.setObject(36, diagnostico.getTelRes());
				            stmt.setObject(37, diagnostico.getTelCel());
				            stmt.setObject(38, diagnostico.getIdEstadoCivil());
				            stmt.setObject(39, diagnostico.getEmail());
				            stmt.setObject(40, diagnostico.getEndereco());
				            stmt.setObject(41, diagnostico.getNumAtual());
				            stmt.setObject(42, diagnostico.getNumAntigo());
				            stmt.setObject(43, diagnostico.getCompl());
				            stmt.setObject(44, diagnostico.getBairro());
				            stmt.setObject(45, diagnostico.getMun());
				            stmt.setObject(46, diagnostico.getUf());
				            stmt.setObject(47, diagnostico.getCep());
				            stmt.setObject(48, diagnostico.getQtdeAdulto());
				            stmt.setObject(49, diagnostico.getQtdeCrianca());
				            stmt.setObject(50, diagnostico.getPossuiConta());
				            stmt.setObject(51, diagnostico.getBanco());
				            stmt.setObject(52, diagnostico.getPossuiCDeb());
				            stmt.setObject(53, diagnostico.getRendaTotal());
				            stmt.setObject(54, diagnostico.getRendaPerceUtil());
				            stmt.setObject(55, diagnostico.getMeioTransp1());
				            stmt.setObject(56, diagnostico.getMeioTransp2());
				            stmt.setObject(57, diagnostico.getMeioTransp3());
				            stmt.setObject(58, diagnostico.getMeioTransp4());
				            stmt.setObject(59, diagnostico.getMeioTransp5());
				            stmt.setObject(60, diagnostico.getInternetAcess());
				            stmt.setObject(61, diagnostico.getInternetWifi());
				            stmt.setObject(62, diagnostico.getInternet3g());
				            stmt.setObject(63, diagnostico.getQtdeCarro());
				            stmt.setObject(64, diagnostico.getQtdeMoto());
				            stmt.setObject(65, diagnostico.getQtdeBicicleta());
				            stmt.setObject(66, diagnostico.getBenefBCPNum());
				            stmt.setObject(67, diagnostico.getBenefNISNum());
				            stmt.setObject(68, diagnostico.getPossuiTarSocial());
				            stmt.setObject(69, diagnostico.getPossuiBolsaFamil());
				            stmt.setObject(70, diagnostico.getBenefEntrev());
				            stmt.setObject(71, diagnostico.getBenefNome());
				            stmt.setObject(72, diagnostico.getBenefCpf());
				            stmt.setObject(73, diagnostico.getBenefRg());
				            stmt.setObject(74, diagnostico.getBenefSexo());
				            stmt.setObject(75, diagnostico.getBenefDtNasc());
				            stmt.setObject(76, diagnostico.getBenefObs());
				            stmt.setObject(77, diagnostico.getMaior59Qtde());
				            stmt.setObject(78, diagnostico.getMenor19Qtde());
				            stmt.setObject(79, diagnostico.getMenor1Qtde());
				            stmt.setObject(80, diagnostico.getDefVisualQtde());
				            stmt.setObject(81, diagnostico.getDefAuditQtde());
				            stmt.setObject(82, diagnostico.getDefFisQtde());
				            stmt.setObject(83, diagnostico.getDefIntelecQtde());
				            stmt.setObject(84, diagnostico.getDefOutrosQtde());
				            stmt.setObject(85, diagnostico.getTratCancer());
				            stmt.setObject(86, diagnostico.getTratTuber());
				            stmt.setObject(87, diagnostico.getTratHansen());
				            stmt.setObject(88, diagnostico.getTratMental());
				            stmt.setObject(89, diagnostico.getTratEscler());
				            stmt.setObject(90, diagnostico.getTratParal());
				            stmt.setObject(91, diagnostico.getTratHepat());
				            stmt.setObject(92, diagnostico.getTratCardiac());
				            stmt.setObject(93, diagnostico.getTratParkins());
				            stmt.setObject(94, diagnostico.getTratRenal());
				            stmt.setObject(95, diagnostico.getTratOutro());
				            stmt.setObject(96, diagnostico.getTratOutroDesc());
				            stmt.setObject(97, diagnostico.getAmebiase());
				            stmt.setObject(98, diagnostico.getAmebiaseMemb());
				            stmt.setObject(99, diagnostico.getGastroent());
				            stmt.setObject(100, diagnostico.getGastroentMemb());
				            stmt.setObject(101, diagnostico.getGiardiase());
				            stmt.setObject(102, diagnostico.getGiardiaseMemb());
				            stmt.setObject(103, diagnostico.getFebreTifo());
				            stmt.setObject(104, diagnostico.getFebreTifoMemb());
				            stmt.setObject(105, diagnostico.getHepatite());
				            stmt.setObject(106, diagnostico.getHepatiteMemb());
				            stmt.setObject(107, diagnostico.getColera());
				            stmt.setObject(108, diagnostico.getColeraMemb());
				            stmt.setObject(109, diagnostico.getEsquitosso());
				            stmt.setObject(110, diagnostico.getEsquitossoMemb());
				            stmt.setObject(111, diagnostico.getAscaridiase());
				            stmt.setObject(112, diagnostico.getAscaridiaseMemb());
				            stmt.setObject(113, diagnostico.getTeniase());
				            stmt.setObject(114, diagnostico.getTeniaseMemb());
				            stmt.setObject(115, diagnostico.getLeptospirose());
				            stmt.setObject(116, diagnostico.getLeptospiroseMemb());
				            stmt.setObject(117, diagnostico.getMalaria());
				            stmt.setObject(118, diagnostico.getMalariaMemb());
				            stmt.setObject(119, diagnostico.getDengue());
				            stmt.setObject(120, diagnostico.getDengueMemb());
				            stmt.setObject(121, diagnostico.getFebreAmar());
				            stmt.setObject(122, diagnostico.getFebreAmarMemb());
				            stmt.setObject(123, diagnostico.getChikung());
				            stmt.setObject(124, diagnostico.getChikungMemb());
				            stmt.setObject(125, diagnostico.getZicaVirus());
				            stmt.setObject(126, diagnostico.getZicaVirusMemb());
				            stmt.setObject(127, diagnostico.getCianobacter());
				            stmt.setObject(128, diagnostico.getCianobacterMemb());
				            stmt.setObject(129, diagnostico.getValDoacao());
				            stmt.setObject(130, diagnostico.getValAposent());
				            stmt.setObject(131, diagnostico.getValPensaoAlimen());
				            stmt.setObject(132, diagnostico.getValSegDesempr());
				            stmt.setObject(133, diagnostico.getValEmprInformal());
				            stmt.setObject(134, diagnostico.getValEmprFormal());
				            stmt.setObject(135, diagnostico.getValBolsaFamil());
				            stmt.setObject(136, diagnostico.getValOutro());
				            stmt.setObject(137, diagnostico.getValOutroDescr());
				            stmt.setObject(138, diagnostico.getIdGrauEscol());
				            stmt.setObject(139, diagnostico.getGrauEscolCompl());
				            stmt.setObject(140, diagnostico.getSabeEscrever());
				            stmt.setObject(141, diagnostico.getSabeLer());
				            stmt.setObject(142, diagnostico.getEnsinoFunMembro());
				            stmt.setObject(143, diagnostico.getEnsinoMedMembro());
				            stmt.setObject(144, diagnostico.getEnsinoSupMembro());
				            stmt.setObject(145, diagnostico.getEnsinoPosMembro());
				            stmt.setObject(146, diagnostico.getEnsinoCurMembro());
				            stmt.setObject(147, diagnostico.getAnalfabMembro());
				            stmt.setObject(148, diagnostico.getProfissRespFamil());
				            stmt.setObject(149, diagnostico.getEnergNegoc());
				            stmt.setObject(150, diagnostico.getEnergNegocParcVal());
				            stmt.setObject(151, diagnostico.getEnergNegocParcQtde());
				            stmt.setObject(152, diagnostico.getEnergNegocDia());
				            stmt.setObject(153, diagnostico.getAguaNegoc());
				            stmt.setObject(154, diagnostico.getAguaNegocParcVal());
				            stmt.setObject(155, diagnostico.getAguaNegocParcQtde());
				            stmt.setObject(156, diagnostico.getAguaNegocDia());
				            stmt.setObject(157, diagnostico.getObraSaneamConhe());
				            stmt.setObject(158, diagnostico.getBenefObraSanSaude());
				            stmt.setObject(159, diagnostico.getBenefObraSanEco());
				            stmt.setObject(160, diagnostico.getBenefObraSanImob());
				            stmt.setObject(161, diagnostico.getBenefObraSanTuri());
				            stmt.setObject(162, diagnostico.getObsGerais());
				            stmt.setObject(163, diagnostico.getIdDiagnostico());
				            stmt.executeUpdate();
	    }
	    finally {
	        if(stmt != null)
	            stmt.close();
	        if(rs != null)
	            rs.close();
	    }
    }

    public Diagnostico buscarUltimoIdUser(Long id_user) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
            "SELECT    MAX(TB_DIAGNOSTICO.ID_DIAGNOSTICO) AS ID_DIAGNOSTICO " +
            "FROM      TB_DIAGNOSTICO " +
            "WHERE     TB_DIAGNOSTICO.ID_USER = ? "
            );
            stmt.setLong(1, id_user);

            rs = stmt.executeQuery();

            Diagnostico diagnostico = null;
            if(rs.next()) {
            	diagnostico = new Diagnostico();
            	diagnostico.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
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
