package br.com.andsisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.andsisjupiter.modelo.DiagnosticoEscolParen;

public class DiagnosticoEscolParenDAO {
    
    private Connection connection;

    public DiagnosticoEscolParenDAO(Connection connection) {
        
        this.connection = connection;
    }
    
    public void inserir(DiagnosticoEscolParen diagnosticoEscolParen) throws SQLException {

        PreparedStatement stmt = null;
                
        try {
        
            stmt = connection.prepareStatement(
            "INSERT INTO TB_DIAGNOESCOLPARENTE ( " +   
    		//"       ID_DIAGNOESCOLPARENTE, " +
    		"       ID_GRAUESCOL, " +
    		"       ID_DIAGNOSTICO, " +
    		"       NOME, " +
    		"       PARENTESCO " +
            ") VALUES (" +
            "       ?,?,?,? " +
            ")");
            
            //stmt.setObject(1, diagnosticoEscolParen.getIdDiagnosticoEscolParen());
            stmt.setObject(1, diagnosticoEscolParen.getGrauEscol());
            stmt.setObject(2, diagnosticoEscolParen.getIdDiagnostico());	
            stmt.setObject(3, diagnosticoEscolParen.getNome());
            stmt.setObject(4, diagnosticoEscolParen.getParentesco());
               
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
}