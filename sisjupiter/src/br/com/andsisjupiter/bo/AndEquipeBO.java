
package br.com.andsisjupiter.bo;

import br.com.andsisjupiter.dao.AcessoDAO;
import br.com.andsisjupiter.dao.EquipeDAO;
import br.com.andsisjupiter.modelo.Acesso;
import br.com.andsisjupiter.modelo.Equipe;
import br.com.sisjupiter.auxiliar.Auxiliar;
import br.com.sisjupiter.connection.ConnectionFactory;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AndEquipeBO extends HttpServlet {

    private Connection connection;
    String resposta = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doGet simplesmente chama o doPost
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            
            if(Auxiliar.isNull(request.getParameter("acao")).equals("1")) {//LOGIN EQUIPE
                
                this.connection = ConnectionFactory.getConnection();
                
                String login = request.getParameter("login");
                String senha = request.getParameter("senha");
                String imei = request.getParameter("imei");
                String vCode = request.getParameter("vCode");
                String vName = request.getParameter("vName");
                String cel = request.getParameter("cel");
                String app = request.getParameter("app");
                String bateria = request.getParameter("bateria");
		String gps = request.getParameter("gps");
                String dataAparelho = request.getParameter("dataAparelho");

                EquipeDAO equipeDAO = new EquipeDAO(connection);
                Equipe equipe = equipeDAO.buscar(login, senha);

                if (equipe == null) {//USUARIO NAO ENCONTRADO

                    write(response, "1");
                }
                else if (!Auxiliar.dataAtual().equals(dataAparelho)) {//DATA APARELHO ERRADA

                    write(response, "2");
                }
                else if (equipe.getIdEquipeSit().longValue() != 1) {//USUARIO INATIVO

                    write(response, "3");
                }
                else {

                    Acesso acesso = new Acesso();
                    acesso.setIdAcesso(null);
                    acesso.setIdEquipe(equipe.getIdEquipe());
                    acesso.setImei(imei);
                    if(vCode != null) {
                        acesso.setvCode(Long.parseLong(vCode));
                    }
                    acesso.setvName(vName);
                    acesso.setCel(cel);
                    acesso.setApp(app);
                    acesso.setGps(gps);
                    if(bateria != null) {
                        acesso.setBateria(Long.parseLong(bateria));
                    }
                    //acesso.setDtAcesso(null);
                    
                    new AcessoDAO(connection).inserir(acesso);
                    
                    write(response, new Gson().toJson(equipe));                    
                }
            }
        }
        catch (SQLException e) {
            
            resposta = "erro sql | " + e.toString();
            
            write(response, resposta);
        }
        finally {
            
            if(connection != null) {
                 
                try {connection.close();} catch (SQLException e) {}
            }
        }
    }

    private void write(HttpServletResponse response, String resposta) throws IOException {

        response.setContentType("text/html");
        //response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.print(resposta);
        writer.flush();
        writer.close();
    }
}
