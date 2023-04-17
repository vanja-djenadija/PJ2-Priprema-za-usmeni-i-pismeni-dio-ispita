package R20220615.Z02;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    public String ime;
    public String prezime;
    public String brojIndeksa;
    public ArrayList<String> predmetId = new ArrayList<>();

    public Student(String ime, String prezime, String brojIndeksa, ArrayList<String> predmetId) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa = brojIndeksa;
        this.predmetId =predmetId;
    }
}
