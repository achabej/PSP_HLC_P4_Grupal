
package psp_hlc_04_grupal.Exceptions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import psp_hlc_04_grupal.Model.Clases.Asignatura;

public class DesplazamientoListaDetalle {
    //TO DO: Crear metodos para avanzar y retroceder en la lista detalle
    //Usar en statements TYPE_SCROLL_SENSITIVE e INSENSITIVE
    
    private PreparedStatement ps;
    private ResultSet rs;
    public ArrayList<Asignatura> listaAsig;
    
    public ArrayList<Asignatura> obtenerAsignaturas() throws SQLException {
        listaAsig = new ArrayList<>();
        String user = CommonActions.getUser();
        String query = "SELECT * FROM Asignatura WHERE codAlum in (SELECT numAlum FROM Alumno WHERE usuario = ?)";
        this.ps = CommonActions.createVistaResumen(query);
        ps.setString(1, user);
        this.rs = ps.executeQuery();
        
        while (rs.next()) {
            listaAsig.add(new Asignatura(rs.getInt("codasig"), rs.getString("nomasig"),
                                           rs.getFloat("nota"), rs.getInt("codAlum")));
        }
        rs.close();
        return listaAsig;
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
         if (rs != null) {
            rs.last();  // Mueve el cursor al último registro
        } else {
            throw new SQLException("El ResultSet no ha sido inicializado.");
        }
    }

    public void actualizarNotaActual(double nuevaNota) throws SQLException {
        // Actualiza la nota del registro actual en el ResultSet
        rs.updateDouble("nota", nuevaNota);
        rs.updateRow(); // Guarda los cambios en la base de datos
    }

    public void cerrarRecursos() throws SQLException {
        // Cierra ResultSet y Statement para evitar fugas de memoria
        if (rs != null && !rs.isClosed()) rs.close();
        if (ps != null && !ps.isClosed()) ps.close();
        CommonActions.cerrarConexion();
    }
    
    public ResultSet getRS(){
        return rs;
    }
}


