/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import entidades.Pasaje;
import entidades.Pasajero;
import entidades.Ruta;
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
    RutaData rData = new RutaData();
    PasajerosData pasData = new PasajerosData();
    ColectivoData colData = new ColectivoData();
    
    public PasajeData(){
        con = Conexion.getConexion();
    }
    
    public void guardarPasaje(Pasaje pasaje){
        String sql = " INSERT INTO pasaje(idPasajero, idColectivo, idruta, fechaViaje, horaViaje, asiento, precio) " +
                    " VALUES (?,?,?,?,?,?,?) ";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
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
           ps.setInt(1, pasaje.getPasajero().getIdPasajero());
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
    
    public Pasaje buscarPasaje(int id){
        Pasaje pasaje = null;

       
        try{
            String sql = " SELECT idPasajero, idColectivo, idruta, fechaViaje, horaViaje, asiento, precio " +
                    " FROM pasaje WHERE idPasaje = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                pasaje = new Pasaje();
                pasaje.setPasajero(pasData.buscarPasajero(rs.getInt("idPasajero")));
                pasaje.setColectivo(colData.buscarColectivo(rs.getInt("idColectivo")));
                pasaje.setRuta(rData.buscarRuta(rs.getInt("idRuta")));
                pasaje.setFechaViaje(rs.getDate("fechaViaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("horaViaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));              
            }else{
                JOptionPane.showMessageDialog(null, "No existe el pasaje con id: " + id);
            }  
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasaje");
        } 
        return pasaje;    
    }
       
    public void eliminarPasaje(int id){
        try{
            String sql = " DELETE FROM pasaje WHERE idPasaje = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
             
            int filas = ps.executeUpdate();
            if (filas == 1) {
                System.out.println("Se ha eliminado el pasaje");
            }
             
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla pasaje");
        }      
    }
      
    public List<Pasaje> listarPasajes(){
        List<Pasaje> pasajes = new ArrayList<>();
        String sql = "SELECT * FROM pasajes";  
        RutaData rutaData = new RutaData();
        PasajerosData pasData = new PasajerosData();
        ColectivoData colData = new ColectivoData();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("idPasaje"));
                pasaje.setPasajero(pasData.buscarPasajero(rs.getInt("idPasajero")));
                pasaje.setColectivo(colData.buscarColectivo(rs.getInt("idColectivo")));
                pasaje.setRuta(rutaData.buscarRuta(rs.getInt("idRuta")));
                pasaje.setFechaViaje(rs.getDate("fechaViaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("horaViaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));
                pasajes.add(pasaje);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pasajes");
        }
        return pasajes;
    }
    
    public List<Pasaje> listarPorRuta(Ruta ruta){
       List<Pasaje> pasajes = new ArrayList<>();
        String sql = "SELECT * FROM pasajes WHERE idRuta = ?";  
        RutaData rutaData = new RutaData();
        PasajerosData pasData = new PasajerosData();
        ColectivoData colData = new ColectivoData();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getIdRuta());
            ResultSet rs = ps.executeQuery();
                    
            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("idPasaje"));
                pasaje.setPasajero(pasData.buscarPasajero(rs.getInt("idPasajero")));
                pasaje.setColectivo(colData.buscarColectivo(rs.getInt("idColectivo")));
                pasaje.setRuta(rutaData.buscarRuta(rs.getInt("idRuta")));
                pasaje.setFechaViaje(rs.getDate("fechaViaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("horaViaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));
                pasajes.add(pasaje);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pasajes");
        }
        return pasajes; 
    }
    
    public List<Pasaje> listarPorHorario(Time hora){
        List<Pasaje> pasajes = new ArrayList<>();
        String sql = "SELECT * FROM pasajes WHERE horaViaje = ?";  
        RutaData rutaData = new RutaData();
        PasajerosData pasData = new PasajerosData();
        ColectivoData colData = new ColectivoData();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTime(1, hora);
            ResultSet rs = ps.executeQuery();
                    
            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("idPasaje"));
                pasaje.setPasajero(pasData.buscarPasajero(rs.getInt("idPasajero")));
                pasaje.setColectivo(colData.buscarColectivo(rs.getInt("idColectivo")));
                pasaje.setRuta(rutaData.buscarRuta(rs.getInt("idRuta")));
                pasaje.setFechaViaje(rs.getDate("fechaViaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("horaViaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));
                pasajes.add(pasaje);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pasajes");
        }
        return pasajes;
    }
    
    public List<Pasaje> listarPorPasajero(Pasajero pasajero){
        List<Pasaje> pasajes = new ArrayList<>();
        String sql = "SELECT * FROM pasajes WHERE idPasajero = ?";  
        RutaData rutaData = new RutaData();
        PasajerosData pasData = new PasajerosData();
        ColectivoData colData = new ColectivoData();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pasajero.getIdPasajero());
            ResultSet rs = ps.executeQuery();
                    
            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("idPasaje"));
                pasaje.setPasajero(pasData.buscarPasajero(rs.getInt("idPasajero")));
                pasaje.setColectivo(colData.buscarColectivo(rs.getInt("idColectivo")));
                pasaje.setRuta(rutaData.buscarRuta(rs.getInt("idRuta")));
                pasaje.setFechaViaje(rs.getDate("fechaViaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("horaViaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));
                pasajes.add(pasaje);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pasajes");
        }
        return pasajes;
    }
    
}
