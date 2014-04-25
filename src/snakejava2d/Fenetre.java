package snakejava2d;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Fenêtre principale, permetant d'afficher le jeu
 * @author Jerome
 * @version 1.0, le 23/04/2014
 */
public class Fenetre extends JFrame implements Constantes {
    
    private Game game;
    
    public Fenetre() {

        super("Snake");
        this.game = new Game();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        final JPanel content = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  // affichage du modèle du jeu
                  Fenetre.this.game.affichage(g);
            }
        };

        content.setPreferredSize(new Dimension(NB_CASE_X*DIM_CASE, NB_CASE_Y*DIM_CASE));
        setContentPane(content);

        Thread thread = new Thread(new Runnable() {                  
            @Override
            public void run() {
                  while (true) {

                        Fenetre.this.game.calcul();
                        content.repaint();
                  }                        
            }
        });
        thread.start();
    } 
    
    public static void main(String[] args) {
            
        Fenetre fenetre = new Fenetre();
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        
    }
    
}
