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

    public static GestorPisosHabitaciones getGestor() {
        return gestor;
    }

    public Piso[] getPisos() {
        return pisos;
    }

    public static void setGestor(GestorPisosHabitaciones gestor) {
        GestorPisosHabitaciones.gestor = gestor;
    }

    public void setPisos(Piso[] pisos) {
        this.pisos = pisos;
    }
    
}
