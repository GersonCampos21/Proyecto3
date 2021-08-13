/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtributosVitales;

import Tiempo.Tiempo;

/**
 *
 * @author Hewlett Packard
 */
public class Salud {
    private boolean Enfermo;
    private Tiempo tiempoEnfermo;

    public Salud() {
        this.Enfermo = false;
        this.tiempoEnfermo =new Tiempo(0,0,0) ;
    }

    public Tiempo getTiempoEnfermo() {
        return tiempoEnfermo;
    }
    
    public boolean isEnfermo() {
        return Enfermo;
    }

    public void setEnfermo(boolean Enfermo) {
        this.Enfermo = Enfermo;
    }

    public void iniciarTiempoEnfermo() {
        this.tiempoEnfermo.Avanzar();
    }
    
    public boolean inicioEnfermo() {
       return this.tiempoEnfermo.termino();
    }

    public void reinciarTiempoEnfermo() {
        this.tiempoEnfermo = new Tiempo(0,0,0);
    }
    
}
