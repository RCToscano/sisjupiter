package br.com.sisjupiter.bo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
            	
            	List<String> listaComunidadeFinal = new ArrayList<>();
            	for(int i = 0; i < listaComunidade.size(); i++) {
            		listaComunidadeFinal.add("{name: '"+listaComunidade.get(i).getNomeComunidade()+"'");
            		listaComunidadeFinal.add("y: "+String.valueOf(listaComunidade.get(i).getQtde())+"}");
            	}
            	
            	List<Grafico> listaEquipe = graficoDAO.qtdeExecucaoPorEquipe();
            	List<String> listaEquipeFinal = new ArrayList<>();
            	for(int i = 0; i < listaEquipe.size(); i++) {
            		listaEquipeFinal.add("{name: '"+listaEquipe.get(i).getNomeComunidade()+"'");
            		listaEquipeFinal.add("y: "+String.valueOf(listaEquipe.get(i).getQtde())+"}");
            	}
            	if(listaEquipe.isEmpty() && listaComunidade.isEmpty()) {
            		req.setAttribute("aviso", "Nenhuma execução encontrada");
            	}
            	else {
            		req.setAttribute("aviso", "");
            		req.setAttribute("listaComunidadeFinal", listaComunidadeFinal);
            		req.setAttribute("listaEquipeFinal", listaEquipeFinal);
            	}
            	
            	req.getRequestDispatcher("/jsp/grafico/totalExecucoes.jsp").forward(req, res);
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
