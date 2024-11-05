
package psp_hlc_04_grupal.Exceptions;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonActions {
    private static final String URL = "jdbc:derby://localhost:1527/miDB;create=true";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static Connection conn = null;
    
    public static Connection abrirConexion() throws SQLException{
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conn;
    }
    
    public static Connection cerrarConexion() throws SQLException{
        if (conn != null && !conn.isClosed()){
            conn.close();
        }
        return conn;
    }
    
    public static Statement crearStatementDetalle() throws SQLException {
        return abrirConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    
    public static Statement crearStatementResumen() throws SQLException {
        return abrirConexion().createStatement();
    }
}
