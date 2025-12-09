
package com.fabrick.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configurazione WebClient riutilizzabile per chiamate esterne (NASA, Aviation API).
 */
@Configuration
public class WebClientConfig {

    @Value("${nasa.base-url:https://api.nasa.gov/neo/rest/v1}")
    private String nasaBaseUrl;

    @Bean(name = "nasaWebClient")
    public WebClient nasaWebClient(WebClient.Builder builder) {
        return builder.baseUrl(nasaBaseUrl).build();
    }

    @Bean
    public WebClient defaultWebClient(WebClient.Builder builder) {
        return builder.build();
    }
}
