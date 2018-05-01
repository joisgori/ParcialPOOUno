/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

/**
 *
 * @author Josué González <00034715@uca.edu.sv>
 */
public class Persona {

    String nombre;
    DUI dui;
    int telefono;
//constructores

    public Persona() {
    }

    public Persona(String nombre, DUI dui, int telefono) {
        this.nombre = nombre;
        this.dui = dui;
        this.telefono = telefono;
    }
//métodos getter

    public String getNombre() {
        return nombre;
    }

    public DUI getDui() {
        return dui;
    }

    public int getTelefono() {
        return telefono;
    }
//métodos setter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDui(DUI dui) {
        this.dui = dui;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
