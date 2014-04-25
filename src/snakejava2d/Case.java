package snakejava2d;

/**
 *
 * @author Jerome
 * @version 1.0, le 24/04/2014
 */
public class Case implements Constantes {
    
    private int indiceX;
    private int indiceY;
    
    public Case (int posX, int posY) {
        
        this.indiceX = posX;
        this.indiceY = posY;
    }
    
    public int getPosX() {
        return this.indiceX;
    }
    
    public void setPosX(int indiceX) {
        this.indiceX = indiceX;
    }
    
    public int getPosY() {
        return this.indiceY;
    }
    
    public void setPosY(int indiceY) {
        this.indiceY = indiceY;
    }
    
    public int getX() {
        return this.indiceX*DIM_CASE;
    }
    
    public int getY() {
        return this.indiceY*DIM_CASE;
    }
    
    public int getLargeur() {
        return DIM_CASE;
    }
    
    public int getHauteur() {
        return DIM_CASE;
    }
    
}
