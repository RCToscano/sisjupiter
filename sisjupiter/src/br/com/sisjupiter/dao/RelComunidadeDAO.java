package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.modelo.RelComunidade;

public class RelComunidadeDAO {
	
	Connection connection = null;

    public RelComunidadeDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<RelComunidade> qtdeExecucaoPorComunidade() throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RelComunidade> list = new ArrayList<>();
        try {
            
            stmt = connection.prepareStatement(
            "SELECT    COUNT(TB_DIAGNOSTICO.ID_COMUNIDADE) AS QTDE, " +
            "          TB_DIAGNOSTICO.ID_COMUNIDADE, " +
            "          TB_COMUNIDADE.NOME " +
            "FROM      TB_DIAGNOSTICO " +
            "LEFT JOIN TB_COMUNIDADE " +
            "       ON TB_DIAGNOSTICO.ID_COMUNIDADE = TB_COMUNIDADE.ID_COMUNIDADE " +
            " GROUP BY TB_DIAGNOSTICO.ID_COMUNIDADE "
            );
            
            rs = stmt.executeQuery();

            while(rs.next()) {
            	RelComunidade relComunidade = new RelComunidade();
            	relComunidade.setIdComunidade(rs.getLong("ID_COMUNIDADE"));
            	relComunidade.setNomeComunidade(rs.getString("NOME"));
            	relComunidade.setQtde(rs.getLong("QTDE"));
                list.add(relComunidade);
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
    
    public List<RelComunidade> qtdeExecucaoPeriodo(String dtInicio, String dtFim) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RelComunidade> list = new ArrayList<>();
        try {
            
            stmt = connection.prepareStatement(
    		"   SELECT COUNT(TB_DIAGNOSTICO.ID_COMUNIDADE) AS QTDE, " +
            "          TB_DIAGNOSTICO.ID_COMUNIDADE, " +
            "          TB_COMUNIDADE.NOME " +
            "     FROM TB_DIAGNOSTICO " +
            "LEFT JOIN TB_COMUNIDADE " +
            "       ON TB_DIAGNOSTICO.ID_COMUNIDADE = TB_COMUNIDADE.ID_COMUNIDADE " +
            "    WHERE TB_DIAGNOSTICO.DATA >= ? " +
            "      AND TB_DIAGNOSTICO.DATA <= ? " +
            " GROUP BY TB_DIAGNOSTICO.ID_COMUNIDADE "
            );
            
            stmt.setString(1, dtInicio);
            stmt.setString(2, dtFim);
            
            rs = stmt.executeQuery();

            while(rs.next()) {
            	RelComunidade relComunidade = new RelComunidade();
            	relComunidade.setIdComunidade(rs.getLong("ID_COMUNIDADE"));
            	relComunidade.setNomeComunidade(rs.getString("NOME"));
            	relComunidade.setQtde(rs.getLong("QTDE"));
                list.add(relComunidade);
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
