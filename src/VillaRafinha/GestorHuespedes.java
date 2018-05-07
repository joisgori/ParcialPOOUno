/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author daniel
 */
public class GestorHuespedes {
    private static GestorHuespedes gestorHuespedes;
    private static ArrayList<Huesped> huespedes;

    private GestorHuespedes() {
        huespedes= new ArrayList<>();
    }
    public static GestorHuespedes getInstance(){
        if(gestorHuespedes == null){
            gestorHuespedes = new GestorHuespedes();
        }
        return gestorHuespedes;
    }
    
    public void agregarHuesped(Huesped huesped) throws Exception{
        if (!huespedes.contains(huesped)){
            huespedes.add(huesped);
            System.out.println("Huesped agregado exitosamente");
        }else {
            throw new Exception("Huesped ya esta registrado");
        }
    }
    
    public void verHuespedes(){
        for (Huesped huesped: huespedes){
            System.out.println(huesped.toString()+"\n");
        }
    }
    public Huesped crearHuesped(){
        Huesped hues;
        Scanner scanner = new Scanner(System.in);
        String nombre, iD, telefono;
        System.out.println("ingrese datos del huesped: ");
        System.out.print("Ingrese nombre: ");
        nombre = scanner.nextLine();
        iD = UUID.randomUUID().toString().toUpperCase().substring(0, 5);
        System.out.print("Ingrese telefono: ");
        telefono = scanner.nextLine();
        hues = new Huesped(nombre,iD,telefono);
        
        return hues;
    }
    
    
    
}
