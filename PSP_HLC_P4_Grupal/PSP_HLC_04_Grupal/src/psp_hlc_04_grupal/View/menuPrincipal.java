/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_hlc_04_grupal.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chaob
 */
public class menuPrincipal extends javax.swing.JFrame {
    private CardLayout cardLayout; // Declarar el CardLayout como variable de clase
    private ventanaVisualizarDetalle panelDetalle;
    private JPanel panelResumen;
    /**
     * Creates new form menuPrincipal
     */
    public menuPrincipal() {
        initComponents();
        configurarPaneles(); 
    }
    
    private void configurarPaneles() {
       // Configurar el CardLayout en el menuPanel
       cardLayout = new CardLayout();
       menuPanel.setLayout(cardLayout);

       // Crear instancias de los paneles que deseas mostrar
       ventanaValidar panelValidar = new ventanaValidar();
       panelDetalle = new ventanaVisualizarDetalle();
       panelResumen = new ventanaVisualizarResumen();
       JPanel panelVacio = new JPanel();
       // Agregar los paneles al CardLayout con un nombre único
       menuPanel.add(panelVacio, "panelVacio");

       menuPanel.add(panelValidar, "panelValidar");
       menuPanel.add(panelDetalle, "panelDetalle");
       menuPanel.add(panelResumen, "panelResumen");
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        menuPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        validarMenu = new javax.swing.JMenuItem();
        visualizarMenu = new javax.swing.JMenu();
        visualizarMenuDetalle = new javax.swing.JMenuItem();
        visualizarMenuResumen = new javax.swing.JMenuItem();
        acercaDeMenu = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        jMenu2.setText("Opciones");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        validarMenu.setText("Validar");
        validarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarMenuActionPerformed(evt);
            }
        });
        jMenu2.add(validarMenu);

        visualizarMenu.setText("Visualizar");

        visualizarMenuDetalle.setText("Detalle");
        visualizarMenuDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarMenuDetalleActionPerformed(evt);
            }
        });
        visualizarMenu.add(visualizarMenuDetalle);

        visualizarMenuResumen.setText("Resumen");
        visualizarMenuResumen.setToolTipText("");
        visualizarMenuResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarMenuResumenActionPerformed(evt);
            }
        });
        visualizarMenu.add(visualizarMenuResumen);

        jMenu2.add(visualizarMenu);

        acercaDeMenu.setText("Acerca de");
        acercaDeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeMenuActionPerformed(evt);
            }
        });
        jMenu2.add(acercaDeMenu);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarMenuActionPerformed
        cardLayout.show(menuPanel, "panelValidar");
         
        panelDetalle.cargarDatos();
    }//GEN-LAST:event_validarMenuActionPerformed

    private void visualizarMenuDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarMenuDetalleActionPerformed
        cardLayout.show(menuPanel, "panelDetalle");
    }//GEN-LAST:event_visualizarMenuDetalleActionPerformed

    private void visualizarMenuResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarMenuResumenActionPerformed
         cardLayout.show(menuPanel, "panelResumen");
    }//GEN-LAST:event_visualizarMenuResumenActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void acercaDeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeMenuActionPerformed
        dialogAcercaDe acercaDeDialog = new dialogAcercaDe(this, true);
        
        acercaDeDialog.setVisible(true);
    }//GEN-LAST:event_acercaDeMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem acercaDeMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JMenuItem validarMenu;
    private javax.swing.JMenu visualizarMenu;
    private javax.swing.JMenuItem visualizarMenuDetalle;
    private javax.swing.JMenuItem visualizarMenuResumen;
    // End of variables declaration//GEN-END:variables
}