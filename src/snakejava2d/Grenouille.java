/*
 *
 */

package snakejava2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;
import javafx.scene.transform.Transform;

/**
 * Représente la nourriture pour le serpent, agrandit le serpent d'une case
 * @author Jerome
 * @version 1.0
 * @since 25/04/2014
 */
public class Grenouille extends Case implements Constantes {
    
    private final static Random RND = new Random();
    private int angle;

    public Grenouille() {
        
        super(getRandomX(), getRandomY());
        this.angle = 0;
    }
    
    public void Calcul() {
        
        this.angle += 25;
    }
    
    public void Affichage(Graphics g) {
        
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform tr = g2.getTransform();
        
        g.setColor(Color.RED);
        
        g2.setTransform(AffineTransform.getRotateInstance(
                            Math.toRadians(this.angle),
                            getX() + (getLargeur() / 2),
                            getY() + (getHauteur() / 2)));
        
        g.fillRect(this.getX()+4, this.getY()+4, this.getLargeur()-8, this.getHauteur()-8);
        g2.setTransform(tr);
    }
    
    public void nouvelleGrenouille(Serpent serpent) {
        
        Case newGrenouille = new Case(getRandomX(), getRandomY());
        
        
        if (!serpent.getListeCasesSerpent().contains(newGrenouille)) {
            this.setPosX(newGrenouille.getPosX());
            this.setPosY(newGrenouille.getPosY());
            this.angle = 0;
        }
        else
            nouvelleGrenouille(serpent);
        
        
    }
    
    private static int getRandomX() {
            return RND.nextInt(NB_CASE_X);
      }
      
      private static int getRandomY() {
            return RND.nextInt(NB_CASE_Y);
      }
    
    
}
