package R_2022_06_29.Z03;

public class AddThread extends Thread {

    Long postotak;

    public AddThread(Long postotak) {
        start();
        this.postotak = postotak;
    }

    public void run() {
        while (!Simulacija.END) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			try {
				Simulacija.red.studenti.put(new Student());
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

    }
}