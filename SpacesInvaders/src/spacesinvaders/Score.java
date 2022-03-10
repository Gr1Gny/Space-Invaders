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
 * permet de gérer les scores
 * @author Noham
 */
public class Score extends BoxGameItem {

    /**
     * constructeur de la classe Score
     * @param g correspond au jeu où on affiche le jeu
     * @param x correspond à la coordonnée en abscisse où on affiche le sprite
     * @param y correspond à la coordonnée en ordonnée où on affiche le sprite
     */
    public Score(Game g, int x, int y) {
        super(g, "0", x, y);
    }

    /**
     * permet de gérer les collisions
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
        return "Score";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) {
        
    }
    
    /**
     * permet de modifier le sprite du score
     * @param s correspond au score à afficher
     */
    public void ChangeSpriteScore(String s){
        this.changeSprite(s);
    }
    
}
