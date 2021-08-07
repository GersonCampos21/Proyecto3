package Interfaz;

import Actividades.Actividades;
import Actividades.Dormir;
import Alimentos.Alimentos;
import Alimentos.Aves;
import Alimentos.Carne;
import Alimentos.Frutas;
import Alimentos.Hojas;
import Alimentos.Pescado;
import Interfaz.FrmJuego;
import Mascota.Mascota;
import Tiempo.Tiempo;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hewlett Packard
 */
public class Control {

    boolean mostrarI = true;
    private FrmJuego interfaz;
    private Mascota mascota;
    private Tiempo tiempo = new Tiempo();
    Timer tiempoImagen;

    public void HabilitarComidas(JRadioButton btn, Alimentos ti, JLabel lbl) {
        ti.getTiempoCarga().Restar();
        if (ti.getTiempoCarga().termino()) {
            ti.habilitar();
            btn.setEnabled(ti.isDisponible());
        }
        btn.setEnabled(ti.isDisponible());
        ActualizarTiemposCarga(ti, lbl);
    }

    public void Curar() {
        if (mascota.isEnfermo()) {
            mascota.SetEnfermo(false);
        } else {
            mascota.SetEnfermo(true);
        }
        if (mascota.getEnergia() <= 10) {
            mascota.AumentarEnergia(20);
        }
        if (mascota.getGanasBaño() >= 90) {
            mascota.DisminuirGanasBaño(20);
        }
        if (mascota.getHambre() >= 90) {
            mascota.DisminuirHambre(20);
        }
        if (mascota.getAburrimiento() >= 90) {
            mascota.DisminuirAburrimiento(20);
        }
    }

    Timer reloj = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            tiempo.Avanzar();
            Habilitar();
            if (tiempo.getSegundos() % 2 == 0) {
                mascota.CambiarEstados();
            }
            ActualizarInformacionMascota();
            if (tiempo.getMinutos() % 1 == 0 && tiempo.getSegundos() == 0 && tiempo.getMinutos() != 0) {
                mascota.AumentarEdad();
                ActualizarEtapaMascota();
            }
        }
    });

    public void ActualizarTiemposCarga(Alimentos ali, JLabel lbl) {
        lbl.setText(ali.getTiempoCarga().toString());
    }

    public void Habilitar() {
        HabilitarComidas(interfaz.getBtnPescado1(), interfaz.pescado, interfaz.getLtiempo9());
        HabilitarComidas(interfaz.getBtnCarne1(), interfaz.carne, interfaz.getLtiempo10());
        HabilitarComidas(interfaz.getBtnFrutas1(), interfaz.fruta, interfaz.getLtiempo12());
        HabilitarComidas(interfaz.getBtnHojas1(), interfaz.hoja, interfaz.getLtiempo11());
        HabilitarComidas(interfaz.getBtnAves1(), interfaz.ave, interfaz.getLtiempo13());
    }

    public void ActualizarInformacionMascota() {
        interfaz.getNivelAburrimiento().setValue(mascota.getAburrimiento());
        interfaz.getNivelEnergia().setValue(mascota.getEnergia());
        interfaz.getNivelHambre().setValue(mascota.getHambre());
        interfaz.getNivelIralBaño().setValue(mascota.getGanasBaño());
        SaludMascota();
    }

    public void SaludMascota() {
        if (mascota.morir()) {
            ImagenesActividad(false, true, "/Imagenes/" + mascota.getEtapa() + "Enfermo" + ".gif");
            JOptionPane.showMessageDialog(interfaz, "Su mascota a Muerto", "Mascota Muerta", JOptionPane.WARNING_MESSAGE);
            reloj.stop();
        }
        if (!mascota.isEnfermo() && mascota.getAburrimiento() == 90 || !mascota.isEnfermo() && mascota.getGanasBaño() == 90 || !mascota.isEnfermo() && mascota.getHambre() == 90 || !mascota.isEnfermo() && mascota.getEnergia() == 10) {
            ImagenesActividad(false, true, "/Imagenes/" + mascota.getEtapa() + "Enfermo" + ".gif");
            JOptionPane.showMessageDialog(interfaz, "Su mascota a enfermado", "Mascota enferma", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void AlimentarMasota(Alimentos ali) {
        mascota.AumentarEnergia(ali.getEnergy());
        mascota.DisminuirHambre(ali.getSatisfaccion());
        ali.regeneracion();
    }

    public void irAlBaño() {
        mascota.DisminuirGanasBaño(100);
    }

    public void Dormir() {
        mascota.AumentarGanasBaño(40);
        mascota.AumentarHambre(20);
        mascota.AumentarEnergia(90);
        mascota.AumentarAburrimiento(20);
    }

    public void HacerActividades(Actividades act) {
        mascota.DisminuirEnergia(act.getCansancio());
        mascota.DisminuirAburrimiento(act.getEntretenimiento());
        ImagenesActividad(false, true, "/Imagenes/" + mascota.getEtapa() + act.getNombre() + ".gif");
    }

    private void ActualizarEtapaMascota() {
        mascota.CambiarEtapa();
        interfaz.getLblEdad().setText("Edad: " + String.valueOf(mascota.getEdad()));
        interfaz.getLblEtapa().setText("Etapa: " + mascota.getEtapa());
        Gifs("/Imagenes/" + mascota.getEtapa() + ".gif", 410, 420, interfaz.getLblMascota());
    }

    private void Visibles(boolean op) {
        interfaz.getjPanel1().setVisible(op);
        interfaz.getjPanel2().setVisible(op);
        interfaz.getjPanel3().setVisible(op);
        interfaz.getjPanel4().setVisible(op);
        interfaz.getjPanel5().setVisible(op);
        interfaz.getjPanel6().setVisible(op);
    }

    public void ImagenesActividad(boolean op, boolean yes, String url) {
        Visibles(op);
        this.Gifs(url, interfaz.getLblFondo().getWidth(), interfaz.getLblFondo().getHeight(), interfaz.getLblFondo());
        ActionListener aplicacion = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Visibles(yes);
                interfaz.getLblFondo().setIcon(Image("/Imagenes/Bosque.png", interfaz.getLblFondo().getWidth(), interfaz.getLblFondo().getHeight()));
                Gifs("/Imagenes/" + mascota.getEtapa() + ".gif", 410, 420, interfaz.getLblMascota());
                tiempoImagen.stop();
            }
        };
        tiempoImagen = new Timer(6000, aplicacion);
        tiempoImagen.start();
    }

    private void ActualizarLbl() {
        mascota.setNombre(Auxiliar.nombre);
        interfaz.getLblNombre().setText("Nombre: " + mascota.getNombre());
        interfaz.getLblFondo().setIcon(Image("/Imagenes/Bosque.png", interfaz.getLblFondo().getWidth(), interfaz.getLblFondo().getHeight()));

    }

    private ImageIcon Image(String url, int han, int lar) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(url));
        Image conver = imagen.getImage();
        Image tamano = conver.getScaledInstance(han, lar, Image.SCALE_SMOOTH);
        ImageIcon Res = new ImageIcon(tamano);
        return Res;
    }

    private void Gifs(String url, int hancho, int largo, JLabel lbl) {
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource(url));
        Image imagen = imageIcon.getImage().getScaledInstance(hancho, largo, 1);
        lbl.setIcon(new ImageIcon(imagen));
    }

    public void InicioJuego() {
        reloj.start();
        this.ActualizarLbl();
        this.ActualizarEtapaMascota();
    }

    public Control(FrmJuego interfaz, Mascota mascota) {
        this.interfaz = interfaz;
        this.mascota = mascota;
    }

}
