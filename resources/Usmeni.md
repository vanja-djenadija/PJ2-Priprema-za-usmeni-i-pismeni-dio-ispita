## :rotating_light: Usmeni ispit

1. **I DIO** - 35 bodova (7 x 5b) Veći zadaci (compile error ili ispis)
2. **II DIO** - 9/6b Memorija (crtanje, ispis, Exceptions)
3. **III DIO** - 6/9b Mali zadaci (compile error ili ispis)
   **Ukupno 50 bodova**

### :one: Prvi dio

#### Ostalo

- rekurzija u main metodi

[Java rules for casting](https://stackoverflow.com/questions/2233902/java-rules-for-casting)

```java
String s = new String("hello"); StringBuffer sb = (StringBuffer)s;  // Compile error : Invertible types because there is no relationship between.

Object o = new String("hello"); StringBuffer sb = (String)o;       // Compile error : Incompatible types because String is not child class of StringBuffer.

Object o = new String("hello"); StringBuffer sb = (StringBuffer)o; // Runtime Exception : ClassCastException because 'o' is string type and trying to cast into StingBuffer and there is no relationship between String and StringBuffer.
```

#### ClassCastException

```java
class A {...}
class B extends A {...}
class C extends A {...}
```

1. You can cast any of these things to Object, because all Java classes inherit from Object.
2. You can cast either B or C to A, because they're both "kinds of" A
3. You can cast a reference to an A object to B *only if* the real object is a B.
4. You can't cast a B to a C even though they're both A's.

#### TODO: Inner classes

[Java Nested and Inner Class](https://www.programiz.com/java-programming/nested-inner-class)

#### TODO: == vs equals

[What is the difference between == and equals() in Java?](https://stackoverflow.com/questions/7520432/what-is-the-difference-between-and-equals-in-java)

#### Overriding _static_ methods

[Can I override and overload static methods in Java?](https://stackoverflow.com/questions/2475259/can-i-override-and-overload-static-methods-in-java)

---

1. **Hijerarhija klasa, redoslijed pozivanja konstruktora, statičkih, nestatičkih blokova i atributa članova**

   - U izvedenim klasama **override metode** ne smiju imati **smanjen modifikator pristupa**
     protected >> friendly
   - **Privatni konstruktor** ne može biti pozvan pozivom **super()**
   - **Nema podrazumijevanog konstruktora**, a poziva se implicitno ili eksplicitno **super()**
   - **Override metoda** **ne** može baciti **više izuzetaka** nego što je definisano u osnovnoj klasi,
     a može baciti unchecked excpetions (Error, RuntimeException)
   - **StackOverflowError → ꚙ→ rekurzija (**pozivi metoda npr. errorCheck, ili u klasi A, da je podatak član A opet… **)**
   - poziv nepostojećeg konsturktora
   - this(a1), a a1 nije kreiran objekat → **NullPointerException**

   ***

   1. statički blok
   2. super()/ this()
   3. **članovi**
   4. **nestatički blok**
   5. ostatak konstruktora

   Tačke 3. i 4. se izvršavaju u redoslijedu navođenja.

---

2. **Hijerarhije klasa, interfejsi, preklapanje metoda, statičke/unutrašnje klase, anonimne klase**
   - hijerarhiju klasa, interfejsa provjeriti (abstract ako nešto nije implemenirano, ali može biti negdje drugo implicitno implementirano)
   - hashCode, equals redefinisanje
   - ispis objekata NazivKlase@hashCode
   - **TODO**: Načini kreiranja statičkih i nestatičkih ugnježdenih klasa!
   - implements AutoCloseable, close metoda, try-with-resources

---

3. **Izuzeci**

   ![Exceptions hierarchy](img/exceptions.png)

   - metoda može u **throws** bacati izuzetak koji se ne može baciti u tijelu metode
   - **Compile Error**: ako se u **try bloku** ne može nikako baciti izuzetak koji catch blok hvata
   - **Compile Error**: **nije obrađen izuzetak** na neki od 2 načina
   - **Compile Error:** **redoslijed hvatanja izuzetaka**, od većeg ka manjem**!**
   - Može se bacati unchecked exception, i navoditi u catch bloku
   - **Finally** se **uvijek izvršava**
   - **multi-catch blok** → **NE** smije se nalaziti izuzeti sa različitih nivoa u hijerarhiji
     ne može npr. IOException | Exception e
   - finally ima veću prednost od catch bloka
   - **Finally** se svakako izvršava, bez obzira da li je bačen izuzetak u try bloku

   ![Zna da ima return; u finally bloku, ako ga izbacimo → kompajlerska greška](img/return.png)

   Zna da ima return; u finally bloku, ako ga izbacimo → kompajlerska greška

   - zatvaranje resursa (koji implementiraju Closeable ili AutoCloseable interfejs) u redoslijedu obrnutom od redoslijeda navođenja u try-with-resources
   - new Random().nextDouble() → (0, 1.0) → uslov > 1.0
     možemo imati i if else, pa pišemo moguće scenarije

---

4. **Random zadatak, lambda, streamovi, ctor reference, metode reference (da li se poklapaju tipovi)**

   - **TODO**: P10 → instance ref methods
   - **Class::instanceMethod** ⇒ ima dodatni implicitni argument **this**
   - **obj::instanceMethod**
   - Lambde
   - Stream API
   - Ctor reference
   - Metoda reference
   - Da li se poklapaju tipovi
   - P10 -> instancerefmethods
   - _Primjeri sa predavanja_

---

5. **Threads, hijerarhija klasa → uglavnom nema compile error**

   - Runnable, Thread
   - join(), sleep()
   - Niz niti
   - Thread ID preko counter-a
   - **daemon** niti → okončavaju izvršavanje po završetku glavnih/worker niti
   - start() → pokreće se nit
   - run() → ne pokreće nit, već samo izvršava run metodu (ne crtamo novu nit, već na tekućoj ispisujemo rezultat run metode)
   - **\*IllegalThreadStateException →** dva puta poziv metode **start()\***
   - Redefinisana start() metoda, u kojoj nema super.start() → ne kreira se nova nit
   - `t2 = new Thread(t1)` → t2 dobija samo run metodu, ostale stvari se ne preuzimaju
     ako je t1 demonska metoda, pisaće i da je t2 demonska, iako ona to stvarno nije

---

6. **Generici →** vjerovatno nema compile error

   - raw tipovi → briše parametrizovane tipove i stavlja Object
   - **ClassCastException** → kastovanje
   - generici rade samo sa metodama iz Object klase
   - `<? extends String>` → onda se mogu koristiti i metode iz klase String

---

7. **Serijalizacija →** uglavnom se izvršava, dosta caka

   - **Serializable** je markerski interfejs, ne mora se ništa implementirati
  može
      ```java
      private void writeObject(java.io.ObjectOutputStream out) throws IOException
      private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException;
      ```
   - **`Externalizable` mora** implementirati sljedeće metode
        ```java
        public void writeExternal(ObjectOutput out) throws IOException
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        ```
   - **`Externalizable` nadjačava `Serializable`**
   - SVAKA klasa koja implementira **`Externalizable` MORA IMATI DEFAULT CTOR, jer se on prvo poziva u procesu deserijalizacije, inače `InvalidClassException`**
   - **Roditelj**, **Dijete** implementira **`Serializable`, Roditelj MORA imati default ctor → inače Runtime Exception, atributi roditelja** dobijaju default vrijednosti, a ne stvarne, u suprotnom Roditelj ne mora imati default ctor (jer se on ni ne poziva u tom slučaju)
  ![Serialization image](img/ser.png)
   - Redoslijed deserializacije je bitan
   - S: Int + Long = 4 + 8 = 12
  D: Long + Int = 8 + 4 = 12
  **OK ⇒ jer je veličina dovoljna
  NOT OK → veličine ne odgovaraju → Exception**
   - **implements** **`Serializable`,** a ima **writeExternal i readExternal** metode **→** tretiraju se kao **obične metode**
   - writeObject i readObject mogu pozivati writeExternal, readExternal
   - ako postoji hijerarhija, ide **super.readObject** pa tek onda readObject
   - **static** i **transient** promjenljive se neće serijalizovati implicitno
   - `NotSerializableException` → svi složeni atributi neke klase takođe treba da implementiraju **`Serializable`**

### :two: Drugi dio

- izračunati veličinu svih objekata na početku
- **CHAR JE 2B**
- **OutOfMemoryError**
- **ArrayIndexOutOfBounds**
- **finalize** metoda se poziva prilikom svakog poziva **System.gc()**
- **finalize** se poziva bez eksplicitnog poziva gc zbog uslova zadatka za oslobađanje memorije

### :three: Treći dio

- try-with-resources u kom je Exception → pa se poziva close() metoda
- `Enum`, poziv metode `ordinal()` počinje od 0
  **ctor** mora biti **private,** prvi put kada se koristi Enum se kreiraju svi objekti,
  sljedeći put neće
- `Stream` → može biti svašta, npr. parallel ispis → ispisati u bilo kom redoslijedu
- niti
- kolekcije
- binarni, bitski operatori `i++, i += ++i` itd. `1&2|3^4|5`

  ```java
  int i = 4;
  for(;i<=12;i+=2){
      i++;
      i-=1;
      ++i;
      i++;
      i+=1;
  }
  ```

- unutrašnja klasa

### General notes
 ![literali](https://user-images.githubusercontent.com/130909026/235144517-6a923b3d-ef45-43a6-974e-c5f84e78da55.png)
 
 ![tipovi](https://user-images.githubusercontent.com/130909026/235145822-839f975a-d9f0-4053-8d3a-dc768d0225f9.png)
 
![inic-blok](https://user-images.githubusercontent.com/130909026/235147837-db7536bc-3300-4cc0-9cd0-d8e5e27d18a3.png)

- __Compile Error__ Kompajler će kao grešku prijaviti svaki pokušaj korištenja neinicijalizovane promjenljive. (metoda, konstruktor, blok)
- __Compile Error__ 
  ```java
  int x;
  x = 3.14;
  ```
- Implicitna konverzija tipa `byte -> short -> int -> long -> float -> double `
- __Compile Error__ Nelegalan pokušaj kastovanja. *
- __ClassCastException__ Sužavanje reference. *
![brojevi](https://user-images.githubusercontent.com/130909026/235176432-32aba165-d573-4720-a8c3-b19f4912f11b.png)

![bitski-operatori](https://user-images.githubusercontent.com/130909026/235176597-e6154d0e-426f-4cf7-b8b1-218818fb5903.png)

- Kod izračunavanja izraza u kojima se nalaze vrijednosti **byte** i **short** vrši njihova promocija u **int**.
- Pomijeranje ulijevo << MNOŽENJE
- Pomijeranje udesno >> DIJELJENJE Check? Da li se na gornjim pozicijama ubacuju nule ili znak koji je prethodno bio zbog održavanja znaka?
- Short circuit && i || -> Drugi operand se neće izračunati ako se vrijednost rezultata može dobiti na osnovu prvog operanda.

![operator-precedence](https://user-images.githubusercontent.com/130909026/235178981-1cdaee69-08e1-424b-9ca8-f36d30ad6fc5.png)

- Pri deklaraciji metode može da postoji samo jedan varargs parameter koji mora biti posljednji u listi parametara metode.
- Moguće je deklarisati metodu koja ima identičan naziv nazivu konstruktora.
- Ako klasa ne specificira nijedan konstruktor, kompajler će generisati implicitni podrazumijevani konstruktor.
- Jedini zadatak implicitnog podrazumijevanog ctora je da pozove ctor roditeljske klase `super()`.
- __Compile Error__ Ukoliko postoje nepodrazumijevani konstruktori, svaki pokušaj korištenja podrazumijevanog konstruktora dovodi do greške pri kompajliranju.
- __Compile Error__ Poziv metode nad objektom, a metoda nije definisana u klasi tog objekta.
- __Compile Error__ Pristup privatnom atributu neke klase.
- Moguće je pristupiti statičkim poljima klase preko objekta te klase, ALI nije preporučljivo. `calculator.numberOfInstances()` umjesto `Calculator.numberOfInstances()`
- **Ugnježdene klase** 4.2.9 (45-46 str.)
    * Opseg vidljivosti ugnježdenih klasa je ograničen opsegom vidljivosti okružujuće klase.
    * Ugnježdena klasa može pristupiti članovima okružujuće klase, čak i privatnim.
    * Okružujuća klasa nema pristup članovima ugnježdene klase.
    * Okružujuća klasa može biti samo `public` ili `friendly`, dok ugnježdene mogu biti `public`, `friendly`, `protected` i `private`.
    * Postoje i _lokalne ugnježdene klase_, koje su deklarisane u nekom _bloku_ koda.
    * Postoje **statičke** i **nestatičke** ugnježdene klase.
    * Pristup nestatičkim članovima okružujuće klase iz statičke ugnježdene klase je moguć samo preko objekta okružujuće klase.
    * Kreiranje objekta **statičke ugnježdene klase**.
      ```java 
      Outer.StaticNestedClass obj = new Outer.StaticNestedClass();
      ```
    * Kreiranje objekta **unutrašnje (nestatičke) klase**.
      ```java 
      Outer.InnerClass obj = outerObject.new InnerClass();
      ```
  - Konstante enumeracije su implicitno `public`, `static`, `final`.
    * `enum-type [] values()`
    * `enum-type valueOf(String str)`
  - Enumeracije mogu imati konstruktore, metode i promjenljive, a mogu i implementirati interfejse (sve isto kao i bilo koja klasa).
  - Ograničenje enum : Enum ne može naslijediti drugu klasu, enum ne može biti roditeljska klasa.
  - `ordinal()` metoda Enum klase. (često na ispitu)
  - 
  
    


