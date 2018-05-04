/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.util.Scanner;

/**
 *
 * @author rau3
 */
public class Menu {
    private GestorPisosHabitaciones gestor=null;
    private static Menu menu=null;
    
    private Menu() {
        this.gestor  = GestorPisosHabitaciones.getInstance();

    }
    public static Menu getInstance(){
        if(menu==null){
            menu=new Menu();
        }
        return menu;
    }
    public void opciones(){
        System.out.println("1.Hacer Reservacion\n2.Hacer Check In\n3.Hacer Check Out\n");
    }
    public void mostrar() {
        int opc = 40;
        opciones();
        Scanner scanner = new Scanner(System.in);
        
        while (opc!=35) {
            opc = scanner.nextInt(opc);
            switch (opc) {
                case 1:
                    
                    break;
            }
        }

    }
    
    
    
}
