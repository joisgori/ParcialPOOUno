/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class GestorReservaciones {
    
    private ArrayList<Reservacion> reservaciones;
     
        
    public GestorReservaciones(){
        reservaciones= new ArrayList<>();
    }

    public ArrayList<Reservacion> getReservaciones() {
        return reservaciones;
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
    public LocalDate pedirFechar() throws Exception{
        Scanner scanner = new Scanner(System.in);
        String fechaxd;
        LocalDate fecha;
        /*System.out.print("Ingrese anio: ");
        anio = scanner.nextInt();
        System.out.print("Ingrese mes: ");
        mes = scanner.nextInt();
        System.out.print("Ingrse dia: ");
        dia = scanner.nextInt();
        fecha = LocalDate.of(anio, mes, dia);*/
        System.out.println("Ingrese fecha en formato dd/mm/aaaa: ");
        fechaxd = scanner.nextLine();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        

        return LocalDate.parse(fechaxd,formateador);
    }
    public Tipo pedirTipo() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int opc;
        Tipo tipo;
        System.out.println("1. Habitacion sencilla\n2. Habitacion doble");
        System.out.print("Ingrese tipo de habitacion: ");
        opc = scanner.nextInt();
        switch (opc) {
            case 1:
                tipo=Tipo.SENCILLA;
                break;
            case 2:
                tipo=Tipo.DOBLE;
                break;
            default:
                throw new Exception("Ingrese 1 o 2");
        }
        
        

        return tipo;

    }
    
    public boolean pedirPiso(){
        boolean isSuperior;
        int opc;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Piso normal\n2.Dos ultimos pisos");
        System.out.print("Ingrese una opcion: ");
        opc = scanner.nextInt();
        isSuperior = (opc==1);
        return isSuperior;
    }
    /*public String ingresarNombre(){
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        
        return nombre;
    }*/
        
        
    

   
}
