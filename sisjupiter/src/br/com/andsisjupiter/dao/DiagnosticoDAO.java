package br.com.andsisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.andsisjupiter.modelo.Diagnostico;
import br.com.sisjupiter.auxiliar.Auxiliar;


public class DiagnosticoDAO {
     
    Connection connection;

    public DiagnosticoDAO(Connection connection) {
        
        this.connection = connection;
    }
    
    public void inserir(Diagnostico diagnostico) throws SQLException {

        PreparedStatement stmt = null;
        
        try {
            
            stmt = connection.prepareStatement(  
            "INSERT INTO TB_DIAGNOSTICO ( " + 
            //"       ID_DIAGNOSTICO, " +            
            "       ID_COMUNIDADE, " +
            "       ID_EQUIPE, " +
            "       ID_USER, " +
            "       COORDX, " +
            "       COORDY, " +
            "       CODSERV, " +
            "       ID_SITIMOVEL, " +
            "       ID_TPCONSTR, " +
            "       ID_TPINSTAL, " +
            "       CATEGORIA1, " +
            "       CATEGORIA2, " +
            "       CATEGORIA3, " +
            "       CATEGORIA4, " +
            "       ID_TPUSO, " +
            "       QTDECASAS, " +
            "       TEMPOOCUP, " +
            "       ATIVIDADE, " +
            "       ENERGELETR, " +
            "       ENERGELETRIRREG, " +
            "       INSTALACAO, " +
            "       MEDIDOR, " +
            "       PAVIMEXISTE, " +
            "       COLLIXOEXISTE, " +
            "       ID_ABASTAGUA, " +
            "       ABASTAGUAIRREG, " +
            "       HIDROMETRO, " +
            "       ID_DESTESGOTO, " +
            "       NOME, " +
            "       CPF, " +
            "       RG, " +
            "       NACIONALIDADE, " +
            "       UFNASC, " +
            "       MUNNASC, " +            
            "       SEXO, " +
            "       TELRES, " +
            "       TELCEL, " +
            "       ID_ESTADOCIVIL, " +
            "       EMAIL, " +
            "       ENDERECO, " +
            "       NUMATUAL, " +
            "       NUMANTIGO, " +
            "       COMPL, " +
            "       BAIRRO, " +
            "       MUN, " +
            "       UF, " +
            "       CEP, " +
            "       QTDEADULTO, " +
            "       QTDECRIANCA, " +
            "       POSSUICONTA, " +
            "       BANCO, " +
            "       POSSUICDEB, " +
            "       RENDATOTAL, " +
            "       RENDAPERCEUTIL, " +
            "       MEIOTRANSP1, " +
            "       MEIOTRANSP2, " +
            "       MEIOTRANSP3, " +
            "       MEIOTRANSP4, " +
            "       MEIOTRANSP5, " +
            "       INTERNETACESS, " +
            "       INTERNETWIFI, " +
            "       INTERNET3G, " +
            "       QTDECARRO, " +
            "       QTDEMOTO, " +
            "       QTDEBICICLETA, " +
            "       BENEFBCPNUM, " +
            "       BENEFNISNUM, " +
            "       POSSUITARSOCIAL, " +
            "       POSSUIBOLSAFAMIL, " +
            "       BENEFENTREV, " +
            "       BENEFNOME, " +
            "       BENEFCPF, " +
            "       BENEFRG, " +
            "       BENEFSEXO, " +
            "       BENEFOBS, " +
            "       MAIOR59QTDE, " +
            "       MENOR19QTDE, " +
            "       MENOR1QTDE, " +
            "       DEFVISUALQTDE, " +
            "       DEFAUDITQTDE, " +
            "       DEFFISQTDE, " +
            "       DEFINTELECQTDE, " +
            "       DEFOUTROSQTDE, " +
            "       TRATCANCER, " +
            "       TRATTUBER, " +
            "       TRATHANSEN, " +
            "       TRATMENTAL, " +
            "       TRATESCLER, " +
            "       TRATPARAL, " +
            "       TRATHEPAT, " +
            "       TRATCARDIAC, " +
            "       TRATPARKINS, " +
            "       TRATRENAL, " +
            "       TRATOUTRO, " +
            "       TRATOUTRODESC, " +
            "       AMEBIASE, " +
            "       AMBIASEMEMB, " +
            "       GASTROENT, " +
            "       GASTROENTMEMB, " +
            "       GIARDIASE, " +
            "       GIARDIASEMEMB, " +
            "       FEBRETIFO, " +
            "       FEBRETIFOMEMB, " +
            "       HEPATITE, " +
            "       HEPATITEMEMB, " +
            "       COLERA, " +
            "       COLERAMEMB, " +
            "       ESQUITOSSO, " +
            "       ESQUITOSSOMEMB, " +
            "       ASCARIDIASE, " +
            "       ASCARIDIASEMEMB, " +
            "       TENIASE, " +
            "       TENIASEMEMB, " +
            "       LEPTOSPIROSE, " +
            "       LEPTOSPIROSEMEMB, " +
            "       MALARIA, " +
            "       MALARIAMEMB, " +
            "       DENGUE, " +
            "       DENGUEMEMB, " +
            "       FEBREAMAR, " +
            "       FEBREAMARMEMB, " +
            "       CHIKUNG, " +
            "       CHIKUNGMEMB, " +
            "       ZICAVIRUS, " +
            "       ZICAVIRUSMEMB, " +
            "       CIANOBACTER, " +
            "       CIANOBACTERMEMB, " +
            "       VALDOACAO, " +
            "       VALAPOSENT, " +
            "       VALPENSAOALIMEN, " +
            "       VALSEGDESEMPR, " +
            "       VALEMPRINFORMAL, " +
            "       VALEMPRFORMAL, " +
            "       VALBOLSAFAMIL, " +
            "       VALOUTRO, " +
            "       VALOUTRDESCR, " +
            "       ID_GRAUESCOL, " +
            "       GRAUESCOLCOMPL, " +
            "       SABEESCREVER, " +
            "       SABELER, " +
            "       ENSINOFUNMEMBRO, " +
            "       ENSINOMEDMEMBRO, " +
            "       ENSINOSUPMEMBRO, " +
            "       ENSINOPOSMEMBRO, " +
            "       ENSINOCURMEMBRO, " +
            "       ANALFABMEMBRO, " +
            "       PROFISSRESPFAMIL, " +
            "       ENERGNEGOC, " +
            "       ENERGNEGOCPARCVAL, " +
            "       ENERGNEGOCPARCQTDE, " +
            "       ENERGNEGOCDIA, " +
            "       AGUANEGOC, " +
            "       AGUANEGOCPARCVAL, " +
            "       AGUANEGOCPARCQTDE, " +
            "       AGUANEGOCDIA, " +
            "       OBRASANEAMCONHE, " +
            "       BENEFOBRASANSAUDE, " +
            "       BENEFOBRASANECO, " +
            "       BENEFOBRASANIMOB, " +
            "       BENEFOBRASANTURI, " +
            "       OBSGERAIS, " +
            "       ID_DIAGNOSTICOCEL, " +
			"       DATA, " +
			"       DTNASC, " +
            "       BENEFDTNASC, " +            
            "       DTINSERT " +        
            ") VALUES ( " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,sysdate() " +
            ") ");
            
            //stmt.setObject(1, diagnostico.getIdDiagnostico());            
            stmt.setObject(1, Auxiliar.isZeroNull(diagnostico.getIdComunidade()));
            stmt.setObject(2, Auxiliar.isZeroNull(diagnostico.getIdEquipe()));
            stmt.setObject(3, 19);
            stmt.setObject(4, diagnostico.getCoordX());
            stmt.setObject(5, diagnostico.getCoordY());
            stmt.setObject(6, null);
            stmt.setObject(7, Auxiliar.isZeroNull(diagnostico.getSituacaoImovel()));
            stmt.setObject(8, Auxiliar.isZeroNull(diagnostico.getTipoContrucao()));
            stmt.setObject(9, Auxiliar.isZeroNull(diagnostico.getTpInstalacao()));
            stmt.setObject(10, Auxiliar.isZeroNull(diagnostico.getCategoriaImovel1()));
            stmt.setObject(11, Auxiliar.isZeroNull(diagnostico.getCategoriaImovel2()));
            stmt.setObject(12, Auxiliar.isZeroNull(diagnostico.getCategoriaImovel3()));
            stmt.setObject(13, Auxiliar.isZeroNull(diagnostico.getCategoriaImovel4()));
            stmt.setObject(14, Auxiliar.isZeroNull(diagnostico.getTpUsoImovel()));
            stmt.setObject(15, Auxiliar.isZeroNull(diagnostico.getQtdeCasa()));
            stmt.setObject(16, Auxiliar.isZeroNull(diagnostico.getTempoOcupacao()));
            stmt.setObject(17, diagnostico.getAtividadeImovel());
            stmt.setObject(18, Auxiliar.isZeroNull(diagnostico.getEnergiaEletr()));
            stmt.setObject(19, Auxiliar.isZeroNull(diagnostico.getEnergiaEletrIrreg()));
            stmt.setObject(20, diagnostico.getNumInstalacao());
            stmt.setObject(21, diagnostico.getNumMedidor());
            stmt.setObject(22, Auxiliar.isZeroNull(diagnostico.getCalcamento()));
            stmt.setObject(23, Auxiliar.isZeroNull(diagnostico.getColetaLixo()));
            stmt.setObject(24, Auxiliar.isZeroNull(diagnostico.getAbastAgua()));
            stmt.setObject(25, Auxiliar.isZeroNull(diagnostico.getAbastAguaIrreg()));
            stmt.setObject(26, diagnostico.getHidrometro());
            stmt.setObject(27, Auxiliar.isZeroNull(diagnostico.getDestinoEsgoto()));
            stmt.setObject(28, diagnostico.getNomeCliente());
            stmt.setObject(29, diagnostico.getCpfCliente());
            stmt.setObject(30, diagnostico.getRgCliente());
            stmt.setObject(31, Auxiliar.isZeroNull(diagnostico.getNacionalidade()));
            stmt.setObject(32, diagnostico.getEstadoNasc());
            stmt.setObject(33, diagnostico.getMunicipioNasc());
            stmt.setObject(34, diagnostico.getSexo());
            stmt.setObject(35, Auxiliar.isZeroNull(diagnostico.getTelResidencia()));
            stmt.setObject(36, Auxiliar.isZeroNull(diagnostico.getTelCelular()));
            stmt.setObject(37, Auxiliar.isZeroNull(diagnostico.getEstadoCivil()));
            stmt.setObject(38, diagnostico.getEmail());
            stmt.setObject(39, diagnostico.getEndereco());
            stmt.setObject(40, Auxiliar.isZeroNull(diagnostico.getNumAtual()));
            stmt.setObject(41, Auxiliar.isZeroNull(diagnostico.getNumAntigo()));
            stmt.setObject(42, diagnostico.getComplemento());
            stmt.setObject(43, diagnostico.getBairro());
            stmt.setObject(44, diagnostico.getMunicipio());
            stmt.setObject(45, diagnostico.getEstado());
            stmt.setObject(46, diagnostico.getCep());
            stmt.setObject(47, Auxiliar.isZeroNull(diagnostico.getQtdeAdulto()));
            stmt.setObject(48, Auxiliar.isZeroNull(diagnostico.getQtdeCrianca()));
            stmt.setObject(49, Auxiliar.isZeroNull(diagnostico.getContaExiste()));
            stmt.setObject(50, diagnostico.getBanco());
            stmt.setObject(51, Auxiliar.isZeroNull(diagnostico.getCartaoDebitoExiste()));
            stmt.setObject(52, Auxiliar.isZeroNull(diagnostico.getRendaTotal()));
            stmt.setObject(53, Auxiliar.isZeroNull(diagnostico.getPercentualMedio()));
            stmt.setObject(54, Auxiliar.isZeroNull(diagnostico.getMeioTransporte1()));
            stmt.setObject(55, Auxiliar.isZeroNull(diagnostico.getMeioTransporte2()));
            stmt.setObject(56, Auxiliar.isZeroNull(diagnostico.getMeioTransporte3()));
            stmt.setObject(57, Auxiliar.isZeroNull(diagnostico.getMeioTransporte4()));
            stmt.setObject(58, Auxiliar.isZeroNull(diagnostico.getMeioTransporte5()));
            stmt.setObject(59, Auxiliar.isZeroNull(diagnostico.getAcessoInternet()));
            stmt.setObject(60, Auxiliar.isZeroNull(diagnostico.getAcessoInternetTp1()));
            stmt.setObject(61, Auxiliar.isZeroNull(diagnostico.getAcessoInternetTp2()));
            stmt.setObject(62, Auxiliar.isZeroNull(diagnostico.getQtdeCarro()));
            stmt.setObject(63, Auxiliar.isZeroNull(diagnostico.getQtdeMoto()));
            stmt.setObject(64, Auxiliar.isZeroNull(diagnostico.getQtdeBicicleta()));
            stmt.setObject(65, diagnostico.getBenefBcpNum());
            stmt.setObject(66, diagnostico.getBenefNisNum());
            stmt.setObject(67, Auxiliar.isZeroNull(diagnostico.getTarifaSocialAgua()));
            stmt.setObject(68, Auxiliar.isZeroNull(diagnostico.getBolsaFamilia()));
            stmt.setObject(69, null);
            stmt.setObject(70, diagnostico.getBenefNome());
            stmt.setObject(71, diagnostico.getBenefCpf());
            stmt.setObject(72, diagnostico.getBenefRG());
            stmt.setObject(73, diagnostico.getBenefSexo());
            stmt.setObject(74, diagnostico.getBenefObs());
            stmt.setObject(75, Auxiliar.isZeroNull(diagnostico.getMembroVulner60Anos()));
            stmt.setObject(76, Auxiliar.isZeroNull(diagnostico.getMembroVulner18Anos()));
            stmt.setObject(77, Auxiliar.isZeroNull(diagnostico.getMembroVulner1Ano()));
            stmt.setObject(78, Auxiliar.isZeroNull(diagnostico.getPessoasDefVisu()));
            stmt.setObject(79, Auxiliar.isZeroNull(diagnostico.getPessoasDefAud()));
            stmt.setObject(80, Auxiliar.isZeroNull(diagnostico.getPessoasDefFis()));
            stmt.setObject(81, Auxiliar.isZeroNull(diagnostico.getPessoasDefIntel()));
            stmt.setObject(82, Auxiliar.isZeroNull(diagnostico.getPessoasDefOutr()));
            stmt.setObject(83, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca1()));
            stmt.setObject(84, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca2()));
            stmt.setObject(85, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca3()));
            stmt.setObject(86, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca4()));
            stmt.setObject(87, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca5()));
            stmt.setObject(88, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca6()));
            stmt.setObject(89, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca7()));
            stmt.setObject(90, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca8()));
            stmt.setObject(91, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca9()));
            stmt.setObject(92, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca10()));
            stmt.setObject(93, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca11()));
            stmt.setObject(94, diagnostico.getMembroTratDoencaDesc());
            stmt.setObject(95, Auxiliar.isZeroNull(diagnostico.getDoenca1()));
            stmt.setObject(96, diagnostico.getMembroDoenca1());
            stmt.setObject(97, Auxiliar.isZeroNull(diagnostico.getDoenca2()));
            stmt.setObject(98, diagnostico.getMembroDoenca2());
            stmt.setObject(99, Auxiliar.isZeroNull(diagnostico.getDoenca3()));
            stmt.setObject(100, diagnostico.getMembroDoenca3());
            stmt.setObject(101, Auxiliar.isZeroNull(diagnostico.getDoenca4()));
            stmt.setObject(102, diagnostico.getMembroDoenca4());
            stmt.setObject(103, Auxiliar.isZeroNull(diagnostico.getDoenca5()));
            stmt.setObject(104, diagnostico.getMembroDoenca5());
            stmt.setObject(105, Auxiliar.isZeroNull(diagnostico.getDoenca6()));
            stmt.setObject(106, diagnostico.getMembroDoenca6());
            stmt.setObject(107, Auxiliar.isZeroNull(diagnostico.getDoenca7()));
            stmt.setObject(108, diagnostico.getMembroDoenca7());
            stmt.setObject(109, Auxiliar.isZeroNull(diagnostico.getDoenca8()));
            stmt.setObject(110, diagnostico.getMembroDoenca8());
            stmt.setObject(111, Auxiliar.isZeroNull(diagnostico.getDoenca9()));
            stmt.setObject(112, diagnostico.getMembroDoenca9());
            stmt.setObject(113, Auxiliar.isZeroNull(diagnostico.getDoenca10()));
            stmt.setObject(114, diagnostico.getMembroDoenca10());
            stmt.setObject(115, Auxiliar.isZeroNull(diagnostico.getDoenca11()));
            stmt.setObject(116, diagnostico.getMembroDoenca11());
            stmt.setObject(117, Auxiliar.isZeroNull(diagnostico.getDoenca12()));
            stmt.setObject(118, diagnostico.getMembroDoenca12());
            stmt.setObject(119, Auxiliar.isZeroNull(diagnostico.getDoenca13()));
            stmt.setObject(120, diagnostico.getMembroDoenca13());
            stmt.setObject(121, Auxiliar.isZeroNull(diagnostico.getDoenca14()));
            stmt.setObject(122, diagnostico.getMembroDoenca14());
            stmt.setObject(123, Auxiliar.isZeroNull(diagnostico.getDoenca15()));
            stmt.setObject(124, diagnostico.getMembroDoenca15());
            stmt.setObject(125, Auxiliar.isZeroNull(diagnostico.getDoenca16()));
            stmt.setObject(126, diagnostico.getMembroDoenca16());
            stmt.setObject(127, Auxiliar.isZeroNull(diagnostico.getDetalheFinanDoacao()));
            stmt.setObject(128, Auxiliar.isZeroNull(diagnostico.getDetalheFinanAposen()));
            stmt.setObject(129, Auxiliar.isZeroNull(diagnostico.getDetalheFinanPensao()));
            stmt.setObject(130, Auxiliar.isZeroNull(diagnostico.getDetalheFinanSegDes()));
            stmt.setObject(131, Auxiliar.isZeroNull(diagnostico.getDetalheFinanInfor()));
            stmt.setObject(132, Auxiliar.isZeroNull(diagnostico.getDetalheFinanFormal()));
            stmt.setObject(133, Auxiliar.isZeroNull(diagnostico.getDetalheFinanBolsaF()));
            stmt.setObject(134, Auxiliar.isZeroNull(diagnostico.getDetalheFinanOutro()));
            stmt.setObject(135, diagnostico.getDetalheFinanOutroDescr());
            stmt.setObject(136, Auxiliar.isZeroNull(diagnostico.getGrauEscol()));
            stmt.setObject(137, Auxiliar.isZeroNull(diagnostico.getGrauEscolCompl()));
            stmt.setObject(138, Auxiliar.isZeroNull(diagnostico.getGrauEscolAnalfLer()));
            stmt.setObject(139, Auxiliar.isZeroNull(diagnostico.getGrauEscolAnalfEscr()));
            stmt.setObject(140, null);
            stmt.setObject(141, null);
            stmt.setObject(142, null);
            stmt.setObject(143, null);
            stmt.setObject(144, null);
            stmt.setObject(145, null);
            stmt.setObject(146, diagnostico.getProfRespFamilia());
            stmt.setObject(147, Auxiliar.isZeroNull(diagnostico.getNegocDebEner()));
            stmt.setObject(148, Auxiliar.isZeroNull(diagnostico.getNegocDebEnerValParc()));
            stmt.setObject(149, Auxiliar.isZeroNull(diagnostico.getNegocDebEnerQtdeParc()));
            stmt.setObject(150, Auxiliar.isZeroNull(diagnostico.getNegocDebEnerVenc()));
            stmt.setObject(151, Auxiliar.isZeroNull(diagnostico.getNegocDebAgua()));
            stmt.setObject(152, Auxiliar.isZeroNull(diagnostico.getNegocDebAguaValParc()));
            stmt.setObject(153, Auxiliar.isZeroNull(diagnostico.getNegocDebAguaQtdeParc()));
            stmt.setObject(154, Auxiliar.isZeroNull(diagnostico.getNegocDebAguaVenc()));
            stmt.setObject(155, diagnostico.getConheciObra());
            stmt.setObject(156, Auxiliar.isZeroNull(diagnostico.getBenefObraSan1()));
            stmt.setObject(157, Auxiliar.isZeroNull(diagnostico.getBenefObraSan2()));
            stmt.setObject(158, Auxiliar.isZeroNull(diagnostico.getBenefObraSan3()));
            stmt.setObject(159, Auxiliar.isZeroNull(diagnostico.getBenefObraSan4()));
            stmt.setObject(160, diagnostico.getObsGerais());
            stmt.setObject(161, diagnostico.getIdDiagnostico());
            stmt.setObject(162, diagnostico.getDtInsert());
            stmt.setObject(163, diagnostico.getDtNascCliente());
            stmt.setObject(164, diagnostico.getBenefDtNasc());
            
            stmt.executeUpdate();
        }
        catch(SQLException e) {            
            
            throw e;
        }
        finally {

            if(stmt != null) {
                
                stmt.close();
            }
        }
    }
    
    public void alterar(Diagnostico diagnostico) throws SQLException {

        PreparedStatement stmt = null;
        
        try {
            
            stmt = connection.prepareStatement(  
            "UPDATE TB_DIAGNOSTICO SET " + 
    		//"       ID_DIAGNOSTICO = ?, " +            
            "       ID_COMUNIDADE = ?, " +
            "       ID_EQUIPE = ?, " +
            "       ID_USER = ?, " +
            "       COORDX = ?, " +
            "       COORDY = ?, " +
            "       CODSERV = ?, " +
            "       ID_SITIMOVEL = ?, " +
            "       ID_TPCONSTR = ?, " +
            "       ID_TPINSTAL = ?, " +
            "       CATEGORIA1 = ?, " +
            "       CATEGORIA2 = ?, " +
            "       CATEGORIA3 = ?, " +
            "       CATEGORIA4 = ?, " +
            "       ID_TPUSO = ?, " +
            "       QTDECASAS = ?, " +
            "       TEMPOOCUP = ?, " +
            "       ATIVIDADE = ?, " +
            "       ENERGELETR = ?, " +
            "       ENERGELETRIRREG = ?, " +
            "       INSTALACAO = ?, " +
            "       MEDIDOR = ?, " +
            "       PAVIMEXISTE = ?, " +
            "       COLLIXOEXISTE = ?, " +
            "       ID_ABASTAGUA = ?, " +
            "       ABASTAGUAIRREG = ?, " +
            "       HIDROMETRO = ?, " +
            "       ID_DESTESGOTO = ?, " +
            "       NOME = ?, " +
            "       CPF = ?, " +
            "       RG = ?, " +
            "       NACIONALIDADE = ?, " +
            "       UFNASC = ?, " +
            "       MUNNASC = ?, " +            
            "       SEXO = ?, " +
            "       TELRES = ?, " +
            "       TELCEL = ?, " +
            "       ID_ESTADOCIVIL = ?, " +
            "       EMAIL = ?, " +
            "       ENDERECO = ?, " +
            "       NUMATUAL = ?, " +
            "       NUMANTIGO = ?, " +
            "       COMPL = ?, " +
            "       BAIRRO = ?, " +
            "       MUN = ?, " +
            "       UF = ?, " +
            "       CEP = ?, " +
            "       QTDEADULTO = ?, " +
            "       QTDECRIANCA = ?, " +
            "       POSSUICONTA = ?, " +
            "       BANCO = ?, " +
            "       POSSUICDEB = ?, " +
            "       RENDATOTAL = ?, " +
            "       RENDAPERCEUTIL = ?, " +
            "       MEIOTRANSP1 = ?, " +
            "       MEIOTRANSP2 = ?, " +
            "       MEIOTRANSP3 = ?, " +
            "       MEIOTRANSP4 = ?, " +
            "       MEIOTRANSP5 = ?, " +
            "       INTERNETACESS = ?, " +
            "       INTERNETWIFI = ?, " +
            "       INTERNET3G = ?, " +
            "       QTDECARRO = ?, " +
            "       QTDEMOTO = ?, " +
            "       QTDEBICICLETA = ?, " +
            "       BENEFBCPNUM = ?, " +
            "       BENEFNISNUM = ?, " +
            "       POSSUITARSOCIAL = ?, " +
            "       POSSUIBOLSAFAMIL = ?, " +
            "       BENEFENTREV = ?, " +
            "       BENEFNOME = ?, " +
            "       BENEFCPF = ?, " +
            "       BENEFRG = ?, " +
            "       BENEFSEXO = ?, " +
            "       BENEFOBS = ?, " +
            "       MAIOR59QTDE = ?, " +
            "       MENOR19QTDE = ?, " +
            "       MENOR1QTDE = ?, " +
            "       DEFVISUALQTDE = ?, " +
            "       DEFAUDITQTDE = ?, " +
            "       DEFFISQTDE = ?, " +
            "       DEFINTELECQTDE = ?, " +
            "       DEFOUTROSQTDE = ?, " +
            "       TRATCANCER = ?, " +
            "       TRATTUBER = ?, " +
            "       TRATHANSEN = ?, " +
            "       TRATMENTAL = ?, " +
            "       TRATESCLER = ?, " +
            "       TRATPARAL = ?, " +
            "       TRATHEPAT = ?, " +
            "       TRATCARDIAC = ?, " +
            "       TRATPARKINS = ?, " +
            "       TRATRENAL = ?, " +
            "       TRATOUTRO = ?, " +
            "       TRATOUTRODESC = ?, " +
            "       AMEBIASE = ?, " +
            "       AMBIASEMEMB = ?, " +
            "       GASTROENT = ?, " +
            "       GASTROENTMEMB = ?, " +
            "       GIARDIASE = ?, " +
            "       GIARDIASEMEMB = ?, " +
            "       FEBRETIFO = ?, " +
            "       FEBRETIFOMEMB = ?, " +
            "       HEPATITE = ?, " +
            "       HEPATITEMEMB = ?, " +
            "       COLERA = ?, " +
            "       COLERAMEMB = ?, " +
            "       ESQUITOSSO = ?, " +
            "       ESQUITOSSOMEMB = ?, " +
            "       ASCARIDIASE = ?, " +
            "       ASCARIDIASEMEMB = ?, " +
            "       TENIASE = ?, " +
            "       TENIASEMEMB = ?, " +
            "       LEPTOSPIROSE = ?, " +
            "       LEPTOSPIROSEMEMB = ?, " +
            "       MALARIA = ?, " +
            "       MALARIAMEMB = ?, " +
            "       DENGUE = ?, " +
            "       DENGUEMEMB = ?, " +
            "       FEBREAMAR = ?, " +
            "       FEBREAMARMEMB = ?, " +
            "       CHIKUNG = ?, " +
            "       CHIKUNGMEMB = ?, " +
            "       ZICAVIRUS = ?, " +
            "       ZICAVIRUSMEMB = ?, " +
            "       CIANOBACTER = ?, " +
            "       CIANOBACTERMEMB = ?, " +
            "       VALDOACAO = ?, " +
            "       VALAPOSENT = ?, " +
            "       VALPENSAOALIMEN = ?, " +
            "       VALSEGDESEMPR = ?, " +
            "       VALEMPRINFORMAL = ?, " +
            "       VALEMPRFORMAL = ?, " +
            "       VALBOLSAFAMIL = ?, " +
            "       VALOUTRO = ?, " +
            "       VALOUTRDESCR = ?, " +
            "       ID_GRAUESCOL = ?, " +
            "       GRAUESCOLCOMPL = ?, " +
            "       SABEESCREVER = ?, " +
            "       SABELER = ?, " +
            "       ENSINOFUNMEMBRO = ?, " +
            "       ENSINOMEDMEMBRO = ?, " +
            "       ENSINOSUPMEMBRO = ?, " +
            "       ENSINOPOSMEMBRO = ?, " +
            "       ENSINOCURMEMBRO = ?, " +
            "       ANALFABMEMBRO = ?, " +
            "       PROFISSRESPFAMIL = ?, " +
            "       ENERGNEGOC = ?, " +
            "       ENERGNEGOCPARCVAL = ?, " +
            "       ENERGNEGOCPARCQTDE = ?, " +
            "       ENERGNEGOCDIA = ?, " +
            "       AGUANEGOC = ?, " +
            "       AGUANEGOCPARCVAL = ?, " +
            "       AGUANEGOCPARCQTDE = ?, " +
            "       AGUANEGOCDIA = ?, " +
            "       OBRASANEAMCONHE = ?, " +
            "       BENEFOBRASANSAUDE = ?, " +
            "       BENEFOBRASANECO = ?, " +
            "       BENEFOBRASANIMOB = ?, " +
            "       BENEFOBRASANTURI = ?, " +
            "       OBSGERAIS = ?, " +
            "       ID_DIAGNOSTICOCEL = ?, " +
			"       DATA = ?, " +
			"       DTNASC = ?, " +
            "       BENEFDTNASC = ?, " +            
            "       DTINSERT = sysdate() " +
            "WHERE  ID_DIAGNOSTICO = ? "        
            );
            
            //stmt.setObject(1, diagnostico.getIdDiagnostico());            
            stmt.setObject(1, Auxiliar.isZeroNull(diagnostico.getIdComunidade()));
            stmt.setObject(2, Auxiliar.isZeroNull(diagnostico.getIdEquipe()));
            stmt.setObject(3, 19);
            stmt.setObject(4, diagnostico.getCoordX());
            stmt.setObject(5, diagnostico.getCoordY());
            stmt.setObject(6, null);
            stmt.setObject(7, Auxiliar.isZeroNull(diagnostico.getSituacaoImovel()));
            stmt.setObject(8, Auxiliar.isZeroNull(diagnostico.getTipoContrucao()));
            stmt.setObject(9, Auxiliar.isZeroNull(diagnostico.getTpInstalacao()));
            stmt.setObject(10, Auxiliar.isZeroNull(diagnostico.getCategoriaImovel1()));
            stmt.setObject(11, Auxiliar.isZeroNull(diagnostico.getCategoriaImovel2()));
            stmt.setObject(12, Auxiliar.isZeroNull(diagnostico.getCategoriaImovel3()));
            stmt.setObject(13, Auxiliar.isZeroNull(diagnostico.getCategoriaImovel4()));
            stmt.setObject(14, Auxiliar.isZeroNull(diagnostico.getTpUsoImovel()));
            stmt.setObject(15, Auxiliar.isZeroNull(diagnostico.getQtdeCasa()));
            stmt.setObject(16, Auxiliar.isZeroNull(diagnostico.getTempoOcupacao()));
            stmt.setObject(17, diagnostico.getAtividadeImovel());
            stmt.setObject(18, Auxiliar.isZeroNull(diagnostico.getEnergiaEletr()));
            stmt.setObject(19, Auxiliar.isZeroNull(diagnostico.getEnergiaEletrIrreg()));
            stmt.setObject(20, diagnostico.getNumInstalacao());
            stmt.setObject(21, diagnostico.getNumMedidor());
            stmt.setObject(22, Auxiliar.isZeroNull(diagnostico.getCalcamento()));
            stmt.setObject(23, Auxiliar.isZeroNull(diagnostico.getColetaLixo()));
            stmt.setObject(24, Auxiliar.isZeroNull(diagnostico.getAbastAgua()));
            stmt.setObject(25, Auxiliar.isZeroNull(diagnostico.getAbastAguaIrreg()));
            stmt.setObject(26, diagnostico.getHidrometro());
            stmt.setObject(27, Auxiliar.isZeroNull(diagnostico.getDestinoEsgoto()));
            stmt.setObject(28, diagnostico.getNomeCliente());
            stmt.setObject(29, diagnostico.getCpfCliente());
            stmt.setObject(30, diagnostico.getRgCliente());
            stmt.setObject(31, Auxiliar.isZeroNull(diagnostico.getNacionalidade()));
            stmt.setObject(32, diagnostico.getEstadoNasc());
            stmt.setObject(33, diagnostico.getMunicipioNasc());
            stmt.setObject(34, diagnostico.getSexo());
            stmt.setObject(35, Auxiliar.isZeroNull(diagnostico.getTelResidencia()));
            stmt.setObject(36, Auxiliar.isZeroNull(diagnostico.getTelCelular()));
            stmt.setObject(37, Auxiliar.isZeroNull(diagnostico.getEstadoCivil()));
            stmt.setObject(38, diagnostico.getEmail());
            stmt.setObject(39, diagnostico.getEndereco());
            stmt.setObject(40, Auxiliar.isZeroNull(diagnostico.getNumAtual()));
            stmt.setObject(41, Auxiliar.isZeroNull(diagnostico.getNumAntigo()));
            stmt.setObject(42, diagnostico.getComplemento());
            stmt.setObject(43, diagnostico.getBairro());
            stmt.setObject(44, diagnostico.getMunicipio());
            stmt.setObject(45, diagnostico.getEstado());
            stmt.setObject(46, diagnostico.getCep());
            stmt.setObject(47, Auxiliar.isZeroNull(diagnostico.getQtdeAdulto()));
            stmt.setObject(48, Auxiliar.isZeroNull(diagnostico.getQtdeCrianca()));
            stmt.setObject(49, Auxiliar.isZeroNull(diagnostico.getContaExiste()));
            stmt.setObject(50, diagnostico.getBanco());
            stmt.setObject(51, Auxiliar.isZeroNull(diagnostico.getCartaoDebitoExiste()));
            stmt.setObject(52, Auxiliar.isZeroNull(diagnostico.getRendaTotal()));
            stmt.setObject(53, Auxiliar.isZeroNull(diagnostico.getPercentualMedio()));
            stmt.setObject(54, Auxiliar.isZeroNull(diagnostico.getMeioTransporte1()));
            stmt.setObject(55, Auxiliar.isZeroNull(diagnostico.getMeioTransporte2()));
            stmt.setObject(56, Auxiliar.isZeroNull(diagnostico.getMeioTransporte3()));
            stmt.setObject(57, Auxiliar.isZeroNull(diagnostico.getMeioTransporte4()));
            stmt.setObject(58, Auxiliar.isZeroNull(diagnostico.getMeioTransporte5()));
            stmt.setObject(59, Auxiliar.isZeroNull(diagnostico.getAcessoInternet()));
            stmt.setObject(60, Auxiliar.isZeroNull(diagnostico.getAcessoInternetTp1()));
            stmt.setObject(61, Auxiliar.isZeroNull(diagnostico.getAcessoInternetTp2()));
            stmt.setObject(62, Auxiliar.isZeroNull(diagnostico.getQtdeCarro()));
            stmt.setObject(63, Auxiliar.isZeroNull(diagnostico.getQtdeMoto()));
            stmt.setObject(64, Auxiliar.isZeroNull(diagnostico.getQtdeBicicleta()));
            stmt.setObject(65, diagnostico.getBenefBcpNum());
            stmt.setObject(66, diagnostico.getBenefNisNum());
            stmt.setObject(67, Auxiliar.isZeroNull(diagnostico.getTarifaSocialAgua()));
            stmt.setObject(68, Auxiliar.isZeroNull(diagnostico.getBolsaFamilia()));
            stmt.setObject(69, null);
            stmt.setObject(70, diagnostico.getBenefNome());
            stmt.setObject(71, diagnostico.getBenefCpf());
            stmt.setObject(72, diagnostico.getBenefRG());
            stmt.setObject(73, diagnostico.getBenefSexo());
            stmt.setObject(74, diagnostico.getBenefObs());
            stmt.setObject(75, Auxiliar.isZeroNull(diagnostico.getMembroVulner60Anos()));
            stmt.setObject(76, Auxiliar.isZeroNull(diagnostico.getMembroVulner18Anos()));
            stmt.setObject(77, Auxiliar.isZeroNull(diagnostico.getMembroVulner1Ano()));
            stmt.setObject(78, Auxiliar.isZeroNull(diagnostico.getPessoasDefVisu()));
            stmt.setObject(79, Auxiliar.isZeroNull(diagnostico.getPessoasDefAud()));
            stmt.setObject(80, Auxiliar.isZeroNull(diagnostico.getPessoasDefFis()));
            stmt.setObject(81, Auxiliar.isZeroNull(diagnostico.getPessoasDefIntel()));
            stmt.setObject(82, Auxiliar.isZeroNull(diagnostico.getPessoasDefOutr()));
            stmt.setObject(83, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca1()));
            stmt.setObject(84, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca2()));
            stmt.setObject(85, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca3()));
            stmt.setObject(86, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca4()));
            stmt.setObject(87, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca5()));
            stmt.setObject(88, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca6()));
            stmt.setObject(89, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca7()));
            stmt.setObject(90, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca8()));
            stmt.setObject(91, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca9()));
            stmt.setObject(92, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca10()));
            stmt.setObject(93, Auxiliar.isZeroNull(diagnostico.getMembroTratDoenca11()));
            stmt.setObject(94, diagnostico.getMembroTratDoencaDesc());
            stmt.setObject(95, Auxiliar.isZeroNull(diagnostico.getDoenca1()));
            stmt.setObject(96, diagnostico.getMembroDoenca1());
            stmt.setObject(97, Auxiliar.isZeroNull(diagnostico.getDoenca2()));
            stmt.setObject(98, diagnostico.getMembroDoenca2());
            stmt.setObject(99, Auxiliar.isZeroNull(diagnostico.getDoenca3()));
            stmt.setObject(100, diagnostico.getMembroDoenca3());
            stmt.setObject(101, Auxiliar.isZeroNull(diagnostico.getDoenca4()));
            stmt.setObject(102, diagnostico.getMembroDoenca4());
            stmt.setObject(103, Auxiliar.isZeroNull(diagnostico.getDoenca5()));
            stmt.setObject(104, diagnostico.getMembroDoenca5());
            stmt.setObject(105, Auxiliar.isZeroNull(diagnostico.getDoenca6()));
            stmt.setObject(106, diagnostico.getMembroDoenca6());
            stmt.setObject(107, Auxiliar.isZeroNull(diagnostico.getDoenca7()));
            stmt.setObject(108, diagnostico.getMembroDoenca7());
            stmt.setObject(109, Auxiliar.isZeroNull(diagnostico.getDoenca8()));
            stmt.setObject(110, diagnostico.getMembroDoenca8());
            stmt.setObject(111, Auxiliar.isZeroNull(diagnostico.getDoenca9()));
            stmt.setObject(112, diagnostico.getMembroDoenca9());
            stmt.setObject(113, Auxiliar.isZeroNull(diagnostico.getDoenca10()));
            stmt.setObject(114, diagnostico.getMembroDoenca10());
            stmt.setObject(115, Auxiliar.isZeroNull(diagnostico.getDoenca11()));
            stmt.setObject(116, diagnostico.getMembroDoenca11());
            stmt.setObject(117, Auxiliar.isZeroNull(diagnostico.getDoenca12()));
            stmt.setObject(118, diagnostico.getMembroDoenca12());
            stmt.setObject(119, Auxiliar.isZeroNull(diagnostico.getDoenca13()));
            stmt.setObject(120, diagnostico.getMembroDoenca13());
            stmt.setObject(121, Auxiliar.isZeroNull(diagnostico.getDoenca14()));
            stmt.setObject(122, diagnostico.getMembroDoenca14());
            stmt.setObject(123, Auxiliar.isZeroNull(diagnostico.getDoenca15()));
            stmt.setObject(124, diagnostico.getMembroDoenca15());
            stmt.setObject(125, Auxiliar.isZeroNull(diagnostico.getDoenca16()));
            stmt.setObject(126, diagnostico.getMembroDoenca16());
            stmt.setObject(127, Auxiliar.isZeroNull(diagnostico.getDetalheFinanDoacao()));
            stmt.setObject(128, Auxiliar.isZeroNull(diagnostico.getDetalheFinanAposen()));
            stmt.setObject(129, Auxiliar.isZeroNull(diagnostico.getDetalheFinanPensao()));
            stmt.setObject(130, Auxiliar.isZeroNull(diagnostico.getDetalheFinanSegDes()));
            stmt.setObject(131, Auxiliar.isZeroNull(diagnostico.getDetalheFinanInfor()));
            stmt.setObject(132, Auxiliar.isZeroNull(diagnostico.getDetalheFinanFormal()));
            stmt.setObject(133, Auxiliar.isZeroNull(diagnostico.getDetalheFinanBolsaF()));
            stmt.setObject(134, Auxiliar.isZeroNull(diagnostico.getDetalheFinanOutro()));
            stmt.setObject(135, diagnostico.getDetalheFinanOutroDescr());
            stmt.setObject(136, Auxiliar.isZeroNull(diagnostico.getGrauEscol()));
            stmt.setObject(137, Auxiliar.isZeroNull(diagnostico.getGrauEscolCompl()));
            stmt.setObject(138, Auxiliar.isZeroNull(diagnostico.getGrauEscolAnalfLer()));
            stmt.setObject(139, Auxiliar.isZeroNull(diagnostico.getGrauEscolAnalfEscr()));
            stmt.setObject(140, null);
            stmt.setObject(141, null);
            stmt.setObject(142, null);
            stmt.setObject(143, null);
            stmt.setObject(144, null);
            stmt.setObject(145, null);
            stmt.setObject(146, diagnostico.getProfRespFamilia());
            stmt.setObject(147, Auxiliar.isZeroNull(diagnostico.getNegocDebEner()));
            stmt.setObject(148, Auxiliar.isZeroNull(diagnostico.getNegocDebEnerValParc()));
            stmt.setObject(149, Auxiliar.isZeroNull(diagnostico.getNegocDebEnerQtdeParc()));
            stmt.setObject(150, Auxiliar.isZeroNull(diagnostico.getNegocDebEnerVenc()));
            stmt.setObject(151, Auxiliar.isZeroNull(diagnostico.getNegocDebAgua()));
            stmt.setObject(152, Auxiliar.isZeroNull(diagnostico.getNegocDebAguaValParc()));
            stmt.setObject(153, Auxiliar.isZeroNull(diagnostico.getNegocDebAguaQtdeParc()));
            stmt.setObject(154, Auxiliar.isZeroNull(diagnostico.getNegocDebAguaVenc()));
            stmt.setObject(155, diagnostico.getConheciObra());
            stmt.setObject(156, Auxiliar.isZeroNull(diagnostico.getBenefObraSan1()));
            stmt.setObject(157, Auxiliar.isZeroNull(diagnostico.getBenefObraSan2()));
            stmt.setObject(158, Auxiliar.isZeroNull(diagnostico.getBenefObraSan3()));
            stmt.setObject(159, Auxiliar.isZeroNull(diagnostico.getBenefObraSan4()));
            stmt.setObject(160, diagnostico.getObsGerais());
            stmt.setObject(161, diagnostico.getIdDiagnostico());
            stmt.setObject(162, diagnostico.getDtInsert());
            stmt.setObject(163, diagnostico.getDtNascCliente());
            stmt.setObject(164, diagnostico.getBenefDtNasc());
            stmt.setObject(165, diagnostico.getIdDiagnostico());   
            
            stmt.executeUpdate();
        }
        catch(SQLException e) {            
            
            throw e;
        }
        finally {

            if(stmt != null) {
                
                stmt.close();
            }
        }
    }

    public Long buscarId(Long idEquipe, Long idComunidade, Long idDiagnosticoCel) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Long id = null;
        
        try {
            
            stmt = connection.prepareStatement(
    		"SELECT   ID_DIAGNOSTICO " +
    		"FROM     TB_DIAGNOSTICO " +
    		"WHERE    ID_EQUIPE = ? " +
    		"AND      ID_COMUNIDADE = ? " +
    		"AND      ID_DIAGNOSTICOCEL = ? " +
    		"ORDER BY DTINSERT DESC "
            );
            
            stmt.setObject(1, idEquipe);
            stmt.setObject(2, idComunidade);
            stmt.setObject(3, idDiagnosticoCel);
            
            rs = stmt.executeQuery();

            if(rs.next()) {
                
                id = rs.getLong("ID_DIAGNOSTICO");
            }

            return id;
        }
        catch(SQLException e) {            
            
            throw e;
        }
        finally {

            if(stmt != null) {
                
                stmt.close();
            }
            if(rs != null) {              
                
                rs.close();
            }
        }
    }
    
    public Long criarId() throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Long id = null;
        
        try {
            
            stmt = connection.prepareStatement("SELECT SEQ_RET_SS.NEXTVAL AS RET_SS FROM DUAL");
            
            rs = stmt.executeQuery();

            if(rs.next()) {
                
                id = rs.getLong("RET_SS");
            }

            return id;
        }
        catch(SQLException e) {            
            
            throw e;
        }
        finally {

            if(stmt != null) {
                
                stmt.close();
            }
            if(rs != null) {              
                
                rs.close();
            }
        }
    }
    
    public boolean existe(Long retSS) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            
            stmt = connection.prepareStatement("SELECT * FROM RET_SS WHERE RET_SS = ? ");
            
            stmt.setObject(1, retSS);
            
            rs = stmt.executeQuery();

            if(rs.next()) {
                
                return true;
            }

            return false;
        }
        catch(SQLException e) {            
            
            throw e;
        }
        finally {

            if(stmt != null) {
                
                stmt.close();
            }
            if(rs != null) {              
                
                rs.close();
            }
        }
    }   

    public void logar(String srvOrdem) throws SQLException {

        PreparedStatement stmt = null;
        
        try {
            
            stmt = connection.prepareStatement("INSERT INTO RET_ORDEMLOG SELECT * FROM RET_ORDEM WHERE SRV_ORDEM = ? ");
            stmt.setString(1, srvOrdem);
            stmt.executeUpdate();
        }
        catch(SQLException e) {            
            
            throw e;
        }
        finally {

            if(stmt != null) {
                
                stmt.close();
            }
        }
    }     
}

