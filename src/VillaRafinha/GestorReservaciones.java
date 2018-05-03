/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.time.LocalDate;
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
    
    public int getReservacionesDisp(Hospedaje hospedaje, int disponibilidad) throws Exception{
        
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
        if (disponibilidad!=0){
             return disponibilidad;
        }else{
            throw new Exception("No hay disponibilidad");
        }
        
    }

    public void agregarReservacion(Reservacion reservacion) {
        
        reservaciones.add(reservacion);
        System.out.println("Reservacion agregada exitosamente");
        Collections.sort(this.reservaciones);
        

    }
    
    public void verReservaciones(){
        Iterator<Reservacion> it= reservaciones.iterator();
        Reservacion reserv = it.next();
        LocalDate inicio= LocalDate.now();
        LocalDate fin= LocalDate.now().plusDays(7);
        System.out.println("Mostrando desde: "+inicio.toString()+" hasta "+fin.toString()+"\n");
        while(reserv.getEstancia().getFechaLlegada().isBefore(fin)){
            System.out.println(reserv.toString());
            if (it.hasNext()){
                reserv=it.next();
            }else{
                break;
            }
        }
            
          
    }
        
        
    

   
}
