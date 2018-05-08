package VillaRafinha;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Raul GRanados 00138816
 * Esta clase administra los servicios y productos que un hotel ofrece
 */
public class GestorProductos {
    private static GestorProductos gestorProductos;
    private static ArrayList<Paquete> paquetes;
    private  static ArrayList<Servicio> servicios;
    
    private GestorProductos() {
        paquetes = new ArrayList<>();
        servicios = new ArrayList<>();
        paquetes.add(new Paquete("BASICO","de acceso limitado"));
        paquetes.add(new Paquete("PREMIUM","ACCESO ILIMITADO A CASI TODO"));
        servicios.add(new Servicio("Piscina", (float)12.45,"Acceso a piscina bajo techo"));
        servicios.add(new Servicio("Bar", (float)22.58,"Acceso al bar 24 horas"));
        servicios.add(new Servicio("Area comun", (float)16.75,"Acceso a linda area comun"));
        
    }
    /**
     * Usando patron Singleton
     * @return instancia del gestor
     */
    public static GestorProductos getInstance(){
        if(gestorProductos == null){
            gestorProductos = new GestorProductos();
        }
        
        return gestorProductos;
    }
    //Getters y setters 

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public  void setPaquetes(ArrayList<Paquete> paquetes) {
        GestorProductos.paquetes = paquetes;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        GestorProductos.servicios = servicios;
    }
    
    /**
     * Este metodo obtiene los datos de un nuevo servicio y crea una instancia de la clase
     * @return el servicio con los valores ingresados
     */
    public static Servicio crearServicio(){
        Scanner scanner = new Scanner (System.in);
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese precio por dia: ");
        float precio=scanner.nextFloat();
       
        Servicio servicio = new Servicio(nombre,precio,descripcion);
        return servicio;
    }
    
    /**
     * 
     * @return 
     */
    public static Paquete crearPaquete() throws Exception{
        
        Scanner scanner = new Scanner (System.in);
        int control=0;
        Servicio servicio; 
        ArrayList<Servicio> serviciosPaquete = new ArrayList<>();
       
        System.out.print("Ingrese nombre el paquete: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese una descripcion: ");
        String descripcion = scanner.nextLine();
        
        while(true){
            scanner.nextLine();
            GestorProductos.verServiciosLista();
            System.out.print("Escriba el servicio que desea agregar: ");
            String nombreServ= scanner.nextLine();
            servicio=GestorProductos.buscarServicio(nombreServ);
            serviciosPaquete.add(servicio);
            System.out.print("Presione 1 para terminar, cualquier otra tecla para agregar otro servicio: ");
            control=scanner.nextInt();
            if (control==1){
                break;
            }
                    
        }
        Paquete paquete = new Paquete(nombre, descripcion, serviciosPaquete);
        return paquete;
    }
    /**
     * Este metodo nos permite agregar un servicio a la lista de servicios que ofrece el hotel
     * @param servicio sera el objeto que agregaremos al gestor
     * @throws Exception "Servicio ya existe" en caso de que el servicio ya exista en el sistema
     */
    public static void agregarServicio(Servicio servicio) throws Exception{
        if (!servicios.contains(servicio)){
            servicios.add(servicio);
        }else{
            throw new Exception("Servicio ya existe");
        }
    }
    
    /**
     *Este metodo quita un servicio del gestor  
     * @param servicio es el obejto que removeremos 
     * @throws Exception "Servicio no existe" si el objeto no existe en el sistema
     */
    public static void quitarServicio(Servicio servicio) throws Exception{
        if (servicios.contains(servicio)){
            servicios.remove(servicio);
        }else{
            throw new Exception("Servicio no existe");
        }
    }
    
