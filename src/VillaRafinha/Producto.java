/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.Objects;

/**
 *
 * @author Raul Granados 00138816
 */
public class Producto {
    private String nombre;
    private float precio;
    private String descripcion;
    private boolean estado;

    public Producto(String nombre, float precio, String descripcion, boolean estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Float.floatToIntBits(this.precio);
        hash = 79 * hash + Objects.hashCode(this.descripcion);
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
        final Producto other = (Producto) obj;
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }
    
    public void hablitarProducto()throws Exception{
        if(!this.estado){
            this.estado=true;
        }
        else{
            throw new Exception("La habitacion ya esta habilitada");
        }
    }
    public void deshablitarProducto()throws Exception{
        if(this.estado){
            this.estado=false;
        }
        else{
            throw new Exception("La habitacion ya esta deshabilitada");
        }
    }
    
    
    
    
}
