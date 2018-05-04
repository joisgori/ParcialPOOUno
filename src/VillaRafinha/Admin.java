/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Usuario, Huesped, Persona, TarjetaCredito, Admin
 *
 * @author Josué González <00034715@uca.edu.sv>
 */
public class Usuario extends Persona {

    private final String usuario;
    private String constraseña;
    private ArrayList<Persona> usuarios;

//constructores
    public Usuario(String usuario, String constraseña, String nombre, String iD) {
        super(nombre, iD);
        this.usuario = usuario;
        this.constraseña = constraseña;
        usuarios = new ArrayList<Persona>();
    }

//métodos getter
    public String getUsuario() {
        return usuario;
    }

    public String getConstraseña() {
        return constraseña;
    }

    public ArrayList<Persona> getUsuarios() {
        return usuarios;
    }

//métodos setter


    public void setUsuarios(ArrayList<Persona> usuarios) {
        this.usuarios = usuarios;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
    }

    //métodos de uso reales
    //método para agregar empleados administrador, estos tendrán un su usuario y contaseña; será un máximo de 3 administradores
    public void add() {
        Persona usuario = new Persona(constraseña, constraseña);
        
        usuarios.add(usuario);
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese su nombre de usuario y contraseña");
        
    }
}

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
}
