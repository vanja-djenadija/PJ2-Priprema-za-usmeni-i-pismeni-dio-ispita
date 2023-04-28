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
- Literali
  ![literali](https://user-images.githubusercontent.com/130909026/235144517-6a923b3d-ef45-43a6-974e-c5f84e78da55.png)

- Tipovi
  ![tipovi](https://user-images.githubusercontent.com/130909026/235145822-839f975a-d9f0-4053-8d3a-dc768d0225f9.png)

