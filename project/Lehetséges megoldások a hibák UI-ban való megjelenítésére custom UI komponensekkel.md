# Lehetséges megoldások a hibák UI-ban való megjelenítésére custom UI komponensekkel

---

## Új UIState bevezetése

#### Felvezetés

A **custom komponensek** a megadott *Appearance* példányok alapján kapják kinézetüket. Minden komponens képes a felhasználói interakcióra valamely UI-beli attribútumok megváltoztatásával:

- Háttér

- Betűszín

- Szegély

- Ikon

- Vagy ezek akármilyen kombinációja

Mindez egy az Appearance osztályban tárolt **UIState** enum egy értéke alapján történik, mely felhasználói interakciónál megkapja a megfelelő értéket. Ez a **paint()** metódusban

a **G2DPainter** osztályban kerül feldolgozásra, és a komponens ez alapján kerül "rajzolásra".

---

#### A probléma forrása

A felmerülő probléma a felülírt "rajzolási" metódusból ered, mely a swing beépített függvényeivel olykor ellent mond. Eddigi próbálkozásaink a hibák megjelenítésre leginkább a beépített swing metódusokkal történt, azon belül is a háttérszín megváltoztatása volt a cél. A probléma, hogy a komponensek hátterét teljes mértékben a custom UI modul kezeli. Ez leginkább UI-beli anomáliákban és glicthekben nyílvánul meg.

---

#### Egy lehetséges megoldás

Ugyan akkor a probléma forrásából ered egy lehetséges megoldása is: 

`A UIState enum bővítése egy "ERROR" vagy hasonló state-tel, és a "rajzolásért" felelős osztályok és metódusok átalakítása, úgy, hogy figyelembe vegyék ezt a state-et is.`

Átalakítás alatt inkább bővítést kell érteni, mivel a G2DPainter rendkívül bővíthetőre és rugalmasra lett tervezve.

---

## Konklúzió

A fentiek implementálása és tesztelése után az említett megoldás tökéletesnek bizonyúlt, így ezt a hibát megoldottnak nyílvánítjuk.
