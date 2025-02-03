# CompetitionManager-Api

## Végpontok dokumentációja

---

Tartalom

- `Competitor`

    - Get all

    - Get

    - New

    - Update

    - Delete

- `Competition`

    - Get all

    - Get

    - New

    - Update

- `Leaderboard`

    - Get all

    - Get

    - New

    - Update

- `Test`

---

## Készítették:

- Szabó Dávid

- Szürke Levente

- Szántó Dávid

---

# Megjegyzés

**A végpontok URl-jének kezdete a szoftver telepítése után változni fog, a fejlesztési idő alatt végig a következő lesz:
**

`localhost:8080`

**Az API a fejlesztés és tesztelés ideje alatt `dummy adatokkal` szolgálja ki a klienseket.**

---

# Competitor

## Get all

Az összes adatbázisban lévő **versenyző** lekérdezése.

**URL**: /api/competitor/

**Body**: Nincs

**Használat**: `Admin` `Frontend`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `Az összes rögzített versenyző egy tömbben`

---

## Get

Egy versenyző lekérdezése az adatbázisból **id** alapján.

**URL**: /api/competitor/*{id}*

**Body**: Nincs

**Használat**: `Admin` `Frontend`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `404 Not found`

  `{`

  `    "message": "Competitor with '{id}' id not found",`

  `    "status": "NOT_FOUND"`

  `}`

- `A megadott id-vel rendelkező versenyző objektum`

---

## New

Új versenyző felvétele az adatbázisba.

**URL**: /api/competitor/new

**Body**:

`{`

`    "name": "",`

`    "club": "",`

`    "birthDate": ""`

`}`

**Használat**: `Admin`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `A létrehozott versenyző objektum.`

---

## Update

Egy létező versenyző valamely adat(ainak)  módosítása.

**URL**: /api/competitor/update/*{id}*

**Body**:

`{`

`"name": "",`

`"club": "",`

`"birthDate": ""`

`}`

**Használat**: `Admin`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `404 Not found`

  `{`

  `"message": "Competitor with '{id}' id not found",`

  `"status": "NOT_FOUND"`

  `}`

- `A megadott id-vel rendelkező versenyző objektum a frissített értékekkel`

---

## Delete

Egy létező versenyző törlése az adatbázisból.

**URL**: /api/competitor/delete/*{id}*

**Body**: Nincs

**Használat**: `Admin`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `404 Not found`

  `{`

  `"message": "Competitor with '{id}' id not found",`

  `"status": "NOT_FOUND"`

  `}`

- `204 No content`

---

# Competition

## Get all

Az összes adatbázisban lévő **verseny** lekérdezése.

**URL**: /api/competition/

**Body**: Nincs

**Használat**: `Admin` `Frontend`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `Az összes rögzített verseny egy tömbben`

---

## Get

Egy verseny lekérdezése az adatbázisból **id** alapján.

**URL**: /api/competition/*{id}*

**Body**: Nincs

**Használat**: `Admin` `Frontend`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `404 Not found`

  `{`

  `"message": "Competition with '{id}' id not found",`

  `"status": "NOT_FOUND"`

  `}`

- `A megadott id-vel rendelkező verseny objektum`

---

## New

Új verseny felvétele az adatbázisba.

**URL**: /api/competition/new

**Body**:

`{`

`"name": "",`

`"location": "",`

`"date": ""`

`}`

**Használat**: `Admin`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `A létrehozott verseny objektum.`

---

## Update

Egy létező verseny valamely adat(ainak) módosítása.

**URL**: /api/competition/update/*{id}*

**Body**:

`{`

`"name": "",`

`"location": "",`

`"date": ""`

`}`

**Használat**: `Admin`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `404 Not found`

  `{`

  `"message": "Competition with '{id}' id not found",`

  `"status": "NOT_FOUND"`

  `}`

- `A megadott id-vel rendelkező verseny objektum a frissített értékekkel`

---

# Leaderboard

## Get all

Az összes adatbázisban lévő **ranglista elem** lekérdezése.

**URL**: /api/leaderboard/

**Body**: Nincs

**Használat**: `Admin` `Frontend`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `Az összes rögzített ranglista elem egy tömbben`

---

## Get

Egy ranglista elem lekérdezése az adatbázisból **id** alapján.

**URL**: /api/leaderboard/*{id}*

**Body**: Nincs

**Használat**: `Admin` `Frontend`

Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `404 Not found`

  `{`

  `"message": "Leaderboard with '{id}' id not found",`

  `"status": "NOT_FOUND"`

  `}`

- `A megadott id-vel rendelkező ranglista elem objektum`

---

## New

Új ranglista elem felvétele az adatbázisba.

**URL**: /api/leaderboard/new

**Body**:

`{`

`"competitionId": "",`

`"competitorId": "",`

`"placement": ""`

`}`

**Használat**: `Admin`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `A létrehozott ranglista elem objektum`

---

## Update

Egy létező ranglista elem valamely adat(ainak) módosítása.

**URL**: /api/leaderboard/update/*{id}*

**Body**:

`{`

`"competitionId": "",`

`"competitorId": "",`

`"placement": ""`

`}`

**Használat**: `Admin`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `404 Not found`

  `{`

  `"message": "Leaderboard with '{id}' id not found",`

  `"status": "NOT_FOUND"`

  `}`

- `A megadott id-vel rendelkező ranglista elem objektum a frissített értékekkel`

---

# Test

**Az API-val való kapcsolat tesztelése.**

**Metódus**: `GET`

**URL**: /api/test/

**Használat**: `Admin` `Frontend`

**Válasz**:

- `ECONNREFUSED` - Nem jött létre kapcsolat

- `202 Accepted`

  `{`

  `    "message": "Connection established"`

  `}`

---

@2024 2+1 team