/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VillaRafinha;

/**
 *
 * @author Josué González <00034715@uca.edu.sv>
 */
public class Huesped extends Persona {

    TarjetaCredito[] tarjetaCredito = new TarjetaCredito[8];
//constructores

    public Huesped() {
    }
    
//métodos getter

    public TarjetaCredito[] getTarjetaCredito() {
        return tarjetaCredito;
    }
//métodos setter

    public void setTarjetaCredito(TarjetaCredito[] tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

}
