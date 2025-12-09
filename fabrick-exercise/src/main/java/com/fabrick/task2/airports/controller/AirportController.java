
package com.fabrick.task2.airports.controller;

import com.fabrick.task2.airports.dto.StationDto;
import com.fabrick.task2.airports.service.AirportsStationsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * Controller per endpoint /airports/{id}/stations
 */
@RestController
@RequestMapping("/api/fabrick/v1.0/airports")
public class AirportController {

    private final AirportsStationsService service;

    public AirportController(AirportsStationsService service) {
        this.service = service;
    }

    @GetMapping(value = "{airportId}/stations", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<StationDto> getStations(@PathVariable String airportId, @RequestParam(required = false) Double closestBy) {
        double cb = (closestBy == null) ? 0.0 : closestBy;
        return service.stationsNearAirport(airportId, cb);
    }
}
