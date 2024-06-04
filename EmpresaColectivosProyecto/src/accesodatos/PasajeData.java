/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import entidades.Pasaje;
import entidades.Ruta;
import entidades.Pasajero;
import entidades.Colectivo;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author pablo
 */
public class PasajeData {
    private Connection con = null;
    
    public PasajeData(){
        con = Conexion.getConexion();
    }
    
    public void guardarPasaje(Pasaje pasaje){
        String sql = " INSERT INTO pasaje(idPasajero, idColectivo, idruta, fechaViaje, horaViaje, asiento, precio) " +
                    " VALUES (?,?,?,?,?,?,?) ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pasaje.getPasajero().getIdPasejero());
            ps.setInt(2, pasaje.getColectivo().getIdColectivo());
            ps.setInt(3, pasaje.getRuta().getIdRuta());
            ps.setDate(4, Date.valueOf(pasaje.getFechaViaje()));
            ps.setTime(5, Time.valueOf(pasaje.getHoraViaje()));
            ps.setInt(6, pasaje.getAsiento());
            ps.setDouble(7, pasaje.getPrecio());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                pasaje.setIdPasaje(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pasaje guardado");
            }
            ps.close();
   
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasaje");
        }   
    }
    
    
    public void actualizarPasaje(Pasaje pasaje){
        try{
           String sql = " UPDATE pasaje SET idPasajero = ?, idColectivo = ?, idruta = ?,fechaViaje = ?, horaViaje = ?, asiento = ?, precio = ? " +
                " WHERE idPasaje = ? "; 
           
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, pasaje.getPasajero().getIdPasejero());
           ps.setInt(2, pasaje.getColectivo().getIdColectivo());
           ps.setInt(3, pasaje.getRuta().getIdRuta());
           ps.setDate(4, Date.valueOf(pasaje.getFechaViaje()));
           ps.setTime(5, Time.valueOf(pasaje.getHoraViaje()));
           ps.setInt(6, pasaje.getAsiento());
           ps.setDouble(7, pasaje.getPrecio());
           
           int fila = ps.executeUpdate();
             
             if (fila ==1) {
                JOptionPane.showMessageDialog(null, "Pasaje modificado");
             }
           
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasaje");
        }     
    }
    
    public Pasaje buscarPasaje(){
        
    }
    
    
    
    
    public void eliminarPasaje(int id){
        
    }
    
    
    
    
    
    
}
