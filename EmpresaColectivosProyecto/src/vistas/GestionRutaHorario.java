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
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
/**
 *
 * @author pablo
 */
public class GestionRutaHorario extends javax.swing.JPanel {
    private RutaData rutData = new RutaData();
    private Ruta rutaActual = null;
    private HorarioData hrData = new HorarioData();
    private Horario hrActual = null;
    List<Ruta> listaRutasDispo;
    List<Horario> listaHorarios;
    

    /**
     * Creates new form GestionRutaHorario
     */
    public GestionRutaHorario() {
        initComponents();
        origenInvalido.setVisible(false);
        destinoInvalido.setVisible(false);
        duracionInvalida.setVisible(false);
        salidaInvalida.setVisible(false);
        llegadaInvalida.setVisible(false);
        refrescarComboBox();        
    }
    
    private void refrescarComboBox(){
        jcbRutas.removeAllItems();
        HRutas.removeAllItems();
        jcbHorarios.removeAllItems();
        
        this.listaRutasDispo = rutData.listaRutasDispo();

        
        for (Ruta r : listaRutasDispo) {
            jcbRutas.addItem(r.getOrigen() + " - "  + r.getDestino() + " - "  + r.getDuracionEstimada());
        }
        for (Ruta r2 : listaRutasDispo) {
             HRutas.addItem(r2.getOrigen() + " - "   + r2.getDestino() + " - "   + r2.getDuracionEstimada());
        }
        if(HRutas.getSelectedItem()!=null){
            String rutaSeleccionada = HRutas.getSelectedItem().toString();
            List<Ruta> rutas = listaRutasDispo;
            for(Ruta r:rutas){
                String sruta = r.getOrigen() + " - "  + r.getDestino() + " - "  + r.getDuracionEstimada();
                if(sruta.equals(rutaSeleccionada)){
                    this.listaHorarios = hrData.listaHorarioRutas(r);
                }
            }   
        }
    }
    
    private void limpiarCampos(){
        jtOrigen.setText("");
        jtDestino.setText("");
        jtDuracion.setText("");
        origenInvalido.setVisible(false);
        destinoInvalido.setVisible(false);
        duracionInvalida.setVisible(false);
    }
     
    private void limpiarCamposHorario(){
        jtHSalida.setText("");
        jtHLlegada.setText("");
        salidaInvalida.setVisible(false);
        llegadaInvalida.setVisible(false);
    } 
    
