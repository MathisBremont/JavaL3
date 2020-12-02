package autre;

import java.util.ArrayList;
import java.util.Arrays;

public class Guerrier extends Personnage {
    public Guerrier(String nom) {
        super(nom,150, 30, 1, new ArrayList<Arme>(Arrays.asList(new Epee(),new Bouclier())));
    }


    Guerrier(String nom,int ptsDeVie, int mana, int niveau, ArrayList<Arme> listeArmes) {
        super(nom,ptsDeVie, mana, niveau, listeArmes);
    }


    public void attaqueSpeciale(Personnage personnage) {

        double temp = Math.random() * 10.0;

        //VERIF EPEE
        boolean aUneEpee=personnage.rangEpee()>=0;
        Epee epee = new Epee();
        if(aUneEpee){

            epee=(Epee)personnage.getListeArmes().get(personnage.rangEpee());

            //VERIF BOUCLIER
            boolean aUnBouclier=personnage.rangBouclier()>=0;
            Bouclier bouclier = new Bouclier();
            if(aUnBouclier){
                bouclier=(Bouclier)personnage.getListeArmes().get(personnage.rangBouclier());
            }

            if (temp <= 1.0) {
                //CAS BOUCLIER COUP CRITIQUE
                if (aUnBouclier){
                    if(epee.getDegats()*2-bouclier.getProtection()<=0){
                        System.out.println("DEGATS BLOQUES");
                    }else{
                        if(personnage.getPtsDeVie()-epee.getDegats()*2<=0){
                            personnage.setPtsDeVie(0);
                        }else{
                            personnage.setPtsDeVie(personnage.getPtsDeVie() - epee.getDegats()*2+bouclier.getProtection());
                        }
                    }
                    //CAS PAS BOUCLIER COUP CRITIQUE
                }else{

                    if(personnage.getPtsDeVie()-epee.getDegats()*2<=0){
                        personnage.setPtsDeVie(0);
                    }else{
                        personnage.setPtsDeVie(personnage.getPtsDeVie() - epee.getDegats()*2);
                    }
                }
            } else {
                //CAS BOUCLIER PAS COUP CRITIQUE
                if(aUnBouclier){
                    if(epee.getDegats()-bouclier.getProtection()<=0){
                        System.out.println("DEGATS BLOQUES");
                    }else{
                        if(personnage.getPtsDeVie()-epee.getDegats()<0){
                            personnage.setPtsDeVie(0);
                        }else{
                            personnage.setPtsDeVie(personnage.getPtsDeVie() - epee.getDegats()+bouclier.getProtection());
                        }
                    }
                    //PAS BOUCLIER PAS COUP CRITIQUE
                }else{
                    if(personnage.getPtsDeVie()-epee.getDegats()<0){
                        personnage.setPtsDeVie(0);
                    }else{
                        personnage.setPtsDeVie(personnage.getPtsDeVie() - epee.getDegats());
                    }
                }
            }
        }
    }
}