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
 * gestion des soucoupes
 * @author nm344384
 */
public class Soucoupe extends BoxGameItem {

    //permet à la soucoupe de connaitre le score
    private UpdateScore score;
    
    /**
     * constructeur de la classe Soucoupe
     * @param g correspond au jeu où on affiche le jeu
     */
    public Soucoupe(Game g) {
        super(g, "soucoupe", 1040, 30);
    }

    /**
     * permet de gérer les collisions avec le Soucoupe
     * @param gi correspond à l'item avec lequel il y a la collision
     */
    @Override
    public void collideEffect(GameItem gi) {
        if(gi.getItemType() == "tirJoueur"){
            this.getGame().remove(this);
            score.UpdateScore(1000);
        }
    }

    /**
     * permet de récupérer le type de l'item
     * @return le type de l'item
     */
    @Override
    public String getItemType() {
        return "Soucoupe";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) {
        this.moveDA(-2, 0);
    }

    /**
     * permet à la soucoupe de connaitre le score afin de le modifier
     * @param score correspond au score
     */
    public void setScore(UpdateScore score) {
        this.score = score;
    }
    
    
}
