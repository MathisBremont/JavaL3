package autre;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Chasseur extends Personnage {

    public Chasseur(String nom) {
        super(nom,120, 30, 1, new ArrayList<Arme>(Arrays.asList(new Arc())));
    }


    public Chasseur(String nom,int ptsDeVie, int mana, int niveau, ArrayList<Arme> listeArmes){
        super(nom,ptsDeVie,mana,niveau,listeArmes);
    }



    public void attaqueSpeciale(Personnage personnage) {

        double temp = Math.random() * 10.0;


        //VERIF ARC
        if(personnage.rangArc()>=0){

            Arc arc = (Arc) personnage.getListeArmes().get(personnage.rangArc());
            if(arc.getNbFleches()>0) {

                //VERIF BOUCLIER
                boolean aUnBouclier = personnage.rangBouclier() >= 0;
                Bouclier bouclier = new Bouclier();
                if (aUnBouclier) {
                    bouclier = (Bouclier) personnage.getListeArmes().get(personnage.rangBouclier());
                }

                if (temp <= 1.0) {
                    //CAS BOUCLIER COUP CRITIQUE
                    if (aUnBouclier) {
                        if (arc.getDegats() * 2 - bouclier.getProtection() <= 0) {
                            System.out.println("DEGATS BLOQUES");
                        } else {
                            if (personnage.getPtsDeVie() - arc.getDegats() * 2 <= 0) {
                                personnage.setPtsDeVie(0);
                            } else {
                                personnage.setPtsDeVie(personnage.getPtsDeVie() - arc.getDegats() * 2 + bouclier.getProtection());
                            }
                        }
                        //CAS PAS BOUCLIER COUP CRITIQUE
                    } else {

                        if (personnage.getPtsDeVie() - arc.getDegats() * 2 <= 0) {
                            personnage.setPtsDeVie(0);
                        } else {
                            personnage.setPtsDeVie(personnage.getPtsDeVie() - arc.getDegats() * 2);
                        }
                    }
                } else {
                    //CAS BOUCLIER PAS COUP CRITIQUE
                    if (aUnBouclier) {
                        if (arc.getDegats() - bouclier.getProtection() <= 0) {
                            System.out.println("DEGATS BLOQUES");
                        } else {
                            if (personnage.getPtsDeVie() - arc.getDegats() < 0) {
                                personnage.setPtsDeVie(0);
                            } else {
                                personnage.setPtsDeVie(personnage.getPtsDeVie() - arc.getDegats() + bouclier.getProtection());
                            }
                        }
                        //PAS BOUCLIER PAS COUP CRITIQUE
                    } else {
                        if (personnage.getPtsDeVie() - arc.getDegats() < 0) {
                            personnage.setPtsDeVie(0);
                        } else {
                            personnage.setPtsDeVie(personnage.getPtsDeVie() - arc.getDegats());
                        }
                    }
                }
            }
        }
    }
}