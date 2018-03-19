package br.com.sisjupiter.bo;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sisjupiter.auxiliar.Auxiliar;
import br.com.sisjupiter.connection.ConnectionFactory;
import br.com.sisjupiter.dao.ComunidadeDAO;
import br.com.sisjupiter.dao.DiagnosticoDAO;
import br.com.sisjupiter.dao.EquipeDAO;
import br.com.sisjupiter.enuns.DestinoEsgotoEnum;
import br.com.sisjupiter.enuns.EstadoCivilEnum;
import br.com.sisjupiter.enuns.EstadosEnum;
import br.com.sisjupiter.enuns.FormaAbastecimentoEnum;
import br.com.sisjupiter.enuns.GrauEnsinoEnum;
import br.com.sisjupiter.enuns.NacionalidadeEnum;
import br.com.sisjupiter.enuns.SexoEnum;
import br.com.sisjupiter.enuns.SimNaoEnum;
import br.com.sisjupiter.enuns.SituacaoEnsinoEnum;
import br.com.sisjupiter.enuns.SituacaoImovelEnum;
import br.com.sisjupiter.enuns.TipoConstrucaoEnum;
import br.com.sisjupiter.enuns.TipoInstalacaoEnum;
import br.com.sisjupiter.enuns.TipoUsoImovelEnum;
import br.com.sisjupiter.modelo.Comunidade;
import br.com.sisjupiter.modelo.Diagnostico;
import br.com.sisjupiter.modelo.Equipe;
import br.com.sisjupiter.modelo.User;