    private boolean validarTexto(String string){
        Pattern patron = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚ]+$");
        Matcher match=patron.matcher(string);
        return match.matches();
    }
    
    private boolean validarHora(String string){
        Pattern patron = Pattern.compile("^(?:[01]\\d|2[0-3]):[0-5]\\d$");
        Matcher match = patron.matcher(string);
        return match.matches();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jtOrigen = new javax.swing.JTextField();
        jtDestino = new javax.swing.JTextField();
        jtDuracion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        HRutas = new javax.swing.JComboBox<>();
        jtHSalida = new javax.swing.JTextField();
        jtHLlegada = new javax.swing.JTextField();
        salidaInvalida = new javax.swing.JLabel();
        llegadaInvalida = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbRutas = new javax.swing.JComboBox<>();
        origenInvalido = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        destinoInvalido = new javax.swing.JLabel();
        duracionInvalida = new javax.swing.JLabel();
        jbEliminar = new javax.swing.JButton();
        jcbHorarios = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jbHEliminar = new javax.swing.JButton();
        jbAñadir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAgregar.setText("Agregar");
        jbAgregar.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.gray));
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 86, -1));

        jtOrigen.setBackground(new java.awt.Color(204, 204, 204));
        jtOrigen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 255)), "Origen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N
        jtOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtOrigenKeyReleased(evt);
            }
        });
        jPanel1.add(jtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 20, 280, -1));

        jtDestino.setBackground(new java.awt.Color(204, 204, 204));
        jtDestino.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 255, 255)), "Destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N
        jtDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtDestinoKeyReleased(evt);
            }
        });
        jPanel1.add(jtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, -1));

        jtDuracion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51)));
        jtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtDuracionKeyReleased(evt);
            }
        });
        jPanel1.add(jtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 159, 184, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel4.setText("Duración:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 158, 81, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel3.setText("Rutas:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 57, -1));

        HRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HRutasActionPerformed(evt);
            }
        });
        jPanel2.add(HRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 244, -1));

        jtHSalida.setBackground(new java.awt.Color(204, 204, 204));
        jtHSalida.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white), "Hora Salida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N
        jtHSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtHSalidaKeyReleased(evt);
            }
        });
        jPanel2.add(jtHSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, -1));

        jtHLlegada.setBackground(new java.awt.Color(204, 204, 204));
        jtHLlegada.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white), "Hora Llegada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14))); // NOI18N
        jtHLlegada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtHLlegadaKeyReleased(evt);
            }
        });
        jPanel2.add(jtHLlegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 200, -1));

        salidaInvalida.setForeground(new java.awt.Color(255, 0, 0));
        salidaInvalida.setText("Horario invalido.");
        jPanel2.add(salidaInvalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 154, -1));

        llegadaInvalida.setForeground(new java.awt.Color(255, 0, 0));
        llegadaInvalida.setText("Horario invalido.");
        jPanel2.add(llegadaInvalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 154, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel5.setText("Buscar Ruta:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jcbRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbRutasActionPerformed(evt);
            }
        });
        jPanel1.add(jcbRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 278, -1));

        origenInvalido.setForeground(new java.awt.Color(255, 0, 0));
        origenInvalido.setText("Origen invalido.");
        jPanel1.add(origenInvalido, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 274, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 8, 248));

        destinoInvalido.setForeground(new java.awt.Color(255, 0, 0));
        destinoInvalido.setText("Destino invalido.");
        jPanel1.add(destinoInvalido, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 130, 271, -1));

        duracionInvalida.setForeground(new java.awt.Color(255, 0, 0));
        duracionInvalida.setText("Hora y/o minutos invalidos.");
        jPanel1.add(duracionInvalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 181, 170, 17));

        jbEliminar.setText("Eliminar");
        jbEliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.gray));
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 86, -1));

        jcbHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHorariosActionPerformed(evt);
            }
        });
        jPanel1.add(jcbHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 296, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel6.setText("Buscar Horarios:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        jbHEliminar.setText("Eliminar");
        jbHEliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.gray));
        jbHEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbHEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 70, -1));

        jbAñadir.setText("Añadir");
        jbAñadir.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.gray));
        jbAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(jbAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 70, -1));

        jLabel1.setFont(new java.awt.Font("Source Serif Pro Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Horarios");

        jLabel7.setFont(new java.awt.Font("Source Serif Pro Black", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Rutas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(378, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(423, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        // TODO add your handling code here:
        String origen = null;
        String destino = null;
        LocalTime duracion = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        
        if(jtOrigen.getText().isEmpty() ||  jtDestino.getText().isEmpty() ||  jtDuracion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Hay campos sin completar");   
        }else{
            //Validar Origen
            if(validarTexto(jtOrigen.getText())){
                origen = jtOrigen.getText();
            }else{
                origenInvalido.setVisible(true);
            }
            //validar destino
            if(validarTexto(jtDestino.getText())){
                destino = jtDestino.getText();
            }else{
                destinoInvalido.setVisible(true);
            }
            if(validarHora(jtDuracion.getText())){
                String duracionS = jtDuracion.getText();
                duracion = LocalTime.parse(duracionS, formatter);
            }else{
                duracionInvalida.setVisible(true);
            }
            
            if(!duracionInvalida.isVisible() && !origenInvalido.isVisible() && !destinoInvalido.isVisible()){
               if (rutaActual == null) {
                rutaActual = new Ruta(origen, destino, duracion, true);
                rutData.guardarRuta(rutaActual);
                rutaActual = null;
                limpiarCampos();
            } else {
                rutaActual.setOrigen(origen);
                rutaActual.setDestino(destino);
                rutaActual.setDuracionEstimada(duracion);
                rutData.actualizarRuta(rutaActual);
                rutaActual = null;
                limpiarCampos();
                } 
            }            
        }
            
        
        
       refrescarComboBox(); 

    }//GEN-LAST:event_jbAgregarActionPerformed

        
    private void jcbRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbRutasActionPerformed
        
    }//GEN-LAST:event_jcbRutasActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        if (jcbRutas.getSelectedItem() != null) {
            String rutaSeleccionada = jcbRutas.getSelectedItem().toString();
            List<Ruta> rutas = listaRutasDispo;
            for(Ruta r:rutas){
                String sruta = r.getOrigen() + " - "  + r.getDestino() + " - "  + r.getDuracionEstimada();
                if(sruta.equals(rutaSeleccionada)){
                    rutData.eliminarRuta(r.getIdRuta());
                }
            }
        }else {
            JOptionPane.showMessageDialog(this, "No hay elementos seleccionados para eliminar.");
        }
        refrescarComboBox();
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void HRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HRutasActionPerformed
        jcbHorarios.removeAllItems();
        if(HRutas.getSelectedItem()!=null){
            String rutaSeleccionada = HRutas.getSelectedItem().toString();
            List<Ruta> rutas = listaRutasDispo;
            for(Ruta r:rutas){
                String sruta = r.getOrigen() + " - "  + r.getDestino() + " - "  + r.getDuracionEstimada();
                if(sruta.equals(rutaSeleccionada)){
                    this.listaHorarios = hrData.listaHorarioRutas(r);
                }
            }
            for(Horario h: listaHorarios){
                jcbHorarios.addItem(h.getHoraSalida() + " - "  + h.getHoraLlegada());
            }  
        }
    }//GEN-LAST:event_HRutasActionPerformed

    private void jbAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAñadirActionPerformed
        // TODO add your handling code here:
        String hSalida = null;
        String hLlegada = null;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaSalida = null;
        LocalTime horaLlegada = null;
        
        
        if (validarHora(jtHSalida.getText())) {
            hSalida = jtHSalida.getText();
            horaSalida = LocalTime.parse(hSalida, formatter);
        } else {
            salidaInvalida.setVisible(true);
        }
        if (validarHora(jtHLlegada.getText())) {
            hLlegada = jtHLlegada.getText();
            horaLlegada = LocalTime.parse(hLlegada, formatter);
        } else {
            llegadaInvalida.setVisible(true);
        }
        
        
        if (!salidaInvalida.isVisible() && !llegadaInvalida.isVisible() && HRutas.getSelectedItem() != null){
            if (hrActual == null) {
                String rutaSeleccionada = HRutas.getSelectedItem().toString();
                List<Ruta> rutas = listaRutasDispo;
                for(Ruta r:rutas){
                    System.out.println(r.toString());
                    String sruta = r.getOrigen() + " - "  + r.getDestino() + " - "  + r.getDuracionEstimada();
                    if(sruta.equals(rutaSeleccionada)){
                        hrActual = new Horario(r,horaSalida, horaLlegada, true);
                        hrData.guardarhorario(hrActual);
                    }   
                }     
            } else{
                hrActual.setHoraSalida(horaSalida);
                hrActual.setHoraLlegada(horaLlegada);
                hrData.actualizarhorario(hrActual);
            }
  
        }

        limpiarCamposHorario();
        refrescarComboBox();   
    }//GEN-LAST:event_jbAñadirActionPerformed

    private void jbHEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHEliminarActionPerformed
        // TODO add your handling code here:
        if (HRutas.getSelectedItem() != null) {
            String rutaSeleccionada = HRutas.getSelectedItem().toString();
            List<Ruta> rutas = listaRutasDispo;
            for(Ruta r:rutas){
                String sruta = r.getOrigen() + " - "  + r.getDestino() + " - "  + r.getDuracionEstimada();
                if(sruta.equals(rutaSeleccionada)){
                    String horarioSeleccionado = jcbHorarios.getSelectedItem().toString();
                    List<Horario> horarios = hrData.listaHorarioRutas(r);
                    for(Horario h:horarios){
                        String hora = h.getHoraSalida() + " - "  + h.getHoraLlegada();
                        if (hora.equals(horarioSeleccionado)) {
                            hrData.eliminarhorario(h.getIdHorario());
                        }
                    }
                }
            }
        }else {
            JOptionPane.showMessageDialog(this, "No hay elementos seleccionados para eliminar.");
        }
        refrescarComboBox();
    }//GEN-LAST:event_jbHEliminarActionPerformed

    private void jcbHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbHorariosActionPerformed

    }//GEN-LAST:event_jcbHorariosActionPerformed

    private void jtDestinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDestinoKeyReleased
        destinoInvalido.setVisible(false);
    }//GEN-LAST:event_jtDestinoKeyReleased

    private void jtOrigenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtOrigenKeyReleased
        origenInvalido.setVisible(false);
    }//GEN-LAST:event_jtOrigenKeyReleased

    private void jtDuracionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDuracionKeyReleased
        duracionInvalida.setVisible(false);
    }//GEN-LAST:event_jtDuracionKeyReleased

    private void jtHSalidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtHSalidaKeyReleased
        salidaInvalida.setVisible(false);
    }//GEN-LAST:event_jtHSalidaKeyReleased

    private void jtHLlegadaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtHLlegadaKeyReleased
        llegadaInvalida.setVisible(false);
    }//GEN-LAST:event_jtHLlegadaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> HRutas;
    private javax.swing.JLabel destinoInvalido;
    private javax.swing.JLabel duracionInvalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbAñadir;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbHEliminar;
    private javax.swing.JComboBox<String> jcbHorarios;
    private javax.swing.JComboBox<String> jcbRutas;
    private javax.swing.JTextField jtDestino;
    private javax.swing.JTextField jtDuracion;
    private javax.swing.JTextField jtHLlegada;
    private javax.swing.JTextField jtHSalida;
    private javax.swing.JTextField jtOrigen;
    private javax.swing.JLabel llegadaInvalida;
    private javax.swing.JLabel origenInvalido;
    private javax.swing.JLabel salidaInvalida;
    // End of variables declaration//GEN-END:variables
}
