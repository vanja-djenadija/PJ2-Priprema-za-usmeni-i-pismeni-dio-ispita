package usmeni.U2025_05_19;

public class Z3_4 {
    public static void main(String[] args) {
        int i = 4;
        i = i++ % 6;
        System.out.println(i);
        i = i++ % 5;
        System.out.println(i);
        i = i++ % 4;
        System.out.println(i);
    }
}
