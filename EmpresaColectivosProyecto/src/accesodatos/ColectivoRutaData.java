/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;
import entidades.Colectivo;
import entidades.ColectivoRuta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author pablo
 */
public class ColectivoRutaData {
    private Connection con = null;

    public ColectivoRutaData() {
        con = Conexion.getConexion();
    }
    
    public void guardarColectivoRuta(ColectivoRuta cr){
        String sql = "INSERT INTO colectivoruta(idColectivo, idRuta) "
                + "VALUES (?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cr.getColectivo().getIdColectivo());
            ps.setInt(2, cr.getRuta().getIdRuta());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                cr.setIdColectivoRuta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ha Asignado el colectivo a la ruta");
            }
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
    }
    
    public void eliminarColectivoRuta(int idColectivo, int idRuta){
        String sql = "DELETE FROM `colectivoruta` WHERE idColectivo = ? AND idRuta = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idColectivo);
            ps.setInt(2, idRuta);
            int filas = ps.executeUpdate();
            if (filas == 1) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente el colectivo a la ruta");
            }
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
    }
    
    
    public List<Colectivo> obtenerColectivosPorRuta(int idRuta){
        List<Colectivo> colectivos = new ArrayList<>();
        
        String sql = "SELECT colectivo.* FROM `colectivo` JOIN colectivoRuta "
                + " ON colectivo.idColectivo = colectivoRuta.idColectivo "
                + " WHERE colectivoRuta.idRuta = ? AND colectivo.estado = 1";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRuta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Colectivo col = new Colectivo();
                col.setIdColectivo(rs.getInt("idColectivo"));
                col.setMatricula(rs.getString("matricula"));
                col.setMarca(rs.getString("marca"));
                col.setModelo(rs.getString("modelo"));
                col.setCapacidad(rs.getInt("capacidad"));
                col.setEstado(rs.getBoolean("estado"));
                colectivos.add(col);
            }   
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
        return colectivos;
    }
    
    public List<Colectivo> obtenerColectivosDisponibles(){
        List<Colectivo> colectivos = new ArrayList<>();
        
        String sql = "SELECT colectivo.* FROM colectivo "
                + "LEFT JOIN colectivoruta ON colectivo.idColectivo = colectivoruta.idColectivo "
                + "WHERE colectivoruta.idRuta IS NULL AND colectivo.estado = 1";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Colectivo col = new Colectivo();
                col.setIdColectivo(rs.getInt("idColectivo"));
                col.setMatricula(rs.getString("matricula"));
                col.setMarca(rs.getString("marca"));
                col.setModelo(rs.getString("modelo"));
                col.setCapacidad(rs.getInt("capacidad"));
                col.setEstado(rs.getBoolean("estado"));
                colectivos.add(col);
            }   
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
        return colectivos;
    }
}
