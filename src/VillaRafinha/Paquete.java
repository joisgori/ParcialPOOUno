package VillaRafinha;
import java.util.ArrayList;
import java.util.Objects;
/**
 *Esta clase representa los diferentes paquetes que ofrece el hotel
 * @author aacm13
 */
public class Paquete extends Producto{
    
    private ArrayList<Servicio> servicios=new ArrayList<>();
    private float tasaDescuento=(float)0.2;
    
    //Constructores
    public Paquete(String nombre, String descripcion, ArrayList<Servicio> servicios) {
        super(nombre, descripcion);
        this.servicios=servicios;
     }
    public Paquete(String nombre, String descripcion) {
        super(nombre, descripcion);
        //this.servicios=servicios;
     }

    
    //setters y getters
    public float getTasaDescuento() {
        return tasaDescuento;
    }

    public void setTasaDescuento(float tasaDescuento) {
        this.tasaDescuento = tasaDescuento;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    
    //equals y hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.servicios);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paquete other = (Paquete) obj;
        return Objects.equals(this.servicios, other.servicios);
    }
    
    /**
     *Este metodo nos permite agregar un servicios a la lista de incluidos con el paquete 
     * @param servicio Es el servicio que agregaremos
     * @throws Exception "Servicio ya esta en el paquete" en caso de que el servicio ya este incluido
     */
    public void agregarServicio(Servicio servicio) throws Exception{
        if (this.servicios.isEmpty()){
            this.servicios.add(servicio);
            System.out.println("Servicio agregado con exito");
            this.calcularPrecio();
        }
        else if (!this.servicios.contains(servicio)){
            this.servicios.add(servicio);
            System.out.println("Servicio agregado con exito");
            this.calcularPrecio();
        }else{ 
            throw new Exception("Servicio ya esta en paquete");
        }
    }
    
    /**
     *Este metodo nos permite remover un servicios de la lista de incluidos con el paquete 
     * @param servicio Es el servicio que removeremos
     * @throws Exception "Servicio no esta en el paquete" en caso de que el servicio no este incluido
     */
    public void quitarServicio(Servicio servicio) throws Exception{
        if (servicios.contains(servicio)){
            this.servicios.remove(servicio);
            this.calcularPrecio();
        }else{ 
            throw new Exception("Servicio no esta en paquete");
        }
    
    }
    
    /**
     * Este metodo calcula el precio del paquete sumando el precio de todos los servicios y restandole el porcentaje
     * establecido por medio de la tasa de descuento
     */
    private void calcularPrecio(){
        
        this.servicios.forEach((servicio) -> {
            this.precio=precio+=servicio.getPrecio();
        });
   }

    //toString
    @Override
    public String toString() {
        return "Paquete: \n" + "Nombre: "+this.getNombre()+"\nPrecio: "+this.precio+"\nServicios:\n" + servicios + "\n";
    }
    
   
    
    
   
}
