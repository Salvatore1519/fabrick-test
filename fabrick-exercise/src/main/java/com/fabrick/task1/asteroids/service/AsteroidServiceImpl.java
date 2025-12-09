
package com.fabrick.task1.asteroids.service;

import com.fabrick.task1.asteroids.client.NasaNeoWsClient;
import com.fabrick.task1.asteroids.dto.NasaNeoLookupResponse;
import com.fabrick.task1.asteroids.dto.PathDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Servizio principale per calcolare i "paths" dell'asteroide.
 * Implementazione non-bloccante: restituisce Flux<PathDto> e usa il client WebClient.
 */
@Service
public class AsteroidServiceImpl implements  AsteroidService {

    private final NasaNeoWsClient nasaClient;
    private final DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;

    public AsteroidServiceImpl(NasaNeoWsClient nasaClient) {
        this.nasaClient = nasaClient;
    }

    @Override
    public Flux<PathDto> getPaths(String asteroidId, String fromDate, String toDate) {
        Mono<NasaNeoLookupResponse> neoMono = nasaClient.lookupNeo(asteroidId);

        return neoMono.flatMapMany(resp -> {
            List<NasaNeoLookupResponse.CloseApproach> approaches = resp.getCloseApproachData();
            if (approaches == null) return Flux.empty();

            approaches.removeIf(a -> a.getCloseApproachDate() == null);
            approaches.sort(Comparator.comparing(NasaNeoLookupResponse.CloseApproach::getCloseApproachDate));

            LocalDate from = (fromDate == null) ? LocalDate.now().minusYears(100) : LocalDate.parse(fromDate, fmt);
            LocalDate to = (toDate == null) ? LocalDate.now() : LocalDate.parse(toDate, fmt);

            List<PathDto> paths = computePaths(approaches, from, to);
            return Flux.fromIterable(paths);
        });
    }

    private List<PathDto> computePaths(List<NasaNeoLookupResponse.CloseApproach> approaches, LocalDate from, LocalDate to) {
        List<PathDto> result = new ArrayList<>();
        if (approaches.isEmpty()) return result;

        String currentPlanet = null;
        LocalDate currentFromDate = null;

        for (var app : approaches) {
            LocalDate d = LocalDate.parse(app.getCloseApproachDate(), fmt);
            if (d.isBefore(from) || d.isAfter(to)) continue;

            String planet = app.getOrbitingBody();
            if (currentPlanet == null) {
                currentPlanet = planet;
                currentFromDate = d;
            } else if (!planet.equals(currentPlanet)) {
                result.add(new PathDto(currentPlanet, planet, currentFromDate.toString(), d.toString()));
                currentPlanet = planet;
                currentFromDate = d;
            }
        }
        return result;
    }
}
