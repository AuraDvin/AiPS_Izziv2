## TODO:
- [x] Stack stuff
- [ ] Deque stuff
- [ ] Sequence stuff
- [ ] fix size (actually count elements in the array)
- [ ] fix toString (use front and back indexes)
- [ ] fix get method (logical to physical index)
- [ ] Remove all warnings 


# Navodila

Pri tem izzivu se boste pozabavali z osnovnimi podatkovnimi strukturami. S (statičnim) poljem boste implementirali 3 APT-je: 
  -  sklad, 
  -  vrsto z dvema koncema in 
  -  zaporedje. 

Če se naloge lotite pametno, potem je dovolj sprogramirati le izvedbo vrste z dvema koncema.

Stack<String> torej predstavlja sklad nizov, Deque<Double> vrsto števil v plavajoči vejici itd..
Preden se lotiš programiranja, dobro poglej vmesnike: vsi trije (Stack<T>, Deque<T> in Sequence<T>) razširjajo Collection, prav tako večina metod lahko povzroči izjemo.

# Vrsta z dvema koncema

S pomočjo (krožnega) polja implementiraj razred ArrayDeque<T>, ki implementira vse tri APT-je. Njegova definicija naj bo naslednja:
```java
class ArrayDeque<T> implements Deque<T>, Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;
    // code
}
```
a) Implementiraj vse potrebne metode.

b) Metode naj v primeru težav vržejo izjemo CollectionException. V ta namen imate že definirana sporočila o napakah:

    ERR_MSG_EMPTY - kadar pride do odstanjevanja ali povpraševanja po elementu v že prazni zbirki in
    ERR_MSG_FULL - kadar pride do dodajanja elementa v že polno zbirko,
    ERR_MSG_INDEX - kadar pride do napačnega indeksa v zaporedju.

c) Vse metode, ki odstranjujejo elemente, naj preprečujejo postopanje (angl. loitering).
# Testni razred

Implementiraj testni razred Izziv2.java, ki prikaže (pravilno) izvedbo vsake operacije za vse tri APT-je.
