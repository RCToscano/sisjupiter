package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.modelo.Grafico;

public class GraficoDAO {
	
	Connection connection = null;

    public GraficoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Grafico> qtdeExecucaoPorComunidade() throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Grafico> list = new ArrayList<>();
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
            	Grafico grafico = new Grafico();
            	grafico.setIdComunidade(rs.getLong("ID_COMUNIDADE"));
            	grafico.setNomeComunidade(rs.getString("NOME"));
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
    
    public List<Grafico> qtdeExecucaoPorEquipe() throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Grafico> list = new ArrayList<>();
        try {
            
            stmt = connection.prepareStatement(
            "SELECT    COUNT(TB_DIAGNOSTICO.ID_EQUIPE) AS QTDE, " +
            "          TB_DIAGNOSTICO.ID_EQUIPE, " +
            "          TB_EQUIPE.EQUIPE " +
            "FROM      TB_DIAGNOSTICO " +
            "LEFT JOIN TB_EQUIPE " +
            "       ON TB_DIAGNOSTICO.ID_EQUIPE = TB_EQUIPE.ID_EQUIPE " +
            " GROUP BY TB_DIAGNOSTICO.ID_EQUIPE "
            );
            
            rs = stmt.executeQuery();

            while(rs.next()) {
            	Grafico grafico = new Grafico();
            	grafico.setIdComunidade(rs.getLong("ID_EQUIPE"));
            	grafico.setNomeComunidade(rs.getString("EQUIPE"));
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
