package R20220209.Z01;

public class Motor {

    int snaga;
    TipMotora tip;

    public Motor(int snaga, TipMotora tip) {
        this.snaga = snaga;
        this.tip = tip;
    }

    @Override
    public String toString() {
        return snaga + " " + tip;
    }
}