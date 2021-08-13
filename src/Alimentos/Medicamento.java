/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alimentos;

import Mascota.Mascota;
import Tiempo.Tiempo;

/**
 *
 * @author Hewlett Packard
 */
public class Medicamento extends Alimentos {
    private int restauracion;

    public Medicamento() {
        this.restauracion = 20;
        this.Energy = 0;
        this.Satisfaccion = 0;
        this.TiempoCarga = new Tiempo(0, 0, 0);
    }

    public int getRestauracion() {
        return restauracion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Tiempo getTiempoCarga() {
        return TiempoCarga;
    }

    public void efectoMedicina(Mascota mascota) {
        if (mascota.getSalud().isEnfermo()) {
            aplicarCuracion(mascota);
            mascota.getSalud().reinciarTiempoEnfermo();
            mascota.getSalud().setEnfermo(false);
        } else {
            mascota.getSalud().setEnfermo(true);
        }
    }

    private void aplicarCuracion(Mascota mascota) {
        mascota.getEnergia().salirCritico(this.getRestauracion());
        mascota.getAburrimiento().salirCritico(this.getRestauracion());
        mascota.getHambre().salirCritico(this.getRestauracion());
        mascota.getGanasBaño().salirCritico(this.getRestauracion());
    }

    @Override
    public void regeneracion() {
        this.disponible = false;
        this.TiempoCarga = new Tiempo(0, 1, 0);
    }
}
