package autre;

public class Arc extends Arme{

    private int nbFleches;
    private int degats;

    public Arc() {
        this.nbFleches=5;
        this.degats=10;
    }

    public Arc(int nbFleches,int degats){
        this.nbFleches=nbFleches;
        this.degats=degats;
    }

    public int getDegats(){
        return this.degats;
    }

    public int getNbFleches(){
        return this.nbFleches;
    }

    @Override
    public String toString() {
        return String.valueOf(this.nbFleches)+", " + String.valueOf(this.degats);
    }


}