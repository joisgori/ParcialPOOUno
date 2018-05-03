/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.time.LocalDate;
import java.time.Period;

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

    
    
    
    
}
