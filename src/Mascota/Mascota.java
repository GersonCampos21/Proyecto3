package Mascota;

import Actividades.Actividades;
import Actividades.Pelear;
import Alimentos.Alimentos;
import Alimentos.Medicamento;
import AtributosVitales.Aburrimiento;
import AtributosVitales.Energia;
import AtributosVitales.GanasIrBano;
import AtributosVitales.Hambre;
import AtributosVitales.Salud;
import FactoryMethod.CreadorAtributosVitales;
import FactoryMethod.CrearEstados;
import Interfaz.FrmJuego;
import State.State;


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

    private CrearEstados crear = new CrearEstados();
    private CreadorAtributosVitales crearA = new CreadorAtributosVitales();
    private static Mascota unico;
    private boolean Vivo;
    private int Edad;
    private Energia energia;
    private Hambre hambre;
    private GanasIrBano ganasBaño;
    private Salud salud;
    private Aburrimiento aburrimiento;
    private State estado;
    private String Nombre;

    public static Mascota Instanciar() {
        if (unico == null) {
            Mascota.unico = new Mascota();
        }
        return unico;
    }

    public Energia getEnergia() {
        return energia;
    }

    public Hambre getHambre() {
        return hambre;
    }

    public Salud getSalud() {
        return salud;
    }

    public void setSalud(Salud salud) {
        this.salud = salud;
    }

    public GanasIrBano getGanasBaño() {
        return ganasBaño;
    }

    public Aburrimiento getAburrimiento() {
        return aburrimiento;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public State getEstado() {
        return estado;
    }

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

    public int getEdad() {
        return Edad;
    }

    public boolean morir() {
        int CantidadCriticos = 0;
        if (this.aburrimiento.estadoCritico()) {
            CantidadCriticos++;
        }
        if (this.energia.estadoCritico()) {
            CantidadCriticos++;
        }
        if (this.ganasBaño.estadoCritico()) {
            CantidadCriticos++;
        }
        if (this.hambre.estadoCritico()) {
            CantidadCriticos++;
        }
        return CantidadCriticos==1&&this.salud.isEnfermo()||CantidadCriticos >= 2 || this.hambre.estadoCulminante() || this.energia.estadoCulminante() || this.aburrimiento.estadoCulminante() || this.ganasBaño.estadoCulminante();
    }

    public String obtenerEstadoSalud() {
        if (this.salud.isEnfermo()) {
            return "Enfermo";
        } else {
            return "Saludable";
        }
    }

    public void actualizarMascota() {
        this.energia.Disminuir(1);
        this.hambre.Aumentar(1);
        this.aburrimiento.Aumentar(1);
        this.ganasBaño.Aumentar(1);
        this.enfermar();
        this.Vivo = !this.morir();
    }

    public void enfermar() {
        if (!this.salud.isEnfermo()) {
            this.salud.setEnfermo(this.hambre.estadoCritico() || this.ganasBaño.estadoCritico() || this.aburrimiento.estadoCritico() || this.energia.estadoCritico());
        }
    }

    public void irAlBaño() {
        this.ganasBaño.Disminuir(100);
    }

    public void dormir() {
        this.ganasBaño.Aumentar(40);
        this.hambre.Aumentar(20);
        this.energia.Aumentar(90);
        this.aburrimiento.Aumentar(20);
    }

    public void AumentarEdad() {
        this.Edad++;
        if (this.Edad > 3) {
            this.Edad = 0;
        }
    }

    public void cambiarEstado() {
        if (this.Edad == 0) {
            this.setEstado(crear.creador(CrearEstados.HUEVO));
        } else if (this.Edad == 1) {
            this.setEstado(crear.creador(CrearEstados.BEBE));
        } else if (this.Edad == 2) {
            this.setEstado(crear.creador(CrearEstados.JOVEN));
        } else if (this.Edad == 3) {
            this.setEstado(crear.creador(CrearEstados.ADULTO));
        }
    }

    public void realizarActividades(Actividades act) {
        this.aburrimiento.Disminuir(act.getEntretenimiento());
        this.energia.Disminuir(act.getCansancio());
    }

    public void comer(Alimentos ali) {
        this.energia.Aumentar(ali.getEnergy());
        this.hambre.Disminuir(ali.getSatisfaccion());
    }

    public Mascota() {
        this.Nombre = "Charmander";
        this.Vivo = true;
        this.Edad = 0;
        this.energia = (Energia) crearA.creador(CreadorAtributosVitales.ENERGIA);
        this.hambre = (Hambre) crearA.creador(CreadorAtributosVitales.HAMBRE);
        this.ganasBaño = (GanasIrBano) crearA.creador(CreadorAtributosVitales.GANASDELBANO);
        this.salud = new Salud();
        this.aburrimiento = (Aburrimiento) crearA.creador(CreadorAtributosVitales.ABURRIMIENTO);
     //   this.setEstado(crear.creador(CrearEstados.HUEVO));
    }

}
