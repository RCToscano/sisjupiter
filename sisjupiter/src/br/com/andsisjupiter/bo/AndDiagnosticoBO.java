package br.com.andsisjupiter.bo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.andsisjupiter.dao.DiagnosticoDAO;
import br.com.andsisjupiter.modelo.Diagnostico;
import br.com.sisjupiter.auxiliar.Auxiliar;
import br.com.sisjupiter.connection.ConnectionFactory;

public class AndDiagnosticoBO extends HttpServlet {

    private Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doGet simplesmente chama o doPost
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            if(Auxiliar.isNull(request.getParameter("acao")).equals("1")) {//INSERIR ALTERAR RET_SS
                                
                connection = ConnectionFactory.getConnection();
                
                DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO(connection);
               
                Diagnostico diagnostico = new Gson().fromJson(request.getParameter("diagnostico"), Diagnostico.class);
                
                //INSERIR //NAO HAVERA ALTERACAO NESTE MOMENTO POR FALTA DE CHAVE
                diagnosticoDAO.inserir(diagnostico);

                write(response, "ok");
            }
        }
        catch (Exception e) {
            System.out.println("erro: " + e.toString());
//            if(e != null && e.toString().length() > 1000) {
//                try {new LogSqlDAO(connection).inserir(e.toString().substring(0, 995), request.getParameter("servicoRet"));} catch (SQLException ex) {}
//            }
//            else {
//                try {new LogSqlDAO(connection).inserir(e.toString(), request.getParameter("servicoRet"));} catch (SQLException ex) {}
//            }
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



