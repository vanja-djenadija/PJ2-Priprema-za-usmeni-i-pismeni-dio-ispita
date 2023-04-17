package R20220615.Z02;

import java.io.Serializable;
import java.util.ArrayList;

public class Profesor implements Serializable {
    public String ime;
    public String prezime;
    public String jmb;
    public ArrayList<String> predmetId = new ArrayList<>();

    public Profesor(String ime, String prezime, String jmb, ArrayList<String> predmetId) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmb = jmb;
        this.predmetId = predmetId;
    }
}
