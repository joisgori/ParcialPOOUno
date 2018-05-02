/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;
import java.util.*;
/**
 *
 * @author aacm13
 */
public class Paquete {
    private tipoPaquete tipo;
    private ArrayList<Servicio> servicio;

    public Paquete() {
    }

    public Paquete(tipoPaquete tipo, ArrayList<Servicio> servicio) {
        this.tipo = tipo;
        this.servicio = servicio;
    }

    public ArrayList<Servicio> getServicio() {
        return servicio;
    }

    public tipoPaquete getTipo() {
        return tipo;
    }

    public void setServicio(ArrayList<Servicio> servicio) {
        this.servicio = servicio;
    }

    public void setTipo(tipoPaquete tipo) {
        this.tipo = tipo;
    }
    
    
    public void agregarServicio(){
        
    }
    public void removerServicio(){
        
    }
    
}
