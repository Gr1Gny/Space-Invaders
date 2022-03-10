/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacesinvaders;

import iut.Vector;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 *
 * @author nm344384
 */
public class SpaceInvader extends iut.Game{

    //correspond au scoire du jeu
    private UpdateScore score;
    //correspond au joueur
    private Joueur j;
    //correspond à la floote d'ennemis
    private Ennemis ennemis[ ] = new Ennemis[32];
    
    /**
     * constructeur de la classe SpaceInvader
     * @param width largeur du jeu
     * @param height hauteur du jeu
     * @param title titre du jeu
     */
    public SpaceInvader(int width, int height, String title) {
        super(width, height, title);
    }

    /**
     * permet de créer les items du jeu
     */
    @Override
    protected void createItems() {
        score = new UpdateScore(this,0);
        this.addItem(score);
        GenerateurSoucoupe s = new GenerateurSoucoupe(this);
        s.setScore(score);
        this.addItem(s);
        int y = this.getHeight()-150;
        j = new Joueur(this,500,y);
        this.addItem(j);
        int index = 0;
        for(int i = 180; i < 870; i+=90){
            for(int j = 60; j < 300; j+=60){
                if(index%4 == 1){
                    ennemis[index] = new EnnemisJaune(this,i,j);
                }
                else if(index%4 == 2){
                    ennemis[index] = new EnnemisBleu(this,i,j);
                }
                else{
                    ennemis[index] = new EnnemisVert(this,i,j);
                }
                this.addItem(ennemis[index]);
                index += 1;
            }
        }
        for ( int i=0; i<ennemis.length; i++ ) {
            ennemis[ i ].setFlotte(ennemis);
            ennemis[ i ].setScore(score);
        }
        for(int i = 60; i < this.getWidth(); i+= 160){
            Mur m1 = new Mur(this,i,500);
            this.addItem(m1);
        }       
    }

    /**
     * permet de modifier le fonc d'écran du jeu
     * @param grphcs 
     */
    @Override
    protected void drawBackground(Graphics grphcs) {
        grphcs.setColor(Color.BLACK);
        grphcs.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * quand le joueur perd
     */
    @Override
    protected void lost() {
        JOptionPane.showMessageDialog(this, "Vous avez perdu");
    }

    /**
     * quand le joueur gagne
     */
    @Override
    protected void win() {
        JOptionPane.showMessageDialog(this, "Vous avez gagné");
    }

    /**
     * condition pour que le joueur gagne
     * @return true si il gagne
     */
    @Override
    protected boolean isPlayerWin() {
        boolean win = true;
        for(Ennemis e : ennemis){
            if(e.isAlive()){
                win = false;
            } 
        }
        return win;
    }

    /**
     * condition pour que le joueur perd
     * @return true si il perd
     */
    @Override
    protected boolean isPlayerLost() {
        boolean bool = false;
        if(j.getPv() <= 0){
            bool = true;
        }
        for(Ennemis e : ennemis){
            if(e.getBottom() == 470 && e.isAlive()){
                bool = true;
            } 
        }
        return bool;
    }

    /**
     * permet de gérer la gravité
     * @return correspond à la gravité
     */
    @Override
    public Vector getGravity() {
        return null;
    }
    
}
