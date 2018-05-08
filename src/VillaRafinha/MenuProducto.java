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
 
     public int mostrarMenu(){
         Scanner scanner =new Scanner(System.in);
         int opc;
         System.out.println("Que desea hacer hoy?\n");
         System.out.println("1-Ver paquetes y servicios\n2-Agregar un paquete o servicio\n3-Remover un paquete o servicio\4-Modificar un paquete o servicio\n");
         System.out.print("Opcion: ");
         opc=scanner.nextInt();
         return opc;
     }
     
     public void ejecutarAccion() throws Exception{
         Scanner scanner =new Scanner(System.in);
         int opc=this.mostrarMenu();
         switch (opc){
             
             case 1: 
                 System.out.println("\n1-Ver paquetes\n2-Ver servicios");
                 int opc2=scanner.nextInt();
                 if (opc2==1){
                     GestorProductos.verPaquetes();
                 }else if(opc2==2){
                     GestorProductos.verServicios();
                 }
                 break;
             
             case 2:
                 System.out.println("\n1-Agregar paquete\n2-Agregar servicio");
                 int opc3=scanner.nextInt();
                 if (opc3==1){
                     GestorProductos.agregarPaquete(GestorProductos.crearPaquete());
                 }else if(opc3==2){
                     GestorProductos.agregarServicio(GestorProductos.crearServicio());
                 }
                 break;
                 
             case 3:
                 System.out.println("\n1-Remover paquete\n2-Remover servicio");
                 int opc4=scanner.nextInt();
                 if (opc4==1){
                    String paquete = scanner.nextLine();
                    GestorProductos.quitarPaquete(GestorProductos.buscarPaquete(paquete));
                 }else if(opc4==2){
                    String servicio = scanner.nextLine();
                    GestorProductos.quitarServicio(GestorProductos.buscarServicio(servicio));
                 }
                 break;
         }
                 
                     
     }
     
     
 }
 
