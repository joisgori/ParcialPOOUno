/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Raul Granados 00138816
 */
public class Habitacion extends Producto{
    
    private Tipo tipo;
    private Piso piso;
    private int numero;
    private boolean estado;
    private ArrayList <Hospedaje> hospedajesHabitacion = new ArrayList();

    

    public Habitacion(Tipo tipo, Piso piso, int numero, boolean habilitacion, String nombre, float precio, String descripcion, boolean estado) {
        super(nombre, precio, descripcion, estado);
        this.tipo = tipo;
        this.piso = piso;
        this.numero = numero;
      
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public ArrayList<Hospedaje> getHospedajesHabitacion() {
        return hospedajesHabitacion;
    }

    public void setHospedajesHabitacion(ArrayList<Hospedaje> hospedajesHabitacion) {
        this.hospedajesHabitacion = hospedajesHabitacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.tipo);
        hash = 53 * hash + Objects.hashCode(this.piso);
        hash = 53 * hash + this.numero;
        hash = 53 * hash + (this.estado ? 1 : 0);
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
        if (this.estado != other.estado) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.piso, other.piso)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
