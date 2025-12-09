package com.fabrick.task2.airports.service;

import com.fabrick.task2.airports.dto.AirportDto;
import com.fabrick.task2.airports.dto.StationDto;
import reactor.core.publisher.Flux;

public interface AirportsStationsService{
    Flux<StationDto> stationsNearAirport(String airportId, double closestBy);

    Flux<AirportDto> airportsNearStation(String stationId, double closestBy);
}
