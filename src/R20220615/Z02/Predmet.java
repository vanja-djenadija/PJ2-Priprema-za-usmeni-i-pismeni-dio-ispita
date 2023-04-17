package R20220615.Z02;

import java.io.Serializable;

public class Predmet implements Serializable {
    public String naziv;
    public String id;

    public Predmet(String naziv, String id) {
        this.naziv = naziv;
        this.id = id;
    }

}
