/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VillaRafinha;
import java.time.LocalDate;

/**
 *
 * @author Josué González <00034715@uca.edu.sv>
 */
public class TarjetaCredito {

    int numero;
    LocalDate fechaExp;
    int cvv;
    Huesped titular;

    //constructor vacío
    public TarjetaCredito() {
    }

    //constructor con argumentos
    public TarjetaCredito(int numero, LocalDate fechaExp, int cvv, Huesped titular) {
        this.numero = numero;
        this.fechaExp = fechaExp;
        this.cvv = cvv;
        this.titular = titular;
    }

    //métodos getter
    public int getNumero() {
        return numero;
    }

    public LocalDate getFechaExp() {
        return fechaExp;
    }

    public int getCvv() {
        return cvv;
    }

    public Huesped getTitular() {
        return titular;
    }

    //métodos setter
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFechaExp(LocalDate fechaExp) {
        this.fechaExp = fechaExp;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setTitular(Huesped titular) {
        this.titular = titular;
    }
}
