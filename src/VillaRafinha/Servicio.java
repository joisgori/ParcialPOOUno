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
public class Servicio {
    private String servicio;
    private String precio;

    public Servicio() {
    }

    public Servicio(String servicio, String precio) {
        this.servicio = servicio;
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
     
    
}
