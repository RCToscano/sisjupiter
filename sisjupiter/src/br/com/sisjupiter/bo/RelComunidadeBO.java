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

import br.com.sisjupiter.connection.ConnectionFactory;
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
}
