
package com.fabrick.task1.asteroids.controller;

import com.fabrick.task1.asteroids.dto.PathDto;
import com.fabrick.task1.asteroids.service.AsteroidService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Controller REST per l'endpoint /api/fabrick/v1.0/asteroids/{asteroidId}/paths
 */
@RestController
@RequestMapping("/api/fabrick/v1.0/asteroids")
public class AsteroidController {

    private final AsteroidService asteroidService;

    public AsteroidController(AsteroidService asteroidService) {
        this.asteroidService = asteroidService;
    }

    @GetMapping(value = "{asteroidId}/paths", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<PathDto> getPaths(@PathVariable String asteroidId,
                                  @RequestParam(required = false) String fromDate,
                                  @RequestParam(required = false) String toDate) {
        return asteroidService.getPaths(asteroidId, fromDate, toDate);
    }
}