    /**
     *Este metodo agrega un paquete del gestor  
     * @param paquete es el obejto que removeremos 
     * @throws Exception "Paquete ya existe"si el objeto ya existe en el sistema 
     */
    public static void agregarPaquete(Paquete paquete) throws Exception{
        if (!paquetes.contains(paquete)){
            paquetes.add(paquete);
        }else{
            throw new Exception("Paquete ya existe");
        }
    }
    
    /**
     *Este metodo quita un paquete del gestor  
     * @param paquete es el obejto que removeremos 
     * @throws Exception "Paquete no existe" si el objeto no existe en el sistema 
     */
    public static void quitarPaquete(Paquete paquete) throws Exception{
        if (paquetes.contains(paquete)){
            paquetes.remove(paquete);
        }else{
            throw new Exception("Paquete no existe");
        }
    }
    
    /**
     * Este metodo nos permite ver los paquetes en detalle disponibles en el sistema
     */
    public static void verPaquetes(){
        paquetes.forEach((paquete) -> {
            System.out.println(paquete.toString());
        });
    }
    
    /**
     * Este metodo nos permite ver los servicios en detalle disponibles en el sistema
     */
    public static void verServicios(){
        servicios.forEach((servicio) -> {
            System.out.println(servicio.verServicioDetalle());
        });
    }
    
    /**
     * Este metodo nos permite ver los paquetes en formato lista
     */
    public static void verPaquetesLista(){
        paquetes.forEach((paquete)->{System.out.println("Paquete: "+paquete.getNombre()+"\nPrecio: "+paquete.getPrecio()+"\n");});
    }

    /**
     *Este metodo nos permite ver los servicios en formato lista
     */
    public static void verServiciosLista(){
        servicios.forEach((servicio)->{System.out.println("Servicio: "+servicio.getNombre()+"\nPrecio: "+servicio.getPrecio()+"\n");});
    }
    
    /**
     * Este metodo nos permite buscar un paquete en el gestor de productos
     * @param nombre es el nombre del paquete que se quiere buscar
     * @return el paquete cuyo nombre se recibe como parametro
     * @throws Exception "Paquete no existe" si el paquete no existe en el gestor
     */
    public static Paquete buscarPaquete(String nombre) throws Exception{
        nombre=nombre.toUpperCase();
        for (Paquete paquete: paquetes){
            if (nombre.equals(paquete.getNombre())){
                return paquete;
            }
        }
        throw new Exception("Paquete no existe");
    }
    
    /**
     * Este paquete nos permite buscar un paquete en el gestor de productos
     * @param nombre es el nombre del servicio que se quiere buscar 
     * @return el servicio cuyo nombre se recibe como parametro
     * @throws Exception "Servicio no existe" si el servicio no existe en el gestor
     */
    
    public static Servicio buscarServicio(String nombre){
        nombre=nombre.toUpperCase();
        for (Servicio servicio: servicios){
            if (nombre.equals(servicio.getNombre())){
                return servicio;
            }
        }
        return null;
    }
    
    /**
     * Este metodo nos permite cambiar el precio a un servicio
     * @param servicio el servicio al que queremos poner un nuevo precio
     * @param nuevoprecio el valor del uevo preci que tendra el servicio
     */
    public static void cambiarPrecioServicio(Servicio servicio, float nuevoprecio){
        servicio.setPrecio(nuevoprecio);
    }
    
    /**
     * Este metodo nos permite cambiar la tasa de descuento a un paquete 
     * @param paquete el paquete al que queremos poner un nuevo precio
     * @param tasaDescuento el valor de la nueva tasa de descuento que tendra el paquete 
     */
    public static void cambiarTasaDescuentoPaquete(Paquete paquete, float tasaDescuento){
        paquete.setTasaDescuento(tasaDescuento);
    }

    /**
     * Este metodo nos permite deshabilitar un servicio 
     * @param nombre el nombre del servicio que de deshabilitara
     * @throws Exception 
     */
    public static void deshabilitarServicio(String nombre) throws Exception{
        GestorProductos.buscarServicio(nombre).deshablitar();
    }
}
