package br.com.sisjupiter.bo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andsisjupiter.modelo.DiagnosticoView;
import br.com.sisjupiter.auxiliar.Auxiliar;
import br.com.sisjupiter.auxiliar.ColunasExcel;
import br.com.sisjupiter.auxiliar.GeradorExcel;
import br.com.sisjupiter.connection.ConnectionFactory;
import br.com.sisjupiter.dao.DiagnosticoViewDAO;
import br.com.sisjupiter.dao.RelComunidadeDAO;
import br.com.sisjupiter.modelo.RelComunidade;

public class RelComunidadeBO extends HttpServlet {

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

            //Inicio
            if (relat.equals("total")) {
            	connection = ConnectionFactory.getConnection();
            	RelComunidadeDAO comunidadeDAO = new RelComunidadeDAO(connection);
            	List<RelComunidade> listaComunidade = comunidadeDAO.qtdeExecucaoPorComunidade();
            	
            	int totalComunidade = 0;
            	for(int i = 0; i < listaComunidade.size(); i++) {
            		totalComunidade += listaComunidade.get(i).getQtde();
            	}
            	
            	if(listaComunidade.isEmpty()) {
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nenhuma execução encontrada");
            		req.getRequestDispatcher("/jsp/relatorios/comunidade/totalExecutado.jsp").forward(req, res);
            	}
            	else {
            		req.setAttribute("display", "none");
            		req.setAttribute("listaComunidade", listaComunidade);
            		req.setAttribute("totalComunidade", totalComunidade);
            	}
            	
            	req.getRequestDispatcher("/jsp/relatorios/comunidade/totalExecutado.jsp").forward(req, res);
            }
            
            //Grafico Total Executado
            else if (relat.equals("graficoTotal")) {
            	connection = ConnectionFactory.getConnection();
            	RelComunidadeDAO comunidadeDAO = new RelComunidadeDAO(connection);
            	List<RelComunidade> listaComunidade = comunidadeDAO.qtdeExecucaoPorComunidade();
            	
            	List<String> listaComunidadeFinal = new ArrayList<>();
            	List<String> listComunidade = new ArrayList<String>();
				List<Long> listQtde = new ArrayList<Long>();
            	
            	for(int i = 0; i < listaComunidade.size(); i++) {
            		listaComunidadeFinal.add("{name: '"+listaComunidade.get(i).getNomeComunidade()+"'");
            		listaComunidadeFinal.add("y: "+String.valueOf(listaComunidade.get(i).getQtde())+"}");
            		
            		listQtde.add(listaComunidade.get(i).getQtde());
            		listComunidade.add(listaComunidade.get(i).getNomeComunidade());
            	}
            	
            	req.setAttribute("display", "none");
        		req.setAttribute("listaComunidadeFinal", listaComunidadeFinal);
        		req.setAttribute("listComunidade", listComunidade);
        		req.setAttribute("listQtde", listQtde);
        		req.getRequestDispatcher("/jsp/relatorios/comunidade/totalExecutadoGrafico.jsp").forward(req, res);
            }

            //Consulta Periodo
            else if (relat.equals("consultaPeriodo")) {
            	req.setAttribute("display", "none");
            	req.getRequestDispatcher("/jsp/relatorios/comunidade/periodoExecucao.jsp").forward(req, res);
            }
            
            //Periodo Execucao
            else if (relat.equals("periodoExecucao")) {
            	SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            	try {
	            	String dtInicio = formatoBanco.format(formatoData.parse(req.getParameter("dtInicio")));
	            	String dtFim = formatoBanco.format(formatoData.parse(req.getParameter("dtFim")));
            	
	            	connection = ConnectionFactory.getConnection();
	            	RelComunidadeDAO graficoDAO = new RelComunidadeDAO(connection);
	            	List<RelComunidade> lista = graficoDAO.qtdeExecucaoPeriodo(dtInicio, dtFim);
	            	
	            	if(lista.isEmpty()) {
	            		req.setAttribute("display", "none");
	            		req.setAttribute("informacao", "Nenhuma execução encontrada no período informado!");
	            	}
	            	else {
	                	int totalComunidade = 0;
	            		for (int i = 0; i < lista.size(); i++) {
	            			totalComunidade += lista.get(i).getQtde();
	            		}
	            		req.setAttribute("display", "none");
	            		req.setAttribute("lista", lista);
	            		req.setAttribute("dtInicio", req.getParameter("dtInicio"));
	            		req.setAttribute("dtFim", req.getParameter("dtFim"));
	            		req.setAttribute("totalComunidade", totalComunidade);
	            	}
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
				}
            	finally {
            		req.getRequestDispatcher("/jsp/relatorios/comunidade/periodoExecucao.jsp").forward(req, res);
            	}
            }
            
