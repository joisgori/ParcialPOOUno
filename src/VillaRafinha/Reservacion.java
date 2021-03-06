/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author daniel
 */


public class Reservacion implements Comparable<Reservacion>{
    
    private boolean sencilla;
    private Huesped huesped;
    private Hospedaje estancia;
    private Paquete paquete;
    private Float total;
    private boolean check;
    //private Habitacion[] habitacion = new Habitacion[2];
    private final String id;
    private Habitacion habitacion;
    
    //Constructor
    public Reservacion(Hospedaje hospedaje, Huesped huesped){
        this.check=false;
        this.estancia=hospedaje;
        this.huesped=huesped;
        this.id= UUID.randomUUID().toString().toUpperCase().substring(0, 5);
        //habitacion = new Habitacion[numHab];
    }
    
    //métodos setter
    public void setSencilla(boolean sencilla) {
        this.sencilla = sencilla;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public void setEstancia(Hospedaje estancia) {
        this.estancia = estancia;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    
    
    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    
    public void setTotal(Float total) {
        this.total = total;
    }

    public void setCheck(boolean activa) {
        this.check = activa;
    }
    
    //métodos getter
    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public Hospedaje getEstancia() {
        return estancia;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public Float getTotal() {
        return total;
    }

    //Estos booleanos retornan validación para la clase menú de acuerdo a las opciones seleccionadas.
    public boolean isCheck() {
        return check;
    }
    
    public boolean isSencilla() {
        return sencilla;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.huesped);
        hash = 47 * hash + Objects.hashCode(this.estancia);
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
        final Reservacion other = (Reservacion) obj;
        if (!Objects.equals(this.huesped, other.huesped)) {
            return false;
        }
        if (!Objects.equals(this.estancia, other.estancia)) {
            return false;
        }
        return true;
    }
    
    public void cancelarReservacion(){
        this.setCheck(false);
    }
    

    @Override
    public String toString() {
        return "Reservacion:\n"+"Huesped: "+huesped.getNombre() +"\nFecha de Llegada: "+estancia.getFechaLlegada()+"\nFecha de Salida: "+estancia.getFechaSalida()+ "\nhabitacion: " + estancia.getTipo() + "\ntotal=" + total+"\n";
    }

    @Override
    public int compareTo(Reservacion o) {
        return estancia.getFechaLlegada().compareTo(o.getEstancia().getFechaLlegada());
    }
    
}

