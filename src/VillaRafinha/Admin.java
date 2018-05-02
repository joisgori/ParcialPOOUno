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
public class Admin {
    Usuario usuario;
    int idAdmin;
    
    //constructores

    public Admin() {
    }

    public Admin(Usuario usuario, int idAdmin) {
        this.usuario = usuario;
        this.idAdmin = idAdmin;
    }
    
    //métodos getter

    public Usuario getUsuario() {
        return usuario;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    //métodos setter
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
}
