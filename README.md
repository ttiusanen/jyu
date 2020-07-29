# Issuetracker backend -sovellus #

Repositorio käsittää Jyväskylän yliopiston Ohjelmointityö-kurssille tehdyn Web-palvelintoteutuksen.
Toteutuksessa on hyödynnetty Java-ohjelmointikieltä, Spring Boot -sovelluskehystä ja sen Security-arkkitehtuuria. 
Toteutus sisältää JUNIT5-testit.

## Suoritusympäristön vaatimukset ##

Sovelluksen ajaminen lokaalisti vaatii
* Maven (versio 3.6.x)
* JDK 8 tai uudempi.

## Sovelluksen ajaminen lokaalisti ##

1) Kloonaa tämä repositorio itsellesi ja siirry repositorion juureen.
2) Lataa tarvittaessa itsellesi Maven (versio 3.6.x)
3) Aja repositorion juuressa komennot `mvn clean` ja `mvn install`.
4) Sovellus käynnistetään komennolla `mvn spring-boot:run`.

Käynnistyksen jälkeen sovellusta voi testata esim. Postmanilla tai VS Coden Rest Client -lisäominaisuudella.

## Sovelluksen testien ajaminen ##

Sovelluksen testit ajetaan repositorion juuressa komennolla `mvn test`. Komento ajaa kaikki sovellukselle määritellyt testit.

## Sovelluksen ajaminen yhtäaikaisesti frontendin kanssa ##

Backend-sovelluksen ajaminen yhtäaikaisesti frontendin kanssa ei tarvitse muita toimia, kuin backend-sovelluksen käynnistämisen.
