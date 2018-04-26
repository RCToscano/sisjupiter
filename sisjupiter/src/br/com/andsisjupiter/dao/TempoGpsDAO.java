package br.com.andsisjupiter.dao;

import br.com.andsisjupiter.modelo.TempoGps;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TempoGpsDAO {

    Connection connection;

    public TempoGpsDAO(Connection connection) {
    
        this.connection = connection;
    }
    
    public List<TempoGps> listar() throws SQLException {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TempoGps> list = new ArrayList<TempoGps>();
        
        try {
        
            stmt = connection.prepareStatement(
            "SELECT TB_TEMPOGPS.ID_TEMPOGPS, " +
            "       TB_TEMPOGPS.TEMPO, " +
            "       TB_TEMPOGPS.INTERVALO " +
            "FROM   TB_TEMPOGPS ") ;

            rs = stmt.executeQuery();

            while (rs.next()) {

                TempoGps tempoGps = new TempoGps();
                tempoGps.setIdTempoGps(rs.getString("ID_TEMPOGPS"));
                tempoGps.setTempo(rs.getString("TEMPO"));
                tempoGps.setIntervalo(rs.getString("INTERVALO"));
                
                list.add(tempoGps);
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
