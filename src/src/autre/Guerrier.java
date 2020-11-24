package autre;

public class Guerrier extends Personnage {
    Guerrier() {
        super(150, 30, 1, (Arme[])null);
        this.setListeArmes(new Arme[]{new Epee(),new Bouclier()});
    }


    public void attaqueSpeciale(Personnage personnage) {
    }
}