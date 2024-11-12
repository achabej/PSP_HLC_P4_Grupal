/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_hlc_04_grupal.View;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import psp_hlc_04_grupal.Exceptions.CommonActions;
import psp_hlc_04_grupal.Exceptions.DesplazamientoListaDetalle;
import psp_hlc_04_grupal.Exceptions.MostrarDatosListaResumen;
import psp_hlc_04_grupal.Model.Clases.Alumno;
import psp_hlc_04_grupal.Model.Clases.Asignatura;

/**
 *
 * @author chaob
 */
public class ventanaVisualizarResumen extends javax.swing.JPanel {

    private MostrarDatosListaResumen datosListaResumen;

    public ventanaVisualizarResumen() {
        initComponents();

        datosListaResumen = new MostrarDatosListaResumen();
        
    }
    
    public void cargarDatos() {
    try {
        Alumno alumno = datosListaResumen.obtenerAlumno(CommonActions.getUser());
        if (alumno != null) {
            nameLabel.setText(alumno.getUsuario());  // Cambiado para mostrar el usuario
            dateChooser.setDate(alumno.getFechaNac().getTime()); // Fecha de nacimiento
            notaMediaLabel.setText(String.valueOf(alumno.getNotaMedia())); // Nota media
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos disponibles para el usuario.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage());
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new com.toedter.calendar.JDateChooser();
        nameLabel = new javax.swing.JTextField();
        notaMediaLabel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();

        nameLabel.setEditable(false);
        nameLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameLabelActionPerformed(evt);
            }
        });

        notaMediaLabel.setEditable(false);
        notaMediaLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaMediaLabelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("Resumen Alumno");

        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/default.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel)
                    .addComponent(notaMediaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(notaMediaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(imgLabel)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameLabelActionPerformed

    private void notaMediaLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaMediaLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notaMediaLabelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameLabel;
    private javax.swing.JTextField notaMediaLabel;
    // End of variables declaration//GEN-END:variables
}
