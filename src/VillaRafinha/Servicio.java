/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

/**
 *
 * @author daniel
 */
public class Servicio extends Producto{
    
    public Servicio(String nombre, double precio, String descripcion) {
        super(nombre, precio, descripcion);
    }

    public String getEstado(){
        
        if (super.isEstado()){
            
            return "Habilitada";
        }else{
            return "Deshabilitada";
        }
        
    }
    @Override
    public String toString() {
        return "Servicio: " +this.getNombre()+"\nPrecio por dia: "+this.getPrecio()+"\nDescripcion: "+this.getDescripcion()+"\n"+this.getEstado()+" \n";
    }
    
    
    
}