            //Grafico Periodo
            else if (relat.equals("graficoPeriodo")) {
            	SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            	try {
            		String dtInicio = formatoBanco.format(formatoData.parse(req.getParameter("dtInicio")));
            		String dtFim = formatoBanco.format(formatoData.parse(req.getParameter("dtFim")));
            		
            		connection = ConnectionFactory.getConnection();
            		RelComunidadeDAO graficoDAO = new RelComunidadeDAO(connection);
            		List<RelComunidade> lista = graficoDAO.qtdeExecucaoPeriodo(dtInicio, dtFim);

        			List<String> listaComunidadeFinal = new ArrayList<>();
        			List<String> listComunidade = new ArrayList<String>();
    				List<Long> listQtde = new ArrayList<Long>();
        			
                	for(int i = 0; i < lista.size(); i++) {
                		listaComunidadeFinal.add("{name: '"+lista.get(i).getNomeComunidade()+"'");
                		listaComunidadeFinal.add("y: "+String.valueOf(lista.get(i).getQtde())+"}");
                		
                		listQtde.add(lista.get(i).getQtde());
                		listComunidade.add(lista.get(i).getNomeComunidade());
                	}
        			req.setAttribute("display", "none");
        			req.setAttribute("listaComunidadeFinal", listaComunidadeFinal);
        			req.setAttribute("listQtde", listQtde);
        			req.setAttribute("listComunidade", listComunidade);
        			req.setAttribute("dtInicio", req.getParameter("dtInicio"));
        			req.setAttribute("dtFim", req.getParameter("dtFim"));
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
            	}
            	finally {
            		req.getRequestDispatcher("/jsp/relatorios/comunidade/periodoExecucaoGrafico.jsp").forward(req, res);
            	}
            }
            
            //Excel com Totais
            else if (relat.equals("excelTotal")) {
	            try {
		        	connection = ConnectionFactory.getConnection();
		        	RelComunidadeDAO comunidadeDAO = new RelComunidadeDAO(connection);
		        	List<RelComunidade> listaComunidade = comunidadeDAO.qtdeExecucaoPorComunidade();
	            	
		        	//Total relatorio
		        	List<String> abas = new ArrayList<String>();
		        	abas.add("Relatorio");
		        	
		        	List<List<String>> colunas = new ArrayList<>();
		        	colunas.add(new ColunasExcel().getColunasRelatorioComunidade());
		        	
		        	List<List<List<String>>> listaFinal = new ArrayList<>();
		        	
		        	List<List<String>> lista1 = new ArrayList<>();
		        	for (int i = 0; i < listaComunidade.size(); i++) {
		        		List<String> listaValores1 = new ArrayList<>();
						listaValores1.add(String.valueOf(i+1));
						listaValores1.add(listaComunidade.get(i).getNomeComunidade());
						listaValores1.add(String.valueOf(listaComunidade.get(i).getQtde()));
						lista1.add(listaValores1);
					}
		        	listaFinal.add(lista1);
		        	
		        	String nomeArquivo = "Relatorio_Comunidade"+Auxiliar.dataAtual()+".xlsx";
		        	
					GeradorExcel.gerarExcel(res, nomeArquivo, "Relatorio",
							new ColunasExcel().getColunasRelatorioComunidade(), lista1);
		        	
	            } 
	        	catch (Exception e) {
	        		System.out.println(e);
	        		req.setAttribute("display", "block");
	        		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
	        		req.getRequestDispatcher("/jsp/relatorios/comunidade/totalExecutado.jsp").forward(req, res);
	        	}
            }
            
