package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.modelo.FotosDiagnostico;

public class FotosDiagnosticoDAO {
	
	Connection connection = null;

    public FotosDiagnosticoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<FotosDiagnostico> listarFotos(String idDiagnostico) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FotosDiagnostico> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(
            "   SELECT TB_DIAGNOSTICO.ID_DIAGNOSTICO, " + 
            "          TB_FOTODIAG.*  " + 
            "     FROM TB_DIAGNOSTICO " + 
            "LEFT JOIN TB_FOTODIAG " + 
            "       ON TB_DIAGNOSTICO.ID_DIAGNOSTICOCEL = TB_FOTODIAG.ID_DIAGNOSTICOAPP " + 
            "      AND TB_DIAGNOSTICO.ID_EQUIPE = TB_FOTODIAG.ID_EQUIPE " + 
            "    WHERE TB_FOTODIAG.ID_FOTODIAG IS NOT NULL " + 
            "      AND TB_DIAGNOSTICO.ID_DIAGNOSTICO = ? "
            );

            stmt.setObject(1, idDiagnostico);
            rs = stmt.executeQuery();

            while (rs.next()) {
            	FotosDiagnostico diagnostico = new FotosDiagnostico();
            	diagnostico.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
            	diagnostico.setIdComunidade(rs.getLong("ID_COMUNIDADE"));
            	diagnostico.setIdDiagnosticoApp(rs.getLong("ID_DIAGNOSTICOAPP"));
            	diagnostico.setIdEquipe(rs.getLong("ID_EQUIPE"));
            	diagnostico.setIdFotoDiag(rs.getLong("ID_FOTODIAG"));
            	diagnostico.setArquivo(rs.getString("ARQUIVO"));
            	diagnostico.setCoodY(rs.getString("COORDY"));
            	diagnostico.setCoordX(rs.getString("COORDX"));
            	diagnostico.setDtApp(rs.getString("DTAPP"));
            	diagnostico.setDtInsert(rs.getString("DTINSERT"));
                list.add(diagnostico);
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
