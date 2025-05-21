package usmeni.U2025_05_19;

public  class Z3_6 {
    String Outer = "2";
    class Unutrasnja{
        String inner = "1";
        void metoda() {
            System.out.println(inner+Outer);
        }
    }
    void metoda() {}
    public  static  void main(String[] args) {
        Z3_6 t = new Z3_6();
        //Z3_6 t2 = t.new Z3_6();
        //Z3_6.metoda();
    }
}//Moguce da se prvo zvala Test3.metoda()... , ne sjecam se najbolje...
