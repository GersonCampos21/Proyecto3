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
public class Huevo extends State{

   public Huevo() {
        this.estado="Huevo";
    }
    

    @Override
    public String estadoMascota() {
        return this.estado;
    }
    
}
