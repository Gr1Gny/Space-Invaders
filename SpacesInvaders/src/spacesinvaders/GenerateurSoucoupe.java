/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesinvaders;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import java.util.Random;

/**
 * classe qui permet de générer des soucoupes
 * @author nm344384
 */
public class GenerateurSoucoupe extends BoxGameItem {

    //permet à la soucoupe de modifier le score
    private UpdateScore score;
    
    //temps avant la création de la première soucoupe
    private long timeToCreate=10000; // durée avant de créer la prochaine balle
    
    /**
     * constructeur de la classe GenerateurSoucoupe
     * @param g correspond au jeu où on affiche le jeu
     */
    public GenerateurSoucoupe(Game g) {
        super(g, "vide", -1, -1);
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
        return "GenerateurSoucoupe";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) {
        timeToCreate -= l;
        if(timeToCreate<=0){
            Soucoupe s = new Soucoupe(getGame());
            s.setScore(score);
            getGame().addItem(s);
            Random r = new Random();
            timeToCreate = r.nextInt(10000)+10000; // entre 10 et 20 s
        }
        
    }

    /**
     * permet au générateur de connaitre le score afin de le modifier plus tard
     * @param score correspond au score
     */
    public void setScore(UpdateScore score) {
        this.score = score;
    }
}
    

