/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;


/**
 *
 * @author Hewlett Packard
 */
public class Bebe extends  State {

    public Bebe() {
        this.estado="Bebe";
    }
    

    @Override
    public String estadoMascota() {
        return this.estado;
    }

    
}
