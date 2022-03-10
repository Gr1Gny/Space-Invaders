/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesinvaders;

/**
 *
 * @author nm344384
 */
public class SpacesInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpaceInvader jeu = new SpaceInvader(1024,768,"Space invaders");
        jeu.play();
    }
    
}
