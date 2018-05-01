/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;



/**
 *
 * @author raul
 */
public class GestorPisosHabitaciones {
    private static GestorPisosHabitaciones gestor;
    Piso[] pisos = new Piso[6];

    
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
    
    public void deshabilitarPiso(Nivel nivel) throws Exception {
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

    }
    public void habilitarPiso(Nivel nivel) throws Exception {
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

    }
    public void habilitarHabitacion(Habitacion habitacion) throws Exception{
        if(!habitacion.estado){
            habitacion.estado=true;
        }
        else{
            throw new Exception("La habitacion ya esta habilitada");
            
        }
        
        
    }
    public void deshabilitarHabitacion(Habitacion habitacion) throws Exception{
        if(habitacion.estado){
            habitacion.estado=false;
        }
        else{
            throw new Exception("La habitacion ya estaba deshabilitada");
        }
        
    }
    public Habitacion getHabitacion(Tipo tipo)throws Exception{
        for(Piso p: this.pisos){
            for(Habitacion h: p.getHabitaciones()){
                
            }
            
        }
        throw new Exception ("No hay habitaciones de tipo "+tipo.toString()+"disponibles");
    }
    
    
}
