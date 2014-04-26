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
    private Direction directionActuelle;
    private Direction toucheAppuyer;
    
    private boolean estMort;
    private int nbGrenouillesMangees;
    private int moveCounter;
    
    public Serpent() {
        
        this.listeCasesSerpent = new LinkedList<Case>(); 
        
        this.listeCasesSerpent.add(new Case(10, 10));
        this.listeCasesSerpent.add(new Case(11, 10));
        this.listeCasesSerpent.add(new Case(12, 10));
        this.listeCasesSerpent.add(new Case(13, 10));
        this.listeCasesSerpent.add(new Case(14, 10));
        this.listeCasesSerpent.add(new Case(15, 10));
        this.listeCasesSerpent.add(new Case(16, 10));
        this.directionActuelle = Direction.VERS_LE_HAUT;
        
    }
    
    public void Calcul(Grenouille grenouille, int niveau) {
        
        this.moveCounter++;
        
         if (this.moveCounter >= getThresholdCounter(niveau)) {
                  // remettre le compteur à zéro 
                  this.moveCounter = 0;
            tourner();
            if(peutManger(grenouille)) {
                mange();
                grenouille.nouvelleGrenouille();
            }
            else if(peutAvancer())
                avance();
            else
                this.estMort = true;
         }
        
    }
    
    public void Affichage(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(Color.CYAN);
        // Dessin du serpent
        for (Case c : this.listeCasesSerpent) {
            
            g.fillRect(c.getX(), c.getY(), c.getLargeur(), c.getHauteur());
        }
    }
    
    public boolean peutAvancer() {
        
        return getNextCase().isCaseValide() && !this.listeCasesSerpent.contains(getNextCase());
    }
    
    
    private void avance() {
        
        this.listeCasesSerpent.addFirst(getNextCase());
        this.listeCasesSerpent.removeLast();
    }
    
    public void setNouvelleDirection(Direction toucheAppuyer) {
        
        this.toucheAppuyer = toucheAppuyer;
    }
    
    public boolean peutManger(Grenouille grenouille) {
        
        if(this.getNextCase().getPosX() == grenouille.getPosX() && this.getNextCase().getPosY() == grenouille.getPosY())
            return true;
        else
            return false;
    }
    
    public void mange() {
        this.listeCasesSerpent.addFirst(getNextCase());
        this.nbGrenouillesMangees++;
    }
    
    public int getNbGrenouillesMangees() {
        
        return this.nbGrenouillesMangees;
    }
    
    private void tourner() {
        
        if(this.toucheAppuyer != null) {
            if (this.directionActuelle == Direction.VERS_LE_HAUT || this.directionActuelle == Direction.VERS_LE_BAS) {
                if (this.toucheAppuyer == Direction.VERS_LA_DROITE) {
                    this.directionActuelle = Direction.VERS_LA_DROITE;
                } else if (this.toucheAppuyer == Direction.VERS_LA_GAUCHE) { 
                    this.directionActuelle = Direction.VERS_LA_GAUCHE;
                }
            } else { 
                if (this.toucheAppuyer == Direction.VERS_LE_HAUT) { 
                    this.directionActuelle = Direction.VERS_LE_HAUT;
                } else if (this.toucheAppuyer == Direction.VERS_LE_BAS) {
                    this.directionActuelle = Direction.VERS_LE_BAS;
                }
            }
            this.toucheAppuyer = null;
        }
    }
    
    public boolean estMort() {
        return this.estMort;
    }
    
    private Case getNextCase() {
            
        Case tete = this.listeCasesSerpent.getFirst();
        
        switch(this.directionActuelle) {
            
            case VERS_LE_HAUT :
                return new Case(tete.getPosX(), tete.getPosY()-1);
            case VERS_LA_DROITE :
                return new Case(tete.getPosX()+1, tete.getPosY());
            case VERS_LE_BAS :
                return new Case(tete.getPosX(), tete.getPosY()+1);
            case VERS_LA_GAUCHE :
                return new Case(tete.getPosX()-1, tete.getPosY());
        }
        return null;
    }
    
    private int getThresholdCounter(int niveau) {
      switch (niveau) {
            case 1:
                  return 14;
            case 2:
                  return 12;
            case 3:
                  return 10;
            case 4:
                  return 10;
            case 5:
                  return 8;
            case 6:
                  return 8;
            case 7:
                  return 5;
            case 8:
                  return 4;
            case 9:
                  return 3;
            default :
                  return 2;
      }
}
    
    
    public enum Direction {
        
      VERS_LE_HAUT,
      VERS_LA_DROITE,
      VERS_LE_BAS,
      VERS_LA_GAUCHE;
      
    }
}