            //Excel Todos Diagnosticos
            else if (relat.equals("excelTotalDiag")) {
            	try {
            		connection = ConnectionFactory.getConnection();
            		RelComunidadeDAO comunidadeDAO = new RelComunidadeDAO(connection);
            		List<RelComunidade> listaComunidade = comunidadeDAO.qtdeExecucaoPorComunidade();
            		
            		//Total relatorio
            		List<String> abas = new ArrayList<String>();
            		abas.add("Relatorio");
            		
            		List<List<String>> colunas = new ArrayList<>();
            		colunas.add(new ColunasExcel().getColunasRelatorioComunidade());
            		
            		List<List<List<String>>> listaFinal = new ArrayList<>();
            		
            		List<List<String>> lista1 = new ArrayList<>();
            		for (int i = 0; i < listaComunidade.size(); i++) {
            			List<String> listaValores1 = new ArrayList<>();
            			listaValores1.add(String.valueOf(i+1));
            			listaValores1.add(listaComunidade.get(i).getNomeComunidade());
            			listaValores1.add(String.valueOf(listaComunidade.get(i).getQtde()));
            			lista1.add(listaValores1);
            		}
            		listaFinal.add(lista1);
            		
            		
            		//Diagnosticos
		        	DiagnosticoViewDAO viewDAO = new DiagnosticoViewDAO(connection);
            		List<DiagnosticoView> listaView = viewDAO.buscarTodos();
		        	
		        	abas.add("Diagnosticos");
		        	
		        	colunas.add(new ColunasExcel().getColunasDiagnostico());
		        	
		        	List<List<String>> lista2 = new ArrayList<>();
		        	for (int i = 0; i < listaView.size(); i++) {
		        		List<String> listaValores2 = new ArrayList<>();
		        		recuperaDados(listaView, i, listaValores2);
		        		lista2.add(listaValores2);
		        	}
		        	listaFinal.add(lista2);
            		
            		String nomeArquivo = "Relatorio_Comunidade"+Auxiliar.dataAtual()+".xlsx";
            		
		        	GeradorExcel.gerar2Abas(res, nomeArquivo, abas, colunas, listaFinal);
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
            		req.getRequestDispatcher("/jsp/relatorios/comunidade/totalExecutado.jsp").forward(req, res);
            	}
            }
            
            //Excel com Dianosticos por Comunidade
            else if (relat.equals("excelComunidade")) {
            	try {
            		String idComunidade = req.getParameter("comunidade");
            		
            		connection = ConnectionFactory.getConnection();
            		RelComunidadeDAO comunidadeDAO = new RelComunidadeDAO(connection);
					List<RelComunidade> listaComunidade = comunidadeDAO.qtdeExecucaoPorComunidade(idComunidade);
            		
            		//Total relatorio
            		List<String> abas = new ArrayList<String>();
            		abas.add("Relatorio");
            		
            		List<List<String>> colunas = new ArrayList<>();
            		colunas.add(new ColunasExcel().getColunasRelatorioComunidade());
            		
            		List<List<List<String>>> listaFinal = new ArrayList<>();
            		
            		List<List<String>> lista1 = new ArrayList<>();
            		for (int i = 0; i < listaComunidade.size(); i++) {
            			List<String> listaValores1 = new ArrayList<>();
            			listaValores1.add(String.valueOf(i+1));
            			listaValores1.add(listaComunidade.get(i).getNomeComunidade());
            			listaValores1.add(String.valueOf(listaComunidade.get(i).getQtde()));
            			lista1.add(listaValores1);
            		}
            		listaFinal.add(lista1);
            		
            		
            		//Diagnosticos
		        	DiagnosticoViewDAO viewDAO = new DiagnosticoViewDAO(connection);
            		List<DiagnosticoView> listaView = viewDAO.buscarPorComunidade(idComunidade);
		        	
		        	abas.add("Diagnosticos");
		        	
		        	colunas.add(new ColunasExcel().getColunasDiagnostico());
		        	
		        	List<List<String>> lista2 = new ArrayList<>();
		        	for (int i = 0; i < listaView.size(); i++) {
		        		List<String> listaValores2 = new ArrayList<>();
		        		recuperaDados(listaView, i, listaValores2);
		        		lista2.add(listaValores2);
		        	}
		        	listaFinal.add(lista2);
            		
            		String nomeArquivo = "Relatorio_Comunidade"+idComunidade+"_"+Auxiliar.dataAtual()+".xlsx";
            		
		        	GeradorExcel.gerar2Abas(res, nomeArquivo, abas, colunas, listaFinal);
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
            		req.getRequestDispatcher("/jsp/relatorios/comunidade/totalExecutado.jsp").forward(req, res);
            	}
            }
            	
