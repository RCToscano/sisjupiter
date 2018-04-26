package br.com.andsisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.andsisjupiter.modelo.FotoDiag;

public class FotoDiagDAO {
    
    private Connection connection;

    public FotoDiagDAO(Connection connection) {
        
        this.connection = connection;
    }
    
    public void inserir(FotoDiag fotoDiag) throws SQLException {

        PreparedStatement stmt = null;
                
        try {
        
            stmt = connection.prepareStatement(
            "INSERT INTO TB_FOTODIAG ( " +   
    		//"       ID_FOTODIAG, " +
    		"       ID_COMUNIDADE, " +
    		"       ID_EQUIPE, " +
    		"       ID_DIAGNOSTICOAPP, " +
    		"       COORDX, " +
    		"       COORDY, " +
    		"       ARQUIVO, " +
    		"       TPFOTO, " +
    		"       DTAPP, " +
    		"       DTINSERT " +
            ") VALUES (" +
            "       ?," +
            "       ?," +
            "       ?," +
            "       ?," +
            "       ?," +
            "       ?," +  
            "       ?," + 
            "       ?," + 
            "       sysdate() " +
            ")");
            
            //stmt.setObject(1, fotoDiag.getIdFotoDiag());
            stmt.setObject(1, fotoDiag.getIdComunidade());
            stmt.setObject(2, fotoDiag.getIdEquipe());
            stmt.setObject(3, fotoDiag.getIdDiagnosticoApp());
            stmt.setObject(4, fotoDiag.getCoordX());
            stmt.setObject(5, fotoDiag.getCoordY());
            stmt.setObject(6, fotoDiag.getArquivo());
            stmt.setObject(7, fotoDiag.getTpFoto());
            stmt.setObject(8, fotoDiag.getDtInsert());
               
            stmt.execute();
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
    
    public boolean existe(String arquivo) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean resposta = false;
        
        try {
            
            stmt = connection.prepareStatement(
            "SELECT ID_FOTODIAG " +
            "FROM   TB_FOTODIAG " +
            "WHERE  TB_FOTODIAG.ARQUIVO = ? ");

            stmt.setString(1, arquivo);

            rs = stmt.executeQuery();

            if (rs.next()) {

                resposta = true;
            }
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
        
        return resposta;
    }
}