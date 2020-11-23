public abstract class Personnage {
    private int ptsDeVie;
    private int mana;
    private int niveau;
    private Arme[] listeArmes;

    Personnage() {
    }

    Personnage(int ptsDeVie, int mana, int niveau, Arme[] listeArmes) {
        this.ptsDeVie = ptsDeVie;
        this.mana = mana;
        this.niveau = niveau;
        this.listeArmes = listeArmes;
    }

    public abstract void attaqueBasique(Personnage var1);

    public abstract void attaqueSpeciale(Personnage var1);

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

    public Arme[] getListeArmes() {
        return this.listeArmes;
    }

    public void setListeArmes(Arme[] listeArmes) {
        this.listeArmes = listeArmes;
    }
}
