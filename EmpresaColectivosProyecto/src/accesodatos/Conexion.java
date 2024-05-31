/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author pablo
 */
public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "proyecto_transversal1";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    private Conexion() {
        
    }
    
    public static Connection getConexion(){
        if(connection == null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                
            }catch(ClassNotFoundException e){
                System.out.println("No se ha encontrado el driver");
            }catch(SQLException e){
                System.out.println("No se ha podido realizar la conexion");
            }
        }
        return connection;
    }
}
