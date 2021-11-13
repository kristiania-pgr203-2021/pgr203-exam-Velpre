
[![Java CI with Maven](https://github.com/kristiania-pgr203-2021/pgr203-exam-Velpre/actions/workflows/maven.yml/badge.svg)](https://github.com/kristiania-pgr203-2021/pgr203-exam-Velpre/actions/workflows/maven.yml)
## Hvordan kjøre dette programmet
* Legg til databaseinfo i en pgr203.properties fil som skal ligge i root directory
* Bygg prosjektet ved å kjøre kommandoen: mvn package
* Start SurveyServer ved å kjøre kommandoen: java -jar target\exam-1.0-SNAPSHOT.jar
* Programme kan også kjøres direkte i main methoden som ligger i SurveyServer klassen

## Ekstra utover minimum
#### Liste svar
User tabellen og survey tabellen er knyttet sammen med questions tabellen. På /showAnswers.html har vi mulighet for å liste svarene i forhold til forskjellige spørreundersøkelser og users som har besvart de.Det er også mulighet for å liste alle svarene fra alle users på valgt spørreundersøkelse.
#### Legge til spørsmål
Ved opprettelse av nye spørsmål er det mulig å velge om spørsmålet skal besvares med options(radio buttons) eller slider.
#### Annet
* Terminerer while loop med beak i readLine methoden for å fikse java heap feilmeldingen
* Mulighet for å legge til og slette eksisterende spørreundersøkelser
* Mulighet for å legge til eller velge eksisterende users når brukeren besvarer spørreundersøkelse
* Mulighet for å oppdatere eksisterende spørsmål

## Database struktur
<img width="1011" alt="DB java" src="https://user-images.githubusercontent.com/65472724/141207340-974c2d00-ac59-4f47-8cb0-d3983e0d43fe.PNG">

## Server struktur
![image](https://user-images.githubusercontent.com/65472724/141470757-f4af41ca-7dc3-408b-ba19-3bd763712a07.png)
Viser hva som skjer på serveren når brukeren lister alle spørsmål
![image](https://user-images.githubusercontent.com/65472724/141493105-3ad37167-7fc0-4971-883b-87a1611cffd9.png)

[![Java CI with Maven](https://github.com/kristiania-pgr203-2021/pgr203-exam-Velpre/actions/workflows/maven.yml/badge.svg)](https://github.com/kristiania-pgr203-2021/pgr203-exam-Velpre/actions/workflows/maven.yml)

## Sjekkliste

## Vedlegg: Sjekkliste for innlevering

* [x] Dere har lest eksamensteksten
* [ ] Dere har lastet opp en ZIP-fil med navn basert på navnet på deres Github repository
* [x] Koden er sjekket inn på github.com/pgr203-2021-repository
* [x] Dere har committed kode med begge prosjektdeltagernes GitHub konto (alternativt: README beskriver arbeidsform)

### README.md

* [x] `README.md` inneholder en korrekt link til Github Actions
* [x] `README.md` beskriver prosjektets funksjonalitet, hvordan man bygger det og hvordan man kjører det
* [x] `README.md` beskriver eventuell ekstra leveranse utover minimum
* [x] `README.md` inneholder et diagram som viser datamodellen

### Koden

* [x] `mvn package` bygger en executable jar-fil
* [x] Koden inneholder et godt sett med tester
* [x] `java -jar target/...jar` (etter `mvn package`) lar bruker legge til og liste ut data fra databasen via
  webgrensesnitt
* [x] Serveren leser HTML-filer fra JAR-filen slik at den ikke er avhengig av å kjøre i samme directory som kildekoden
* [x] Programmet leser `dataSource.url`, `dataSource.username` og `dataSource.password` fra `pgr203.properties` for å
  connecte til databasen
* [x] Programmet bruker Flywaydb for å sette opp databaseskjema
* [ ] Server skriver nyttige loggmeldinger, inkludert informasjon om hvilken URL den kjører på ved oppstart

### Funksjonalitet

* [x] Programmet kan opprette spørsmål og lagrer disse i databasen (påkrevd for bestått)
* [x] Programmet kan vise spørsmål (påkrevd for D)
* [x] Programmet kan legge til alternativ for spørsmål (påkrevd for D)
* [x] Programmet kan registrere svar på spørsmål (påkrevd for C)
* [x] Programmet kan endre tittel og tekst på et spørsmål (påkrevd for B)

### Ekstraspørsmål (dere må løse mange/noen av disse for å oppnå A/B)

* [ ] Før en bruker svarer på et spørsmål hadde det vært fint å la brukeren registrere navnet sitt. Klarer dere å implementere dette med cookies? Lag en form med en POST request der serveren sender tilbake Set-Cookie headeren. Browseren vil sende en Cookie header tilbake i alle requester. Bruk denne til å legge inn navnet på brukerens svar
* [x] Når brukeren utfører en POST hadde det vært fint å sende brukeren tilbake til dit de var før. Det krever at man svarer med response code 303 See other og headeren Location
* [x] Når brukeren skriver inn en tekst på norsk må man passe på å få encoding riktig. Klarer dere å lage en <form> med action=POST og encoding=UTF-8 som fungerer med norske tegn? Klarer dere å få æøå til å fungere i tester som gjør både POST og GET?
* [x] Å opprette og liste spørsmål hadde vært logisk og REST-fult å gjøre med GET /api/questions og POST /api/questions. Klarer dere å endre måten dere hånderer controllers på slik at en GET og en POST request kan ha samme request target?
* [x] Vi har sett på hvordan å bruke AbstractDao for å få felles kode for retrieve og list. Kan dere bruke felles kode i AbstractDao for å unngå duplisering av inserts og updates?
* [ ] Dersom noe alvorlig galt skjer vil serveren krasje. Serveren burde i stedet logge dette og returnere en status code 500 til brukeren
* [x] Dersom brukeren går til http://localhost:8080 får man 404. Serveren burde i stedet returnere innholdet av index.html
* [ ] Et favorittikon er et lite ikon som nettleseren viser i tab-vinduer for en webapplikasjon. Kan dere lage et favorittikon for deres server? Tips: ikonet er en binærfil og ikke en tekst og det går derfor ikke an å laste den inn i en StringBuilder
* [ ] I forelesningen har vi sett på å innføre begrepet Controllers for å organisere logikken i serveren. Unntaket fra det som håndteres med controllers er håndtering av filer på disk. Kan dere skrive om HttpServer til å bruke en FileController for å lese filer fra disk?
* [x] Kan dere lage noen diagrammer som illustrerer hvordan programmet deres virker?
* [x] JDBC koden fra forelesningen har en feil ved retrieve dersom id ikke finnes. Kan dere rette denne?
* [x] I forelesningen fikk vi en rar feil med CSS når vi hadde `<!DOCTYPE html>`. Grunnen til det er feil content-type. Klarer dere å fikse det slik at det fungerer å ha `<!DOCTYPE html>` på starten av alle HTML-filer?
* [ ] Klarer dere å lage en Coverage-rapport med GitHub Actions med Coveralls? (Advarsel: Foreleser har nylig opplevd feil med Coveralls så det er ikke sikkert dere får det til å virke)
* [x] FARLIG: I løpet av kurset har HttpServer og tester fått funksjonalitet som ikke lenger er nødvendig. Klarer dere å fjerne alt som er overflødig nå uten å også fjerne kode som fortsatt har verdi? (Advarsel: Denne kan trekke ned dersom dere gjør det feil!)

### Ekstraspørsmål fra eksamens dokumentet
* [x] Avansert datamodell (mer enn 3 tabeller)
* [x] Avansert funksjonalitet (skala på spørsmål, spørreundersøkelser)
* [x] Rammeverk rundt Http-håndtering (en god HttpMessage class med HttpRequest og HttpResponse subtyper) som gjenspeiler RFC7230
* [ ] Implementasjon av Chunked Transfer Encoding: https://tools.ietf.org/html/rfc7230#section-4.1
* [ ] Annet 
 
