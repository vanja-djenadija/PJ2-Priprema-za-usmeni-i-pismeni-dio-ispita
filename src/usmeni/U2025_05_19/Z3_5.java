package usmeni.U2025_05_19;

public class Z3_5 implements AutoCloseable {
    public static void main(String[] args) {
        try (Z3_5 t = new Z3_5()) {
            t.test();
        } catch (Throwable e) {
            System.out.println("catch...");
        } finally {
            System.out.println("finally...");
        }
    }

    @Override
    public void close() {
        System.out.println("close...");
    }

    public void test() throws Exception {
        System.out.println("test...");
        throw new Exception();
    }
}
