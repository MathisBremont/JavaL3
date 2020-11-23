public class Guerrier extends Personnage {
    Guerrier() {
        super(150, 60, 1, (Arme[])null);
        this.setListeArmes(new Arme[]{new Epee()});
    }

    public void attaqueBasique(Personnage personnage) {
    }

    public void attaqueSpeciale(Personnage personnage) {
    }
}
