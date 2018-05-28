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
import br.com.sisjupiter.dao.RelEquipeDAO;
import br.com.sisjupiter.modelo.RelEquipe;

public class RelEquipeBO extends HttpServlet {

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
            	RelEquipeDAO graficoDAO = new RelEquipeDAO(connection);
            	
            	int totalEquipe = 0;
            	List<RelEquipe> listaEquipe = graficoDAO.qtdeExecucaoPorEquipe();
            	for(int i = 0; i < listaEquipe.size(); i++) {
            		totalEquipe += listaEquipe.get(i).getQtde();
            	}
            	if(listaEquipe.isEmpty()) {
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nenhuma execução encontrada");
            		req.getRequestDispatcher("/jsp/relatorios/equipe/totalExecutado.jsp").forward(req, res);
            	}
            	else {
            		req.setAttribute("display", "none");
            		req.setAttribute("listaEquipe", listaEquipe);
            		req.setAttribute("totalEquipe", totalEquipe);
            	}
            	
            	req.getRequestDispatcher("/jsp/relatorios/equipe/totalExecutado.jsp").forward(req, res);
            }
            
            //Grafico Total Executado
            else if (relat.equals("graficoTotal")) {
            	connection = ConnectionFactory.getConnection();
            	RelEquipeDAO graficoDAO = new RelEquipeDAO(connection);
            	List<RelEquipe> listaEquipe = graficoDAO.qtdeExecucaoPorEquipe();
            	
            	List<String> listaEquipeFinal = new ArrayList<>();
            	List<String> listEquipe = new ArrayList<String>();
				List<Long> listQtde = new ArrayList<Long>();
            	
            	for(int i = 0; i < listaEquipe.size(); i++) {
            		String[] splited = listaEquipe.get(i).getNomeEquipe().split("\\s+");
            		String nome = listaEquipe.get(i).getLoginEquipe()+" - "+splited[0];
            		listaEquipeFinal.add("{name: '"+nome+"'");
            		listaEquipeFinal.add("y: "+String.valueOf(listaEquipe.get(i).getQtde())+"}");
            		
            		listQtde.add(listaEquipe.get(i).getQtde());
            		listEquipe.add(listaEquipe.get(i).getNomeEquipe());
            	}
            	
            	req.setAttribute("display", "none");
        		req.setAttribute("listaEquipeFinal", listaEquipeFinal);
        		req.setAttribute("listQtde", listQtde);
        		req.setAttribute("listEquipe", listEquipe);
        		req.getRequestDispatcher("/jsp/relatorios/equipe/totalExecutadoGrafico.jsp").forward(req, res);
            }
            
            //Consulta Periodo
            else if (relat.equals("consultaPeriodo")) {
            	req.setAttribute("display", "none");
            	req.getRequestDispatcher("/jsp/relatorios/equipe/periodoExecucao.jsp").forward(req, res);
            }
            
            //Periodo Execucao
            else if (relat.equals("periodoExecucao")) {
            	SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            	try {
	            	String dtInicio = formatoBanco.format(formatoData.parse(req.getParameter("dtInicio")));
	            	String dtFim = formatoBanco.format(formatoData.parse(req.getParameter("dtFim")));
            	
	            	connection = ConnectionFactory.getConnection();
	            	RelEquipeDAO graficoDAO = new RelEquipeDAO(connection);
	            	List<RelEquipe> lista = graficoDAO.qtdeExecucaoPeriodo(dtInicio, dtFim);
	            	
	            	if(lista.isEmpty()) {
	            		req.setAttribute("display", "none");
	            		req.setAttribute("informacao", "Nenhuma execução encontrada no período informado!");
	            	}
	            	else {
	                	int totalEquipe = 0;
	            		for (int i = 0; i < lista.size(); i++) {
	            			totalEquipe += lista.get(i).getQtde();
	            		}
	            		req.setAttribute("display", "none");
	            		req.setAttribute("lista", lista);
	            		req.setAttribute("dtInicio", req.getParameter("dtInicio"));
	            		req.setAttribute("dtFim", req.getParameter("dtFim"));
	            		req.setAttribute("totalEquipe", totalEquipe);
	            	}
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
				}
            	finally {
            		req.getRequestDispatcher("/jsp/relatorios/equipe/periodoExecucao.jsp").forward(req, res);
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
            		RelEquipeDAO graficoDAO = new RelEquipeDAO(connection);
            		List<RelEquipe> lista = graficoDAO.qtdeExecucaoPeriodo(dtInicio, dtFim);
            		
            		List<String> listaEquipeFinal = new ArrayList<>();
                	List<String> listEquipe = new ArrayList<String>();
    				List<Long> listQtde = new ArrayList<Long>();
                	
                	for(int i = 0; i < lista.size(); i++) {
                		String[] splited = lista.get(i).getNomeEquipe().split("\\s+");
                		String nome = lista.get(i).getLoginEquipe()+" - "+splited[0];
                		listaEquipeFinal.add("{name: '"+nome+"'");
                		listaEquipeFinal.add("y: "+String.valueOf(lista.get(i).getQtde())+"}");
                		
                		listQtde.add(lista.get(i).getQtde());
                		listEquipe.add(lista.get(i).getNomeEquipe());
                	}
                	
                	req.setAttribute("display", "none");
            		req.setAttribute("listaEquipeFinal", listaEquipeFinal);
            		req.setAttribute("listQtde", listQtde);
            		req.setAttribute("listEquipe", listEquipe);
            		req.setAttribute("dtInicio", req.getParameter("dtInicio"));
        			req.setAttribute("dtFim", req.getParameter("dtFim"));
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("display", "block");
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
            	}
            	finally {
            		req.getRequestDispatcher("/jsp/relatorios/equipe/periodoExecucaoGrafico.jsp").forward(req, res);
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
