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
public abstract class AtributosVitales {

    protected int porcentaje;

    public int getPorcentaje() {
        return porcentaje;
    }

    public void Disminuir(int cantidad) {
        if (this.porcentaje - cantidad >= 0) {
            this.porcentaje -= cantidad;
        } else {
            this.porcentaje = 0;
        }
    }

    public void Aumentar(int cantidad) {
        if (this.porcentaje + cantidad <= 100) {
            this.porcentaje += cantidad;
        } else {
            this.porcentaje = 100;
        }
    }

    public abstract boolean estadoCritico();

    public abstract boolean estadoCulminante();

    public abstract void salirCritico(int cantidad);
}
