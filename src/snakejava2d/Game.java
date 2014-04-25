package snakejava2d;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Coeur du jeu, boucle de calcul et d'affichage
 * @author Jerome
 * @version 1.0, le 23/04/2014
 */

public class Game implements Constantes {
    
    private Serpent serpent;
    private Grille grille;
    
    private boolean isGameOver;
    
    
    public Game() {
        
        this.serpent = new Serpent();
        this.grille = new Grille();

    }

    public void calcul() {
        
        if(this.serpent.estMort())
            this.isGameOver = true;
        this.serpent.Calcul();
    }

    public void affichage(Graphics g) {
        
        this.grille.Affichage(g);
        this.serpent.Affichage(g);
        if(this.isGameOver)
            afficherGameOver(g);
    }
    
    public void afficherGameOver(Graphics g) {
        
        String msgGameOver = Constantes.GAME_OVER;
        g.setColor(Color.RED);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
        FontMetrics fm = g.getFontMetrics();
        int x = (g.getClipBounds().width-fm.stringWidth(msgGameOver))/2;
        int y = (g.getClipBounds().height)/2+fm.getMaxDescent();
        g.drawString(msgGameOver, x, y);
        
    }
    
    public void gestionDuClavier(KeyEvent ke) {
        
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            
        }
        else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
            
        }
        else if(ke.getKeyCode() == KeyEvent.VK_UP) {
            
        }
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
            
        }
        
        
    }
      
}