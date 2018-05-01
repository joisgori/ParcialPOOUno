/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.ArrayList;

/**
 *
 * @author Raul GRanados 00138816
 */
public class GestorProductos {
    private static GestorProductos gestorProductos;
    private ArrayList<Paquete> paquetes;
    private ArrayList<Servicio> servicios;
    private ArrayList<Admin> administradores;

    private GestorProductos() {
        paquetes = new ArrayList<>();
        servicios = new ArrayList<>();
        administradores = new ArrayList<>();
        
    }
    
    public GestorProductos getInstance(){
        if(gestorProductos == null){
            gestorProductos = new GestorProductos();
        }
        
        return gestorProductos;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public ArrayList<Admin> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Admin> administradores) {
        this.administradores = administradores;
    }
    
    public void modificarPaquete(){
        
    }
    
    public void modificarPrecioPaquete(Paquete paquete,float precio){
       // paquete.setPrecio(precio);
    }
    
    

    

    
    
    
}
