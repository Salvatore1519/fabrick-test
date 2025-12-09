
package com.fabrick.task2.airports.service.impl;

import com.fabrick.task2.airports.bootstrap.DataBootstrap;
import com.fabrick.task2.airports.dto.AirportDto;
import com.fabrick.task2.airports.dto.StationDto;
import com.fabrick.task2.airports.service.AirportsStationsService;
import com.fabrick.util.GeoUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;

/**
 * Servizio Per Gestione logica di businesses  per il calcolo della distanza tra stazioni metrologiche e aereoporti e viceversa
 */
@Service
public class AirportsStationsServiceImpl implements AirportsStationsService {

    private final DataBootstrap bootstrap;


    public AirportsStationsServiceImpl(DataBootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @Override
    public Flux<StationDto> stationsNearAirport(String airportId, double closestBy) {
        var opt = bootstrap.getAirport(airportId);
        if (opt.isEmpty()) return Flux.empty();

        var airport = opt.get();
        double lat = airport.getLatitude();
        double lon = airport.getLongitude();

        return Flux.fromIterable(bootstrap.allStations())
                .filter(s -> {
                    if (closestBy <= 0.0) return true;
                    return s.getLatitude() >= lat - closestBy && s.getLatitude() <= lat + closestBy
                            && s.getLongitude() >= lon - closestBy && s.getLongitude() <= lon + closestBy;
                })
                .sort(Comparator.comparingDouble(s -> GeoUtils.haversineKm(lat, lon, s.getLatitude(), s.getLongitude())));
    }
    @Override
    public Flux<AirportDto> airportsNearStation(String stationId, double closestBy) {
        var opt = bootstrap.getStation(stationId);
        if (opt.isEmpty()) return Flux.empty();

        var station = opt.get();
        double lat = station.getLatitude();
        double lon = station.getLongitude();

        return Flux.fromIterable(bootstrap.allAirports())
                .filter(a -> {
                    if (closestBy <= 0.0) return true;
                    return a.getLatitude() >= lat - closestBy && a.getLatitude() <= lat + closestBy
                            && a.getLongitude() >= lon - closestBy && a.getLongitude() <= lon + closestBy;
                })
                .sort(Comparator.comparingDouble(a -> GeoUtils.haversineKm(lat, lon, a.getLatitude(), a.getLongitude())));
    }
}
