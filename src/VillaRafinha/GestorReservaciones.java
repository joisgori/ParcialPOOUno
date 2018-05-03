/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author daniel
 */
public class GestorReservaciones {
    
    private ArrayList<Reservacion> reservaciones;
     
        
    public GestorReservaciones(){
        reservaciones= new ArrayList<>();
    }
    
    public int getReservacionesDisp(Hospedaje hospedaje, int disponibilidad){
        
        if (this.reservaciones.isEmpty()){
           return disponibilidad;
        }else
        {
            for (Reservacion reserv : reservaciones) {
                if (hospedaje.seIntercecta(reserv.getEstancia()) || hospedaje.contiene(reserv.getEstancia())||hospedaje.equals(reserv.getEstancia())) {
                    disponibilidad--;
                }
            }

        }

         return disponibilidad;
        
    }

    public void agregarReservacion(Reservacion reservacion) {
        
        reservaciones.add(reservacion);
        Collections.sort(this.reservaciones);
        

    }
    
    public void verReservaciones(){
        for (Reservacion reserva: reservaciones){
            System.out.println(reserva.toString());
        }
            
          
    }
        
        
    

   
}
