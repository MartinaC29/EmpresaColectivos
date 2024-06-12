/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author pablo
 */
public class ColectivoRuta {
    private int idColectivoRuta;
    private Colectivo colectivo;
    private Ruta ruta;

    public ColectivoRuta() {
    }

    public ColectivoRuta(Colectivo colectivo, Ruta ruta) {
        this.colectivo = colectivo;
        this.ruta = ruta;
    }

    public ColectivoRuta(int idColectivoRuta, Colectivo colectivo, Ruta ruta) {
        this.idColectivoRuta = idColectivoRuta;
        this.colectivo = colectivo;
        this.ruta = ruta;
    }

    public int getIdColectivoRuta() {
        return idColectivoRuta;
    }

    public void setIdColectivoRuta(int idColectivoRuta) {
        this.idColectivoRuta = idColectivoRuta;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
    
    
    
}
