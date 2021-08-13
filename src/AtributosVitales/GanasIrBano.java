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
public class GanasIrBano extends AtributosVitales {

    public GanasIrBano() {
        this.porcentaje = 0;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    @Override
    public boolean estadoCritico() {
        return  this.porcentaje >= 90;
    }

    @Override
    public void salirCritico(int cantidad) {
        if (this.estadoCritico()) {
            this.Disminuir(cantidad);
        }
    }

    @Override
    public boolean estadoCulminante() {
        return this.porcentaje == 100;
    }

}
