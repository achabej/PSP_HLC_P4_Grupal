

package psp_hlc_04_grupal.Exceptions;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonActions {
    private static final String URL = "jdbc:derby://localhost:1527/PsP04;create=true";
    private static String USER = null;
    private static String PASSWORD = null;
    private static Connection conn = null;
    
    public static Connection abrirConexion(String user, String password) throws SQLException, ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");

        if (conn == null || conn.isClosed()) {
            USER = user;
            PASSWORD = password;
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
    
    public static PreparedStatement createStatementAlumno(String query) throws SQLException {
        return conn.prepareStatement(query);
    }
    
    public static PreparedStatement createVistaDetalle(String query) throws SQLException {
        try {
            abrirConexion(USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommonActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    // Método para obtener un PreparedStatement scroll-insensitive
    public static PreparedStatement createVistaResumen(String query) throws SQLException {
        try {
            abrirConexion(USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommonActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    
    public static String getUser(){
        return USER;
    }
}
