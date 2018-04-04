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
import javax.servlet.http.HttpSession;

import br.com.sisjupiter.connection.ConnectionFactory;
import br.com.sisjupiter.dao.GraficoDAO;
import br.com.sisjupiter.modelo.Grafico;

public class GraficoBO extends HttpServlet {

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

            if (relat.equals("home")) {
                req.getRequestDispatcher("/jsp/home.jsp").forward(req, res);
            } 
            else if (relat.equals("total")) {
            	connection = ConnectionFactory.getConnection();
            	GraficoDAO graficoDAO = new GraficoDAO(connection);
            	List<Grafico> listaComunidade = graficoDAO.qtdeExecucaoPorComunidade();
            	
            	int totalComunidade = 0;
            	List<String> listaComunidadeFinal = new ArrayList<>();
            	for(int i = 0; i < listaComunidade.size(); i++) {
            		listaComunidadeFinal.add("{name: '"+listaComunidade.get(i).getNomeComunidade()+"'");
            		listaComunidadeFinal.add("y: "+String.valueOf(listaComunidade.get(i).getQtde())+"}");
            		totalComunidade += listaComunidade.get(i).getQtde();
            	}
            	
            	int totalEquipe = 0;
            	List<Grafico> listaEquipe = graficoDAO.qtdeExecucaoPorEquipe();
            	List<String> listaEquipeFinal = new ArrayList<>();
            	for(int i = 0; i < listaEquipe.size(); i++) {
            		String[] splited = listaEquipe.get(i).getNomeEquipe().split("\\s+");
            		String nome = listaEquipe.get(i).getLoginEquipe()+" - "+splited[0];
            		listaEquipeFinal.add("{name: '"+nome+"'");
            		listaEquipeFinal.add("y: "+String.valueOf(listaEquipe.get(i).getQtde())+"}");
            		totalEquipe += listaEquipe.get(i).getQtde();
            	}
            	if(listaEquipe.isEmpty() && listaComunidade.isEmpty()) {
            		req.setAttribute("aviso", "Nenhuma execução encontrada");
            		req.getRequestDispatcher("/jsp/grafico/consultaPeriodo.jsp").forward(req, res);
            	}
            	else {
            		req.setAttribute("aviso", "");
            		req.setAttribute("listaComunidade", listaComunidade);
            		req.setAttribute("listaEquipe", listaEquipe);
            		req.setAttribute("listaComunidadeFinal", listaComunidadeFinal);
            		req.setAttribute("listaEquipeFinal", listaEquipeFinal);
            		req.setAttribute("totalComunidade", totalComunidade);
            		req.setAttribute("totalEquipe", totalEquipe);
            	}
            	
            	req.getRequestDispatcher("/jsp/grafico/totalExecucoes.jsp").forward(req, res);
            }
            else if (relat.equals("consultaPeriodo")) {
            	req.setAttribute("aviso", "");
                req.getRequestDispatcher("/jsp/grafico/consultaPeriodo.jsp").forward(req, res);
            }
            else if (relat.equals("periodoExecucao")) {
            	SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            	try {
	            	String dtInicio = formatoBanco.format(formatoData.parse(req.getParameter("dtInicio")));
	            	String dtFim = formatoBanco.format(formatoData.parse(req.getParameter("dtFim")));
            	
	            	connection = ConnectionFactory.getConnection();
	            	GraficoDAO graficoDAO = new GraficoDAO(connection);
	            	List<Grafico> lista = graficoDAO.qtdeExecucaoPeriodo(dtInicio, dtFim);
	            	
	            	if(lista.isEmpty()) {
	            		req.setAttribute("aviso", "Nenhuma execução encontrada no período informado.");
	            		req.getRequestDispatcher("/jsp/grafico/consultaPeriodo.jsp").forward(req, res);
	            	}
	            	else {
	            		List<String> listaData = new ArrayList<>();
		            	List<String> listaQtde = new ArrayList<>();
	            		for (int i = 0; i < lista.size(); i++) {
	            			listaData.add("'"+String.valueOf(lista.get(i).getData())+"'");
	            			listaQtde.add("{name: '"+lista.get(i).getData()+"'");
	            			listaQtde.add("y: "+String.valueOf(lista.get(i).getQtde())+"}");
	            		}
	            		req.setAttribute("aviso", "");
	            		req.setAttribute("listaQtde", listaQtde);
	            		req.setAttribute("listaData", listaData);
	            		req.setAttribute("periodo", "'"+req.getParameter("dtInicio")+" - "+req.getParameter("dtFim")+"'");
	            		req.getRequestDispatcher("/jsp/grafico/periodoExecucao.jsp").forward(req, res);
	            	}
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("aviso", "Nao foi possivel realizar a consulta, contate o suporte!");
            		req.getRequestDispatcher("/jsp/grafico/consultaPeriodo.jsp").forward(req, res);
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
        finally {
            if(connection != null) {
                try {connection.close();} catch (SQLException ex) {}
            }
        }
    }
}
