package Interfaz;

import Actividades.Actividades;
import Alimentos.Alimentos;
import Alimentos.Medicamento;
import FactoryMethod.CreadorActividades;
import Mascota.Mascota;
import Tiempo.Tiempo;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    private FrmJuego interfaz;
    private Mascota mascota;
    private Tiempo tiempo = new Tiempo();
    CreadorActividades creadorActividades = new CreadorActividades();
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

    public void Curar(Medicamento medicina) {
        medicina.efectoMedicina(mascota);
    }

    Timer reloj = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            tiempo.Avanzar();
            Habilitar();
            if (tiempo.getSegundos() % 2 == 0) {
                mascota.actualizarMascota();
                ActualizarInformacionMascota();
            }
            if (tiempo.getMinutos() % 1 == 0 && tiempo.getSegundos() == 0 && tiempo.getMinutos() != 0) {
                mascota.AumentarEdad();
                ActualizarMascota();
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
        HabilitarComidas(interfaz.getBtnCurar(), interfaz.medicina, interfaz.getLtiempo14());
    }

    public void ActualizarInformacionMascota() {
        interfaz.getNivelAburrimiento().setValue(mascota.getAburrimiento().getPorcentaje());
        interfaz.getNivelEnergia().setValue(mascota.getEnergia().getPorcentaje());
        interfaz.getNivelHambre().setValue(mascota.getHambre().getPorcentaje());
        interfaz.getNivelIralBaño().setValue(mascota.getGanasBaño().getPorcentaje());
        interfaz.getLblEstado().setText("Estado: " + mascota.obtenerEstadoSalud());
        SaludMascota();
    }

    public void SaludMascota() {
        if (mascota.morir()) {
            FrmTerminarJuego frm = new FrmTerminarJuego();
            frm.setVisible(true);
            this.Visibles(false);
            this.Gifs("/Imagenes/Morir.gif", interfaz.getLblFondo().getWidth(), interfaz.getLblFondo().getHeight(), interfaz.getLblFondo());
         //   JOptionPane.showMessageDialog(interfaz, "Su mascota a Muerto", "Mascota Muerta", JOptionPane.WARNING_MESSAGE);         
            reloj.stop();
        } else {
            if (mascota.getSalud().inicioEnfermo() && mascota.getSalud().isEnfermo()) {
                mascota.getSalud().iniciarTiempoEnfermo();       
                mostrarActividades(false, true, this.creadorActividades.creador(CreadorActividades.ENFERMAR));
                JOptionPane.showMessageDialog(interfaz, "Su mascota a enfermado", "Mascota enferma", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void AlimentarMasota(Alimentos ali) {
        mascota.comer(ali);
        ali.regeneracion();
    }

    public void mascotaHacerNecesidades() {
        mascota.irAlBaño();
    }

    public void mascotaIrCama() {
        mascota.dormir();
    }

    public void HacerActividades(Actividades act) {
        mascota.realizarActividades(act);
        mostrarActividades(false, true, act);
    }

    private void ActualizarMascota() {
        mascota.cambiarEstado();
        interfaz.getLblEdad().setText("Edad: " + String.valueOf(mascota.getEdad()));
        interfaz.getLblEtapa().setText("Etapa: " + mascota.getEstado().estadoMascota());
        Gifs("/Imagenes/" + mascota.getEstado().estadoMascota() + ".gif", 410, 420, interfaz.getLblMascota());
    }

    private void Visibles(boolean op) {
        interfaz.getjPanel1().setVisible(op);
        interfaz.getjPanel2().setVisible(op);
        interfaz.getjPanel3().setVisible(op);
        interfaz.getjPanel4().setVisible(op);
        interfaz.getjPanel5().setVisible(op);
        interfaz.getjPanel6().setVisible(op);
    }

    public void mostrarActividades(boolean no, boolean si, Actividades act) {
        Visibles(no);
        this.Gifs("/Imagenes/" + mascota.getEstado().estadoMascota() + act.getNombre() + ".gif", interfaz.getLblFondo().getWidth(), interfaz.getLblFondo().getHeight(), interfaz.getLblFondo());
        ActionListener aplicacion = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Visibles(si);
                ActualizarLbl();
                Gifs("/Imagenes/" + mascota.getEstado().estadoMascota() + ".gif", 410, 420, interfaz.getLblMascota());
                tiempoImagen.stop();
            }
        };
        tiempoImagen = new Timer(6000, aplicacion);
        tiempoImagen.start();
    }

    private void ActualizarLbl() {
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
        mascota.setNombre(FrmInicio.NOMBRE);
        interfaz.getLblNombre().setText("Nombre: " + mascota.getNombre());
        interfaz.getLblFondo().setIcon(Image("/Imagenes/Bosque.png", interfaz.getLblFondo().getWidth(), interfaz.getLblFondo().getHeight()));
        this.ActualizarMascota();
    }

    public Control(FrmJuego interfaz, Mascota mascota) {
        this.interfaz = interfaz;
        this.mascota = mascota;
    }

}
