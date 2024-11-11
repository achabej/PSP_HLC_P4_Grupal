

package psp_hlc_04_grupal.Exceptions;

import java.sql.*;
import java.util.GregorianCalendar;
import psp_hlc_04_grupal.Model.Clases.Alumno;

public class ModificarAlumno {
    private PreparedStatement ps;

    public Alumno obtenerAlumno(int numero) throws SQLException {
        String query = "SELECT * FROM Alumno WHERE numero = ?";
        ps = CommonActions.createStatementAlumno(query); // Usar el nuevo método que devuelve PreparedStatement
        ps.setInt(1, numero);
        ResultSet rs = ps.executeQuery();

        Alumno alumno = null;
        if (rs.next()) {
            alumno = new Alumno(
                rs.getInt("numAlum"), 
                rs.getString("contraseña"),  
                new GregorianCalendar(
                    rs.getDate("fechaNac").toLocalDate().getYear(),
                    rs.getDate("fechaNac").toLocalDate().getMonthValue() - 1,
                    rs.getDate("fechaNac").toLocalDate().getDayOfMonth()
                ), 
                rs.getInt("notaMedia"), 
                rs.getString("imagen")
            );
        }
        rs.close();
        return alumno;
    }

    public void actualizarFechaNacimiento(int numero, Date nuevaFecha) throws SQLException {
        String query = "UPDATE Alumno SET fechaNac = ? WHERE numero = ?";
        ps = CommonActions.createStatementAlumno(query);
        ps.setDate(1, nuevaFecha);
        ps.setInt(2, numero);
        ps.executeUpdate();
    }

    public void actualizarNotaMedia(int numero, int nuevaNotaMedia) throws SQLException {
        String query = "UPDATE Alumno SET notaMedia = ? WHERE numero = ?";
        ps = CommonActions.createStatementAlumno(query);
        ps.setInt(1, nuevaNotaMedia);
        ps.setInt(2, numero);
        ps.executeUpdate();
    }

    public void cerrarRecursos() throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        CommonActions.cerrarConexion();
    }
}

