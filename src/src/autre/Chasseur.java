package autre;

public class Chasseur extends Personnage {

    public Chasseur() {
        super(120, 60, 1, (Arme[])null);
        this.setListeArmes(new Arme[]{new Arc()});
    }



    public void attaqueSpeciale(Personnage personnage) {
    }
}