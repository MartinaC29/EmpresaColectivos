/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author pablo
 */
public class Pasajero {
    private int idPasajero;
    private String nombre;
    private String apellido;
    private int dni;
    private String correo;
    private int tel;
    private boolean estado;

    public Pasajero() {
    }

    public Pasajero(String nombre, String apellido, int dni, String correo, int tel, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.tel = tel;
        this.estado = estado;
    }

    public Pasajero(int idPasajero, String nombre, String apellido, int dni, String correo, int tel, boolean estado) {
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.tel = tel;
        this.estado = estado;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni;
    }
    
    
    
    
    
    
    
}
