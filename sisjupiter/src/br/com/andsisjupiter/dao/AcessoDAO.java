
package br.com.andsisjupiter.dao;

import br.com.andsisjupiter.modelo.Acesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcessoDAO {
    
    Connection connection = null;

    public AcessoDAO(Connection connection) {
        
        this.connection = connection;
    }
   
    public void inserir(Acesso acesso) throws SQLException {
        
        PreparedStatement stmt = null;
                
        try {
        
            stmt = connection.prepareStatement(
            "INSERT INTO TB_ANDACESSO ( " +
            //"       ID_ANDACESSO, " +
            "       ID_EQUIPE, " +
            "       IMEI, " +
            "       VCODE, " +
            "       VNAME, " +
            "       CEL, " +
            "       APP, " +
            "       GPS, " +
            "       BATERIA, " +
            "       DTACESSO " +        
            ") VALUES ( " +
            "       ?,?,?,?,?,?,?,?,SYSDATE() " +
            ") ");
            
            //stmt.setObject(1, acesso.getIdAcesso());
            stmt.setObject(1, acesso.getIdEquipe());
            stmt.setObject(2, acesso.getImei());
            stmt.setObject(3, acesso.getvCode());
            stmt.setObject(4, acesso.getvName());
            stmt.setObject(5, acesso.getCel());
            stmt.setObject(6, acesso.getApp());
            stmt.setObject(7, acesso.getGps());
            stmt.setObject(8, acesso.getBateria());
            //stmt.setObject(9, acesso.getDtAcesso());

            stmt.executeUpdate();
        }
        catch(SQLException e) {
            
            throw e;
        }
        finally {

            if(stmt != null) {
                
                stmt.close();
            }
        }
    }
}
