package snakejava2d;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

        super(TITRE+" "+VERSION);
        this.game = new Game();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setFocusable(false);

        final JPanel jpcontenant = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  // affichage du modèle du jeu
                  Fenetre.this.game.affichage(g);
            }
        };
        jpcontenant.setFocusable(true);
        
        // le listener gérant les entrées au clavier
        jpcontenant.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
              Fenetre.this.game.gestionDuClavier(e);
        }
        });

        jpcontenant.setPreferredSize(new Dimension(NB_CASE_X*DIM_CASE, NB_CASE_Y*DIM_CASE));
        setContentPane(jpcontenant);

        Thread thread = new Thread(new Runnable() {                  
        @Override
        public void run() {
            while (true) { // boucle infinie
                
                Fenetre.this.game.calcul();
                jpcontenant.repaint();
                // temporisation
                try {
                      Thread.sleep(DELAI_RAFFRAICHISSEMENT);
                } catch (InterruptedException e) {
                      //
                }
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
