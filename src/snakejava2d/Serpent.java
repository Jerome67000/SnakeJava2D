package snakejava2d;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedList;

/**
 * Objet représentant le serpent qui sera une collections de cases
 * @author Jerome
 * @version 1.0, le 24/04/2014
 */
public class Serpent {
    
    private LinkedList<Case> list;
    
    public Serpent() {
        
        this.list = new LinkedList<Case>(); 
        
        this.list.add(new Case(2, 2));
        this.list.add(new Case(15, 15));
        this.list.add(new Case(16, 15));
        
    }
    
    public void Calcul() {
        
    }
    
    public void Affichage(Graphics g) {
        
        
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        // Dessin du serpent
        for (Case c : this.list) {
            
            g.fillRect(c.getX(), c.getY(), c.getLargeur(), c.getHauteur());
        }
        
    }
}
