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
import java.util.List;

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
        
        Colectivo cole1 = new Colectivo(1,"11","Volvo","4",50,true);
        Colectivo cole2 = new Colectivo(2,"13","Mercedes","X12",45,true);
        
        Ruta ruta1 = new Ruta(1,"Buenos Aires","San Luis, capital",LocalTime.of(12,0),true);
        Ruta ruta2 = new Ruta(2,"Misiones","Corrientes",LocalTime.of(4, 0),true);
        
        Horario hora1 = new Horario(1,ruta1,LocalTime.of(6,0),LocalTime.of(18,10),true);
        Horario hora2 = new Horario(2,ruta2,LocalTime.of(10,30),LocalTime.of(14,30),true);
        
        Pasajero pasajero1 = new Pasajero(1,"Agustin","Gonzalez",111,"abc@gmail.com",135,true);
        Pasajero pasajero2 = new Pasajero(2,"Viviana","Estrada",222,"erd@gmail.com",246,true);
        
//        -- Guardados

//        coleData.guardarColectivo(cole1);
//        coleData.guardarColectivo(cole2);

//        rutaData.guardarRuta(ruta1);
//        rutaData.guardarRuta(ruta2);

//        horaData.guardarhorario(hora1);
//        horaData.guardarhorario(hora2);
        
//        pasajeroData.guardarPasajero(pasajero1);
//        pasajeroData.guardarPasajero(pasajero2);

//        -- Busquedas

//        System.out.println(coleData.buscarColectivo(1).toString());
//        System.out.println(rutaData.buscarRuta(1).toString());
//        System.out.println(horaData.buscarhorario(1));
//        System.out.println(pasajeroData.buscarPasajero(1));


//        -- Eliminaciones

//        coleData.eliminarColectivo(1);
//        rutaData.eliminarRuta(1);
//        horaData.eliminarhorario(1);
//        pasajeroData.eliminarPasajero(1);

//        -- Actualizaciones

//        coleData.actualizarColectivo(cole1);
//        rutaData.actualizarRuta(ruta1);
//        horaData.actualizarhorario(hora1);
//        pasajeroData.actualizarPasajero(pasajero1);

//        -- Listar
//        List<Ruta> rutas = rutaData.listaRutasDispo();
//        for (Ruta r: rutas) {
//            System.out.println(r.toString());
//        }
//        List<Pasajero> pasajeros = pasajeroData.listarPasajeros();
//        for (Pasajero p: pasajeros){
//            System.out.println(p.toString());
//        }
//        List<Pasajero> pasajerosNombre = pasajeroData.listarPorNombre("Agustina");
//        for(Pasajero p:pasajerosNombre){
//            System.out.println(p.toString());
//        }
        List<Ruta> rutasDestino = rutaData.listaRutasDestino("Corrientes");
        for(Ruta r: rutasDestino){
            System.out.println(r.toString());
        }
    }
    
}
