/*
 *
 */

package snakejava2d;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javafx.scene.transform.Transform;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Représente la nourriture pour le serpent, agrandit le serpent d'une case
 * @author Jerome
 * @version 1.0
 * @since 25/04/2014
 */
public class Grenouille extends Case implements Constantes {
    
    private final static Random RND = new Random();
    private BufferedImage image=null;

    public Grenouille() {
        
        super(getRandomX(), getRandomY());

        try { 
            image = ImageIO.read(new File("img/grenouille2.png"));
            //  test ImageIcon imageNrm = new ImageIcon(CentralManager.class.getResource("/grad3d/images/general/logo_Grad.png"));
        } catch (IOException e) { 
          e.printStackTrace(); 
        }

    }

    public void Calcul() {
        
    }
    
    public void Affichage(Graphics g) {
        
        g.drawImage(image, this.getX(), this.getY(), null);
         
    }
    
    public void nouvelleGrenouille(Serpent serpent) {
        
        Case newGrenouille = new Case(getRandomX(), getRandomY());
        
        
        if (!serpent.getListeCasesSerpent().contains(newGrenouille)) {
            this.setPosX(newGrenouille.getPosX());
            this.setPosY(newGrenouille.getPosY());
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
