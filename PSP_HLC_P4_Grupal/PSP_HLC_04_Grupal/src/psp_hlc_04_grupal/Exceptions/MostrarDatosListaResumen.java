
package psp_hlc_04_grupal.Exceptions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import psp_hlc_04_grupal.Model.Clases.Asignatura;
import java.util.*;

public class MostrarDatosListaResumen {
    /*TO DO: Crear un metodo que recoga todos los elementos de Asignaturas
      y que calcule la nota media de las asignaturas de un alumno
    */
    //Statements y ResultSets simples
    
private Statement st;

    public MostrarDatosListaResumen() throws SQLException {
        this.st = CommonActions.crearStatementResumen();
    }

    public List<Asignatura> obtenerAsignaturasPorAlumno(int codAlum) throws SQLException {
        List<Asignatura> asignaturas = new ArrayList<>();
        String query = "SELECT * FROM Asignatura WHERE codAlum = " + codAlum;
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            asignaturas.add(new Asignatura(rs.getInt("codAsig"), rs.getString("nomAsig"),
                                           rs.getFloat("nota"), codAlum));
        }
        rs.close();
        return asignaturas;
    }

    public float calcularNotaMedia(int codAlum) throws SQLException {
        String query = "SELECT AVG(nota) AS notaMedia FROM Asignatura WHERE codAlum = " + codAlum;
        ResultSet rs = st.executeQuery(query);
        int notaMedia = 0;
        if (rs.next()) {
            notaMedia = rs.getInt("notaMedia");
        }
        rs.close();
        return notaMedia;
    }

    public void cerrarRecursos() throws SQLException {
        if (st != null && !st.isClosed()) st.close();
        CommonActions.cerrarConexion();
    }
}
