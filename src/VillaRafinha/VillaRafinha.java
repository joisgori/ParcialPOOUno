/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        //Scanner scanner = new Scanner(System.in);
        /*LocalDate fecha1 = LocalDate.of(2018, 05, 6);
        LocalDate fecha2 = LocalDate.of(2018, 05, 10);
        LocalDate fecha3 = LocalDate.of(2018, 05, 7);
        LocalDate fecha4 = LocalDate.of(2018, 05, 11);
        GestorPisosHabitaciones ges = GestorPisosHabitaciones.getInstance();
        Hospedaje hos1 = new Hospedaje(fecha1, fecha2, Tipo.DOBLE,true);
        Habitacion hab = new Habitacion(Tipo.DOBLE, "A", 9, "jaja", (float)80.0,"xd");
        Hospedaje hos2 = new Hospedaje(fecha3, fecha4, Tipo.SENCILLA,false);
        System.out.println(ges.verificarDisp(hab,hos2));*/
        
        Menu menu=Menu.getInstance();
        menu.mostrar();
        //GestorProductos.getInstance();
        //GestorProductos.agregarServicio(GestorProductos.crearServicio());
        //GestorProductos.agregarServicio(GestorProductos.crearServicio());
        //GestorProductos.agregarServicio(GestorProductos.crearServicio());
        //GestorProductos.verServicios();
        //GestorProductos.agregarPaquete(GestorProductos.crearPaquete());
        //GestorProductos.agregarPaquete(GestorProductos.crearPaquete());
        //GestorProductos.verPaquetes();
        //GestorProductos.verPaquetesLista();
        //Servicio servicio1= new Servicio("Piscina", (float) 15.5,"Acceso a piscina semiolimpica bajo techo");
        //Servicio servicio2= new Servicio("Buffet", (float) 12.4,"Desayuno, almuerzo y cena buffet");
        //Servicio servicio3= new Servicio("Bar", (float) 16.7,"Acceso al bar y open bar");
        //GestorProductos.agregarServicio(servicio3);
        //GestorProductos.agregarServicio(servicio2);
        //GestorProductos.agregarServicio(servicio1);
        //String nombreServ= scanner.nextLine();
        //System.out.println(GestorProductos.buscarServicio(nombreServ));
        
        //System.out.println(servicio1.toString());
        //Paquete paquete1= new Paquete("Premium",(float)59.99);
        //paquete1.agregarServicio(servicio1);
        //paquete1.agregarServicio(servicio2);
        //System.out.println(paquete1.toString());
        //paquete1.agregarServicio(servicio3);
        //gestorProductos.agregarPaquete(paquete1);
        //System.out.println(gestorProductos.buscarPaquete("premium"));
        //System.out.println(paquete1.toString());
        //paquete1.quitarServicio(servicio2);
        //System.out.println(paquete1.toString());
        
        
        /* Estan son las pruebas del codigo que tenemos trabajando ya
        Inicializando gestores
        */
        
        /*GestorPisosHabitaciones gestorPisos = GestorPisosHabitaciones.getInstance();
        GestorReservaciones gestorReserv = GestorReservaciones.getInstance();
        GestorHuespedes gestorHuespedes = GestorHuespedes.getInstance();*/
        
        //Deshabilitando un piso y probando el metodo deshabilitar piso y getDisponibilidad
        //System.out.println(gestorPisos.calcularNumHabitacionesHabilitadas());
        //gestorPisos.deshabilitarPiso("A");
        //System.out.println(gestorPisos.calcularNumHabitacionesHabilitadas());
        
        /*
        //Creando fechas para testeo
        
        LocalDate fecha1 = LocalDate.of(2018, 05, 3);
        LocalDate fecha2 = LocalDate.of(2018, 05, 8);
        LocalDate fecha3 = LocalDate.of(2018, 05, 3);
        LocalDate fecha4 = LocalDate.of(2018, 05, 5);
        LocalDate fecha5 = LocalDate.of(2018, 05, 4);
        LocalDate fecha6 = LocalDate.of(2018, 05, 10);
        LocalDate fecha7 = LocalDate.of(2018, 06, 16);
        LocalDate fecha8 = LocalDate.of(2018, 06, 20);

        //Creando hospedajes para testeo
        Hospedaje hos1 = new Hospedaje(fecha1, fecha2, Tipo.DOBLE,true);
        Hospedaje hos2 = new Hospedaje(fecha3, fecha4, Tipo.SENCILLA,false);
        Hospedaje hos3 = new Hospedaje(fecha5, fecha6, Tipo.DOBLE,true);
        Hospedaje hos4 = new Hospedaje(fecha5, fecha6, Tipo.DOBLE,false);
        Hospedaje hos5 = new Hospedaje(fecha7, fecha8, Tipo.DOBLE,true);
        
        //Creando Huespedes para testeo
        Huesped huesped1 = new Huesped("Raul", "asl");
        Huesped huesped2 = new Huesped("Jorge", "asu");
        Huesped huesped3 = new Huesped("Daniel", "asd");
        
        //Creando Reservaciones para testeo
        Reservacion reservacion1 = new Reservacion(hos1, huesped1);
        Reservacion reservacion2 = new Reservacion(hos2, huesped2);
        Reservacion reservacion3 = new Reservacion(hos1, huesped3);
        Reservacion reservacion4 = new Reservacion(hos2, huesped3);*/

        //System.out.println(gestorPisos.calcularNumHabitacionesHabilitadas(true, hos1));
        //gestorPisos.getPisos().get(5).getHabitaciones()[9].agregarHospedaje(hos2);
        //System.out.println(gestorPisos.calcularNumHabitacionesHabilitadas(true, hos3));
        
       
 
        //Probando la disponibilidad cuando el hotel no tiene reservaciones
        //System.out.println(gestorReserv.getReservacionesDisp(hos1, gestorPisos.calcularNumHabitacionesHabilitadas(false,hos1)));
        
        //Agregando una reservacion a el gestor
        //gestorReserv.agregarReservacion(reservacion1);
        
        //Verificando disponibilidad cuando una reservacion
        //System.out.println(gestorReserv.getReservacionesDisp(hos2, gestorPisos.calcularNumHabitacionesHabilitadas(false,hos2)));
        
        //Agregando segunda reservacion
        //gestorReserv.agregarReservacion(reservacion2);
        
        //Verificando disp cuando hay n reservaciones
        //System.out.println(gestorReserv.getReservacionesDisp(hos3, gestorPisos.calcularNumHabitacionesHabilitadas(false,hos3)));
        //gestorReserv.agregarReservacion(reservacion3);
        //System.out.println(gestorReserv.getReservacionesDisp(hos4, gestorPisos.calcularNumHabitacionesHabilitadas(false,hos4)));
        //gestorReserv.agregarReservacion(reservacion4);
        //System.out.println(gestorReserv.getReservacionesDisp(hos5, gestorPisos.calcularNumHabitacionesHabilitadas(false, hos5)));
        //gestorReserv.agregarReservacion(reservacion5);
        
        //Viendo reservaciones de los siguientes 7 dias
        //gestorReserv.verReservaciones();

        

        
        
  
        
        
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
    
    
//    }
    
    

//}
    }
}