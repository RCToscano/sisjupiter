package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.modelo.Comunidade;

public class ComunidadeDAO {
	
	Connection connection = null;

    public ComunidadeDAO(Connection connection) {
        this.connection = connection;
    }
	
	public List<Comunidade> listarTodos() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Comunidade> list = new ArrayList<Comunidade>();
        try {
            stmt = connection.prepareStatement(
            "SELECT   ID_COMUNIDADE, " +
            "         ID_CONTRATO, " +
            "         NOME, " +
            "         SITUACAO, " +
            "         DTINSERT " +
            "FROM     TB_COMUNIDADE " +
            "WHERE    SITUACAO = 'A' " +
            "ORDER BY NOME ") ;

            rs = stmt.executeQuery();

            while (rs.next()) {
                Comunidade comunidade = new Comunidade();
                comunidade.setIdComunidade(rs.getLong("ID_COMUNIDADE"));
                comunidade.setIdContrato(rs.getLong("ID_CONTRATO"));
                comunidade.setNome(rs.getString("NOME"));
                comunidade.setSituacao(rs.getString("SITUACAO"));
                comunidade.setDtInsert(rs.getString("DTINSERT"));
                list.add(comunidade);
            }
            return list;
        } 
        catch (SQLException e) {
            throw e;
        }
        finally {
            if(stmt != null)
                stmt.close();
            if(rs != null)
                rs.close();
        }
    }

}
