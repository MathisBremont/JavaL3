package autre;

import java.util.ArrayList;

public class Mage extends Personnage {

    //private Sort sort = new Sort(15,20);

    public Mage() {
        super("",100, 150, 1, new ArrayList<Arme>(){});
    }

    public Mage(String nom,int ptsDeVie, int mana, int niveau, ArrayList<Arme> listeArmes) {
        super(nom,ptsDeVie, mana, niveau, listeArmes);
    }

    public Mage(String nom){
        super(nom,100,100,1,new ArrayList<Arme>(){});
    }

    public void attaqueSpeciale(Personnage personnage) {




    }
}
