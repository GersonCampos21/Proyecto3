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
public class Volar extends Actividades{
     public Volar() {
        this.Cansancio=12;
        this.Entretenimiento=20;
        this.nombre="Volar";
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
