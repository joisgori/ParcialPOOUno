/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;
import java.time.Instant;
import java.time.LocalDate;



/**
 *
 * @author Raul Granados 00138816
 */
public class GestorPisosHabitaciones {
    private static GestorPisosHabitaciones gestor;
    private Piso[] pisos = new Piso[6];

    
    private GestorPisosHabitaciones(){
        
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
    
    /*public void deshabilitarPiso(Nivel nivel) throws Exception {
        for (Piso p : this.pisos) {
            if (p.getNivel() == nivel) {
                if (p.isEstado()) {
                    for (Habitacion h : p.getHabitaciones()) {
                        h.estado = false;
                    }
                }
                else{
                    throw new Exception ("El piso ya esta dshabilitado");
                    
                }
            }

        }

    }*/
    /*public void habilitarPiso(Nivel nivel) throws Exception {
        for (Piso p : this.pisos) {
            if (p.getNivel() == nivel) {
                if (!p.isEstado()) {
                    for (Habitacion h : p.getHabitaciones()) {
                        h.estado = true;
                    }
                }
                else{
                    throw new Exception("El pso ya esta habilitdo");
                }
            }

        }

    }*/
    public void habilitarHabitacion(Habitacion habitacion) throws Exception{
        if(!habitacion.isEstado()){
            habitacion.setEstado(true);
        }
        else{
            throw new Exception("La habitacion ya esta habilitada");
            
        }
        
        
    }
    public void deshabilitarHabitacion(Habitacion habitacion) throws Exception{
        if(habitacion.isEstado()){
            habitacion.setEstado(false);
        }
        else{
            throw new Exception("La habitacion ya estaba deshabilitada");
        }
        
    }
    /*public boolean verificarDisp(Habitacion habitacion, Hospedaje hospedaje){
        Hospedaje f;
        if(habitacion.getHospedajesHabitacion()==null){
            return true;
        }
        for(int i=0;i<habitacion.getHospedajesHabitacion().size();i++){
            f=habitacion.getHospedajesHabitacion().get(i);
            if(f.getFechaLlegada().isBefore(hospedaje.getFechaLlegada())||f.getFechaLlegada().equals(hospedaje.getFechaLlegada())){
                
            }
        }
        
    }*/
    public Habitacion getHabitacion(Tipo tipo)throws Exception{
        
        for(Piso p: this.pisos){
            /*for(Habitacion h: p.getHabitaciones()){
                
            }*/
            
        }
        throw new Exception ("No hay habitaciones de tipo "+tipo.toString()+"disponibles");
    }
    
    
    
}
