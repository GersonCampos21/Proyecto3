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
public class Pelear extends Actividades {
    
    public Pelear() {
        this.Cansancio=40;
        this.Entretenimiento=60;
        this.nombre="Pelear";
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
