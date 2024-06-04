/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import entidades.Horario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class HorarioData {
    private Connection con = null;

    public HorarioData() {
        this.con = Conexion.getConexion();
    }
    
    public void guardarhorario(Horario horario){
        String sql = "INSERT INTO horario(idRuta,horaSalida,horaLlegada,estado) "
                + "VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,horario.getRuta().getIdRuta()+"");
            ps.setTime(2,horario.getHoraSalida());
            ps.setTime(3,horario.getModelo());
            ps.setInt(4,horario.getCapacidad());
            ps.setBoolean(5, horario.isEstado());
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
        
        String sql = "SELECT `matricula`, `marca`, `modelo`, `capacidad` FROM `alumno` WHERE idAlumno = ? AND estado = 1";
        
        try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           
           ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                horario.setIdhorario(id);
                horario.setMatricula(rs.getString("matricula"));
                horario.setMarca(rs.getString("marca"));
                horario.setModelo(rs.getString("modelo"));
                horario.setCapacidad(rs.getInt("capacidad"));
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
        String sql = "UPDATE horario SET matricula= ?,marca= ?,modelo= ?,capacidad= ? "
                    + "WHERE idhorario = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1,horario.getMatricula());
            ps.setString(2,horario.getMarca());
            ps.setString(3,horario.getModelo());
            ps.setInt(4,horario.getCapacidad());
            ps.setInt(5,horario.getIdhorario());
            
            int fila = ps.executeUpdate();
                    
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "horario modificado");
            }
        }catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla horario, error: " + ex);
        }
    }
}
