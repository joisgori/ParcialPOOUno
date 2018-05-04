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

    private GestorProductos() {
        paquetes = new ArrayList<>();
        servicios = new ArrayList<>();
        
    }
    
    public static GestorProductos getInstance(){
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
    
    public void agregarServicio(Servicio servicio) throws Exception{
        if (!this.servicios.contains(servicio)){
            servicios.add(servicio);
        }else{
            throw new Exception("Servicio ya existe");
        }
    }
    public void quitarServicio(Servicio servicio) throws Exception{
        if (this.servicios.contains(servicio)){
            servicios.remove(servicio);
        }else{
            throw new Exception("Servicio no existe");
        }
    }
    
    public void agregarPaquete(Paquete paquete) throws Exception{
        if (!this.paquetes.contains(paquete)){
            paquetes.add(paquete);
        }else{
            throw new Exception("Paquete ya existe");
        }
    }
    
    public void quitarPaquete(Paquete paquete) throws Exception{
        if (this.paquetes.contains(paquete)){
            paquetes.remove(paquete);
        }else{
            throw new Exception("Paquete no existe");
        }
    }
    
    public void verPaquetes(){
        for (Paquete paquete:paquetes){
            System.out.println(paquete.toString());
        }
    }
    
    public void verServicios(){
        for (Servicio servicio: servicios){
            System.out.println(servicio.verDetalleServicio());
        }
    }
    
    public Paquete buscarPaquete(String nombre) throws Exception{
        nombre=nombre.toUpperCase();
        for (Paquete paquete: paquetes){
            if (nombre.equals(paquete.getNombre())){
                return paquete;
            }
        }
        throw new Exception("Paquete no existe");
    }
    
    public Servicio buscarServicio(String nombre) throws Exception{
        nombre=nombre.toUpperCase();
        for (Servicio servicio: servicios){
            if (nombre.equals(servicio.getNombre())){
                return servicio;
            }
        }
        throw new Exception("Servicio no existe");
    }
    
    public void cambiarPrecioServicio(Servicio servicio, float nuevoprecio){
        servicio.setPrecio(nuevoprecio);
    }
    
    public void cambiarTasaDescuentoPaquete(Paquete paquete, float tasaDescuento){
        paquete.setTasaDescuento(tasaDescuento);
    }
}
