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
    private String nivel;
    private int numero;
    private ArrayList <Hospedaje> hospedajesHabitacion = new ArrayList();

    

    public Habitacion(Tipo tipo, String nivel, int numero, String nombre, float precio, String descripcion, boolean estado) {
        super(nombre, precio, descripcion, estado);
        this.tipo = tipo;
        this.nivel = nivel;
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nivel);
        hash = 73 * hash + this.numero;
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
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        return true;
    }
    
}
