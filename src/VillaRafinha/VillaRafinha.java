/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.time.LocalDate;

/**
 *
 * @author josue
 */
public class VillaRafinha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorPisosHabitaciones gestor = new GestorPisosHabitaciones();
        LocalDate fecha1 = LocalDate.of(2018, 03, 15);
        LocalDate fecha2 = LocalDate.of(2018, 03, 20);
        LocalDate fecha3 = LocalDate.of(2018, 03, 10);
        LocalDate fecha4 = LocalDate.of(2018, 03, 15);
        LocalDate fecha5 = LocalDate.of(2018, 03, 20);
        LocalDate fecha6 = LocalDate.of(2018, 03, 25);
        Hospedaje hos1 = new Hospedaje(fecha1,fecha2);
        Hospedaje hos2 = new Hospedaje(fecha3,fecha4);
        Hospedaje hos3 = new Hospedaje(fecha5,fecha6);
        
        
    }
    
}
