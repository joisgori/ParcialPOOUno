/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;
import java.util.*;

/**
 *
 * @author aacm13
 */
public class Piso {
    private Nivel nivel;
    private ArrayList<Habitacion> habitacion;

    public Piso() {
    }

    public Piso(Nivel nivel, ArrayList<Habitacion> habitacion) {
        this.nivel = nivel;
        this.habitacion = habitacion;
    }

    public ArrayList<Habitacion> getHabitacion() {
        return habitacion;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setHabitacion(ArrayList<Habitacion> habitacion) {
        this.habitacion = habitacion;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
    
    
}
