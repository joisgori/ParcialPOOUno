/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

/**
 * Usuario, Huesped, Persona, TarjetaCredito, Admin
 *
 * @author Josué González <00034715@uca.edu.sv>
 */
public class Usuario extends Persona {

    String usuario;
    String constraseña;
//constructores

    public Usuario() {
    }

    public Usuario(String usuario, String constraseña) {
        this.usuario = usuario;
        this.constraseña = constraseña;
    }
//métodos getter

    public String getUsuario() {
        return usuario;
    }

    public String getConstraseña() {
        return constraseña;
    }
//métodos setter

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
    }
}
