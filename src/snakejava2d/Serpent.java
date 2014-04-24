/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakejava2d;

/**
 * Objet représentant le serpent qui sera une collections de cases
 * @author Jerome
 * @version 1.0, le 24/04/2014
 */
public class Serpent implements Constantes {
    
    private int posX;
    private int posY;
    
    public Serpent(int posX, int posY) {
        
        this.posX = posX;
        this.posY = posY;
    }
    
}
