package R_2022_06_29.Z03;

public class Simulacija {

    static Boolean END = false;
    static Red red = new Red();

    public static void main(String[] args) {

        if (args.length < 1) {
            return;
        }
        Long postotak = 0L;
        try {
             postotak = Long.parseLong(args[0]);

            if (postotak < 0 || postotak > 100)
                return;
        } catch (Exception e) {
            return;
        }
        AddThread t1 = new AddThread(postotak);
        RemoveThread t2 = new RemoveThread(100 - postotak);

        try {
            Thread.sleep(60_000); // 1 min
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        END = true;
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

}