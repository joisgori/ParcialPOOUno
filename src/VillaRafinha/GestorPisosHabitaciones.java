/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;
import java.time.LocalDate;
import java.util.Iterator;



/**
 *
 * @author Raul Granados 00138816
 */
public class GestorPisosHabitaciones {
    private static GestorPisosHabitaciones gestor;
    private Piso[] pisos = new Piso[6];
    

    
    private GestorPisosHabitaciones(){
        pisos[0].setNivel(Nivel.A);
        pisos[1].setNivel(Nivel.B);
        pisos[2].setNivel(Nivel.C);
        pisos[3].setNivel(Nivel.D);
        pisos[4].setNivel(Nivel.E);
        pisos[5].setNivel(Nivel.F);
        
        int cont=1;
        for(Piso p: this.pisos){
            for(Habitacion h: p.getHabitaciones()){
                h.setNumero(cont);
                cont+=1;
            }
        }
        
        
    }
    
    public static GestorPisosHabitaciones getInstance(){
        if(gestor==null){
            gestor = new GestorPisosHabitaciones();
        }
        return gestor;
    }

    public Piso[] getPisos() {
        return pisos;
    }

    
    public void setPisos(Piso[] pisos) {
        this.pisos = pisos;
    }
    /**
     * Este metodo deshabilita todas las habitaciones de un piso.
     * @param nivel el nivel en el que se ecuentra 
     * @throws Exception en caso de que ya esten todos deshabilitados 
     */
    
    public void deshabilitarPiso(Nivel nivel) throws Exception {
        for (Piso p : this.pisos) {
            
            if (p.getNivel() == nivel) {
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
    public void habilitarPiso(Nivel nivel) throws Exception {
        for (Piso p : this.pisos) {
            if (p.getNivel() == nivel) {
                if (!p.isEstado()) {
                    for (Habitacion h : p.getHabitaciones()) {
                        h.setEstado(true);
                    }
                }
                else{
                    throw new Exception("El pso ya esta habilitdo");
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
    public Habitacion getHabitacion(Tipo tipo, Hospedaje hospedaje) throws Exception {

        for (Piso p : this.pisos) {
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
    /*public Habitacion getHabitacion(Nivel nivel, int numero){
        for(Piso p :this.pisos ){
            
        }
        
    }*/
    
    
    
}