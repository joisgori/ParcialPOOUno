/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 *
 * @author daniel
 */
public class Hospedaje {
    
    private LocalDate fechaLlegada;
    private LocalDate fechaSalida;
    private int numDias;
    
    
    
    public Hospedaje(LocalDate fLlegada, LocalDate fSalida){
        this.fechaLlegada=fLlegada;
        this.fechaSalida=fSalida;
        Period periodo = Period.between(fLlegada, fSalida);
        this.numDias=periodo.getDays();
    }

    
    
    public Hospedaje(LocalDate fLlegada, int numDias){
        this.fechaLlegada=fLlegada;
        this.fechaSalida=fechaLlegada.plusDays(numDias);
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public int getNumDias() {
        return numDias;
    }


    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }


    @Override
    public int hashCode() {
        int hash = 7;
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
        final Hospedaje other = (Hospedaje) obj;
        if (!Objects.equals(this.fechaLlegada, other.fechaLlegada)) {
            return false;
        }
        if (!Objects.equals(this.fechaSalida, other.fechaSalida)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
