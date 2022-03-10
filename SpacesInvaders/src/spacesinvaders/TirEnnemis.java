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
 * permet de gérer les tirs ennemis
 * @author nm344384
 */
public class TirEnnemis extends BoxGameItem {

    /**
     * constructeur de la classe Coeur
     * @param g correspond au jeu où on affiche le jeu
     * @param _x correspond à la coordonnée en abscisse où on affiche le sprite
     * @param _y correspond à la coordonnée en ordonnée où on affiche le sprite
     */
    public TirEnnemis(Game g, int _x, int _y) {
        super(g, "tirAlien1", _x, _y);
    }

    /**
     * permet de gérer les collisions avec les tirs ennemis
     * @param gi correspond à l'item avec lequel il y a la collision
     */
    @Override
    public void collideEffect(GameItem gi) {
        if(gi.getItemType() == "joueur" || gi.getItemType() == "Mur"){
            this.getGame().remove(this);
        }
    }

    /**
     * permet de récupérer le type de l'item
     * @return le type de l'item
     */
    @Override
    public String getItemType() {
        return "tirEnnemis";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) {
        this.moveDA(4,270);
    }
    
}
