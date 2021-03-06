package VillaRafinha;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
/**
 *
 * @author Josué González <00034715@uca.edu.sv>
 */
 
 public class MenuProducto {
 //Esta clase será usada para generar los gestores de la clase de menu producto
     private static MenuProducto menuProducto;
     private  GestorProductos gestorProductos; 

    private MenuProducto() {
        gestorProductos= GestorProductos.getInstance();
    }
    public static MenuProducto getInstance(){
        if(menuProducto ==null){
            menuProducto = new MenuProducto();
            
        }
        return menuProducto;
    }

    public GestorProductos getGestorProductos() {
        return gestorProductos;
    }
    
 
     public int mostrarMenu(){
         Scanner scanner =new Scanner(System.in);
         int opc;
         System.out.println("Que desea hacer hoy?\n");
         System.out.println("1-Ver paquetes y servicios\n2-Agregar un paquete o servicio\n3-Remover un paquete o servicio\n4-Modificar un paquete\n5-Modificar un servicio\n");
         System.out.print("Opcion: ");
         opc=scanner.nextInt();
         return opc;
     }
     
     public void ejecutarAccion() throws Exception{
         int opc=this.mostrarMenu();
         switch (opc){
             
             case 1: 
                 Scanner scanner1 =new Scanner(System.in);
                 System.out.println("\n1-Ver paquetes\n2-Ver servicios");
                 System.out.print("Opcion: ");
                 int opc2=scanner1.nextInt();
                 if (opc2==1){
                     GestorProductos.verPaquetes();
                 
                 }else if(opc2==2){
                 
                     GestorProductos.verServicios();
                 }
                 break;
             
             case 2:
                 Scanner scanner2 =new Scanner(System.in);
                 System.out.println("\n1-Agregar paquete\n2-Agregar servicio");
                 System.out.print("Opcion: ");
                 int opc3=scanner2.nextInt();
                 if (opc3==1){
                     GestorProductos.agregarPaquete(GestorProductos.crearPaquete());
                 
                 }else if(opc3==2){
                 
                     GestorProductos.agregarServicio(GestorProductos.crearServicio());
                 }
                 break;
                 
             case 3:
                 Scanner scanner3 =new Scanner(System.in);
                 System.out.println("\n1-Remover paquete\n2-Remover servicio");
                 System.out.print("Opcion: ");         
                 int opc4=scanner3.nextInt();
                 if (opc4==1){
                     
                    GestorProductos.verPaquetesLista();
                    String paquete = scanner3.nextLine();
                    GestorProductos.quitarPaquete(GestorProductos.buscarPaquete(paquete));
                 
                 }else if(opc4==2){
                    
                    GestorProductos.verServiciosLista();
                    scanner3.nextLine();
                    String servicio = scanner3.nextLine();
                    GestorProductos.quitarServicio(GestorProductos.buscarServicio(servicio));
                 }
                 break;
                 
             case 4:
                 Scanner scanner4 =new Scanner(System.in);
                 System.out.println("1-Agregar servicio\n2-Quitar Servicio\n3-Modificar la tasa de descuento'");
                 System.out.print("Opcion: ");
                 int opc5=scanner4.nextInt();
                 if(opc5==1){
                     GestorProductos.verPaquetesLista();
                     System.out.print("Paquete: ");
                     String paquete=scanner4.nextLine();
                     GestorProductos.verServiciosLista();
                     System.out.print("Servicio: ");
                     String servicio=scanner4.nextLine();
                     GestorProductos.buscarPaquete(paquete).agregarServicio(GestorProductos.buscarServicio(servicio));
                 
                 }else if(opc5==2){
                 
                     GestorProductos.verPaquetesLista();
                     System.out.print("Paquete: ");
                     String paquete=scanner4.nextLine();
                     GestorProductos.verServiciosLista();
                     System.out.print("Servicio: ");
                     String servicio=scanner4.nextLine();
                     GestorProductos.buscarPaquete(paquete).quitarServicio(GestorProductos.buscarServicio(servicio));
                 
                 }else if(opc5==3){
                 
                     String paquete;
                     float tasaDescuento;
                     GestorProductos.verPaquetesLista();
                     System.out.print("Paquete: ");
                     paquete=scanner4.nextLine();
                     System.out.print("Nueva tasa de descuento: ");
                     tasaDescuento=scanner4.nextFloat();
                     GestorProductos.buscarPaquete(paquete).setTasaDescuento(tasaDescuento);
                 }
             
             case 5:
                 Scanner scanner5 =new Scanner(System.in);
                 System.out.println("1-Cambiar precio\n2-Cambiar descripcion");
                 System.out.print("Opcion: ");
                 int opc6=scanner5.nextInt();
                 if (opc6==1){
                     float precio;
                     String servicio;
                     GestorProductos.verServiciosLista();
                     System.out.print("Servicio: ");
                     servicio=scanner5.nextLine();
                     System.out.print("Nuevo precio: ");
                     precio=scanner5.nextFloat();
                     GestorProductos.buscarServicio(servicio).setPrecio(precio);
                     
                 }else if(opc6==2){
                     String descripcion;
                     String servicio;
                     GestorProductos.verServiciosLista();
                     System.out.print("Servicio: ");
                     servicio=scanner5.nextLine();
                     System.out.print("Nuevo descripcion: ");
                     descripcion=scanner5.nextLine();
                     GestorProductos.buscarServicio(servicio).setDescripcion(descripcion);
                     
                 }
                 
                 
         }
                 
                     
     }
     
     
 }
 
