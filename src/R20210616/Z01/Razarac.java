package R20210616.Z01;

public class Razarac extends Plovilo {
    public Torpedo torpedo;
    public Raketa raketa;
    public boolean imaRaketniStit;

    public Razarac(String id, int x, int y, boolean imaRaketniStit) {
        super(id, x, y);
        this.imaRaketniStit = imaRaketniStit;
    }
}