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
 * Classe qui permet d'afficher les pv restant
 * @author Noham
 */
public class Coeur extends BoxGameItem {

    /**
     * constructeur de la classe Coeur
     * @param g correspond au jeu où on affiche le jeu
     * @param x correspond à la coordonnée en abscisse où on affiche le sprite
     * @param y correspond à la coordonnée en ordonnée où on affiche le sprite
     */
    public Coeur(Game g, int x, int y) {
        super(g, "like", x, y);
    }

    /**
     * permet de gérer les collisions avec le coeur
     * @param gi correspond à l'item avec lequel il y a la collision
     */
    @Override
    public void collideEffect(GameItem gi) { 
    }

    /**
     * permet de récupérer le type de l'item
     * @return le type de l'item
     */
    @Override
    public String getItemType() {
        return "coeur";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) { 
    }
    
}
