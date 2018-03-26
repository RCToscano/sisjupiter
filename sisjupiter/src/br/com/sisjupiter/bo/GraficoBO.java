package br.com.sisjupiter.bo;

import java.io.IOException;
import java.sql.Connection;
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
            else if (relat.equals("diario")) {
            	connection = ConnectionFactory.getConnection();
            	GraficoDAO graficoDAO = new GraficoDAO(connection);
            	List<Grafico> lista = graficoDAO.qtdeExecucaoPorComunidade();
            	
            	List<String> listaNome = new ArrayList<>();
            	for(int i = 0; i < lista.size(); i++) {
            		listaNome.add("{name: '"+lista.get(i).getNomeComunidade()+"'");
            		listaNome.add("y: "+String.valueOf(lista.get(i).getQtde())+"}");
            	}
            	
            	req.setAttribute("listaNome", listaNome);
            	
            	List<String> listConsumo = new ArrayList<>();
            	for(int i = 0; i < 28; i++) {
            		listConsumo.add("" + (i + 3));
            	}
            	
             	req.setAttribute("listConsumo", listConsumo);
            	req.getRequestDispatcher("/jsp/grafico/comunidade.jsp").forward(req, res);
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
