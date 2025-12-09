
package com.fabrick.task2.airports.controller;

import com.fabrick.task2.airports.dto.AirportDto;
import com.fabrick.task2.airports.service.AirportsStationsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * Controller per endpoint /stations/{id}/airports
 */
@RestController
@RequestMapping("/api/fabrick/v1.0/stations")
public class StationController {

    private final AirportsStationsService service;

    public StationController(AirportsStationsService service) {
        this.service = service;
    }

    @GetMapping(value = "{stationId}/airports", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<AirportDto> getAirports(@PathVariable String stationId, @RequestParam(required = false) Double closestBy) {
        double cb = (closestBy == null) ? 0.0 : closestBy;
        return service.airportsNearStation(stationId, cb);
    }
}
