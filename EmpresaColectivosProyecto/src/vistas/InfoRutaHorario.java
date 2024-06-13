/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;
import entidades.Ruta;
import entidades.Horario;
import accesodatos.RutaData;
import accesodatos.HorarioData;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pablo
 */
public class InfoRutaHorario extends javax.swing.JPanel {
    List<Ruta> listaRutas;
    List<Ruta> listaOrigen;
    List<Ruta> listaDestino;
    List<Horario> listaHRutas;
    List<Horario> listaHSalida;
    
    private RutaData rutData;
    private HorarioData hrData;
    private Ruta rutaActual = new Ruta();
    
    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;

    /**
     * Creates new form infoRutaHorario
     */
    public InfoRutaHorario() {
        initComponents();
        this.rutData = new RutaData();
        this.hrData = new HorarioData();
        this.modelo = (DefaultTableModel) jTRutas.getModel();
        this.modelo2 = (DefaultTableModel) jTHorarios.getModel();
        jrbRutas.setSelected(false);
        jrbOrigen.setSelected(false);
        jrbDestino.setSelected(false);
        

        
    }
    
    private void cargarRutas(){
        listaRutas = rutData.listaRutasDispo();
        
        for(Ruta r: listaRutas){
            String rt = r.getOrigen() + " - " + r.getDestino();
            jcbRutas.addItem(rt);
            
        }
        
    }
    
    private void limpiarCamposRuta(){
        jtBRuta.setText("");
        jrbRutas.setSelected(false);
        jrbOrigen.setSelected(false);
        jrbDestino.setSelected(false);
        borrarFilasRuta();
        
    }
    
    private void limpiarCamposHorario(){
        jtHSalida.setText("");
        jcbRutas.removeAllItems();
        borrarFilasHorario();
    }
    
    private void borrarFilasRuta(){
         int filas=modelo.getRowCount()-1;
         for(int f=filas;f >= 0;f--){
             modelo.removeRow(f);
         }
    }
    private void borrarFilasHorario(){
         int filas=modelo2.getRowCount()-1;
         for(int f=filas;f >= 0;f--){
             modelo2.removeRow(f);
         }
    }
    
    public void llenarTabla(){
        String buscar = jtBRuta.getText().toLowerCase();
        
        borrarFilasRuta();
        
        for(Ruta r: listaRutas){
            String origen = r.getOrigen().toLowerCase();
            String destino = r.getDestino().toLowerCase();
            
            if (jrbRutas.isSelected() && (origen.contains(buscar) || destino.contains(buscar))) {
                modelo.addRow(new Object[]{r.getOrigen(), r.getDestino(), r.getDuracionEstimada()});
            } else if (jrbOrigen.isSelected() && origen.contains(buscar)) {
                modelo.addRow(new Object[]{r.getOrigen(), r.getDestino(), r.getDuracionEstimada()});
            } else if (jrbDestino.isSelected() && destino.contains(buscar)) {
                modelo.addRow(new Object[]{r.getOrigen(), r.getDestino(), r.getDuracionEstimada()});
            }
            
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

        jLabel1 = new javax.swing.JLabel();
        jtBRuta = new javax.swing.JTextField();
        jrbRutas = new javax.swing.JRadioButton();
        jrbOrigen = new javax.swing.JRadioButton();
        jrbDestino = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTRutas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtHSalida = new javax.swing.JTextField();
        jcbRutas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTHorarios = new javax.swing.JTable();
        jbBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("RUTAS");

        jtBRuta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.gray), "Buscar Ruta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 12))); // NOI18N
        jtBRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBRutaKeyReleased(evt);
            }
        });

        jrbRutas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jrbRutas.setText("Rutas");
        jrbRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbRutasActionPerformed(evt);
            }
        });

        jrbOrigen.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jrbOrigen.setText("Origen");
        jrbOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOrigenActionPerformed(evt);
            }
        });

        jrbDestino.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jrbDestino.setText("Destino");
        jrbDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDestinoActionPerformed(evt);
            }
        });

        jTRutas.setBackground(new java.awt.Color(128, 185, 203));
        jTRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Origen", "Destino", "Duracion"
            }
        ));
        jScrollPane3.setViewportView(jTRutas);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setText("HORARIOS");

        jtHSalida.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.gray), "Hora Salida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 12))); // NOI18N

        jcbRutas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.gray), "Rutas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 12))); // NOI18N
        jcbRutas.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));

        jTHorarios.setBackground(new java.awt.Color(128, 185, 203));
        jTHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ruta", "H. Salida", "H. Llegada"
            }
        ));
        jScrollPane1.setViewportView(jTHorarios);

        jbBuscar.setBackground(new java.awt.Color(128, 185, 203));
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.gray, java.awt.Color.gray));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Ingrese este formato HH:mm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jrbDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(jrbOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jrbRutas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtHSalida)
                                    .addComponent(jtBRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbRutas, 0, 180, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtBRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jrbRutas)
                        .addGap(16, 16, 16)
                        .addComponent(jrbOrigen)
                        .addGap(16, 16, 16)
                        .addComponent(jrbDestino))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jtHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(jbBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jcbRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtBRutaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBRutaKeyReleased
        // TODO add your handling code here:
        llenarTabla();
    }//GEN-LAST:event_jtBRutaKeyReleased

    private void jrbRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbRutasActionPerformed
        // TODO add your handling code here:
        llenarTabla();
        jrbOrigen.setSelected(false);
        jrbDestino.setSelected(false);
    }//GEN-LAST:event_jrbRutasActionPerformed

    private void jrbOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOrigenActionPerformed
        // TODO add your handling code here:
        llenarTabla();
        jrbRutas.setSelected(false);
        jrbDestino.setSelected(false);
    }//GEN-LAST:event_jrbOrigenActionPerformed

    private void jrbDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDestinoActionPerformed
        // TODO add your handling code here:
        llenarTabla();
        jrbRutas.setSelected(false);
        jrbOrigen.setSelected(false);
        
    }//GEN-LAST:event_jrbDestinoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String hSalida = jtHSalida.getText();
        LocalTime hora = LocalTime.parse(hSalida, formatter);
        this.listaHSalida = hrData.listaHorarioSalida(hora);
        String rutas = jcbRutas.getSelectedItem().toString();
        
        borrarFilasHorario();
        
        for (Horario hr : listaHSalida) {
            if (!hSalida.isEmpty()) {
                modelo2.addRow(new Object[]{hr.getRuta(), hr.getHoraSalida(), hr.getHoraLlegada()});
            }
        }
        
        for(Horario ruta: listaHRutas){
            if(rutas != null){
                modelo2.addRow(new Object[]{ruta.getRuta(), ruta.getHoraSalida(), ruta.getHoraLlegada()});
            }
        }
        
        
        
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTHorarios;
    private javax.swing.JTable jTRutas;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JComboBox<String> jcbRutas;
    private javax.swing.JRadioButton jrbDestino;
    private javax.swing.JRadioButton jrbOrigen;
    private javax.swing.JRadioButton jrbRutas;
    private javax.swing.JTextField jtBRuta;
    private javax.swing.JTextField jtHSalida;
    // End of variables declaration//GEN-END:variables
}
