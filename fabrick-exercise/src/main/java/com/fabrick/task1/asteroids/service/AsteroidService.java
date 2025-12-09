package com.fabrick.task1.asteroids.service;

import com.fabrick.task1.asteroids.dto.PathDto;
import reactor.core.publisher.Flux;

public interface AsteroidService {
    Flux<PathDto> getPaths(String asteroidId, String fromDate, String toDate);
}
