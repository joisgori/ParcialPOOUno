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
public class Huesped extends Persona {
 //constructores
    
    public Huesped(String nombre, String iD) {
        super(nombre, iD);
    }
    public Huesped(String nombre,String iD, String telefono) {
        super(nombre, telefono);
    }


    @Override
    public String toString() {
        return "Huesped: " +this.getNombre()+"\nCodigo: "+this.getId()+"\nTelefono: "+this.getTelefono();
    }
    
    

    
}
