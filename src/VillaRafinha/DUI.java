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
public class DUI {

    int[] codigo = new int[8];
    int verificador;
//constructores

    public DUI() {
    }

    public DUI(int verificador) {
        this.verificador = verificador;
    }
//métodos getter

    public int[] getCodigo() {
        return codigo;
    }

    public int getVerificador() {
        return verificador;
    }
//métodos setter

    public void setCodigo(int[] codigo) {
        this.codigo = codigo;
    }

    public void setVerificador(int verificador) {
        this.verificador = verificador;
    }

}
