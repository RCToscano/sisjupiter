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

import com.google.gson.Gson;

import br.com.sisjupiter.connection.ConnectionFactory;
import br.com.sisjupiter.dao.ComunidadeDAO;
import br.com.sisjupiter.modelo.Comunidade;
import br.com.sisjupiter.modelo.User;

public class MapaBO extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                   
		if (req.getParameter("acao") != null && req.getParameter("acao").equals("1")) {//ENTRA MAPA
			
			Connection connection = null;
			
			try {
				
				connection = ConnectionFactory.getConnection();
				
				ComunidadeDAO comunidadeDAO = new ComunidadeDAO(connection);
				List<Comunidade> listComunidade = comunidadeDAO.listarTodos();
				
				req.setAttribute("listComunidade", listComunidade);
				req.getRequestDispatcher("/jsp/mapa/mapadiagnocomunidade.jsp").forward(req, res);
			}
	        catch (Exception e) {
	            req.setAttribute("erro", e.toString());
	            req.getRequestDispatcher("/jsp/erro.jsp").forward(req, res);
	        }
			finally {
				if(connection != null) {
					try {connection.close();} catch (SQLException e) {}
				}
			}
        }
		else if (req.getParameter("acao") != null && req.getParameter("acao").equals("2")) {//POPULA COMBO CONDOMINIO

			Connection connection = null;
			HttpSession session = req.getSession(true);
            User user = (User) session.getValue("user");
            String sql = "";
            String json = "";
			
			try {
			
				connection = ConnectionFactory.getConnection();
//				
//				CondominioDAO condominioDAO = new CondominioDAO(connection);
//				List<Condominio> listCondominio = new ArrayList<Condominio>();		
//				listCondominio = condominioDAO.listarPorUsuario(user.getIdUser(), Long.parseLong(req.getParameter("idEmpresa")));
//				
//				json = new Gson().toJson(listCondominio);
				
				res.setContentType("application/json");
				res.setCharacterEncoding("UTF-8");
				res.getWriter().write(json);   
			}
	        catch (Exception e) {
	        	System.out.println("erro " + e.toString());
	            req.setAttribute("erro", e.toString());
	            req.getRequestDispatcher("/jsp/erro.jsp").forward(req, res);
	        }
			finally {
				if(connection != null) {
					try {connection.close();} catch (SQLException e) {}
				}
			}	
        }
    }
}


