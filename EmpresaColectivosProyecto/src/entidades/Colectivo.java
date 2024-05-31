/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author pablo
 */
public class Colectivo {
    private int idColectivo;
    private String matricula;
    private String marca;
    private String modelo;
    private int capacidad;
    private boolean estado;
    
    public Colectivo() {
    }

    public Colectivo(int idColectivo, String matricula, String marca, String modelo, int capacidad, boolean estado) {
        this.idColectivo = idColectivo;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Colectivo(String matricula, String marca, String modelo, int capacidad, boolean estado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.estado = estado;
    } 
    
    public int getIdColectivo() {
        return idColectivo;
    }

    public void setIdColectivo(int idColectivo) {
        this.idColectivo = idColectivo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String toString() {
        return "Colectivo{" + "idColectivo=" + idColectivo + ", matricula=" + matricula + ", capacidad=" + capacidad + '}';
    }
    
}
