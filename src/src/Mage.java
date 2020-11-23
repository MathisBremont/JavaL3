public class Mage extends Personnage {
    Mage() {
        super(100, 100, 1, (Arme[])null);
    }

    public void attaqueBasique(Personnage personnage) {
        double temp = Math.random() * 10.0D;
        if (temp <= 1.0D) {
            this.setMana(this.getMana() - 10);
            personnage.setPtsDeVie(personnage.getPtsDeVie() - 20);
        } else {
            this.setMana(this.getMana() - 10);
            personnage.setPtsDeVie(personnage.getPtsDeVie() - 10);
        }

    }

    public void attaqueSpeciale(Personnage personnage) {
    }
}
