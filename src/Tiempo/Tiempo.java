package Tiempo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hewlett Packard
 */
public class Tiempo {

    private int Minutos;
    private int Segundos;

    public int getMinutos() {
        return Minutos;
    }

    public void setMinutos(int Minutos) {
        if (Minutos >= 0 && Minutos <= 59) {
            this.Minutos = Minutos;
        }
    }

    public int getSegundos() {
        return Segundos;
    }

    public void setSegundos(int Segundos) {
        if (Segundos >= 0 && Segundos <= 59) {
            this.Segundos = Segundos;
        }
    }

    public Tiempo() {
        this(0, 0, 0);
    }

    public Tiempo(int Horas, int Minutos, int Segundos) {
        this.setMinutos(Minutos);
        this.setSegundos(Segundos);
    }

    @Override
    public String toString() {
        String Valor = "";
        if (Minutos < 10) {
            Valor += "0";
        }
        Valor += Minutos + ":";
        if (Segundos < 10) {
            Valor += "0";
        }
        Valor += Segundos;
        return Valor;
    }

    public void Avanzar() {
        this.Segundos++;
        if (Segundos > 59) {
            this.Segundos = 0;
            this.Minutos++;
        }
    }
    public boolean termino(){
        return this.Minutos==0&&this.Segundos==0;
    }
    public void Restar() {
        if (this.Segundos > 0 || this.Minutos > 0) {
            this.Segundos--;
            if (Segundos < 0) {
                this.Segundos = 59;
                this.Minutos--;
            }
        }
    }
}
