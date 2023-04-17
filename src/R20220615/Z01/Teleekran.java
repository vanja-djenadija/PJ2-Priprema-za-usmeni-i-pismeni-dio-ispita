package R20220615.Z01;


public class Teleekran extends Thread {


    // prikaz liste poruka, prikaz izmjena u porukama
    @Override
    public void run() {
        while (!Simulacija.ZAUSTAVI) {
            Poruka poruka;
            while ((poruka = Simulacija.telePoruke.poll()) != null) {
                System.out.println(poruka);
                // process msg
            }
            // do other stuff
        }
    }
}
