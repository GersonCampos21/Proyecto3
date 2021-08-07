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
public class Dormir extends Actividades {
    public Dormir() {
        this.Cansancio=0;
        this.Entretenimiento=0;
        this.nombre="Dormir";
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
