package com.fabrick.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiDocumentation() {
        return new OpenAPI()
                .components(new Components()
                        .addParameters("closestBy", new Parameter()
                                .in("query")
                                .required(false)
                                .description("Filtro opzionale per la distanza geografica (gradi lat/lon)")
                                .schema(new StringSchema().example("0.1"))))
                .info(new Info()
                        .title("Fabrick Airport & Station API")
                        .version("v1.0")
                        .description("""
                                API reattiva per trovare:
                                - Aeroporti vicino a una stazione
                                - Stazioni vicino a un aeroporto
                                Ogni endpoint restituisce dati di test.
                                Parametri:
                                - stationId / airportId: identificativo della stazione o aeroporto
                                - closestBy: raggio opzionale (gradi lat/lon)
                                """));
    }
}
