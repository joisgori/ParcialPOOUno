
import VillaRafinha.GestorProductos;
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
     private final Scanner scanner =new Scanner(System.in);
     private final GestorProductos gestorProductos= GestorProductos.getInstance(); 

    public MenuProducto() {
    }
 
     public int mostrarMenu(){
         int opc;
         System.out.println("Que desea hacer hoy?\n");
         System.out.println("1-Ver paquetes y servicios\n2-Agregar un paquete o servicio\n3-Remover un paquete o servicio\4-Remover un paquete o servicio\n");
         System.out.print("Opcion: ");
         opc=scanner.nextInt();
         return opc;
     }
     
     public void ejecutarAccion(int opc){
         
         switch (opc){
             
             case 1:
         }
                 
                     
     }
     
     
 }
 
