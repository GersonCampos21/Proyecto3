/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

import State.Adulto;
import State.Bebe;
import State.Huevo;
import State.Joven;
import State.State;

/**
 *
 * @author Hewlett Packard
 */
public class CrearEstados implements Creadora<State> {
 public static final int HUEVO = 1;
    public static final int BEBE = 2;
    public static final int JOVEN = 3;
    public static final int ADULTO = 4;

    @Override
    public State creador(int tipo) {
        switch (tipo) {
            case CrearEstados.HUEVO -> {
                return new Huevo();
            }
            case CrearEstados.BEBE -> {
                return new Bebe();
            }
            case CrearEstados.JOVEN -> {
                return new Joven();
            }
            case CrearEstados.ADULTO -> {
                return new Adulto();
            }
        }
        return null;
    }
    
}
