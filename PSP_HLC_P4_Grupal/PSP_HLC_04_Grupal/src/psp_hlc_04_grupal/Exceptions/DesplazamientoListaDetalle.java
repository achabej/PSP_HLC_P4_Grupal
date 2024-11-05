
package psp_hlc_04_grupal.Exceptions;

import java.sql.*;
import psp_hlc_04_grupal.Model.Clases.Asignatura;

public class DesplazamientoListaDetalle {
    //TO DO: Crear metodos para avanzar y retroceder en la lista detalle
    //Usar en statements TYPE_SCROLL_SENSITIVE e INSENSITIVE
    
    private Statement st;
    private ResultSet rs;

    public DesplazamientoListaDetalle() throws SQLException {
        // Usa CommonActions para obtener un Statement desplazable y actualizable para "detalle"
        this.st = CommonActions.crearStatementDetalle();
        // Ejecuta una consulta inicial para obtener todas las asignaturas
        String query = "SELECT * FROM Asignatura";
        this.rs = st.executeQuery(query);
    }

    public Asignatura obtenerAsignaturaActual() throws SQLException {
        // Devuelve el objeto Asignatura de la posición actual en el ResultSet
        if (rs != null && !rs.isBeforeFirst() && !rs.isAfterLast()) {
            return new Asignatura(
                rs.getInt("codAsig"),
                rs.getString("nomAsig"),
                rs.getDouble("nota"),
                rs.getInt("codAlum")
            );
        }
        return null;
    }

    public boolean avanzar() throws SQLException {
        // Mueve el cursor al siguiente registro
        return rs.next();
    }

    public boolean retroceder() throws SQLException {
        // Mueve el cursor al registro anterior
        return rs.previous();
    }

    public boolean esPrimero() throws SQLException {
        // Verifica si el cursor está en el primer registro
        return rs.isFirst();
    }

    public boolean esUltimo() throws SQLException {
        // Verifica si el cursor está en el último registro
        return rs.isLast();
    }

    public void irPrimero() throws SQLException {
        // Mueve el cursor al primer registro
        rs.first();
    }

    public void irUltimo() throws SQLException {
        // Mueve el cursor al último registro
        rs.last();
    }

    public void actualizarNotaActual(double nuevaNota) throws SQLException {
        // Actualiza la nota del registro actual en el ResultSet
        rs.updateDouble("nota", nuevaNota);
        rs.updateRow(); // Guarda los cambios en la base de datos
    }

    public void cerrarRecursos() throws SQLException {
        // Cierra ResultSet y Statement para evitar fugas de memoria
        if (rs != null && !rs.isClosed()) rs.close();
        if (st != null && !st.isClosed()) st.close();
        CommonActions.cerrarConexion();
    }
}



