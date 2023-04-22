package R_2019_10_03.Z02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Treca extends Thread {
    String slovo;
    ArrayList<String> suglasnici = new ArrayList<>();
    String odgovor = "";

    public Treca(String slovo) {
        this.slovo = slovo;
        suglasnici.add("a");
        suglasnici.add("e");
        suglasnici.add("i");
        suglasnici.add("o");
        suglasnici.add("u");
    }

    public void run() {
        List<String> kol = Prva.mapa.get(slovo);
        System.out.println(" TRECA >> rijec pocinje na slovo: " + slovo);
        int br = new Random().nextInt(kol.size());
        String rijec = kol.get(br);
        System.out.println(rijec);
        String[] slova = rijec.split("");
        for (int i = 0; i < slova.length; i++) {
            String slovo = slova[i];
            for (String s : suglasnici) {
                if (slovo.equals(s)) {
                    slova[i] = "*";
                    odgovor += s;
                    break;
                }
            }
            System.out.print(slova[i]);
        }
        System.out.println();
        System.out.println(odgovor);
        System.out.print(">> ODGOVOR: ");
        Scanner scan = new Scanner(System.in);
        String unos = scan.nextLine();
        System.out.println("UNOS " + unos);
        (new Cetvrta(odgovor, unos)).start();
    }
}