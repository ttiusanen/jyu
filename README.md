# Issuetracker backend -sovellus #

Repositorio käsittää Jyväskylän yliopiston Ohjelmointityö-kurssille tehdyn Web-palvelintoteutuksen.
Toteutuksessa on hyödynnetty Java-ohjelmointikieltä, Spring Boot -sovelluskehystä ja sen Security-arkkitehtuuria. 
Toteutus sisältää testit julkaistuille rajapinnoille.

## Suoritusympäristön vaatimukset ##

Sovelluksen ajaminen lokaalisti vaatii
* Maven (versio 3.6.x)
* JDK 8 tai uudempi.

## Sovelluksen ajaminen testausympäristössä ##

1) Kloonaa tämä repositorio itsellesi ja siirry repositorion juureen.
2) Lataa tarvittaessa itsellesi Maven (versio 3.6.x)
3) Aja repositorion juuressa komennot `mvn clean` ja `mvn install`.
4) Sovellus käynnistetään komennolla `mvn spring-boot:run`.

Käynnistyksen jälkeen sovellusta voi testata esim. Postmanilla tai VSCoden RestClient -lisäominaisuudella.

## Sovelluksen testien ajaminen ##

Sovelluksen testit ajetaan repositorion juuressa komennolla `mvn test`. Komento ajaa kaikki sovellukselle määritellyt testit.

## Rajapintojen testaaminen VSCode RestClientin avulla

Kansiossa `restClient` on joitakin testikutsuja, joilla sovelluksen julkaisemia rajapintoja voi testata. Huomioitava on se, että Spring Security suojaa kaikki rajapinnat `/api/login` ja `/api/register` rajapintoja lukuunottamatta, joten testatessa suojattuja rajapintoja kutsun mukana tulee toimittaa Authorization header mallikutsun mukaisesti.

## Sovelluksen ajaminen yhtäaikaisesti frontendin kanssa ##

Backend-sovelluksen ajaminen yhtäaikaisesti frontendin kanssa ei vaadi muuta, kuin backend-sovelluksen käynnistämisen. Backend kuuntelee porttia 8080, frontendin toteuttava React-sovellus toimii portissa 3000 ja React-sovellus reitittää kutsut backendille valmiiden konfiguraatioiden mukaisesti.

## Sovelluksen tuotantoversion ajaminen

1) Luo sovelluksesta ajettava jar-tiedosto komennolla `mvn -B package` projektin juuressa.
2) Käynnistä sovellus komennolla `java -jar ./target/issuetracker-1.0-SNAPSHOT.jar`
3) Luo itsellesi testikäyttäjä seuraavalla komennolla

```
curl -H "Content-Type: application/json" \
  -X POST \
  --data '{"username":"testuser","password":"testpasswd", "email":"testuser@domain.com"}' \
  http://localhost:8080/api/register
```
  
Käyttäjän luomiseksi voi käyttää myös restClient-kansiossa olevia kutsuja.

4) Käytä edellisessä komennossa olevaa käyttäjätunnusta ja salasanaa kirjautuaksesi käyttöliittymään.


