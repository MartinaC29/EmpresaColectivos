/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empresacolectivos;

import accesodatos.ColectivoData;
import accesodatos.HorarioData;
import accesodatos.PasajerosData;
import accesodatos.RutaData;
import entidades.Colectivo;
import entidades.Horario;
import entidades.Pasajero;
import entidades.Ruta;
import java.time.LocalTime;

/**
 *
 * @author pablo
 */
public class EmpresaColectivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Pruebas CRUD
        ColectivoData coleData = new ColectivoData();
        RutaData rutaData = new RutaData();
        HorarioData horaData = new HorarioData();
        PasajerosData pasajeroData = new PasajerosData();
        
        Colectivo cole1 = new Colectivo("12","Volvo","4",50,true);
        Colectivo cole2 = new Colectivo("13","Mercedes","X12",45,true);
        
        Ruta ruta1 = new Ruta(1,"Buenos Aires","San Luis",LocalTime.of(12,0),true);
        Ruta ruta2 = new Ruta(2,"Misiones","Corrientes",LocalTime.of(4, 0),true);
        
        Horario hora1 = new Horario(ruta1,LocalTime.of(6,0),LocalTime.of(18,0),true);
        Horario hora2 = new Horario(ruta2,LocalTime.of(10,30),LocalTime.of(14,30),true);
        
        Pasajero pasajero1 = new Pasajero("Agustina","Gonzalez",111,"abc@gmail.com",135,true);
        Pasajero pasajero2 = new Pasajero("Viviana","Estrada",222,"erd@gmail.com",246,true);
        
//        coleData.guardarColectivo(cole1);
//        coleData.guardarColectivo(cole2);

//        rutaData.guardarRuta(ruta1);
//        rutaData.guardarRuta(ruta2);

//        horaData.guardarhorario(hora1);
//        horaData.guardarhorario(hora2);
        
        pasajeroData.guardarPasajero(pasajero1);
        pasajeroData.guardarPasajero(pasajero2);
        
    }
    
}
