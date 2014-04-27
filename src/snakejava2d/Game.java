package snakejava2d;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Coeur du jeu, boucle de calcul et d'affichage
 * @author Jerome
 * @version 1.0, le 23/04/2014
 */

public class Game implements Constantes {
    
    private Serpent serpent;
    private Grenouille grenouille;
    private Grille grille;
    
    private boolean isGameOver;
    private int niveau;    
    
    public Game() {
        
        this.serpent = new Serpent();
        this.grenouille = new Grenouille();
        this.grille = new Grille();
        
        this.niveau = 1;   
    }

    public void calcul() {
        this.grenouille.Calcul();
        if(!this.isGameOver) {
            if(this.serpent.estMort())
                this.isGameOver = true;
            this.serpent.Calcul(this.grenouille, getNiveau());
        
        }
    }

    public void affichage(Graphics g) {
        
        this.grille.Affichage(g);
        this.grenouille.Affichage(g);
        this.serpent.Affichage(g);
        
        if(this.isGameOver)
            afficherGameOver(g);
        
        g.setColor(Color.BLUE);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        g.drawString(String.valueOf(getNiveau()), 5, 25);
        
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
        
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
            this.serpent.setNouvelleDirection(Serpent.Direction.VERS_LA_DROITE);
        else if(ke.getKeyCode() == KeyEvent.VK_LEFT)
            this.serpent.setNouvelleDirection(Serpent.Direction.VERS_LA_GAUCHE);
        else if(ke.getKeyCode() == KeyEvent.VK_UP)
            this.serpent.setNouvelleDirection(Serpent.Direction.VERS_LE_HAUT);
        else if (ke.getKeyCode() == KeyEvent.VK_DOWN)
            this.serpent.setNouvelleDirection(Serpent.Direction.VERS_LE_BAS);
  
    }
    
    public int getNiveau() {
        this.niveau = 1+this.serpent.getNbGrenouillesMangees()/5;
        return this.niveau;
    }
}