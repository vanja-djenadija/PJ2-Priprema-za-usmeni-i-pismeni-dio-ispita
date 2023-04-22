# Programski jezici 2 - Pismeni dio ispita

## :pushpin: Oblasti

1. Uvod

2. Paketi, moduli i kontrola pristupa

3. Izuzeci

4. OOP

5. Osnovne Java klase

6. Ulazno-izlazni podsistem

7. Generički tipovi

8. Kolekcije

9. Uvod u konkurentno programiranje

10. Lambda izrazi i Stream API

11. GUI

## :pushpin: Tipovi zadataka na pismenom dijelu ispita

<details>
  <summary>Prvi zadatak</summary>
  
  
<p>
Akcenat je na konkurentnom programiranju i pravilnoj sinhronizaciji. Bitno je napraviti pravilnu hijerarhiju klasa i interfejsa.
</p>

==_NOTE_== Ne smijemo koristiti **instanceof** da provjerimo da li je roditelj dijete, to postižemo upotrebom interfejsa ili provjeravanjem nekog flega/atributa.

</details>

<details>
  <summary>Drugi zadatak</summary>

- I/O

</details>

<details>
  <summary>Treći zadatak</summary>

- Stream API
- </details>

## :rotating_light: Usmeni ispit

[:arrow_forward: Usmeni ispit](resources/Usmeni.md)

## :sun_with_face: Tips and tricks

- Importovanje paketa
  ```java
      import java.util.stream.*;
      import java.util.*;
      import java.io,*;
  ```
- Svi atributi klase **default** paketski modifikator pristupa, bez navođenja public (manje kucanja), bez getter i setter metoda
- **Default constructor** kod Stream API

  ```java
  public Proizvod() {
      id = "ID" + new Date().getTime();
      naziv = "Proizvod" + count++;
      opis = "Opis" + count;
      cijena = new Random().nextInt(100) + 1000;
      tip = (count % 2 == 0) ? Tip.KNJIGA : Tip.SVESKA;
  }
  ```

- **toString** Override
  ```java
  @Override
    public String toString() {
        return id + " " + " " + naziv + " " + opis + " " + cijena + " " + tip.toString();
    }
  ```
- **`catch(Exception e)`**
- `java.util.Stream.toList()`
- `Collectors.metoda()`
- `stream().collect(Collectors.groupingBy(p -> p.tip))`
- Konverzija String u TIP -> `TIP.parseTIP(string)`
- Trenutno vrijeme `new Date().getTime()`
- Kopiranje liste u drugu preko parametrizovanog konstruktora
  ```java
  ArrayList<Proizvod> copy = new ArrayList<>(original);
  ```
- Serijalizacija
  ```java
      String fajl = Main.class.getName() + "_" + new Date().getTime() + ".ser";
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fajl))) {
          oos.writeObject(copyProizvodi);
      } catch (IOException e) {
          e.printStackTrace();
      }
  ```
- Deserijalizacija
  ```java
       String fajl = "fajl.ser";
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fajl))) {
              proizvodi = (ArrayList<Proizvod>) ois.readObject();
          } catch (ClassNotFoundException | IOException e) {
              e.printStackTrace();
          }
  ```
- ```java
  File[] file.listFiles()
  ```
- ```java
    import java.util.concurrent.*;
    BlockingQueue<Student> red = new LinkedBlockingQueue<>();
    ```

## :page_facing_up: Praktični ispiti

<details>
<summary>29.06.2022</summary>

1. Simulacija leta
2. Stream API Registar proizvoda
3. Simulacija RED
</details>

<details>
  <summary>15.06.2022 ✅</summary>

1. Orwell 1984 Big brother
2. Rad sa fajlovima
3. Generici + Predicate + Consumer ExampleData1
</details>

<details>
  <summary>09.02.2022 ✅</summary>

1. Trka vozila
2. Stream API + Rad sa fajlovima Filmovi
3. Pretraga direktorijuma Rad sa fajlovima + Stream API
</details>

<details>
  <summary>26.01.2022 ** ➡️</summary>

1. Slanje poruka + FileWatcher
2. Simulacija rad sa fajlovima
3. Analiza rješenja ispitnih zadataka (paketi, klase, komentari)
</details>

---

<details>
  <summary>06.10.2021 ➡️</summary>

1. Studentski izbori (.SAVE, .ELECTION, .REGISTER, .STATUS)
2. Rad sa fajlovima
3. Stream API Agencija za zapošljavanje
</details>

<details>
  <summary>08.09.2021 ✅</summary>

1. Obrada podataka kompanije (IMPORT, AUTO, SAVE, STATUS)
2. Stream API Studenti
3. UlancaniStek AddThread, RemoveThread
</details>

<details>
  <summary>25.08.2021 **</summary>

1. Virtuelna pošta
2. Rad sa fajlovima
3. Generici , Predicate, Podatak
</details>

<details>
  <summary>30.07.2021 ✅</summary>

