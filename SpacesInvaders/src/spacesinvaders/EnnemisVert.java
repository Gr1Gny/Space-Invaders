/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesinvaders;

import iut.Game;

/**
 * permet de générer les ennemis vert
 * @author nm344384
 */
public class EnnemisVert extends Ennemis {
    
    /**
     * constructeur de la classe EnnemisJaune
     * @param g correspond au jeu où on affiche le jeu
     * @param _x correspond à la coordonnée en abscisse où on affiche le sprite
     * @param _y correspond à la coordonnée en ordonnée où on affiche le sprite
     */
    public EnnemisVert(Game g, int _x, int _y) {
        super(g, "alienMilieu1", _x, _y);
    }
    
    /**
     * permet de récupérer le premier sprite du vaisseau
     * @return le premier sprite du vaisseau
     */
    @Override
    public String getSprite1(){
        return "alienMilieu1";
    }
    
    /**
     * permet de récupérer le deuxième sprite du vaisseau
     * @return le deuxième sprite du vaisseau
     */
    @Override
    public String getSprite2(){
        return "alienMilieu2";
    }
    
    /**
     * permet de renseigner le score du vaisseau
     * @return le score
     */
    @Override
    public int getScore(){
        return 100;
    }
    
}
