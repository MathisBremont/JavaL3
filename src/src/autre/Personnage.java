package autre;

import com.sun.jdi.DoubleValue;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Personnage implements Serializable {
    private String nom;
    private int ptsDeVie;
    private int mana;
    private int niveau;
    private ArrayList<Arme> listeArmes;




    Personnage(String nom,int ptsDeVie, int mana, int niveau, ArrayList<Arme> listeArmes) {
        this.nom=nom;
        this.ptsDeVie = ptsDeVie;
        this.mana = mana;
        this.niveau = niveau;
        this.listeArmes = listeArmes;
    }

    public void attaqueBasique(Personnage personnage){
        double temp = Math.random() * 10.0;
        //UNE CHANCE SUR 10 DE COUP CRITIQUE
        Sort sort = new Sort();

        int degatsSort=sort.getDegats() + 2*(this.getNiveau()-1);
        //VERIF BOUCLIER
        boolean aUnBouclier=personnage.rangBouclier()>=0;
        Bouclier bouclier = new Bouclier();
        if(aUnBouclier){
            bouclier=(Bouclier)personnage.getListeArmes().get(personnage.rangBouclier());
        }

        //MANA PERDU
        this.setMana(this.getMana() - sort.getCoutMana());
        if (temp <= 1.0) {
            //CAS BOUCLIER COUP CRITIQUE
            if (aUnBouclier){
                if(degatsSort*2-bouclier.getProtection()<=0){
                    System.out.println("DEGATS BLOQUES");
                }else{
                    if(personnage.getPtsDeVie()-degatsSort*2<0){
                        personnage.setPtsDeVie(0);
                    }else{
                        personnage.setPtsDeVie(personnage.getPtsDeVie() - degatsSort*2+bouclier.getProtection());
                    }
                }
                //CAS PAS BOUCLIER COUP CRITIQUE
            }else{

                if(personnage.getPtsDeVie()-degatsSort*2<0){
                    personnage.setPtsDeVie(0);
                }else{
                    personnage.setPtsDeVie(personnage.getPtsDeVie() - degatsSort*2);
                }
            }
        } else {
            //CAS BOUCLIER PAS COUP CRITIQUE
            if(aUnBouclier){
                if(degatsSort-bouclier.getProtection()<=0){
                    System.out.println("DEGATS BLOQUES");
                }else{
                    if(personnage.getPtsDeVie()-degatsSort<0){
                        personnage.setPtsDeVie(0);
                    }else{
                        personnage.setPtsDeVie(personnage.getPtsDeVie() - degatsSort+bouclier.getProtection());
                    }
                }
                //PAS BOUCLIER PAS COUP CRITIQUE
            }else{
                if(personnage.getPtsDeVie()-degatsSort<0){
                    personnage.setPtsDeVie(0);
                }else{
                    personnage.setPtsDeVie(personnage.getPtsDeVie() - degatsSort);
                }
            }
        }
    }


    int rangBouclier(){
        int temp=-1;
        for(int i=0;i<this.getListeArmes().size();i++){
            if(this.getListeArmes().get(i) instanceof Bouclier){
                temp=i;
            }
        }
        return temp;
    }

    int rangEpee(){
        int temp=-1;
        for(int i=0;i<this.getListeArmes().size();i++){
            if(this.getListeArmes().get(i) instanceof Epee){
                temp=i;
            }
        }
        return temp;
    }

    int rangArc(){
        int temp=-1;
        for(int i=0;i<this.getListeArmes().size();i++){
            if(this.getListeArmes().get(i) instanceof Arc){
                temp=i;
            }
        }
        return temp;
    }

    public abstract void attaqueSpeciale(Personnage personnage);

    public int getPtsDeVie() {
        return this.ptsDeVie;
    }

    public void setPtsDeVie(int ptsDeVie) {
        this.ptsDeVie = ptsDeVie;
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getNiveau() {
        return this.niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public ArrayList<Arme> getListeArmes() {
        return this.listeArmes;
    }

    public void setListeArmes(ArrayList<Arme> listeArmes) {
        this.listeArmes = listeArmes;
    }

    public String getNom(){return this.nom;}

    public void setNom(String nom){this.nom=nom;}

    public  String toString() {
        StringBuffer sb =  new StringBuffer() ;
        return sb.append(this.nom).append(" ").append(this.ptsDeVie).append(" ").append(this.mana).append(" ").append(this.niveau).append(" ").append(this.listeArmes).toString();
    }
}