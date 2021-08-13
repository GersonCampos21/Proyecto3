/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sonido;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Hewlett Packard
 */
public class Musica {

    private Clip sound;

    public void sonarCancion() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Sonido/AudioInicio.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.start();
        } catch (Exception ex) {
        }
    }

    public void reproducir() {
        sound.start();
    }

    public void pausa() {
        sound.stop();
    }
    
}
