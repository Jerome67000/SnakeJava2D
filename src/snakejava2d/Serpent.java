package snakejava2d;

import java.awt.Color;
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
    
    private LinkedList<Case> listeCasesSerpent;
    private Direction direction;
    
    public Serpent() {
        
        this.listeCasesSerpent = new LinkedList<Case>(); 
        
        this.listeCasesSerpent.add(new Case(14, 15));
        this.listeCasesSerpent.add(new Case(15, 15));
        this.listeCasesSerpent.add(new Case(16, 15));
        this.direction = Direction.VERS_LA_GAUCHE;
        
    }
    
    public void Calcul() {
        
        avance();
        
    }
    
    public void Affichage(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(Color.black);
        // Dessin du serpent
        for (Case c : this.listeCasesSerpent) {
            
            g.fillOval(c.getX(), c.getY(), c.getLargeur(), c.getHauteur());
        }
    }
    
    private void avance() {

         this.listeCasesSerpent.addFirst(getNextCase());
         this.listeCasesSerpent.removeLast();
    }
    
    private Case getNextCase() {
            
        Case tete = this.listeCasesSerpent.getFirst();
        
//        switch(this.direction) {
//            
//            case VERS_LE_HAUT :
//                return new Case(tete.getPosX(), tete.getPosY()-1);
//            case VERS_LA_DROITE :
//                return new Case(tete.getPosX()+1, tete.getPosY());
//            case VERS_LE_BAS :
//                return new Case(tete.getPosX(), tete.getPosY()+1);
//            case VERS_LA_GAUCHE :
//                return new Case(tete.getPosX()-1, tete.getPosY()-1);
//        }
        return new Case(0, 0);
    }
    
    public enum Direction {
        
      VERS_LE_HAUT,
      VERS_LA_DROITE,
      VERS_LE_BAS,
      VERS_LA_GAUCHE;
      
    }
}
