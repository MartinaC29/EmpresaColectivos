/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import entidades.Horario;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import accesodatos.RutaData;
import entidades.Ruta;

/**
 *
 * @author pablo
 */
public class HorarioData {
    private Connection con = null;
    RutaData rData = new RutaData();
    
    public HorarioData() {
        this.con = Conexion.getConexion();
    }
    
    public void guardarhorario(Horario horario){
        String sql = "INSERT INTO horario(idRuta,horaSalida,horaLlegada,estado) "
                + "VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,horario.getRuta().getIdRuta());
            ps.setTime(2,Time.valueOf(horario.getHoraSalida()));
            ps.setTime(3,Time.valueOf(horario.getHoraLlegada()));
            ps.setBoolean(4, horario.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "horario guardado");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla horario, error: " + ex);
        }
    }
    
    public Horario buscarhorario(int id){
        Horario horario = null;
        
        String sql = "SELECT `idRuta`, `horaSalida`, `horaLlegada` FROM `horario` WHERE idHorario = ? AND estado = 1";
        
        try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           
           ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                horario = new Horario();
                horario.setIdHorario(id);
                horario.setRuta(rData.buscarRuta(rs.getInt("idRuta")));
                horario.setHoraSalida(rs.getTime("horaSalida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("horaLlegada").toLocalTime());
                horario.setEstado(true);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla horario, error: " + ex);
        }
        return horario;
    }
    
    public void eliminarhorario(int id){
        String sql = "UPDATE horario SET estado = 0 WHERE idhorario = ? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas == 1) {
                JOptionPane.showMessageDialog(null,"Se ha eliminado el horario");
            }
            
        }catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla horario, error: " + ex);
        }
    }
    
    public void actualizarhorario(Horario horario){
        String sql = "UPDATE horario SET idRuta= ?,horaSalida= ?,horaLlegada= ? "
                    + "WHERE idhorario = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1,horario.getRuta().getIdRuta());
            ps.setTime(2,Time.valueOf(horario.getHoraSalida()));
            ps.setTime(3,Time.valueOf(horario.getHoraLlegada()));
            ps.setInt(4,horario.getIdHorario());
            
            int fila = ps.executeUpdate();
                    
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "horario modificado");
            }
        }catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla horario, error: " + ex);
        }
    }
    
    public List<Horario> listaHorarioRutas(Ruta ruta){
        List<Horario> horarios = new ArrayList<>();
        
        try{
            String sql = " SELECT * FROM horario INNER JOIN ruta ON horario.idRuta = ruta.idRuta " + 
                    " WHERE ruta.origen = ? AND ruta.destino = ? AND horario.estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Horario horario = new Horario();
                horario.setIdHorario(rs.getInt("idHorario"));
                horario.setRuta(ruta);
                horario.setHoraSalida(rs.getTime("horaSalida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("horaLlegada").toLocalTime());
                horario.setEstado(rs.getBoolean("estado"));
                horarios.add(horario);             
            }
            rs.close();
            ps.close();
            
        }catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla horario, error: " + ex);
        }
        return horarios;   
    }
    
    public List<Horario> listaHorarioSalida(LocalTime horaSalida){
        List<Horario> horarios = new ArrayList<>();
        
        try{
            String sql = " SELECT * FROM horario WHERE horaSalida = ? AND horario.estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTime(1, Time.valueOf(horaSalida));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Horario horario = new Horario();
                horario.setIdHorario(rs.getInt("idHorario"));
                horario.setRuta(rData.buscarRuta(rs.getInt("idRuta")));
                horario.setHoraSalida(rs.getTime("horaSalida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("horaLlegada").toLocalTime());
                horario.setEstado(rs.getBoolean("estado"));
                horarios.add(horario); 
            }
            rs.close();
            ps.close();
            
        }catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla horario, error: " + ex);
        }
        return horarios; 
    }
    
    public List<Horario> listaHorarios(){
        
        List<Horario> horarios = new ArrayList<>();
        try{
            String sql = " SELECT * FROM horario WHERE horario.estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Horario horario = new Horario();
                horario.setIdHorario(rs.getInt("idHorario"));
                horario.setRuta(rData.buscarRuta(rs.getInt("idRuta")));
                horario.setHoraSalida(rs.getTime("horaSalida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("horaLlegada").toLocalTime());
                horario.setEstado(rs.getBoolean("estado"));
                horarios.add(horario);             
            }
            rs.close();
            ps.close();
            
        }catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla horario, error: " + ex);
        }
        return horarios;
    }
    
    
    
    
    
    
}
