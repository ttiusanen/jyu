# Issuetracker backend -sovellus #

Repositorio käsittää Jyväskylän yliopiston Ohjelmointityö-kurssille tehdyn Web-palvelintoteutuksen.
Toteutuksessa on hyödynnetty Java-ohjelmointikieltä, Spring Boot -sovelluskehystä ja sen Security-arkkitehtuuria. 
Toteutus sisältää testit julkaistuille rajapinnoille.

## Suoritusympäristön vaatimukset ##

Sovelluksen ajaminen lokaalisti vaatii
* Maven (versio 3.6.x)
* JDK 8 tai uudempi.

## Sovelluksen ajaminen lokaalisti ##

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
