/*
 * © Grad, Architecture du Bois
 */

package snakejava2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

/**
 * Représente la grille de jeu
 * @author Jérôme GULLY
 * @version 1.0, le 25/04/2014
 */
public class Grille implements Constantes {
    
    ArrayList<Case> grille;
    
    public Grille() {
        
        this.grille = new ArrayList<Case>();
        
        for (int x=0; x < NB_CASE_X; x++) {
            for(int y=0; y < NB_CASE_Y; y++) {
                
                this.grille.add(new Case(x, y));
                this.grille.add(new Case(0, 0));
            }
        }
    }
    
    public void Affichage(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(Color.lightGray);
        
        // Dessin du serpent
         for(Case c : this.grille)
             g.drawRect(c.getX(), c.getY(), c.getLargeur(), c.getHauteur());
  
    }
}
