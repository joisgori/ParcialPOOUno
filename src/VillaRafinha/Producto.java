package VillaRafinha;

import java.util.Objects;

/**
 *Esta clase es una abstarccion de los diferentes productos que ofrece el hotel
 * @author Raul Granados 00138816
 */
public class Producto {
    
    private String nombre;

    /**
     *
     */
    protected float precio;
    private String descripcion;
    private boolean estado;

    //Contructores con diferentes parametros
    public Producto(String nombre) {
        this.nombre = nombre.toUpperCase();
        this.estado = true;
    }
    
    public Producto(String nombre, float precio) {
        this.nombre = nombre.toUpperCase();
        this.precio = precio;
        this.estado = true;
    }
    
    public Producto(String nombre, String descripcion) {
        this.nombre = nombre.toUpperCase();
        this.descripcion = descripcion;
        this.estado = true;
    }
    
    public Producto(String nombre, float precio, String descripcion) {
        this.nombre = nombre.toUpperCase();
        this.precio = precio;
        this.descripcion = descripcion;
        this.estado = true;
    }
    
    //setters y getters
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


    //equals y hashcode
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

    /**
     * Este metodo nos permite cambiar el estado del producto a true, habilitado
     * @throws Exception "Producto ya habilitado"
     */
    public void hablitar()throws Exception{
        if(!this.estado){
            this.estado=true;
        }
        else{
            System.out.println(this.getClass()+" ya habilitado");
        }
    }
    
    /**
     * Este metodo nos permite cambiar el estado del producto a false, deshabilitado
     * @throws Exception "Producto ya deshabilitado"
     */
    public void deshablitar()throws Exception{
        if(this.estado){
            this.estado=false;
        }
        else{
            System.out.println(this.getClass()+"ya esta deshabilitada");
        }
    }
    
    
    
    
}
