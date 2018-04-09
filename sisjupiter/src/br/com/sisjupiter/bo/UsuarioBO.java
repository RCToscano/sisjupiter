package br.com.sisjupiter.bo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisjupiter.connection.ConnectionFactory;
import br.com.sisjupiter.dao.UserDAO;
import br.com.sisjupiter.modelo.User;

public class UsuarioBO extends HttpServlet {

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

            if (relat.equals("perfil")) {
            	req.setAttribute("aviso", "");
            	req.setAttribute("sucesso", "");
            	req.getRequestDispatcher("/jsp/perfil/perfil.jsp").forward(req, res);
            } 
            else if (relat.equals("alterarPerfil")) {
            	SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
        		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            	try {
            		connection = ConnectionFactory.getConnection();
            		User user = (User) req.getSession().getAttribute("user");
            		user.setNome(req.getParameter("nome"));
            		user.setEmail(req.getParameter("email"));
            		user.setDtNasc(formatoBanco.format(formatoData.parse(user.getDtNasc())));

            		UserDAO userDAO = new UserDAO(connection);
            		userDAO.alterarUser(user);
            		
            		req.getSession().setAttribute("user", user);
            		req.setAttribute("sucesso", "Perfil alterado com sucesso!");
            		req.setAttribute("aviso", "");
            		req.getRequestDispatcher("/jsp/perfil/perfil.jsp").forward(req, res);
				} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("sucesso", "");
            		req.setAttribute("aviso", "Não foi possível realizar a operação, contate o suporte!");
            		req.getRequestDispatcher("/jsp/perfil/perfil.jsp").forward(req, res);
				}
            } 
            else if (relat.equals("alterarSenha")) {
            	try {
            		connection = ConnectionFactory.getConnection();
            		User user = (User) req.getSession().getAttribute("user");
            		String senha = req.getParameter("senha");
            		
            		UserDAO userDAO = new UserDAO(connection);
            		userDAO.alterarSenha(user.getIdUser(), senha);
            		
            		req.setAttribute("sucesso", "Senha alterada com sucesso!");
            		req.setAttribute("aviso", "");
            		req.getRequestDispatcher("/jsp/perfil/perfil.jsp").forward(req, res);
            	} 
            	catch (Exception e) {
            		System.out.println(e);
            		req.setAttribute("sucesso", "");
            		req.setAttribute("aviso", "Não foi possível realizar a operação, contate o suporte!");
            		req.getRequestDispatcher("/jsp/perfil/perfil.jsp").forward(req, res);
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
