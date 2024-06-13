/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import java.sql.Connection;
import entidades.Pasajero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author pablo
 */
public class PasajerosData {
    private Connection con = null;
    
    public PasajerosData(){
        con = Conexion.getConexion();
    }
    
    public void guardarPasajero(Pasajero pasajero){
        String sql = " INSERT INTO pasajeros (nombre, apellido, dni, correo, telefono, estado) " +
                " VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2,pasajero.getApellido());
            ps.setInt(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setInt(5, pasajero.getTel());
            ps.setBoolean(6, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                JOptionPane.showMessageDialog(null, "Pasajero guardado");
            }
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasajeros "+ex);
        }   
    }
    
    public void actualizarPasajero(Pasajero pasajero){
        try{
             String sql = "UPDATE pasajeros SET nombre = ?, apellido = ?, dni = ?, correo = ?, telefono = ? " +
                " WHERE idPasajero = ? ";
             
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, pasajero.getNombre());
             ps.setString(2,pasajero.getApellido());
             ps.setInt(3, pasajero.getDni());
             ps.setString(4, pasajero.getCorreo());
             ps.setInt(5, pasajero.getTel());

             int fila = ps.executeUpdate();
             
             if (fila ==1) {
                JOptionPane.showMessageDialog(null, "Pasajero modificado");
             }
         
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasajero");
        }     
    }
    
    public Pasajero buscarPasajero(int id){
        Pasajero pasajero = null;
        
        try{
            String sql = " SELECT nombre, apellido, dni, correo, telefono FROM pasajeros " +
                    " WHERE idPasajero = ? ";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                pasajero = new Pasajero();
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getInt("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTel(rs.getInt("telefono"));
                pasajero.setEstado(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe el pasajero con id: " + id);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasajero");
        }  
        return pasajero;
    }
    
    public Pasajero buscarPasajeroDNI(int dni){
        Pasajero pasajero = null;
        
        try{
            String sql = " SELECT * FROM pasajeros " +
                    " WHERE dni = ? AND estado = 1";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("idPasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getInt("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTel(rs.getInt("telefono"));
                pasajero.setEstado(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe el pasajero con dni: " + dni);
            }
            
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasajero");
        }  
        return pasajero;
    }
    
    
    public void eliminarPasajero(int id){
         try{
            String sql = " UPDATE pasajeros SET estado = 0 WHERE idPasajero = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas == 1) {
                JOptionPane.showMessageDialog(null,"Se ha eliminado el pasajero");
            }
                    
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasajeros");
        }
    }
    
    public List<Pasajero> listarPasajeros(){
        List<Pasajero> pasajeros = new ArrayList<>();
        String sql = "SELECT * FROM pasajeros WHERE estado = 1";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("idPasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getInt("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTel(rs.getInt("telefono"));
                pasajero.setEstado(rs.getBoolean("estado"));
                pasajeros.add(pasajero);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasajeros");
        }
        return pasajeros;
    }
    
    public List<Pasajero> listarPorNombre(String nombre){
        List<Pasajero> pasajeros = new ArrayList<>();
        String sql = "SELECT * FROM pasajeros WHERE estado = 1 AND nombre = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("idPasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getInt("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTel(rs.getInt("telefono"));
                pasajero.setEstado(rs.getBoolean("estado"));
                pasajeros.add(pasajero);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasajeros");
        }
        return pasajeros;
    }
    
    public List<Pasajero> listarPorApellido(String apellido){
      List<Pasajero> pasajeros = new ArrayList<>();
        String sql = "SELECT * FROM pasajeros WHERE estado = 1 AND apellido = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, apellido);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("idPasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getInt("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTel(rs.getInt("telefono"));
                pasajero.setEstado(rs.getBoolean("estado"));
                pasajeros.add(pasajero);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasajeros");
        }
        return pasajeros; 
    }
}
