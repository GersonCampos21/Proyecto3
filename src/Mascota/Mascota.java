package Mascota;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hewlett Packard
 */
public class Mascota {

    private boolean Vivo;
    private int Edad;
    private int Energia;
    private int Hambre;
    private int GanasBaño;
    private boolean Enfermo;
    private int Aburrimiento;
    private String Etapa;
    private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        if (!Nombre.isBlank()) {
            this.Nombre = Nombre;
        }
    }

    public boolean isVivo() {
        return Vivo;
    }

    public void setVivo(boolean Vivo) {
        this.Vivo = Vivo;
    }

    public String getEtapa() {
        return Etapa;
    }

    public int getEdad() {
        return Edad;
    }

    public int getEnergia() {
        return Energia;
    }

    public int getHambre() {
        return Hambre;
    }

    public int getGanasBaño() {
        return GanasBaño;
    }

    public boolean isEnfermo() {
        return Enfermo;
    }

    public void SetEnfermo(boolean enfer) {
        this.Enfermo = enfer;
    }

    public int getAburrimiento() {
        return Aburrimiento;
    }

    public void AumentarAburrimiento(int Aburrimiento) {
        if (this.Aburrimiento + Aburrimiento <= 100) {
            this.Aburrimiento += Aburrimiento;
        } else {
            this.setVivo(false);
            this.Aburrimiento = 100;
        }
    }

    public void DisminuirAburrimiento(int Aburrimiento) {
        if (this.Aburrimiento - Aburrimiento >= 0) {
            this.Aburrimiento -= Aburrimiento;
        } else {
            this.Aburrimiento = 0;
        }
    }

    public void AumentarEnergia(int Energia) {
        if (this.Energia + Energia <= 100) {
            this.Energia += Energia;
        } else {
            this.Energia = 100;
        }
    }

    public void DisminuirEnergia(int Energia) {
        if (this.Energia - Energia >= 0) {
            this.Energia -= Energia;
        } else {
            this.setVivo(false);
            this.Energia = 0;
        }
    }

    public void AumentarHambre(int Hambre) {
        if (this.Hambre + Hambre <= 100) {
            this.Hambre += Hambre;
        } else {
            this.setVivo(false);
            this.Hambre = 100;
        }
    }

    public void DisminuirHambre(int Hambre) {
        if (this.Hambre - Hambre >= 0) {
            this.Hambre -= Hambre;
        } else {
            this.Hambre = 0;
        }
    }

    public void AumentarGanasBaño(int GanasBaño) {
        if (this.GanasBaño + GanasBaño <= 100) {
            this.GanasBaño += GanasBaño;
        } else {
            this.setVivo(false);
            this.GanasBaño = 100;
        }
    }

    public boolean morir() {
        int CantidadCriticos = 0;
        if (this.Aburrimiento >= 90) {
            CantidadCriticos++;
        }
        if (this.Energia <= 10) {
            CantidadCriticos++;
        }
        if (this.GanasBaño >= 90) {
            CantidadCriticos++;
        }
        if (this.Hambre >= 90) {
            CantidadCriticos++;
        }
        return CantidadCriticos>=2&&this.isEnfermo();
    }

    public void DisminuirGanasBaño(int GanasBaño) {
        if (this.GanasBaño - GanasBaño >= 0) {
            this.GanasBaño -= GanasBaño;
        } else {
            this.GanasBaño = 0;
        }
    }

    public void CambiarEstados() {
        this.DisminuirEnergia(1);
        this.AumentarAburrimiento(1);
        this.AumentarGanasBaño(1);
        this.AumentarHambre(1);
        this.Enfermo = EstarEnfermo();
        this.morir();
    }

    public boolean EstarEnfermo() {
        return this.Aburrimiento >= 90 || this.GanasBaño >= 90 || this.Hambre >= 90 || this.Energia <= 10;
    }

    public void AumentarEdad() {
        this.Edad++;
        if (this.Edad > 3) {
            this.Edad = 0;
        }
    }

    public void CambiarEtapa() {
        if (this.Edad == 0) {
            this.Etapa = "Huevo";
        } else if (this.Edad == 1) {
            this.Etapa = "Bebe";
        } else if (this.Edad == 2) {
            this.Etapa = "Joven";
        } else if (this.Edad == 3) {
            this.Etapa = "Adulto";
        }
    }

    public Mascota() {
        this.Nombre = "Charmander";
        this.Vivo = true;
        this.Edad = 0;
        this.Energia = 100;
        this.Hambre = 0;
        this.GanasBaño = 0;
        this.Enfermo = false;
        this.Aburrimiento = 0;
        this.Etapa = "Huevo";
    }
}
