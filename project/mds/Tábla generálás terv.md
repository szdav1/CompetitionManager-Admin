# Tábla generálás terv

---

## Felvezetés

### Probléma felvetése

A tábla versenyelem egy bináris fa oldalra fodrítva. Ennek legenerálása, feltöltése, kezelése felesleges bonyolítás lenne a sziftver specifikációjára való tekintettel (A vívók száma limitálva van 128-ra).

Ezért más megoldások kipróbálása, használata  fogja megadni az egyszerű és könnyen kezelhető tábla struktúra vizializálását.

---

## Soros listában tárolt boxok

### Használat

Ez a módszer a szoftver demójában tesztelésre került. Megjelenítés ügyileg viszonylag egyszerű, gyors megoldásnak bizonyul, azonban adat bevitelnél és validációnál bonyolult, komplex és hard-coded számításokat igényel a különböző méretű táblák kezeléséhez.

Itt minden egyes box egy önálló objektum anoniman egy listában tárolva. Ezen megoldás legfőbb hátránya az adatok validációja és általános kezelése.

### UI-béli reprezentációs hibák

Ebben a megoldásban a különböző boxok összekötése nem valósult meg, a már amúgy is rendkívüli bonyolultsága miatt.

---

## TableElement megoldás

### Mi az a table element?

A TableElement a tábla egy elemét hivatott megjeleníteni és kezelni. A két versenyző és egy győztes mező egy komponensbe vételével, majd később a többi element a két versenyző boxnál való összekötésével az adatvalidáció és a megjelenítése leegyszerűsödik. Az egyetlen dolog ami odafigyelést igényel, az a két versenyző box közötti hely az Y tengelyen.

### Miben jobb?

Az adatkezelés így leegyszerűsödik, a megjelenítése szintén, és a boxok vonallal való össze kötése is rendkívül egyszerű feladattá válik.


