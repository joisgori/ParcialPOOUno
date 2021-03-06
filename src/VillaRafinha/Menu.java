package VillaRafinha;

import java.time.LocalDate;
import java.time.Period;
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
    private static MenuProducto menuPro = null;

    private Menu() {
        Menu.gestorHab = GestorPisosHabitaciones.getInstance();
        Menu.gestorRes = GestorReservaciones.getInstance();
        Menu.gestoHus = GestorHuespedes.getInstance();
        Menu.menuPro = MenuProducto.getInstance();
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void opciones() {
        System.out.println("Ingrese numeros enteros");
        System.out.println("\n1.Hacer Reservacion\n2.Hacer Check In\n3.Hacer Check Out\n4.Modificaciones\n5.Ver reservaciones");
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
                        int numdias;
                        LocalDate llegada,
                         salida;
                        Hospedaje hosp = null;
                        String paquete;

                        System.out.println("\n1. Por fechas\n2. Por numero de dias");
                        System.out.print("Ingrese una opcion: ");
                        int a = scanner.nextInt();

                        if (a == 1) {
                            Scanner scanner1 = new Scanner(System.in);
                            try {
                                int numHab;
                                System.out.println("Ingrese Fecha de llegada: ");
                                llegada = Menu.gestorRes.pedirFechar();
                                System.out.println("Ingrese fecha de salida: ");
                                salida = Menu.gestorRes.pedirFechar();
                                Period periodo = Period.between(llegada, salida);

                                boolean isSuperior = gestorRes.pedirPiso();
                                hosp = new Hospedaje(llegada, salida, Menu.gestorRes.pedirTipo(), isSuperior);

                                //int disp = this.gestorHab.calcularNumHabitacionesHabilitadas(isSuperior, hosp);
                            } catch (Exception ex) {
                                //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                                System.err.println(ex);
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
                                if (numdias > 7) {
                                    throw new Exception("No se puede reservar por mas de 7 dias");
                                } else {
                                    //System.out.print("Ingrese número de habitaciones: ");
                                    //numHab = scannopdos.nextInt();
                                    boolean isSuperior = gestorRes.pedirPiso();
                                    hosp = new Hospedaje(llegada, numdias, this.gestorRes.pedirTipo(), isSuperior);

                                }

                            } catch (Exception ex) {
                                //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                                System.err.println(ex);
                            }
//EL CÓDIGO TERMINA ACÁ PARA ESA OPCIÓN
//Esto que se encuentra acontinuación será donde termine el buckle para validar la opción correcta escogida dentro del menú para la manera de reserva...
                        }
                        try {

                            Scanner paqueteScan = new Scanner(System.in);
                            if (gestorRes.getReservacionesDisp(hosp, gestorHab.getHabitacionesHabilitadas(hosp)) > 0) {
                                Huesped huespe = this.gestoHus.crearHuesped();
                                Reservacion res = new Reservacion(hosp, huespe);
                                GestorProductos.verPaquetesLista();
                                System.out.print("Ingrese paquete: ");
                                paquete = paqueteScan.nextLine();
                                res.setPaquete(GestorProductos.buscarPaquete(paquete));
                                Menu.gestoHus.agregarHuesped(huespe);

                                Menu.gestorRes.agregarReservacion(res);
                                res.toString();
                            } else {
                                System.out.println("Ingrese una opción válida...");
                            }
                        } catch (Exception ex) {
                            //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            System.err.println("No se ha podido realizar la reservacion");
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
                                //System.out.println("Ya se ha realizado el Check In");
                                throw new Exception("Ya se ha realizado el check in");
                            }
                        } catch (Exception ex) {
                            System.err.println(ex);
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
                        System.out.println("\n1.Pisos y Habitaciones\n2.Paquetes y servicios");
                        int opc4 = scanner4.nextInt();
                        if (opc4 == 1) {
                            System.out.println("1. Cambiar precio habitaciones\n2.Agregar Piso\n3. Habilitar piso\n4.Deshabilitar piso");
                            System.out.println("5. Habilitar habitacion\n6. Deshabilitar habitacion");
                            int opc41 = scanner4.nextInt();
                            switch (opc41) {

                                case 1:
                                    System.out.println("El precio base es: " + GestorPisosHabitaciones.getPrecioBase());
                                    System.out.print("Ingrese el nuevo precio base: ");
                                    GestorPisosHabitaciones.setPrecioBase(scanner4.nextInt());
                                    System.out.println("El nuevo precio base es: " + GestorPisosHabitaciones.getPrecioBase());
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
                                        //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                                        System.out.println(ex);
                                    }

                                    break;
                                case 4:
                                    String piso2;
                                    Scanner scanner44 = new Scanner(System.in);
                                    piso2 = scanner44.nextLine();

                                    try {
                                        gestorHab.deshabilitarPiso(piso2);
                                    } catch (Exception ex) {
                                        //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                                        System.out.println(ex);
                                    }

                                    break;
                                case 5:
                                    String nivel;
                                    int numero;
                                    Scanner scanner45 = new Scanner(System.in);
                                    System.out.print("Ingrese nivel de la habitacion: ");
                                    nivel = scanner45.nextLine();
                                    System.out.print("Ingrese numero de habitacion: ");
                                    numero = scanner45.nextInt();
                                    gestorHab.habilitarHabitacion(nivel, numero);
                                    break;
                                case 6:
                                    String nivel6;
                                    int numero6;
                                    Scanner scanner46 = new Scanner(System.in);
                                    System.out.print("Ingrese nivel de la habitacion: ");
                                    nivel = scanner46.nextLine();
                                    System.out.print("Ingrese numero de habitacion: ");
                                    numero = scanner46.nextInt();
                                    gestorHab.deshabilitarHabitacion(nivel, numero);
                                    break;
                                default:
                                    System.out.println("...");
                                    break;
                            }

                        } else if (opc4 == 2) {
                            menuPro.ejecutarAccion();
                        }

                        break;
                    case 5:
                        Scanner scanner5 = new Scanner(System.in);
                        System.out.println("1-Ver reservaciones de los proximos 7 dias\n2-Ver todas las reservaciones");
                        System.out.print("Opcion: ");
                        int opc5 =scanner5.nextInt();
                        if(opc5==1){
                            gestorRes.verReservaciones();
                        }else if (opc5==2){
                            gestorRes.verTodasReservaciones();
                        }
                }

                //Hospedaje hosp = new Hospedaje();
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese una opcion correcta");
                scanner.nextLine(); //este es el del while
            }

        }
    }

}
