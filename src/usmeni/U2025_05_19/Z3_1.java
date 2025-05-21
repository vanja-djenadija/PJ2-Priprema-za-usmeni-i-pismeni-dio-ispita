package usmeni.U2025_05_19;

import java.util.ArrayList;

public class Z3_1 {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("a");
        s.add("ab");
        s.add("Acc");
        s.stream().peek(e -> System.out.println(e)).filter(e -> e.length() > 2);//.map(e->e+e)...tako  			  nesto...
    }
}
