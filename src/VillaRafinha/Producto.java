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

    
    public Producto(String nombre) {
        this.nombre = nombre.toUpperCase();
        this.estado = true;
    }
    
    public Producto(String nombre, float precio) {
        this.nombre = nombre.toUpperCase();
        this.precio = precio;
        this.estado = true;
    }
    
    public Producto(String nombre, float precio, String descripcion) {
        this.nombre = nombre.toUpperCase();
        this.precio = precio;
        this.descripcion = descripcion;
        this.estado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
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



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nombre);
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
        return Objects.equals(this.nombre, other.nombre);
    }

    
    public void hablitar()throws Exception{
        if(!this.estado){
            this.estado=true;
        }
        else{
            System.out.println("La habitacion ya esta habilitada");
        }
    }
    public void deshablitar()throws Exception{
        if(this.estado){
            this.estado=false;
        }
        else{
            System.out.println("Ya esta deshabilitada");
        }
    }
    
    
    
    
}
