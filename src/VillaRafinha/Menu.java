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
 * @author rau3
 */
public class Menu {
    private GestorPisosHabitaciones gestorHab=null;
    private GestorReservaciones gestorRes=null;
    private static Menu menu=null;
    
    private Menu() {
        this.gestorHab  = GestorPisosHabitaciones.getInstance();
        this.gestorRes = new GestorReservaciones();

    }
    public static Menu getInstance(){
        if(menu==null){
            menu=new Menu();
        }
        return menu;
    }
    public void opciones(){
        System.out.println("1.Hacer Reservacion\n2.Hacer Check In\n3.Hacer Check Out");
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
                    System.out.println("1. Por fechas\n2. Por numero de dias");
                    System.out.print("Ingrese una opcion: ");
                    int a = scanner.nextInt();

                    int dia,
                     mes,
                     anio;
                    LocalDate llegada,
                     salida;
                    if (a == 1) {
                        try {
                            System.out.println("Ingrese Fecha de llegada: ");
                            llegada = this.gestorRes.pedirFechar();
                            System.out.println("Ingrse fecha de salida: ");
                            salida = this.gestorRes.pedirFechar();
                            Hospedaje hosp = new Hospedaje(llegada, salida, this.gestorRes.pedirTipo());
                            Reservacion res = new Reservacion(hosp, this.gestorRes.crearHuesped());
                            this.gestorRes.agregarReservacion(res);
                        } catch (Exception ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.gestorRes.verReservaciones();

                    }
                case 2:
                    
                    break;

            }

            //Hospedaje hosp = new Hospedaje();
        }
    }

    }
