/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;


/**
 *Esta clase representa los diferentes servicios que ofrece el hotel
 * @author daniel
 */
public class Servicio extends Producto{
    
    public Servicio(String nombre, float precio, String descripcion) {
        super(nombre, precio, descripcion);
    }

    public String getEstado(){
        
        if (super.isEstado()){
            
            return "Disponible";
        }else{
            return "no disponible";
        }
        
    }
    
   
    public String verServicioDetalle(){
        return "Servicio: " +this.getNombre()+"\nPrecio por dia: "+this.getPrecio()+"\nDescripcion: "+this.getDescripcion()+"\n"+this.getEstado()+" \n";
    
    }
     @Override
    public String toString() {
        return  this.getNombre();
    }

}
