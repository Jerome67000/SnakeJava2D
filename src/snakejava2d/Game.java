package snakejava2d;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Coeur du jeu, boucle de calcul et d'affichage
 * @author Jerome
 * @version 1.0, le 23/04/2014
 */

public class Game implements Constantes {
    
    Serpent serpent;
    Grille grille;
    
    public Game() {
        
        this.serpent = new Serpent();
        this.grille = new Grille();

    }

    public void calcul() {
        
        this.serpent.Calcul();

    }

    public void affichage(Graphics g) {
        
        this.grille.Affichage(g);
        this.serpent.Affichage(g);
         
    }
      
}