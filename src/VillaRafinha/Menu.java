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

    private static GestorPisosHabitaciones gestorHab = null;
    private static GestorReservaciones gestorRes = null;
    private static GestorHuespedes gestoHus = null;
    private static Menu menu = null;

    private Menu() {
        this.gestorHab = GestorPisosHabitaciones.getInstance();
        this.gestorRes = GestorReservaciones.getInstance();
        this.gestoHus = GestorHuespedes.getInstance();

    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void opciones() {
        System.out.println("Ingrese numeros enteros");
        System.out.println("\n1.Hacer Reservacion\n2.Hacer Check In\n3.Hacer Check Out\n4.Modificaciones");
    }

    public void mostrar() throws Exception {
        int opc = 40;

        Scanner scanner = new Scanner(System.in);

        while (opc != 35) {

            try {
                opciones();
                System.out.print("Ingrese una opcion: ");
                opc = scanner.nextInt();
                switch (opc) {
                    
                    case 1:
                        int dia, mes,anio,numdias;
                        LocalDate llegada,salida;
                        Hospedaje hosp = null;

                        System.out.println("\n1. Por fechas\n2. Por numero de dias");
                        System.out.print("Ingrese una opcion: ");
                        int a = scanner.nextInt();

                        if (a == 1) {
                            Scanner scanner1 = new Scanner(System.in);
                            try {
                                int numHab;
                                System.out.println("Ingrese Fecha de llegada: ");
                                llegada = this.gestorRes.pedirFechar();
                                System.out.println("Ingrese fecha de salida: ");
                                salida = this.gestorRes.pedirFechar();

                                boolean isSuperior = gestorRes.pedirPiso();
                                hosp = new Hospedaje(llegada, salida, this.gestorRes.pedirTipo(), isSuperior);

                                //int disp = this.gestorHab.calcularNumHabitacionesHabilitadas(isSuperior, hosp);
                            } catch (Exception ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }/*código recién agregado para validar la segunda opción del menú sobre la cantidad de días...*/ //ACÁ ADJUNTE MI PARTE DE CÓDIGO PARA HACER UNA RESERVACIÓN COLOCANDO CANTIDAD DE DÍAS PUNTUALES,
                        //Acá habrá que adjuntar la segunda opción que es ingresar una cantidad N de días
                        else if (a == 2) {
                            System.out.println("Escogió la segunda opción...");
                            Scanner scannopdos = new Scanner(System.in);
                            try {
                                int numHab;
                                System.out.println("Ingrese Fecha de llegada: ");
                                llegada = this.gestorRes.pedirFechar();
                                System.out.println("Ingrese cantidad de días: ");
                                numdias = this.gestorRes.pedirnum();
                                //System.out.print("Ingrese número de habitaciones: ");
                                //numHab = scannopdos.nextInt();
                                boolean isSuperior = gestorRes.pedirPiso();
                                hosp = new Hospedaje(llegada, numdias,this.gestorRes.pedirTipo(), isSuperior);
                                

                                

                            } catch (Exception ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }
//EL CÓDIGO TERMINA ACÁ PARA ESA OPCIÓN
//Esto que se encuentra acontinuación será donde termine el buckle para validar la opción correcta escogida dentro del menú para la manera de reserva...
                        }
                        
                        if (gestorRes.getReservacionesDisp(hosp, gestorHab.getHabitacionesHabilitadas(hosp)) > 0) {
                            Huesped huespe = this.gestoHus.crearHuesped();
                            Reservacion res = new Reservacion(hosp, huespe);
                            this.gestoHus.agregarHuesped(huespe);

                            this.gestorRes.agregarReservacion(res);
                            this.gestorRes.verReservaciones();
                        } else {
                            System.out.println("Ingrese una opción válida...");
                        }

                        break;
                    case 2:
                        Scanner check = new Scanner(System.in);
                        System.out.print("Ingrese nombre: ");
                        String nombreCheck = check.nextLine();

                        Reservacion rCheck;
                        try {
                            rCheck = gestorRes.buscarReservacionNombre(nombreCheck);
                            if (!rCheck.isCheck()) {
                                rCheck.setCheck(true);
                                Habitacion hCheck = gestorHab.getHabitacion(rCheck);
                                rCheck.setHabitacion(hCheck);
                                hCheck.agregarHospedaje(rCheck.getEstancia());
                                System.out.println("/nHabitacion asignada: " + hCheck.getNivel() + hCheck.getNumero());
                                gestorRes.verReservaciones();
                            } else {
                                System.out.println("Ya se ha realizado el Check In");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    case 3:
                        Scanner scanner3 = new Scanner(System.in);
                        String nombre;
                        System.out.print("Nombre del huesped: ");
                        nombre = scanner3.nextLine();
                        for (Reservacion r : this.gestorRes.getReservaciones()) {
                            if (r.getHuesped().getNombre().equals(nombre)) {
                                r.getHabitacion().getHospedajesHabitacion().remove(r.getEstancia());
                                this.gestorRes.getReservaciones().remove(r);
                                break;
                            }

                        }

                        break;
                    case 4:
                        Scanner scanner4 = new Scanner(System.in);
                        System.out.println("\n1.Pisos y Habitaciones\n2.Tarifas\n3.Paquetes");
                        int opc4 = scanner4.nextInt();
                        if (opc4 == 1) {
                            System.out.println("1. Cambiar precio habitaciones\n2.Agregar Piso\n3. Habilitar piso\n4.Deshabilitar piso");
                            System.out.println("5. Habilitar habitacion\n6. Deshabilitar habitacion");
                            int opc41 = scanner4.nextInt();
                            switch (opc41) {

                                case 1:
                                    System.out.println("El precio base es: " + gestorRes.getPrecioBase());
                                    System.out.print("Ingrese el nuevo precio base: ");
                                    gestorRes.setPrecioBase(scanner4.nextInt());
                                    System.out.println("El nuevo precio base es: " + gestorRes.getPrecioBase());
                                    break;
                                case 2:
                                    gestorHab.agregarPiso();
                                    break;
                                case 3:
                                    Scanner scanner43 = new Scanner(System.in);
                                    String piso;
                                    piso = scanner43.nextLine();
                                    try {

                                        gestorHab.habilitarPiso(piso);
                                    } catch (Exception ex) {
                                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    break;
                                case 4:
                                    String piso2;
                                    Scanner scanner44 = new Scanner(System.in);
                                    piso2 = scanner44.nextLine();

                                    try {
                                        gestorHab.deshabilitarPiso(piso2);
                                    } catch (Exception ex) {
                                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    break;
                                case 5:
                                    String nivel;
                                    int numero;
                                    Scanner scanner45 = new Scanner(System.in);
                                    System.out.print("Ingrese nivel de la habitacion: ");
                                    nivel = scanner45.nextLine();
                                    System.out.print("Ingrese numero de habitacio: ");
                                    numero = scanner45.nextInt();
                                    gestorHab.habilitarHabitacion(nivel, numero);
                                    break;
                                case 6:
                                    String nivel6;
                                    int numero6;
                                    Scanner scanner46 = new Scanner(System.in);
                                    System.out.print("Ingrese nivel de la habitacion: ");
                                    nivel = scanner46.nextLine();
                                    System.out.print("Ingrese numero de habitacio: ");
                                    numero = scanner46.nextInt();
                                    gestorHab.deshabilitarHabitacion(nivel, numero);
                                    break;
                                default:
                                    System.out.println("Llora pues");
                                    break;
                            }

                        }
                        

                        break;


                }

                //Hospedaje hosp = new Hospedaje();
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese una opcion correcta");
                scanner.nextLine(); //este es el del while
            }

        }
    }

}
