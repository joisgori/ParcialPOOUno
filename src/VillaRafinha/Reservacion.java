/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.Objects;

/**
 *
 * @author daniel
 */


public class Reservacion {
    
    private boolean sencilla;
    private Huesped huesped;
    private Hospedaje estancia;
    private Paquete paquete;
    private Float total;
    private boolean activa;
    private TarjetaCredito garantia;
    
    
    public Reservacion(){
        
    }
    
    public void setSencilla(boolean sencilla) {
        this.sencilla = sencilla;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public void setEstancia(Hospedaje estancia) {
        this.estancia = estancia;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public boolean isSencilla() {
        return sencilla;
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

    public boolean isActiva() {
        return activa;
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
        this.setActiva(false);
    }
    
    public void procesarREservacion(TarjetaCredito t){
        this.garantia=t;
    }
    
}