public class ServicoBO extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String relat = "";
		Connection connection = null;
        try {
            if (req.getParameter("acao") != null) {
                relat = req.getParameter("acao");
            }

            if (relat.equals("consultar")) {
            	req.setAttribute("aviso", "");
                req.getRequestDispatcher("/jsp/servico/consulta.jsp").forward(req, res);
            } 
            else if (relat.equals("pesquisar")) {
            	SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            	try {
	            	String dtInicio = formatoBanco.format(formatoData.parse(req.getParameter("dtInicio")));
	            	String dtFim = formatoBanco.format(formatoData.parse(req.getParameter("dtFim")));
	            	
	            	connection = ConnectionFactory.getConnection();
	            	DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO(connection);
	            	List<Diagnostico> listaServicos = diagnosticoDAO.listarPorPeriodo(dtInicio, dtFim);
	            	
	            	if(!listaServicos.isEmpty()) {
	            		List<SituacaoImovelEnum> listaSituacaoImovel = SituacaoImovelEnum.listCodigos();
	            		List<FormaAbastecimentoEnum> listaAbastecimentoAgua = FormaAbastecimentoEnum.listCodigos();
		            	List<DestinoEsgotoEnum> listaDestinoEsgoto = DestinoEsgotoEnum.listCodigos();
		            	
		            	req.setAttribute("aviso", "");
		            	req.setAttribute("listaSituacaoImovel", listaSituacaoImovel);
		            	req.setAttribute("listaAbastecimentoAgua", listaAbastecimentoAgua);
		            	req.setAttribute("listaDestinoEsgoto", listaDestinoEsgoto);
	            		req.setAttribute("lista", listaServicos);
	            		req.setAttribute("dtInicio", req.getParameter("dtInicio"));
	            		req.setAttribute("dtFim", req.getParameter("dtFim"));
	            		req.getRequestDispatcher("/jsp/servico/lista.jsp").forward(req, res);
	            	}
	            	else {
	            		req.setAttribute("aviso", "Nenhum resultado encontrado para o periodo solicitado!");
	            		req.getRequestDispatcher("/jsp/servico/consulta.jsp").forward(req, res);
	            	}
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
            		req.getRequestDispatcher("/jsp/servico/consulta.jsp").forward(req, res);
				}
            } 
            else if (relat.equals("detalhe")) {
            	SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            	connection = ConnectionFactory.getConnection();
            	try {
	            	Long id = Long.parseLong(req.getParameter("id"));
	            	DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO(connection);
	            	Diagnostico diagnostico = diagnosticoDAO.buscarPorId(id);
	            	
	            	EquipeDAO equipeDAO = new EquipeDAO(connection);
	            	List<Equipe> listaEquipe = equipeDAO.listarTodos();
	            	
	            	ComunidadeDAO comunidadeDAO = new ComunidadeDAO(connection);
	            	List<Comunidade> listaComunidades = comunidadeDAO.listarTodos();
	            	
	            	List<TipoConstrucaoEnum> listaTpContrucao = TipoConstrucaoEnum.listCodigos();
	            	List<TipoInstalacaoEnum> listaTpInstalacao = TipoInstalacaoEnum.listCodigos();
	            	List<SituacaoImovelEnum> listaSituacaoImovel = SituacaoImovelEnum.listCodigos();
	            	List<TipoUsoImovelEnum> listaTipoImovel = TipoUsoImovelEnum.listCodigos();
	            	List<SimNaoEnum> listaSimNao = SimNaoEnum.listCodigos();
	            	List<FormaAbastecimentoEnum> listaAbastecimentoAgua = FormaAbastecimentoEnum.listCodigos();
	            	List<DestinoEsgotoEnum> listaDestinoEsgoto = DestinoEsgotoEnum.listCodigos();
	            	List<EstadosEnum> listaEstados = EstadosEnum.listCodigos();
	            	List<SexoEnum> listaSexo = SexoEnum.listCodigos();
	            	List<NacionalidadeEnum> listaNacionalidade = NacionalidadeEnum.listCodigos();
	            	List<EstadoCivilEnum> listaEstadoCivil = EstadoCivilEnum.listCodigos();
	            	List<GrauEnsinoEnum> listaGrauEnsino = GrauEnsinoEnum.listCodigos();
	            	List<SituacaoEnsinoEnum> listaSituacaoEnsino = SituacaoEnsinoEnum.listCodigos();
	            	
	            	req.setAttribute("listaTpContrucao", listaTpContrucao);
	            	req.setAttribute("listaTpInstalacao", listaTpInstalacao);
	            	req.setAttribute("listaSituacaoImovel", listaSituacaoImovel);
	            	req.setAttribute("listaTipoImovel", listaTipoImovel);
	            	req.setAttribute("listaSimNao", listaSimNao);
	            	req.setAttribute("listaAbastecimentoAgua", listaAbastecimentoAgua);
	            	req.setAttribute("listaDestinoEsgoto", listaDestinoEsgoto);
	            	req.setAttribute("listaEstados", listaEstados);
	            	req.setAttribute("listaSexo", listaSexo);
	            	req.setAttribute("listaNacionalidade", listaNacionalidade);
	            	req.setAttribute("listaEstadoCivil", listaEstadoCivil);
	            	req.setAttribute("listaGrauEnsino", listaGrauEnsino);
	            	req.setAttribute("listaSituacaoEnsino", listaSituacaoEnsino);
	            	req.setAttribute("listaEquipe", listaEquipe);
	            	req.setAttribute("listaComunidades", listaComunidades);

	            	req.setAttribute("modelo", diagnostico);
	            	req.setAttribute("botao", "Alterar");
	            	req.setAttribute("aviso", "");
	            	req.setAttribute("sucesso", "");
	            	req.setAttribute("dtInicio", req.getParameter("dtInicio"));
            		req.setAttribute("dtFim", req.getParameter("dtFim"));
	            	req.getRequestDispatcher("/jsp/servico/formulario.jsp").forward(req, res);
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		
            		String dtInicio = formatoBanco.format(formatoData.parse(req.getParameter("dtInicio")));
	            	String dtFim = formatoBanco.format(formatoData.parse(req.getParameter("dtFim")));
            		
	            	DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO(connection);
	            	List<Diagnostico> listaServicos = diagnosticoDAO.listarPorPeriodo(dtInicio, dtFim);
	            	
            		List<SituacaoImovelEnum> listaSituacaoImovel = SituacaoImovelEnum.listCodigos();
            		List<FormaAbastecimentoEnum> listaAbastecimentoAgua = FormaAbastecimentoEnum.listCodigos();
	            	List<DestinoEsgotoEnum> listaDestinoEsgoto = DestinoEsgotoEnum.listCodigos();
	            	
	            	req.setAttribute("listaSituacaoImovel", listaSituacaoImovel);
	            	req.setAttribute("listaAbastecimentoAgua", listaAbastecimentoAgua);
	            	req.setAttribute("listaDestinoEsgoto", listaDestinoEsgoto);
            		req.setAttribute("lista", listaServicos);
            		
            		req.setAttribute("aviso", "Nao foi possivel mostrar o formulario, contate o suporte!");
            		req.getRequestDispatcher("/jsp/servico/lista.jsp").forward(req, res);
				}
            } 
            else if (relat.equals("cadastrar")) {
            	try {
            		connection = ConnectionFactory.getConnection();
	            	EquipeDAO equipeDAO = new EquipeDAO(connection);
	            	List<Equipe> listaEquipe = equipeDAO.listarTodos();
	            	
	            	ComunidadeDAO comunidadeDAO = new ComunidadeDAO(connection);
	            	List<Comunidade> listaComunidades = comunidadeDAO.listarTodos();
	            	
	            	List<TipoConstrucaoEnum> listaTpContrucao = TipoConstrucaoEnum.listCodigos();
	            	List<TipoInstalacaoEnum> listaTpInstalacao = TipoInstalacaoEnum.listCodigos();
	            	List<SituacaoImovelEnum> listaSituacaoImovel = SituacaoImovelEnum.listCodigos();
	            	List<TipoUsoImovelEnum> listaTipoImovel = TipoUsoImovelEnum.listCodigos();
	            	List<SimNaoEnum> listaSimNao = SimNaoEnum.listCodigos();
	            	List<FormaAbastecimentoEnum> listaAbastecimentoAgua = FormaAbastecimentoEnum.listCodigos();
	            	List<DestinoEsgotoEnum> listaDestinoEsgoto = DestinoEsgotoEnum.listCodigos();
	            	List<EstadosEnum> listaEstados = EstadosEnum.listCodigos();
	            	List<SexoEnum> listaSexo = SexoEnum.listCodigos();
	            	List<NacionalidadeEnum> listaNacionalidade = NacionalidadeEnum.listCodigos();
	            	List<EstadoCivilEnum> listaEstadoCivil = EstadoCivilEnum.listCodigos();
	            	List<GrauEnsinoEnum> listaGrauEnsino = GrauEnsinoEnum.listCodigos();
	            	List<SituacaoEnsinoEnum> listaSituacaoEnsino = SituacaoEnsinoEnum.listCodigos();
	            	
	            	req.setAttribute("listaTpContrucao", listaTpContrucao);
	            	req.setAttribute("listaTpInstalacao", listaTpInstalacao);
	            	req.setAttribute("listaSituacaoImovel", listaSituacaoImovel);
	            	req.setAttribute("listaTipoImovel", listaTipoImovel);
	            	req.setAttribute("listaSimNao", listaSimNao);
	            	req.setAttribute("listaAbastecimentoAgua", listaAbastecimentoAgua);
	            	req.setAttribute("listaDestinoEsgoto", listaDestinoEsgoto);
	            	req.setAttribute("listaEstados", listaEstados);
	            	req.setAttribute("listaSexo", listaSexo);
	            	req.setAttribute("listaNacionalidade", listaNacionalidade);
	            	req.setAttribute("listaEstadoCivil", listaEstadoCivil);
	            	req.setAttribute("listaGrauEnsino", listaGrauEnsino);
	            	req.setAttribute("listaSituacaoEnsino", listaSituacaoEnsino);
	            	req.setAttribute("listaEquipe", listaEquipe);
	            	req.setAttribute("listaComunidades", listaComunidades);
	            	
	            	req.setAttribute("aviso", "");
	            	req.setAttribute("sucesso", "");
	            	req.setAttribute("botao", "Cadastrar");
	                req.getRequestDispatcher("/jsp/servico/formulario.jsp").forward(req, res);
            	}
                catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("aviso", "Nao foi possivel mostrar o formulario, contate o suporte!");
            		req.getRequestDispatcher("/jsp/home.jsp").forward(req, res);
				}
            }
        	else if (relat.equals("inserir")) {
        		SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
        		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        		Diagnostico diagnostico = new Diagnostico();
        		connection = ConnectionFactory.getConnection();
        		try {

        			User user = (User) req.getSession().getAttribute("user");
	            	diagnostico.setIdUser(user.getIdUser());
	            	diagnostico.setDtInsert(Auxiliar.dataAtual());
	            	diagnostico.setIdEquipe(Auxiliar.converteLong(req.getParameter("cadastrante")));
	            	diagnostico.setData(formatoBanco.format(formatoData.parse(req.getParameter("dtExecucao"))));
	            	diagnostico.setCodServ(Auxiliar.converteLong(req.getParameter("codServico")));
	            	diagnostico.setIdComunidade(Auxiliar.converteLong(req.getParameter("comunidade")));
	            	diagnostico.setIdTpInstal(Auxiliar.converteInteger(req.getParameter("radioTpInst")));
	            	diagnostico.setIdTpConstr(Auxiliar.converteInteger(req.getParameter("radioTpConstrucao")));
	            	diagnostico.setIdSitImovel(Auxiliar.converteInteger(req.getParameter("radioSitImovel")));
	            	diagnostico.setCategoria1(Auxiliar.converteCheckBox(req.getParameter("checkTpImovelResidencia")));
	            	diagnostico.setCategoria2(Auxiliar.converteCheckBox(req.getParameter("checkTpImovelComercio")));
	            	diagnostico.setCategoria3(Auxiliar.converteCheckBox(req.getParameter("checkTpImovelIndustria")));
	            	diagnostico.setCategoria4(Auxiliar.converteCheckBox(req.getParameter("checkTpImovelPublica")));
	            	diagnostico.setIdTpUso(Auxiliar.converteInteger(req.getParameter("radioImovel")));
	            	diagnostico.setQtdeCasas(Auxiliar.converteInteger(req.getParameter("qtdeCasas")));
	            	diagnostico.setTempoOcup(Auxiliar.converteLong(req.getParameter("ocupacao")));
	            	diagnostico.setAtividade(req.getParameter("atividade"));
	            	diagnostico.setEnergEletr(Auxiliar.converteInteger(req.getParameter("radioEnergia")));
	            	diagnostico.setEnergEletrIrreg(Auxiliar.converteInteger(req.getParameter("radioEnergiaIrregular")));
	            	diagnostico.setInstalacao(req.getParameter("numeroInstalacao"));
	            	diagnostico.setMedidor(req.getParameter("numeroMedidor"));
	            	diagnostico.setPavimeExiste(Auxiliar.converteInteger(req.getParameter("radioPavimento")));
	            	diagnostico.setColLixoExiste(Auxiliar.converteInteger(req.getParameter("radioLixo")));
	            	diagnostico.setIdAbastAgua(Auxiliar.converteInteger(req.getParameter("radioAbastecimento")));
	            	diagnostico.setAbastAguaIrreg(Auxiliar.converteInteger(req.getParameter("radioAguaIrregular")));
	            	diagnostico.setHidrometro(req.getParameter("hidrometro"));
	            	diagnostico.setIdDestEsgoto(Auxiliar.converteInteger(req.getParameter("radioEsgoto")));
	            	diagnostico.setNome(req.getParameter("nomeCliente"));
	            	diagnostico.setCpf(req.getParameter("cpfCliente"));
	            	diagnostico.setRg(req.getParameter("rgCliente"));
	            	diagnostico.setMunNasc(req.getParameter("municipioNascimento"));
	            	diagnostico.setUfNasc(req.getParameter("estadoNascimento"));
	            	if(req.getParameter("dtNascimento") != null && !req.getParameter("dtNascimento").trim().isEmpty())
	            		diagnostico.setDtNasc(formatoBanco.format(formatoData.parse(req.getParameter("dtNascimento"))));
	            	diagnostico.setNacionalidade(Auxiliar.converteInteger(req.getParameter("radioNacionalidade")));
	            	diagnostico.setSexo(req.getParameter("radioSexo"));
	            	diagnostico.setIdEstadoCivil(Auxiliar.converteInteger(req.getParameter("radioEstadoCivil")));
	            	diagnostico.setTelRes(Auxiliar.converteInteger(req.getParameter("telefone")));
	            	diagnostico.setTelCel(Auxiliar.converteInteger(req.getParameter("celular")));
	            	diagnostico.setEndereco(req.getParameter("endereco"));
	            	diagnostico.setNumAtual(Auxiliar.converteInteger(req.getParameter("numeroAtualEndereco")));
	            	diagnostico.setNumAntigo(Auxiliar.converteInteger(req.getParameter("numeroAntigoEndereco")));
	            	diagnostico.setCompl(req.getParameter("complementoEndereco"));
	            	diagnostico.setBairro(req.getParameter("bairroEndereco"));
	            	diagnostico.setMun(req.getParameter("municipioEndereco"));
	            	diagnostico.setUf(req.getParameter("estadoEndereco"));
	            	diagnostico.setCep(req.getParameter("cepEndereco"));
	            	diagnostico.setQtdeAdulto(Auxiliar.converteInteger(req.getParameter("qtdeAdultos")));
	            	diagnostico.setQtdeCrianca(Auxiliar.converteInteger(req.getParameter("qtdeCriancas")));
	            	diagnostico.setPossuiConta(Auxiliar.converteInteger(req.getParameter("radioBanco")));
	            	diagnostico.setPossuiCDeb(Auxiliar.converteInteger(req.getParameter("radioCartaoDebito")));
	            	diagnostico.setBanco(req.getParameter("descBanco"));
	            	diagnostico.setRendaTotal(Auxiliar.converteBigDecimal(req.getParameter("rendaFamilia")));
	            	diagnostico.setRendaPerceUtil(Auxiliar.converteInteger(req.getParameter("financeiroMensal")));
	            	diagnostico.setMeioTransp1(Auxiliar.converteCheckBox(req.getParameter("checkTransporteCarro")));
	            	diagnostico.setMeioTransp2(Auxiliar.converteCheckBox(req.getParameter("checkTransporteOnibus")));
	            	diagnostico.setMeioTransp3(Auxiliar.converteCheckBox(req.getParameter("checkTransporteTrem")));
	            	diagnostico.setMeioTransp4(Auxiliar.converteCheckBox(req.getParameter("checkTransporteMetro")));
	            	diagnostico.setMeioTransp5(Auxiliar.converteCheckBox(req.getParameter("checkTransporteTaxi")));
	            	diagnostico.setInternetAcess(Auxiliar.converteInteger(req.getParameter("radioInternet")));
	            	diagnostico.setInternetWifi(Auxiliar.converteInteger(req.getParameter("checkWifi")));
	            	diagnostico.setInternet3g(Auxiliar.converteInteger(req.getParameter("check3g")));
	            	diagnostico.setQtdeCarro(Auxiliar.converteInteger(req.getParameter("qtdeCarro")));
	            	diagnostico.setQtdeMoto(Auxiliar.converteInteger(req.getParameter("qtdeMoto")));
	            	diagnostico.setQtdeBicicleta(Auxiliar.converteInteger(req.getParameter("qtdeBicicleta")));
	            	diagnostico.setBenefBCPNum(req.getParameter("numeroBPC"));
	            	diagnostico.setBenefNISNum(req.getParameter("nis"));
	            	diagnostico.setPossuiTarSocial(Auxiliar.converteInteger(req.getParameter("radioTarifaAgua")));
	            	diagnostico.setPossuiBolsaFamil(Auxiliar.converteInteger(req.getParameter("radioBolsaFamilia")));
	            	diagnostico.setBenefNome(req.getParameter("nomeNTitular"));
	            	diagnostico.setBenefCpf(req.getParameter("cpfNTitular"));
	            	diagnostico.setBenefRg(req.getParameter("rgNTitular"));
	            	if(req.getParameter("dtNascimentoNTitular") != null && !req.getParameter("dtNascimentoNTitular").trim().isEmpty())
	            		diagnostico.setBenefDtNasc(formatoBanco.format(formatoData.parse(req.getParameter("dtNascimentoNTitular"))));
	            	diagnostico.setBenefSexo(req.getParameter("radioSexoNTitular"));
	            	diagnostico.setBenefObs(req.getParameter("observacoes"));
	            	diagnostico.setMaior59Qtde(Auxiliar.converteInteger(req.getParameter("qtdeIdosos")));
	            	diagnostico.setMenor19Qtde(Auxiliar.converteInteger(req.getParameter("qtdeAdolescente")));
	            	diagnostico.setMenor1Qtde(Auxiliar.converteInteger(req.getParameter("qtdeBebes")));
	            	diagnostico.setDefVisualQtde(Auxiliar.converteInteger(req.getParameter("defVisual")));
	            	diagnostico.setDefAuditQtde(Auxiliar.converteInteger(req.getParameter("defAuditivo")));
	            	diagnostico.setDefFisQtde(Auxiliar.converteInteger(req.getParameter("defFisico")));
	            	diagnostico.setDefIntelecQtde(Auxiliar.converteInteger(req.getParameter("defIntelectual")));
	            	diagnostico.setDefOutrosQtde(Auxiliar.converteInteger(req.getParameter("defOutros")));
	            	diagnostico.setTratCancer(Auxiliar.converteCheckBox(req.getParameter("checkCancer")));
	            	diagnostico.setTratHansen(Auxiliar.converteCheckBox(req.getParameter("checkHanseniase")));
	            	diagnostico.setTratMental(Auxiliar.converteCheckBox(req.getParameter("checkMental")));
	            	diagnostico.setTratEscler(Auxiliar.converteCheckBox(req.getParameter("checkEsclerose")));
	            	diagnostico.setTratParal(Auxiliar.converteCheckBox(req.getParameter("checkParalisia")));
	            	diagnostico.setTratHepat(Auxiliar.converteCheckBox(req.getParameter("checkHepatica")));
	            	diagnostico.setTratCardiac(Auxiliar.converteCheckBox(req.getParameter("checkCardiaca")));
	            	diagnostico.setTratParkins(Auxiliar.converteCheckBox(req.getParameter("checkParkinson")));
	            	diagnostico.setTratRenal(Auxiliar.converteCheckBox(req.getParameter("checkRenais")));
	            	diagnostico.setTratOutro(Auxiliar.converteCheckBox(req.getParameter("outroDoenca")));
	            	diagnostico.setTratOutroDesc(req.getParameter("outroDoenca"));
	            	diagnostico.setAmebiase(Auxiliar.converteCheckBox(req.getParameter("checkAmebiase")));
	            	diagnostico.setAmebiaseMemb(req.getParameter("amebiase"));
	            	diagnostico.setGastroent(Auxiliar.converteCheckBox(req.getParameter("checkGastroenterite")));
	            	diagnostico.setGastroentMemb(req.getParameter("gastroenterite"));
	            	diagnostico.setGiardiase(Auxiliar.converteCheckBox(req.getParameter("checkGiardiase")));
	            	diagnostico.setGiardiaseMemb(req.getParameter("giardiase"));
	            	diagnostico.setFebreTifo(Auxiliar.converteCheckBox(req.getParameter("checkTifoide")));
	            	diagnostico.setFebreTifoMemb(req.getParameter("tifoide"));
	            	diagnostico.setHepatite(Auxiliar.converteCheckBox(req.getParameter("checkHepatite")));
	            	diagnostico.setHepatiteMemb(req.getParameter("hepatite"));
	            	diagnostico.setColera(Auxiliar.converteCheckBox(req.getParameter("checkColera")));
	            	diagnostico.setColeraMemb(req.getParameter("colera"));
	            	diagnostico.setEsquitosso(Auxiliar.converteCheckBox(req.getParameter("checkEsquistossomose")));
	            	diagnostico.setEsquitossoMemb(req.getParameter("esquistossomose"));
	            	diagnostico.setAscaridiase(Auxiliar.converteCheckBox(req.getParameter("checkAscaridiase")));
	            	diagnostico.setAscaridiaseMemb(req.getParameter("ascaridiase"));
	            	diagnostico.setTeniase(Auxiliar.converteCheckBox(req.getParameter("checkTeniase")));
	            	diagnostico.setTeniaseMemb(req.getParameter("teniase"));
	            	diagnostico.setLeptospirose(Auxiliar.converteCheckBox(req.getParameter("checkLeptospirose")));
	            	diagnostico.setLeptospiroseMemb(req.getParameter("leptospirose"));
	            	diagnostico.setMalaria(Auxiliar.converteCheckBox(req.getParameter("checkMalaria")));
	            	diagnostico.setMalariaMemb(req.getParameter("malaria"));
	            	diagnostico.setDengue(Auxiliar.converteCheckBox(req.getParameter("checkDengue")));
	            	diagnostico.setDengueMemb(req.getParameter("dengue"));
	            	diagnostico.setFebreAmar(Auxiliar.converteCheckBox(req.getParameter("checkFebreAmarela")));
	            	diagnostico.setFebreAmarMemb(req.getParameter("febreAmarela"));
	            	diagnostico.setChikung(Auxiliar.converteCheckBox(req.getParameter("checkChikungunya")));
	            	diagnostico.setChikungMemb(req.getParameter("chikungunya"));
	            	diagnostico.setZicaVirus(Auxiliar.converteCheckBox(req.getParameter("checkZika")));
	            	diagnostico.setZicaVirusMemb(req.getParameter("zika"));
	            	diagnostico.setCianobacter(Auxiliar.converteCheckBox(req.getParameter("checkCianobacterias")));
	            	diagnostico.setCianobacterMemb(req.getParameter("cianobacterias"));
	            	diagnostico.setValDoacao(Auxiliar.converteBigDecimal(req.getParameter("valorDoacao")));
	            	diagnostico.setValAposent(Auxiliar.converteBigDecimal(req.getParameter("valorAposentadoria")));
	            	diagnostico.setValPensaoAlimen(Auxiliar.converteBigDecimal(req.getParameter("valorPensao")));
	            	diagnostico.setValSegDesempr(Auxiliar.converteBigDecimal(req.getParameter("valorSeguroDesemp")));
	            	diagnostico.setValEmprInformal(Auxiliar.converteBigDecimal(req.getParameter("valorSemCarteira")));
	            	diagnostico.setValEmprFormal(Auxiliar.converteBigDecimal(req.getParameter("valorComCarteira")));
	            	diagnostico.setValBolsaFamil(Auxiliar.converteBigDecimal(req.getParameter("valorBolsaFamilia")));
	            	diagnostico.setValOutro(Auxiliar.converteBigDecimal(req.getParameter("valorOutros")));
	            	diagnostico.setValOutroDescr(req.getParameter("valorOutrosDesc"));
	            	diagnostico.setIdGrauEscol(Auxiliar.converteInteger(req.getParameter("radioEnsino")));
	            	diagnostico.setGrauEscolCompl(Auxiliar.converteInteger(req.getParameter("radioEnsinoSituacao")));
	            	diagnostico.setSabeLer(Auxiliar.converteInteger(req.getParameter("radioConsegueLer")));
	            	diagnostico.setSabeEscrever(Auxiliar.converteInteger(req.getParameter("radioConsegueEscrever")));
	//            	req.getParameter("checkEnsinoFundamentalMembro");
	//            	req.getParameter("checkEnsinoMedioMembro");
	//            	req.getParameter("checkEnsinoTecnicoMembro");
	//            	req.getParameter("checkEnsinoSuperiorMembro");
	//            	req.getParameter("checkEnsinoGraduacaoMembro");
	//            	req.getParameter("checkAnalfabetoMembro");
	            	diagnostico.setProfissRespFamil(req.getParameter("profissaoResponsavel"));
	            	diagnostico.setEnergNegoc(Auxiliar.converteInteger(req.getParameter("radioNegociacaoEnergia")));
	            	diagnostico.setEnergNegocParcQtde(Auxiliar.converteInteger(req.getParameter("qtdeParcelaEnergia")));
	            	diagnostico.setEnergNegocParcVal(Auxiliar.converteBigDecimal(req.getParameter("valorParcelaEnergia")));
	            	diagnostico.setEnergNegocDia(Auxiliar.converteInteger(req.getParameter("diaParcelaEnergia")));
	            	diagnostico.setAguaNegoc(Auxiliar.converteInteger(req.getParameter("radioNegociacaoAgua")));
	            	diagnostico.setAguaNegocParcQtde(Auxiliar.converteInteger(req.getParameter("qtdeParcelaAgua")));
	            	diagnostico.setAguaNegocParcVal(Auxiliar.converteBigDecimal(req.getParameter("valorParcelaAgua")));
	            	diagnostico.setAguaNegocDia(Auxiliar.converteInteger(req.getParameter("diaParcelaAgua")));
	            	diagnostico.setObraSaneamConhe(req.getParameter("empresaExecutar"));
	            	diagnostico.setBenefObraSanSaude(Auxiliar.converteCheckBox(req.getParameter("checkBeneficioPrevencaoDoenca")));
	            	diagnostico.setBenefObraSanEco(Auxiliar.converteCheckBox(req.getParameter("checkBeneficioFortalecimento")));
	            	diagnostico.setBenefObraSanImob(Auxiliar.converteCheckBox(req.getParameter("checkBeneficioValorizacaoImovel")));
	            	diagnostico.setBenefObraSanTuri(Auxiliar.converteCheckBox(req.getParameter("checkBeneficioValorizacaoTurismo")));
	            	diagnostico.setObsGerais(req.getParameter("observacoesInformacoes"));
            	
	            	DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO(connection);
	            	diagnosticoDAO.inserir(diagnostico);
	            	
	            	req.setAttribute("botao", "Alterar");
	            	req.setAttribute("sucesso", "Serviço cadastrado com sucesso");
	            	req.setAttribute("aviso", "");
        		} 
        		catch (Exception e) {
        			System.out.println(e);
            		req.setAttribute("aviso", "Nao foi possivel inserir as informacoes, contate o suporte!");
            		req.setAttribute("sucesso", "");
            		req.setAttribute("botao", "Cadastrar");
				}
        		finally {
        			EquipeDAO equipeDAO = new EquipeDAO(connection);
	            	List<Equipe> listaEquipe = equipeDAO.listarTodos();
	            	
	            	ComunidadeDAO comunidadeDAO = new ComunidadeDAO(connection);
	            	List<Comunidade> listaComunidades = comunidadeDAO.listarTodos();
	            	
	            	List<TipoConstrucaoEnum> listaTpContrucao = TipoConstrucaoEnum.listCodigos();
	            	List<TipoInstalacaoEnum> listaTpInstalacao = TipoInstalacaoEnum.listCodigos();
	            	List<SituacaoImovelEnum> listaSituacaoImovel = SituacaoImovelEnum.listCodigos();
	            	List<TipoUsoImovelEnum> listaTipoImovel = TipoUsoImovelEnum.listCodigos();
	            	List<SimNaoEnum> listaSimNao = SimNaoEnum.listCodigos();
	            	List<FormaAbastecimentoEnum> listaAbastecimentoAgua = FormaAbastecimentoEnum.listCodigos();
	            	List<DestinoEsgotoEnum> listaDestinoEsgoto = DestinoEsgotoEnum.listCodigos();
	            	List<EstadosEnum> listaEstados = EstadosEnum.listCodigos();
	            	List<SexoEnum> listaSexo = SexoEnum.listCodigos();
	            	List<NacionalidadeEnum> listaNacionalidade = NacionalidadeEnum.listCodigos();
	            	List<EstadoCivilEnum> listaEstadoCivil = EstadoCivilEnum.listCodigos();
	            	List<GrauEnsinoEnum> listaGrauEnsino = GrauEnsinoEnum.listCodigos();
	            	List<SituacaoEnsinoEnum> listaSituacaoEnsino = SituacaoEnsinoEnum.listCodigos();
	            	req.setAttribute("listaTpContrucao", listaTpContrucao);
	            	req.setAttribute("listaTpInstalacao", listaTpInstalacao);
	            	req.setAttribute("listaSituacaoImovel", listaSituacaoImovel);
	            	req.setAttribute("listaTipoImovel", listaTipoImovel);
	            	req.setAttribute("listaSimNao", listaSimNao);
	            	req.setAttribute("listaAbastecimentoAgua", listaAbastecimentoAgua);
	            	req.setAttribute("listaDestinoEsgoto", listaDestinoEsgoto);
	            	req.setAttribute("listaEstados", listaEstados);
	            	req.setAttribute("listaSexo", listaSexo);
	            	req.setAttribute("listaNacionalidade", listaNacionalidade);
	            	req.setAttribute("listaEstadoCivil", listaEstadoCivil);
	            	req.setAttribute("listaGrauEnsino", listaGrauEnsino);
	            	req.setAttribute("listaSituacaoEnsino", listaSituacaoEnsino);
	            	req.setAttribute("listaEquipe", listaEquipe);
	            	req.setAttribute("listaComunidades", listaComunidades);
        			
	            	diagnostico.setData(req.getParameter("dtExecucao"));
        			if(req.getParameter("dtNascimentoNTitular") != null && !req.getParameter("dtNascimentoNTitular").trim().isEmpty())
	            		diagnostico.setBenefDtNasc(req.getParameter("dtNascimentoNTitular"));
        			
        			if(req.getParameter("dtNascimento") != null && !req.getParameter("dtNascimento").trim().isEmpty())
	            		diagnostico.setDtNasc(req.getParameter("dtNascimento"));
	            	
	            	req.setAttribute("modelo", diagnostico);
	            	req.getRequestDispatcher("/jsp/servico/formulario.jsp").forward(req, res);
        		}
            	
            }
            else if (relat.equals("logout")) {
                HttpSession session = req.getSession(true);
                session.putValue("user", null);
                req.getSession().invalidate();
                req.getRequestDispatcher("/index.jsp").forward(req, res);
            } 
        }
        catch (Exception e) {
            req.setAttribute("erro", e.toString());
            req.getRequestDispatcher("/jsp/erro.jsp").forward(req, res);
        }
    }
}
