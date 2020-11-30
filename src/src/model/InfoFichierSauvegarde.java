package model;

import autre.Arme;

import java.util.ArrayList;

public class InfoFichierSauvegarde {
    private String titre;
    private String pseudo;
    private int typePerso;
    private Double ptsVie;
    private int mana;
    private int niveau;
    private ArrayList<Arme> listeArme;

    public InfoFichierSauvegarde(String titre, String pseudo, int typePerso, Double ptsVie, int mana, int niveau, ArrayList<Arme> listeArme) {
        this.titre = titre;
        this.pseudo = pseudo;
        this.typePerso = typePerso;
        this.ptsVie = ptsVie;
        this.mana = mana;
        this.niveau = niveau;
        this.listeArme = listeArme;
    }

    @Override
    public String toString() {
        StringBuffer sb =  new StringBuffer() ;
        return sb.append(this.titre).append("-").append(this.pseudo).append("\n").append(this.typePerso).append(" ").append(this.ptsVie).append(" ").append(this.mana)
                .append(" ").append(this.niveau).append(" ").append(listeArme).toString();
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getTypePerso() {
        return typePerso;
    }

    public void setTypePerso(int typePerso) {
        this.typePerso = typePerso;
    }

    public Double getPtsVie() {
        return ptsVie;
    }

    public void setPtsVie(Double ptsVie) {
        this.ptsVie = ptsVie;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public ArrayList<Arme> getListeArme() {
        return listeArme;
    }

    public void setListeArme(ArrayList<Arme> listeArme) {
        this.listeArme = listeArme;
    }
}
