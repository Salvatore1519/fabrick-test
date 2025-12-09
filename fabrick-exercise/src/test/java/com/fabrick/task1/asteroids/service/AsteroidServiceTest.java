
package com.fabrick.task1.asteroids.service;

import com.fabrick.task1.asteroids.client.NasaNeoWsClient;
import com.fabrick.task1.asteroids.dto.NasaNeoLookupResponse;
import com.fabrick.task1.asteroids.dto.PathDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

public class AsteroidServiceTest {

    @Test
    void testGetPaths_basic() {
        NasaNeoWsClient mockClient = Mockito.mock(NasaNeoWsClient.class);
        var resp = new NasaNeoLookupResponse();
        var list = List.of(
                createCA("1917-04-30","Juptr"),
                createCA("1930-06-01","Earth"),
                createCA("1950-08-07","Juptr")
        );
        resp.setCloseApproachData(list);
        Mockito.when(mockClient.lookupNeo("1234")).thenReturn(Mono.just(resp));

        var svc = new com.fabrick.task1.asteroids.service.AsteroidServiceImpl(mockClient);

        StepVerifier.create(svc.getPaths("1234", "1917-01-01", "1960-01-01"))
                .expectNextCount(2)
                .verifyComplete();
    }

    private NasaNeoLookupResponse.CloseApproach createCA(String d, String body) {
        var ca = new NasaNeoLookupResponse.CloseApproach();
        ca.setCloseApproachDate(d);
        ca.setOrbitingBody(body);
        return ca;
    }
}
