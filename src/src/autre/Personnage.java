package autre;
public abstract class Personnage {
    private double ptsDeVie;
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

    public void attaqueBasique(Personnage personnage){
        double temp = Math.random() * 10.0;
        //UNE CHANCE SUR 10 DE COUP CRITIQUE
        Sort sort = new Sort();
        Bouclier bouclier = null;
        int degatsSort=sort.getDegats() + 2*(this.getNiveau()-1);

        //VERIF BOUCLIER
        boolean aUnBouclier=false;
        int rangBouclier=0;
        for(int i=0;i<personnage.getListeArmes().length;i++){
            if(personnage.getListeArmes()[i] instanceof Bouclier){
                aUnBouclier=true;
                rangBouclier=i;

                bouclier = new Bouclier((Bouclier) personnage.getListeArmes()[i]);

            }
        }

        //MANA PERDU
        this.setMana(this.getMana() - sort.getCoutMana());

        if (temp <= 1.0) {
            //CAS COUP CRITIQUE
            System.out.println("COUP CRITIQUE !");

            //CAS BOUCLIER COUP CRITIQUE
            if (aUnBouclier){
                if(degatsSort*2-bouclier.getProtection()<=0){
                    System.out.println("DEGATS BLOQUES");
                }else{
                    personnage.setPtsDeVie(personnage.getPtsDeVie() - degatsSort*2+bouclier.getProtection());
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
            //CAS NORMAL



            //CAS BOUCLIER PAS COUP CRITIQUE
            if(aUnBouclier){
                if(degatsSort-bouclier.getProtection()<=0){
                    System.out.println("DEGATS BLOQUES");
                }else{
                    personnage.setPtsDeVie(personnage.getPtsDeVie() - degatsSort+bouclier.getProtection());
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

    public abstract void attaqueSpeciale(Personnage personnage);

    public double getPtsDeVie() {
        return this.ptsDeVie;
    }

    public void setPtsDeVie(double ptsDeVie) {
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