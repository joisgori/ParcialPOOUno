/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VillaRafinha;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.InputMismatchException;
//import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Usuario, Huesped, Persona, TarjetaCredito, Admin
 *
 * @author Josué González <00034715@uca.edu.sv>
 */
public class Admin extends Persona {

    private String usuario;
    private String constraseña;

    public Admin(String nombre, String iD, String telefono) {
        super(nombre, iD, telefono);
    }

    public Admin() {
        super(null, null);
    }

    public Admin(String usuario, String constraseña, String nombre, String iD) {
        super(nombre, iD);
        this.usuario = usuario;
        this.constraseña = constraseña;
    }

    public Admin(String usuario, String constraseña, String nombre, String iD, String telefono) {
        super(nombre, iD, telefono);
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

    //métodos setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
    }

    public static void opcionReserva() {
        System.out.println("Por favor, a partir de las siguientes opciones indíquenos que desea hacer: ");
        System.out.println("1. Realizar una reservación\n2. Salir");
    }

    public static void opcionTipoHabitacion(int CantidadSeleccionada) {
        /*DEBERÍA HACER UN ARREGLO DE SERVICIOS, PUES ESTOS PUEDEN VARIAR (ARRAYLIST), DE IGUAL LA MATRIZ CON LAS HABITACIONES...
        Y SUS PRECIOS MANDARLOS A LLAMAR CON UN SETTER Y GETTER;*/
        boolean bandera = true;
        int TipoHabitacion, OpcionPaquete;
        Scanner intext = new Scanner(System.in);
        while (bandera) {
            if (CantidadSeleccionada == 1 || CantidadSeleccionada == 2) {
                bandera = false;
                System.out.println("¿Qué tipo de habitación[es] desea?: ");
                System.out.println("1. Sencilla...PRECIO$$\n2. Doble...PRECIO$$");
                TipoHabitacion = intext.nextInt();

                System.out.println("¿Desea agregar un paquete de servicios a su habitación?");
                System.out.println("1. Entre los que se ofrecen está el paquete premium que posee blablabla");
                System.out.println("2. El paquete básico que posee y tiene un precio de ...");
                OpcionPaquete = intext.nextInt();

                System.out.println("Bueno, su reservación ha sido realizada..."); //me falta agregar la fecha, ir haciendo operaciones de precio que van en aumento... y mandandolo
                //a la clase factura, de igual, algunos valores hay que mandarlos a la clase administrador... para que este gestione y rellene con sus métodos los valores de la matriz habitación-
                //Cuando se llegue acá se debe mostrar cuál será su habitación, se deberá tirar el total a pagar finalizados los 7 días
                //no dice nada sobre poder agregar servicicos en el medio de la semana, pero es algo que se puede agregar a futuro.
            } else {
                System.out.println("¡Digíte un número entero que se encuentre entre las opciones por favor!");
                break;
            }
        }

    /**
     *
     * @param args
     */
   

}
    /* public static void main(String[] args) {
        int opcion = 3;
        int CantidadHabitaciones;
        Scanner leer = new Scanner(System.in);

        // TODO code application logic here
        System.out.println("Bienvenido al hotel Villa Rafinha");

        while (opcion != 2) {
            opcionReserva();
            try {       //DEBO AGREGAR UNA OPCIÓN DE EDICIÓN Y PODER CANCELAR LA RESERVACIÓN...
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("<<Por políticas del jefe, un usuario solo puede reservar como máximo dos habitaciones.>>");
                        System.out.println("¿Cuántas habitaciones desea reservar?: ");
                        System.out.println("1. Una habitación\n2. Dos habitaciones");
                        CantidadHabitaciones = leer.nextInt();
                        opcionTipoHabitacion(CantidadHabitaciones);
                        break;
                    case 2:
                        System.out.println("¡Lo esperamos pronto, adiós!");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor ingrese un número");
                leer.nextLine();
            }
        }
     }*/
}
    
