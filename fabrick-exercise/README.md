
Fabrick Exercise - Spring Boot WebFlux (Java 21)
===============================================

Contenuto:
- Task 1: Asteroids path (usa NASA NeoWs lookup)
- Task 2: Airports & Stations (in-memory bootstrap)

Come eseguire:
1. Importa il progetto in IntelliJ/Eclipse come Maven project.
2. Configura `application.properties` (opzionale: sostituisci nasa.api-key con la tua chiave NASA).
3. Esegui: `mvn clean package` e `java -jar target/fabrick-exercise-0.0.1-SNAPSHOT.jar` oppure esegui la classe `com.fabrick.FabrickApplication` da IDE.

Endpoint principali:
- GET /api/fabrick/v1.0/asteroids/{asteroidId}/paths?fromDate=YYYY-MM-DD&toDate=YYYY-MM-DD
- GET /api/fabrick/v1.0/airports/{airportId}/stations?closestBy=1.0
- GET /api/fabrick/v1.0/stations/{stationId}/airports?closestBy=1.0

Note:
- Implementazione non-bloccante con WebFlux/WebClient.
- Dati aeroporti/stazioni sono bootstrap in memoria per evitare dipendenze esterne.
