# Opdracht 1

We willen een random permutatie genereren van de eerste N integers. Dergelijke permutaties
zijn vaak handig in simulaties. Zo zijn bijvoorbeeld **[5,2,3,0,4,1]** en **[2,1,4,5,3,0]** legale
permutaties (voor N=6), maar **[1,0,2,4,2,5]** niet want deze bevat tweemaal een 2 en geen 3.
Voor het creëren van een random permutatie van de getallen 0,...,N-1 hebben we de volgende
drie algoritmen:

## 1. 

**Algoritme 1 met N= 5.000, 10.000, 20.000, 50.000, 100.000, 200.000**

Vul een voor een de elementen **a[0]** tot **a[N-1]** van de array **a**. Om element **a[i]** te
vullen, genereer je net zo lang een random getal totdat er een is gevonden die niet
gelijk is aan **a[0]** t/m **a[i-1]**.

## 2.

**Algoritme 2 met N= 100.000, 200.000, 500.000, 1.000.000, 5.000.000, 10.000.000**
 
Analoog aan algoritme 1, maar hou nu een extra array used bij. Wanneer een random
getal **r** in array **a** wordt gezet, zet dan ook **used[r]** op true. Bij het vullen van **a[i]**
kunnen we nu dus direct zien of het gegenereerde random getal al gebruikt is of niet
(i.p.v. alle plaatsen **a[0]** t/m **a[i-1]** langs te lopen).

## 3.

**Algoritme 3 met N= 2.000.000, 5.000.000, 10.000.000, 20.000.000, 50.000.000, 100.000.000**

Voer voor elke waarde van **i** tussen **0** en **N-1** de volgende stappen uit: zet op positie **i**
in het array een **i**, dus **a[i]** = **i**. Verwissel vervolgens meteen de inhoud van **a[i]** met
een willekeurige reeds gevulde positie in de array, dus **swap(a[i], a[random getaltussen 0 en i])**.

## Documentatie

Leg in je documentatie uit of elk algoritme legale permutaties oplevert en of de kans op elke
permutatie even groot is. Geef een zo goed mogelijke Big-Oh schatting van de verwachte
running time van elk algoritme en leg uit hoe je daaraan komt. Schrijf afzonderlijke programma’s
om elk algoritme 10 keer uit te voeren voor elk van de volgende waarden van N, en meet de
gemiddelde running time in elk van de volgende situaties:

Presenteer in je verslag je metingen in een grafiek en geef daarbij een kritische vergelijking
van je metingen met de verwachte running times.

# Opdracht 2

# Opdracht 3