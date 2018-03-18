package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.modelo.Equipe;

public class EquipeDAO {
	
	Connection connection = null;

    public EquipeDAO(Connection connection) {
        this.connection = connection;
    }
	
	
	public List<Equipe> listarTodos() throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Equipe> list = new ArrayList<>();
        try {
            
            stmt = connection.prepareStatement(
            "SELECT    TB_EQUIPE.* " +
            "FROM      TB_EQUIPE " +
            "ORDER BY  TB_EQUIPE.EQUIPE "
            );
            
            rs = stmt.executeQuery();

            while(rs.next()) {
            	Equipe equipe = new Equipe();
                equipe.setIdEquipe(rs.getLong("ID_EQUIPE"));
                equipe.setIdEquipeTp(rs.getLong("ID_EQUIPETP"));
                equipe.setIdEquipeSit(rs.getLong("ID_EQUIPESIT"));
                equipe.setEquipe(rs.getString("EQUIPE"));
                equipe.setLogin(rs.getString("LOGIN"));
                equipe.setSenha(rs.getString("SENHA"));
                equipe.setCkImei(rs.getString("CKIMEI"));
                equipe.setDtSituacao(rs.getString("DTSITUACAO"));
                equipe.setDtInsert(rs.getString("DTINSERT"));
                list.add(equipe);
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
