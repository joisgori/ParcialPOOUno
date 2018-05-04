/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;



/**
 *
 * @author Raul Granados 00138816
 */
public class GestorPisosHabitaciones {
    //private GestorPisosHabitaciones gestor;
    //private Piso[] pisos = new Piso[6];
    private static GestorPisosHabitaciones gestor;
    private ArrayList<Piso> pisos = new ArrayList();
    int precioBase;
    

    
    private GestorPisosHabitaciones(){
        
        
        this.pisos.add(new Piso("A"));
        this.pisos.add(new Piso("B"));
        this.pisos.add(new Piso("C"));
        this.pisos.add(new Piso("D"));
        this.pisos.add(new Piso("E"));
        this.pisos.add(new Piso("F"));
        this.precioBase=80;
        
        
        
        
        
    }
    
    public static GestorPisosHabitaciones getInstance(){
        if(gestor==null){
            gestor = new GestorPisosHabitaciones();
            
        }
        System.out.println("Gestor Instanciado");
        return gestor;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }
    

    public ArrayList<Piso> getPisos() {
        return pisos;
    }

    public void setPisos(ArrayList<Piso> pisos) {
        this.pisos = pisos;
    }

    
    /**
     * Este metodo deshabilita todas las habitaciones de un piso.
     * @param nivel el nivel en el que se ecuentra 
     * @throws Exception en caso de que ya esten todos deshabilitados 
     */
    
    public void deshabilitarPiso(String nivel) throws Exception {
        for (Piso p : this.pisos) {
            
            if (p.getNivel().equals(nivel)) {
                if (p.isEstado()) {
                    for (Habitacion h : p.getHabitaciones()) {
                        h.setEstado(false);
                    }
                }
                else{
                    throw new Exception ("El piso ya esta dshabilitado");
                    
                }
            }

        }

    }
    public void habilitarPiso(String nivel) throws Exception {
        for (Piso p : this.pisos) {
            if (p.getNivel().equals(nivel)) {
                if (!p.isEstado()) {
                    for (Habitacion h : p.getHabitaciones()) {
                        h.setEstado(true);
                    }
                }
                else{
                    throw new Exception("El piso ya esta habilitdo");
                }
            }

        }

    }
    /**
     * Este metodo desabilita la habitacion.
     * @param habitacion 
     * @throws Exception en caso de que la habitacion este ya habilitada
     */
    public void habilitarHabitacion(Habitacion habitacion) throws Exception {
        if (!habitacion.isEstado()) {
            habitacion.setEstado(true);
        } else {
            throw new Exception("La habitacion ya esta habilitada");

        }

    }
    /**
     * Este metodo habilita la habitacion
     * @param habitacion
     * @throws Exception en caso de que la habitacion ya este deshabilitada
     */
    public void deshabilitarHabitacion(Habitacion habitacion) throws Exception {
        if (habitacion.isEstado()) {
            habitacion.setEstado(false);
        } else {
            throw new Exception("La habitacion ya estaba deshabilitada");
        }
    }
    /**
     * Esta habitacion recibe un objeto habitacion y uno de tipo hospedaje, del cual se extraen la fecha en la que se quere reservar 
     * y se compara con las fechas de entrada y salida que tiene cada objeto de tipo hospedaje almacenado en el arreglo de cada habitacion
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
                } else if (hos2.getFechaSalida().isBefore(hospedaje.getFechaLlegada())) {
                    return true;
                } else {
                    return false;
                }
            }
            if (hos2.getFechaLlegada().isAfter(hospedaje.getFechaSalida())) {
                return true;
            }

            while (it.hasNext()) {
                hos1 = hos2;
                hos2 = it.next();
                if (hos1.getFechaSalida().isBefore(hospedaje.getFechaLlegada()) || hos1.getFechaSalida().equals(hospedaje.getFechaLlegada())) {
                    if (hos2.getFechaLlegada().isAfter(hospedaje.getFechaSalida()) || hos2.getFechaLlegada().equals(hospedaje.getFechaSalida())) {
                        return true;
                    }
                    else{
                        return false;
                    }

                }

            }
            if (hos2.getFechaSalida().isBefore(hospedaje.getFechaLlegada())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public Habitacion getHabitacion(Tipo tipo, Hospedaje hospedaje, boolean isSuperior) throws Exception {
        //boolean isSuperior;
        int validador1, validador2;
        int tamanio = this.pisos.size();

        if (isSuperior) {
            validador2 = tamanio - 1;
            validador1 = tamanio;

        } else {
            validador1 = tamanio - 2;
            validador2 = 0;
        }

        for (int i = validador1; i >= validador2; i--) {
            Piso p = this.pisos.get(i);
            if (p.isEstado()) {
                for (Habitacion h : p.getHabitaciones()) {
                    if (h.getTipo() == tipo) {
                        if (this.verificarDisp(h, hospedaje)) {
                            return h;
                        }
                    }
                }
            }

        }
        throw new Exception("No hay habitaciones de tipo " + tipo.toString() + "disponibles");

    }
    public int calcularNumHabitacionesDisponibles(boolean isSuperior, Hospedaje hospedaje) {
        int cont = 0, validador1, validador2;
        int tamanio = this.pisos.size() - 1;
        Piso p;
        //Habitacion h;
        if (isSuperior) {
            validador2 = tamanio - 1;
            validador1 = tamanio;

        } else {
            validador1 = tamanio - 2;
            validador2 = 0;
        }
        for (int i = validador1; i >= validador2; i--) {
            p = this.pisos.get(i);
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
    
    
    public boolean isSuperior(Habitacion habitacion){
        int tamanio = this.pisos.size() - 1;
        for(int i=tamanio;i>tamanio-2;i--){
            Piso p = this.pisos.get(i);
            for(Habitacion h: p.getHabitaciones()){
                if(h.equals(habitacion)){
                    return true;
                }
            }
        }
        return false;
        
        
    }
    
    
}
