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
 * @author aacm13
 */
public class Paquete extends Producto{
    
    private ArrayList<Servicio> servicios;
    private float tasaDescuento=(float)0.2;
    
    public Paquete(String nombre, float precio, String descripcion, ArrayList<Servicio> servicios) {
        super(nombre, precio, descripcion);
        this.servicios=servicios;        
    }

    public Paquete(String nombre, float precio, ArrayList<Servicio> servicios) {
        super(nombre, precio);
        this.servicios=servicios;
    }
    
    public Paquete(String nombre, float precio, float tasaDescuento) {
        super(nombre, precio);
        this.servicios=new ArrayList<>();
        this.tasaDescuento=tasaDescuento;
    }
    
    public Paquete(String nombre, float precio) {
        super(nombre, precio);
        this.servicios=new ArrayList<>();        
    }

    public float getTasaDescuento() {
        return tasaDescuento;
    }

    public void setTasaDescuento(float tasaDescuento) {
        this.tasaDescuento = tasaDescuento;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.servicios);
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
        final Paquete other = (Paquete) obj;
        if (!Objects.equals(this.servicios, other.servicios)) {
            return false;
        }
        return true;
    }
    
    public void agregarServicio(Servicio servicio) throws Exception{
        if (!servicios.contains(servicio)){
            this.servicios.add(servicio);
            this.calcularPrecio();
        }else{ 
            throw new Exception("Servicio ya esta en paquete");
        }
    }
    
    public void quitarServicio(Servicio servicio) throws Exception{
        if (servicios.contains(servicio)){
            this.servicios.remove(servicio);
            this.calcularPrecio();
        }else{ 
            throw new Exception("Servicio no esta en paquete");
        }
    
    }
    
    public void calcularPrecio(){
        double precio=0;
        for (Servicio servicio:servicios){
            precio=precio+servicio.getPrecio();
        }
        super.setPrecio((float)precio-(float)precio*this.tasaDescuento);
    }

    @Override
    public String toString() {
        return "Paquete: \n" + "Nombre: "+this.getNombre()+"\nPrecio: "+this.getPrecio()+"\nServicios:\n" + servicios + "\n";
    }
    
   
    
    
   
}
