package autre;


public class Epee extends Arme {

    private int degats;

    public Epee() {
        this.degats=5;
    }

    public Epee(int degats) {
        this.degats=degats;
    }

    public int getDegats(){
        return this.degats;
    }

    @Override
    public String toString() {
        return String.valueOf(this.degats);
    }


}