1. Simulacija kupovine na kasi
2. Generici (Skladište, Podaci, Obavještenje , Alarmi)
3. FileWatcher + Rad sa fajlovima + Simulacija DailyQuotes
</details>

<details>
  <summary>16.06.2021 ✅</summary>

1. Vojna plovila
2. Stream API Knjige
3. Pretraga direktorijuma Rad sa fajlovima + Stream API
</details>

---

<details>
  <summary>13.02.2020 **</summary>

1. Cirkus + Biljojedi + Mesojedi
2. Rad sa fajlovima + Rekurzija
3. ArrayOps
</details>

<details>
  <summary>30.01.2020 ➡️</summary>

1. Trka vozila
2. Sakupljac_Watcher + rad sa fajlovima
3. Stream API | Zec
</details>

---

<details>
  <summary>03.10.2019 ✅</summary>

</details>

<details>
  <summary>19.09.2019.</summary>

1. JavaAds + JavaCity
2. Rad sa fajlovima + komandna linija (-src, -dest, -unique, -limit)
3. StekRed **08.09.2021.**
</details>

<details>
  <summary>05.09.2019.</summary>

1. JavaFabrika
2. Generici Baza artikala prodavnice + CSV
3. JavaBank Stream API + Simulacija
</details>

<details>
  <summary>04.07.2019. **</summary>

1. Java vodeni svijet
2. Java kompanija pozivnice Rad sa fajlovima
3. Generici Predicate hashCode **25.08.2021.**
</details>

<details>
  <summary>18.04.2019.</summary>

1. Java takmičenje prepreke, bonusi, voda, vatra, stijena
2. FileWatcher binarne datoteke Rad sa fajlovima
3. Takmičenje niti Xnit, Ynit, Znit
</details>

<details>
  <summary>14.02.2019.</summary>

1. Narudžbenica i Faktura
2. Generici, Stream API, Predicate
3. Rad sa fajlovima ispis brojeva (10)
</details>

---

<details>
  <summary>05.10.2018</summary>

1. Simulacija Kino dvorane
2. ConsoleTable \*\*\*
3. Rad sa fajlovima
</details>

<details>
  <summary>20.09.2018</summary>

1. Java firma varioci, vozači, bravari
2. Queue AddThread, RemoveThread
3. Minsko polje simulacija
</details>

<details>
  <summary>06.09.2018 ✅</summary>

1. Sipanje goriva na benzinskoj pumpi
2. Rad sa fajl sistemom
3. Java NIO + Stream API
</details>

<details>
  <summary>19.04.2018</summary>

1. Simulacija voda, vatra, stijena
2. Obrada sadržaja tekstualnih fajlova na različite načine (loader, processor, exporter) \*\*
3. Stream API
</details>

<details>
  <summary>15.02.2018</summary>

1. Simulacija sakupljanje zlatnika robot, planinar, atletičar, skijaš
2. Modifikacija konfiguracioni fajl
3. Generička metoda \*\*
</details>

<details>
  <summary>01.02.2018</summary>

1. Java hidrocentrala
2. [Ponovljeno] broj klasa, paketa **26.01.2022**
3. FileWatcher
</details>

---

<details>
  <summary>27.09.2017</summary>

1. Fabrika, trake, mašine
2. Proširenje prethodnog zadatka, Narudžbe, algoritam za raspoređivanje
3. Stream API
</details>

<details>
  <summary>07.09.2017</summary>

1. Upravljanje fajlova u folderima
2. Proširenje
3. Proširenje
</details>

<details>
  <summary>24.08.2017 **</summary>

1. **08.09.2021.**
2. Processor
3. Exporter
</details>

<details>
  <summary>29.06.2017</summary>

1. Takmičenje na mapi prepeke + bonusi
2. CSV analiza poslovanja izmišljenog preduzeća
3. Generator Java klasa
</details>

<details>
  <summary>27.04.2017</summary>

1. Turističke atrakcije
2. Stack PusherThread PopperThread
3. Stream API Quotes CSV
</details>

<details>
  <summary>09.02.2017**</summary>

1. Grad robovil Roboti
2. Procesiranje \*\*
3. Class-creator
</details>

---

<details>
  <summary>22.10.2016</summary>

1. Mitološka bića
2. Ppogađanje riječi
3. Fajlovi sa riječima istog početnog slova
</details>

<details>
  <summary>22.09.2016 **</summary>

1. Takmičenje prepreke i bonusi
2. Kopiranje fajlova, foldera
3. XML, JSON -> Java klase
</details>

<details>
  <summary>08.09.2016 **</summary>

1. Muzički zapisi
2. HTML Parser \*\*
3. Rad sa fajlovima
</details>

<details>
  <summary>30.06.2016 **</summary>

1. Ambulanta
2. LIMUNADA Pogađanje riječi
3. Rad sa fajlovima razvrstavanje
</details>

<details>
  <summary>16.06.2016 ***</summary>

1. Evropsko prvenstvo u fudbalu
2. Proširenje
3. Fajlovi
</details>
