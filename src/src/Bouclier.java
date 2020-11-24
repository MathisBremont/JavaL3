public class Bouclier extends Arme {

    private int protection;

    public Bouclier() {
        this.protection=5;
    }

    public Bouclier(Bouclier bouclier){
        this.protection=bouclier.protection;
    }

    public int getProtection(){
        return this.protection;
    }


}
