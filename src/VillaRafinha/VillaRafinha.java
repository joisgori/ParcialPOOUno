/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josue
 */
public class VillaRafinha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorPisosHabitaciones gestor = new GestorPisosHabitaciones();
        GestorReservaciones gestorReserv = new GestorReservaciones();
        LocalDate fecha1 = LocalDate.of(2018, 03, 15);
        LocalDate fecha2 = LocalDate.of(2018, 03, 20);
        LocalDate fecha3 = LocalDate.of(2018, 03, 16);
        LocalDate fecha4 = LocalDate.of(2018, 03, 17);
        LocalDate fecha5 = LocalDate.of(2018, 03, 23);
        LocalDate fecha6 = LocalDate.of(2018, 03, 25);
        
        
        try {
            gestor.deshabilitarPiso("A");
            Hospedaje hos1 = new Hospedaje(fecha1,fecha2, Tipo.DOBLE);
            Hospedaje hos2 = new Hospedaje(fecha3,fecha4, Tipo.DOBLE);
            Hospedaje hos3 = new Hospedaje(fecha5,fecha6, Tipo.SENCILLA);
            Hospedaje hos4 = new Hospedaje(fecha5,fecha6, Tipo.DOBLE);
            Huesped huesped1= new Huesped("Raul");
            Huesped huesped2= new Huesped("Jorge");
            Huesped huesped3= new Huesped("Daniel");
            //System.out.println(hos1.seIntercecta(hos2));
            //System.out.println(hos1.contiene(hos2));
            Reservacion reservacion1 = new Reservacion(hos1,huesped1);
            Reservacion reservacion2 = new Reservacion(hos2,huesped2);
            Reservacion reservacion3 = new Reservacion(hos3,huesped3);
            //System.out.println(reservacion1.toString());
            //System.out.println(gestorReserv.getReservacionesDisp(hos1, gestor.calcularNumHabitacionesHabilitadas()));
            gestorReserv.agregarReservacion(reservacion1);
            System.out.println(gestorReserv.getReservacionesDisp(hos2, gestor.calcularNumHabitacionesHabilitadas()));            
            //gestorReserv.agregarReservacion(reservacion2);
            System.out.println(gestorReserv.getReservacionesDisp(hos3, gestor.calcularNumHabitacionesHabilitadas()));            
            gestorReserv.agregarReservacion(reservacion3);
            //System.out.println(gestorReserv.getReservacionesDisp(hos4, gestor.calcularNumHabitacionesHabilitadas()));
            gestorReserv.verReservaciones();
            
            Habitacion hab= new Habitacion(Tipo.DOBLE, "A", 9,"A9", (float) 5.0,"bla bla",true);
            hab.agregarHospedaje(hos3);
        
            //System.out.println(gestor.verificarDisp(hab, hos3));
        
        } catch (Exception ex) {
            Logger.getLogger(VillaRafinha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println(gestor.calcularNumHabitacionesHabilitadas());
        try {
            gestor.deshabilitarPiso("A");
        } catch (Exception ex) {
            Logger.getLogger(VillaRafinha.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(gestor.calcularNumHabitacionesHabilitadas());
    
        
    }
    
    
}
