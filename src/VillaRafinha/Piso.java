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
    
    private String nivel;
    private Habitacion [] habitaciones = new Habitacion[10]; ;
    private boolean estado;

    public Piso(String nivel) {
        this.estado=true;
        this.nivel=nivel;
        for(int i=1;i<=10;i++){
            if(i%2==0){
                this.habitaciones[i-1]= new Habitacion(Tipo.DOBLE,nivel,i,nivel+i,"Linda habitacion con dos camas sencillas");
                
            }
            else{
                this.habitaciones[i-1]= new Habitacion(Tipo.SENCILLA,nivel,i,nivel+i,"Linda habitacion con cama doble");
            }
            
        }
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nivel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piso other = (Piso) obj;
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        return true;
    }
    
}
