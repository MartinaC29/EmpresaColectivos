/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import accesodatos.ColectivoData;
import accesodatos.ColectivoRutaData;
import accesodatos.HorarioData;
import accesodatos.PasajeData;
import accesodatos.PasajerosData;
import accesodatos.RutaData;
import entidades.Colectivo;
import entidades.Horario;
import entidades.Pasaje;
import entidades.Pasajero;
import entidades.Ruta;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class GestionPasaje extends javax.swing.JPanel {
    PasajerosData pData = new PasajerosData();
    RutaData rData = new RutaData();
    HorarioData hData = new HorarioData();
    ColectivoRutaData crData = new ColectivoRutaData();
    ColectivoData cData = new ColectivoData();
    PasajeData pasData = new PasajeData();
    List<Pasajero> pasajeros;
    Ruta rutaActual = null;
    Horario horarioActual = null;
    Pasajero pasajeroActual = null;
    Colectivo colectivoActual = null;
    /**
     * Creates new form GestionPasaje
     */
    public GestionPasaje() {
        initComponents();
        jcbPasajeros.setEnabled(false);
        jbColectivoValido.setVisible(false);
        jbRutaValida.setVisible(false);
        jbFechaValida.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbComprar = new javax.swing.JButton();
        jtOrigen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbDestino = new javax.swing.JComboBox<>();
        jcbHorarios = new javax.swing.JComboBox<>();
        jcbPasajeros = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jcbColectivo = new javax.swing.JComboBox<>();
        jbColectivoValido = new javax.swing.JLabel();
        jbRutaValida = new javax.swing.JLabel();
        jdFecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jbFechaValida = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Colectivos:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Elija el pasajero:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Destinos:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jbComprar.setText("Comprar pasaje");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });
        add(jbComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, -1));

        jtOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtOrigenKeyReleased(evt);
            }
        });
        add(jtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 150, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Ingrese el origen:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        add(jcbDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 240, -1));

        add(jcbHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, -1));

        jcbPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPasajerosActionPerformed(evt);
            }
        });
        add(jcbPasajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 260, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Fecha:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));

        add(jcbColectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 260, -1));

        jbColectivoValido.setForeground(new java.awt.Color(255, 0, 51));
        jbColectivoValido.setText("No quedan colectivos disponibles");
        add(jbColectivoValido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 240, -1));

        jbRutaValida.setForeground(new java.awt.Color(255, 0, 51));
        jbRutaValida.setText("Debe seleccionar una ruta valida");
        add(jbRutaValida, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, -1));

        jdFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdFechaPropertyChange(evt);
            }
        });
        add(jdFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Horario:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jbFechaValida.setForeground(new java.awt.Color(255, 0, 51));
        jbFechaValida.setText("Fecha invalida");
        add(jbFechaValida, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 80, -1));

        jLabel11.setFont(new java.awt.Font("Source Serif Pro Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Elija una ruta");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Source Serif Pro Black", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Venta de pasajes");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed
        Date fecha;
        LocalDate fechaSeleccionada = null;
        if (rutaActual == null) {
            jbRutaValida.setVisible(true);
        }
        if(colectivoActual == null){
            jbColectivoValido.setVisible(true);
        }
        if (jdFecha.getDate() == null) {
            jbFechaValida.setVisible(true);
        }else{
            fecha = jdFecha.getDate();
            fechaSeleccionada = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        
        if (colectivoActual != null && rutaActual != null && pasajeroActual != null && horarioActual != null && fechaSeleccionada != null) {
            Pasaje pasaje = new Pasaje(pasajeroActual,colectivoActual,rutaActual,fechaSeleccionada,rutaActual.getDuracionEstimada(),(colectivoActual.getAsientosOcupados()+1),(rutaActual.getDuracionEstimada().getHour()*100));
            pasData.guardarPasaje(pasaje);
            cData.actualizarAsientosOcupados(colectivoActual);
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea imprimir un recibo?", "Confirmacion",JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                ReciboPago rp = new ReciboPago(pasaje);
                int option = JOptionPane.showConfirmDialog(null, rp,"Recibo de pago",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
            }
            jtOrigen.setText("");
            jcbPasajeros.removeAllItems();
            jcbColectivo.removeAllItems();
            jcbDestino.removeAllItems();
            jcbHorarios.removeAllItems();
            rutaActual = null;
            horarioActual = null;
            pasajeroActual = null;
            colectivoActual = null;
            jdFecha.cleanup();
        }
    }//GEN-LAST:event_jbComprarActionPerformed

    private void jtOrigenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtOrigenKeyReleased
        jbRutaValida.setVisible(false);
        jbColectivoValido.setVisible(false);
        jcbPasajeros.removeAllItems();
        jcbColectivo.removeAllItems();
        jcbDestino.removeAllItems();
        jcbHorarios.removeAllItems();
        String origenSeleccionado = jtOrigen.getText().toLowerCase();
        List<Ruta> rutasOrigen = rData.listaRutasOrigen(origenSeleccionado);
        List<Ruta> rutas = rData.listaRutasDispo();
        rutaActual = null;
        horarioActual = null;
        colectivoActual = null;
        pasajeroActual = null;
        for(Ruta r:rutasOrigen){
            jcbDestino.addItem(" Dest: " + r.getDestino() + ", Dur.Est: " + r.getDuracionEstimada());
        }  
        if (jcbDestino.getSelectedItem() != null) {
            String rutaSeleccionada = origenSeleccionado + jcbDestino.getSelectedItem();
            for(Ruta r:rutas){
                String ruta = r.getOrigen().toLowerCase() + " Dest: " + r.getDestino() + ", Dur.Est: " + r.getDuracionEstimada();
                
                if (ruta.equals(rutaSeleccionada)) {
                    rutaActual= r; 
                    List<Horario> horarios = hData.listaHorarioRutas(rutaActual);
                    for(Horario h:horarios){
                        jcbHorarios.addItem(" Hora lleg: " + h.getHoraLlegada().toString() + " Hora sal: " + h.getHoraSalida());
                    }
                }
            }
        }
        if (rutaActual != null) {
            List<Colectivo> colectivos = crData.obtenerColectivosPorRuta(rutaActual.getIdRuta());
            for(Colectivo c:colectivos){
                if (c.getAsientosOcupados() < c.getCapacidad()) {
                    jcbColectivo.addItem("Matricula: " + c.getMatricula() + "Cant.AsientosLibres: " + (c.getCapacidad()-c.getAsientosOcupados()));
                }
            } 
        }
        // Colectivo seleccionado
        if (jcbColectivo.getSelectedItem() != null) {
            String colectivoSeleccionado = jcbColectivo.getSelectedItem().toString();
            List<Colectivo> listaColectivos = cData.listarColectivos();
            for(Colectivo c:listaColectivos){
                String colectivo = "Matricula: " + c.getMatricula() + "Cant.AsientosLibres: " + (c.getCapacidad()-c.getAsientosOcupados());
                if(colectivo.equals(colectivoSeleccionado)){
                    colectivoActual = c;
                }
            }
        }
        // Horario seleccionado
        if(jcbHorarios.getSelectedItem() != null){
            String horarioSeleccionado = jcbHorarios.getSelectedItem().toString();
            List<Horario> listaHorarios = hData.listaHorarioRutas(rutaActual);
            for(Horario h:listaHorarios){
                String horario = " Hora lleg: " + h.getHoraLlegada().toString() + " Hora sal: " + h.getHoraSalida();
                if (horario.equals(horarioSeleccionado)) {
                    horarioActual = h;
                }
            }
        }
        if (rutaActual != null && horarioActual != null && colectivoActual != null) {
            jcbPasajeros.setEnabled(true);
            refrescarComboBox();
            if(jcbPasajeros.getSelectedItem() != null){
                String pasajeroSeleccionado = jcbPasajeros.getSelectedItem().toString();
                for(Pasajero p:pasajeros){
                    String pasajero = p.getNombre() + "," + p.getApellido() + "," + p.getDni();
                    if (pasajero.equals(pasajeroSeleccionado)) {
                        pasajeroActual = p;
                    }
                }
            }
        }else{
            jcbPasajeros.setEnabled(false);
        }
        
    }//GEN-LAST:event_jtOrigenKeyReleased

    private void jcbPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPasajerosActionPerformed
        if(jcbPasajeros.getSelectedItem() != null){
            String pasajeroSeleccionado = jcbPasajeros.getSelectedItem().toString();
                for(Pasajero p:pasajeros){
                    String pasajero = p.getNombre() + "," + p.getApellido() + "," + p.getDni();
                    if (pasajero.equals(pasajeroSeleccionado)) {
                        pasajeroActual = p;
                    }
            }
        }
    }//GEN-LAST:event_jcbPasajerosActionPerformed

    private void jdFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdFechaPropertyChange
        jbFechaValida.setVisible(false);
    }//GEN-LAST:event_jdFechaPropertyChange
    
    public void refrescarComboBox(){
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jbColectivoValido;
    private javax.swing.JButton jbComprar;
    private javax.swing.JLabel jbFechaValida;
    private javax.swing.JLabel jbRutaValida;
    private javax.swing.JComboBox<String> jcbColectivo;
    private javax.swing.JComboBox<String> jcbDestino;
    private javax.swing.JComboBox<String> jcbHorarios;
    private javax.swing.JComboBox<String> jcbPasajeros;
    private com.toedter.calendar.JDateChooser jdFecha;
    private javax.swing.JTextField jtOrigen;
    // End of variables declaration//GEN-END:variables
}
