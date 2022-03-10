/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesinvaders;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * permet de modifier le score
 * @author Noham
 */
public class UpdateScore extends BoxGameItem {

    //correspond au score du jeu
    private int score; 
    
    //on sépare le score en plusieurs chiffres
    private Score unite;
    private Score dizaine;
    private Score centaine;
    private Score millier;
    private Score dixmilliers; 

    /**
     * constructeur de la classe UpdateScore
     * @param g correspond au jeu
     * @param score correspond au score
     */
    public UpdateScore(Game g, int score) {
        super(g, "vide", -1, -1);
        dixmilliers = new Score(g, 20,this.getGame().getHeight()-50);
        this.getGame().addItem(dixmilliers);
        millier = new Score(g, 60,this.getGame().getHeight()-50);
        this.getGame().addItem(millier);
        centaine = new Score(g, 100,this.getGame().getHeight()-50);
        this.getGame().addItem(centaine);
        dizaine = new Score(g, 140,this.getGame().getHeight()-50);
        this.getGame().addItem(dizaine);
        unite = new Score(g, 180,this.getGame().getHeight()-50);
        this.getGame().addItem(unite);
    }

    /**
     * permet de modifier le score
     * @param nb correspond au score à modifier
     */
    public void UpdateScore(int nb) {
        this.score += nb;
        System.out.println(score);
    }

    /**
     * permet de gérer les collisions avec le score
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
        return "GenerateurScore";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) {
        NumberFormat nf = new DecimalFormat("00000");
        String scoreStr = String.valueOf(nf.format(score));
        String[] Sc = scoreStr.split("");
        dixmilliers.ChangeSpriteScore(Sc[0]);
        millier.ChangeSpriteScore(Sc[1]);
        centaine.ChangeSpriteScore(Sc[2]);
        dizaine.ChangeSpriteScore(Sc[3]);
        unite.ChangeSpriteScore(Sc[4]); 
    }
}
