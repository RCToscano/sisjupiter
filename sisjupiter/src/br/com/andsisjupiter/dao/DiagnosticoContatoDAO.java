package br.com.andsisjupiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.andsisjupiter.modelo.DiagnosticoContato;
import br.com.sisjupiter.auxiliar.Auxiliar;

public class DiagnosticoContatoDAO {
    
    private Connection connection;

    public DiagnosticoContatoDAO(Connection connection) {
        
        this.connection = connection;
    }
    
    public void inserir(DiagnosticoContato diagnosticoContato) throws SQLException {

        PreparedStatement stmt = null;
                
        try {
        
            stmt = connection.prepareStatement(
            "INSERT INTO TB_DIAGNOCONTATO ( " +   
    		//"       ID_DIAGNOCONTATO, " +
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
            
            //stmt.setObject(1, diagnosticoContato.getIdDiagnosticoContato());
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