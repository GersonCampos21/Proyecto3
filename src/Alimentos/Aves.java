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
public class Aves extends Alimentos{
   public Aves() {
        this.Energy=15;
        this.Satisfaccion=15;
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
//Iniciar regerenacion
    @Override
    public void regeneracion() {
        this.disponible=false;
        this.TiempoCarga = new Tiempo(0,0,40); 
    }   
}
