/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class GestorHuespedes {
    
    private ArrayList<Huesped> huespedes;

    public GestorHuespedes() {
        huespedes= new ArrayList<>();
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
    
    
    
}
