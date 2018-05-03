/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author daniel
 */
public class GestorReservaciones {
    
    private ArrayList<Reservacion> reservaciones;
    private Iterator<Reservacion> it; 
        
    public GestorReservaciones(){
        reservaciones= new ArrayList<>();
    }
    
    public boolean getReservacionesDisp(Hospedaje hospedaje, int disponibilidad){
        
        int contador = 0;
        
        if (!it.hasNext()){
           return true;
        }
        it = this.reservaciones.iterator();
        Hospedaje hos1 = it.next().getEstancia();
        Hospedaje hos2;
        
        if (!it.hasNext()){
            return true;
        }
        else{
                
            while (it.hasNext()){
                if (hos1.getTipo() == hospedaje.getTipo()) {
                    if (hospedaje.getFechaLlegada().getMonthValue()== hos1.getFechaLlegada().getMonthValue()) {
                        if (hospedaje.getFechaLlegada().isAfter(hos1.getFechaLlegada()) && hospedaje.getFechaLlegada().isBefore(hos1.getFechaSalida())) {
                            contador++;

                        } else if (hospedaje.getFechaSalida().isBefore(hos1.getFechaSalida()) && hospedaje.getFechaSalida().isAfter(hos1.getFechaLlegada())) {
                            contador++;
                        }else if (hospedaje.getFechaLlegada().isBefore(hos1.getFechaLlegada())&& (hospedaje.getFechaSalida().isAfter(hos1.getFechaLlegada())||hospedaje.getFechaSalida().equals(hos1.getFechaLlegada()))){
                            contador++;   
                        }
                    } else if (hospedaje.getFechaLlegada().getMonthValue() < hos1.getFechaLlegada().getMonthValue()) {
                        break;
                    }
                }
                hos1 = it.next().getEstancia();
            }
        
        }
        if (contador!=disponibilidad){
            return true;
        }else{
            return false;
        }
    }
    
    public void agregarReservacion(Reservacion reservacion){
        it = this.reservaciones.iterator();
        
        if(!it.hasNext()){
            reservaciones.add(reservacion);
        }
        Hospedaje hos1=it.next().getEstancia();
        if(!it.hasNext()){
            if(hos1.getFechaLlegada().isBefore(reservacion.getEstancia().getFechaLlegada())){
                reservaciones.add(reservacion);
            }else{
                reservaciones.add(0, reservacion);
            }
        }else{
            
            while(it.hasNext()){
                if(hos1.getFechaLlegada().isBefore(reservacion.getEstancia().getFechaLlegada())){
                    hos1=it.next().getEstancia();
                }else{
                    reservaciones.add(reservaciones.indexOf(hos1),reservacion);
                }
            }
        }
    }
    
    public void verReservaciones(){
        Iterator<Reservacion> it = this.reservaciones.iterator();
        while(it.hasNext()){
            
          
        }
        
        
    }

   
}
