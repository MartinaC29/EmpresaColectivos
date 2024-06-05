/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import entidades.Colectivo;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ColectivoData {
    private Connection con = null;

    public ColectivoData() {
        this.con = Conexion.getConexion();
    }
    
    public void guardarColectivo(Colectivo colectivo){
        String sql = "INSERT INTO colectivo(matricula,marca,modelo,capacidad,estado) "
                + "VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,colectivo.getMatricula());
            ps.setString(2,colectivo.getMarca());
            ps.setString(3,colectivo.getModelo());
            ps.setInt(4,colectivo.getCapacidad());
            ps.setBoolean(5, colectivo.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "Colectivo guardado");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla colectivo, error: " + ex);
        }
    }
    
    public Colectivo buscarColectivo(int id){
        Colectivo colectivo = null;
        
        String sql = "SELECT `matricula`, `marca`, `modelo`, `capacidad` FROM `colectivo` WHERE idColectivo = ? AND estado = 1";
        
        try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           
           ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                colectivo = new Colectivo();
                colectivo.setIdColectivo(id);
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
                colectivo.setEstado(true);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla colectivo, error: " + ex);
        }
        return colectivo;
    }
    
    public void eliminarColectivo(int id){
        String sql = "UPDATE colectivo SET estado = 0 WHERE idColectivo = ? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas == 1) {
                JOptionPane.showMessageDialog(null,"Se ha eliminado el colectivo");
            }
            
        }catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla colectivo, error: " + ex);
        }
    }
    
    public void actualizarColectivo(Colectivo colectivo){
        String sql = "UPDATE colectivo SET matricula= ?,marca= ?,modelo= ?,capacidad= ? "
                    + "WHERE idColectivo = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1,colectivo.getMatricula());
            ps.setString(2,colectivo.getMarca());
            ps.setString(3,colectivo.getModelo());
            ps.setInt(4,colectivo.getCapacidad());
            ps.setInt(5,colectivo.getIdColectivo());
            
            int fila = ps.executeUpdate();
                    
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Colectivo modificado");
            }
        }catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla colectivo, error: " + ex);
        }
    }
}

