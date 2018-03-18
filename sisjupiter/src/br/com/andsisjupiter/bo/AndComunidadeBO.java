
package br.com.andsisjupiter.bo;

import br.com.andsisjupiter.dao.ComunidadeDAO;
import br.com.andsisjupiter.modelo.Comunidade;
import br.com.sisjupiter.connection.ConnectionFactory;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AndComunidadeBO extends HttpServlet {

    private Connection connection;
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doGet simplesmente chama o doPost
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            if(request.getParameter("acao").equals("1")) {//LISTAR COMUNIDADE
                
                this.connection = ConnectionFactory.getConnection();
                
                ComunidadeDAO comunidadeDAO = new ComunidadeDAO(connection);
                List<Comunidade> list = comunidadeDAO.listar();
                
                if(list.size() > 0){
                    
                    write(response, new Gson().toJson(list));
                }
                else {
                    
                    write(response, "");
                }
            }
        }
        catch (SQLException e) {

            write(response, "erro: " + e.toString());
        }
        catch (Exception e) {

            write(response, "erro: " + e.toString());
        }
        finally {
            
            if(connection != null) {
                 
                try {connection.close();} catch (SQLException e) {}
            }
        }
    }

    private void write(HttpServletResponse response, String resposta) throws IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print(resposta);
        writer.flush();
        writer.close();
    }
}
