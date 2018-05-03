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
    private Tipo tipo;
    
    
    public Hospedaje(LocalDate fLlegada, LocalDate fSalida, Tipo tipo) throws Exception {

        Period periodo = Period.between(fLlegada, fSalida);
        if (periodo.getDays()<7 && !fLlegada.equals(fSalida)){
            this.fechaLlegada = fLlegada;
            this.fechaSalida = fSalida;
            this.numDias = periodo.getDays();
            this.tipo = tipo;
        }else {
            throw new Exception ("Entrada de datos invalida");
        }
    }
    
  

    
    
    public Hospedaje(LocalDate fLlegada, int numDias){
        this.fechaLlegada=fLlegada;
        this.fechaSalida=fechaLlegada.plusDays(numDias);
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.fechaLlegada);
        hash = 41 * hash + Objects.hashCode(this.fechaSalida);
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

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public int getNumDias() {
        return numDias;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
    
    public boolean seIntercecta(Hospedaje hospedaje){
        if(this.fechaLlegada.isAfter(hospedaje.fechaLlegada)&&this.fechaLlegada.isBefore(hospedaje.fechaSalida)){
            return true; 
        }else if(this.fechaSalida.isAfter(hospedaje.fechaLlegada)&&this.fechaSalida.isBefore(hospedaje.fechaSalida)){
            return true;
        }
        return false;
    }
    
    public boolean contiene(Hospedaje hospedaje){
        if (hospedaje.fechaLlegada.isAfter(this.fechaLlegada)&&hospedaje.fechaSalida.isBefore(this.fechaSalida)){
            return true;
        }
        return false;
    }
    
    public boolean llegaAntes(Hospedaje hospedaje){
        if(hospedaje.fechaLlegada.isBefore(this.fechaLlegada)){
            return true;
        }
        return false;
    }

    
    
    
    
}
