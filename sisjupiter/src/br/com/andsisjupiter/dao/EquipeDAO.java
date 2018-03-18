
package br.com.andsisjupiter.dao;

import br.com.andsisjupiter.modelo.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipeDAO {
     
    private Connection connection;

    public EquipeDAO(Connection connection) {
        
        this.connection = connection;
    }
    
    public Equipe buscar(String login, String senha) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Equipe equipe = null;
        
        try {

            stmt = connection.prepareStatement(
            "SELECT    TB_EQUIPE.ID_EQUIPE, " +
            "          TB_EQUIPE.ID_EQUIPETP, " + 
            "          TB_EQUIPETP.DESCRICAO EQUIPETP, " +
            "          TB_EQUIPE.ID_EQUIPESIT, " +
            "          TB_EQUIPE.EQUIPE, " + 
            "          TB_EQUIPE.LOGIN, " + 
            "          TB_EQUIPE.SENHA, " + 
            "          TB_EQUIPE.CKIMEI, " + 
            "          TB_EQUIPE.DTSITUACAO, " + 
            "          TB_EQUIPE.DTINSERT " +
            "FROM      TB_EQUIPE " +
            "LEFT JOIN TB_EQUIPETP " +
            "ON        TB_EQUIPE.ID_EQUIPETP = TB_EQUIPETP.ID_EQUIPETP " +
            "WHERE     TB_EQUIPE.LOGIN = ? " +
            "AND       TB_EQUIPE.SENHA = ? ");        

            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if(rs.next()) {
                
                equipe = new Equipe();
                equipe.setIdEquipe(rs.getLong("ID_EQUIPE"));
                equipe.setIdEquipeTp(rs.getLong("ID_EQUIPETP"));
                equipe.setEquipeTp(rs.getString("EQUIPETP"));
                equipe.setIdEquipeSit(rs.getLong("ID_EQUIPESIT"));
                equipe.setEquipe(rs.getString("EQUIPE"));
                equipe.setLogin(rs.getString("LOGIN"));
                equipe.setSenha(rs.getString("SENHA"));
                equipe.setCkImei(rs.getString("CKIMEI"));
                equipe.setDtSituacao(rs.getString("DTSITUACAO"));
                equipe.setDtInsert(rs.getString("DTINSERT"));
                
                return equipe;
            }

            return null;
        }
        catch(SQLException e) {            
            
            throw e;
        }
        finally {

            if(stmt != null) {
                
                stmt.close();
            }
            if(rs != null) {              
                
                rs.close();
            }
        }
    }
    
    public Equipe buscarPorId(Long idEquipe) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Equipe equipe = null;
        
        try {

            stmt = connection.prepareStatement(
            "SELECT    TB_EQUIPE.ID_EQUIPE, " +
            "          TB_EQUIPE.ID_EQUIPETP, " + 
            "          TB_EQUIPETP.DESCRICAO EQUIPETP, " +
            "          TB_EQUIPE.ID_EQUIPESIT, " +
            "          TB_EQUIPE.EQUIPE, " + 
            "          TB_EQUIPE.LOGIN, " + 
            "          TB_EQUIPE.SENHA, " + 
            "          TB_EQUIPE.CKIMEI, " + 
            "          TB_EQUIPE.DTSITUACAO, " + 
            "          TB_EQUIPE.DTINSERT " +
            "FROM      TB_EQUIPE " +
            "LEFT JOIN TB_EQUIPETP " +
            "ON        TB_EQUIPE.ID_EQUIPETP = TB_EQUIPETP.ID_EQUIPETP " +
            "WHERE     TB_EQUIPE.ID_EQUIPE = ? ");       

            stmt.setLong(1, idEquipe);

            rs = stmt.executeQuery();

            if(rs.next()) {
                
                equipe = new Equipe();
                equipe.setIdEquipe(rs.getLong("ID_EQUIPE"));
                equipe.setIdEquipeTp(rs.getLong("ID_EQUIPETP"));
                equipe.setEquipeTp(rs.getString("EQUIPETP"));
                equipe.setIdEquipeSit(rs.getLong("ID_EQUIPESIT"));
                equipe.setEquipe(rs.getString("EQUIPE"));
                equipe.setLogin(rs.getString("LOGIN"));
                equipe.setSenha(rs.getString("SENHA"));
                equipe.setCkImei(rs.getString("CKIMEI"));
                equipe.setDtSituacao(rs.getString("DTSITUACAO"));
                equipe.setDtInsert(rs.getString("DTINSERT"));
                
                return equipe;
            }

            return null;
        }
        catch(SQLException e) {            
            
            throw e;
        }
        finally {

            if(stmt != null) {
                
                stmt.close();
            }
            if(rs != null) {              
                
                rs.close();
            }
        }
    }
    
//    public static void main(String[] args) throws SQLException {
//        
//        Connection connection = ConnectionFactory.getConnection();
//        
//        EquipeDAO equipeDAO = new EquipeDAO(connection);
//        Equipe equipe = equipeDAO.buscarPorId(1l);
//        
//        System.out.println("equipe " + equipe.getEquipe());
//        
//        connection.close();
//    }
}

