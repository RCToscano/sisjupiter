package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.modelo.EscolaridadeParente;

public class EscolaridadeParenteDAO {
	
	Connection connection = null;

    public EscolaridadeParenteDAO(Connection connection) {
        this.connection = connection;
    }
	
	public List<EscolaridadeParente> listaPorIdDiagnostico(Long id_diagnostico) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<EscolaridadeParente> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(
            "SELECT   TB_DIAGNOESCOLPARENTE.* " +
            "FROM     TB_DIAGNOESCOLPARENTE " +
            "WHERE    TB_DIAGNOESCOLPARENTE.ID_DIAGNOSTICO = ? " +
            "ORDER BY TB_DIAGNOESCOLPARENTE.ID_DIAGNOESCOLPARENTE " ) ;

            stmt.setLong(1, id_diagnostico);
            rs = stmt.executeQuery();

            while (rs.next()) {
            	EscolaridadeParente parente = new EscolaridadeParente();
            	parente.setIdDiagnoEscolParente(rs.getLong("ID_DIAGNOESCOLPARENTE"));
            	parente.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
            	parente.setIdGrauEscol(rs.getLong("ID_GRAUESCOL"));
            	parente.setNome(rs.getString("NOME"));
            	parente.setParentesco(rs.getString("PARENTESCO"));
                list.add(parente);
            }
            return list;
        } 
        finally {
            if(stmt != null)
                stmt.close();
            if(rs != null)
                rs.close();
        }
    }
	
	public void inserir(EscolaridadeParente parente) throws Exception {
    	PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
            				" INSERT INTO TB_DIAGNOESCOLPARENTE ( " +
            				" ID_DIAGNOSTICO, " +
            				" ID_GRAUESCOL, " +
            				" NOME, " +
            				" PARENTESCO " +
            				") " +
            				"VALUES ( " +
            				"?, ?, ?, ?)" 
            				);
            
			stmt.setObject(1, parente.getIdDiagnostico());
			stmt.setObject(2, parente.getIdGrauEscol());
			stmt.setObject(3, parente.getNome());
			stmt.setObject(4, parente.getParentesco());
			stmt.executeUpdate();
        }
	    finally {
	        if(stmt != null)
	            stmt.close();
	        if(rs != null)
	            rs.close();
	    }
	}
	
	public void alterar(EscolaridadeParente parente) throws Exception {
    	PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
            				" UPDATE TB_DIAGNOESCOLPARENTE SET " +
    						"ID_DIAGNOSTICO = ?," + 
    						"ID_GRAUESCOL = ?," + 
    						"NOME = ?," + 
    						"PARENTESCO = ? " + 
    						"WHERE ID_DIAGNOSTICO = ? " +
    						"AND ID_DIAGNOESCOLPARENTE = ? "
            				);
        						
			stmt.setObject(1, parente.getIdDiagnostico());
			stmt.setObject(2, parente.getIdGrauEscol());
			stmt.setObject(3, parente.getNome());
			stmt.setObject(4, parente.getParentesco());
			stmt.setObject(5, parente.getIdDiagnostico());
			stmt.setObject(6, parente.getIdDiagnoEscolParente());
			stmt.executeUpdate();
				            
	    }
	    finally {
	        if(stmt != null)
	            stmt.close();
	        if(rs != null)
	            rs.close();
	    }
	}

}