            //Excel Totais por Periodo
            else if (relat.equals("excelPeriodo")) {
            	SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            	try {
            		String dtInicio = formatoBanco.format(formatoData.parse(req.getParameter("dtInicio")));
            		String dtFim = formatoBanco.format(formatoData.parse(req.getParameter("dtFim")));
            		
            		connection = ConnectionFactory.getConnection();
            		RelComunidadeDAO graficoDAO = new RelComunidadeDAO(connection);
            		List<RelComunidade> listaComunidade = graficoDAO.qtdeExecucaoPeriodo(dtInicio, dtFim);
            		
            		
            		//Total relatorio
            		List<String> abas = new ArrayList<String>();
            		abas.add("Relatorio");
            		
            		List<List<String>> colunas = new ArrayList<>();
            		colunas.add(new ColunasExcel().getColunasRelatorioComunidade());
            		
            		List<List<List<String>>> listaFinal = new ArrayList<>();
            		
            		List<List<String>> lista1 = new ArrayList<>();
            		for (int i = 0; i < listaComunidade.size(); i++) {
            			List<String> listaValores1 = new ArrayList<>();
            			listaValores1.add(String.valueOf(i+1));
            			listaValores1.add(listaComunidade.get(i).getNomeComunidade());
            			listaValores1.add(String.valueOf(listaComunidade.get(i).getQtde()));
            			lista1.add(listaValores1);
            		}
            		listaFinal.add(lista1);
            		
            		String nomeArquivo = "Relatorio_Comunidade_"+Auxiliar.dataAtual()+".xlsx";
            		
            		GeradorExcel.gerarExcel(res, nomeArquivo, "Relatorio",
            				new ColunasExcel().getColunasRelatorioComunidade(), lista1);
            		
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
            		req.getRequestDispatcher("/jsp/relatorios/comunidade/totalExecutado.jsp").forward(req, res);
            	}
            }
            
            //Excel com Diagnosticos por Periodo
            else if (relat.equals("excelPeriodoDiag")) {
            	try {
            		SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

            		String dtInicio = formatoBanco.format(formatoData.parse(req.getParameter("dtInicio")));
            		String dtFim = formatoBanco.format(formatoData.parse(req.getParameter("dtFim")));
            		
            		connection = ConnectionFactory.getConnection();
            		RelComunidadeDAO graficoDAO = new RelComunidadeDAO(connection);
            		List<RelComunidade> listaComunidade = graficoDAO.qtdeExecucaoPeriodo(dtInicio, dtFim);
            		
            		//Total relatorio
            		List<String> abas = new ArrayList<String>();
            		abas.add("Relatorio");
            		
            		List<List<String>> colunas = new ArrayList<>();
            		colunas.add(new ColunasExcel().getColunasRelatorioComunidade());
            		
            		List<List<List<String>>> listaFinal = new ArrayList<>();
            		
            		List<List<String>> lista1 = new ArrayList<>();
            		for (int i = 0; i < listaComunidade.size(); i++) {
            			List<String> listaValores1 = new ArrayList<>();
            			listaValores1.add(String.valueOf(i+1));
            			listaValores1.add(listaComunidade.get(i).getNomeComunidade());
            			listaValores1.add(String.valueOf(listaComunidade.get(i).getQtde()));
            			lista1.add(listaValores1);
            		}
            		listaFinal.add(lista1);
            		
            		
            		//Diagnosticos
            		DiagnosticoViewDAO viewDAO = new DiagnosticoViewDAO(connection);
            		List<DiagnosticoView> listaView = viewDAO.buscarPorPeriodo(dtInicio, dtFim);
            		
            		abas.add("Diagnosticos");
            		
            		colunas.add(new ColunasExcel().getColunasDiagnostico());
            		
            		List<List<String>> lista2 = new ArrayList<>();
            		for (int i = 0; i < listaView.size(); i++) {
            			List<String> listaValores2 = new ArrayList<>();
            			recuperaDados(listaView, i, listaValores2);
            			lista2.add(listaValores2);
            		}
            		listaFinal.add(lista2);
            		
            		String nomeArquivo = "Relatorio_Comunidade_"+Auxiliar.dataAtual()+".xlsx";
            		
            		GeradorExcel.gerar2Abas(res, nomeArquivo, abas, colunas, listaFinal);
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
            		req.getRequestDispatcher("/jsp/relatorios/comunidade/totalExecutado.jsp").forward(req, res);
            	}
            }
            
