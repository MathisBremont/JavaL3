package autre;

public class Sort {
    private int coutMana;
    private int degats;

    public Sort() {
        this.coutMana = 10;
        this.degats = 10;
    }

    public Sort(int coutMana, int degats) {
        this.coutMana = coutMana;
        this.degats = degats;
    }

    public int getCoutMana() {
        return this.coutMana;
    }

    public void setCoutMana(int coutMana) {
        this.coutMana = coutMana;
    }

    public int getDegats() {
        return this.degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public String toString(){
        return String.valueOf(this.coutMana)+" "+String.valueOf(this.degats)+" ";
    }
}