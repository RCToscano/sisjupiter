package br.com.andsisjupiter.bo;

import br.com.sisjupiter.connection.ConnectionFactory;
import br.com.andsisjupiter.dao.TempoGpsDAO;
import br.com.andsisjupiter.modelo.TempoGps;
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

public class AndTempoGpsBO extends HttpServlet {

    Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doGet simplesmente chama o doPost
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            this.connection = ConnectionFactory.getConnection();
            TempoGpsDAO tempoGpsDAO = new TempoGpsDAO(connection);
            List<TempoGps> list = tempoGpsDAO.listar();
                            
            if(list.size() > 0){

                write(response, new Gson().toJson(list));
            }
            else {

                write(response, "");
            }
        } 
        catch (SQLException e) {

             write(response, e.toString());
        }
        finally {
            
            if(connection != null) {
                
                try {connection.close();} catch (SQLException ex) {}
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

