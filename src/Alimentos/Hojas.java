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
public class Hojas extends Alimentos {

    public Hojas() {
        this.Energy=5;
        this.Satisfaccion=5;
        this.TiempoCarga= new Tiempo(0,0,0);
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

    @Override
    public void regeneracion() {
        this.disponible=false;
        this.TiempoCarga = new Tiempo(0,0,10); 
    }
    
}
