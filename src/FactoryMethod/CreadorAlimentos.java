/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

import Alimentos.Alimentos;
import Alimentos.Aves;
import Alimentos.Carne;
import Alimentos.Frutas;
import Alimentos.Hojas;
import Alimentos.Medicamento;
import Alimentos.Pescado;
import FactoryMethod.Creadora;

/**
 *
 * @author Hewlett Packard
 */
public class CreadorAlimentos implements Creadora<Alimentos>{
  public static final int CARNE = 1;
    public static final int PESCADO = 2;
    public static final int FRUTAS = 3;
    public static final int HOJAS = 4;
    public static final int AVES = 5;
    public static final int MEDICAMENTO = 6;

    @Override
    public Alimentos creador(int tipo) {
        switch (tipo) {
            case CreadorAlimentos.CARNE-> {
                return new Carne();
            }
            case CreadorAlimentos.PESCADO-> {
                return new Pescado();
            }
            case CreadorAlimentos.FRUTAS -> {
                return new Frutas();
            }
            case CreadorAlimentos.HOJAS -> {
                return new Hojas();
            }
            case CreadorAlimentos.AVES -> {
                return new Aves();
            }
            case CreadorAlimentos.MEDICAMENTO -> {
                return new Medicamento();
            }
        }
        return null;
    }
    
    
}
