package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.modelo.RelEquipe;

public class RelEquipeDAO {
	
	Connection connection = null;

    public RelEquipeDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<RelEquipe> qtdeExecucaoPorEquipe() throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RelEquipe> list = new ArrayList<>();
        try {
            
            stmt = connection.prepareStatement(
            "SELECT    COUNT(TB_DIAGNOSTICO.ID_EQUIPE) AS QTDE, " +
            "          TB_DIAGNOSTICO.ID_EQUIPE, " +
            "          TB_EQUIPE.EQUIPE, " +
            "          TB_EQUIPE.LOGIN " +
            "FROM      TB_DIAGNOSTICO " +
            "LEFT JOIN TB_EQUIPE " +
            "       ON TB_DIAGNOSTICO.ID_EQUIPE = TB_EQUIPE.ID_EQUIPE " +
            "LEFT JOIN TB_COMUNIDADE C " +
			"       ON TB_DIAGNOSTICO.ID_COMUNIDADE = C.ID_COMUNIDADE " +
            "    WHERE C.SITUACAO = 'A' " +
            " GROUP BY TB_DIAGNOSTICO.ID_EQUIPE "
            );
            
            rs = stmt.executeQuery();

            while(rs.next()) {
            	RelEquipe grafico = new RelEquipe();
            	grafico.setIdEquipe(rs.getLong("ID_EQUIPE"));
            	grafico.setNomeEquipe(rs.getString("EQUIPE"));
            	grafico.setLoginEquipe(rs.getString("LOGIN"));
            	grafico.setQtde(rs.getLong("QTDE"));
                list.add(grafico);
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
    
    public List<RelEquipe> qtdeExecucaoPorEquipe(String idEquipe) throws Exception {
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	List<RelEquipe> list = new ArrayList<>();
    	try {
    		
    		stmt = connection.prepareStatement(
    				"SELECT    COUNT(TB_DIAGNOSTICO.ID_EQUIPE) AS QTDE, " +
					"          TB_DIAGNOSTICO.ID_EQUIPE, " +
					"          TB_EQUIPE.EQUIPE, " +
					"          TB_EQUIPE.LOGIN " +
					"FROM      TB_DIAGNOSTICO " +
					"LEFT JOIN TB_EQUIPE " +
					"       ON TB_DIAGNOSTICO.ID_EQUIPE = TB_EQUIPE.ID_EQUIPE " +
					"LEFT JOIN TB_COMUNIDADE C " +
					"       ON TB_DIAGNOSTICO.ID_COMUNIDADE = C.ID_COMUNIDADE " +
					"    WHERE TB_DIAGNOSTICO.ID_EQUIPE = ? " +
					"      AND C.SITUACAO = 'A' "
			);
    		stmt.setObject(1, idEquipe);
    		rs = stmt.executeQuery();
    		
    		while(rs.next()) {
    			RelEquipe grafico = new RelEquipe();
    			grafico.setIdEquipe(rs.getLong("ID_EQUIPE"));
    			grafico.setNomeEquipe(rs.getString("EQUIPE"));
    			grafico.setLoginEquipe(rs.getString("LOGIN"));
    			grafico.setQtde(rs.getLong("QTDE"));
    			list.add(grafico);
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
    
    public List<RelEquipe> qtdeExecucaoPeriodo(String dtInicio, String dtFim) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RelEquipe> list = new ArrayList<>();
        try {
            
            stmt = connection.prepareStatement(
    		"   SELECT COUNT(TB_DIAGNOSTICO.ID_EQUIPE) AS QTDE, " +
            "          TB_DIAGNOSTICO.ID_EQUIPE, " +
            "          TB_EQUIPE.EQUIPE, " +
            "          TB_EQUIPE.LOGIN " +
            "     FROM TB_DIAGNOSTICO " +
            "LEFT JOIN TB_EQUIPE " +
            "       ON TB_DIAGNOSTICO.ID_EQUIPE = TB_EQUIPE.ID_EQUIPE " +
            "LEFT JOIN TB_COMUNIDADE C " +
			"       ON TB_DIAGNOSTICO.ID_COMUNIDADE = C.ID_COMUNIDADE " +
            "    WHERE TB_DIAGNOSTICO.DATA >= ? " +
            "      AND TB_DIAGNOSTICO.DATA <= ? " +
            "      AND C.SITUACAO = 'A' " +
            " GROUP BY TB_DIAGNOSTICO.ID_EQUIPE "
            );
            
            stmt.setString(1, dtInicio);
            stmt.setString(2, dtFim);
            
            rs = stmt.executeQuery();

            while(rs.next()) {
            	RelEquipe grafico = new RelEquipe();
            	grafico.setIdEquipe(rs.getLong("ID_EQUIPE"));
            	grafico.setNomeEquipe(rs.getString("EQUIPE"));
            	grafico.setLoginEquipe(rs.getString("LOGIN"));
            	grafico.setQtde(rs.getLong("QTDE"));
                list.add(grafico);
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
    
	public List<RelEquipe> qtdeExecucaoPeriodoEquipe(String dtInicio, String dtFim, String idEquipe) throws Exception {
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	List<RelEquipe> list = new ArrayList<>();
    	try {
    		
    		stmt = connection.prepareStatement(
    				"   SELECT COUNT(TB_DIAGNOSTICO.ID_EQUIPE) AS QTDE, " +
					"          TB_DIAGNOSTICO.ID_EQUIPE, " +
					"          TB_EQUIPE.EQUIPE, " +
					"          TB_EQUIPE.LOGIN " +
					"     FROM TB_DIAGNOSTICO " +
					"LEFT JOIN TB_EQUIPE " +
					"       ON TB_DIAGNOSTICO.ID_EQUIPE = TB_EQUIPE.ID_EQUIPE " +
					"LEFT JOIN TB_COMUNIDADE C " +
					"       ON TB_DIAGNOSTICO.ID_COMUNIDADE = C.ID_COMUNIDADE " +
					"    WHERE TB_DIAGNOSTICO.DATA >= ? " +
					"      AND TB_DIAGNOSTICO.DATA <= ? " +
					"      AND TB_DIAGNOSTICO.ID_EQUIPE = ? " +
					"      AND C.SITUACAO = 'A' "
			);
    		
    		stmt.setString(1, dtInicio);
    		stmt.setString(2, dtFim);
    		stmt.setObject(3, idEquipe);
    		
    		rs = stmt.executeQuery();
    		
    		while(rs.next()) {
    			RelEquipe grafico = new RelEquipe();
    			grafico.setIdEquipe(rs.getLong("ID_EQUIPE"));
    			grafico.setNomeEquipe(rs.getString("EQUIPE"));
    			grafico.setLoginEquipe(rs.getString("LOGIN"));
    			grafico.setQtde(rs.getLong("QTDE"));
    			list.add(grafico);
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

}
