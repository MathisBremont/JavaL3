package autre;

public class Bouclier extends Arme {

    private int protection;

    public Bouclier() {
        this.protection=5;
    }



    public Bouclier(Bouclier bouclier){
        this.protection=bouclier.protection;
    }

    public Bouclier(int protection){
        this.protection=protection;
    }

    public int getProtection(){
        return this.protection;
    }

    @Override
    public String toString() {
        return String.valueOf(this.protection);
    }
}
