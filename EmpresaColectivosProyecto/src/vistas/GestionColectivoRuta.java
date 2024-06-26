/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import accesodatos.ColectivoRutaData;
import accesodatos.RutaData;
import entidades.Colectivo;
import entidades.ColectivoRuta;
import entidades.Ruta;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class GestionColectivoRuta extends javax.swing.JPanel {
    ColectivoRutaData crData = new ColectivoRutaData();
    RutaData rData = new RutaData();
    List<Colectivo> colectivosDisponibles;
    List<Colectivo> colectivosAsignados;
    List<Ruta> rutas;
    /**
     * Creates new form GestionColectivoRuta
     */
    public GestionColectivoRuta() {
        initComponents();
        jcbColectivoRuta.setEnabled(false); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbRutas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jcbColectivoDisponible = new javax.swing.JComboBox<>();
        jbAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbRutas2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jcbColectivoRuta = new javax.swing.JComboBox<>();
        jbEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Source Serif Pro Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Eliminar un colectivo de una ruta");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Elija un colectivo disponible:");

        jcbRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbRutasActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Elija una ruta:");

        jbAgregar.setText("Añadir");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Source Serif Pro Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Asignar un colectivo a una ruta");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Elija una ruta:");

        jcbRutas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbRutas2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Elija un colectivo:");

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbColectivoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jcbRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcbColectivoRuta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbRutas2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jbEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jbAgregar)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbColectivoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jbAgregar)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcbRutas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbColectivoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbEliminar)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        int idRuta = -1;
        int idColectivo = -1;
        Colectivo colectivoObjeto = null;
        Ruta rutaObjeto = null;
        if (jcbRutas.getSelectedItem() != null && jcbColectivoDisponible.getSelectedItem() != null) {
            String rutaSeleccionada = jcbRutas.getSelectedItem().toString();
            String colectivoSeleccionado = jcbColectivoDisponible.getSelectedItem().toString();
            for (Ruta r: rutas) {
                String ruta = r.getIdRuta()+ "," + r.getOrigen() + "," + r.getDestino() + "," + r.getDuracionEstimada();
                if (ruta.equals(rutaSeleccionada)) {
                    rutaObjeto = r;
                }
            }
            for(Colectivo c: colectivosDisponibles){
                String colectivo = c.getIdColectivo() + "," + c.getMatricula() + "," + c.getMarca() + "," + c.getCapacidad();
                if (colectivo.equals(colectivoSeleccionado)) {
                    colectivoObjeto = c;
                }
            }
            ColectivoRuta cr = new ColectivoRuta(colectivoObjeto,rutaObjeto);
            crData.guardarColectivoRuta(cr);
            refrescarComboBox();
        }
        
        
        
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jcbRutas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbRutas2ActionPerformed
        int idRutaActual = -1;
        jcbColectivoRuta.removeAllItems();
        if (jcbRutas2.getSelectedItem() != null) {
           jcbColectivoRuta.setEnabled(true);
           String rutaSeleccionada = jcbRutas2.getSelectedItem().toString();
           for(Ruta r:rutas){
                String ruta = r.getIdRuta()+ "," + r.getOrigen() + "," + r.getDestino() + "," + r.getDuracionEstimada();
                if (ruta.equals(rutaSeleccionada)) {
                    idRutaActual = r.getIdRuta();
                }
            }
           this.colectivosAsignados = crData.obtenerColectivosPorRuta(idRutaActual);
           for(Colectivo c: colectivosAsignados){
            jcbColectivoRuta.addItem(c.getIdColectivo() + "," + c.getMatricula() + "," + c.getMarca() + "," + c.getCapacidad());   
           } 
        }
    }//GEN-LAST:event_jcbRutas2ActionPerformed

    private void jcbRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbRutasActionPerformed
        
    }//GEN-LAST:event_jcbRutasActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int idRuta = -1;
        int idColectivo = -1;
        if (jcbRutas2.getSelectedItem() != null && jcbColectivoRuta.getSelectedItem() != null) {
            String rutaSeleccionada = jcbRutas2.getSelectedItem().toString();
            String colectivoSeleccionado = jcbColectivoRuta.getSelectedItem().toString();
            for (Ruta r: rutas) {
                String ruta = r.getIdRuta()+ "," + r.getOrigen() + "," + r.getDestino() + "," + r.getDuracionEstimada();
                if (ruta.equals(rutaSeleccionada)) {
                    idRuta = r.getIdRuta();
                }
            }
            for(Colectivo c: colectivosAsignados){
                String colectivo = c.getIdColectivo() + "," + c.getMatricula() + "," + c.getMarca() + "," + c.getCapacidad();
                if (colectivo.equals(colectivoSeleccionado)) {
                    idColectivo = c.getIdColectivo();
                }
            }
            crData.eliminarColectivoRuta(idColectivo, idRuta);
            refrescarComboBox();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed
    
    public void refrescarComboBox(){
        this.colectivosDisponibles = crData.obtenerColectivosDisponibles();
        this.rutas = rData.listaRutasDispo();
        jcbRutas.removeAllItems();
        jcbRutas2.removeAllItems();
        jcbColectivoDisponible.removeAllItems();
        jcbColectivoRuta.removeAllItems();
        for (Ruta r: rutas) {
            jcbRutas.addItem(r.getIdRuta()+ "," + r.getOrigen() + "," + r.getDestino() + "," + r.getDuracionEstimada());
        }
        for (Ruta r: rutas) {
            jcbRutas2.addItem(r.getIdRuta()+ "," + r.getOrigen() + "," + r.getDestino() + "," + r.getDuracionEstimada());
        }
        for(Colectivo c: colectivosDisponibles){            
            jcbColectivoDisponible.addItem(c.getIdColectivo() + "," + c.getMatricula() + "," + c.getMarca() + "," + c.getCapacidad());
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JComboBox<String> jcbColectivoDisponible;
    private javax.swing.JComboBox<String> jcbColectivoRuta;
    private javax.swing.JComboBox<String> jcbRutas;
    private javax.swing.JComboBox<String> jcbRutas2;
    // End of variables declaration//GEN-END:variables
}
