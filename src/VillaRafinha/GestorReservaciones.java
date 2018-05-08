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
    private static GestorReservaciones gestorReservaciones;
    //private static int precioBase;

    private GestorReservaciones() {
        reservaciones = new ArrayList<>();
        //GestorReservaciones.precioBase = 80;
    }

    public static GestorReservaciones getInstance() {
        if (gestorReservaciones == null) {
            gestorReservaciones = new GestorReservaciones();
        }
        return gestorReservaciones;
    }

    /*public int getPrecioBase() {
        return precioBase;
    }*/

    /*public void setPrecioBase(int precioBase) {
        GestorReservaciones.precioBase = precioBase;
    }*/

    public ArrayList<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public int getReservacionesDisp(Hospedaje hospedaje, int disponibilidad) {

        if (this.reservaciones.isEmpty()) {
            return disponibilidad;
        } else {
            for (Reservacion reserv : reservaciones) {
                if (hospedaje.getTipo() == reserv.getEstancia().getTipo()) {
                    if (reserv.getEstancia().equals(hospedaje)) {
                        disponibilidad--;
                    } else if (reserv.getEstancia().llegaDurante(hospedaje) || reserv.getEstancia().saleDurante(hospedaje)) {
                        disponibilidad--;
                    } else if (reserv.getEstancia().llegaAntes(hospedaje) && reserv.getEstancia().saleDespues(hospedaje)) {
                        disponibilidad--;
                    } else if (hospedaje.llegaDurante(reserv.getEstancia()) || hospedaje.saleDurante(reserv.getEstancia())) {
                        disponibilidad--;
                    } else if (hospedaje.llegaAntes(reserv.getEstancia()) && hospedaje.saleDespues(reserv.getEstancia())) {
                        disponibilidad--;
                    }
                }
                if (disponibilidad == 0) {
                    System.out.println("NO HAY DISPONIBILIDAD");
                    return disponibilidad;
                }
            }
            System.out.println("Hay " + disponibilidad + " habitaciones disponibles");
            return disponibilidad;
        }
    }

    public void agregarReservacion(Reservacion reservacion) {

        reservaciones.add(reservacion);
        System.out.println("Reservacion agregada exitosamente");
        Collections.sort(this.reservaciones);
    }

    public void verReservaciones() {
        Iterator<Reservacion> it = reservaciones.iterator();
        Reservacion reserv = it.next();

        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusDays(7);

        System.out.println("Mostrando desde: " + inicio.toString() + " hasta " + fin.toString() + "\n");

        while (reserv.getEstancia().getFechaLlegada().isBefore(fin)) {
            System.out.println(reserv.toString());
            if (it.hasNext()) {
                reserv = it.next();
            } else {
                break;
            }
        }
    }
    public void verTodasReservaciones() {
        reservaciones.forEach((reservacion) -> {
            reservacion.toString();
        });

    }

    public LocalDate pedirFechar() throws Exception {
        
        String fecha;
        Scanner scanfecha = new Scanner(System.in);
        System.out.println("Ingrese fecha en formato dd/mm/aaaa: ");
        fecha = scanfecha.nextLine();
        String[] fechaPartida = fecha.split("/");
        int dia = Integer.parseInt(fechaPartida[0]);
        int mes = Integer.parseInt(fechaPartida[1]);
        int anio = Integer.parseInt(fechaPartida[2]);
        if (dia <= 31 && mes <= 12 && anio <= 3000) {

            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            return LocalDate.parse(fecha, formateador);
        } else {
            throw new Exception("Ingrese una fecha valida");
        }
    }

    public int pedirnum() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numdias;

        System.out.println("Ingrese cantidad de días en número entero: ");
        numdias = scanner.nextInt();
        return numdias;
    }

    public Tipo pedirTipo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opc;
        Tipo tipo;
        System.out.println("\n1. Habitacion sencilla\n2. Habitacion doble");
        System.out.print("Ingrese tipo de habitacion: ");

        opc = scanner.nextInt();
        switch (opc) {
            case 1:
                tipo = Tipo.SENCILLA;
                break;
            case 2:
                tipo = Tipo.DOBLE;
                break;
            default:
                throw new Exception("Ingrese 1 o 2");
        }

        return tipo;

    }

    public boolean pedirPiso() {
        Scanner scanner = new Scanner(System.in);
        boolean isSuperior;
        int opc;

        System.out.println("\n1. Piso normal\n2.Pisos superiores");
        System.out.print("Ingrese una opcion: ");
        opc = scanner.nextInt();
        isSuperior = !(opc == 1);
        return isSuperior;
    }

    public Reservacion buscarReservacionNomTel(String nombre, String telefono) throws Exception {
        for (Reservacion r : this.reservaciones) {
            if (r.getHuesped().getNombre().equals(nombre) && r.getHuesped().getTelefono().equals(telefono)) {
                return r;

            }

        }
        throw new Exception("No se encuentra esa reservacion");
    }

    public Reservacion buscarReservacionNombre(String nombre) throws Exception {
        for (Reservacion r : this.reservaciones) {
            if (r.getHuesped().getNombre().equals(nombre)) {
                return r;
            }
        }
        throw new Exception("No se encuentra esa reservacion");
    }

}
