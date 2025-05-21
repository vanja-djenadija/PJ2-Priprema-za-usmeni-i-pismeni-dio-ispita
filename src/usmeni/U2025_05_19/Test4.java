package usmeni.U2025_05_19;

public class Test4 {
    public static void main(String[] args) {
        new Test4() {
            void metoda() {
                //...ovde je mozda bila nova metoda tipa metoda1(), te redefinisana metoda()

            }
        };
    }

    void metoda() {
        for (int i = -2; i < 4; i += 2) {
            System.out.println(i);
        }
    }
}
