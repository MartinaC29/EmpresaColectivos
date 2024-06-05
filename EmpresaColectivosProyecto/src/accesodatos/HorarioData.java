/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import entidades.Horario;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Time;

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
}
