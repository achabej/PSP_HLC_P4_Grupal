

package psp_hlc_04_grupal.Exceptions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import psp_hlc_04_grupal.Model.Clases.Asignatura;
import java.util.*;
import psp_hlc_04_grupal.Model.Clases.Alumno;

public class MostrarDatosListaResumen {
    /*TO DO: Crear un metodo que recoga todos los elementos de Asignaturas
      y que calcule la nota media de las asignaturas de un alumno
    */
    //Statements y ResultSets simples
    
    private  PreparedStatement ps;
    ResultSet rs;
    
    public Alumno obtenerAlumno(String user) throws SQLException {
        List<Asignatura> asignaturas = new ArrayList<>();
        String query = "SELECT * FROM Alumno WHERE usuario = " + user;
        this.ps = CommonActions.createVistaResumen(query);
        this.rs = ps.executeQuery();

        Alumno alum = null;

        // Verifica que el ResultSet no esté vacío antes de acceder a los datos
        if (rs.next()) {
            // Obtiene la fecha de nacimiento como Date de la base de datos
            Date fechaNacSQL = rs.getDate("fechaNac");

            // Convierte la fecha a GregorianCalendar
            GregorianCalendar fechaNacGregorian = null;
            if (fechaNacSQL != null) {
                fechaNacGregorian = new GregorianCalendar();
                fechaNacGregorian.setTime(fechaNacSQL);
            }

            // Crea el objeto Alumno con la fecha de nacimiento en formato GregorianCalendar
            alum = new Alumno(
                rs.getInt("cod"),
                rs.getString("contraseña"),
                fechaNacGregorian,
                0,
                rs.getString("imageURL")
            );
        }

        // Cierra el ResultSet
        rs.close();
        return alum;
    }


    public float calcularNotaMedia(int codAlum) throws SQLException {
        String query = "SELECT AVG(nota) AS notaMedia FROM Asignatura WHERE codAlum = " + codAlum;
        ResultSet rs = ps.executeQuery(query);
        int notaMedia = 0;
        if (rs.next()) {
            notaMedia = rs.getInt("notaMedia");
        }
        rs.close();
        return notaMedia;
    }

    public void cerrarRecursos() throws SQLException {
        if (ps != null && !ps.isClosed()) ps.close();
        CommonActions.cerrarConexion();
    }
}
