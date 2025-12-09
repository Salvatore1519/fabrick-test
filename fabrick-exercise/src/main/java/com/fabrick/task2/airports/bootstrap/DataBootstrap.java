
package com.fabrick.task2.airports.bootstrap;

import com.fabrick.task2.airports.dto.AirportDto;
import com.fabrick.task2.airports.dto.StationDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;


import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bootstrap in-memory dei dati: carica due mappe (airports, stations).
 */
@Component
public class DataBootstrap {

    private final Map<String, AirportDto> airports = new ConcurrentHashMap<>();
    private final Map<String, StationDto> stations = new ConcurrentHashMap<>();

    private final Sinks.Many<AirportDto> airportSink = Sinks.many().replay().all();
    private final Sinks.Many<StationDto> stationSink = Sinks.many().replay().all();

    @PostConstruct
    public void init() {
        AirportDto den = new AirportDto("KDEN","DENVER/DENVER_INTL","CO","US",39.8617,-104.6732,1656.6);
        AirportDto aff = new AirportDto("KAFF","Air Force Academy Arfld","CO","US",38.971,-104.816,2003);
        AirportDto milano=  new AirportDto("MIL","MILANO MALPENSA AIRPORT","MI","IT",38.971,-104.816,2003);
        airports.put(den.getId(), den);
        airports.put(aff.getId(), aff);
        airportSink.tryEmitNext(den);
        airportSink.tryEmitNext(aff);

        StationDto s1 = new StationDto("KAFF","Air Force Academy Arfld","CO","US",38.971,-104.816,2003);
        StationDto s2 = new StationDto("KDEN","DENVER/DENVER_INTL","CO","US",39.8617,-104.6732,1656.6);
        stations.put(s1.getId(), s1);
        stations.put(s2.getId(), s2);
        stationSink.tryEmitNext(s1);
        stationSink.tryEmitNext(s2);
    }

    public Collection<AirportDto> allAirports() { return airports.values(); }
    public Collection<StationDto> allStations() { return stations.values(); }

    public Optional<AirportDto> getAirport(String id) { return Optional.ofNullable(airports.get(id)); }
    public Optional<StationDto> getStation(String id) { return Optional.ofNullable(stations.get(id)); }
}
