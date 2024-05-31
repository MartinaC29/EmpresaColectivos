/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import entidades.Colectivo;
import java.sql.*;

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
            ps.setString(1,colectivo.getMarca());
            
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla colectivo, error: " + ex);
        }
    }
    
    public void buscarColectivo(){
        
    }
    
    public void eliminarColectivo(){
        
    }
    
    public void actualizarColectivo(){
        
    }
}

