/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author daw-B
 */
public class PC extends Equipo{
    private String ssoo;
    private String tipo; //Sobremesa o portatil

    public PC(String ssoo, String tipo, String cod, String ubicacion, double precio, boolean protegido) {
        super(cod, ubicacion, precio, protegido);
        this.ssoo = ssoo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " PC{" + "ssoo=" + ssoo + ", tipo=" + tipo + '}';
    }


}
