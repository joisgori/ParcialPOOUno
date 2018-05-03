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
     
        
    public GestorReservaciones(){
        reservaciones= new ArrayList<>();
    }
    
    public int getReservacionesDisp(Hospedaje hospedaje, int disponibilidad){
        Iterator<Reservacion> it = this.reservaciones.iterator();
        int contador = 0;
        Hospedaje hos1;
        
        if (!it.hasNext()){
           return disponibilidad;
        }else{
        
        hos1 = it.next().getEstancia();
        
        
        /*if (!it.hasNext()){
            
            return disponibilidad;
        }*/
        
                
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
        return disponibilidad-contador;
    }
    
    public boolean agregarReservacion(Reservacion reservacion){
        Iterator<Reservacion> it = this.reservaciones.iterator();
        Hospedaje hos1;
        if(!it.hasNext()){
            this.reservaciones.add(reservacion);
            return true;
        }
        hos1=it.next().getEstancia();
        if(!it.hasNext()){
            if(hos1.getFechaLlegada().isBefore(reservacion.getEstancia().getFechaLlegada())){
                reservaciones.add(reservacion);
                return true;
            }else{
                reservaciones.add(0, reservacion);
                return true;
            }
        }else{
            
            while(it.hasNext()){
                if(hos1.getFechaLlegada().isBefore(reservacion.getEstancia().getFechaLlegada())){
                    hos1=it.next().getEstancia();
                }else{
                    reservaciones.add(reservaciones.indexOf(hos1),reservacion);
                    return true;
                }
            }
        }
        return true;
    }
    
    public void verReservaciones(){
        for (Reservacion reserva: reservaciones){
            System.out.println(reserva.toString());
        }
            
          
        }
        
        
    

   
}
