
package com.fabrick.task1.asteroids.client;

import com.fabrick.task1.asteroids.dto.NasaNeoLookupResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Client per chiamare il Neo - Lookup API di NASA (Non-bloccante tramite WebClient).
 */
@Component
public class NasaNeoWsClient {

    private final WebClient webClient;
    private final String apiKey;

    public NasaNeoWsClient(@Qualifier("nasaWebClient") WebClient webClient,
                           @Value("${nasa.api-key:DEMO_KEY}") String apiKey) {
        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    public Mono<NasaNeoLookupResponse> lookupNeo(String asteroidId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/neo/{id}").queryParam("api_key", apiKey).build(asteroidId))
                .retrieve()
                .bodyToMono(NasaNeoLookupResponse.class);
    }
}
