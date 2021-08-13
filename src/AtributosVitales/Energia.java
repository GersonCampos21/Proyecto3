/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtributosVitales;

/**
 *
 * @author Hewlett Packard
 */
public class Energia extends AtributosVitales {

    public Energia() {
        this.porcentaje = 100;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    @Override
    public boolean estadoCritico() {
       return this.porcentaje <= 10;
    }

    @Override
    public void salirCritico(int cantidad) {
        if (this.estadoCritico()) {
            this.Aumentar(cantidad);
        }
    }

    @Override
    public boolean estadoCulminante() {
        return this.porcentaje == 0;
    }
}
