/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.Objects;

/**
 *
 * @author Josué González <00034715@uca.edu.sv>
 */
public class Persona {

    private String nombre;
    private final String iD;
    private String telefono="";

//constructores


    public Persona(String nombre, String iD, String telefono){
        this.nombre = nombre;
        this.telefono=telefono;
        this.iD=iD;
        }
    
    public Persona(String nombre,String iD){
        this.nombre = nombre;
        this.iD=iD;
        
        }
//métodos getter

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return iD;
    }

    public String getTelefono() {
        return telefono;
    }
//métodos setter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

        @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.iD);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.iD, other.iD)) {
            return false;
        }
        return true;
    }



}
