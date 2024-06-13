/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalTime;

/**
 *
 * @author pablo
 */
public class Ruta {
    private int idRuta;
    private String origen;
    private String destino;
    private LocalTime duracionEstimada;
    private boolean estado;

    public Ruta() {
    }

    public Ruta(int idRuta, String origen, String destino, LocalTime duracionEstimada, boolean estado) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.duracionEstimada = duracionEstimada;
        this.estado = estado;
    }

    public Ruta(String origen, String destino, LocalTime duracionEstimada, boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.duracionEstimada = duracionEstimada;
        this.estado = estado;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(LocalTime duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "origen=" + origen + ", destino=" + destino + ", duracionEstimada=" + duracionEstimada ;
    }
    
    
}
