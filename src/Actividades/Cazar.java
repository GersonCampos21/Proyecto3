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
public class Cazar extends Actividades{
     public Cazar() {
        this.Cansancio=15;
        this.Entretenimiento=25;
        this.nombre="Cazar";
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
