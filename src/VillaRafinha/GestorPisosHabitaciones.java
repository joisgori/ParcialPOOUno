/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



/**
 *
 * @author Raul Granados 00138816
 */
public class GestorPisosHabitaciones {

    //private GestorPisosHabitaciones gestor;
    //private Piso[] pisos = new Piso[6];
    private static GestorPisosHabitaciones gestor;
    private  static ArrayList<Piso> pisos = new ArrayList();
    private static int precioBase;
    

    private GestorPisosHabitaciones() {

        GestorPisosHabitaciones.pisos.add(new Piso("A"));
        GestorPisosHabitaciones.pisos.add(new Piso("B"));
        GestorPisosHabitaciones.pisos.add(new Piso("C"));
        GestorPisosHabitaciones.pisos.add(new Piso("D"));
        GestorPisosHabitaciones.pisos.add(new Piso("E"));
        GestorPisosHabitaciones.pisos.add(new Piso("F"));
        

    }

    public static GestorPisosHabitaciones getInstance() {
        if (gestor == null) {
            gestor = new GestorPisosHabitaciones();

        }
        return gestor;
    }

    public static int getPrecioBase() {
        return precioBase;
    }

    public static void setPrecioBase(int precioBase) {
        GestorPisosHabitaciones.precioBase = precioBase;
    }
    

    

    public ArrayList<Piso> getPisos() {
        return pisos;
    }

    public void setPisos(ArrayList<Piso> pisos) {
        GestorPisosHabitaciones.pisos = pisos;
    }

    /**
     * Este metodo deshabilita todas las habitaciones de un piso.
     *
     * @param nivel el nivel en el que se ecuentra
     * @return 
     * @throws Exception en caso de que ya esten todos deshabilitados
     */
    public boolean deshabilitarPiso(String nivel) throws Exception {
        for (Piso p : GestorPisosHabitaciones.pisos) {

            if (p.getNivel().equals(nivel)) {
                if (p.isEstado()) {
                    for (Habitacion h : p.getHabitaciones()) {
                        h.deshablitar();
                        return true;
                    }
                } else {
                    throw new Exception("El piso ya esta dshabilitado");

                }
            }

        }
        throw new Exception("El piso no existe");

    }

    public boolean habilitarPiso(String nivel) throws Exception {
        for (Piso p : GestorPisosHabitaciones.pisos) {
            if (p.getNivel().equals(nivel)) {
                if (!p.isEstado()) {
                    
                    for (Habitacion h : p.getHabitaciones()) {
                        h.hablitar();
                        
                    }
                    return true;
                } else {
                    throw new Exception("El piso ya esta habilitdo");
                }
            }

        }
        throw new Exception("El piso no existe");

    }

    /**
     * Este metodo desabilita la habitacion.
     *
     * @param nivel
     * @param numero
     * @return 
     * @throws Exception en caso de que la habitacion este ya habilitada
     */
    public boolean habilitarHabitacion(String nivel, int numero) throws Exception {
        for (Piso p : this.getPisos()) {
            if (p.getNivel().equals(nivel)) {
                for (Habitacion h : p.getHabitaciones()) {
                    if (h.getNumero() == numero&&!h.isEstado()) {
                        h.hablitar();
                        return true;
                    }
                }
            }
        }
        throw new Exception("La habitacion ya esta habilitada o no existe");
    }

    /**
     * Este metodo habilita la habitacion
     *
     * @param nivel
     * @param numero
     * @return 
     * @throws Exception en caso de que la habitacion ya este deshabilitada
     */
    public boolean deshabilitarHabitacion(String nivel, int numero) throws Exception  {
        for (Piso p : this.getPisos()) {
            if (p.getNivel().equals(nivel)) {
                for (Habitacion h : p.getHabitaciones()) {
                    if (h.getNumero() == numero&&!h.isEstado()) {
                        h.hablitar();
                        return true;
                    }
                }
            }
        }
        throw new Exception("La habitacion ya esta deshabilitada o no existe");
    }

    /**
     * Esta habitacion recibe un objeto habitacion y uno de tipo hospedaje, del
     * cual se extraen la fecha en la que se quere reservar y se compara con las
     * fechas de entrada y salida que tiene cada objeto de tipo hospedaje
     * almacenado en el arreglo de cada habitacion
     *
     * @param habitacion
     * @param hospedaje
     * @return
     */

