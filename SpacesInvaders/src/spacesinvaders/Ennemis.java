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
 * permet de permet de gérer les ennemis
 * @author nm344384
 */
public abstract class Ennemis extends BoxGameItem {
    
    //permet de savoir si le vaisseau est en vie ou non
    private boolean alive = true;
    
    //vitesse du vaisseau en abscisse et en ordonnées
    private float vitesseX = 0.03f;
    private float vitesseY = 0.15f;
    
    //permet de changer de direction si un vaisseau touche le bord
    private int auBord = 0;
    
    //permet de changer le sprite des vaisseaux
    private int changeImg = 0;
    
    //permet au vaisseau de connaitre tous les autres vaisseaux
    private Ennemis flotteEnnemis[ ];
    
    //permet au vaisseau de modifier le score total quand il meurt
    private UpdateScore score;
    
    /**
     * constructeur de la classe ennemis
     * @param g correspond au jeu où on affiche le jeu
     * @param str correspond au sprite à afficher
     * @param _x correspond à la coordonnée en abscisse où on affiche le sprite
     * @param _y correspond à la coordonnée en ordonnée où on affiche le sprite
     */
    public Ennemis(Game g,String str, int _x, int _y) {
        super(g, str, _x, _y);
    }

    /**
     * permet de récupérer le premier sprite du vaisseau
     * @return le premier sprite du vaisseau
     */
    public abstract String getSprite1();
    
    /**
     * permet de récupérer le deuxième sprite du vaisseau
     * @return le deuxième sprite du vaisseau
     */
    public abstract String getSprite2();
    
    /**
     * permet de gérer les collisions avec le coeur
     * @param gi correspond à l'item avec lequel il y a la collision
     */
    @Override
    public void collideEffect(GameItem gi) {
        if(gi.getItemType() == "tirJoueur"){
            if(alive){
                this.getGame().remove(this);
                alive = false;
                score.UpdateScore(this.getScore());
            }    
        }
    }

    /**
     * permet de récupérer le type de l'item
     * @return le type de l'item
     */
    @Override
    public String getItemType() {
        return "ennemis";
    }

    /**
     * permet de gérer l'évolution de l'objet
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    @Override
    public void evolve(long l) {  
        
        //on change le sprite du vaisseau
        modifieSprite(l);
       
        //on permet aux vaisseaux ennemis de tirer
        tirEnnemis();

        float mouvementX = 0;
        float mouvementY = 0;
        
        mouvementX = vitesseX * l;
        mouvementY = vitesseY * l;
        this.moveDA(mouvementX,0);
        //on va vérifier pour toute la flotte que les vaisseau ne sortent pas de l'écran
        //si un vaisseau tape le bord, la vitesse de la flotte augmente, change de direction et descend un certains nombre de fois
        
        //on gère ici le cas où le vaisseau doit descendre
        if (auBord > 0){
            allerEnBas(mouvementY);
        }
        
        for ( int i=0; i<flotteEnnemis.length; i++ ) {
            
            //on gère ici le cas où le vaisseau sort du coté droit de l'écran
            if(flotteEnnemis[i].getRight()>this.getGame().getWidth() && auBord == 0){
                allerAGauche(i);
            }
            
            //on gère ici le cas où le vaisseau sort du coté gauche de l'écran
            else if(flotteEnnemis[i].getLeft()<=0 && auBord == 0){
                allerADroite(i);
            }
        }
        
        
        
    }
    
    /**
     * permet au vaisseau de connaitre les autres vaisseaux de la flotte
     * @param flotte correspond à la flotte de vaisseaux
     */
    public void setFlotte(Ennemis flotte[ ]){
        this.flotteEnnemis = flotte;
    }
    
    /**
     * permet de modifier le modifier la vitesse des vaisseaux 
     * @param deplacement 
     */
    public void setMouvement(float deplacement){
        this.vitesseX = deplacement;
    }
    
    /**
     * permet de modifier le sprite des vaisseaix
     * @param l correspond au temps en millisecondes avant l'appel de la fonction
     */
    private void modifieSprite(long l){
        
        this.changeImg += l;
        
        if(changeImg > 1500){
            this.changeSprite(this.getSprite2());
            this.changeImg = 0;
        }
        else if(changeImg > 750){
            this.changeSprite(this.getSprite1());
        }
    }

    /**
     * permet aux vaisseaux ennemis de pouvoir tirer
     */
    private void tirEnnemis() {
        
        //il y a une change sur 3000 pour chaque appel de cette fonction que chaque vaisseau tire
        Random random = new Random();
        int nb;
        nb = random.nextInt(3000);
        
        if(nb == 1000){
            TirEnnemis tir = new TirEnnemis(this.getGame(),(int)this.getPosition().getX()+15,(int)this.getPosition().getY()+25);
            this.getGame().addItem(tir);
        }
    }
    
    /**
     * permet de changer la direction de tous les vaisseaux de la flotte vers la droite
     * @param i correspond à l'emplacement du vaisseau qui a touché le bord dans le tableau
     */
    private void allerADroite(int i){
        auBord += 20;
        this.vitesseX -= 0.005;
        this.moveDA(1,0);
        //on modifie le déplacement de tous les vaisseaux de la flotte
        for ( int j=0; j<flotteEnnemis.length; j++ ) {
            //on modifie dans ce cas le sens en multipliant la vitesse par -1 et on augmente sa vitesses
            if(j!=i){
                flotteEnnemis[j].setMouvement(vitesseX*(-1));
            }
        }
        this.vitesseX *= -1;
    }
    
    /**
     * permet de changer la direction de tous les vaisseaux de la flotte vers la gauche
     * @param i correspond à l'emplacement du vaisseau qui a touché le bord dans le tableau
     */
    private void allerAGauche(int i){
        auBord += 20;
        this.vitesseX += 0.005;
        this.moveDA(-1,0);
        //on modifie le déplacement de tous les vaisseaux de la flotte
        for ( int j=0; j<flotteEnnemis.length; j++ ) {
            //on modifie dans ce cas le sens en multipliant la vitesse par -1 et on augmente sa vitesses
            if(j!=i){
                flotteEnnemis[j].setMouvement(vitesseX*(-1));
            }
        }
        this.vitesseX *= -1;
    }
    
    /**
     * permet de changer la direction de tous les vaisseaux de la flotte vers le bas
     * @param mouvementY correspond à la vitesse du vaisseau
     */
    private void allerEnBas(float mouvementY){
        for ( int j=0; j<flotteEnnemis.length; j++ ) {
            flotteEnnemis[j].moveDA(mouvementY, 270);
        }
        auBord --;
    }

    /**
     * permet de savoir si le vaisseau est en vie ou non
     * @return true si le vaisseau est en vie
     */
    public boolean isAlive() {
        return alive;
    }
    
    /**
     * permet de récupérer le score du vaisseau
     * @return le score
     */
    public abstract int getScore();

    /**
     * poermet au vaisseau de connaitre le score afin de le modifier à sa mort
     * @param s correspond au score
     */
    public void setScore(UpdateScore s) {
        this.score = s;
    }
}
