
package br.com.sisjupiter.reldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sisjupiter.relmodelo.RelMapaDiagnostico;

public class RelMapaDiagnosticoDAO {

    Connection connection;

    public RelMapaDiagnosticoDAO(Connection connection) {
    
        this.connection = connection;
    }
    
    public List<RelMapaDiagnostico> listar(String sql) throws SQLException {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RelMapaDiagnostico> list = new ArrayList<RelMapaDiagnostico>();
        
        try {
        
            stmt = connection.prepareStatement(
    		"SELECT    TB_DIAGNOSTICO.ID_DIAGNOSTICO, " +
	        "  		   TB_DIAGNOSTICO.ID_COMUNIDADE, " +
	        "          TB_DIAGNOSTICO.ID_EQUIPE, " +
	        "          TB_DIAGNOSTICO.COORDX, " +
	        "          TB_DIAGNOSTICO.COORDY, " +
	        "          TB_DIAGNOSTICO.NOME, " +
	        "          TB_DIAGNOSTICO.CPF, " +
	        "          TB_DIAGNOSTICO.RG, " +
	        "          TB_DIAGNOSTICO.ENDERECO, " +
	        "          TB_DIAGNOSTICO.NUMATUAL, " +
	        "          TB_DIAGNOSTICO.NUMANTIGO, " +
	        "          TB_DIAGNOSTICO.COMPL, " +
	        "          TB_DIAGNOSTICO.BAIRRO, " +
	        "          TB_DIAGNOSTICO.MUN, " +
	        "          TB_DIAGNOSTICO.UF, " +
	        "          TB_DIAGNOSTICO.CEP, " +
	        "          TB_DIAGNOSTICO.TELRES, " +
	        "          TB_DIAGNOSTICO.TELCEL, " +
	        "          TB_DIAGNOCONTATO.RESPCASANOME1, " +
	        "          TB_DIAGNOCONTATO.RESPCASATEL1, " +
	        "          TB_DIAGNOCONTATO.RESPCASANOME2, " +
	        "          TB_DIAGNOCONTATO.RESPCASATEL2 " +
	        "FROM      TB_DIAGNOSTICO " +
	        "LEFT JOIN TB_DIAGNOCONTATO " +
	        "ON        TB_DIAGNOSTICO.ID_DIAGNOSTICO = TB_DIAGNOCONTATO.ID_DIAGNOSTICO " +
	        "WHERE     TB_DIAGNOCONTATO.ID_DIAGNOCONTATO IS NOT NULL " +
	        sql
	        ) ;

            rs = stmt.executeQuery();

            while (rs.next()) {
                
            	RelMapaDiagnostico relMapaDiagnostico = new RelMapaDiagnostico();
            	relMapaDiagnostico.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
            	relMapaDiagnostico.setIdComunidade(rs.getLong("ID_COMUNIDADE"));
            	relMapaDiagnostico.setIdEquipe(rs.getLong("ID_EQUIPE"));
            	relMapaDiagnostico.setCoordX(rs.getString("COORDX"));
            	relMapaDiagnostico.setCoordY(rs.getString("COORDY"));
            	relMapaDiagnostico.setNome(rs.getString("NOME"));
            	relMapaDiagnostico.setCpf(rs.getString("CPF"));
            	relMapaDiagnostico.setRg(rs.getString("RG"));
            	relMapaDiagnostico.setEndereco(rs.getString("ENDERECO"));
            	relMapaDiagnostico.setNumAtual(rs.getInt("NUMATUAL"));
            	relMapaDiagnostico.setNumAntigo(rs.getInt("NUMANTIGO"));
            	relMapaDiagnostico.setCompl(rs.getString("COMPL"));
            	relMapaDiagnostico.setBairro(rs.getString("BAIRRO"));
            	relMapaDiagnostico.setMun(rs.getString("MUN"));
            	relMapaDiagnostico.setUf(rs.getString("UF"));
            	relMapaDiagnostico.setCep(rs.getString("CEP"));
            	relMapaDiagnostico.setTelRes(rs.getLong("TELRES"));
            	relMapaDiagnostico.setTelCel(rs.getLong("TELCEL"));
    	        relMapaDiagnostico.setContatoRespCasaNome1(rs.getString("RESPCASANOME1"));
    	        relMapaDiagnostico.setContatoRespCasaTel1(rs.getLong("RESPCASATEL1"));
    	        relMapaDiagnostico.setContatoRespCasaNome2(rs.getString("RESPCASANOME2"));
    	        relMapaDiagnostico.setContatoRespCasaTel2(rs.getLong("RESPCASATEL2"));
                
                list.add(relMapaDiagnostico);
            }
        } 
        catch (SQLException e) {
        
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
        
        return list;
    }
}