    public boolean verificarDisp(Habitacion habitacion, Hospedaje hospedaje) {

        if (habitacion.isEstado()) {
            Iterator<Hospedaje> it = habitacion.getHospedajesHabitacion().iterator();

            if (!it.hasNext()) {
                return true;
            }
            Hospedaje hos2 = it.next();
            Hospedaje hos1;
            if (!it.hasNext()) {
                if (hos2.getFechaLlegada().isAfter(hospedaje.getFechaSalida())) {
                    return true;
                } else {
                    return hos2.getFechaSalida().isBefore(hospedaje.getFechaLlegada());
                }
            }

            while (it.hasNext()) {
                hos1 = hos2;
                hos2 = it.next();
                if (hos1.getFechaSalida().isBefore(hospedaje.getFechaLlegada()) || hos1.getFechaSalida().equals(hospedaje.getFechaLlegada())) {
                    return hos2.getFechaLlegada().isAfter(hospedaje.getFechaSalida()) || hos2.getFechaLlegada().equals(hospedaje.getFechaSalida());

                }

            }
            return hos2.getFechaSalida().isBefore(hospedaje.getFechaLlegada());
        } else {
            return false;
        }
    }

    public Habitacion getHabitacion(Reservacion reservacion) throws Exception {
        //boolean isSuperior;
        int validador1, validador2;
        int tamanio = GestorPisosHabitaciones.pisos.size()-1;

        if (reservacion.getEstancia().isIsSuperior()) {
            validador1 = tamanio - 1;
            validador2 = tamanio;

        } else {
            validador1 = 0;
            validador2 = tamanio-2;
        }

        for (int i = validador1; i <= validador2; i++) {
            Piso p = GestorPisosHabitaciones.pisos.get(i);
            if (p.isEstado()) {
                for (Habitacion h : p.getHabitaciones()) {
                    if (h.getTipo() == reservacion.getEstancia().getTipo()) {
                        if (this.verificarDisp(h, reservacion.getEstancia())) {
                            return h;
                        }
                    }
                }
            }

        }
        throw new Exception("No hay habitaciones de tipo " + reservacion.getEstancia().getTipo().toString() + "disponibles");

    }

    public int calcularNumHabitacionesDisponibles(Hospedaje hospedaje) {
        int cont = 0, validador1, validador2;
        int tamanio = GestorPisosHabitaciones.pisos.size() - 1;
        Piso p;
        //Habitacion h;
        if (hospedaje.isIsSuperior()) {
            validador2 = tamanio - 1;
            validador1 = tamanio;

        } else {
            validador1 = tamanio - 2;
            validador2 = 0;
        }
        for (int i = validador1; i >= validador2; i--) {
            p = GestorPisosHabitaciones.pisos.get(i);
            for (Habitacion h : p.getHabitaciones()) {
                if (h.getTipo() == hospedaje.getTipo()) {
                    if (this.verificarDisp(h, hospedaje)) {
                        cont++;
                    }

                }
            }

        }

        return cont;
    }
    public int getHabitacionesHabilitadas(Hospedaje hospedaje){
        int cont = 0, validador1, validador2;
        int tamanio = GestorPisosHabitaciones.pisos.size() - 1;
        Piso p;
        //Habitacion h;
        if (hospedaje.isIsSuperior()) {
            validador2 = tamanio - 1;
            validador1 = tamanio;

        } else {
            validador1 = tamanio - 2;
            validador2 = 0;
        }
        for (int i = validador1; i >= validador2; i--) {
            p = GestorPisosHabitaciones.pisos.get(i);
            for (Habitacion h : p.getHabitaciones()) {
                if (h.isEstado()) {
                    cont++;

                }
            }

        }
        
        
        
        return cont;
    }

    public static boolean isSuperior(Habitacion habitacion) {
        int tamanio = pisos.size() - 1;
        /*for (int i = tamanio; i > tamanio - 2; i--) {
            Piso p = this.pisos.get(i);
            for (Habitacion h : p.getHabitaciones()) {
                if (h.equals(habitacion)) {
                    return true;
                }
            }
        }
        return false;*/
       for (int i = tamanio-1; i <= tamanio; i++){
           Piso p=pisos.get(i);
           
           if(p.getNivel().equals(habitacion.getNivel())){
               return true;
           }
       }
       return false;
    }
    public void agregarPiso(){
        String nivel;
        Scanner scanner = new Scanner(System.in);
        System.out.println("El  ultimo piso es: "+GestorPisosHabitaciones.pisos.get(GestorPisosHabitaciones.pisos.size()-1).getNivel());
        System.out.println("Nivel del nuevo piso: ");
        nivel = scanner.nextLine();
        Piso nuevopiso = new Piso(nivel);
        GestorPisosHabitaciones.pisos.add(nuevopiso);
    }

}
    
