/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

import Actividades.Actividades;
import Actividades.Caminar;
import Actividades.Cazar;
import Actividades.Dormir;
import Actividades.Enfermar;
import Actividades.Jugar;
import Actividades.Pelear;
import Actividades.Volar;
import Alimentos.Alimentos;
import FactoryMethod.Creadora;

/**
 *
 * @author Hewlett Packard
 */
public class CreadorActividades implements Creadora<Actividades> {

    public static final int CAMINAR = 1;
    public static final int JUGAR = 2;
    public static final int CAZAR = 3;
    public static final int PELEAR = 4;
    public static final int VOLAR = 5;
    public static final int DORMIR = 6;
    public static final int ENFERMAR=7;

    @Override
    public Actividades creador(int tipo) {
        switch (tipo) {
            case CreadorActividades.CAMINAR -> {
                return new Caminar();
            }
            case CreadorActividades.JUGAR -> {
                return new Jugar();
            }
            case CreadorActividades.CAZAR -> {
                return new Cazar();
            }
            case CreadorActividades.PELEAR -> {
                return new Pelear();
            }
            case CreadorActividades.VOLAR -> {
                return new Volar();
            }
            case CreadorActividades.DORMIR -> {
                return new Dormir();
            }
            case CreadorActividades.ENFERMAR -> {
                return new Enfermar();
            }
        }
        return null;
    }
}
