package R20220209.Z01;

public class Kamion extends Vozilo implements PrevoziTeret {

    public Kamion(String id, Vozac vozac, Motor motor, String konfig) {
        super(id, vozac, motor, konfig);
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + " " + super.toString();
    }
}