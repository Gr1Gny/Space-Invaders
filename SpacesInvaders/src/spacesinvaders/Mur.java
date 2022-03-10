/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesinvaders;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;

/**
 * permet de gérer les murs
 * @author nm344384
 */
public class Mur extends BoxGameItem {

    //correspond au nombre de pv du joueur
    private int pv;
    
    /**
     * constructeur de la classe Mur
     * @param g correspond au jeu où on affiche le jeu
     * @param x correspond à la coordonnée en abscisse où on affiche le sprite
     * @param y correspond à la coordonnée en ordonnée où on affiche le sprite
     */
    public Mur(Game g, int x, int y) {
        super(g, "mur1", x, y);
        pv = 4;
    }

    /**
     * permet de gérer les collisions avec le mur
     * @param gi correspond à l'item avec lequel il y a la collision
     */
    @Override
    public void collideEffect(GameItem gi) {
        if(gi.getItemType() == "tirEnnemis" || gi.getItemType() == "tirJoueur"){
            pv --;
            System.out.println(pv);
        }
    }

    /**
     * permet de récupérer le type de l'item
     * @return le type de l'item
     */
    @Override
    public String getItemType() {
        return "Mur";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) {
        switch(pv){
            case 3: this.changeSprite("mur2"); break;
            case 2: this.changeSprite("mur3"); break;
            case 1: this.changeSprite("mur4"); break;
            case 0: this.getGame().remove(this); break;
        }
    }
    
}
