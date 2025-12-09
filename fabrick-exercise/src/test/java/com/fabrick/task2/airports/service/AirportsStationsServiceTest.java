
package com.fabrick.task2.airports.service;

import com.fabrick.task2.airports.bootstrap.DataBootstrap;
import com.fabrick.task2.airports.service.impl.AirportsStationsServiceImpl;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class AirportsStationsServiceTest {

    @Test
    void testStationsNearAirport() {
        DataBootstrap bootstrap = new DataBootstrap();
        bootstrap.init();
        AirportsStationsService svc = new AirportsStationsServiceImpl(bootstrap);

        StepVerifier.create(svc.stationsNearAirport("KDEN", 0.5))
                .expectNextCount(1)
                .verifyComplete();
    }
}
