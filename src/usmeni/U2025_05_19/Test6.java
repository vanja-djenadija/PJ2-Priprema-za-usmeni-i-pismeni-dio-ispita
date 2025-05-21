package usmeni.U2025_05_19;

public abstract class Test6 implements I1 {
    public static void main(String[] args) {
        //I1 i = (c)->System.out.println(c*2);
    }
}

interface I1 {
    int hashCode();

    public abstract boolean equals();

    public void add(double x);

    public void metoda(int nesto);
}

interface I2 extends I1 {
    public void doSmth();
}//Moguce da Test6 nije implementirao I1, I1 je implementirao I1, ili obrnuto...