            //Excel Periodo com Dianosticos por Comunidade
            else if (relat.equals("excelComunidadePeriodo")) {
            	try {
            		SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

            		String idComunidade = req.getParameter("comunidade");
            		String dtInicio = formatoBanco.format(formatoData.parse(req.getParameter("dtInicio")));
            		String dtFim = formatoBanco.format(formatoData.parse(req.getParameter("dtFim")));
            		
            		
            		connection = ConnectionFactory.getConnection();
            		RelComunidadeDAO comunidadeDAO = new RelComunidadeDAO(connection);
					List<RelComunidade> listaComunidade = comunidadeDAO.qtdeExecucaoPeriodoComunidade(dtInicio, dtFim,
							idComunidade);
            		
            		//Total relatorio
            		List<String> abas = new ArrayList<String>();
            		abas.add("Relatorio");
            		
            		List<List<String>> colunas = new ArrayList<>();
            		colunas.add(new ColunasExcel().getColunasRelatorioComunidade());
            		
            		List<List<List<String>>> listaFinal = new ArrayList<>();
            		
            		List<List<String>> lista1 = new ArrayList<>();
            		for (int i = 0; i < listaComunidade.size(); i++) {
            			List<String> listaValores1 = new ArrayList<>();
            			listaValores1.add(String.valueOf(i+1));
            			listaValores1.add(listaComunidade.get(i).getNomeComunidade());
            			listaValores1.add(String.valueOf(listaComunidade.get(i).getQtde()));
            			lista1.add(listaValores1);
            		}
            		listaFinal.add(lista1);
            		
            		
            		//Diagnosticos
		        	DiagnosticoViewDAO viewDAO = new DiagnosticoViewDAO(connection);
            		List<DiagnosticoView> listaView = viewDAO.buscarPorPeriodoComunidade(dtInicio, dtFim, idComunidade);
		        	
		        	abas.add("Diagnosticos");
		        	
		        	colunas.add(new ColunasExcel().getColunasDiagnostico());
		        	
		        	List<List<String>> lista2 = new ArrayList<>();
		        	for (int i = 0; i < listaView.size(); i++) {
		        		List<String> listaValores2 = new ArrayList<>();
		        		recuperaDados(listaView, i, listaValores2);
		        		lista2.add(listaValores2);
		        	}
		        	listaFinal.add(lista2);
            		
            		String nomeArquivo = "Relatorio_Comunidade"+idComunidade+"_"+Auxiliar.dataAtual()+".xlsx";
            		
		        	GeradorExcel.gerar2Abas(res, nomeArquivo, abas, colunas, listaFinal);
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
            		req.getRequestDispatcher("/jsp/relatorios/comunidade/totalExecutado.jsp").forward(req, res);
            	}
            }
            
            
            
        }
        catch (Exception e) {
            req.setAttribute("erro", e.toString());
            req.getRequestDispatcher("/jsp/erro.jsp").forward(req, res);
        }
        finally {
            if(connection != null) {
                try {connection.close();} catch (SQLException ex) {}
            }
        }
    }

	private void recuperaDados(List<DiagnosticoView> listaView, int i, List<String> listaValores2) {
		listaValores2.add(listaView.get(i).getId_diagnostico());
		listaValores2.add(listaView.get(i).getId_comunidade());
		listaValores2.add(listaView.get(i).getComunidade());
		listaValores2.add(listaView.get(i).getData_diagnos());
		listaValores2.add(listaView.get(i).getData_insert());
		listaValores2.add(listaView.get(i).getId_equipe());
		listaValores2.add(listaView.get(i).getExecutor());
		listaValores2.add(listaView.get(i).getId_user());
		listaValores2.add(listaView.get(i).getSituacao_imovel());
		listaValores2.add(listaView.get(i).getTipo_contrucao());
		listaValores2.add(listaView.get(i).getTipo_instalacao());
		listaValores2.add(listaView.get(i).getResidencia());
		listaValores2.add(listaView.get(i).getComercio());
		listaValores2.add(listaView.get(i).getIndustria());
		listaValores2.add(listaView.get(i).getPublica());
		listaValores2.add(listaView.get(i).getUso_imovel());
		listaValores2.add(listaView.get(i).getQtde_casas());
		listaValores2.add(listaView.get(i).getTempo_ocupacao());
		listaValores2.add(listaView.get(i).getAtividade());
		listaValores2.add(listaView.get(i).getEnergia_eletrica());
		listaValores2.add(listaView.get(i).getEnergia_eletrica_irreg());
		listaValores2.add(listaView.get(i).getInstalacao());
		listaValores2.add(listaView.get(i).getMedidor());
		listaValores2.add(listaView.get(i).getPavimentacao());
		listaValores2.add(listaView.get(i).getColeta_lixo());
		listaValores2.add(listaView.get(i).getAbastec_agua());
		listaValores2.add(listaView.get(i).getAbastec_agua_irreg());
		listaValores2.add(listaView.get(i).getHidrometro());
		listaValores2.add(listaView.get(i).getDestino_esgoto());
		listaValores2.add(listaView.get(i).getCliente());
		listaValores2.add(listaView.get(i).getCpf());
		listaValores2.add(listaView.get(i).getRg());
		listaValores2.add(listaView.get(i).getNacionalidade());
		listaValores2.add(listaView.get(i).getUf_nasc());
		listaValores2.add(listaView.get(i).getMun_nasc());
		listaValores2.add(listaView.get(i).getDtnasc());
		listaValores2.add(listaView.get(i).getSexo());
		listaValores2.add(listaView.get(i).getTelres());
		listaValores2.add(listaView.get(i).getTelcel());
		listaValores2.add(listaView.get(i).getEstado_civil());
		listaValores2.add(listaView.get(i).getEmail());
		listaValores2.add(listaView.get(i).getEndereco());
		listaValores2.add(listaView.get(i).getNumatual());
		listaValores2.add(listaView.get(i).getNumantigo());
		listaValores2.add(listaView.get(i).getCompl());
		listaValores2.add(listaView.get(i).getBairro());
		listaValores2.add(listaView.get(i).getMun());
		listaValores2.add(listaView.get(i).getUf());
		listaValores2.add(listaView.get(i).getCep());
		listaValores2.add(listaView.get(i).getQtde_adulto());
		listaValores2.add(listaView.get(i).getQtde_crianca());
		listaValores2.add(listaView.get(i).getTem_conta());
		listaValores2.add(listaView.get(i).getBanco());
		listaValores2.add(listaView.get(i).getTem_cartao_debito());
		listaValores2.add(listaView.get(i).getRendatotal());
		listaValores2.add(listaView.get(i).getCompro_financ());
		listaValores2.add(listaView.get(i).getTransp_carro_proprio());
		listaValores2.add(listaView.get(i).getTransp_onibus());
		listaValores2.add(listaView.get(i).getTransp_trem());
		listaValores2.add(listaView.get(i).getTransp_metro());
		listaValores2.add(listaView.get(i).getTransp_taxi());
		listaValores2.add(listaView.get(i).getAcesso_internet());
		listaValores2.add(listaView.get(i).getWifi());
		listaValores2.add(listaView.get(i).getInternet3g());
		listaValores2.add(listaView.get(i).getQtde_carro());
		listaValores2.add(listaView.get(i).getQtde_moto());
		listaValores2.add(listaView.get(i).getQtde_bicicleta());
		listaValores2.add(listaView.get(i).getBenef_bcpnum());
		listaValores2.add(listaView.get(i).getBenef_nisnum());
		listaValores2.add(listaView.get(i).getTarifa_social());
		listaValores2.add(listaView.get(i).getBolsa_familia());
		listaValores2.add(listaView.get(i).getBenef_nome());
		listaValores2.add(listaView.get(i).getBenef_cpf());
		listaValores2.add(listaView.get(i).getBenef_rg());
		listaValores2.add(listaView.get(i).getBenef_sexo());
		listaValores2.add(listaView.get(i).getBenef_dtnasc());
		listaValores2.add(listaView.get(i).getBenef_obs());
		listaValores2.add(listaView.get(i).getAnos60_ou_maior());
		listaValores2.add(listaView.get(i).getAnos18_ou_menor());
		listaValores2.add(listaView.get(i).getMenor_1_ano());
		listaValores2.add(listaView.get(i).getQtde_def_visual());
		listaValores2.add(listaView.get(i).getQtde_def_auditivo());
		listaValores2.add(listaView.get(i).getQtde_def_fisico());
		listaValores2.add(listaView.get(i).getQtde_def_intelect());
		listaValores2.add(listaView.get(i).getQtde_def_outros());
		listaValores2.add(listaView.get(i).getTrata_cancer());
		listaValores2.add(listaView.get(i).getTrata_tuberculose());
		listaValores2.add(listaView.get(i).getTrata_hansen());
		listaValores2.add(listaView.get(i).getTrata_alie_mental());
		listaValores2.add(listaView.get(i).getTrata_esclerose());
		listaValores2.add(listaView.get(i).getTrata_paralisia());
		listaValores2.add(listaView.get(i).getTrata_hepatite());
		listaValores2.add(listaView.get(i).getTrata_cardiaco());
		listaValores2.add(listaView.get(i).getTrata_parkinson());
		listaValores2.add(listaView.get(i).getTrata_renal());
		listaValores2.add(listaView.get(i).getTrata_outro());
		listaValores2.add(listaView.get(i).getTrat_outro_desc());
		listaValores2.add(listaView.get(i).getMembro_amebiase());
		listaValores2.add(listaView.get(i).getMembro_amebiase_parent());
		listaValores2.add(listaView.get(i).getMembro_gastro());
		listaValores2.add(listaView.get(i).getMembro_gastro_parent());
		listaValores2.add(listaView.get(i).getMembro_giardiase());
		listaValores2.add(listaView.get(i).getMembro_giardiase_parent());
		listaValores2.add(listaView.get(i).getMembro_febre_tifoide());
		listaValores2.add(listaView.get(i).getMembro_febre_tifoide_parent());
		listaValores2.add(listaView.get(i).getMembro_hepatite());
		listaValores2.add(listaView.get(i).getMembro_hepatite_parent());
		listaValores2.add(listaView.get(i).getMembro_colera());
		listaValores2.add(listaView.get(i).getMembro_colera_parent());
		listaValores2.add(listaView.get(i).getMembro_esquitosso());
		listaValores2.add(listaView.get(i).getMembro_esquitosso_parent());
		listaValores2.add(listaView.get(i).getMembro_ascaridiase());
		listaValores2.add(listaView.get(i).getMembro_ascaridiase_parent());
		listaValores2.add(listaView.get(i).getMembro_teniase());
		listaValores2.add(listaView.get(i).getMembro_teniase_parent());
		listaValores2.add(listaView.get(i).getMembro_leptospirose());
		listaValores2.add(listaView.get(i).getMembro_leptospirose_parent());
		listaValores2.add(listaView.get(i).getMembro_malaria());
		listaValores2.add(listaView.get(i).getMembro_malaria_parent());
		listaValores2.add(listaView.get(i).getMembro_dengue());
		listaValores2.add(listaView.get(i).getMembro_dengue_parent());
		listaValores2.add(listaView.get(i).getMembro_febreamar());
		listaValores2.add(listaView.get(i).getMembro_febreamar_parent());
		listaValores2.add(listaView.get(i).getMembro_chikung());
		listaValores2.add(listaView.get(i).getMembro_chikung_parent());
		listaValores2.add(listaView.get(i).getMembro_zicavirus());
		listaValores2.add(listaView.get(i).getMembro_zicavirus_parent());
		listaValores2.add(listaView.get(i).getMembro_cianobacter());
		listaValores2.add(listaView.get(i).getMembro_cianobacter_parent());
		listaValores2.add(listaView.get(i).getVal_doacao());
		listaValores2.add(listaView.get(i).getVal_aposent());
		listaValores2.add(listaView.get(i).getVal_pensao_alimen());
		listaValores2.add(listaView.get(i).getVal_seg_desempr());
		listaValores2.add(listaView.get(i).getVal_empr_informal());
		listaValores2.add(listaView.get(i).getVal_empr_formal());
		listaValores2.add(listaView.get(i).getVal_bolsa_famil());
		listaValores2.add(listaView.get(i).getVal_outro());
		listaValores2.add(listaView.get(i).getVal_outr_descr());
		listaValores2.add(listaView.get(i).getGrau_escolar());
		listaValores2.add(listaView.get(i).getGrau_escolar_compl());
		listaValores2.add(listaView.get(i).getSabe_escrever());
		listaValores2.add(listaView.get(i).getSabe_ler());
		listaValores2.add(listaView.get(i).getProfissao_resp_familia());
		listaValores2.add(listaView.get(i).getNegociacao_deb_energia());
		listaValores2.add(listaView.get(i).getValor_parcela_energ());
		listaValores2.add(listaView.get(i).getQtde_parcela_energ());
		listaValores2.add(listaView.get(i).getVenc_parcela_energ());
		listaValores2.add(listaView.get(i).getNegociacao_deb_agua());
		listaValores2.add(listaView.get(i).getValor_parcela_agua());
		listaValores2.add(listaView.get(i).getQtde_parcela_agua());
		listaValores2.add(listaView.get(i).getVenc_parcela_agua());
		listaValores2.add(listaView.get(i).getConhec_obra_saneam());
		listaValores2.add(listaView.get(i).getBenef_sanea_prev_doenca());
		listaValores2.add(listaView.get(i).getBenef_sanea_fortal_econo());
		listaValores2.add(listaView.get(i).getBenef_sanea_valori_imob());
		listaValores2.add(listaView.get(i).getBenef_sanea_valor_turism());
		listaValores2.add(listaView.get(i).getObs_gerais());
		listaValores2.add(listaView.get(i).getMoradores());
		listaValores2.add(listaView.get(i).getResp_casa_nome1());
		listaValores2.add(listaView.get(i).getResp_casa_tel1());
		listaValores2.add(listaView.get(i).getResp_casa_nome2());
		listaValores2.add(listaView.get(i).getResp_casa_tel2());
		listaValores2.add(listaView.get(i).getVizinho_nome1());
		listaValores2.add(listaView.get(i).getVizinho_tel1());
		listaValores2.add(listaView.get(i).getVizinho_nome2());
		listaValores2.add(listaView.get(i).getVizinho_tel2());
		listaValores2.add(listaView.get(i).getContato_altern_nome1());
		listaValores2.add(listaView.get(i).getContato_altern_tel1());
		listaValores2.add(listaView.get(i).getContato_altern_nome2());
		listaValores2.add(listaView.get(i).getContato_altern_tel2());
		listaValores2.add(listaView.get(i).getContato_prof_nome1());
		listaValores2.add(listaView.get(i).getContato_prof_te1());
		listaValores2.add(listaView.get(i).getContato_prof_nome2());
		listaValores2.add(listaView.get(i).getContato_prof_te2());
		listaValores2.add(listaView.get(i).getEquip_publico());
		listaValores2.add(listaView.get(i).getRelacaoviz());
		listaValores2.add(listaView.get(i).getRel_recor_vizinho());
		listaValores2.add(listaView.get(i).getRel_recor_vizinho_freq());
		listaValores2.add(listaView.get(i).getConsideracoes_familias_ao_redor());
		listaValores2.add(listaView.get(i).getHospital_nome());
		listaValores2.add(listaView.get(i).getRef_nome());
		listaValores2.add(listaView.get(i).getCoordx());
		listaValores2.add(listaView.get(i).getCoordy());
		listaValores2.add(listaView.get(i).getCoordxdiag());
		listaValores2.add(listaView.get(i).getCoordydiag());
	}
}
