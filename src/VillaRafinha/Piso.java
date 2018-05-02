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
    private ArrayList<Habitacion> habitaciones;
    private boolean estado;

    public Piso() {
    }

    public Piso(Nivel nivel, ArrayList<Habitacion> habitaciones) {
        this.nivel = nivel;
        this.habitaciones = habitaciones;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}
