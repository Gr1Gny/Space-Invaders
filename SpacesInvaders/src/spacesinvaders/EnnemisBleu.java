/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesinvaders;

import iut.Game;

/**
 * permet de générer les ennemis bleu
 * @author nm344384
 */
public class EnnemisBleu extends Ennemis {
    
    /**
     * constructeur de la classe EnnemisBleu
     * @param g correspond au jeu où on affiche le jeu
     * @param _x correspond à la coordonnée en abscisse où on affiche le sprite
     * @param _y correspond à la coordonnée en ordonnée où on affiche le sprite
     */
    public EnnemisBleu(Game g, int _x, int _y) {
        super(g,"alienHaut2", _x, _y);
    }
    
    /**
     * permet de récupérer le premier sprite du vaisseau
     * @return le premier sprite du vaisseau
     */
    @Override
    public String getSprite1(){
        return "alienHaut1";
    }
    
    /**
     * permet de récupérer le deuxième sprite du vaisseau
     * @return le deuxième sprite du vaisseau
     */
    @Override
    public String getSprite2(){
        return "alienHaut2";
    }

    /**
     * permet de renseigner le score du vaisseau
     * @return le score
     */
    @Override
    public int getScore() {
        return 250;
    }
    
}
