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
public class Caminar extends Actividades{

    public Caminar() {
        this.Cansancio=5;
        this.Entretenimiento=10;
        this.nombre="Caminar";
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
