/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;
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
public class RutaData {
    private Connection con = null;
    
    public RutaData(){
        con = Conexion.getConexion();
    }
    
    public void guardarRuta(Ruta ruta){
        String sql = " INSERT INTO ruta(origen, destino, duracionEstimada, estado) " +
                " VALUES (?,?,?,?) ";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2,ruta.getDestino());
            ps.setTime(3, Time.valueOf(ruta.getDuracionEstimada()));
            ps.setBoolean(4, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                ruta.setIdRuta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ruta guardada");
            }
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla ruta");
        }   
    }
    
    public void actualizarRuta(Ruta ruta){
        try{
             String sql = "UPDATE ruta SET origen = ?, destino = ?, duracionEstimada = ? " +
                " WHERE idRuta = ? ";
             
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, ruta.getOrigen());
             ps.setString(2,ruta.getDestino());
             ps.setTime(3, Time.valueOf(ruta.getDuracionEstimada()));
             ps.setInt(4, ruta.getIdRuta());
             
             int fila = ps.executeUpdate();
             
             if (fila ==1) {
                JOptionPane.showMessageDialog(null, "Ruta modificada");
             }
         
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla ruta");
        }     
    }
    
    public Ruta buscarRuta(int id){
        Ruta ruta = null;
        try{
            String sql = " SELECT origen, destino, duracionEstimada FROM ruta " +
                    " WHERE idRuta = ? AND estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                ruta = new Ruta();
                ruta.setIdRuta(id);
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracionEstimada(rs.getTime("duracionEstimada").toLocalTime());
                ruta.setEstado(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe la ruta con id: " + id);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla ruta");
        }
        return ruta;
    }
    
    public void eliminarRuta(int id){
        try{
            String sql = " UPDATE ruta SET estado = 0 WHERE idRuta = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas == 1) {
                JOptionPane.showMessageDialog(null,"Se ha eliminado la ruta");
            }
                    
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla ruta");
        }
    }
    
    public List<Ruta> listaRutasDispo(){
        List<Ruta> rutas = new ArrayList<>();
        
        try{
            String sql = " SELECT * FROM ruta WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("idRuta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracionEstimada(rs.getTime("duracionEstimada").toLocalTime());
                ruta.setEstado(rs.getBoolean("estado"));
                rutas.add(ruta);
            }
            rs.close();
            ps.close();
            
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla ruta");
        }
        return rutas;
    }
    
    public List<Ruta> listaRutasOrigen(String origen){
        List<Ruta> rutas = new ArrayList<>();
        
        try{
            String sql = " SELECT * FROM ruta WHERE origen = ? AND estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("idRuta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracionEstimada(rs.getTime("duracionEstimada").toLocalTime());
                ruta.setEstado(rs.getBoolean("estado"));
                rutas.add(ruta);
            }
            rs.close();
            ps.close();
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla ruta");
        }
        return rutas;
    }
    
    public List<Ruta> listaRutasDestino(String destino){
        List<Ruta> rutas = new ArrayList<>();
        
        try{
            String sql = " SELECT * FROM ruta WHERE destino = ? AND estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("idRuta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracionEstimada(rs.getTime("duracionEstimada").toLocalTime());
                ruta.setEstado(rs.getBoolean("estado"));
                rutas.add(ruta);
            }
            rs.close();
            ps.close();
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla ruta");
        }
        return rutas;
    }
    
    
    
    
    
    
    
    
}
