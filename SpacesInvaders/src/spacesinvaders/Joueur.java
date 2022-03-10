/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesinvaders;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * classe qui permet la gestion du joueur
 * @author nm344384
 */
public class Joueur extends BoxGameItem implements KeyListener{
    
    //correspond aux points de vies du joueur
    private int pv;
    
    //permet de créer un loop de temps
    private long temps;
    
    //permet de savoir si le joueur peut mourir
    private boolean peutMourir = true;
    
    //permet de savoir si le joueur peut tirer
    private boolean peutTirer = true;
    
    //permet d'afficher le nombre de pv sous forme de coeurs
    private Coeur coeur1;
    private Coeur coeur2;
    private Coeur coeur3;  
    
    /**
     * constructeur de la classe Joueur
     * @param g correspond au jeu où on affiche le jeu
     * @param x correspond à la coordonnée en abscisse où on affiche le sprite
     * @param y correspond à la coordonnée en ordonnée où on affiche le sprite
     */
    public Joueur(Game g, int x, int y) {
        super(g, "vaisseau", x, y);
        pv = 3;
        coeur1 = new Coeur(this.getGame(),this.getGame().getWidth()-50,this.getGame().getHeight()-50);
        this.getGame().addItem(coeur1);
        coeur2 = new Coeur(this.getGame(),this.getGame().getWidth()-90,this.getGame().getHeight()-50);
        this.getGame().addItem(coeur2);
        coeur3 = new Coeur(this.getGame(),this.getGame().getWidth()-130,this.getGame().getHeight()-50);
        this.getGame().addItem(coeur3);
    }

    /**
     * permet de gérer les collisions avec le Joueur
     * @param gi correspond à l'item avec lequel il y a la collision
     */
    @Override
    public void collideEffect(GameItem gi) {
        if(gi.getItemType() == "tirEnnemis"){
            if(peutMourir){
                switch(pv){
                    case 3: this.getGame().remove(coeur3); break;
                    case 2: this.getGame().remove(coeur2); break;
                    case 1: this.getGame().remove(coeur1); break; 
                }
                pv --;
                peutMourir = false;
            }
        }
    }

    /**
     * permet de récupérer le type de l'item
     * @return le type de l'item
     */
    @Override
    public String getItemType() {
        return "joueur";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) {
            temps += l;
            
            if(temps > 300){
                peutTirer = true;
                peutMourir = true;
                temps = 0;
            }
        
    }
    
    /**
     * permet de gérer les evènements du clavier
     * @param ke correspond à l'évènement
     */
    @Override
    public void keyTyped(KeyEvent ke) {

    }

    /**
     * permet de gérer les evènements quand on appuye sur une touche du clavier
     * @param ke correspond à l'évènement
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode())
            {
                case KeyEvent.VK_LEFT:
                    if(this.getLeft()>0)
                        this.moveXY(-10, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    if(this.getRight()<this.getGame().getWidth())
                        this.moveXY(+10, 0);
                    break;
                case KeyEvent.VK_UP:
                    if(peutTirer){
                        TirJoueur tir = new TirJoueur(this.getGame(),(int)this.getPosition().getX()+26,(int)this.getPosition().getY()-10);
                        this.getGame().addItem(tir);
                        peutTirer = false;
                    }
                    
        }
        
    }

    /**
     * permet de gérer les evènements quand on lache une touche du clavier
     * @param ke correspond à l'évènement
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    /**
     * poermet de récupérer les pv du joueur
     * @return le nombre de pv
     */
    public int getPv() {
        return pv;
    }
    
}
