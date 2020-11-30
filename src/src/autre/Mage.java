package autre;

import java.util.ArrayList;

public class Mage extends Personnage {

    //private Sort sort = new Sort(15,20);

    public Mage() {
        super(100, 150, 1, new ArrayList<Arme>(){});
    }

    Mage(double ptsDeVie,int mana,int niveau,ArrayList<Arme> listeArmes) {
        super(ptsDeVie, mana, niveau, listeArmes);
    }

    public void attaqueSpeciale(Personnage personnage) {




    }
}
