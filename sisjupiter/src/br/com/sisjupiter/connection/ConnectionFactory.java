
package br.com.sisjupiter.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

////    //CONEXAO LOCAL
//    private static final String url = "jdbc:mysql://localhost:3306/sisjupiter001";
//    private static final String driver = "com.mysql.jdbc.Driver";
//    private static final String usuario = "root";
//    private static final String senha = "admin";
    
//    //CONEXAO REMOTA
//    private static final String url = "jdbc:mysql://192.175.112.170:3306/diagsdee_001";
//    private static final String driver = "com.mysql.jdbc.Driver";
//    private static final String usuario = "diagsdee_001";
//    private static final String senha = "87hfds&dsa123";
       
    //CONEXAO REMOTA
    private static final String url = "jdbc:mysql://localhost:3306/diagsdee_001";
    private static final String driver = "com.mysql.jdbc.Driver";
//    private static final String usuario = "diagsdee_001";
//    private static final String senha = "87hfds&dsa123";
    private static final String usuario = "root";
    private static final String senha = "admin";

    public static Connection getConnection() throws SQLException {

        try {

            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        } 
        catch (ClassNotFoundException e) {

            throw new SQLException(e.getMessage());
        }
    }
}
