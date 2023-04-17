package R20220209.Z01;

public class Vozac {

    String ime;
    String prezime;

    public Vozac(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
}