/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.Objects;

/**
 *
 * @author raul
 */
public class Habitacion {
    public enum Tipo{
        DOBLE,
        SENCILLA
    }
    Tipo tipo;
    Piso piso;
    int numero;

    public Habitacion(Tipo tipo, Piso piso, int numero) {
        this.tipo = tipo;
        this.piso = piso;
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Piso getPiso() {
        return piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.piso);
        hash = 59 * hash + this.numero;
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
        final Habitacion other = (Habitacion) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.piso, other.piso)) {
            return false;
        }
        return true;
    }
    
    
    
}
