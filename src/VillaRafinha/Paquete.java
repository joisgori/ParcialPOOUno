/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;
import java.util.*;
/**
 *
 * @author aacm13
 */
public class Paquete {
    private tipoPaquete tipo;
    private ArrayList<Servicio> servicio;

    public Paquete() {
    }

    public Paquete(tipoPaquete tipo, ArrayList<Servicio> servicio) {
        this.tipo = tipo;
        this.servicio = servicio;
    }

    public ArrayList<Servicio> getServicio() {
        return servicio;
    }

    public tipoPaquete getTipo() {
        return tipo;
    }

    public void setServicio(ArrayList<Servicio> servicio) {
        this.servicio = servicio;
    }

    public void setTipo(tipoPaquete tipo) {
        this.tipo = tipo;
    }
    
    
    public void agregarServicio(){
        Scanner input= new Scanner(System.in);
        String nombre = input.nextLine();
        float precio = input.nextFloat();
        String descripcion = input.nextLine();
        String e = input.next();
        boolean estado = false;
        if (e == "t" || e == "T"){
            estado = true;
        }else if (e == "f"|| e=="F"){
            estado = false;
        }
        servicio.add(new Servicio(nombre, precio, descripcion, estado));
        
    }
    public void removerServicio(){
        Scanner input= new Scanner(System.in);
        String nombre = input.nextLine();
        float precio = input.nextFloat();
        
        for (int i = 0; i<servicio.size();i++){
            if ((servicio.get(i).getNombre()==nombre)&& (servicio.get(i).getPrecio()==precio)){
                servicio.remove(i);
                System.out.println("El servicio: ");
                System.out.println(servicio.get(i).getNombre() + " | "
                        + servicio.get(i).getPrecio() + " | " 
                        + servicio.get(i).getDescripcion()+" | ");
                System.out.println("A sido removido");
            }
        }
    }
    
}
