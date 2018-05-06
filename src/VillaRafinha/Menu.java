/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul Granados 00138816
 */
public class Menu {
    private static GestorPisosHabitaciones gestorHab=null;
    private static GestorReservaciones gestorRes=null;
    private static GestorHuespedes gestoHus = null;
    private static Menu menu=null;
    
    private Menu() {
        Menu.gestorHab  = GestorPisosHabitaciones.getInstance();
        Menu.gestorRes = GestorReservaciones.getInstance();
        Menu.gestoHus = GestorHuespedes.getInstance();

    }
    public static Menu getInstance(){
        if(menu==null){
            menu=new Menu();
        }
        return menu;
    }
    public void opciones(){
        System.out.println("\n1.Hacer Reservacion\n2.Hacer Check In\n3.Hacer Check Out\n4.Modificaciones");
    }
    public void mostrar() {
        int opc = 40;
        
        Scanner scanner = new Scanner(System.in);
        

        while (opc != 35) {
            
                opciones();
                System.out.print("Ingrese una opcion: ");
                opc = scanner.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println("\n1. Por fechas\n2. Por numero de dias");
                        System.out.print("Ingrese una opcion: ");
                        int a = scanner.nextInt();
                        
                        int dia,mes,anio;
                        LocalDate llegada,
                                salida;
                        if (a == 1) {
                            try {
                                System.out.println("Ingrese Fecha de llegada: ");
                                llegada = this.gestorRes.pedirFechar();
                                System.out.println("Ingrse fecha de salida: ");
                                salida = this.gestorRes.pedirFechar();
                                boolean isSuperior = gestorRes.pedirPiso();
                                Hospedaje hosp = new Hospedaje(llegada, salida, this.gestorRes.pedirTipo(),isSuperior);
                                
                                //int disp = this.gestorHab.calcularNumHabitacionesHabilitadas(isSuperior, hosp);
                                //if (gestorRes.getReservacionesDisp(hosp, gestorHab.getHabitacionesHabilitadas(hosp)) > 0) {
                                    Huesped hues = this.gestoHus.crearHuesped();
                                    Reservacion res = new Reservacion(hosp, hues);
                                    this.gestoHus.agregarHuesped(hues);

                                    this.gestorRes.agregarReservacion(res);
                                    this.gestorRes.verReservaciones();
                               // }


                            } catch (Exception ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            
                        }
                        break;
                    case 2:
                        Scanner check = new Scanner(System.in);
                        System.out.print("Ingrese nombre: ");
                        String nombreCheck = check.nextLine();

                        Reservacion rCheck;
                        try {
                            rCheck = gestorRes.buscarReservacionNombre(nombreCheck);
                            Habitacion hCheck = gestorHab.getHabitacion(rCheck);
                            rCheck.setHabitacion(hCheck);
                            hCheck.agregarHospedaje(rCheck.getEstancia());
                            System.out.println("/nHabitacion asignada: " + hCheck.getNivel() + hCheck.getNumero());
                            gestorRes.verReservaciones();
                        } catch (Exception ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    case 3:
                        Scanner scanner3= new Scanner(System.in);
                        String nombre;
                        System.out.print("Nombre del huesped: ");
                        nombre = scanner3.nextLine();
                        for(Reservacion r: this.gestorRes.getReservaciones()){
                            if(r.getHuesped().getNombre().equals(nombre)){
                                r.getHabitacion().getHospedajesHabitacion().remove(r.getEstancia());
                                this.gestorRes.getReservaciones().remove(r);
                            }
                            
                        }
                        
                        break;
                    case 4:
                        System.out.println("\n1.Precios y habitaciones\n2.Tarifas");
                      
                        
                        break;
                        
                        
                }
                
                //Hospedaje hosp = new Hospedaje();
            } 
            
        }
    }

    
