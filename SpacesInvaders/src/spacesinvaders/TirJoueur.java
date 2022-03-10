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
 * permet de gérer les tirs du joueur
 * @author nm344384
 */
public class TirJoueur extends BoxGameItem {

    /**
     * constructeur de la classe TirJoueur
     * @param g correspond au jeu où on affiche le jeu
     * @param _x correspond à la coordonnée en abscisse où on affiche le sprite
     * @param _y correspond à la coordonnée en ordonnée où on affiche le sprite
     */
    public TirJoueur(Game g, int _x, int _y) {
        super(g, "tirVaisseau", _x, _y);
    }

    /**
     * permet de gérer les collisions avec les tirs du joueur
     * @param gi correspond à l'item avec lequel il y a la collision
     */
    @Override
    public void collideEffect(GameItem gi) {
        if(gi.getItemType() == "ennemis" || gi.getItemType() == "Mur" || gi.getItemType() == "Soucoupe"){
            this.getGame().remove(this);
        }
    }

    /**
     * permet de récupérer le type de l'item
     * @return le type de l'item
     */
    @Override
    public String getItemType() {
        return "tirJoueur";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) {
        this.moveDA(6,90);
    }
    
}
