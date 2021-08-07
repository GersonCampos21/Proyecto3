package Actividades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hewlett Packard
 */
public class Jugar extends Actividades {

     public Jugar() {
        this.Cansancio=10;
        this.Entretenimiento=15;
        this.nombre="Jugar";
    }

    public int getCansancio() {
        return Cansancio;
    }

    public int getEntretenimiento() {
        return Entretenimiento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
}
