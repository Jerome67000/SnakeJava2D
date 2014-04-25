package snakejava2d;

import java.awt.Dimension;
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
        
        super("Snake avec Java2D");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        // Conteneur principal
        JPanel jpContenant = new JPanel();
        jpContenant.setPreferredSize(new Dimension(NB_CASE_X*DIM_CASE, NB_CASE_Y*DIM_CASE));

        setContentPane(jpContenant);
        
        this.game = new Game();
        
        Thread thread = new Thread(new Runnable() {                  
            @Override
            public void run() {
                while (true) { 
                    Fenetre.this.game.calcul();

                    jpContenant.repaint();
                    // temporisation
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }                        
            }
        });
      // lancer le thread
      thread.start();
    }
    
    public static void main(String[] args) {
            
        Fenetre fenetre = new Fenetre();
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        
      }
    
}
