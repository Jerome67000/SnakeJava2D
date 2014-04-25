package snakejava2d;

import java.awt.Graphics;

/**
 * Coeur du jeu, boucle de calcul et d'affichage
 * @author Jerome
 * @version 1.0, le 23/04/2014
 */

public class Game {
    
    Serpent serpent;
    
    public Game() {
        
        this.serpent = new Serpent();
    }

    public void calcul() {
        
        this.serpent.Calcul();

    }

    public void affichage(Graphics g) {
        
        this.serpent.Affichage(g);
        

    }
      
}