public class Partie {
    public Partie() {
    }

    public static void main(String[] args) {
        Mage mage = new Mage();
        Guerrier guerrier = new Guerrier();
        mage.attaqueBasique(guerrier);
        System.out.println("Le guerrier n'a plus que " + guerrier.getPtsDeVie() + " pts de vies");
        System.out.println("Le mage n'a plus que " + mage.getMana() + " pts de mana");
    }
}
