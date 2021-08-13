/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

import AtributosVitales.Aburrimiento;
import AtributosVitales.AtributosVitales;
import AtributosVitales.Energia;
import AtributosVitales.GanasIrBano;
import AtributosVitales.Hambre;
import FactoryMethod.Creadora;

/**
 *
 * @author Hewlett Packard
 */
public class CreadorAtributosVitales implements Creadora<AtributosVitales> {

    public static final int ENERGIA = 1;
    public static final int HAMBRE = 2;
    public static final int GANASDELBANO = 3;
    public static final int ABURRIMIENTO = 4;

    @Override
    public AtributosVitales creador(int tipo) {
        switch (tipo) {
            case CreadorAtributosVitales.ENERGIA -> {
                return new Energia();
            }
            case CreadorAtributosVitales.ABURRIMIENTO -> {
                return new Aburrimiento();
            }
            case CreadorAtributosVitales.GANASDELBANO -> {
                return new GanasIrBano();
            }
            case CreadorAtributosVitales.HAMBRE -> {
                return new Hambre();
            }
        }
        return null;
    }
}
