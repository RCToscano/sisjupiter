package br.com.andsisjupiter.bo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import br.com.andsisjupiter.dao.FotoDiagDAO;
import br.com.andsisjupiter.modelo.FotoDiag;
import br.com.sisjupiter.connection.ConnectionFactory;

public class AndFotoDiagBO extends HttpServlet {

    private Connection connection;
    String resposta = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            //GRAVAR FOTO DIAGNOSTICO
            if(request.getParameter("acao") != null && request.getParameter("acao").equals("1")) {
        
            	String diretorio = "/home/diagsdeep/images_diagnostico/";
                //String diretorio = "c:/temp/";

                //MultipartRequest multi = new MultipartRequest(request, diretorio, 50000 * 1024 * 1024, 
                //                                              new com.oreilly.servlet.multipart.DefaultFileRenamePolicy());//NAO SOBRESCREVE O ARQUIVO
                MultipartRequest multi = new MultipartRequest(request, diretorio, 50000 * 1024 * 1024);//SOBRESCREVE O ARQUIVO

                File file = new File(diretorio + request.getParameter("arquivo"));

                if(ImageIO.read(file) != null) {

                    connection = ConnectionFactory.getConnection();
                    
                    FotoDiag fotoDiag = new FotoDiag();
                    fotoDiag.setIdFotoDiag(Long.parseLong(request.getParameter("idFoto")));
                    fotoDiag.setIdComunidade(Long.parseLong(request.getParameter("idComunidade")));
                    fotoDiag.setIdEquipe(Long.parseLong(request.getParameter("idEquipe")));
                    fotoDiag.setIdDiagnosticoApp(Long.parseLong(request.getParameter("idDiagnostico")));
                    fotoDiag.setCoordX(request.getParameter("coordX"));
                    fotoDiag.setCoordY(request.getParameter("coordY"));
                    fotoDiag.setArquivo(request.getParameter("arquivo"));
                    fotoDiag.setTpFoto(Long.parseLong(request.getParameter("tpFoto")));
                    fotoDiag.setSituacao(Long.parseLong(request.getParameter("situacao")));
                    fotoDiag.setDtInsert(request.getParameter("dtInsert").substring(0, 10) + " " + request.getParameter("dtInsert").substring(11, 16));

                    FotoDiagDAO fotoDiagDAO = new FotoDiagDAO(connection);
                    if(!fotoDiagDAO.existe(fotoDiag.getArquivo())) {

                        fotoDiagDAO.inserir(fotoDiag);
                    }

                    resposta = "ok";
                }
                else {
                        
                    resposta = "erro";
                }

                write(response, resposta);
            }
        } 
        catch (Exception e) {
            System.out.println("erro: " + e.toString());
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

