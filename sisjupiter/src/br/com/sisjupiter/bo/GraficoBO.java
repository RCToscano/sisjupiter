package br.com.sisjupiter.bo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GraficoBO extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String relat = "";
        try {
            if (req.getParameter("acao") != null) {
                relat = req.getParameter("acao");
            }

            if (relat.equals("home")) {
                req.getRequestDispatcher("/jsp/home.jsp").forward(req, res);
            } 
            else if (relat.equals("diario")) {
            	req.getRequestDispatcher("/jsp/grafico/diario.jsp").forward(req, res);
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