package Alimentos;


import Tiempo.Tiempo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hewlett Packard
 */
public abstract class Alimentos {
    protected Tiempo TiempoCarga;
    protected int Energy;
    protected int Satisfaccion;
    protected boolean disponible;

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Tiempo getTiempoCarga() {
        return TiempoCarga;
    }

    public int getEnergy() {
        return Energy;
    }

    public int getSatisfaccion() {
        return Satisfaccion;
    }

    public abstract void regeneracion();
    
    public void habilitar(){
        this.setDisponible(true);
    }

     
    
}
