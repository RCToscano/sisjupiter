package br.com.sisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sisjupiter.auxiliar.Auxiliar;
import br.com.sisjupiter.modelo.DiagnosticoContato;

public class DiagnosticoContatoDAO {
	
	Connection connection = null;

    public DiagnosticoContatoDAO(Connection connection) {
        this.connection = connection;
    }
	
	
	public DiagnosticoContato buscarPorId(Long idDiagnostico) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = this.connection.prepareStatement(
            "SELECT    TB_DIAGNOCONTATO.* " +
            "FROM      TB_DIAGNOCONTATO " +
            "WHERE     TB_DIAGNOCONTATO.ID_DIAGNOSTICO = ? "
            );
            stmt.setLong(1, idDiagnostico);

            rs = stmt.executeQuery();

            DiagnosticoContato diagnosticoContato = null;
            if(rs.next()) {
            	diagnosticoContato = new DiagnosticoContato();
            	diagnosticoContato.setIdDiagnosticoContato(rs.getLong("ID_DIAGNOCONTATO"));
	        	diagnosticoContato.setIdDiagnostico(rs.getLong("ID_DIAGNOSTICO"));
	        	diagnosticoContato.setIdEquipe(rs.getLong("ID_EQUIPE"));
	        	diagnosticoContato.setIdComunidade(rs.getLong("ID_COMUNIDADE"));
	        	diagnosticoContato.setMoradoresResid(rs.getString("MORADORES"));
	        	diagnosticoContato.setContatoRespCasaNome1(rs.getString("RESPCASANOME1"));
	        	diagnosticoContato.setContatoRespCasaTel1(Auxiliar.converteLong(rs.getString("RESPCASATEL1")));
	        	diagnosticoContato.setContatoRespCasaNome2(rs.getString("RESPCASANOME2"));
	        	diagnosticoContato.setContatoRespCasaTel2(Auxiliar.converteLong(rs.getString("RESPCASATEL2")));
	        	diagnosticoContato.setContatoVizinhoNome1(rs.getString("VIZINHONOME1"));
	        	diagnosticoContato.setContatoVizinhoTel1(Auxiliar.converteLong(rs.getString("VIZINHOTEL1")));
	        	diagnosticoContato.setContatoVizinhoNome2(rs.getString("VIZINHONOME2"));
	        	diagnosticoContato.setContatoVizinhoTel2(Auxiliar.converteLong(rs.getString("VIZINHOTEL2")));
	        	diagnosticoContato.setContatoAlternNome1(rs.getString("ALTERNNOME1"));
	        	diagnosticoContato.setContatoAlternTel1(Auxiliar.converteLong(rs.getString("ALTERTEL1")));
	        	diagnosticoContato.setContatoAlternNome2(rs.getString("ALTERNOME2"));
	        	diagnosticoContato.setContatoAlternTel2(Auxiliar.converteLong(rs.getString("ALTERTEL2")));
	        	diagnosticoContato.setContatoProfissNome1(rs.getString("PROFISSNOME1"));
	        	diagnosticoContato.setContatoProfissTel1(Auxiliar.converteLong(rs.getString("PROFISSTEL1")));
	        	diagnosticoContato.setContatoProfissNome2(rs.getString("PROFISSNOME2"));
	        	diagnosticoContato.setContatoProfissTel2(Auxiliar.converteLong(rs.getString("PROFISSTEL2")));
	        	diagnosticoContato.setEquipaPublico(rs.getString("EQUIPPUBLIC"));
	        	diagnosticoContato.setRelacaoViz(Auxiliar.converteLong(rs.getString("RELACAOVIZ")));
	        	diagnosticoContato.setRelacaoVizFreq(Auxiliar.converteLong(rs.getString("RELACAOVIZFREQ")));
	        	diagnosticoContato.setConsFamiliaViz(Auxiliar.converteLong(rs.getString("CONSFAMILVIZ")));
	        	diagnosticoContato.setHospitalNome(rs.getString("HOSPITALNOME"));
	        	diagnosticoContato.setContatoReferNome(rs.getString("REFNOME"));
	        	diagnosticoContato.setCoordX(rs.getString("COORDX"));
	        	diagnosticoContato.setCoordY(rs.getString("COORDY"));
	        	diagnosticoContato.setDtInsert(rs.getString("DTINSERT"));
            }    	
            return diagnosticoContato;
        }
        finally {
            if(stmt != null)
                stmt.close();
            if(rs != null)
                rs.close();
        }
    }
	
	public void inserir(DiagnosticoContato diagnosticoContato) throws SQLException {

        PreparedStatement stmt = null;
                
        try {
        
            stmt = this.connection.prepareStatement(
            "INSERT INTO TB_DIAGNOCONTATO ( " +   
    		"       ID_DIAGNOSTICO, " +
    		"       ID_COMUNIDADE, " +
    		"       ID_EQUIPE, " +
    		"       MORADORES, " +
    		"       RESPCASANOME1, " +
    		"       RESPCASATEL1, " +
    		"       RESPCASANOME2, " +
    		"       RESPCASATEL2, " +
    		"       VIZINHONOME1, " +
    		"       VIZINHOTEL1, " +
    		"       VIZINHONOME2, " +
    		"       VIZINHOTEL2, " +
    		"       ALTERNNOME1, " +
    		"       ALTERTEL1, " +
    		"       ALTERNOME2, " +
    		"       ALTERTEL2, " +
    		"       PROFISSNOME1, " +
    		"       PROFISSTEL1, " +
    		"       PROFISSNOME2, " +
    		"       PROFISSTEL2, " +
    		"       EQUIPPUBLIC, " +
    		"       RELACAOVIZ, " +
    		"       RELACAOVIZFREQ, " +
    		"       CONSFAMILVIZ, " +
    		"       HOSPITALNOME, " +
    		"       REFNOME, " +
    		"       COORDX, " +
    		"       COORDY, " +
    		"       DTAPP, " +
    		"       DTINSERT " +
            ") VALUES (" +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,?, " +
            "       ?,?,?,?,?,?,?,?,?,sysdate() " +
            ")");
            
            stmt.setObject(1, diagnosticoContato.getIdDiagnostico());
            stmt.setObject(2, diagnosticoContato.getIdComunidade());
            stmt.setObject(3, diagnosticoContato.getIdEquipe());
            stmt.setObject(4, diagnosticoContato.getMoradoresResid());
            stmt.setObject(5, diagnosticoContato.getContatoRespCasaNome1());
            stmt.setObject(6, Auxiliar.isZeroNull(diagnosticoContato.getContatoRespCasaTel1()));
            stmt.setObject(7, diagnosticoContato.getContatoRespCasaNome2());
            stmt.setObject(8, Auxiliar.isZeroNull(diagnosticoContato.getContatoRespCasaTel2()));
            stmt.setObject(9, diagnosticoContato.getContatoVizinhoNome1());
            stmt.setObject(10, Auxiliar.isZeroNull(diagnosticoContato.getContatoVizinhoTel1()));
            stmt.setObject(11, diagnosticoContato.getContatoVizinhoNome2());
            stmt.setObject(12, Auxiliar.isZeroNull(diagnosticoContato.getContatoVizinhoTel2()));
            stmt.setObject(13, diagnosticoContato.getContatoAlternNome1());
            stmt.setObject(14, Auxiliar.isZeroNull(diagnosticoContato.getContatoAlternTel1()));
            stmt.setObject(15, diagnosticoContato.getContatoAlternNome2());
            stmt.setObject(16, Auxiliar.isZeroNull(diagnosticoContato.getContatoAlternTel2()));
            stmt.setObject(17, diagnosticoContato.getContatoProfissNome1());
            stmt.setObject(18, Auxiliar.isZeroNull(diagnosticoContato.getContatoProfissTel1()));
            stmt.setObject(19, diagnosticoContato.getContatoProfissNome2());
            stmt.setObject(20, Auxiliar.isZeroNull(diagnosticoContato.getContatoProfissTel2()));
            stmt.setObject(21, diagnosticoContato.getEquipaPublico());
            stmt.setObject(22, Auxiliar.isZeroNull(diagnosticoContato.getRelacaoViz()));
            stmt.setObject(23, Auxiliar.isZeroNull(diagnosticoContato.getRelacaoVizFreq()));
            stmt.setObject(24, Auxiliar.isZeroNull(diagnosticoContato.getConsFamiliaViz()));
            stmt.setObject(25, diagnosticoContato.getHospitalNome());
            stmt.setObject(26, diagnosticoContato.getContatoReferNome());
            stmt.setObject(27, diagnosticoContato.getCoordX());
            stmt.setObject(28, diagnosticoContato.getCoordY());
            stmt.setObject(29, diagnosticoContato.getDtInsert());
               
            stmt.execute();
        }
        finally {
            if(stmt != null)
                stmt.close();
            if(stmt != null)
            	stmt.close();
        }
    }
	
	public void alterar(DiagnosticoContato diagnosticoContato) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = this.connection.prepareStatement(
							"UPDATE TB_DIAGNOCONTATO SET " +   
							"       ID_COMUNIDADE = ?," + 
							"       ID_EQUIPE = ?," + 
							"       MORADORES = ?," + 
							"       RESPCASANOME1 = ?," + 
							"       RESPCASATEL1 = ?," + 
							"       RESPCASANOME2 = ?," + 
							"       RESPCASATEL2 = ?," + 
							"       VIZINHONOME1 = ?," + 
							"       VIZINHOTEL1 = ?," + 
							"       VIZINHONOME2 = ?," + 
							"       VIZINHOTEL2 = ?," + 
							"       ALTERNNOME1 = ?," + 
							"       ALTERTEL1 = ?," + 
							"       ALTERNOME2 = ?," + 
							"       ALTERTEL2 = ?," + 
							"       PROFISSNOME1 = ?," + 
							"       PROFISSTEL1 = ?," + 
							"       PROFISSNOME2 = ?," + 
							"       PROFISSTEL2 = ?," + 
							"       EQUIPPUBLIC = ?," + 
							"       RELACAOVIZ = ?," + 
							"       RELACAOVIZFREQ = ?," + 
							"       CONSFAMILVIZ = ?," + 
							"       HOSPITALNOME = ?," + 
							"       REFNOME = ? " +
							" WHERE ID_DIAGNOCONTATO = ? "
							);
			
			stmt.setObject(1, diagnosticoContato.getIdComunidade());
			stmt.setObject(2, diagnosticoContato.getIdEquipe());
			stmt.setObject(3, diagnosticoContato.getMoradoresResid());
			stmt.setObject(4, diagnosticoContato.getContatoRespCasaNome1());
			stmt.setObject(5, diagnosticoContato.getContatoRespCasaTel1());
			stmt.setObject(6, diagnosticoContato.getContatoRespCasaNome2());
			stmt.setObject(7, diagnosticoContato.getContatoRespCasaTel2());
			stmt.setObject(8, diagnosticoContato.getContatoVizinhoNome1());
			stmt.setObject(9, diagnosticoContato.getContatoVizinhoTel1());
			stmt.setObject(10, diagnosticoContato.getContatoVizinhoNome2());
			stmt.setObject(11, diagnosticoContato.getContatoVizinhoTel2());
			stmt.setObject(12, diagnosticoContato.getContatoAlternNome1());
			stmt.setObject(13, diagnosticoContato.getContatoAlternTel1());
			stmt.setObject(14, diagnosticoContato.getContatoAlternNome2());
			stmt.setObject(15, diagnosticoContato.getContatoAlternTel2());
			stmt.setObject(16, diagnosticoContato.getContatoProfissNome1());
			stmt.setObject(17, diagnosticoContato.getContatoProfissTel1());
			stmt.setObject(18, diagnosticoContato.getContatoProfissNome2());
			stmt.setObject(19, diagnosticoContato.getContatoProfissTel2());
			stmt.setObject(20, diagnosticoContato.getEquipaPublico());
			stmt.setObject(21, diagnosticoContato.getRelacaoViz());
			stmt.setObject(22, diagnosticoContato.getRelacaoVizFreq());
			stmt.setObject(23, diagnosticoContato.getConsFamiliaViz());
			stmt.setObject(24, diagnosticoContato.getHospitalNome());
			stmt.setObject(25, diagnosticoContato.getContatoReferNome());
			stmt.setObject(26, diagnosticoContato.getIdDiagnosticoContato());
			
			stmt.execute();
		}
		finally {
			if(stmt != null)
				stmt.close();
			if(stmt != null)
				stmt.close();
		}
	}    

}
