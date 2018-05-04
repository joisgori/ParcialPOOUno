/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.time.LocalDate;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author josue
 */
public class VillaRafinha {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        
        Menu menu=Menu.getInstance();
        menu.mostrar();
        
        /* Estan son las pruebas del codigo que tenemos trabajando ya
        Inicializando gestores
        */
        /*
        GestorPisosHabitaciones gestorPisos = new GestorPisosHabitaciones();
        GestorReservaciones gestorReserv = new GestorReservaciones();
        GestorHuespedes gestorHuespedes = new GestorHuespedes();*/
        
        //Deshabilitando un piso y probando el metodo deshabilitar piso y getDisponibilidad
        //System.out.println(gestorPisos.calcularNumHabitacionesHabilitadas());
        //gestorPisos.deshabilitarPiso("A");
        //System.out.println(gestorPisos.calcularNumHabitacionesHabilitadas());
        

        //Creando fechas para testeo
        /*
        LocalDate fecha1 = LocalDate.of(2018, 05, 3);
        LocalDate fecha2 = LocalDate.of(2018, 05, 8);
        LocalDate fecha3 = LocalDate.of(2018, 05, 3);
        LocalDate fecha4 = LocalDate.of(2018, 05, 5);
        LocalDate fecha5 = LocalDate.of(2018, 05, 8);
        LocalDate fecha6 = LocalDate.of(2018, 05, 10);
        LocalDate fecha7 = LocalDate.of(2018, 06, 16);
        LocalDate fecha8 = LocalDate.of(2018, 06, 20);

        //Creando hospedajes para testeo
        Hospedaje hos1 = new Hospedaje(fecha1, fecha2, Tipo.DOBLE);
        Hospedaje hos2 = new Hospedaje(fecha3, fecha4, Tipo.DOBLE);
        Hospedaje hos3 = new Hospedaje(fecha5, fecha6, Tipo.DOBLE);
        Hospedaje hos4 = new Hospedaje(fecha5, fecha6, Tipo.DOBLE);
        Hospedaje hos5 = new Hospedaje(fecha7, fecha8, Tipo.DOBLE);
        
        //Creando Huespedes para testeo
        Huesped huesped1 = new Huesped("Raul", "asl");
        Huesped huesped2 = new Huesped("Jorge", "asu");
        Huesped huesped3 = new Huesped("Daniel", "asd");
        
        //Creando Reservaciones para testeo
        Reservacion reservacion1 = new Reservacion(hos1, huesped1);
        Reservacion reservacion2 = new Reservacion(hos2, huesped2);
        Reservacion reservacion3 = new Reservacion(hos1, huesped3);
        Reservacion reservacion4 = new Reservacion(hos2, huesped3);
        Reservacion reservacion5 = new Reservacion(hos1, huesped3);
        Reservacion reservacion6 = new Reservacion(hos2, huesped3);
        Reservacion reservacion7 = new Reservacion(hos1, huesped3);
        Reservacion reservacion8 = new Reservacion(hos2, huesped3);
        Reservacion reservacion9 = new Reservacion(hos1, huesped3);
        Reservacion reservacion10 = new Reservacion(hos2, huesped3);
        Reservacion reservacion11 = new Reservacion(hos5, huesped3);
        Reservacion reservacion12 = new Reservacion(hos1, huesped3);
        
        System.out.println(gestorPisos.calcularNumHabitacionesHabilitadas(true, hos1));
        gestorPisos.getPisos().get(5).getHabitaciones()[9].agregarHospedaje(hos2);
        System.out.println(gestorPisos.calcularNumHabitacionesHabilitadas(true, hos3));
        
       
 /*
        //Probando la disponibilidad cuando el hotel no tiene reservaciones
        System.out.println(gestorReserv.getReservacionesDisp(hos1, gestorPisos.calcularNumHabitacionesHabilitadas()));
        
        //Agregando una reservacion a el gestor
        gestorReserv.agregarReservacion(reservacion1);
        
        //Verificando disponibilidad cuando una reservacion
        System.out.println(gestorReserv.getReservacionesDisp(hos2, gestorPisos.calcularNumHabitacionesHabilitadas()));
        
        //Agregando segunda reservacion
        gestorReserv.agregarReservacion(reservacion2);
        
        //Verificando disp cuando hay n reservaciones
        System.out.println(gestorReserv.getReservacionesDisp(hos3, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion3);
        System.out.println(gestorReserv.getReservacionesDisp(hos4, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion4);
        System.out.println(gestorReserv.getReservacionesDisp(hos5, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion5);
        
        //Viendo reservaciones de los siguientes 7 dias
        gestorReserv.verReservaciones();
*/
        
/*SIMULANDO UN HOTEL LLENO DESHABILITANDO 5 PISOS PARA TRABAJAR CON 10 HABITACIONES
    Aun necesita probarse bien, he hecho pruebas basicas y parece funcionar, creo que si hay errores que quitarle aun pruebenlo 
 
        gestorPisos.deshabilitarPiso("B");
        gestorPisos.deshabilitarPiso("C");
        gestorPisos.deshabilitarPiso("D");
        gestorPisos.deshabilitarPiso("E");
        gestorPisos.deshabilitarPiso("F");
        System.out.println(gestorPisos.calcularNumHabitacionesHabilitadas());
        
        System.out.println(gestorReserv.getReservacionesDisp(hos1, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion1);
        System.out.println(gestorReserv.getReservacionesDisp(hos2, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion2);
        System.out.println(gestorReserv.getReservacionesDisp(hos1, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion3);
        System.out.println(gestorReserv.getReservacionesDisp(hos2, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion4);
        System.out.println(gestorReserv.getReservacionesDisp(hos1, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion5);
        System.out.println(gestorReserv.getReservacionesDisp(hos2, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion6);
        System.out.println(gestorReserv.getReservacionesDisp(hos1, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion7);
        System.out.println(gestorReserv.getReservacionesDisp(hos2, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion8);
        System.out.println(gestorReserv.getReservacionesDisp(hos1, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion9);
        System.out.println(gestorReserv.getReservacionesDisp(hos2, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion10);
        System.out.println(gestorReserv.getReservacionesDisp(hos5, gestorPisos.calcularNumHabitacionesHabilitadas()));
        gestorReserv.agregarReservacion(reservacion11);
        System.out.println(gestorReserv.getReservacionesDisp(hos2, gestorPisos.calcularNumHabitacionesHabilitadas()));
        //gestorReserv.agregarReservacion(reservacion12);
        
        
        */
        
        
        //ESTO ES DE RAUL 
        
        //Habitacion hab = new Habitacion(Tipo.DOBLE, "A", 9, "A9", (float) 5.0, "bla bla", true);

        //System.out.println(gestor.verificarDisp(hab, hos3));
        //System.out.println(gestor.calcularNumHabitacionesHabilitadas());
        //System.out.println(gestor.calcularNumHabitacionesHabilitadas());
        
        //gestorHuespedes.agregarHuesped(huesped2);
        //gestorHuespedes.agregarHuesped(huesped2);
        //gestorHuespedes.agregarHuesped(huesped1);
        //gestorHuespedes.agregarHuesped(huesped3);
        //gestorHuespedes.verHuespedes();
    
    
    }
    
    
    
}
