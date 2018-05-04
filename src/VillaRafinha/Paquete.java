/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;
import java.util.ArrayList;
/**
 *
 * @author aacm13
 */
public class Paquete extends Producto{
    
    private ArrayList<Servicio> servicios;
    
    public Paquete(String nombre, double precio, String descripcion, ArrayList<Servicio> servicios) {
        super(nombre, precio, descripcion);
        this.servicios=servicios;
        
    }
    
    public Paquete(String nombre, double precio, ArrayList<Servicio> servicios) {
        super(nombre, precio);
        this.servicios=servicios;
        
    }
    public Paquete(String nombre, double precio) {
        super(nombre, precio);        
    }
    
    public void agregarServicio(Servicio servicio){
        if (!servicios.contains(servicio)){
            this.servicios.add(servicio);
        }else{ System.out.println("GGG"); }
    }
    
    public void quitarServicio(Servicio servicio){
        if (servicios.contains(servicio)){
            this.servicios.remove(servicio);
        }else{ System.out.println("GGG"); }
    
    }
    
   
    
    
   
}
